package org.typedb.typeql.plugin.jetbrains

import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighter
import com.intellij.openapi.options.colors.AttributesDescriptor
import com.intellij.openapi.options.colors.ColorDescriptor
import com.intellij.openapi.options.colors.ColorSettingsPage
import javax.swing.Icon

class TypeQLColorSettingsPage : ColorSettingsPage {

    companion object {
        private val DESCRIPTORS = arrayOf(
            AttributesDescriptor("Keyword", TypeQLSyntaxHighlighter.KEYWORD),
            AttributesDescriptor("Schema type", TypeQLSyntaxHighlighter.STORAGE_TYPE),
            AttributesDescriptor("Value type", TypeQLSyntaxHighlighter.STORAGE_MODIFIER),
            AttributesDescriptor("Function", TypeQLSyntaxHighlighter.FUNCTION),
            AttributesDescriptor("Variable", TypeQLSyntaxHighlighter.VARIABLE),
            AttributesDescriptor("Annotation", TypeQLSyntaxHighlighter.ANNOTATION),
            AttributesDescriptor("String", TypeQLSyntaxHighlighter.STRING),
            AttributesDescriptor("Number", TypeQLSyntaxHighlighter.NUMERIC),
            AttributesDescriptor("Date", TypeQLSyntaxHighlighter.DATE),
            AttributesDescriptor("Boolean", TypeQLSyntaxHighlighter.BOOLEAN),
            AttributesDescriptor("Line comment", TypeQLSyntaxHighlighter.LINE_COMMENT),
            AttributesDescriptor("Operator", TypeQLSyntaxHighlighter.OPERATOR),
            AttributesDescriptor("Label", TypeQLSyntaxHighlighter.LABEL),
        )
    }

    override fun getIcon(): Icon = TypeQLIcons.FILE

    override fun getHighlighter(): SyntaxHighlighter = TypeQLSyntaxHighlighter()

    override fun getDemoText(): String = """
# TypeQL 3.x schema definition
define

entity person sub entity,
    owns name,
    owns age,
    plays friendship:friend;

relation friendship sub relation,
    relates friend @card(2..2);

attribute name sub attribute, value string;
attribute age sub attribute, value integer;

struct coordinates {
    latitude: double,
    longitude: double
};

# Query example
match
${'$'}p isa person, has name "Alice", has age ${'$'}a;
${'$'}f (${'$'}p) isa friendship;
select ${'$'}p, ${'$'}a;
sort ${'$'}a asc;
limit 10;

# Function definition
fun shortest_path(${'$'}from: person, ${'$'}to: person) -> duration:
    match
    ${'$'}from has created-date ${'$'}d;
    return ${'$'}d;

# Insert with values
insert
${'$'}p isa person, has name "Bob", has age 30;

# Fetch
match ${'$'}p isa person;
fetch {
    "name": ${'$'}p.name,
    "active": true
};

# Date and duration literals
# 2024-01-15
# 2024-01-15T10:30:00
# P1Y2M3DT4H5M6S
""".trimIndent()

    override fun getAdditionalHighlightingTagToDescriptorMap(): Map<String, TextAttributesKey>? = null

    override fun getAttributeDescriptors(): Array<AttributesDescriptor> = DESCRIPTORS

    override fun getColorDescriptors(): Array<ColorDescriptor> = ColorDescriptor.EMPTY_ARRAY

    override fun getDisplayName(): String = "TypeQL"
}
