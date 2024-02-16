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

package org.typedb.typeql.plugin.jetbrains.test.parsing

import com.intellij.testFramework.ParsingTestCase
import org.typedb.typeql.plugin.jetbrains.TypeQLFileType
import org.typedb.typeql.plugin.jetbrains.TypeQLParserDefinition

open abstract class TypeQLParsingTestBase() : ParsingTestCase("", TypeQLFileType.EXTENSION, TypeQLParserDefinition()) {

    fun testParsingTestData() {
        doTest(true)
    }

    override fun getTestDataPath(): String = "src/test/resources/parsing/${getTestDataSubdir()}"
    override fun skipSpaces(): Boolean = false
    override fun includeRanges(): Boolean = true
    abstract fun getTestDataSubdir(): String
}
