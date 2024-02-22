package org.typedb.typeql.plugin.jetbrains.psi.constraint

import com.intellij.lang.ASTNode
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiReference
import com.intellij.psi.impl.source.resolve.reference.ReferenceProvidersRegistry
import org.typedb.typeql.plugin.jetbrains.psi.PsiTypeQLReferencingElement

/**
 * @author [Brandon Fergerson](mailto:bfergerson@apache.org)
 */
class PsiTypeQLOwnsType(node: ASTNode) : PsiTypeQLReferencingElement(node) {
    val ownsTypeTextRange: TextRange
        get() = TextRange("owns".length, "owns".length + ownsType!!.length)
    val ownsType: String?
        get() = firstChild?.nextSibling?.nextSibling?.text
    val isAbstractType: Boolean
        get() = ownsType == "abstract" // TODO CLeanup
    val isKey: Boolean
        get() = lastChild?.text == "key" // TODO CLeanup

    override fun getReference(): PsiReference? {
        if (ownsType == null || isAbstractType) { // TODO: Needed?
            return null
        }

        return super.getReference()
    }
}
