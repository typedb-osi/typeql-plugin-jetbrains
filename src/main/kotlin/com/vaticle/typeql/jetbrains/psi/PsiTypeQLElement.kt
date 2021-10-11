package com.vaticle.typeql.jetbrains.psi

import com.intellij.lang.ASTNode
import com.intellij.psi.impl.source.tree.CompositeElement
import com.vaticle.typeql.jetbrains.TypeQLParserDefinition
import com.vaticle.typeql.jetbrains.psi.constraint.PsiOwnsTypeConstraint
import com.vaticle.typeql.jetbrains.psi.constraint.PsiPlaysTypeConstraint
import com.vaticle.typeql.jetbrains.psi.constraint.PsiRelatesTypeConstraint
import com.vaticle.typeql.jetbrains.psi.constraint.PsiSubTypeConstraint
import com.vaticle.typeql.jetbrains.psi.statement.PsiStatementType
import org.antlr.intellij.adaptor.psi.ANTLRPsiNode

/**
 * @author [Brandon Fergerson](mailto:bfergerson@apache.org)
 */
open class PsiTypeQLElement(node: ASTNode) : ANTLRPsiNode(node) {

    override fun getNode(): CompositeElement = super.getNode() as CompositeElement

    override fun getName(): String? {
        return when (this) {
            is PsiSubTypeConstraint -> this.subType
            is PsiPlaysTypeConstraint -> this.playsType
            is PsiOwnsTypeConstraint -> this.ownsType
            else -> super.getName()
        }
    }

    val scopedName: String?
        get() = if (this is PsiRelatesTypeConstraint) {
            val statementType = getParent() as PsiStatementType
            statementType.name + ":" + getName()
        } else {
            name
        }

    override fun toString(): String = String.format(
        "%s(%s) - Location: %s",
        javaClass.simpleName, node.elementType, textRange
    )

    override fun subtreeChanged() {
        val updatedElement = TypeQLParserDefinition.INSTANCE.createElement(super.getNode()) as PsiTypeQLElement
        TypeQLParserDefinition.updateWrappedTypeIfNecessary(super.getNode(), updatedElement)
    }
}
