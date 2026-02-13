package org.typedb.typeql.plugin.jetbrains.psi.impl

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import org.typedb.typeql.plugin.jetbrains.psi.TypeQLCompositeElementImpl
import org.typedb.typeql.plugin.jetbrains.psi.TypeQLDefinitionFunction
import org.typedb.typeql.plugin.jetbrains.psi.TypeQLElementFactory

abstract class TypeQLDefinitionFunctionMixin(node: ASTNode) : TypeQLCompositeElementImpl(node), TypeQLDefinitionFunction {

    override fun getName(): String? {
        // Use firstChildNode to handle both LABEL and unreserved keyword tokens
        return functionSignature?.node?.firstChildNode?.text
    }

    override fun setName(name: String): PsiElement {
        val nameNode = functionSignature?.node?.firstChildNode?.psi ?: return this
        val newSig = TypeQLElementFactory.createFunctionName(project, name)
        val newNameNode = newSig.node.firstChildNode?.psi ?: return this
        nameNode.replace(newNameNode)
        return this
    }

    override fun getNameIdentifier(): PsiElement? = functionSignature?.node?.firstChildNode?.psi

    override fun getTextOffset(): Int = nameIdentifier?.textOffset ?: super.getTextOffset()
}
