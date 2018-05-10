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
  public GraqlBlockContents getBlockContents() {
    return findChildByClass(GraqlBlockContents.class);
  }

  @Override
  @Nullable
  public GraqlMatchLimitOffset getMatchLimitOffset() {
    return findChildByClass(GraqlMatchLimitOffset.class);
  }

  @Override
  @Nullable
  public GraqlMatchOffsetLimit getMatchOffsetLimit() {
    return findChildByClass(GraqlMatchOffsetLimit.class);
  }

  @Override
  @Nullable
  public GraqlMatchOrderBy getMatchOrderBy() {
    return findChildByClass(GraqlMatchOrderBy.class);
  }

  @Override
  @NotNull
  public GraqlPatterns getPatterns() {
    return findNotNullChildByClass(GraqlPatterns.class);
  }

}
