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

public class GraqlNumberImpl extends ASTWrapperPsiElement implements GraqlNumber {

  public GraqlNumberImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull GraqlVisitor visitor) {
    visitor.visitNumber(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof GraqlVisitor) accept((GraqlVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public GraqlDouble_ getDouble_() {
    return findChildByClass(GraqlDouble_.class);
  }

  @Override
  @Nullable
  public GraqlInt_ getInt_() {
    return findChildByClass(GraqlInt_.class);
  }

  @Override
  @Nullable
  public GraqlUntypedExpression getUntypedExpression() {
    return findChildByClass(GraqlUntypedExpression.class);
  }

}