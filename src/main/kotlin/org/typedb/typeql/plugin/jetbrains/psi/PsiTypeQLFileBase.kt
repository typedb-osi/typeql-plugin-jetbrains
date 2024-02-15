package org.typedb.typeql.plugin.jetbrains.psi

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNamedElement
import org.typedb.typeql.plugin.jetbrains.TypeQLFileType
import org.typedb.typeql.plugin.jetbrains.TypeQLLanguage
import org.antlr.intellij.adaptor.psi.ScopeNode
import org.typedb.typeql.plugin.jetbrains.TypeQLIcons
import javax.swing.Icon

/**
 * @author [Brandon Fergerson](mailto:bfergerson@apache.org)
 */
class PsiTypeQLFileBase(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, TypeQLLanguage.INSTANCE),
    ScopeNode {
    override fun getFileType(): FileType {
        return TypeQLFileType.INSTANCE
    }

    override fun toString(): String {
        return "TypeQL Language file"
    }

    override fun getIcon(flags: Int): Icon {
        return TypeQLIcons.ICON
    }

    /**
     * Return null since a file scope has no enclosing scope. It is
     * not itself in a scope.
     *
     *
     * todo: a file could be in the scope of all the other files in the project
     */
    override fun getContext(): ScopeNode? {
        return null
    }

    override fun resolve(element: PsiNamedElement): PsiElement? {
        return null
    }
}