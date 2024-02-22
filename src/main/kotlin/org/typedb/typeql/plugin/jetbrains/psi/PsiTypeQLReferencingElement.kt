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

package org.typedb.typeql.plugin.jetbrains.psi

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiReference
import com.intellij.psi.impl.source.resolve.reference.ReferenceProvidersRegistry
import org.typedb.typeql.plugin.jetbrains.psi.constraint.PsiTypeQLOwnsType
import org.typedb.typeql.plugin.jetbrains.psi.constraint.PsiTypeQLPlaysType
import org.typedb.typeql.plugin.jetbrains.psi.constraint.PsiTypeQLRelatesType
import org.typedb.typeql.plugin.jetbrains.psi.constraint.PsiTypeQLSubType

/**
 * Classification between Named and Referencing elements is needed for referencing purposes
 * (which is a basis for features like "Find Usages", "Find Declaration", "Refactor", etc.).
 * Referencing elements do not declare new "names" for the language, but only reference already
 * existing named elements, thus being considered as a "usage" of that entity.
 * @ref PsiTypeQLNamedElement
 */
abstract class PsiTypeQLReferencingElement(node: ASTNode) : PsiTypeQLElement(node) {

    override fun getName(): String? = text

    override fun getReference(): PsiReference? {
        val refs = ReferenceProvidersRegistry.getReferencesFromProviders(this)
        return if (refs.isNotEmpty()) refs[0] else null
    }
}