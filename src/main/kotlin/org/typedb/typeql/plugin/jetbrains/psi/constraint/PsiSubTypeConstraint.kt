package org.typedb.typeql.plugin.jetbrains.psi.constraint

import com.intellij.lang.ASTNode
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiReference
import com.intellij.psi.impl.source.resolve.reference.ReferenceProvidersRegistry
import org.typedb.typeql.plugin.jetbrains.psi.PsiTypeQLElement

/**
 * @author [Brandon Fergerson](mailto:bfergerson@apache.org)
 */
// sub *NAME*
class PsiSubTypeConstraint(node: ASTNode) : PsiTypeQLElement(node) {
    val subTypeTextRange: TextRange
        get() = TextRange("sub ".length, "sub ".length + subType!!.length)
    val subType: String?
        get() = lastChild?.text

    override fun getReference(): PsiReference? {
        if (subType == null) {
            return null
        }

        val refs = ReferenceProvidersRegistry.getReferencesFromProviders(this)
        return if (refs.isNotEmpty()) refs[0] else null
    }
}