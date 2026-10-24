package me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.serializer;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/minimessage/internal/serializer/ClaimConsumer.class */
public interface ClaimConsumer {
    void style(@NotNull String str, @NotNull Emitable emitable);

    boolean component(@NotNull Emitable emitable);

    boolean styleClaimed(@NotNull String str);

    boolean componentClaimed();
}
