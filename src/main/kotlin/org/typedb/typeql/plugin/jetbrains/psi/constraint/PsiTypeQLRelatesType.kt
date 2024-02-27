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
import com.intellij.psi.PsiElement
import com.intellij.util.IncorrectOperationException
import com.vaticle.typeql.grammar.TypeQLParser
import org.typedb.typeql.plugin.jetbrains.TypeQLParserDefinition
import org.typedb.typeql.plugin.jetbrains.psi.PsiTypeQLElementFactory
import org.typedb.typeql.plugin.jetbrains.psi.PsiTypeQLNamedElement
import org.typedb.typeql.plugin.jetbrains.psi.PsiTypeQLStatementType

/**
 * @author [Brandon Fergerson](mailto:bfergerson@apache.org)
 */
class PsiTypeQLRelatesType(node: ASTNode) : PsiTypeQLNamedElement(node) {
    override val labelNode: ASTNode?
        get() = node.firstChildNode?.treeNext?.treeNext

    override val scopedName: String?
        get() {
            val statement = parent as PsiTypeQLStatementType
            return String.format("%s:%s", statement.name, name)
        }

    override val tokenText = TypeQLParserDefinition.getTokenText(TypeQLParser.RELATES)

    override fun getTextRange(): TextRange? {
        val fullTextRange = super.getTextRange() ?: return null
        return TextRange(fullTextRange.startOffset - tokenTextOffset, fullTextRange.endOffset)
    }

    override fun getNameIdentifier(): PsiElement? {
        return labelNode?.psi
    }

    @Throws(IncorrectOperationException::class)
    override fun setName(name: String): PsiElement {
        val typeProperty = PsiTypeQLElementFactory.createRelatesTypeProperty(project, name) ?: return this

        if (labelNode == null || typeProperty.labelNode == null) {
            throw NullPointerException("Cannot access label node for $this")
        }

        node.replaceChild(labelNode!!, typeProperty.labelNode!!)
        return this
    }
}
