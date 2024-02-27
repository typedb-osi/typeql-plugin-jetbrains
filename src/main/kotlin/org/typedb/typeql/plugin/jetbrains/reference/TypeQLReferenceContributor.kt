/*
 * Copyright (C) 2022 Vaticle
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

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
