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

package org.typedb.typeql.plugin.jetbrains.refactor

import com.intellij.codeInsight.generation.CommenterDataHolder
import com.intellij.codeInsight.generation.SelfManagingCommenter
import com.intellij.lang.Commenter
import com.intellij.openapi.editor.Document
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiFile
import com.intellij.util.text.CharArrayUtil

/**
 * @author [Brandon Fergerson](mailto:bfergerson@apache.org)
 */
class TypeQLCommenter : Commenter, SelfManagingCommenter<CommenterDataHolder?> {
    override fun getLineCommentPrefix(): String? {
        return HASH_COMMENT_PREFIX
    }

    override fun getBlockCommentPrefix(): String? {
        return null
    }

    override fun getBlockCommentSuffix(): String? {
        return null
    }

    override fun getCommentedBlockCommentPrefix(): String? {
        return null
    }

    override fun getCommentedBlockCommentSuffix(): String? {
        return null
    }

    override fun createLineCommentingState(
        startLine: Int, endLine: Int,
        document: Document, file: PsiFile
    ): CommenterDataHolder? {
        return null
    }

    override fun createBlockCommentingState(
        selectionStart: Int, selectionEnd: Int,
        document: Document, file: PsiFile
    ): CommenterDataHolder? {
        return null
    }

    override fun commentLine(
        line: Int, offset: Int,
        document: Document, data: CommenterDataHolder
    ) {
        document.insertString(offset, HASH_COMMENT_PREFIX)
    }

    override fun uncommentLine(
        line: Int, offset: Int,
        document: Document, data: CommenterDataHolder
    ) {
        document.deleteString(offset, offset + HASH_COMMENT_PREFIX.length)
    }

    override fun isLineCommented(
        line: Int, offset: Int,
        document: Document, data: CommenterDataHolder
    ): Boolean {
        return CharArrayUtil.regionMatches(document.charsSequence, offset, HASH_COMMENT_PREFIX)
    }

    override fun getCommentPrefix(line: Int, document: Document, data: CommenterDataHolder): String? {
        return HASH_COMMENT_PREFIX
    }

    override fun getBlockCommentRange(
        selectionStart: Int, selectionEnd: Int,
        document: Document, data: CommenterDataHolder
    ): TextRange? {
        throw UnsupportedOperationException()
    }

    override fun getBlockCommentPrefix(
        selectionStart: Int, document: Document,
        data: CommenterDataHolder
    ): String? {
        return blockCommentPrefix
    }

    override fun getBlockCommentSuffix(
        selectionEnd: Int, document: Document,
        data: CommenterDataHolder
    ): String? {
        return blockCommentSuffix
    }

    override fun uncommentBlockComment(
        startOffset: Int,
        endOffset: Int,
        document: Document,
        data: CommenterDataHolder?
    ) {
        throw UnsupportedOperationException()
    }

    override fun insertBlockComment(
        startOffset: Int,
        endOffset: Int,
        document: Document,
        data: CommenterDataHolder?
    ): TextRange {
        throw UnsupportedOperationException()
    }

    companion object {
        const val HASH_COMMENT_PREFIX = "#"
    }
}
