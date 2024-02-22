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

object TypeQLDeclarationFinder {
    fun findDeclaration(
        project: Project,
        name: String?,
        searchScope: Collection<VirtualFile?>
    ): PsiTypeQLNamedElement? {
        val declarations = findDeclarations(project, name, searchScope)
        return if (declarations.isNotEmpty()) declarations[0] else null
    }

    fun findDeclaration(project: Project, identifier: PsiTypeQLElement): PsiTypeQLNamedElement? {
        val declarations = findDeclarations(project, identifier)
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
        name: String?,
        searchScope: Collection<VirtualFile?>
    ): List<PsiTypeQLNamedElement> {
        if (name == null) {
            return emptyList()
        }

        val scopedNameDeclarations: MutableList<PsiTypeQLNamedElement> = ArrayList()
        val nameDeclarations: MutableList<PsiTypeQLNamedElement> = ArrayList()

        for (virtualFile in searchScope) {
            val typeqlFile = PsiManager.getInstance(project).findFile(virtualFile!!) as PsiTypeQLFile?

            if (typeqlFile != null) {
                val identifiers = PsiTreeUtil.collectElementsOfType(
                    typeqlFile, PsiTypeQLNamedElement::class.java
                )

                for (identifier in identifiers) {
                    if (name == identifier.scopedName) {
                        scopedNameDeclarations.add(identifier)
                    }

                    if (name == identifier.name) {
                        nameDeclarations.add(identifier)
                    }
                }
            }
        }

        return scopedNameDeclarations + nameDeclarations

        // TODO: Return this line when the logic is fully correct:
//        return scopedNameDeclarations.ifEmpty { nameDeclarations }
    }
}
