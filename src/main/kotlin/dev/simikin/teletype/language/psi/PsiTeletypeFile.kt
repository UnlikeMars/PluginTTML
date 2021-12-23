package dev.simikin.teletype.language.psi

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.psi.FileViewProvider
import dev.simikin.teletype.language.TeletypeLanguage
import com.intellij.openapi.fileTypes.FileType
import dev.simikin.teletype.language.types.TeletypeFileType

class PsiTeletypeFile(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, TeletypeLanguage.INSTANCE) {
    override fun getFileType(): FileType {
        return TeletypeFileType.INSTANCE
    }
}
