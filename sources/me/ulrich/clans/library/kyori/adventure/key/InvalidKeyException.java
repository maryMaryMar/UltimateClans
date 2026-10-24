package me.ulrich.clans.library.kyori.adventure.key;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/key/InvalidKeyException.class */
public final class InvalidKeyException extends RuntimeException {
    private static final long serialVersionUID = -5413304087321449434L;
    private final String keyNamespace;
    private final String keyValue;

    InvalidKeyException(@NotNull String str, @NotNull String str2, @Nullable String str3) {
        super(str3);
        this.keyNamespace = str;
        this.keyValue = str2;
    }

    @NotNull
    public final String keyNamespace() {
        return this.keyNamespace;
    }

    @NotNull
    public final String keyValue() {
        return this.keyValue;
    }
}
