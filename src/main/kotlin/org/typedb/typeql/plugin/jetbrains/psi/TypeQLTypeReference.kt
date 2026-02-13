package org.typedb.typeql.plugin.jetbrains.psi

import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReferenceBase
import com.intellij.psi.util.PsiTreeUtil

class TypeQLTypeReference(element: TypeQLTypeLabel) :
    PsiReferenceBase<TypeQLTypeLabel>(element, TextRange(0, element.textLength)) {

    override fun resolve(): PsiElement? {
        val name = element.text ?: return null

        // Fast path: search the containing file first (always works, no index needed)
        val file = element.containingFile
        if (file != null) {
            val localDefs = PsiTreeUtil.findChildrenOfType(file, TypeQLTypeDefinition::class.java)
            val match = localDefs.find { it.name == name }
            if (match != null) return match

            val localStructs = PsiTreeUtil.findChildrenOfType(file, TypeQLDefinitionStruct::class.java)
            val structMatch = localStructs.find { it.name == name }
            if (structMatch != null) return structMatch
        }

        // Slow path: search across all project files via FileTypeIndex
        return TypeQLPsiUtil.findTypeDefinitions(element.project, name).firstOrNull()
            ?: TypeQLPsiUtil.findStructDefinitions(element.project, name).firstOrNull()
    }

    override fun getVariants(): Array<Any> = emptyArray()

    override fun handleElementRename(newName: String): PsiElement {
        val newLabel = TypeQLElementFactory.createTypeLabel(element.project, newName)
        return element.replace(newLabel)
    }
}
