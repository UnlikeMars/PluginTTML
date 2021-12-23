package dev.simikin.teletype.language.completion

import com.intellij.codeInsight.completion.CompletionContributor
import com.intellij.codeInsight.completion.CompletionType
import com.intellij.patterns.PlatformPatterns
import dev.simikin.teletype.language.TeletypeLanguage

open class TeletypeCompletionContributor : CompletionContributor() {

    init {
        registerGenericCommandCompletion()
    }

    private fun registerGenericCommandCompletion() = extend(
        CompletionType.BASIC,
        PlatformPatterns.psiElement().withLanguage(TeletypeLanguage.INSTANCE), // no specific environment
        TeletypeCommandsCompletionProvider()
    )
}
