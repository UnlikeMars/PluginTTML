package dev.simikin.teletype.language

import com.intellij.lexer.FlexAdapter

class TeletypeLexerAdapter  : FlexAdapter(TeletypeLexer(null))
