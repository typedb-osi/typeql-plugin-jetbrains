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

import com.intellij.lang.cacheBuilder.DefaultWordsScanner
import com.intellij.lang.cacheBuilder.WordsScanner
import com.intellij.lang.findUsages.FindUsagesProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.tree.TokenSet
import com.vaticle.typeql.grammar.TypeQLLexer
import org.antlr.intellij.adaptor.lexer.ANTLRLexerAdaptor
import org.typedb.typeql.plugin.jetbrains.TypeQLFileType
import org.typedb.typeql.plugin.jetbrains.TypeQLLanguage
import org.typedb.typeql.plugin.jetbrains.TypeQLTokenSets
import org.typedb.typeql.plugin.jetbrains.psi.PsiTypeQLElement

/**
 * @author [Brandon Fergerson](mailto:bfergerson@apache.org)
 */
class TypeQLFindUsagesProvider : FindUsagesProvider {
    override fun getWordsScanner(): WordsScanner? {
        return DefaultWordsScanner(
            ANTLRLexerAdaptor(TypeQLLanguage.INSTANCE, TypeQLLexer(null)),
            TypeQLTokenSets.IDENTIFIERS,
            TypeQLTokenSets.COMMENTS,
            TokenSet.EMPTY
        )
    }

    override fun canFindUsagesFor(element: PsiElement): Boolean {
        return element is PsiTypeQLElement
    }

    override fun getHelpId(psiElement: PsiElement): String? {
        return null
    }

    override fun getType(element: PsiElement): String {
        return if (element is PsiTypeQLElement) "${TypeQLFileType.LANG_NAME} element" else ""
    }

    override fun getDescriptiveName(element: PsiElement): String {
        return if (element is PsiTypeQLElement) element.scopedName!! else ""
    }

    override fun getNodeText(element: PsiElement, useFullName: Boolean): String {
        return if (element is PsiTypeQLElement) element.name!! else ""
    }
}
