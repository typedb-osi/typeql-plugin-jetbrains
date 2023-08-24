package org.typedb.typeql.plugin.jetbrains.reference

import com.intellij.openapi.util.TextRange
import com.intellij.psi.*
import com.intellij.util.IncorrectOperationException
import org.typedb.typeql.plugin.jetbrains.psi.PsiTypeQLElement
import org.typedb.typeql.plugin.jetbrains.psi.TypeQLPsiUtils
import org.typedb.typeql.plugin.jetbrains.psi.constraint.PsiOwnsTypeConstraint

/**
 * @author [Brandon Fergerson](mailto:bfergerson@apache.org)
 */
class TypeQLReference(element: PsiTypeQLElement, textRange: TextRange) :
    PsiReferenceBase<PsiTypeQLElement?>(element, textRange), PsiPolyVariantReference {

    override fun getRangeInElement(): TextRange {
        return if (element is PsiOwnsTypeConstraint) {
            TextRange(super.getRangeInElement().startOffset + 1, super.getRangeInElement().endOffset + 1)
        } else {
            super.getRangeInElement()
        }
    }

    @Throws(IncorrectOperationException::class)
    override fun handleElementRename(newElementName: String): PsiElement {
        return TypeQLPsiUtils.setName(myElement!!, newElementName)
    }

    override fun multiResolve(incompleteCode: Boolean): Array<ResolveResult> {
        val results: MutableList<ResolveResult> = ArrayList()
        for (identifier in TypeQLPsiUtils.findUsages(myElement!!)) {
            results.add(PsiElementResolveResult(identifier))
        }
        return results.toTypedArray()
    }

    override fun resolve(): PsiElement? {
        return TypeQLPsiUtils.findDeclaration(myElement!!.project, myElement!!)
    }

    override fun getVariants(): Array<Any> {
        return emptyArray()
    }
}
