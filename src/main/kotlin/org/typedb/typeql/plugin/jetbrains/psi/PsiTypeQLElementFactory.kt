package org.typedb.typeql.plugin.jetbrains.psi

import com.intellij.openapi.project.Project
import com.intellij.psi.PsiFileFactory
import org.typedb.typeql.plugin.jetbrains.TypeQLFileType

/**
 * @author [Brandon Fergerson](mailto:bfergerson@apache.org)
 */
object PsiTypeQLElementFactory {
    fun createTypeProperty(project: Project?, name: String?): PsiTypeQLNamedElement? {
        val dummyText = String.format("define\n%s sub entity;", name)
        val file = createFile(project, dummyText) ?: return null

        // definables -> first definable -> statement -> type node wrapper -> type node
        val node = PsiTypeQLUtils.getDefinables(file)?.firstChild?.firstChild?.firstChild?.firstChild
        return if (node != null) node as PsiTypeQLNamedElement else null
    }

    fun createSubTypeProperty(project: Project?, name: String?): PsiTypeQLReferencingElement? {
        val dummyText = String.format("define\ndummy sub %s;", name)
        val file = createFile(project, dummyText) ?: return null

        // definables -> first definable -> statement -> type node wrapper -> whitespace -> subtype node
        val node = PsiTypeQLUtils.getDefinables(file)?.firstChild?.firstChild?.firstChild?.nextSibling?.nextSibling
        return if (node != null) node as PsiTypeQLReferencingElement else null
    }

    fun createRelatesTypeProperty(project: Project?, name: String?): PsiTypeQLNamedElement? {
        val dummyText = String.format("define\ndummy sub entity, relates %s;", name)
        val file = createFile(project, dummyText) ?: return null

        // definables -> first definable -> statement -> relates type node
        val node = PsiTypeQLUtils.getDefinables(file)?.firstChild?.firstChild?.lastChild
        return if (node != null) node as PsiTypeQLNamedElement else null
    }

    fun createPlaysTypeProperty(project: Project?, name: String?): PsiTypeQLReferencingElement? {
        val dummyText = String.format("define\ndummy sub entity, plays %s;", name)
        val file = createFile(project, dummyText) ?: return null

        // definables -> first definable -> statement -> plays type node
        val node = PsiTypeQLUtils.getDefinables(file)?.firstChild?.firstChild?.lastChild
        return if (node != null) node as PsiTypeQLReferencingElement else null
    }

    fun createOwnsTypeProperty(project: Project?, name: String?): PsiTypeQLReferencingElement? {
        val dummyText = String.format("define\ndummy sub entity, owns %s;", name)
        val file = createFile(project, dummyText) ?: return null

        // definables -> first definable -> statement -> owns type node
        val node = PsiTypeQLUtils.getDefinables(file)?.firstChild?.firstChild?.lastChild
        return if (node != null) node as PsiTypeQLReferencingElement else null
    }

    fun createRelatesAsOverrideTypeProperty(project: Project?, name: String?): PsiTypeQLReferencingElement? {
        val dummyText = String.format("define\ndummy sub entity, relates something as %s;", name)
        val file = createFile(project, dummyText) ?: return null

        // definables -> first definable -> statement -> relates type node -> relates as override type node
        val node = PsiTypeQLUtils.getDefinables(file)?.firstChild?.firstChild?.lastChild?.lastChild
        return if (node != null) node as PsiTypeQLReferencingElement else null
    }

    fun createPlaysAsOverrideTypeProperty(project: Project?, name: String?): PsiTypeQLReferencingElement? {
        val dummyText = String.format("define\ndummy sub entity, plays some:role as %s;", name)
        val file = createFile(project, dummyText) ?: return null

        // definables -> first definable -> statement -> plays type node -> plays as override type node
        val node = PsiTypeQLUtils.getDefinables(file)?.firstChild?.firstChild?.lastChild?.lastChild
        return if (node != null) node as PsiTypeQLReferencingElement else null
    }

    fun createOwnsAsOverrideTypeProperty(project: Project?, name: String?): PsiTypeQLReferencingElement? {
        val dummyText = String.format("define\ndummy sub entity, owns something as %s;", name)
        val file = createFile(project, dummyText) ?: return null

        // definables -> first definable -> statement -> owns type node -> annotation -> owns as override type node
        val node = PsiTypeQLUtils.getDefinables(file)?.firstChild?.firstChild?.lastChild?.lastChild?.prevSibling
        return if (node != null) node as PsiTypeQLReferencingElement else null
    }

    fun createFile(project: Project?, text: String): PsiTypeQLFile {
        return PsiFileFactory.getInstance(project).createFileFromText(
            "dummy.tql", TypeQLFileType.INSTANCE, text
        ) as PsiTypeQLFile
    }
}
