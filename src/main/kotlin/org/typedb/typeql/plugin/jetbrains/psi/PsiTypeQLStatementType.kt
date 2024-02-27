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

/**
 * @author [Brandon Fergerson](mailto:bfergerson@apache.org)
 */
class PsiTypeQLStatementType(node: ASTNode) : PsiTypeQLElement(node) {

    override fun getName(): String? = firstChild.text

    val subType: String?
        get() = node.firstChildNode?.treeNext?.treeNext?.lastChildNode?.text

    // TODO: Uncomment and revalidate while returning the inspection package.
//    fun findRelatesTypeProperties(): List<PsiRelatesTypeConstraint> {
//        val relatesTypes: MutableList<PsiRelatesTypeConstraint> = ArrayList()
//        for (child in children) {
//            val element = TypeQLParserDefinition.getRuleTypePropertyElement(child.node)
//            if (element is PsiRelatesTypeConstraint) {
//                relatesTypes.add(element)
//            }
//        }
//        return relatesTypes
//    }
//
//    fun findPlaysTypeProperties(): List<PsiPlaysTypeConstraint> {
//        val playsTypes: MutableList<PsiPlaysTypeConstraint> = ArrayList()
//        for (child in children) {
//            val element = TypeQLParserDefinition.getRuleTypePropertyElement(child.node)
//            if (element is PsiPlaysTypeConstraint) {
//                playsTypes.add(element)
//            }
//        }
//        return playsTypes
//    }
//
//    fun findOwnsTypeProperties(): List<PsiOwnsTypeConstraint> {
//        val ownsTypes: MutableList<PsiOwnsTypeConstraint> = ArrayList()
//        for (child in children) {
//            val element = TypeQLParserDefinition.getRuleTypePropertyElement(child.node)
//            if (element is PsiOwnsTypeConstraint) {
//                ownsTypes.add(element)
//            }
//        }
//        return ownsTypes
//    }
//
//    fun findSubTypeProperties(): List<PsiSubTypeConstraint> {
//        val subTypes: MutableList<PsiSubTypeConstraint> = ArrayList()
//        for (child in children) {
//            val element = TypeQLParserDefinition.getRuleTypePropertyElement(child.node)
//            if (element is PsiSubTypeConstraint) {
//                subTypes.add(element)
//            }
//        }
//        return subTypes
//    }
//
//    fun findTypeProperties(): List<PsiTypeConstraint> {
//        val relatesTypes: MutableList<PsiTypeConstraint> = ArrayList()
//        for (child in children) {
//            val element = TypeQLParserDefinition.getRuleTypeElement(child.node)
//            if (element is PsiTypeConstraint) {
//                relatesTypes.add(element)
//            }
//        }
//        return relatesTypes
//    }
}
