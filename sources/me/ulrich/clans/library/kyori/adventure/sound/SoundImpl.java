package me.ulrich.clans.library.kyori.adventure.sound;

import java.util.Objects;
import java.util.OptionalLong;
import java.util.function.Supplier;
import java.util.stream.Stream;
import me.ulrich.clans.library.kyori.adventure.internal.Internals;
import me.ulrich.clans.library.kyori.adventure.key.Key;
import me.ulrich.clans.library.kyori.adventure.util.ShadyPines;
import me.ulrich.clans.library.kyori.examination.ExaminableProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/sound/SoundImpl.class */
abstract class SoundImpl implements Sound {
    static final Sound.Emitter EMITTER_SELF = new Sound.Emitter() { // from class: me.ulrich.clans.library.kyori.adventure.sound.SoundImpl.1
        public String toString() {
            return "SelfSoundEmitter";
        }
    };
    private final Sound.Source source;
    private final float volume;
    private final float pitch;
    private final OptionalLong seed;
    private SoundStop stop;

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/sound/SoundImpl$BuilderImpl.class */
    static final class BuilderImpl implements Sound.Builder {
        private static final float DEFAULT_VOLUME = 1.0f;
        private static final float DEFAULT_PITCH = 1.0f;
        private Key eagerType;
        private Supplier<? extends Sound.Type> lazyType;
        private Sound.Source source = Sound.Source.MASTER;
        private float volume = 1.0f;
        private float pitch = 1.0f;
        private OptionalLong seed = OptionalLong.empty();

        BuilderImpl() {
        }

        BuilderImpl(@NotNull Sound sound) {
            if (sound instanceof Eager) {
                type(((Eager) sound).name);
            } else {
                if (!(sound instanceof Lazy)) {
                    throw new IllegalArgumentException("Unknown sound type " + sound + ", must be Eager or Lazy");
                }
                type(((Lazy) sound).supplier);
            }
            source(sound.source()).volume(sound.volume()).pitch(sound.pitch()).seed(sound.seed());
        }

        @Override // me.ulrich.clans.library.kyori.adventure.sound.Sound.Builder
        @NotNull
        public Sound.Builder type(@NotNull Key key) {
            this.eagerType = (Key) Objects.requireNonNull(key, "type");
            this.lazyType = null;
            return this;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.sound.Sound.Builder
        @NotNull
        public Sound.Builder type(@NotNull Sound.Type type) {
            this.eagerType = (Key) Objects.requireNonNull(((Sound.Type) Objects.requireNonNull(type, "type")).key(), "type.key()");
            this.lazyType = null;
            return this;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.sound.Sound.Builder
        @NotNull
        public Sound.Builder type(@NotNull Supplier<? extends Sound.Type> supplier) {
            this.lazyType = (Supplier) Objects.requireNonNull(supplier, "typeSupplier");
            this.eagerType = null;
            return this;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.sound.Sound.Builder
        @NotNull
        public Sound.Builder source(@NotNull Sound.Source source) {
            this.source = (Sound.Source) Objects.requireNonNull(source, "source");
            return this;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.sound.Sound.Builder
        @NotNull
        public Sound.Builder source(Sound.Source.Provider provider) {
            return source(provider.soundSource());
        }

        @Override // me.ulrich.clans.library.kyori.adventure.sound.Sound.Builder
        @NotNull
        public Sound.Builder volume(float f) {
            this.volume = f;
            return this;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.sound.Sound.Builder
        @NotNull
        public Sound.Builder pitch(float f) {
            this.pitch = f;
            return this;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.sound.Sound.Builder
        @NotNull
        public Sound.Builder seed(long j) {
            this.seed = OptionalLong.of(j);
            return this;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.sound.Sound.Builder
        @NotNull
        public Sound.Builder seed(@NotNull OptionalLong optionalLong) {
            this.seed = (OptionalLong) Objects.requireNonNull(optionalLong, "seed");
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // me.ulrich.clans.library.kyori.adventure.builder.AbstractBuilder, me.ulrich.clans.library.kyori.adventure.util.Buildable.Builder
        @NotNull
        /* JADX INFO: renamed from: build */
        public Sound build2() {
            if (this.eagerType != null) {
                return new Eager(this.eagerType, this.source, this.volume, this.pitch, this.seed);
            }
            if (this.lazyType != null) {
                return new Lazy(this.lazyType, this.source, this.volume, this.pitch, this.seed);
            }
            throw new IllegalStateException("A sound type must be provided to build a sound");
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/sound/SoundImpl$Eager.class */
    static final class Eager extends SoundImpl {
        final Key name;

        Eager(@NotNull Key key, @NotNull Sound.Source source, float f, float f2, OptionalLong optionalLong) {
            super(source, f, f2, optionalLong);
            this.name = key;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.sound.Sound
        @NotNull
        public Key name() {
            return this.name;
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/sound/SoundImpl$Lazy.class */
    static final class Lazy extends SoundImpl {
        final Supplier<? extends Sound.Type> supplier;

        Lazy(@NotNull Supplier<? extends Sound.Type> supplier, @NotNull Sound.Source source, float f, float f2, OptionalLong optionalLong) {
            super(source, f, f2, optionalLong);
            this.supplier = supplier;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.sound.Sound
        @NotNull
        public Key name() {
            return this.supplier.get().key();
        }
    }

    SoundImpl(@NotNull Sound.Source source, float f, float f2, OptionalLong optionalLong) {
        this.source = source;
        this.volume = f;
        this.pitch = f2;
        this.seed = optionalLong;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.sound.Sound
    @NotNull
    public Sound.Source source() {
        return this.source;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.sound.Sound
    public float volume() {
        return this.volume;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.sound.Sound
    public float pitch() {
        return this.pitch;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.sound.Sound
    @NotNull
    public OptionalLong seed() {
        return this.seed;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.sound.Sound
    @NotNull
    public SoundStop asStop() {
        if (this.stop == null) {
            this.stop = SoundStop.namedOnSource(name(), source());
        }
        return this.stop;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SoundImpl)) {
            return false;
        }
        SoundImpl soundImpl = (SoundImpl) obj;
        return name().equals(soundImpl.name()) && this.source == soundImpl.source && ShadyPines.equals(this.volume, soundImpl.volume) && ShadyPines.equals(this.pitch, soundImpl.pitch) && this.seed.equals(soundImpl.seed);
    }

    public int hashCode() {
        return (31 * ((31 * ((31 * ((31 * name().hashCode()) + this.source.hashCode())) + Float.hashCode(this.volume))) + Float.hashCode(this.pitch))) + this.seed.hashCode();
    }

    @Override // me.ulrich.clans.library.kyori.examination.Examinable
    @NotNull
    public Stream<? extends ExaminableProperty> examinableProperties() {
        return Stream.of((Object[]) new ExaminableProperty[]{ExaminableProperty.of("name", name()), ExaminableProperty.of("source", this.source), ExaminableProperty.of("volume", this.volume), ExaminableProperty.of("pitch", this.pitch), ExaminableProperty.of("seed", this.seed)});
    }

    public String toString() {
        return Internals.toString(this);
    }
}
