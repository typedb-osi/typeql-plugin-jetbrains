// This is a generated file. Not intended for manual editing.
package com.intellij.lang.graql.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.intellij.lang.graql.psi.GraqlTokenTypes.*;
import com.intellij.lang.graql.psi.*;

public class GraqlIdentifierImpl extends GraqlNamedElementImpl implements GraqlIdentifier {

  public GraqlIdentifierImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull GraqlVisitor visitor) {
    visitor.visitIdentifier(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof GraqlVisitor) accept((GraqlVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public PsiElement getId() {
    return findChildByType(ID);
  }

  @Override
  @Nullable
  public PsiElement getString() {
    return findChildByType(STRING);
  }

  public String getName() {
    return GraqlPsiImplUtil.getName(this);
  }

  public PsiElement setName(String newName) {
    return GraqlPsiImplUtil.setName(this, newName);
  }

  public PsiElement getNameIdentifier() {
    return GraqlPsiImplUtil.getNameIdentifier(this);
  }

}
