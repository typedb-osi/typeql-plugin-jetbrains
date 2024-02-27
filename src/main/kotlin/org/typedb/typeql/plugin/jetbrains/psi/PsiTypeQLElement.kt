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
import com.intellij.psi.impl.source.tree.CompositeElement
import org.antlr.intellij.adaptor.psi.ANTLRPsiNode
import org.typedb.typeql.plugin.jetbrains.TypeQLParserDefinition

/**
 * @author [Brandon Fergerson](mailto:bfergerson@apache.org)
 */
open class PsiTypeQLElement(node: ASTNode) : ANTLRPsiNode(node) {
    open val labelNode: ASTNode?
        get() = node

    open val scopedName: String?
        get() = name

    open val tokenText = ""

    protected val tokenTextOffset
        get() = tokenText.length - 1 // Minus 2 quotes, plus 1 space

    override fun getNode(): CompositeElement = super.getNode() as CompositeElement

    override fun toString(): String = String.format(
        "%s(%s) - Location: %s",
        javaClass.simpleName, node.elementType, textRange
    )

    override fun subtreeChanged() {
        val updatedElement = TypeQLParserDefinition.INSTANCE.createElement(super.getNode())
        TypeQLParserDefinition.updateWrappedTypeIfNecessary(super.getNode(), updatedElement)
    }
}
