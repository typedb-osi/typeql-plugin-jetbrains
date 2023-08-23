package org.typedb.typeql.plugin.jetbrains.highlighter

import com.intellij.openapi.editor.colors.ColorKey
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighter
import com.intellij.openapi.options.colors.AttributesDescriptor
import com.intellij.openapi.options.colors.ColorDescriptor
import com.intellij.openapi.options.colors.ColorSettingsPage
import com.intellij.openapi.util.IconLoader
import javax.swing.Icon

/**
 * @author [Brandon Fergerson](mailto:bfergerson@apache.org)
 */
class TypeQLColorSettingsPage : ColorSettingsPage {
    override fun getIcon(): Icon? {
        return IconLoader.findIcon("/icons/typedb.svg")
    }

    override fun getHighlighter(): SyntaxHighlighter {
        return TypeQLSyntaxHighlighter()
    }

    override fun getDemoText(): String {
        return """define

person sub entity, owns age, owns name;
    name sub attribute, value string;
    age sub attribute, value long;
    
# Lorem ipsum dolor sit amet
match
${"$"}p isa person, has name "Kevin Morrison", has age != 25;
${"$"}c isa car, has reg-date < 2020-02-29T18:01:28.577;
{ ${"$"}c has reg "VATICLE1"; } or { ${"$"}c has reg "TYPEDB1"; };
(owner: ${"$"}p, property: ${"$"}c) isa ownership, has certified true;
${"$"}p has age = 4 + 4;
group ${"$"}p;
sort asc;
"""
    }

    override fun getAdditionalHighlightingTagToDescriptorMap(): Map<String, TextAttributesKey>? {
        return null
    }

    override fun getAttributeDescriptors(): Array<AttributesDescriptor> {
        return DESCRIPTORS
    }

    override fun getColorDescriptors(): Array<ColorDescriptor> {
        return ColorDescriptor.EMPTY_ARRAY
    }

    override fun getDisplayName(): String {
        return "TypeQL"
    }

    companion object {
        private val DESCRIPTORS = arrayOf(
            AttributesDescriptor("Line Comment", TypeQLSyntaxHighlighter.Companion.LINE_COMMENT),
            AttributesDescriptor("Keyword", TypeQLSyntaxHighlighter.Companion.KEYWORD),
            AttributesDescriptor("String", TypeQLSyntaxHighlighter.Companion.STRING),
            AttributesDescriptor("Number", TypeQLSyntaxHighlighter.Companion.NUMBER),
            AttributesDescriptor("Id", TypeQLSyntaxHighlighter.Companion.ID),
            AttributesDescriptor("Thing", TypeQLSyntaxHighlighter.Companion.THING),
            AttributesDescriptor("Var", TypeQLSyntaxHighlighter.Companion.VAR),
            AttributesDescriptor("Boolean", TypeQLSyntaxHighlighter.Companion.BOOLEAN),
            AttributesDescriptor("Aggregate", TypeQLSyntaxHighlighter.Companion.AGGREGATE),
            AttributesDescriptor("Type", TypeQLSyntaxHighlighter.Companion.TYPE),
            AttributesDescriptor("Bad Value", TypeQLSyntaxHighlighter.Companion.BAD_CHARACTER)
        )
    }
}