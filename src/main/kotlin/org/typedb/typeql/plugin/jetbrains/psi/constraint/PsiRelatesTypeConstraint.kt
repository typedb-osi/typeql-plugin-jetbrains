package org.typedb.typeql.plugin.jetbrains.psi.constraint

import com.intellij.lang.ASTNode
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.util.IncorrectOperationException
import org.typedb.typeql.plugin.jetbrains.psi.PsiTypeQLNamedElement
import org.typedb.typeql.plugin.jetbrains.psi.TypeQLPsiUtils

/**
 * @author [Brandon Fergerson](mailto:bfergerson@apache.org)
 */
class PsiRelatesTypeConstraint(node: ASTNode) : PsiTypeQLNamedElement(node) {

    override fun getTextRange(): TextRange {
        return TextRange(super.getTextRange().startOffset - "relates ".length, super.getTextRange().endOffset)
    }

    override fun getNameIdentifier(): PsiElement? {
        return node.firstChildNode?.treeNext?.treeNext?.psi
    }

    @Throws(IncorrectOperationException::class)
    override fun setName(name: String): PsiElement {
        return TypeQLPsiUtils.setName(this, name)
    }
}
