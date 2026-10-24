package me.ulrich.clans.library.enumconfig.library.scanner;

import me.ulrich.clans.library.enumconfig.library.error.Mark;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/scanner/SimpleKey.class */
final class SimpleKey {
    private final int tokenNumber;
    private final boolean required;
    private final int index;
    private final int line;
    private final int column;
    private final Mark mark;

    public SimpleKey(int i, boolean z, int i2, int i3, int i4, Mark mark) {
        this.tokenNumber = i;
        this.required = z;
        this.index = i2;
        this.line = i3;
        this.column = i4;
        this.mark = mark;
    }

    public int getTokenNumber() {
        return this.tokenNumber;
    }

    public int getColumn() {
        return this.column;
    }

    public Mark getMark() {
        return this.mark;
    }

    public int getIndex() {
        return this.index;
    }

    public int getLine() {
        return this.line;
    }

    public boolean isRequired() {
        return this.required;
    }

    public String toString() {
        return "SimpleKey - tokenNumber=" + this.tokenNumber + " required=" + this.required + " index=" + this.index + " line=" + this.line + " column=" + this.column;
    }
}
