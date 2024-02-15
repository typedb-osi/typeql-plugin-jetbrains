package org.typedb.typeql.plugin.jetbrains

import com.intellij.openapi.fileTypes.LanguageFileType
import org.typedb.typeql.plugin.jetbrains.TypeQLIcons
import javax.swing.Icon

/**
 * @author [Brandon Fergerson](mailto:bfergerson@apache.org)
 */
class TypeQLFileType private constructor() : LanguageFileType(TypeQLLanguage.INSTANCE) {
    override fun getName(): String {
        return LANG_NAME
    }

    override fun getDescription(): String {
        return "$LANG_NAME file"
    }

    override fun getDefaultExtension(): String {
        return EXTENSION
    }

    override fun getIcon(): Icon {
        return TypeQLIcons.ICON
    }

    companion object {
        val INSTANCE: TypeQLFileType = TypeQLFileType()
        const val LANG_NAME: String = "TypeQL"
        const val EXTENSION: String = "tql"
    }
}
