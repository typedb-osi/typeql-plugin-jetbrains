package org.typedb.typeql.plugin.jetbrains

import com.intellij.testFramework.ParsingTestCase

class TypeQLParsingTest : ParsingTestCase("", "tql", TypeQLParserDefinition()) {

    fun testParsingTestData() {
        doTest(true)
    }

    override fun getTestDataPath(): String = "src/test/resources"
    override fun skipSpaces(): Boolean = false
    override fun includeRanges(): Boolean = true
}
