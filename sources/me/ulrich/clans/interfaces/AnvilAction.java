package me.ulrich.clans.interfaces;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/interfaces/AnvilAction.class */
public class AnvilAction {
    private final Type type;
    private final String text;

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/interfaces/AnvilAction$Type.class */
    public enum Type {
        CLOSE,
        KEEP_OPEN,
        UPDATE_TEXT
    }

    public AnvilAction(Type type, String str) {
        this.type = type;
        this.text = str;
    }

    public Type getType() {
        return this.type;
    }

    public String getText() {
        return this.text;
    }

    public static AnvilAction close() {
        return new AnvilAction(Type.CLOSE, null);
    }

    public static AnvilAction keep() {
        return new AnvilAction(Type.KEEP_OPEN, null);
    }

    public static AnvilAction update(String str) {
        return new AnvilAction(Type.UPDATE_TEXT, str);
    }
}
