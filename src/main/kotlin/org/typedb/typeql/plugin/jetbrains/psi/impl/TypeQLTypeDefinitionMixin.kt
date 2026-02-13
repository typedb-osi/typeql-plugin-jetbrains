package org.typedb.typeql.plugin.jetbrains.psi.impl

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import org.typedb.typeql.plugin.jetbrains.psi.TypeQLCompositeElementImpl
import org.typedb.typeql.plugin.jetbrains.psi.TypeQLElementFactory
import org.typedb.typeql.plugin.jetbrains.psi.TypeQLTypeDefinition

abstract class TypeQLTypeDefinitionMixin(node: ASTNode) : TypeQLCompositeElementImpl(node), TypeQLTypeDefinition {

    override fun getName(): String? = typeLabel?.text

    override fun setName(name: String): PsiElement {
        val newLabel = TypeQLElementFactory.createTypeLabel(project, name)
        typeLabel.replace(newLabel)
        return this
    }

    override fun getNameIdentifier(): PsiElement? = typeLabel?.node?.firstChildNode?.psi
}
