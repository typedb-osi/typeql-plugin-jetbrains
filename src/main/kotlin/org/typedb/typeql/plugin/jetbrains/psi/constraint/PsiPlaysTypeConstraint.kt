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
            val superRoleIndex = text.indexOf(" as ")
            val endIndex = if (superRoleIndex == -1) "plays ".length + playsType!!.length else superRoleIndex
            return TextRange(scopeIndex, endIndex)
        }
    val playsType: String?
        get() = firstChild?.nextSibling?.nextSibling?.text

    val isAbstractType: Boolean
        get() = playsType == "abstract"

    override fun getReference(): PsiReference? {
        if (playsType == null || isAbstractType) {
            return null
        }

        val refs = ReferenceProvidersRegistry.getReferencesFromProviders(this)
        return if (refs.isNotEmpty()) refs[0] else null
    }
}
