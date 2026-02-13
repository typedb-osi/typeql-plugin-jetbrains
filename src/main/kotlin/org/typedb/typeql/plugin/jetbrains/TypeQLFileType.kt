package org.typedb.typeql.plugin.jetbrains

import com.intellij.openapi.fileTypes.LanguageFileType
import javax.swing.Icon

object TypeQLFileType : LanguageFileType(TypeQLLanguage) {
    override fun getName(): String = "TypeQL"
    override fun getDescription(): String = "TypeQL language file"
    override fun getDefaultExtension(): String = "tql"
    override fun getIcon(): Icon = TypeQLIcons.FILE
}
