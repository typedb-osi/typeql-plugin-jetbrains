package org.typedb.typeql.plugin.jetbrains.psi.impl

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiReference
import org.typedb.typeql.plugin.jetbrains.psi.TypeQLCompositeElementImpl
import org.typedb.typeql.plugin.jetbrains.psi.TypeQLTypeLabel
import org.typedb.typeql.plugin.jetbrains.psi.TypeQLTypeReference

abstract class TypeQLTypeLabelMixin(node: ASTNode) : TypeQLCompositeElementImpl(node), TypeQLTypeLabel {

    override fun getReference(): PsiReference? {
        return TypeQLTypeReference(this)
    }
}
