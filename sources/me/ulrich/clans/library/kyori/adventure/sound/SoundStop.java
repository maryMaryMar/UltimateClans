package me.ulrich.clans.library.kyori.adventure.sound;

import java.util.Objects;
import java.util.function.Supplier;
import me.ulrich.clans.library.kyori.adventure.key.Key;
import me.ulrich.clans.library.kyori.examination.Examinable;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/sound/SoundStop.class */
@ApiStatus.NonExtendable
public interface SoundStop extends Examinable {
    @NotNull
    static SoundStop all() {
        return SoundStopImpl.ALL;
    }

    @NotNull
    static SoundStop named(@NotNull final Key key) {
        Objects.requireNonNull(key, "sound");
        return new SoundStopImpl(null) { // from class: me.ulrich.clans.library.kyori.adventure.sound.SoundStop.1
            @Override // me.ulrich.clans.library.kyori.adventure.sound.SoundStop
            @NotNull
            public Key sound() {
                return key;
            }
        };
    }

    @NotNull
    static SoundStop named(final Sound.Type type) {
        Objects.requireNonNull(type, "sound");
        return new SoundStopImpl(null) { // from class: me.ulrich.clans.library.kyori.adventure.sound.SoundStop.2
            @Override // me.ulrich.clans.library.kyori.adventure.sound.SoundStop
            @NotNull
            public Key sound() {
                return type.key();
            }
        };
    }

    @NotNull
    static SoundStop named(@NotNull final Supplier<? extends Sound.Type> supplier) {
        Objects.requireNonNull(supplier, "sound");
        return new SoundStopImpl(null) { // from class: me.ulrich.clans.library.kyori.adventure.sound.SoundStop.3
            @Override // me.ulrich.clans.library.kyori.adventure.sound.SoundStop
            @NotNull
            public Key sound() {
                return ((Sound.Type) supplier.get()).key();
            }
        };
    }

    @NotNull
    static SoundStop source(Sound.Source source) {
        Objects.requireNonNull(source, "source");
        return new SoundStopImpl(source) { // from class: me.ulrich.clans.library.kyori.adventure.sound.SoundStop.4
            @Override // me.ulrich.clans.library.kyori.adventure.sound.SoundStop
            @Nullable
            public Key sound() {
                return null;
            }
        };
    }

    @NotNull
    static SoundStop namedOnSource(@NotNull final Key key, Sound.Source source) {
        Objects.requireNonNull(key, "sound");
        Objects.requireNonNull(source, "source");
        return new SoundStopImpl(source) { // from class: me.ulrich.clans.library.kyori.adventure.sound.SoundStop.5
            @Override // me.ulrich.clans.library.kyori.adventure.sound.SoundStop
            @NotNull
            public Key sound() {
                return key;
            }
        };
    }

    @NotNull
    static SoundStop namedOnSource(Sound.Type type, Sound.Source source) {
        Objects.requireNonNull(type, "sound");
        return namedOnSource(type.key(), source);
    }

    @NotNull
    static SoundStop namedOnSource(@NotNull final Supplier<? extends Sound.Type> supplier, Sound.Source source) {
        Objects.requireNonNull(supplier, "sound");
        Objects.requireNonNull(source, "source");
        return new SoundStopImpl(source) { // from class: me.ulrich.clans.library.kyori.adventure.sound.SoundStop.6
            @Override // me.ulrich.clans.library.kyori.adventure.sound.SoundStop
            @NotNull
            public Key sound() {
                return ((Sound.Type) supplier.get()).key();
            }
        };
    }

    @Nullable
    Key sound();

    Sound.Source source();
}
