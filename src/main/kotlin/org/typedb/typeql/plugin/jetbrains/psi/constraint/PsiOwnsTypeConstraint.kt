package org.typedb.typeql.plugin.jetbrains.psi.constraint

import com.intellij.lang.ASTNode
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReference
import com.intellij.psi.PsiWhiteSpace
import com.intellij.psi.impl.source.resolve.reference.ReferenceProvidersRegistry
import com.vaticle.typeql.grammar.TypeQLParser
import org.antlr.intellij.adaptor.psi.ANTLRPsiNode
import org.typedb.typeql.plugin.jetbrains.TypeQLParserDefinition
import org.typedb.typeql.plugin.jetbrains.psi.PsiTypeQLElement

/**
 * @author [Brandon Fergerson](mailto:bfergerson@apache.org)
 */
class PsiOwnsTypeConstraint(node: ASTNode) : PsiTypeQLElement(node) {
    val ownsTypeTextRange: TextRange
        get() = TextRange("owns".length, "owns".length + ownsType!!.length)
    val ownsType: String?
        get() {
            var typeNode: PsiElement? = lastChild
            while (typeNode != null && !TypeQLParserDefinition.checkNode(typeNode.node, TypeQLParser.RULE_type)) {
                typeNode = typeNode.prevSibling
            }
            return typeNode?.text
        }
    val isAbstractType: Boolean
        get() = ownsType == "abstract"
    val isKey: Boolean
        get() = firstChild != null && firstChild.text == "key"

    override fun getReference(): PsiReference? {
        if (ownsType == null || isAbstractType) {
            return null
        }

        val refs = ReferenceProvidersRegistry.getReferencesFromProviders(this)
        return if (refs.isNotEmpty()) refs[0] else null
    }
}