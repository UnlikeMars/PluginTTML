// This is a generated file. Not intended for manual editing.
package dev.simikin.teletype.language.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static dev.simikin.teletype.language.psi.TeletypeTokenTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import dev.simikin.teletype.language.psi.*;

public class PsiTeletypeBlockCommentImpl extends ASTWrapperPsiElement implements PsiTeletypeBlockComment {

  public PsiTeletypeBlockCommentImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiTeletypeVisitor visitor) {
    visitor.visitBlockComment(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof PsiTeletypeVisitor) accept((PsiTeletypeVisitor)visitor);
    else super.accept(visitor);
  }

}
