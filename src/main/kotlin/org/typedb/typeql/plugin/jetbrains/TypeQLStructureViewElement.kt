package org.typedb.typeql.plugin.jetbrains

import com.intellij.ide.projectView.PresentationData
import com.intellij.ide.structureView.StructureViewTreeElement
import com.intellij.ide.util.treeView.smartTree.SortableTreeElement
import com.intellij.ide.util.treeView.smartTree.TreeElement
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.NavigatablePsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.util.PsiTreeUtil
import org.typedb.typeql.plugin.jetbrains.psi.*

class TypeQLStructureViewElement(private val element: NavigatablePsiElement) :
    StructureViewTreeElement, SortableTreeElement {

    override fun getValue(): Any = element

    override fun navigate(requestFocus: Boolean) = element.navigate(requestFocus)

    override fun canNavigate(): Boolean = element.canNavigate()

    override fun canNavigateToSource(): Boolean = element.canNavigateToSource()

    override fun getAlphaSortKey(): String = getPresentation().presentableText ?: ""

    override fun getPresentation(): ItemPresentation {
        return element.presentation ?: buildPresentation()
    }

    private fun buildPresentation(): PresentationData {
        return when (element) {
            is TypeQLFile -> PresentationData(
                (element as PsiFile).name, null, TypeQLIcons.FILE, null
            )
            is TypeQLDefineQuery -> PresentationData("define", null, null, null)
            is TypeQLUndefineQuery -> PresentationData("undefine", null, null, null)
            is TypeQLRedefineQuery -> PresentationData("redefine", null, null, null)
            is TypeQLPipelineQuery -> buildPipelinePresentation()
            is TypeQLTypeDefinition -> buildTypePresentation()
            is TypeQLDefinitionFunction -> buildFunctionPresentation()
            is TypeQLDefinitionStruct -> buildStructPresentation()
            else -> PresentationData(element.text?.take(40) ?: "?", null, null, null)
        }
    }

    private fun buildPipelinePresentation(): PresentationData {
        val firstClause = element.children.firstOrNull()
        val label = when (firstClause) {
            is TypeQLMatchClause -> "match ..."
            is TypeQLInsertClause -> "insert ..."
            is TypeQLPutClause -> "put ..."
            is TypeQLUpdateClause -> "update ..."
            is TypeQLDeleteClause -> "delete ..."
            else -> "pipeline"
        }
        return PresentationData(label, null, null, null)
    }

    private fun buildTypePresentation(): PresentationData {
        val typeDef = element as TypeQLTypeDefinition
        val kind = typeDef.kind?.text ?: ""
        val name = typeDef.typeLabel.text
        val label = if (kind.isNotEmpty()) "$kind $name" else name
        return PresentationData(label, null, null, null)
    }

    private fun buildFunctionPresentation(): PresentationData {
        val funDef = element as TypeQLDefinitionFunction
        val sig = funDef.functionSignature
        val name = sig?.text?.substringBefore("(")?.trim() ?: "?"
        return PresentationData("fun $name(...)", null, null, null)
    }

    private fun buildStructPresentation(): PresentationData {
        val structDef = element as TypeQLDefinitionStruct
        val name = structDef.label?.text
            ?: structDef.text?.substringAfter("struct")?.substringBefore(":")?.trim()
            ?: "?"
        return PresentationData("struct $name", null, null, null)
    }

    override fun getChildren(): Array<TreeElement> {
        val children = mutableListOf<TreeElement>()

        when (element) {
            is TypeQLFile -> {
                // Top-level: schema queries, pipeline queries, standalone functions/structs
                for (child in element.children) {
                    when (child) {
                        is TypeQLSchemaQuery -> {
                            // Unwrap schema_query → define/undefine/redefine
                            for (inner in child.children) {
                                if (inner is NavigatablePsiElement) {
                                    children.add(TypeQLStructureViewElement(inner))
                                }
                            }
                        }
                        is NavigatablePsiElement -> children.add(TypeQLStructureViewElement(child))
                    }
                }
            }
            is TypeQLDefineQuery, is TypeQLUndefineQuery, is TypeQLRedefineQuery -> {
                // Inside define/undefine/redefine: type definitions, functions, structs
                collectDefinables(children)
            }
            is TypeQLTypeDefinition -> {
                // Leaf — no children in structure view
            }
            is TypeQLDefinitionFunction -> {
                // Leaf — no children in structure view
            }
            is TypeQLDefinitionStruct -> {
                // Could show fields but keeping it simple
            }
        }

        return children.toTypedArray()
    }

    private fun collectDefinables(out: MutableList<TreeElement>) {
        val types = PsiTreeUtil.findChildrenOfType(element, TypeQLTypeDefinition::class.java)
        val functions = PsiTreeUtil.findChildrenOfType(element, TypeQLDefinitionFunction::class.java)
        val structs = PsiTreeUtil.findChildrenOfType(element, TypeQLDefinitionStruct::class.java)

        for (t in types) out.add(TypeQLStructureViewElement(t as NavigatablePsiElement))
        for (f in functions) out.add(TypeQLStructureViewElement(f as NavigatablePsiElement))
        for (s in structs) out.add(TypeQLStructureViewElement(s as NavigatablePsiElement))
    }
}
