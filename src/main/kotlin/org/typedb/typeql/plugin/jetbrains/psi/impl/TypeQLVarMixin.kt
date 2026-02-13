package org.typedb.typeql.plugin.jetbrains.psi.impl

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiReference
import org.typedb.typeql.plugin.jetbrains.psi.TypeQLCompositeElementImpl
import org.typedb.typeql.plugin.jetbrains.psi.TypeQLVar
import org.typedb.typeql.plugin.jetbrains.psi.TypeQLVariableReference

abstract class TypeQLVarMixin(node: ASTNode) : TypeQLCompositeElementImpl(node), TypeQLVar {

    override fun getReference(): PsiReference? {
        // Don't resolve anonymous variables
        if (text == "\$_") return null
        return TypeQLVariableReference(this)
    }
}
