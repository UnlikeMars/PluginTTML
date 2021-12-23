package dev.simikin.teletype.language.highlighter

import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighter
import com.intellij.openapi.options.colors.AttributesDescriptor
import com.intellij.openapi.options.colors.ColorDescriptor
import com.intellij.openapi.options.colors.ColorSettingsPage
import dev.simikin.teletype.TeletypeIcons
import javax.swing.Icon

class TeletypeColorSettingsPage : ColorSettingsPage {

    companion object {
        private val DESCRIPTORS = arrayOf(
            AttributesDescriptor("Keyword", DefaultLanguageHighlighterColors.KEYWORD),
            AttributesDescriptor("Dot", DefaultLanguageHighlighterColors.DOT),
            AttributesDescriptor("Comma", DefaultLanguageHighlighterColors.COMMA),
            AttributesDescriptor("Semicolon", DefaultLanguageHighlighterColors.SEMICOLON),
            AttributesDescriptor("Operators", DefaultLanguageHighlighterColors.OPERATION_SIGN),
            AttributesDescriptor("Comments", DefaultLanguageHighlighterColors.BLOCK_COMMENT),
        )
    }

    override fun getAttributeDescriptors(): Array<AttributesDescriptor> = DESCRIPTORS
    override fun getColorDescriptors(): Array<ColorDescriptor> = ColorDescriptor.EMPTY_ARRAY
    override fun getDisplayName(): String = "Teletype"
    override fun getIcon(): Icon = TeletypeIcons.FILE
    override fun getHighlighter(): SyntaxHighlighter = TeletypeSyntaxHighlighter()

    override fun getDemoText(): String {
        return """
            ^F^W^V^ATTML: TeleType Markup Language^
            ^ATTML^B text is a ASCII, scientific mathematical language: 2 * 2 + 4 = 8
            <!-- characters such as ^ and ^^ are used for masking commands. -->
            Did you know that . , and ; can have different colors in this editor?
               """.trimIndent()
    }

    override fun getAdditionalHighlightingTagToDescriptorMap(): MutableMap<String, TextAttributesKey>? = null
}
