// This is a generated file. Not intended for manual editing.
package com.intellij.lang.graql.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface GraqlStatement extends PsiElement {

  @Nullable
  GraqlForEachStatement getForEachStatement();

  @Nullable
  GraqlForInStatement getForInStatement();

  @Nullable
  GraqlIfStatement getIfStatement();

}
