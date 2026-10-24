package me.ulrich.clans.library.kyori.adventure.text;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.standard.KeybindTag;
import me.ulrich.clans.library.kyori.adventure.translation.Translatable;
import me.ulrich.clans.library.kyori.examination.ExaminableProperty;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/TranslatableComponent.class */
public interface TranslatableComponent extends BuildableComponent<TranslatableComponent, Builder>, ScopedComponent<TranslatableComponent> {

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/TranslatableComponent$Builder.class */
    public interface Builder extends ComponentBuilder<TranslatableComponent, Builder> {
        @Contract(pure = true)
        @NotNull
        default Builder key(@NotNull Translatable translatable) {
            return key(((Translatable) Objects.requireNonNull(translatable, "translatable")).translationKey());
        }

        @Contract("_ -> this")
        @NotNull
        Builder key(@NotNull String str);

        @Contract("_ -> this")
        @Deprecated
        @NotNull
        default Builder args(@NotNull ComponentBuilder<?, ?> componentBuilder) {
            return arguments(componentBuilder);
        }

        @Contract("_ -> this")
        @Deprecated
        @NotNull
        default Builder args(@NotNull ComponentBuilder<?, ?>... componentBuilderArr) {
            return arguments(componentBuilderArr);
        }

        @Contract("_ -> this")
        @Deprecated
        @NotNull
        default Builder args(@NotNull Component component) {
            return arguments(component);
        }

        @Contract("_ -> this")
        @Deprecated
        @NotNull
        default Builder args(@NotNull ComponentLike... componentLikeArr) {
            return arguments(componentLikeArr);
        }

        @Contract("_ -> this")
        @Deprecated
        @NotNull
        default Builder args(@NotNull List<? extends ComponentLike> list) {
            return arguments(list);
        }

        @Contract("_ -> this")
        @NotNull
        Builder arguments(@NotNull ComponentLike... componentLikeArr);

        @Contract("_ -> this")
        @NotNull
        Builder arguments(@NotNull List<? extends ComponentLike> list);

        @Contract("_ -> this")
        @NotNull
        Builder fallback(@Nullable String str);
    }

    @NotNull
    String key();

    @Contract(pure = true)
    @NotNull
    default TranslatableComponent key(@NotNull Translatable translatable) {
        return key(((Translatable) Objects.requireNonNull(translatable, "translatable")).translationKey());
    }

    @Contract(pure = true)
    @NotNull
    TranslatableComponent key(@NotNull String str);

    @Deprecated
    @NotNull
    List<Component> args();

    @Contract(pure = true)
    @Deprecated
    @NotNull
    default TranslatableComponent args(@NotNull ComponentLike... componentLikeArr) {
        return arguments(componentLikeArr);
    }

    @Contract(pure = true)
    @Deprecated
    @NotNull
    default TranslatableComponent args(@NotNull List<? extends ComponentLike> list) {
        return arguments(list);
    }

    @NotNull
    List<TranslationArgument> arguments();

    @Contract(pure = true)
    @NotNull
    TranslatableComponent arguments(@NotNull ComponentLike... componentLikeArr);

    @Contract(pure = true)
    @NotNull
    TranslatableComponent arguments(@NotNull List<? extends ComponentLike> list);

    @Nullable
    String fallback();

    @Contract(pure = true)
    @NotNull
    TranslatableComponent fallback(@Nullable String str);

    @Override // me.ulrich.clans.library.kyori.adventure.text.Component, me.ulrich.clans.library.kyori.examination.Examinable
    @NotNull
    default Stream<? extends ExaminableProperty> examinableProperties() {
        return Stream.concat(Stream.of((Object[]) new ExaminableProperty[]{ExaminableProperty.of(KeybindTag.KEYBIND, key()), ExaminableProperty.of("arguments", arguments()), ExaminableProperty.of("fallback", fallback())}), super.examinableProperties());
    }
}
