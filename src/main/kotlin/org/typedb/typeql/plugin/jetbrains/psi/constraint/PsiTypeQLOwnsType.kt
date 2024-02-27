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

package org.typedb.typeql.plugin.jetbrains.psi.constraint

import com.intellij.lang.ASTNode
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiReference
import com.vaticle.typeql.grammar.TypeQLParser
import org.typedb.typeql.plugin.jetbrains.TypeQLParserDefinition
import org.typedb.typeql.plugin.jetbrains.psi.PsiTypeQLReferencingElement

/**
 * @author [Brandon Fergerson](mailto:bfergerson@apache.org)
 */
class PsiTypeQLOwnsType(node: ASTNode) : PsiTypeQLReferencingElement(node) {
    override val labelNode: ASTNode?
        get() = node.firstChildNode?.treeNext?.treeNext

    val ownsTypeTextRange: TextRange
        get() = TextRange(tokenTextOffset, tokenTextOffset + ownsType!!.length)

    val ownsType: String?
        get() = labelNode?.text

    override val tokenText = TypeQLParserDefinition.getTokenText(TypeQLParser.OWNS)

    override fun getName(): String? = this.ownsType

    override fun getReference(): PsiReference? = if (ownsType == null) null else super.getReference()
}
