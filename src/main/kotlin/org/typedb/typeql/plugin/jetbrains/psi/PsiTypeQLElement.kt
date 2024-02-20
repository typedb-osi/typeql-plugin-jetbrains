package org.typedb.typeql.plugin.jetbrains.psi

import com.intellij.lang.ASTNode
import com.intellij.psi.impl.source.tree.CompositeElement
import org.typedb.typeql.plugin.jetbrains.TypeQLParserDefinition
import org.typedb.typeql.plugin.jetbrains.psi.constraint.PsiOwnsTypeConstraint
import org.typedb.typeql.plugin.jetbrains.psi.constraint.PsiPlaysTypeConstraint
import org.typedb.typeql.plugin.jetbrains.psi.constraint.PsiRelatesTypeConstraint
import org.typedb.typeql.plugin.jetbrains.psi.constraint.PsiSubTypeConstraint
import org.typedb.typeql.plugin.jetbrains.psi.statement.PsiStatementType
import org.antlr.intellij.adaptor.psi.ANTLRPsiNode

/**
 * @author [Brandon Fergerson](mailto:bfergerson@apache.org)
 */
open class PsiTypeQLElement(node: ASTNode) : ANTLRPsiNode(node) {

    override fun getNode(): CompositeElement = super.getNode() as CompositeElement

    override fun getName(): String? {
        println("Somebody asks my name... $this")
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
            String.format("%s:%s", statementType.name, name)
        } else {
            name
        }

    override fun toString(): String = String.format(
        "%s(%s) - Location: %s",
        javaClass.simpleName, node.elementType, textRange
    )

    override fun subtreeChanged() {
//        val updatedElement = TypeQLParserDefinition.INSTANCE.createElement(super.getNode()) as PsiTypeQLElement
//        TypeQLParserDefinition.updateWrappedTypeIfNecessary(super.getNode(), updatedElement)
    }
}
