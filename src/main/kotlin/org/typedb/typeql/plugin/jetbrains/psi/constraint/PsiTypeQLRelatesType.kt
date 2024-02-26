package org.typedb.typeql.plugin.jetbrains.psi.constraint

import com.intellij.lang.ASTNode
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.util.IncorrectOperationException
import com.vaticle.typeql.grammar.TypeQLParser
import org.typedb.typeql.plugin.jetbrains.TypeQLParserDefinition
import org.typedb.typeql.plugin.jetbrains.psi.PsiTypeQLElementFactory
import org.typedb.typeql.plugin.jetbrains.psi.PsiTypeQLNamedElement
import org.typedb.typeql.plugin.jetbrains.psi.PsiTypeQLStatementType

/**
 * @author [Brandon Fergerson](mailto:bfergerson@apache.org)
 */
class PsiTypeQLRelatesType(node: ASTNode) : PsiTypeQLNamedElement(node) {
    override val labelNode: ASTNode?
        get() = node.firstChildNode?.treeNext?.treeNext

    override val scopedName: String?
        get() {
            val statement = parent as PsiTypeQLStatementType
            return String.format("%s:%s", statement.name, name)
        }

    override val tokenText = TypeQLParserDefinition.getTokenText(TypeQLParser.RELATES)

    override fun getTextRange(): TextRange? {
        val fullTextRange = super.getTextRange() ?: return null
        return TextRange(fullTextRange.startOffset - tokenTextOffset, fullTextRange.endOffset)
    }

    override fun getNameIdentifier(): PsiElement? {
        return labelNode?.psi
    }

    @Throws(IncorrectOperationException::class)
    override fun setName(name: String): PsiElement {
        val typeProperty = PsiTypeQLElementFactory.createRelatesTypeProperty(project, name) ?: return this

        if (labelNode == null || typeProperty.labelNode == null) {
            throw NullPointerException("Cannot access label node for $this")
        }

        node.replaceChild(labelNode!!, typeProperty.labelNode!!)
        return this
    }
}
