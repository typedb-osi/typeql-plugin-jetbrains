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

public class GraqlDefineExpressionImpl extends ASTWrapperPsiElement implements GraqlDefineExpression {

  public GraqlDefineExpressionImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull GraqlVisitor visitor) {
    visitor.visitDefineExpression(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof GraqlVisitor) accept((GraqlVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<GraqlExpression> getExpressionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, GraqlExpression.class);
  }

  @Override
  @Nullable
  public GraqlLiteralExpr getLiteralExpr() {
    return findChildByClass(GraqlLiteralExpr.class);
  }

}
