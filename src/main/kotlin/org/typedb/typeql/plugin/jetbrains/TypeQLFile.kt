package org.typedb.typeql.plugin.jetbrains

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider

class TypeQLFile(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, TypeQLLanguage) {
    override fun getFileType(): FileType = TypeQLFileType
}
