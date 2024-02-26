package org.typedb.typeql.plugin.jetbrains.psi.constraint

import com.intellij.lang.ASTNode
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiReference
import com.vaticle.typeql.grammar.TypeQLParser
import org.typedb.typeql.plugin.jetbrains.TypeQLParserDefinition
import org.typedb.typeql.plugin.jetbrains.psi.PsiTypeQLReferencingElement

/**
 * @author [Brandon Fergerson](mailto:bfergerson@apache.org)
 */
class PsiTypeQLOwnsType(node: ASTNode) : PsiTypeQLReferencingElement(node) {
    override val labelNode: ASTNode?
        get() = node.firstChildNode?.treeNext?.treeNext

    val ownsTypeTextRange: TextRange
        get() = TextRange(tokenTextOffset, tokenTextOffset + ownsType!!.length)

    val ownsType: String?
        get() = labelNode?.text

    override val tokenText = TypeQLParserDefinition.getTokenText(TypeQLParser.OWNS)

    override fun getName(): String? = this.ownsType

    override fun getReference(): PsiReference? = if (ownsType == null) null else super.getReference()
}
