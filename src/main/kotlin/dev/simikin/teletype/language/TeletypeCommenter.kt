package dev.simikin.teletype.language

import com.intellij.lang.Commenter

class TeletypeCommenter : Commenter {
    override fun getLineCommentPrefix(): String? = null
    override fun getBlockCommentPrefix(): String = "^@"
    override fun getBlockCommentSuffix(): String = "^M"
    override fun getCommentedBlockCommentPrefix(): String = "^@"
    override fun getCommentedBlockCommentSuffix(): String = "^M"
}
