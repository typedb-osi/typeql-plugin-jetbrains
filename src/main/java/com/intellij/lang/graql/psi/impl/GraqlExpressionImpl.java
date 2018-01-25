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

public class GraqlExpressionImpl extends ASTWrapperPsiElement implements GraqlExpression {

  public GraqlExpressionImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull GraqlVisitor visitor) {
    visitor.visitExpression(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof GraqlVisitor) accept((GraqlVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public GraqlAttributeExpression getAttributeExpression() {
    return findChildByClass(GraqlAttributeExpression.class);
  }

  @Override
  @Nullable
  public GraqlCommitExpression getCommitExpression() {
    return findChildByClass(GraqlCommitExpression.class);
  }

  @Override
  @Nullable
  public GraqlEqualityExpression getEqualityExpression() {
    return findChildByClass(GraqlEqualityExpression.class);
  }

  @Override
  @Nullable
  public GraqlHasExpression getHasExpression() {
    return findChildByClass(GraqlHasExpression.class);
  }

  @Override
  @Nullable
  public GraqlHasValueExpression getHasValueExpression() {
    return findChildByClass(GraqlHasValueExpression.class);
  }

  @Override
  @Nullable
  public GraqlIsaExpression getIsaExpression() {
    return findChildByClass(GraqlIsaExpression.class);
  }

  @Override
  @Nullable
  public GraqlKeyExpression getKeyExpression() {
    return findChildByClass(GraqlKeyExpression.class);
  }

  @Override
  @Nullable
  public GraqlLabelExpression getLabelExpression() {
    return findChildByClass(GraqlLabelExpression.class);
  }

  @Override
  @Nullable
  public GraqlPlaysExpression getPlaysExpression() {
    return findChildByClass(GraqlPlaysExpression.class);
  }

  @Override
  @Nullable
  public GraqlRelatesExpression getRelatesExpression() {
    return findChildByClass(GraqlRelatesExpression.class);
  }

  @Override
  @Nullable
  public GraqlRelationExpression getRelationExpression() {
    return findChildByClass(GraqlRelationExpression.class);
  }

  @Override
  @Nullable
  public GraqlRuleExpression getRuleExpression() {
    return findChildByClass(GraqlRuleExpression.class);
  }

  @Override
  @Nullable
  public GraqlSubExpression getSubExpression() {
    return findChildByClass(GraqlSubExpression.class);
  }

}
