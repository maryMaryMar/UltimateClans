package me.ulrich.clans.library.kyori.adventure.text;

import me.ulrich.clans.library.kyori.adventure.text.NBTComponent;
import me.ulrich.clans.library.kyori.adventure.text.NBTComponentBuilder;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/NBTComponentBuilder.class */
public interface NBTComponentBuilder<C extends NBTComponent<C, B>, B extends NBTComponentBuilder<C, B>> extends ComponentBuilder<C, B> {
    @Contract("_ -> this")
    @NotNull
    B nbtPath(@NotNull String str);

    @Contract("_ -> this")
    @NotNull
    B interpret(boolean z);

    @Contract("_ -> this")
    @NotNull
    B separator(@Nullable ComponentLike componentLike);
}
