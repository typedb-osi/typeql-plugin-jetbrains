package org.typedb.typeql.plugin.jetbrains

import com.intellij.ide.structureView.StructureViewModel
import com.intellij.ide.structureView.StructureViewModelBase
import com.intellij.ide.structureView.StructureViewTreeElement
import com.intellij.psi.PsiFile
import org.typedb.typeql.plugin.jetbrains.psi.*

class TypeQLStructureViewModel(psiFile: PsiFile) :
    StructureViewModelBase(psiFile, TypeQLStructureViewElement(psiFile)),
    StructureViewModel.ElementInfoProvider {

    override fun getSuitableClasses(): Array<Class<*>> = arrayOf(
        TypeQLDefineQuery::class.java,
        TypeQLUndefineQuery::class.java,
        TypeQLRedefineQuery::class.java,
        TypeQLPipelineQuery::class.java,
        TypeQLTypeDefinition::class.java,
        TypeQLDefinitionFunction::class.java,
        TypeQLDefinitionStruct::class.java,
    )

    override fun isAlwaysShowsPlus(element: StructureViewTreeElement): Boolean = false
    override fun isAlwaysLeaf(element: StructureViewTreeElement): Boolean = false
}
