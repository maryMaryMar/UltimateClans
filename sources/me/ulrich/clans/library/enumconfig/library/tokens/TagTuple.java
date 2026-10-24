package me.ulrich.clans.library.enumconfig.library.tokens;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/tokens/TagTuple.class */
public final class TagTuple {
    private final String handle;
    private final String suffix;

    public TagTuple(String str, String str2) {
        if (str2 == null) {
            throw new NullPointerException("Suffix must be provided.");
        }
        this.handle = str;
        this.suffix = str2;
    }

    public String getHandle() {
        return this.handle;
    }

    public String getSuffix() {
        return this.suffix;
    }
}
