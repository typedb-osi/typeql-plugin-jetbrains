package org.typedb.typeql.plugin.jetbrains.psi

import com.intellij.openapi.project.Project
import com.intellij.psi.PsiFileFactory
import com.intellij.psi.util.PsiTreeUtil
import org.typedb.typeql.plugin.jetbrains.TypeQLFile
import org.typedb.typeql.plugin.jetbrains.TypeQLFileType

object TypeQLElementFactory {

    fun createTypeLabel(project: Project, name: String): TypeQLTypeLabel {
        val file = createFile(project, "define entity $name sub entity;")
        val typeDef = PsiTreeUtil.findChildOfType(file, TypeQLTypeDefinition::class.java)
        return typeDef!!.typeLabel
    }

    fun createFunctionName(project: Project, name: String): TypeQLFunctionSignature {
        val file = createFile(project, "define fun $name(\$x: entity) -> entity: match \$x isa entity; return first \$x;")
        val funDef = PsiTreeUtil.findChildOfType(file, TypeQLDefinitionFunction::class.java)
        return funDef!!.functionSignature!!
    }

    fun createStructDefinition(project: Project, name: String): TypeQLDefinitionStruct {
        val file = createFile(project, "define struct $name: dummy value string;")
        return PsiTreeUtil.findChildOfType(file, TypeQLDefinitionStruct::class.java)!!
    }

    fun createVariable(project: Project, name: String): TypeQLVar {
        val varName = if (name.startsWith("$")) name else "$$name"
        val file = createFile(project, "match $varName isa entity;")
        return PsiTreeUtil.findChildOfType(file, TypeQLVar::class.java)!!
    }

    private fun createFile(project: Project, text: String): TypeQLFile {
        return PsiFileFactory.getInstance(project)
            .createFileFromText("dummy.tql", TypeQLFileType, text) as TypeQLFile
    }
}
