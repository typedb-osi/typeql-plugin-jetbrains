package org.typedb.typeql.plugin.jetbrains.psi

import com.intellij.openapi.project.Project
import com.intellij.psi.PsiFileFactory
import org.typedb.typeql.plugin.jetbrains.TypeQLFileType

/**
 * @author [Brandon Fergerson](mailto:bfergerson@apache.org)
 */
object TypeQLPsiElementFactory {
    fun createTypeProperty(project: Project?, name: String?): PsiTypeQLNamedElement {
        val dummyText = String.format("define\n%s sub entity;", name)
        val file = createFile(project, dummyText)
        return file.firstChild.firstChild.firstChild.lastChild.firstChild as PsiTypeQLNamedElement
    }

    fun createSubTypeProperty(project: Project?, name: String?): PsiTypeQLElement {
        val dummyText = String.format("define\ndummy sub %s;", name)
        val file = createFile(project, dummyText)
        return file.firstChild.firstChild.firstChild.lastChild.firstChild
            .nextSibling.nextSibling as PsiTypeQLElement
    }

    fun createRelatesTypeProperty(project: Project?, name: String?): PsiTypeQLNamedElement {
        val dummyText = String.format("define\ndummy sub entity, relates %s;", name)
        val file = createFile(project, dummyText)
        return file.firstChild.firstChild.firstChild.lastChild.firstChild
            .nextSibling.nextSibling.nextSibling.nextSibling.nextSibling as PsiTypeQLNamedElement
    }

    fun createPlaysTypeProperty(project: Project?, name: String?): PsiTypeQLElement {
        val dummyText = String.format("define\ndummy sub entity, plays %s;", name)
        val file = createFile(project, dummyText)
        return file.firstChild.firstChild.firstChild.lastChild.firstChild
            .nextSibling.nextSibling.nextSibling.nextSibling.nextSibling as PsiTypeQLElement
    }

    fun createFile(project: Project?, text: String?): PsiTypeQLFileBase {
        return PsiFileFactory.getInstance(project).createFileFromText(
            "dummy.tql", TypeQLFileType.INSTANCE, text!!
        ) as PsiTypeQLFileBase
    }
}