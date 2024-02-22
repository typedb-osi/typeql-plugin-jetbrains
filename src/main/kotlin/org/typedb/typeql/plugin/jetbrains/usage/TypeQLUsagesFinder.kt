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

package org.typedb.typeql.plugin.jetbrains.usage

import com.intellij.ide.scratch.ScratchUtil
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiManager
import com.intellij.psi.search.FileTypeIndex
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.psi.util.PsiTreeUtil
import org.typedb.typeql.plugin.jetbrains.TypeQLFileType
import org.typedb.typeql.plugin.jetbrains.psi.PsiTypeQLElement
import org.typedb.typeql.plugin.jetbrains.psi.PsiTypeQLFile
import org.typedb.typeql.plugin.jetbrains.psi.constraint.*

object TypeQLUsagesFinder {
    fun findUsages(identifier: PsiTypeQLElement): List<PsiTypeQLElement> {
        val identifierFile = identifier.node.psi.containingFile.virtualFile
        return if (ScratchUtil.isScratch(identifierFile)) {
            findUsages(
                identifier.project,
                identifier,
                identifier.scopedName,
                listOf(identifierFile)
            )
        } else {
            findUsages(
                identifier.project,
                identifier,
                identifier.scopedName,
                FileTypeIndex.getFiles(
                    TypeQLFileType.INSTANCE,
                    GlobalSearchScope.allScope(identifier.project)
                )
            )
        }
    }

    fun findUsages(
        project: Project, element: PsiTypeQLElement,
        name: String?, searchScope: Collection<VirtualFile?>
    ): List<PsiTypeQLElement> {
        val result: MutableList<PsiTypeQLElement> = ArrayList()
        println("FIND USAGES FOR ELEMENT ${element.text}  WITH NAME ${name}!")
        if (name == null) {
            return result
        }
        println("FIND USAGES FOR ELEMENT ${element.text}!")
        for (virtualFile in searchScope) {
            val typeqlFile = PsiManager.getInstance(project).findFile(virtualFile!!) as PsiTypeQLFile? ?: continue

            if (element is PsiTypeQLOwnsAsOverrideType) {
                addOwnsAsSuperRoleTypeElements(result, typeqlFile, name)
                addOwnsTypeElements(result, typeqlFile, name)
                addSubTypeElements(result, typeqlFile, name)
                addTypeElements(result, typeqlFile, name) // declaration
            } else if (element is PsiTypeQLOwnsType) {
                addOwnsAsSuperRoleTypeElements(result, typeqlFile, name)
                addOwnsTypeElements(result, typeqlFile, name)
                addSubTypeElements(result, typeqlFile, name)
                addTypeElements(result, typeqlFile, name) // declaration
            } else if (element is PsiTypeQLPlaysAsOverrideType) {
                addPlaysAsSuperRoleTypeElements(result, typeqlFile, name)
                addPlaysTypeElements(result, typeqlFile, name) // declaration
                addRelatesAsSuperRoleTypeElements(result, typeqlFile, name)
                addRelatesTypeElements(result, typeqlFile, name)
            } else if (element is PsiTypeQLPlaysType) {
                addPlaysAsSuperRoleTypeElements(result, typeqlFile, name)
                addPlaysTypeElements(result, typeqlFile, name)
                addRelatesAsSuperRoleTypeElements(result, typeqlFile, name)
                addRelatesTypeElements(result, typeqlFile, name, true) // declaration
            } else if (element is PsiTypeQLRelatesOverrideType) {
                addPlaysAsSuperRoleTypeElements(result, typeqlFile, name)
                addPlaysTypeElements(result, typeqlFile, name)
                addRelatesAsSuperRoleTypeElements(result, typeqlFile, name)
                addRelatesTypeElements(result, typeqlFile, name) // declaration
            } else if (element is PsiTypeQLRelatesType) {
                addPlaysAsSuperRoleTypeElements(result, typeqlFile, name)
                addPlaysTypeElements(result, typeqlFile, name)
                addRelatesAsSuperRoleTypeElements(result, typeqlFile, name)
                addRelatesTypeElements(result, typeqlFile, name) // declaration
            } else if (element is PsiTypeQLSubType) {
                addSubTypeElements(result, typeqlFile, name)
                addTypeElements(result, typeqlFile, name) // declaration
            } else if (element is PsiTypeQLType) {
                addSubTypeElements(result, typeqlFile, name)
                addTypeElements(result, typeqlFile, name) // declaration
            } else {
                throw UnsupportedOperationException("This branch is not expected...")
                addOwnsAsSuperRoleTypeElements(result, typeqlFile, name)
                addOwnsTypeElements(result, typeqlFile, name)
                addPlaysAsSuperRoleTypeElements(result, typeqlFile, name)
                addPlaysTypeElements(result, typeqlFile, name)
                addRelatesAsSuperRoleTypeElements(result, typeqlFile, name)
                addRelatesTypeElements(result, typeqlFile, name)
                addSubTypeElements(result, typeqlFile, name)
                addTypeElements(result, typeqlFile, name)
            }
        }

        return result
    }

    fun addOwnsTypeElements(
        outResult: MutableList<PsiTypeQLElement>, rootElement: PsiElement, targetName: String? = null
    ) {
        val ownsIdentifiers = PsiTreeUtil.collectElementsOfType(
            rootElement, PsiTypeQLOwnsType::class.java
        )
        for (identifier in ownsIdentifiers)
        {
            if ((targetName ?: identifier.ownsType) == identifier.ownsType) {
                outResult.add(identifier)
            }
        }
    }

    fun addOwnsAsSuperRoleTypeElements(
        outResult: MutableList<PsiTypeQLElement>, rootElement: PsiElement, targetName: String? = null
    ) {
        val identifiers = PsiTreeUtil.collectElementsOfType(
            rootElement, PsiTypeQLOwnsAsOverrideType::class.java
        )
        for (identifier in identifiers) {
            if ((targetName ?: identifier.text) == identifier.text) {
                outResult.add(identifier)
            }
        }
    }

    fun addSubTypeElements(
        outResult: MutableList<PsiTypeQLElement>, rootElement: PsiElement, targetName: String? = null
    ) {
        val identifiers = PsiTreeUtil.collectElementsOfType(
            rootElement, PsiTypeQLSubType::class.java
        )
        for (identifier in identifiers) {
            if ((targetName ?: identifier.subType) == identifier.subType) {
                outResult.add(identifier)
            }
        }
    }

    fun addPlaysTypeElements(
        outResult: MutableList<PsiTypeQLElement>, rootElement: PsiElement, targetName: String? = null
    ) {
        val identifiers = PsiTreeUtil.collectElementsOfType(
            rootElement, PsiTypeQLPlaysType::class.java
        )
        for (identifier in identifiers) {
            if ((targetName ?: identifier.playsType) == identifier.playsType) {
                outResult.add(identifier)
            }
        }
    }

    fun addPlaysAsSuperRoleTypeElements(
        outResult: MutableList<PsiTypeQLElement>, rootElement: PsiElement, targetName: String? = null
    ) {
        val identifiers = PsiTreeUtil.collectElementsOfType(
            rootElement, PsiTypeQLPlaysAsOverrideType::class.java
        )
        for (identifier in identifiers) {
            if ((targetName ?: identifier.text) == identifier.text) {
                outResult.add(identifier)
            }
        }
    }

    fun addRelatesTypeElements(
        outResult: MutableList<PsiTypeQLElement>,
        rootElement: PsiElement,
        targetName: String? = null,
        useScopedName: Boolean = false
    ) {
        val identifiers = PsiTreeUtil.collectElementsOfType(
            rootElement, PsiTypeQLRelatesType::class.java
        )
        for (identifier in identifiers) {
            val identifierName = if (useScopedName) identifier.scopedName else identifier.name
            if ((targetName ?: identifierName) == identifierName) {
                outResult.add(identifier)
            }
        }
    }

    fun addRelatesAsSuperRoleTypeElements(
        outResult: MutableList<PsiTypeQLElement>, rootElement: PsiElement, targetName: String? = null
    ) {
        val identifiers = PsiTreeUtil.collectElementsOfType(
            rootElement, PsiTypeQLRelatesOverrideType::class.java
        )
        for (identifier in identifiers) {
            if ((targetName ?: identifier.text) == identifier.text) {
                outResult.add(identifier)
            }
        }
    }

    fun addTypeElements(
        outResult: MutableList<PsiTypeQLElement>, rootElement: PsiElement, targetName: String? = null
    ) {
        val identifiers = PsiTreeUtil.collectElementsOfType(
            rootElement, PsiTypeQLType::class.java
        )
        for (identifier in identifiers) {
            if ((targetName ?: identifier.scopedName) == identifier.scopedName) {
                outResult.add(identifier)
            }
        }
    }
}
