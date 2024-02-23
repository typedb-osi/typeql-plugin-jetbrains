package org.typedb.typeql.plugin.jetbrains.psi.constraint

import com.intellij.lang.ASTNode
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiReference
import com.intellij.psi.impl.source.resolve.reference.ReferenceProvidersRegistry
import com.vaticle.typeql.grammar.TypeQLParser
import org.typedb.typeql.plugin.jetbrains.TypeQLParserDefinition
import org.typedb.typeql.plugin.jetbrains.psi.PsiTypeQLReferencingElement

/**
 * @author [Brandon Fergerson](mailto:bfergerson@apache.org)
 */
class PsiTypeQLPlaysType(node: ASTNode) : PsiTypeQLReferencingElement(node) {
    override val labelNode: ASTNode?
        get() = node.firstChildNode?.treeNext?.treeNext

    val playsTypeTextRange: TextRange
        get() {
            val scopeIndex = text.indexOf(rolePrefix) + 1
            val superRoleIndex = text.indexOf(asTokenText)
            val endIndex = if (superRoleIndex == -1) tokenTextOffset + playsType!!.length else superRoleIndex

            return if (scopeIndex <= endIndex) TextRange(scopeIndex, endIndex) else TextRange(0, 0)
        }

    override val tokenText = TypeQLParserDefinition.getTokenText(TypeQLParser.PLAYS)
    private val asTokenText = TypeQLParserDefinition.getTokenText(TypeQLParser.AS)
    private val rolePrefix = ":"

    val playsType: String?
        get() = labelNode?.text

    val playsScope: String?
        get() {
            if (playsType == null) {
                return null
            }

            val scopeIndex = playsType!!.indexOf(rolePrefix)
            return playsType!!.substring(0, scopeIndex)
        }

    fun buildScopedName(newName: String): String {
       return playsScope + rolePrefix + newName
    }

    override fun getName(): String? = this.playsType

    override fun getReference(): PsiReference? = if (playsType == null) null else super.getReference()
}
