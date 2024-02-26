package org.typedb.typeql.plugin.jetbrains.highlighter

import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighter
import com.intellij.openapi.options.colors.AttributesDescriptor
import com.intellij.openapi.options.colors.ColorDescriptor
import com.intellij.openapi.options.colors.ColorSettingsPage
import org.typedb.typeql.plugin.jetbrains.TypeQLFileType
import org.typedb.typeql.plugin.jetbrains.TypeQLIcons
import org.typedb.typeql.plugin.jetbrains.highlighter.TypeQLSyntaxHighlighter.Companion.ANNOTATION
import org.typedb.typeql.plugin.jetbrains.highlighter.TypeQLSyntaxHighlighter.Companion.BOOLEAN
import org.typedb.typeql.plugin.jetbrains.highlighter.TypeQLSyntaxHighlighter.Companion.DATE
import org.typedb.typeql.plugin.jetbrains.highlighter.TypeQLSyntaxHighlighter.Companion.FUNCTION
import org.typedb.typeql.plugin.jetbrains.highlighter.TypeQLSyntaxHighlighter.Companion.IID
import org.typedb.typeql.plugin.jetbrains.highlighter.TypeQLSyntaxHighlighter.Companion.KEYWORD
import org.typedb.typeql.plugin.jetbrains.highlighter.TypeQLSyntaxHighlighter.Companion.LABEL
import org.typedb.typeql.plugin.jetbrains.highlighter.TypeQLSyntaxHighlighter.Companion.LINE_COMMENT
import org.typedb.typeql.plugin.jetbrains.highlighter.TypeQLSyntaxHighlighter.Companion.NUMERIC
import org.typedb.typeql.plugin.jetbrains.highlighter.TypeQLSyntaxHighlighter.Companion.OPERATOR
import org.typedb.typeql.plugin.jetbrains.highlighter.TypeQLSyntaxHighlighter.Companion.STORAGE_MODIFIER
import org.typedb.typeql.plugin.jetbrains.highlighter.TypeQLSyntaxHighlighter.Companion.STORAGE_TYPE
import org.typedb.typeql.plugin.jetbrains.highlighter.TypeQLSyntaxHighlighter.Companion.STRING
import org.typedb.typeql.plugin.jetbrains.highlighter.TypeQLSyntaxHighlighter.Companion.VARIABLE
import javax.swing.Icon

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

# The resulting response copied here to show an IID:
iid 0x826e800f8000000000000000 isa person => 1
"""
    }

    override fun getAdditionalHighlightingTagToDescriptorMap(): Map<String, TextAttributesKey>? {
        return HashMap()
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
            getAttributesDescriptor(STORAGE_TYPE, ::STORAGE_TYPE.name),
            getAttributesDescriptor(STORAGE_MODIFIER, ::STORAGE_MODIFIER.name),
            getAttributesDescriptor(KEYWORD, ::KEYWORD.name),
            getAttributesDescriptor(OPERATOR, ::OPERATOR.name),
            getAttributesDescriptor(ANNOTATION, ::ANNOTATION.name),
            getAttributesDescriptor(FUNCTION, ::FUNCTION.name),
            getAttributesDescriptor(BOOLEAN, ::BOOLEAN.name),
            getAttributesDescriptor(STRING, ::STRING.name),
            getAttributesDescriptor(NUMERIC, ::NUMERIC.name),
            getAttributesDescriptor(DATE, ::DATE.name),
            getAttributesDescriptor(VARIABLE, ::VARIABLE.name),
            getAttributesDescriptor(LABEL, ::LABEL.name),
            getAttributesDescriptor(IID, ::IID.name),
            getAttributesDescriptor(LINE_COMMENT, ::LINE_COMMENT.name),
        )
    }
}
