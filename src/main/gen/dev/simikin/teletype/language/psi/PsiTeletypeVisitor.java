// This is a generated file. Not intended for manual editing.
package dev.simikin.teletype.language.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiElement;

public class PsiTeletypeVisitor extends PsiElementVisitor {

  public void visitBlockComment(@NotNull PsiTeletypeBlockComment o) {
    visitPsiElement(o);
  }

  public void visitCommands(@NotNull PsiTeletypeCommands o) {
    visitPsiElement(o);
  }

  public void visitHyperlink(@NotNull PsiTeletypeHyperlink o) {
    visitPsiElement(o);
  }

  public void visitMathElements(@NotNull PsiTeletypeMathElements o) {
    visitPsiElement(o);
  }

  public void visitText(@NotNull PsiTeletypeText o) {
    visitPsiElement(o);
  }

  public void visitPsiElement(@NotNull PsiElement o) {
    visitElement(o);
  }

}
