package me.ulrich.clans.library.enumconfig.library;

import me.ulrich.clans.library.enumconfig.library.inspector.TagInspector;
import me.ulrich.clans.library.enumconfig.library.inspector.UnTrustedTagInspector;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/LoaderOptions.class */
public class LoaderOptions {
    private boolean allowDuplicateKeys = true;
    private boolean warnOnDuplicateKeys = true;
    private boolean wrappedToRootException = false;
    private int maxAliasesForCollections = 50;
    private boolean allowRecursiveKeys = false;
    private boolean processComments = false;
    private boolean enumCaseSensitive = true;
    private int nestingDepthLimit = 50;
    private int codePointLimit = 3145728;
    private boolean mergeOnCompose = false;
    private TagInspector tagInspector = new UnTrustedTagInspector();

    public final boolean isAllowDuplicateKeys() {
        return this.allowDuplicateKeys;
    }

    public void setAllowDuplicateKeys(boolean z) {
        this.allowDuplicateKeys = z;
    }

    public final boolean isWarnOnDuplicateKeys() {
        return this.warnOnDuplicateKeys;
    }

    public void setWarnOnDuplicateKeys(boolean z) {
        this.warnOnDuplicateKeys = z;
    }

    public final boolean isWrappedToRootException() {
        return this.wrappedToRootException;
    }

    public void setWrappedToRootException(boolean z) {
        this.wrappedToRootException = z;
    }

    public final int getMaxAliasesForCollections() {
        return this.maxAliasesForCollections;
    }

    public void setMaxAliasesForCollections(int i) {
        this.maxAliasesForCollections = i;
    }

    public final boolean getAllowRecursiveKeys() {
        return this.allowRecursiveKeys;
    }

    public void setAllowRecursiveKeys(boolean z) {
        this.allowRecursiveKeys = z;
    }

    public final boolean isProcessComments() {
        return this.processComments;
    }

    public LoaderOptions setProcessComments(boolean z) {
        this.processComments = z;
        return this;
    }

    public final boolean isEnumCaseSensitive() {
        return this.enumCaseSensitive;
    }

    public void setEnumCaseSensitive(boolean z) {
        this.enumCaseSensitive = z;
    }

    public final int getNestingDepthLimit() {
        return this.nestingDepthLimit;
    }

    public void setNestingDepthLimit(int i) {
        this.nestingDepthLimit = i;
    }

    public final int getCodePointLimit() {
        return this.codePointLimit;
    }

    public void setCodePointLimit(int i) {
        this.codePointLimit = i;
    }

    public boolean isMergeOnCompose() {
        return this.mergeOnCompose;
    }

    public void setMergeOnCompose(boolean z) {
        this.mergeOnCompose = z;
    }

    public TagInspector getTagInspector() {
        return this.tagInspector;
    }

    public void setTagInspector(TagInspector tagInspector) {
        this.tagInspector = tagInspector;
    }
}
