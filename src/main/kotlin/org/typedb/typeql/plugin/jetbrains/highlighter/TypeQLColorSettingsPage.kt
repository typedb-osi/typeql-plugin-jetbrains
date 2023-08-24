package org.typedb.typeql.plugin.jetbrains.highlighter

import com.intellij.openapi.editor.colors.ColorKey
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighter
import com.intellij.openapi.options.colors.AttributesDescriptor
import com.intellij.openapi.options.colors.ColorDescriptor
import com.intellij.openapi.options.colors.ColorSettingsPage
import com.intellij.openapi.util.IconLoader
import com.intellij.openapi.util.Pair
import com.intellij.util.containers.ContainerUtil
import java.awt.Color
import javax.swing.Icon

/**
 * @author [Brandon Fergerson](mailto:bfergerson@apache.org)
 */
class TypeQLColorSettingsPage : ColorSettingsPage {

    var testint = 1;

    override fun getIcon(): Icon? {
        return IconLoader.findIcon("/icons/typedb.svg", TypeQLColorSettingsPage::class.java.classLoader)
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
        return ContainerUtil.newHashMap(Pair("Line Comment TEST", TypeQLSyntaxHighlighter.Companion.LINE_COMMENT))
    }

    override fun getAttributeDescriptors(): Array<AttributesDescriptor> {
        return ATTR_DESC
    }

    override fun getColorDescriptors(): Array<ColorDescriptor> {
        return ColorDescriptor.EMPTY_ARRAY
    }

    override fun getDisplayName(): String {
        return "TypeQL"
    }

    companion object {
        private var ATTR_DESC = arrayOf(
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
            //AttributesDescriptor("Bad Value", TypeQLSyntaxHighlighter.Companion.BAD_CHARACTER)
        )

        private val COLOR_DESC = arrayOf(
            ColorDescriptor("Line Comment", ColorKey.createColorKey("Green", Color(77, 201, 124)), ColorDescriptor.Kind.FOREGROUND),
            ColorDescriptor("Keyword", ColorKey.createColorKey("Pink", Color(255, 122, 189)), ColorDescriptor.Kind.FOREGROUND),
            ColorDescriptor("String", ColorKey.createColorKey("Yellow", Color(255, 228, 167)), ColorDescriptor.Kind.FOREGROUND),
            ColorDescriptor("Number", ColorKey.createColorKey("Blue", Color(130, 182, 255)), ColorDescriptor.Kind.FOREGROUND),
            ColorDescriptor("Id", ColorKey.createColorKey("Light Purple", Color(213, 204, 255)), ColorDescriptor.Kind.FOREGROUND),
            ColorDescriptor("Thing", ColorKey.createColorKey("Cyan", Color(85, 234, 226)), ColorDescriptor.Kind.FOREGROUND),
            ColorDescriptor("Var", ColorKey.createColorKey("Cyan", Color(85, 234, 226)), ColorDescriptor.Kind.FOREGROUND),
            ColorDescriptor("Boolean", ColorKey.createColorKey("Orange", Color(255, 161, 135)), ColorDescriptor.Kind.FOREGROUND),
            ColorDescriptor("Aggregate", ColorKey.createColorKey("Pink", Color(255, 122, 189)), ColorDescriptor.Kind.FOREGROUND),
            ColorDescriptor("Type", ColorKey.createColorKey("Blue", Color(130, 182, 255)), ColorDescriptor.Kind.FOREGROUND),
            //ColorDescriptor("Bad Value", ColorKey.createColorKey("Line Comment", Color(10, 10, 10)), ColorDescriptor.Kind.FOREGROUND),
        )
    }
}