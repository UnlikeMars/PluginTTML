package dev.simikin.teletype.language.types

import com.intellij.openapi.fileTypes.LanguageFileType
import dev.simikin.teletype.TeletypeIcons
import dev.simikin.teletype.language.TeletypeLanguage

class TeletypeFileType : LanguageFileType(TeletypeLanguage.INSTANCE) {
    companion object {
        val INSTANCE = TeletypeFileType()
        const val EXTENSION = "ttml"
    }

    override fun getName() = "Teletype"
    override fun getDescription() = "Teletype language file"
    override fun getDefaultExtension() = EXTENSION
    override fun getIcon() = TeletypeIcons.FILE
}
