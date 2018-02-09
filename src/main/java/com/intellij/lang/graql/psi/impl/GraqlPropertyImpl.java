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

public class GraqlPropertyImpl extends ASTWrapperPsiElement implements GraqlProperty {

  public GraqlPropertyImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull GraqlVisitor visitor) {
    visitor.visitProperty(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof GraqlVisitor) accept((GraqlVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<GraqlCasting> getCastingList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, GraqlCasting.class);
  }

  @Override
  @Nullable
  public GraqlId getId() {
    return findChildByClass(GraqlId.class);
  }

  @Override
  @Nullable
  public GraqlLabel getLabel() {
    return findChildByClass(GraqlLabel.class);
  }

  @Override
  @Nullable
  public GraqlPatterns getPatterns() {
    return findChildByClass(GraqlPatterns.class);
  }

  @Override
  @Nullable
  public GraqlPredicate getPredicate() {
    return findChildByClass(GraqlPredicate.class);
  }

  @Override
  @Nullable
  public GraqlVarPatterns getVarPatterns() {
    return findChildByClass(GraqlVarPatterns.class);
  }

  @Override
  @Nullable
  public GraqlVariable getVariable() {
    return findChildByClass(GraqlVariable.class);
  }

  @Override
  @Nullable
  public PsiElement getDatatype() {
    return findChildByType(DATATYPE);
  }

  @Override
  @Nullable
  public PsiElement getRegex() {
    return findChildByType(REGEX);
  }

}
