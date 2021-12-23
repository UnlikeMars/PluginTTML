package dev.simikin.teletype.language.highlighter

import com.intellij.codeInsight.highlighting.PairedBraceMatcherAdapter
import com.intellij.lang.BracePair
import com.intellij.lang.PairedBraceMatcher
import com.intellij.psi.PsiFile
import com.intellij.psi.tree.IElementType
import dev.simikin.teletype.language.TeletypeLanguage
import dev.simikin.teletype.language.psi.TeletypeTokenTypes

class TeletypePairedBraceMatcher : PairedBraceMatcherAdapter(LatexBraceMatcher(), TeletypeLanguage.INSTANCE) {
    private class LatexBraceMatcher : PairedBraceMatcher {
        companion object {
            private val BRACE_PAIRS = arrayOf(
                BracePair(TeletypeTokenTypes.LPARENTH, TeletypeTokenTypes.RPARENTH, false),
                BracePair(TeletypeTokenTypes.LBRACKET, TeletypeTokenTypes.RBRACKET, false),
                BracePair(TeletypeTokenTypes.LBRACE, TeletypeTokenTypes.RBRACE, false)
            )
        }

        override fun getPairs(): Array<BracePair> = BRACE_PAIRS

        override fun isPairedBracesAllowedBeforeType(lbraceType: IElementType, contextType: IElementType?): Boolean {
            return true
        }

        override fun getCodeConstructStart(file: PsiFile, openingBraceOffset: Int): Int {
            return openingBraceOffset
        }
    }
}
