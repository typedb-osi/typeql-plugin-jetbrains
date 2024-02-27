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
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiNameIdentifierOwner

/**
 * @author [Brandon Fergerson](mailto:bfergerson@apache.org)
 */

/**
 * Classification between Named and Referencing elements is needed for referencing purposes
 * (which is a basis for features like "Find Usages", "Find Declaration", "Refactor", etc.).
 * Named elements are the declarations of entities which can be targets for these features.
 * This way, they create new "names" for the language.
 * @ref PsiTypeQLReferencingElement
 *
 * Examples:
 *
 * "my_new_entity" is a named element, declaring a new entity:
 * "define my_new_entity sub entity;"
 *
 * "my_newest_entity" is a named element, declaring a new entity,
 * "my_new_entity" is a referencing element, which only relates to the original named element,
 * but does not create a new name:
 * "define my_newest_entity sub my_new_entity;"
 */
abstract class PsiTypeQLNamedElement(node: ASTNode) : PsiTypeQLElement(node), PsiNameIdentifierOwner {
    override fun getTextRange(): TextRange? = nameIdentifier?.textRange

    override fun getName(): String? = nameIdentifier?.text

    override fun getTextOffset(): Int = nameIdentifier?.textOffset ?: super.getTextOffset()

    override fun toString(): String = String.format(
        "%s(%s) - Name: %s - Location: %s",
        javaClass.simpleName, node.elementType, name, textRange
    )
}
