package org.typedb.typeql.plugin.jetbrains.psi.constraint

import com.intellij.lang.ASTNode
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiReference
import org.typedb.typeql.plugin.jetbrains.psi.PsiTypeQLReferencingElement

/**
 * @author [Brandon Fergerson](mailto:bfergerson@apache.org)
 */
// sub *NAME*
class PsiTypeQLSubType(node: ASTNode) : PsiTypeQLReferencingElement(node) {
    val subTypeTextRange: TextRange
        get() = TextRange("sub ".length, "sub ".length + subType!!.length)
    val subType: String?
        get() = lastChild?.text

    override fun getReference(): PsiReference? {
        if (subType == null) {
            return null
        }

        return super.getReference()
    }
}