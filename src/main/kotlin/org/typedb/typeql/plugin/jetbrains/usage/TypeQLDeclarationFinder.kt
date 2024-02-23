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
import com.intellij.psi.PsiManager
import com.intellij.psi.search.FileTypeIndex
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.psi.util.PsiTreeUtil
import org.typedb.typeql.plugin.jetbrains.TypeQLFileType
import org.typedb.typeql.plugin.jetbrains.psi.PsiTypeQLElement
import org.typedb.typeql.plugin.jetbrains.psi.PsiTypeQLFile
import org.typedb.typeql.plugin.jetbrains.psi.PsiTypeQLNamedElement
import org.typedb.typeql.plugin.jetbrains.psi.constraint.*
import kotlin.reflect.KClass

object TypeQLDeclarationFinder {
    fun findDeclaration(project: Project, identifier: PsiTypeQLElement): PsiTypeQLNamedElement? {
        val declarations = findDeclarations(project, identifier)
        return if (declarations.isNotEmpty()) declarations[0] else null
    }

    fun findDeclaration(
        project: Project,
        targetName: String?,
        searchScope: Collection<VirtualFile?>
    ): PsiTypeQLNamedElement? {
        val declarations = findDeclarations(project, targetName, searchScope)
        return if (declarations.isNotEmpty()) declarations[0] else null
    }

    fun findDeclarations(
        project: Project,
        identifier: PsiTypeQLElement
    ): List<PsiTypeQLNamedElement> {
        val identifierFile = identifier.node.psi.containingFile.virtualFile

        return if (ScratchUtil.isScratch(identifierFile)) {
            findDeclarations(project, identifier.scopedName, listOf(identifierFile))
        } else {
            findDeclarations(
                project, identifier.scopedName, FileTypeIndex.getFiles(
                    TypeQLFileType.INSTANCE, GlobalSearchScope.allScope(project)
                )
            )
        }
    }

    fun findDeclarations(
        project: Project,
        targetName: String?,
        searchScope: Collection<VirtualFile?>
    ): List<PsiTypeQLNamedElement> {
        if (targetName == null) {
            return emptyList()
        }

        val scopedNameDeclarations: MutableList<PsiTypeQLNamedElement> = ArrayList()
        val nameDeclarations: MutableList<PsiTypeQLNamedElement> = ArrayList()

        for (virtualFile in searchScope) {
            val typeqlFile = PsiManager.getInstance(project).findFile(virtualFile!!) as PsiTypeQLFile? ?: continue

            val namedElements = PsiTreeUtil.collectElementsOfType(typeqlFile, PsiTypeQLNamedElement::class.java)

            for (namedElement in namedElements) {
                if (targetName == namedElement.scopedName) {
                    scopedNameDeclarations.add(namedElement)
                }

                if (targetName == namedElement.name) {
                    nameDeclarations.add(namedElement)
                }
            }
        }

        return scopedNameDeclarations + nameDeclarations
    }
}
