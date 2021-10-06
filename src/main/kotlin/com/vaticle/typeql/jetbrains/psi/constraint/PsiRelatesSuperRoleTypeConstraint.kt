package com.vaticle.typeql.jetbrains.psi.constraint

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiReference
import com.intellij.psi.impl.source.resolve.reference.ReferenceProvidersRegistry
import com.vaticle.typeql.jetbrains.psi.PsiTypeQLElement

/**
 * @author [Brandon Fergerson](mailto:bfergerson@apache.org)
 */
class PsiRelatesSuperRoleTypeConstraint(node: ASTNode) : PsiTypeQLElement(node) {
    override fun getReference(): PsiReference? {
        return ReferenceProvidersRegistry.getReferencesFromProviders(this)[0]
    }
}