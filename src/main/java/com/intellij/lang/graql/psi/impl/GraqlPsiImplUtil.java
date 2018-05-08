package com.intellij.lang.graql.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.lang.graql.GraqlFileType;
import com.intellij.lang.graql.psi.GraqlElementFactory;
import com.intellij.lang.graql.psi.GraqlFile;
import com.intellij.lang.graql.psi.GraqlIdentifier;
import com.intellij.lang.graql.psi.GraqlTokenTypes;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiManager;
import com.intellij.psi.search.FileTypeIndex;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.util.indexing.FileBasedIndex;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author github.com/BFergerson
 */
public class GraqlPsiImplUtil {

    public static List<GraqlIdentifier> findIdentifiers(Project project, String name) {
        List<GraqlIdentifier> result = null;
        Collection<VirtualFile> virtualFiles =
                FileBasedIndex.getInstance().getContainingFiles(FileTypeIndex.NAME, GraqlFileType.INSTANCE,
                        GlobalSearchScope.allScope(project));
        for (VirtualFile virtualFile : virtualFiles) {
            GraqlFile graqlFile = (GraqlFile) PsiManager.getInstance(project).findFile(virtualFile);
            if (graqlFile != null) {
                Collection<GraqlIdentifier> identifiers = PsiTreeUtil.collectElementsOfType(
                        graqlFile, GraqlIdentifier.class);
                for (GraqlIdentifier identifier : identifiers) {
                    if (name.equals(identifier.getName())) {
                        if (result == null) {
                            result = new ArrayList<>();
                        }
                        result.add(identifier);
                    }
                }
            }
        }
        return result != null ? result : Collections.emptyList();
    }

    public static List<GraqlIdentifier> findIdentifiers(Project project) {
        List<GraqlIdentifier> result = null;
        Collection<VirtualFile> virtualFiles =
                FileBasedIndex.getInstance().getContainingFiles(FileTypeIndex.NAME, GraqlFileType.INSTANCE,
                        GlobalSearchScope.allScope(project));
        for (VirtualFile virtualFile : virtualFiles) {
            GraqlFile graqlFile = (GraqlFile) PsiManager.getInstance(project).findFile(virtualFile);
            if (graqlFile != null) {
                Collection<GraqlIdentifier> identifiers = PsiTreeUtil.collectElementsOfType(
                        graqlFile, GraqlIdentifier.class);
                for (GraqlIdentifier identifier : identifiers) {
                    if (result == null) {
                        result = new ArrayList<>();
                    }
                    result.add(identifier);
                }
            }
        }
        return result != null ? result : Collections.emptyList();
    }

    public static String getName(GraqlIdentifier element) {
        return element.getText();
    }

    public static PsiElement setName(GraqlIdentifier element, String newName) {
        ASTNode keyNode = element.getNode().findChildByType(GraqlTokenTypes.IDENTIFIER);
        if (keyNode == null) {
            keyNode = element.getNode().findChildByType(GraqlTokenTypes.STRING_LITERAL);
        }
        if (keyNode != null) {
            GraqlIdentifier property = GraqlElementFactory.createIdentifier(element.getProject(), newName);
            ASTNode newKeyNode = property.getFirstChild().getNode();
            element.getNode().replaceChild(keyNode, newKeyNode);
        }
        return element;
    }

    public static PsiElement getNameIdentifier(GraqlIdentifier element) {
        return element;
    }
}
