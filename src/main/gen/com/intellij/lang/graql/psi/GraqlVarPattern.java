// This is a generated file. Not intended for manual editing.
package com.intellij.lang.graql.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface GraqlVarPattern extends GraqlPattern {

  @NotNull
  List<GraqlBlockContents> getBlockContentsList();

  @Nullable
  GraqlLabelOrVar getLabelOrVar();

  @NotNull
  List<GraqlProperty> getPropertyList();

}
