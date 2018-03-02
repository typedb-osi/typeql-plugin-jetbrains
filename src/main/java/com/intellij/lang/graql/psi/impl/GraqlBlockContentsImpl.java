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

public class GraqlBlockContentsImpl extends ASTWrapperPsiElement implements GraqlBlockContents {

  public GraqlBlockContentsImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull GraqlVisitor visitor) {
    visitor.visitBlockContents(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof GraqlVisitor) accept((GraqlVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<GraqlEscapedExpression> getEscapedExpressionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, GraqlEscapedExpression.class);
  }

  @Override
  @NotNull
  public List<GraqlPatterns> getPatternsList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, GraqlPatterns.class);
  }

  @Override
  @NotNull
  public List<GraqlQuery> getQueryList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, GraqlQuery.class);
  }

  @Override
  @NotNull
  public List<GraqlStatement> getStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, GraqlStatement.class);
  }

}
