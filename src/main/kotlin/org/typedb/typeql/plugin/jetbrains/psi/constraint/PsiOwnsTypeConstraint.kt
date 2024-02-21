package org.typedb.typeql.plugin.jetbrains.psi.constraint

import com.intellij.lang.ASTNode
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReference
import com.intellij.psi.PsiWhiteSpace
import com.intellij.psi.impl.source.resolve.reference.ReferenceProvidersRegistry
import com.intellij.util.IncorrectOperationException
import com.vaticle.typeql.grammar.TypeQLParser
import org.antlr.intellij.adaptor.psi.ANTLRPsiNode
import org.typedb.typeql.plugin.jetbrains.TypeQLParserDefinition
import org.typedb.typeql.plugin.jetbrains.psi.PsiTypeQLElement
import org.typedb.typeql.plugin.jetbrains.psi.PsiTypeQLNamedElement
import org.typedb.typeql.plugin.jetbrains.psi.TypeQLPsiUtils

/**
 * @author [Brandon Fergerson](mailto:bfergerson@apache.org)
 */
class PsiOwnsTypeConstraint(node: ASTNode) : PsiTypeQLNamedElement(node) {
    val ownsTypeTextRange: TextRange
        get() = TextRange("owns".length, "owns".length + ownsType!!.length)
    val ownsType: String?
        get() = firstChild?.nextSibling?.text
    val isAbstractType: Boolean
        get() = ownsType == "abstract" // TODO CLeanup
    val isKey: Boolean
        get() = lastChild?.text == "key" // TODO CLeanup

//    override fun getReference(): PsiReference? {
//        if (ownsType == null || isAbstractType) {
//            return null
//        }
//
//        val refs = ReferenceProvidersRegistry.getReferencesFromProviders(this)
//        return if (refs.isNotEmpty()) refs[0] else null
//    }
    override fun getNameIdentifier(): PsiElement? {
        return node.firstChildNode?.treeNext?.treeNext?.psi
    }

    @Throws(IncorrectOperationException::class)
    override fun setName(name: String): PsiElement {
        return TypeQLPsiUtils.setName(this, name)
    }
}