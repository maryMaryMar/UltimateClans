package me.ulrich.clans.data;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/data/AnvilResult.class */
public class AnvilResult {
    private final Type type;
    private final String input;

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/data/AnvilResult$Type.class */
    public enum Type {
        CLOSE,
        CANCELLED,
        COMPLETED,
        REPLACED
    }

    public AnvilResult(Type type, String str) {
        this.type = type;
        this.input = str;
    }

    public Type getType() {
        return this.type;
    }

    public String getInput() {
        return this.input;
    }

    public static AnvilResult close(String str) {
        return new AnvilResult(Type.CLOSE, str);
    }

    public static AnvilResult completed(String str) {
        return new AnvilResult(Type.COMPLETED, str);
    }
}
