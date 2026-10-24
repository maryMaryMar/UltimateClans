package me.ulrich.clans.library.kyori.adventure.text.minimessage;

import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/minimessage/ParsingException.class */
@ApiStatus.NonExtendable
public abstract class ParsingException extends RuntimeException {
    private static final long serialVersionUID = 4502774670340827070L;
    public static final int LOCATION_UNKNOWN = -1;

    protected ParsingException(@Nullable String str) {
        super(str);
    }

    protected ParsingException(@Nullable String str, @Nullable Throwable th) {
        super(str, th);
    }

    protected ParsingException(String str, Throwable th, boolean z, boolean z2) {
        super(str, th, z, z2);
    }

    @NotNull
    public abstract String originalText();

    @Nullable
    public abstract String detailMessage();

    public abstract int startIndex();

    public abstract int endIndex();
}
