package org.typedb.typeql.plugin.jetbrains

import com.intellij.openapi.fileTypes.LanguageFileType
import com.intellij.openapi.util.IconLoader
import javax.swing.Icon

/**
 * @author [Brandon Fergerson](mailto:bfergerson@apache.org)
 */
class TypeQLFileType private constructor() : LanguageFileType(TypeQLLanguage.INSTANCE) {
    override fun getName(): String {
        return "TypeQL"
    }

    override fun getDescription(): String {
        return "TypeQL file"
    }

    override fun getDefaultExtension(): String {
        return "tql"
    }

    override fun getIcon(): Icon {
        return IconLoader.findIcon("/icons/typedb.svg", TypeQLFileType::class.java.classLoader)!!
    }

    object Util {
        val INSTANCE = TypeQLFileType()
    }

    companion object {
        val INSTANCE = Util.INSTANCE //todo: idk why this is needed
    }
}