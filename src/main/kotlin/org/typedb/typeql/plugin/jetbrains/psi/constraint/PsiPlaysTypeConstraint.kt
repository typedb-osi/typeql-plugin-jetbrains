package org.typedb.typeql.plugin.jetbrains.psi.constraint

import com.intellij.lang.ASTNode
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiReference
import com.intellij.psi.impl.source.resolve.reference.ReferenceProvidersRegistry
import org.typedb.typeql.plugin.jetbrains.psi.PsiTypeQLElement

/**
 * @author [Brandon Fergerson](mailto:bfergerson@apache.org)
 */
class PsiPlaysTypeConstraint(node: ASTNode) : PsiTypeQLElement(node) {
    val playsTypeTextRange: TextRange
        get() {
            val scopeIndex = text.indexOf(":") + 1
            return TextRange(scopeIndex, 6 + playsType!!.length)
        }
    val playsType: String?
        get() = if (lastChild != null) {
            lastChild.text
        } else null
    val isAbstractType: Boolean
        get() = playsType == "abstract"

    override fun getReference(): PsiReference? {
        return if (playsType == null || isAbstractType) {
            null
        } else ReferenceProvidersRegistry.getReferencesFromProviders(this)[0]
    }
}