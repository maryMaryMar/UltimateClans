package me.ulrich.clans.library.kyori.adventure.text;

import java.util.stream.Stream;
import me.ulrich.clans.library.kyori.examination.ExaminableProperty;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/ScoreComponent.class */
public interface ScoreComponent extends BuildableComponent<ScoreComponent, Builder>, ScopedComponent<ScoreComponent> {

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/ScoreComponent$Builder.class */
    public interface Builder extends ComponentBuilder<ScoreComponent, Builder> {
        @Contract("_ -> this")
        @NotNull
        Builder name(@NotNull String str);

        @Contract("_ -> this")
        @NotNull
        Builder objective(@NotNull String str);

        @Contract("_ -> this")
        @Deprecated
        @NotNull
        Builder value(@Nullable String str);
    }

    @NotNull
    String name();

    @Contract(pure = true)
    @NotNull
    ScoreComponent name(@NotNull String str);

    @NotNull
    String objective();

    @Contract(pure = true)
    @NotNull
    ScoreComponent objective(@NotNull String str);

    @Deprecated
    @Nullable
    String value();

    @Contract(pure = true)
    @Deprecated
    @NotNull
    ScoreComponent value(@Nullable String str);

    @Override // me.ulrich.clans.library.kyori.adventure.text.Component, me.ulrich.clans.library.kyori.examination.Examinable
    @NotNull
    default Stream<? extends ExaminableProperty> examinableProperties() {
        return Stream.concat(Stream.of((Object[]) new ExaminableProperty[]{ExaminableProperty.of("name", name()), ExaminableProperty.of("objective", objective()), ExaminableProperty.of("value", value())}), super.examinableProperties());
    }
}
