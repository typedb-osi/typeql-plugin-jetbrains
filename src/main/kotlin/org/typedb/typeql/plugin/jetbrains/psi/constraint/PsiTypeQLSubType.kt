package org.typedb.typeql.plugin.jetbrains.psi.constraint

import com.intellij.lang.ASTNode
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiReference
import com.vaticle.typeql.grammar.TypeQLParser
import org.typedb.typeql.plugin.jetbrains.psi.PsiTypeQLReferencingElement

/**
 * @author [Brandon Fergerson](mailto:bfergerson@apache.org)
 */
class PsiTypeQLSubType(node: ASTNode) : PsiTypeQLReferencingElement(node) {
    val subTypeTextRange: TextRange
        get() = TextRange("sub ".length, "sub ".length + subType!!.length)

    val subType: String?
        get() = lastChild?.text

    override fun getName(): String? = this.subType

    override fun getReference(): PsiReference? = if (subType == null) null else super.getReference()
}
