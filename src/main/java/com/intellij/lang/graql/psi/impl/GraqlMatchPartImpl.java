// This is a generated file. Not intended for manual editing.
package com.intellij.lang.graql.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.intellij.lang.graql.psi.GraqlTokenTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.graql.psi.*;

public class GraqlMatchPartImpl extends ASTWrapperPsiElement implements GraqlMatchPart {

  public GraqlMatchPartImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull GraqlVisitor visitor) {
    visitor.visitMatchPart(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof GraqlVisitor) accept((GraqlVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public GraqlMatchPart getMatchPart() {
    return findChildByClass(GraqlMatchPart.class);
  }

  @Override
  @Nullable
  public GraqlPatterns getPatterns() {
    return findChildByClass(GraqlPatterns.class);
  }

  @Override
  @Nullable
  public PsiElement getInteger() {
    return findChildByType(INTEGER);
  }

  @Override
  @Nullable
  public PsiElement getOrder() {
    return findChildByType(ORDER);
  }

  @Override
  @Nullable
  public PsiElement getVariable() {
    return findChildByType(VARIABLE);
  }

}
