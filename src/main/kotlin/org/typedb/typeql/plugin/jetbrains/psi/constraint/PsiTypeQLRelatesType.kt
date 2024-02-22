package org.typedb.typeql.plugin.jetbrains.psi.constraint

import com.intellij.lang.ASTNode
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.util.IncorrectOperationException
import org.typedb.typeql.plugin.jetbrains.psi.PsiTypeQLNamedElement
import org.typedb.typeql.plugin.jetbrains.psi.PsiTypeQLUtils
import org.typedb.typeql.plugin.jetbrains.psi.PsiTypeQLStatementType

/**
 * @author [Brandon Fergerson](mailto:bfergerson@apache.org)
 */
class PsiTypeQLRelatesType(node: ASTNode) : PsiTypeQLNamedElement(node) {
    override val scopedName: String?
        get() {
            val statement = parent as PsiTypeQLStatementType
            return String.format("%s:%s", statement.name, name)
        }

    override fun getTextRange(): TextRange? {
        val fullTextRange = super.getTextRange() ?: return null
        return TextRange(fullTextRange.startOffset - "relates ".length, fullTextRange.endOffset)
    }

    override fun getNameIdentifier(): PsiElement? {
        return node.firstChildNode?.treeNext?.treeNext?.psi
    }

    @Throws(IncorrectOperationException::class)
    override fun setName(name: String): PsiElement {
        return PsiTypeQLUtils.setName(this, name)
    }
}
