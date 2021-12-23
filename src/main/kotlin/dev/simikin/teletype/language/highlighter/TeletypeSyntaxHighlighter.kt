package dev.simikin.teletype.language.highlighter

import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.tree.IElementType
import com.intellij.psi.tree.TokenSet
import dev.simikin.teletype.language.TeletypeLexerAdapter
import dev.simikin.teletype.language.psi.TeletypeTokenTypes

class TeletypeSyntaxHighlighter : SyntaxHighlighterBase() {
    companion object {
        private val attributeMap: MutableMap<IElementType, TextAttributesKey> = HashMap(50)
    }

    init {
        val brackets = TokenSet.create(TeletypeTokenTypes.LBRACKET, TeletypeTokenTypes.RBRACKET)
        val parentheses = TokenSet.create(TeletypeTokenTypes.LPARENTH, TeletypeTokenTypes.RPARENTH)
        val braces = TokenSet.create(TeletypeTokenTypes.LBRACE, TeletypeTokenTypes.RBRACE)

        val comments = TokenSet.create(
            TeletypeTokenTypes.COMMENT_START,
            TeletypeTokenTypes.COMMENT_END,
            TeletypeTokenTypes.COMMENT_CHARACTERS
        )

        val commands = TokenSet.create(TeletypeTokenTypes.COMMAND, TeletypeTokenTypes.COLOR_COMMAND)
        val operators = TokenSet.create(
            TeletypeTokenTypes.PLUS, TeletypeTokenTypes.MINUS, TeletypeTokenTypes.EQUALS,
            TeletypeTokenTypes.STAR, TeletypeTokenTypes.GREATER, TeletypeTokenTypes.SMALLER
        )

        fillMap(attributeMap, brackets, DefaultLanguageHighlighterColors.BRACKETS)
        fillMap(attributeMap, parentheses, DefaultLanguageHighlighterColors.PARENTHESES)
        fillMap(attributeMap, braces, DefaultLanguageHighlighterColors.BRACES)
        fillMap(attributeMap, comments, DefaultLanguageHighlighterColors.BLOCK_COMMENT)

        fillMap(attributeMap, commands, DefaultLanguageHighlighterColors.KEYWORD)
        fillMap(attributeMap, operators, DefaultLanguageHighlighterColors.OPERATION_SIGN)

        attributeMap[TeletypeTokenTypes.DOT] = DefaultLanguageHighlighterColors.DOT
        attributeMap[TeletypeTokenTypes.COMMA] = DefaultLanguageHighlighterColors.COMMA
        attributeMap[TeletypeTokenTypes.SEMICOLON] = DefaultLanguageHighlighterColors.SEMICOLON
    }

    override fun getHighlightingLexer(): Lexer = TeletypeLexerAdapter()
    override fun getTokenHighlights(tokenType: IElementType): Array<TextAttributesKey> = pack(attributeMap[tokenType])
}
