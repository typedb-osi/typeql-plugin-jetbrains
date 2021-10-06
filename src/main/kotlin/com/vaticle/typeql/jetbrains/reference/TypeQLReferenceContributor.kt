package com.vaticle.typeql.jetbrains.reference

import com.intellij.openapi.util.TextRange
import com.intellij.patterns.PlatformPatterns
import com.intellij.psi.*
import com.intellij.util.ProcessingContext
import com.vaticle.typeql.jetbrains.psi.constraint.PsiOwnsTypeConstraint
import com.vaticle.typeql.jetbrains.psi.constraint.PsiPlaysTypeConstraint
import com.vaticle.typeql.jetbrains.psi.constraint.PsiRelatesSuperRoleTypeConstraint
import com.vaticle.typeql.jetbrains.psi.constraint.PsiSubTypeConstraint

/**
 * @author [Brandon Fergerson](mailto:bfergerson@apache.org)
 */
class TypeQLReferenceContributor : PsiReferenceContributor() {
    override fun registerReferenceProviders(registrar: PsiReferenceRegistrar) {
        registrar.registerReferenceProvider(
            PlatformPatterns.psiElement(PsiOwnsTypeConstraint::class.java),
            object : PsiReferenceProvider() {
                override fun getReferencesByElement(
                    element: PsiElement,
                    context: ProcessingContext
                ): Array<PsiReference> {
                    val ownsElement = element as PsiOwnsTypeConstraint
                    return arrayOf(
                        TypeQLReference(ownsElement, ownsElement.ownsTypeTextRange)
                    )
                }
            })
        registrar.registerReferenceProvider(
            PlatformPatterns.psiElement(PsiPlaysTypeConstraint::class.java),
            object : PsiReferenceProvider() {
                override fun getReferencesByElement(
                    element: PsiElement,
                    context: ProcessingContext
                ): Array<PsiReference> {
                    val playsElement = element as PsiPlaysTypeConstraint
                    return arrayOf(
                        TypeQLReference(playsElement, playsElement.playsTypeTextRange)
                    )
                }
            })
        registrar.registerReferenceProvider(PlatformPatterns.psiElement(
            PsiRelatesSuperRoleTypeConstraint::class.java
        ), object : PsiReferenceProvider() {
            override fun getReferencesByElement(
                element: PsiElement,
                context: ProcessingContext
            ): Array<PsiReference> {
                val relatesSuperRoleElement = element as PsiRelatesSuperRoleTypeConstraint
                return arrayOf(
                    TypeQLReference(
                        relatesSuperRoleElement,
                        TextRange(0, relatesSuperRoleElement.text.length)
                    )
                )
            }
        })
        registrar.registerReferenceProvider(
            PlatformPatterns.psiElement(PsiSubTypeConstraint::class.java),
            object : PsiReferenceProvider() {
                override fun getReferencesByElement(
                    element: PsiElement,
                    context: ProcessingContext
                ): Array<PsiReference> {
                    val subTypeElement = element as PsiSubTypeConstraint
                    return arrayOf(
                        TypeQLReference(subTypeElement, subTypeElement.subTypeTextRange)
                    )
                }
            })
    }
}