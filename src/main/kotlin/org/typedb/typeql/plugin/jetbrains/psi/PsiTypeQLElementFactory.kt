package org.typedb.typeql.plugin.jetbrains.psi

import com.intellij.openapi.project.Project
import com.intellij.psi.PsiFileFactory
import org.typedb.typeql.plugin.jetbrains.TypeQLFileType

/**
 * @author [Brandon Fergerson](mailto:bfergerson@apache.org)
 */
object PsiTypeQLElementFactory {
    fun createTypeProperty(project: Project?, name: String?): PsiTypeQLNamedElement {
        val dummyText = String.format("define\n%s sub entity;", name)
        val file = createFile(project, dummyText)

        // definables -> first definable -> statement -> type node wrapper -> type node
        return PsiTypeQLUtils.getDefinables(file)!!.firstChild.firstChild.firstChild.firstChild
            as PsiTypeQLNamedElement
    }

    fun createSubTypeProperty(project: Project?, name: String?): PsiTypeQLReferencingElement {
        val dummyText = String.format("define\ndummy sub %s;", name)
        val file = createFile(project, dummyText)

        // definables -> first definable -> statement -> type node wrapper -> whitespace -> subtype node
        return PsiTypeQLUtils.getDefinables(file)!!.firstChild.firstChild.firstChild.nextSibling.nextSibling
            as PsiTypeQLReferencingElement
    }

    fun createRelatesTypeProperty(project: Project?, name: String?): PsiTypeQLNamedElement {
        val dummyText = String.format("define\ndummy sub entity, relates %s;", name)
        val file = createFile(project, dummyText)

        // definables -> first definable -> statement -> relates type node
        return PsiTypeQLUtils.getDefinables(file)!!.firstChild.firstChild.lastChild
            as PsiTypeQLNamedElement
    }

    fun createPlaysTypeProperty(project: Project?, name: String?): PsiTypeQLReferencingElement {
        val dummyText = String.format("define\ndummy sub entity, plays %s;", name)
        val file = createFile(project, dummyText)

        // definables -> first definable -> statement -> plays type node
        return PsiTypeQLUtils.getDefinables(file)!!.firstChild.firstChild.lastChild
            as PsiTypeQLReferencingElement
    }

    fun createOwnsTypeProperty(project: Project?, name: String?): PsiTypeQLReferencingElement {
        val dummyText = String.format("define\ndummy sub entity, owns %s;", name)
        val file = createFile(project, dummyText)

        // definables -> first definable -> statement -> owns type node
        return PsiTypeQLUtils.getDefinables(file)!!.firstChild.firstChild.lastChild
            as PsiTypeQLReferencingElement
    }

    fun createRelatesAsOverrideTypeProperty(project: Project?, name: String?): PsiTypeQLReferencingElement {
        val dummyText = String.format("define\ndummy sub entity, relates something as %s;", name)
        val file = createFile(project, dummyText)

        // definables -> first definable -> statement -> relates type node -> relates as override type node
        return PsiTypeQLUtils.getDefinables(file)!!.firstChild.firstChild.lastChild.lastChild
            as PsiTypeQLReferencingElement
    }

    fun createPlaysAsOverrideTypeProperty(project: Project?, name: String?): PsiTypeQLReferencingElement {
        val dummyText = String.format("define\ndummy sub entity, plays some:role as %s;", name)
        val file = createFile(project, dummyText)

        // definables -> first definable -> statement -> plays type node -> plays as override type node
        return PsiTypeQLUtils.getDefinables(file)!!.firstChild.firstChild.lastChild.lastChild
            as PsiTypeQLReferencingElement
    }

    fun createOwnsAsOverrideTypeProperty(project: Project?, name: String?): PsiTypeQLReferencingElement {
        val dummyText = String.format("define\ndummy sub entity, owns something as %s;", name)
        val file = createFile(project, dummyText)

        // definables -> first definable -> statement -> owns type node -> annotation -> owns as override type node
        return PsiTypeQLUtils.getDefinables(file)!!.firstChild.firstChild.lastChild.lastChild.prevSibling
            as PsiTypeQLReferencingElement
    }

    fun createFile(project: Project?, text: String): PsiTypeQLFile {
        return PsiFileFactory.getInstance(project).createFileFromText(
            "dummy.tql", TypeQLFileType.INSTANCE, text
        ) as PsiTypeQLFile
    }
}