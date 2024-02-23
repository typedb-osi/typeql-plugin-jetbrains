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
class PsiTypeQLOwnsType(node: ASTNode) : PsiTypeQLReferencingElement(node) {
    val ownsTypeTextRange: TextRange
        get() = TextRange(tokenTextOffset, tokenTextOffset + ownsType!!.length)

    val ownsType: String?
        get() = firstChild?.nextSibling?.nextSibling?.text

    override val tokenText = TypeQLParserDefinition.getTokenText(TypeQLParser.OWNS)

    override fun getName(): String? = this.ownsType

    override fun getReference(): PsiReference? = if (ownsType == null) null else super.getReference()
}
