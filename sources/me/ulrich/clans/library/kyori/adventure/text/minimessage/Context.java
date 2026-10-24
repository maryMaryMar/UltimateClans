package me.ulrich.clans.library.kyori.adventure.text.minimessage;

import me.ulrich.clans.library.kyori.adventure.pointer.Pointered;
import me.ulrich.clans.library.kyori.adventure.text.Component;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.resolver.ArgumentQueue;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.resolver.TagResolver;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/minimessage/Context.class */
@ApiStatus.NonExtendable
public interface Context {
    @Nullable
    Pointered target();

    @NotNull
    Pointered targetOrThrow();

    @NotNull
    <T extends Pointered> T targetAsType(@NotNull Class<T> cls);

    @NotNull
    Component deserialize(@NotNull String str);

    @NotNull
    Component deserialize(@NotNull String str, @NotNull TagResolver tagResolver);

    @NotNull
    Component deserialize(@NotNull String str, @NotNull TagResolver... tagResolverArr);

    @NotNull
    ParsingException newException(@NotNull String str, @NotNull ArgumentQueue argumentQueue);

    @NotNull
    ParsingException newException(@NotNull String str);

    @NotNull
    ParsingException newException(@NotNull String str, @Nullable Throwable th, @NotNull ArgumentQueue argumentQueue);

    boolean emitVirtuals();
}
