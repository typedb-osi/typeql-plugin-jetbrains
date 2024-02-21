package org.typedb.typeql.plugin.jetbrains.reference

import com.intellij.patterns.PlatformPatterns
import com.intellij.psi.*
import com.intellij.util.ProcessingContext
import org.typedb.typeql.plugin.jetbrains.psi.constraint.*

/**
 * @author [Brandon Fergerson](mailto:bfergerson@apache.org)
 */
class TypeQLReferenceContributor : PsiReferenceContributor() {
    override fun registerReferenceProviders(registrar: PsiReferenceRegistrar) {

        registrar.registerReferenceProvider(
            PlatformPatterns.psiElement(PsiOwnsAsSuperRoleTypeConstraint::class.java),
            object : PsiReferenceProvider() {
                override fun getReferencesByElement(
                    element: PsiElement,
                    context: ProcessingContext
                ): Array<PsiReference> {
                    val typeElement = element as PsiOwnsAsSuperRoleTypeConstraint
                    return arrayOf(
                        TypeQLReference(typeElement, typeElement.superRoleTextRange)
                    )
                }
            })

        registrar.registerReferenceProvider(
            PlatformPatterns.psiElement(PsiPlaysAsSuperRoleTypeConstraint::class.java),
            object : PsiReferenceProvider() {
                override fun getReferencesByElement(
                    element: PsiElement,
                    context: ProcessingContext
                ): Array<PsiReference> {
                    val typeElement = element as PsiPlaysAsSuperRoleTypeConstraint
                    return arrayOf(
                        TypeQLReference(typeElement, typeElement.superRoleTextRange)
                    )
                }
            })

        registrar.registerReferenceProvider(
            PlatformPatterns.psiElement(PsiRelatesAsSuperRoleTypeConstraint::class.java),
            object : PsiReferenceProvider() {
                override fun getReferencesByElement(
                    element: PsiElement,
                    context: ProcessingContext
                ): Array<PsiReference> {
                    val typeElement = element as PsiRelatesAsSuperRoleTypeConstraint
                    return arrayOf(
                        TypeQLReference(typeElement, typeElement.superRoleTextRange)
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

        // TODO: Should not be needed
//        registrar.registerReferenceProvider(
//            PlatformPatterns.psiElement(PsiOwnsTypeConstraint::class.java),
//            object : PsiReferenceProvider() {
//                override fun getReferencesByElement(
//                    element: PsiElement,
//                    context: ProcessingContext
//                ): Array<PsiReference> {
//                    val playsElement = element as PsiOwnsTypeConstraint
//                    return arrayOf(
//                        TypeQLReference(playsElement, playsElement.ownsTypeTextRange)
//                    )
//                }
//            })

        // TODO: Should not be needed
//        registrar.registerReferenceProvider(
//            PlatformPatterns.psiElement(PsiRelatesTypeConstraint::class.java),
//            object : PsiReferenceProvider() {
//                override fun getReferencesByElement(
//                    element: PsiElement,
//                    context: ProcessingContext
//                ): Array<PsiReference> {
//                    val playsElement = element as PsiRelatesTypeConstraint
//                    return arrayOf(
//                        TypeQLReference(playsElement, playsElement.textRange)
//                    )
//                }
//            })

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

        // TODO: Shoud not be needed
//        registrar.registerReferenceProvider(
//            PlatformPatterns.psiElement(PsiTypeConstraint::class.java),
//            object : PsiReferenceProvider() {
//                override fun getReferencesByElement(
//                    element: PsiElement,
//                    context: ProcessingContext
//                ): Array<PsiReference> {
//                    val typeElement = element as PsiTypeConstraint
//                    return arrayOf(
//                        TypeQLReference(typeElement, typeElement.textRange)
//                    )
//                }
//            })
    }
}
