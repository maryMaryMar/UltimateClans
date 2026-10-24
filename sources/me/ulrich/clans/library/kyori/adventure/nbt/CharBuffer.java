package me.ulrich.clans.library.kyori.adventure.nbt;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/nbt/CharBuffer.class */
final class CharBuffer {
    private final CharSequence sequence;
    private int index;

    CharBuffer(CharSequence charSequence) {
        this.sequence = charSequence;
    }

    public char peek() {
        return this.sequence.charAt(this.index);
    }

    public char peek(int i) {
        return this.sequence.charAt(this.index + i);
    }

    public char take() {
        CharSequence charSequence = this.sequence;
        int i = this.index;
        this.index = i + 1;
        return charSequence.charAt(i);
    }

    public boolean advance() {
        this.index++;
        return hasMore();
    }

    public boolean hasMore() {
        return this.index < this.sequence.length();
    }

    public boolean hasMore(int i) {
        return this.index + i < this.sequence.length();
    }

    public CharSequence takeUntil(char c) throws StringTagParseException {
        char lowerCase = Character.toLowerCase(c);
        int i = -1;
        int i2 = this.index;
        while (i2 < this.sequence.length()) {
            if (this.sequence.charAt(i2) == '\\') {
                i2++;
            } else if (Character.toLowerCase(this.sequence.charAt(i2)) == lowerCase) {
                i = i2;
                break;
            }
            i2++;
        }
        if (i == -1) {
            throw makeError("No occurrence of " + lowerCase + " was found");
        }
        CharSequence charSequenceSubSequence = this.sequence.subSequence(this.index, i);
        this.index = i + 1;
        return charSequenceSubSequence;
    }

    public CharBuffer expect(char c) throws StringTagParseException {
        skipWhitespace();
        if (!hasMore()) {
            throw makeError("Expected character '" + c + "' but got EOF");
        }
        if (peek() != c) {
            throw makeError("Expected character '" + c + "' but got '" + peek() + "'");
        }
        take();
        return this;
    }

    public boolean takeIf(char c) {
        skipWhitespace();
        if (!hasMore() || peek() != c) {
            return false;
        }
        advance();
        return true;
    }

    public CharBuffer skipWhitespace() {
        while (hasMore() && Character.isWhitespace(peek())) {
            advance();
        }
        return this;
    }

    public StringTagParseException makeError(String str) {
        return new StringTagParseException(str, this.sequence, this.index);
    }
}
