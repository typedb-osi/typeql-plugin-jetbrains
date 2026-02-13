package org.typedb.typeql.plugin.jetbrains.psi

import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReferenceBase
import com.intellij.psi.util.PsiTreeUtil

class TypeQLFunctionReference(element: TypeQLExpressionFunctionName) :
    PsiReferenceBase<TypeQLExpressionFunctionName>(element, TextRange(0, element.textLength)) {

    override fun resolve(): PsiElement? {
        val name = element.text ?: return null

        // Fast path: search the containing file first
        val file = element.containingFile
        if (file != null) {
            val localDefs = PsiTreeUtil.findChildrenOfType(file, TypeQLDefinitionFunction::class.java)
            val match = localDefs.find { it.name == name }
            if (match != null) return match
        }

        // Slow path: search across all project files via FileTypeIndex
        return TypeQLPsiUtil.findFunctionDefinitions(element.project, name).firstOrNull()
    }

    override fun getVariants(): Array<Any> = emptyArray()

    override fun handleElementRename(newName: String): PsiElement {
        val newSig = TypeQLElementFactory.createFunctionName(element.project, newName)
        // Use firstChildNode to handle both LABEL and unreserved keyword tokens
        val newNameNode = newSig.node.firstChildNode?.psi ?: return element
        element.node.firstChildNode?.psi?.replace(newNameNode) ?: return element
        return element
    }
}
