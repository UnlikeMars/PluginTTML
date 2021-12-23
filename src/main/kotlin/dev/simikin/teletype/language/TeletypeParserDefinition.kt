package dev.simikin.teletype.language

import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.lang.PsiParser
import com.intellij.lexer.Lexer
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet
import dev.simikin.teletype.language.parser.TeletypeParser
import dev.simikin.teletype.language.psi.PsiTeletypeFile
import dev.simikin.teletype.language.psi.TeletypeTokenTypes

class TeletypeParserDefinition: ParserDefinition {
    companion object {
        val FILE_ELEMENT_TYPE = IFileElementType(TeletypeLanguage.INSTANCE)
        val WHITE_SPACE = TokenSet.create(TokenType.WHITE_SPACE)
    }

    override fun createLexer(project: Project?): Lexer = TeletypeLexerAdapter()
    override fun createParser(project: Project?): PsiParser = TeletypeParser()
    override fun getFileNodeType(): IFileElementType = FILE_ELEMENT_TYPE
    override fun getWhitespaceTokens(): TokenSet = WHITE_SPACE
    override fun getCommentTokens(): TokenSet = TokenSet.EMPTY
    override fun getStringLiteralElements(): TokenSet = TokenSet.EMPTY
    override fun createElement(node: ASTNode): PsiElement = TeletypeTokenTypes.Factory.createElement(node)
    override fun createFile(viewProvider: FileViewProvider): PsiFile = PsiTeletypeFile(viewProvider)
}
