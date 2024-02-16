package org.typedb.typeql.plugin.jetbrains.highlighter

import ai.grazie.utils.capitalize
import com.intellij.openapi.editor.colors.ColorKey
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighter
import com.intellij.openapi.options.colors.AttributesDescriptor
import com.intellij.openapi.options.colors.ColorDescriptor
import com.intellij.openapi.options.colors.ColorSettingsPage
import com.intellij.openapi.util.Pair
import com.intellij.util.containers.ContainerUtil
import com.jetbrains.rd.generator.nova.util.capitalizeInvariant
import org.typedb.typeql.plugin.jetbrains.TypeQLFileType
import org.typedb.typeql.plugin.jetbrains.TypeQLIcons
import java.awt.Color
import javax.swing.Icon
import org.typedb.typeql.plugin.jetbrains.highlighter.TypeQLSyntaxHighlighter.Companion.FUNCTION
import org.typedb.typeql.plugin.jetbrains.highlighter.TypeQLSyntaxHighlighter.Companion.ANNOTATION
import org.typedb.typeql.plugin.jetbrains.highlighter.TypeQLSyntaxHighlighter.Companion.BOOLEAN
import org.typedb.typeql.plugin.jetbrains.highlighter.TypeQLSyntaxHighlighter.Companion.DATE
import org.typedb.typeql.plugin.jetbrains.highlighter.TypeQLSyntaxHighlighter.Companion.IID
import org.typedb.typeql.plugin.jetbrains.highlighter.TypeQLSyntaxHighlighter.Companion.KEYWORD
import org.typedb.typeql.plugin.jetbrains.highlighter.TypeQLSyntaxHighlighter.Companion.LABEL
import org.typedb.typeql.plugin.jetbrains.highlighter.TypeQLSyntaxHighlighter.Companion.LINE_COMMENT
import org.typedb.typeql.plugin.jetbrains.highlighter.TypeQLSyntaxHighlighter.Companion.NUMBER
import org.typedb.typeql.plugin.jetbrains.highlighter.TypeQLSyntaxHighlighter.Companion.OPERATOR
import org.typedb.typeql.plugin.jetbrains.highlighter.TypeQLSyntaxHighlighter.Companion.STRING
import org.typedb.typeql.plugin.jetbrains.highlighter.TypeQLSyntaxHighlighter.Companion.THING
import org.typedb.typeql.plugin.jetbrains.highlighter.TypeQLSyntaxHighlighter.Companion.TYPE
import org.typedb.typeql.plugin.jetbrains.highlighter.TypeQLSyntaxHighlighter.Companion.VAR

/**
 * @author [Brandon Fergerson](mailto:bfergerson@apache.org)
 */
class TypeQLColorSettingsPage : ColorSettingsPage {

    override fun getIcon(): Icon? {
        return TypeQLIcons.ICON
    }

    override fun getHighlighter(): SyntaxHighlighter {
        return TypeQLSyntaxHighlighter()
    }

    override fun getDemoText(): String {
        return """define

person sub entity, 
    owns id @key,
    owns age,
    owns name;
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
        return ContainerUtil.newHashMap(Pair("Line Comment TEST", TypeQLSyntaxHighlighter.LINE_COMMENT))
    }

    override fun getAttributeDescriptors(): Array<AttributesDescriptor> {
        return ATTR_DESC
    }

    override fun getColorDescriptors(): Array<ColorDescriptor> {
        return ColorDescriptor.EMPTY_ARRAY
    }

    override fun getDisplayName(): String {
        return TypeQLFileType.LANG_NAME
    }

    companion object {

        private fun formatAttributeKeyName(name: String): String {
            return name
                .split("_")
                .joinToString(" ") { val lower = it.lowercase(); lower.replaceFirstChar(Char::uppercaseChar) }
        }

        private fun getAttributesDescriptor(key: TextAttributesKey, keyName: String): AttributesDescriptor {
            return AttributesDescriptor(formatAttributeKeyName(keyName), key)
        }

        private var ATTR_DESC = arrayOf(
            getAttributesDescriptor(THING, ::THING.name),
            getAttributesDescriptor(TYPE, ::TYPE.name),
            getAttributesDescriptor(KEYWORD, ::KEYWORD.name),
            getAttributesDescriptor(OPERATOR, ::OPERATOR.name),
            getAttributesDescriptor(ANNOTATION, ::ANNOTATION.name),
            getAttributesDescriptor(FUNCTION, ::FUNCTION.name),
            getAttributesDescriptor(BOOLEAN, ::BOOLEAN.name),
            getAttributesDescriptor(STRING, ::STRING.name),
            getAttributesDescriptor(NUMBER, ::NUMBER.name),
            getAttributesDescriptor(DATE, ::DATE.name),
            getAttributesDescriptor(VAR, ::VAR.name),
            getAttributesDescriptor(LABEL, ::LABEL.name),
            getAttributesDescriptor(IID, ::IID.name),
            getAttributesDescriptor(LINE_COMMENT, ::LINE_COMMENT.name),
        )
    }
}