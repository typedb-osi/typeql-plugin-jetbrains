package org.typedb.typeql.plugin.jetbrains.psi

import com.intellij.lang.ASTNode
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiNameIdentifierOwner

/**
 * @author [Brandon Fergerson](mailto:bfergerson@apache.org)
 */
abstract class PsiTypeQLNamedElement(node: ASTNode) : PsiTypeQLElement(node), PsiNameIdentifierOwner {

    override fun getTextRange(): TextRange = nameIdentifier?.textRange!!

    override fun getName(): String? = nameIdentifier?.text

    override fun getTextOffset(): Int = nameIdentifier?.textOffset ?: super.getTextOffset()

    override fun toString(): String {
        return String.format(
            "%s(%s) - Name: %s - Location: %s",
            javaClass.simpleName, node.elementType, name, textRange
        )
    }
}
