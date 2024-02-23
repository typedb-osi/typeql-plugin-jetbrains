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
            PlatformPatterns.psiElement(PsiTypeQLOwnsAsOverrideType::class.java),
            object : PsiReferenceProvider() {
                override fun getReferencesByElement(
                    element: PsiElement,
                    context: ProcessingContext
                ): Array<PsiReference> {
                    val typeElement = element as PsiTypeQLOwnsAsOverrideType
                    return arrayOf(
                        TypeQLReference(typeElement, typeElement.superRoleTextRange)
                    )
                }
            })

        registrar.registerReferenceProvider(
            PlatformPatterns.psiElement(PsiTypeQLPlaysAsOverrideType::class.java),
            object : PsiReferenceProvider() {
                override fun getReferencesByElement(
                    element: PsiElement,
                    context: ProcessingContext
                ): Array<PsiReference> {
                    val typeElement = element as PsiTypeQLPlaysAsOverrideType
                    return arrayOf(
                        TypeQLReference(typeElement, typeElement.superRoleTextRange)
                    )
                }
            })

        registrar.registerReferenceProvider(
            PlatformPatterns.psiElement(PsiTypeQLRelatesAsOverrideType::class.java),
            object : PsiReferenceProvider() {
                override fun getReferencesByElement(
                    element: PsiElement,
                    context: ProcessingContext
                ): Array<PsiReference> {
                    val typeElement = element as PsiTypeQLRelatesAsOverrideType
                    return arrayOf(
                        TypeQLReference(typeElement, typeElement.superRoleTextRange)
                    )
                }
            })

        registrar.registerReferenceProvider(
            PlatformPatterns.psiElement(PsiTypeQLPlaysType::class.java),
            object : PsiReferenceProvider() {
                override fun getReferencesByElement(
                    element: PsiElement,
                    context: ProcessingContext
                ): Array<PsiReference> {
                    val playsElement = element as PsiTypeQLPlaysType
                    return arrayOf(
                        TypeQLReference(playsElement, playsElement.playsTypeTextRange)
                    )
                }
            })

        registrar.registerReferenceProvider(
            PlatformPatterns.psiElement(PsiTypeQLOwnsType::class.java),
            object : PsiReferenceProvider() {
                override fun getReferencesByElement(
                    element: PsiElement,
                    context: ProcessingContext
                ): Array<PsiReference> {
                    val playsElement = element as PsiTypeQLOwnsType
                    return arrayOf(
                        TypeQLReference(playsElement, playsElement.ownsTypeTextRange)
                    )
                }
            })

        registrar.registerReferenceProvider(
            PlatformPatterns.psiElement(PsiTypeQLSubType::class.java),
            object : PsiReferenceProvider() {
                override fun getReferencesByElement(
                    element: PsiElement,
                    context: ProcessingContext
                ): Array<PsiReference> {
                    val subTypeElement = element as PsiTypeQLSubType
                    return arrayOf(
                        TypeQLReference(subTypeElement, subTypeElement.subTypeTextRange)
                    )
                }
            })
    }
}
