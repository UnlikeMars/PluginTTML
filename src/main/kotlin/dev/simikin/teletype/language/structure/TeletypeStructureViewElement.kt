package dev.simikin.teletype.language.structure

import com.intellij.ide.projectView.PresentationData
import com.intellij.ide.structureView.StructureViewTreeElement
import com.intellij.ide.util.treeView.smartTree.SortableTreeElement
import com.intellij.ide.util.treeView.smartTree.TreeElement
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.NavigatablePsiElement
import com.intellij.psi.util.PsiTreeUtil
import dev.simikin.teletype.TeletypeIcons
import dev.simikin.teletype.language.completion.TeletypeGenericCommand
import dev.simikin.teletype.language.psi.PsiTeletypeCommands
import dev.simikin.teletype.language.psi.PsiTeletypeFile
import dev.simikin.teletype.language.psi.impl.PsiTeletypeCommandsImpl

class TeletypeStructureViewElement(private val element: NavigatablePsiElement) :
    StructureViewTreeElement, SortableTreeElement {

    override fun getPresentation(): ItemPresentation {
        return element.presentation ?: PresentationData(
            element.node.text,
            TeletypeGenericCommand.fromSymbol(element.node.text)?.name?.lowercase(),
            TeletypeIcons.DOT_COMMAND,
            null
        )
    }

    override fun navigate(requestFocus: Boolean) = element.navigate(requestFocus)
    override fun canNavigate(): Boolean = element.canNavigate()
    override fun canNavigateToSource(): Boolean = element.canNavigateToSource()
    override fun getValue(): Any = element
    override fun getAlphaSortKey(): String = element.node.text

    override fun getChildren(): Array<TreeElement> {
        if (element is PsiTeletypeFile) {
            val properties: List<PsiTeletypeCommands> =
                PsiTreeUtil.getChildrenOfTypeAsList(element, PsiTeletypeCommands::class.java)
            val treeElements = ArrayList<TreeElement>(properties.size)
            for (property in properties) {
                treeElements.add(TeletypeStructureViewElement(property as PsiTeletypeCommandsImpl))
            }

            return treeElements.toArray(arrayOfNulls<TreeElement>(0))
        }
        return TreeElement.EMPTY_ARRAY
    }
}
