package org.typedb.typeql.plugin.jetbrains.psi.constraint

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiReference
import com.intellij.psi.impl.source.resolve.reference.ReferenceProvidersRegistry
import org.typedb.typeql.plugin.jetbrains.psi.PsiTypeQLElement

/**
 * @author [Brandon Fergerson](mailto:bfergerson@apache.org)
 */
class PsiRelatesSuperRoleTypeConstraint(node: ASTNode) : PsiTypeQLElement(node) {
    override fun getReference(): PsiReference? {
        val refs = ReferenceProvidersRegistry.getReferencesFromProviders(this)
        return if (refs.isNotEmpty()) refs[0] else null
    }
}