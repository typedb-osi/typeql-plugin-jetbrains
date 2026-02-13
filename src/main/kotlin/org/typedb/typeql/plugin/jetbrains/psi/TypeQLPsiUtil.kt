package org.typedb.typeql.plugin.jetbrains.psi

import com.intellij.openapi.project.Project
import com.intellij.psi.PsiManager
import com.intellij.psi.search.FileTypeIndex
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.psi.util.PsiTreeUtil
import org.typedb.typeql.plugin.jetbrains.TypeQLFile
import org.typedb.typeql.plugin.jetbrains.TypeQLFileType

object TypeQLPsiUtil {

    fun findAllTypeQLFiles(project: Project): List<TypeQLFile> {
        val psiManager = PsiManager.getInstance(project)
        val virtualFiles = FileTypeIndex.getFiles(TypeQLFileType, GlobalSearchScope.allScope(project))
        return virtualFiles.mapNotNull { psiManager.findFile(it) as? TypeQLFile }
    }

    fun findTypeDefinitions(project: Project, name: String): List<TypeQLTypeDefinition> {
        return findAllTypeQLFiles(project).flatMap { file ->
            PsiTreeUtil.findChildrenOfType(file, TypeQLTypeDefinition::class.java)
                .filter { it.name == name }
        }
    }

    fun findFunctionDefinitions(project: Project, name: String): List<TypeQLDefinitionFunction> {
        return findAllTypeQLFiles(project).flatMap { file ->
            PsiTreeUtil.findChildrenOfType(file, TypeQLDefinitionFunction::class.java)
                .filter { it.name == name }
        }
    }

    fun findStructDefinitions(project: Project, name: String): List<TypeQLDefinitionStruct> {
        return findAllTypeQLFiles(project).flatMap { file ->
            PsiTreeUtil.findChildrenOfType(file, TypeQLDefinitionStruct::class.java)
                .filter { it.name == name }
        }
    }
}
