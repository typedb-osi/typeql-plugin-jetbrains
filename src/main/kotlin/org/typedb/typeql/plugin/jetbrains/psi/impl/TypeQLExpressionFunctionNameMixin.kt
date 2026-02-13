package org.typedb.typeql.plugin.jetbrains.psi.impl

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiReference
import org.typedb.typeql.plugin.jetbrains.psi.TypeQLCompositeElementImpl
import org.typedb.typeql.plugin.jetbrains.psi.TypeQLExpressionFunctionName
import org.typedb.typeql.plugin.jetbrains.psi.TypeQLFunctionReference
import org.typedb.typeql.plugin.jetbrains.psi.TypeQLTypes

abstract class TypeQLExpressionFunctionNameMixin(node: ASTNode) : TypeQLCompositeElementImpl(node), TypeQLExpressionFunctionName {

    override fun getReference(): PsiReference? {
        // Don't resolve built-in function names
        val firstChild = node.firstChildNode ?: return null
        if (firstChild.elementType in BUILTIN_TOKENS) return null
        return TypeQLFunctionReference(this)
    }

    companion object {
        private val BUILTIN_TOKENS = setOf(
            TypeQLTypes.ABS_KW, TypeQLTypes.CEIL_KW, TypeQLTypes.FLOOR_KW,
            TypeQLTypes.ROUND_KW, TypeQLTypes.LEN_KW,
            TypeQLTypes.MAX, TypeQLTypes.MIN,
            TypeQLTypes.LABEL_KW, TypeQLTypes.IID_KW
        )
    }
}
