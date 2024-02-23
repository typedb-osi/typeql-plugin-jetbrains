package org.typedb.typeql.plugin.jetbrains.psi.constraint

import com.intellij.lang.ASTNode
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiReference
import com.intellij.psi.impl.source.resolve.reference.ReferenceProvidersRegistry
import org.typedb.typeql.plugin.jetbrains.psi.PsiTypeQLReferencingElement

/**
 * @author [Brandon Fergerson](mailto:bfergerson@apache.org)
 */
class PsiTypeQLPlaysType(node: ASTNode) : PsiTypeQLReferencingElement(node) {

    val playsTypeTextRange: TextRange
        get() {
            val scopeIndex = text.indexOf(":") + 1
            val superRoleIndex = text.indexOf(" as ")
            val endIndex = if (superRoleIndex == -1) "plays ".length + playsType!!.length else superRoleIndex

            return if (scopeIndex <= endIndex) TextRange(scopeIndex, endIndex) else TextRange(0, 0)
        }

    val playsType: String?
        get() = firstChild?.nextSibling?.nextSibling?.text

    override fun getName(): String? = this.playsType

    override fun getReference(): PsiReference? = if (playsType == null) null else super.getReference()
}
