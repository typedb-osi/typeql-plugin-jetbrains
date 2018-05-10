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

public class GraqlBoolImpl extends ASTWrapperPsiElement implements GraqlBool {

  public GraqlBoolImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull GraqlVisitor visitor) {
    visitor.visitBool(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof GraqlVisitor) accept((GraqlVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public GraqlAndBool getAndBool() {
    return findChildByClass(GraqlAndBool.class);
  }

  @Override
  @NotNull
  public List<GraqlExpression> getExpressionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, GraqlExpression.class);
  }

  @Override
  @Nullable
  public GraqlGroupBool getGroupBool() {
    return findChildByClass(GraqlGroupBool.class);
  }

  @Override
  @Nullable
  public GraqlNotBool getNotBool() {
    return findChildByClass(GraqlNotBool.class);
  }

  @Override
  @NotNull
  public List<GraqlNumber> getNumberList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, GraqlNumber.class);
  }

  @Override
  @Nullable
  public GraqlOrBool getOrBool() {
    return findChildByClass(GraqlOrBool.class);
  }

  @Override
  @Nullable
  public GraqlUntypedExpression getUntypedExpression() {
    return findChildByClass(GraqlUntypedExpression.class);
  }

}
