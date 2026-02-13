package org.typedb.typeql.plugin.jetbrains.psi.impl

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.TokenType
import org.typedb.typeql.plugin.jetbrains.psi.TypeQLCompositeElementImpl
import org.typedb.typeql.plugin.jetbrains.psi.TypeQLDefinitionStruct
import org.typedb.typeql.plugin.jetbrains.psi.TypeQLElementFactory
import org.typedb.typeql.plugin.jetbrains.psi.TypeQLTypes

abstract class TypeQLDefinitionStructMixin(node: ASTNode) : TypeQLCompositeElementImpl(node), TypeQLDefinitionStruct {

    /**
     * Finds the name token (LABEL or unreserved keyword) which is the child after STRUCT.
     * The generated getLabel() only finds LABEL tokens, missing unreserved keywords.
     */
    private fun findNameNode(): ASTNode? {
        var child = node.firstChildNode
        // Skip past STRUCT keyword and whitespace to find the name token
        while (child != null) {
            if (child.elementType != TypeQLTypes.STRUCT && child.elementType != TokenType.WHITE_SPACE) {
                return child
            }
            child = child.treeNext
        }
        return null
    }

    override fun getName(): String? = findNameNode()?.text

    override fun setName(name: String): PsiElement {
        val nameNode = findNameNode()?.psi ?: return this
        val newStruct = TypeQLElementFactory.createStructDefinition(project, name)
        val newNameNode = newStruct.label ?: return this
        nameNode.replace(newNameNode)
        return this
    }

    override fun getNameIdentifier(): PsiElement? = findNameNode()?.psi
}
