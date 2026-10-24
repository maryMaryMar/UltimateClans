package me.ulrich.clans.library.enumconfig.library.emitter;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/emitter/ScalarAnalysis.class */
public final class ScalarAnalysis {
    private final String scalar;
    private final boolean empty;
    private final boolean multiline;
    private final boolean allowFlowPlain;
    private final boolean allowBlockPlain;
    private final boolean allowSingleQuoted;
    private final boolean allowBlock;

    public ScalarAnalysis(String str, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        this.scalar = str;
        this.empty = z;
        this.multiline = z2;
        this.allowFlowPlain = z3;
        this.allowBlockPlain = z4;
        this.allowSingleQuoted = z5;
        this.allowBlock = z6;
    }

    public String getScalar() {
        return this.scalar;
    }

    public boolean isEmpty() {
        return this.empty;
    }

    public boolean isMultiline() {
        return this.multiline;
    }

    public boolean isAllowFlowPlain() {
        return this.allowFlowPlain;
    }

    public boolean isAllowBlockPlain() {
        return this.allowBlockPlain;
    }

    public boolean isAllowSingleQuoted() {
        return this.allowSingleQuoted;
    }

    public boolean isAllowBlock() {
        return this.allowBlock;
    }
}
