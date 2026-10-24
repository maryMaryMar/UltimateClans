package me.ulrich.clans.library.kyori.adventure.text;

import java.util.stream.Stream;
import me.ulrich.clans.library.kyori.adventure.text.NBTComponent;
import me.ulrich.clans.library.kyori.adventure.text.NBTComponentBuilder;
import me.ulrich.clans.library.kyori.examination.ExaminableProperty;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/NBTComponent.class */
public interface NBTComponent<C extends NBTComponent<C, B>, B extends NBTComponentBuilder<C, B>> extends BuildableComponent<C, B> {
    @NotNull
    String nbtPath();

    @Contract(pure = true)
    @NotNull
    C nbtPath(@NotNull String str);

    boolean interpret();

    @Contract(pure = true)
    @NotNull
    C interpret(boolean z);

    @Nullable
    Component separator();

    @NotNull
    C separator(@Nullable ComponentLike componentLike);

    @Override // me.ulrich.clans.library.kyori.adventure.text.Component, me.ulrich.clans.library.kyori.examination.Examinable
    @NotNull
    default Stream<? extends ExaminableProperty> examinableProperties() {
        return Stream.concat(Stream.of((Object[]) new ExaminableProperty[]{ExaminableProperty.of("nbtPath", nbtPath()), ExaminableProperty.of("interpret", interpret()), ExaminableProperty.of("separator", separator())}), super.examinableProperties());
    }
}
