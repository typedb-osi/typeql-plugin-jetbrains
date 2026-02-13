package org.typedb.typeql.plugin.jetbrains.psi

import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReferenceBase

class TypeQLFunctionReference(element: TypeQLExpressionFunctionName) :
    PsiReferenceBase<TypeQLExpressionFunctionName>(element, TextRange(0, element.textLength)) {

    override fun resolve(): PsiElement? {
        val name = element.text ?: return null
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
