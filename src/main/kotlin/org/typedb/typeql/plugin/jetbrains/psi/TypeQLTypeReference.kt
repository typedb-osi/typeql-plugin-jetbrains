package org.typedb.typeql.plugin.jetbrains.psi

import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReferenceBase

class TypeQLTypeReference(element: TypeQLTypeLabel) :
    PsiReferenceBase<TypeQLTypeLabel>(element, TextRange(0, element.textLength)) {

    override fun resolve(): PsiElement? {
        val name = element.text ?: return null
        return TypeQLPsiUtil.findTypeDefinitions(element.project, name).firstOrNull()
            ?: TypeQLPsiUtil.findStructDefinitions(element.project, name).firstOrNull()
    }

    override fun getVariants(): Array<Any> = emptyArray()

    override fun handleElementRename(newName: String): PsiElement {
        val newLabel = TypeQLElementFactory.createTypeLabel(element.project, newName)
        return element.replace(newLabel)
    }
}
