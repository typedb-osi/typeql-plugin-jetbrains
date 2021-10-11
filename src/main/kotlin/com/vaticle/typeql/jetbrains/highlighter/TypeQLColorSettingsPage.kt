package com.vaticle.typeql.jetbrains.highlighter

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
        //todo: better demo text; doesn't show numbers/text/bad chars/etc
        return """#Example comment
define

school-mutuality sub relation,
  relates schoolmate,
  relates mutual-school;

people-gone-to-the-same-school sub rule,
  when {
    (student: ${"$"}p1, enrolled-course: ${"$"}c1) isa school-course-enrollment;
    (student: ${"$"}p2, enrolled-course: ${"$"}c2) isa school-course-enrollment;
    (offered-course: ${"$"}c1, offering-school: ${"$"}s) isa school-course-offering;
    (offered-course: ${"$"}c2, offering-school: ${"$"}s) isa school-course-offering;
    ${"$"}p1 != ${"$"}p2;
  }, then {
    (schoolmate: ${"$"}p1, schoolmate: ${"$"}p2, mutual-school: ${"$"}s) isa school-mutuality;
  };"""
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
            AttributesDescriptor("Bad Value", TypeQLSyntaxHighlighter.Companion.BAD_CHARACTER)
        )
    }
}