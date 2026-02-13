package org.typedb.typeql.plugin.jetbrains.psi

import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReferenceBase
import com.intellij.psi.util.PsiTreeUtil

class TypeQLVariableReference(element: TypeQLVar) :
    PsiReferenceBase<TypeQLVar>(element, TextRange(0, element.textLength)) {

    override fun resolve(): PsiElement? {
        val name = element.text ?: return null
        if (name == "\$_") return null

        // Walk up to the nearest scope boundary
        val scope = PsiTreeUtil.getParentOfType(
            element,
            TypeQLPipelineQuery::class.java,
            TypeQLDefinitionFunction::class.java,
            TypeQLDefineQuery::class.java
        ) ?: element.containingFile

        // Find the first var with the same name in scope
        val allVars = PsiTreeUtil.findChildrenOfType(scope, TypeQLVar::class.java)
        val first = allVars.firstOrNull { it.text == name }
        // Resolve to the first occurrence if it's not ourselves; otherwise null (we are the definition)
        return if (first != null && first !== element) first else null
    }

    override fun getVariants(): Array<Any> = emptyArray()

    override fun handleElementRename(newName: String): PsiElement {
        val varName = if (newName.startsWith("$")) newName else "$$newName"
        val newVar = TypeQLElementFactory.createVariable(element.project, varName)
        return element.replace(newVar)
    }
}
