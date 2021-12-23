package dev.simikin.teletype.language.completion

import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionProvider
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.util.ProcessingContext
import com.intellij.codeInsight.lookup.LookupElementBuilder
import dev.simikin.teletype.TeletypeIcons

class TeletypeCommandsCompletionProvider : CompletionProvider<CompletionParameters>() {
    override fun addCompletions(
        parameters: CompletionParameters,
        context: ProcessingContext,
        result: CompletionResultSet
    ) {
        addGenericCommands(result)
    }

    private fun createCommandLookupElements(command: TeletypeGenericCommand): LookupElementBuilder {
        return LookupElementBuilder.create(command, command.command)
            .withPresentableText(command.command)
            .bold()
            .withTailText(command.name.lowercase(), true)
            .withTypeText(command.key)
            .withIcon(TeletypeIcons.DOT_COMMAND)
    }

    private fun addGenericCommands(result: CompletionResultSet) {
        TeletypeGenericCommand.values().forEach { genericCommand ->
            result.addElement(createCommandLookupElements(genericCommand))
        }
    }
}
