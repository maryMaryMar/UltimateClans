package me.ulrich.clans.library.kyori.adventure.nbt;

import java.io.IOException;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/nbt/StringTagParseException.class */
class StringTagParseException extends IOException {
    private static final long serialVersionUID = -3001637554903912905L;
    private final CharSequence buffer;
    private final int position;

    StringTagParseException(String str, CharSequence charSequence, int i) {
        super(str);
        this.buffer = charSequence;
        this.position = i;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return super.getMessage() + "(at position " + this.position + ")";
    }
}
