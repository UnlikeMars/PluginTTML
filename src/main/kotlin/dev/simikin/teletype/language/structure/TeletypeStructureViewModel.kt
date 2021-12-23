package dev.simikin.teletype.language.structure

import com.intellij.ide.structureView.StructureViewModel
import com.intellij.ide.structureView.StructureViewModelBase
import com.intellij.ide.structureView.StructureViewTreeElement
import com.intellij.ide.util.treeView.smartTree.Sorter
import com.intellij.psi.PsiFile

class TeletypeStructureViewModel(psiFile: PsiFile) :
    StructureViewModelBase(psiFile, TeletypeStructureViewElement(psiFile)), StructureViewModel.ElementInfoProvider {

    override fun isAlwaysShowsPlus(element: StructureViewTreeElement?): Boolean = false
    override fun isAlwaysLeaf(element: StructureViewTreeElement?): Boolean = false
    override fun getSorters(): Array<Sorter> = arrayOf(Sorter.ALPHA_SORTER)
}
