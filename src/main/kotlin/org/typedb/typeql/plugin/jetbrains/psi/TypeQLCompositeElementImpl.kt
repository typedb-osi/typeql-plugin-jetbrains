package org.typedb.typeql.plugin.jetbrains.psi

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode

open class TypeQLCompositeElementImpl(node: ASTNode) : ASTWrapperPsiElement(node), TypeQLCompositeElement
