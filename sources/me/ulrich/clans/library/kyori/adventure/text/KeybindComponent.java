package me.ulrich.clans.library.kyori.adventure.text;

import java.util.Objects;
import java.util.stream.Stream;
import me.ulrich.clans.library.kyori.examination.ExaminableProperty;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/KeybindComponent.class */
public interface KeybindComponent extends BuildableComponent<KeybindComponent, Builder>, ScopedComponent<KeybindComponent> {

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/KeybindComponent$Builder.class */
    public interface Builder extends ComponentBuilder<KeybindComponent, Builder> {
        @Contract("_ -> this")
        @NotNull
        Builder keybind(@NotNull String str);

        @Contract(pure = true)
        @NotNull
        default Builder keybind(@NotNull KeybindLike keybindLike) {
            return keybind(((KeybindLike) Objects.requireNonNull(keybindLike, "keybind")).asKeybind());
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/KeybindComponent$KeybindLike.class */
    public interface KeybindLike {
        @NotNull
        String asKeybind();
    }

    @NotNull
    String keybind();

    @Contract(pure = true)
    @NotNull
    KeybindComponent keybind(@NotNull String str);

    @Contract(pure = true)
    @NotNull
    default KeybindComponent keybind(@NotNull KeybindLike keybindLike) {
        return keybind(((KeybindLike) Objects.requireNonNull(keybindLike, "keybind")).asKeybind());
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.Component, me.ulrich.clans.library.kyori.examination.Examinable
    @NotNull
    default Stream<? extends ExaminableProperty> examinableProperties() {
        return Stream.concat(Stream.of(ExaminableProperty.of("keybind", keybind())), super.examinableProperties());
    }
}
