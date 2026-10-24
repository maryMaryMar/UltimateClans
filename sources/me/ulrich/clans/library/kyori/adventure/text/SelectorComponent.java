package me.ulrich.clans.library.kyori.adventure.text;

import java.util.stream.Stream;
import me.ulrich.clans.library.kyori.examination.ExaminableProperty;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/SelectorComponent.class */
public interface SelectorComponent extends BuildableComponent<SelectorComponent, Builder>, ScopedComponent<SelectorComponent> {

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/SelectorComponent$Builder.class */
    public interface Builder extends ComponentBuilder<SelectorComponent, Builder> {
        @Contract("_ -> this")
        @NotNull
        Builder pattern(@NotNull String str);

        @Contract("_ -> this")
        @NotNull
        Builder separator(@Nullable ComponentLike componentLike);
    }

    @NotNull
    String pattern();

    @Contract(pure = true)
    @NotNull
    SelectorComponent pattern(@NotNull String str);

    @Nullable
    Component separator();

    @NotNull
    SelectorComponent separator(@Nullable ComponentLike componentLike);

    @Override // me.ulrich.clans.library.kyori.adventure.text.Component, me.ulrich.clans.library.kyori.examination.Examinable
    @NotNull
    default Stream<? extends ExaminableProperty> examinableProperties() {
        return Stream.concat(Stream.of((Object[]) new ExaminableProperty[]{ExaminableProperty.of("pattern", pattern()), ExaminableProperty.of("separator", separator())}), super.examinableProperties());
    }
}
