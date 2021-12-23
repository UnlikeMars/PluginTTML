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

public class PsiTeletypeCommandsImpl extends ASTWrapperPsiElement implements PsiTeletypeCommands {

  public PsiTeletypeCommandsImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiTeletypeVisitor visitor) {
    visitor.visitCommands(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof PsiTeletypeVisitor) accept((PsiTeletypeVisitor)visitor);
    else super.accept(visitor);
  }

}
