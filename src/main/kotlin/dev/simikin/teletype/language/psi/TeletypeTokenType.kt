package dev.simikin.teletype.language.psi

import com.intellij.psi.tree.IElementType
import dev.simikin.teletype.language.TeletypeLanguage

open class TeletypeTokenType(debugName: String) : IElementType(debugName, TeletypeLanguage.INSTANCE)
