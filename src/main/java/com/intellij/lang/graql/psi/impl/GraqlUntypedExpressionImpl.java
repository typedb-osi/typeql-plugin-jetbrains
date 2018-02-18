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

public class GraqlUntypedExpressionImpl extends ASTWrapperPsiElement implements GraqlUntypedExpression {

  public GraqlUntypedExpressionImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull GraqlVisitor visitor) {
    visitor.visitUntypedExpression(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof GraqlVisitor) accept((GraqlVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public GraqlIdMacro getIdMacro() {
    return findChildByClass(GraqlIdMacro.class);
  }

  @Override
  @Nullable
  public GraqlMacroEquals getMacroEquals() {
    return findChildByClass(GraqlMacroEquals.class);
  }

  @Override
  @Nullable
  public GraqlMacroNoescp getMacroNoescp() {
    return findChildByClass(GraqlMacroNoescp.class);
  }

  @Override
  @NotNull
  public List<GraqlAccessor> getAccessorList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, GraqlAccessor.class);
  }

  @Override
  @NotNull
  public List<GraqlExpression> getExpressionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, GraqlExpression.class);
  }

  @Override
  @Nullable
  public GraqlId getId() {
    return findChildByClass(GraqlId.class);
  }

}
