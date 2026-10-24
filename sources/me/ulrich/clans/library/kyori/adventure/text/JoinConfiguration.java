package me.ulrich.clans.library.kyori.adventure.text;

import java.util.function.Function;
import java.util.function.Predicate;
import me.ulrich.clans.library.kyori.adventure.builder.AbstractBuilder;
import me.ulrich.clans.library.kyori.adventure.text.format.Style;
import me.ulrich.clans.library.kyori.adventure.util.Buildable;
import me.ulrich.clans.library.kyori.examination.Examinable;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/JoinConfiguration.class */
@ApiStatus.NonExtendable
public interface JoinConfiguration extends Buildable<JoinConfiguration, Builder>, Examinable {

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/JoinConfiguration$Builder.class */
    public interface Builder extends AbstractBuilder<JoinConfiguration>, Buildable.Builder<JoinConfiguration> {
        @Contract("_ -> this")
        @NotNull
        Builder prefix(@Nullable ComponentLike componentLike);

        @Contract("_ -> this")
        @NotNull
        Builder suffix(@Nullable ComponentLike componentLike);

        @Contract("_ -> this")
        @NotNull
        Builder separator(@Nullable ComponentLike componentLike);

        @Contract("_ -> this")
        @NotNull
        Builder lastSeparator(@Nullable ComponentLike componentLike);

        @Contract("_ -> this")
        @NotNull
        Builder lastSeparatorIfSerial(@Nullable ComponentLike componentLike);

        @Contract("_ -> this")
        @NotNull
        Builder convertor(@NotNull Function<ComponentLike, Component> function);

        @Contract("_ -> this")
        @NotNull
        Builder predicate(@NotNull Predicate<ComponentLike> predicate);

        @Contract("_ -> this")
        @NotNull
        Builder parentStyle(@NotNull Style style);
    }

    @NotNull
    static Builder builder() {
        return new JoinConfigurationImpl.BuilderImpl();
    }

    @NotNull
    static JoinConfiguration noSeparators() {
        return JoinConfigurationImpl.NULL;
    }

    @NotNull
    static JoinConfiguration newlines() {
        return JoinConfigurationImpl.STANDARD_NEW_LINES;
    }

    @NotNull
    static JoinConfiguration spaces() {
        return JoinConfigurationImpl.STANDARD_SPACES;
    }

    @NotNull
    static JoinConfiguration commas(boolean z) {
        return z ? JoinConfigurationImpl.STANDARD_COMMA_SPACE_SEPARATED : JoinConfigurationImpl.STANDARD_COMMA_SEPARATED;
    }

    @NotNull
    static JoinConfiguration arrayLike() {
        return JoinConfigurationImpl.STANDARD_ARRAY_LIKE;
    }

    @NotNull
    static JoinConfiguration separator(@Nullable ComponentLike componentLike) {
        return componentLike == null ? JoinConfigurationImpl.NULL : builder().separator(componentLike).build2();
    }

    @NotNull
    static JoinConfiguration separators(@Nullable ComponentLike componentLike, @Nullable ComponentLike componentLike2) {
        return (componentLike == null && componentLike2 == null) ? JoinConfigurationImpl.NULL : builder().separator(componentLike).lastSeparator(componentLike2).build2();
    }

    @Nullable
    Component prefix();

    @Nullable
    Component suffix();

    @Nullable
    Component separator();

    @Nullable
    Component lastSeparator();

    @Nullable
    Component lastSeparatorIfSerial();

    @NotNull
    Function<ComponentLike, Component> convertor();

    @NotNull
    Predicate<ComponentLike> predicate();

    @NotNull
    Style parentStyle();
}
