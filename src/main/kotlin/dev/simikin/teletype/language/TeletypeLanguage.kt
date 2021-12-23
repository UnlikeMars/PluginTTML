package dev.simikin.teletype.language

import com.intellij.lang.Language

class TeletypeLanguage : Language("TTML") {
    companion object {
        val INSTANCE = TeletypeLanguage()
    }

    override fun getDisplayName() = "Teletype"
}
