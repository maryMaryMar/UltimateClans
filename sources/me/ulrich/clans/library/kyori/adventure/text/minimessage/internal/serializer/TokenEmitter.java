package me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.serializer;

import me.ulrich.clans.library.kyori.adventure.text.Component;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/minimessage/internal/serializer/TokenEmitter.class */
public interface TokenEmitter {
    @NotNull
    TokenEmitter tag(@NotNull String str);

    @NotNull
    TokenEmitter selfClosingTag(@NotNull String str);

    @NotNull
    default TokenEmitter arguments(@NotNull String... strArr) {
        for (String str : strArr) {
            argument(str);
        }
        return this;
    }

    @NotNull
    TokenEmitter argument(@NotNull String str);

    @NotNull
    TokenEmitter argument(@NotNull String str, @NotNull QuotingOverride quotingOverride);

    @NotNull
    TokenEmitter argument(@NotNull Component component);

    @NotNull
    TokenEmitter text(@NotNull String str);

    @NotNull
    TokenEmitter pop();
}
