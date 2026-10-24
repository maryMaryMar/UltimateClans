package me.ulrich.clans.library.kyori.adventure.sound;

import java.util.Objects;
import java.util.stream.Stream;
import me.ulrich.clans.library.kyori.adventure.internal.Internals;
import me.ulrich.clans.library.kyori.adventure.key.Key;
import me.ulrich.clans.library.kyori.examination.ExaminableProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/sound/SoundStopImpl.class */
abstract class SoundStopImpl implements SoundStop {
    static final SoundStop ALL = new SoundStopImpl(null) { // from class: me.ulrich.clans.library.kyori.adventure.sound.SoundStopImpl.1
        @Override // me.ulrich.clans.library.kyori.adventure.sound.SoundStop
        @Nullable
        public Key sound() {
            return null;
        }
    };
    private final Sound.Source source;

    SoundStopImpl(Sound.Source source) {
        this.source = source;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.sound.SoundStop
    public Sound.Source source() {
        return this.source;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SoundStopImpl)) {
            return false;
        }
        SoundStopImpl soundStopImpl = (SoundStopImpl) obj;
        return Objects.equals(sound(), soundStopImpl.sound()) && Objects.equals(this.source, soundStopImpl.source);
    }

    public int hashCode() {
        return (31 * Objects.hashCode(sound())) + Objects.hashCode(this.source);
    }

    @Override // me.ulrich.clans.library.kyori.examination.Examinable
    @NotNull
    public Stream<? extends ExaminableProperty> examinableProperties() {
        return Stream.of((Object[]) new ExaminableProperty[]{ExaminableProperty.of("name", sound()), ExaminableProperty.of("source", this.source)});
    }

    public String toString() {
        return Internals.toString(this);
    }
}
