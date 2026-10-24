package me.ulrich.clans.library.kyori.adventure.sound;

import java.util.Objects;
import java.util.OptionalLong;
import java.util.function.Consumer;
import java.util.function.Supplier;
import me.ulrich.clans.library.kyori.adventure.builder.AbstractBuilder;
import me.ulrich.clans.library.kyori.adventure.key.Key;
import me.ulrich.clans.library.kyori.adventure.key.Keyed;
import me.ulrich.clans.library.kyori.adventure.util.Index;
import me.ulrich.clans.library.kyori.examination.Examinable;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/sound/Sound.class */
@ApiStatus.NonExtendable
public interface Sound extends Examinable {

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/sound/Sound$Builder.class */
    @ApiStatus.NonExtendable
    public interface Builder extends AbstractBuilder<Sound> {
        @NotNull
        Builder type(@NotNull Key key);

        @NotNull
        Builder type(@NotNull Type type);

        @NotNull
        Builder type(@NotNull Supplier<? extends Type> supplier);

        @NotNull
        Builder source(@NotNull Source source);

        @NotNull
        Builder source(Source.Provider provider);

        @NotNull
        Builder volume(float f);

        @NotNull
        Builder pitch(float f);

        @NotNull
        Builder seed(long j);

        @NotNull
        Builder seed(@NotNull OptionalLong optionalLong);
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/sound/Sound$Emitter.class */
    public interface Emitter {
        @NotNull
        static Emitter self() {
            return SoundImpl.EMITTER_SELF;
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/sound/Sound$Source.class */
    public enum Source {
        MASTER("master"),
        MUSIC("music"),
        RECORD("record"),
        WEATHER("weather"),
        BLOCK("block"),
        HOSTILE("hostile"),
        NEUTRAL("neutral"),
        PLAYER("player"),
        AMBIENT("ambient"),
        VOICE("voice"),
        UI("ui");

        public static final Index<String, Source> NAMES = Index.create(Source.class, source -> {
            return source.name;
        });
        private final String name;

        /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/sound/Sound$Source$Provider.class */
        public interface Provider {
            @NotNull
            Source soundSource();
        }

        Source(String str) {
            this.name = str;
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/sound/Sound$Type.class */
    public interface Type extends Keyed {
        @Override // me.ulrich.clans.library.kyori.adventure.key.Keyed
        @NotNull
        Key key();
    }

    @NotNull
    static Builder sound() {
        return new SoundImpl.BuilderImpl();
    }

    @NotNull
    static Builder sound(@NotNull Sound sound) {
        return new SoundImpl.BuilderImpl(sound);
    }

    @NotNull
    static Sound sound(@NotNull Consumer<Builder> consumer) {
        return (Sound) AbstractBuilder.configureAndBuild(sound(), consumer);
    }

    @NotNull
    static Sound sound(@NotNull Key key, @NotNull Source source, float f, float f2) {
        return sound().type(key).source(source).volume(f).pitch(f2).build();
    }

    @NotNull
    static Sound sound(@NotNull Type type, @NotNull Source source, float f, float f2) {
        Objects.requireNonNull(type, "type");
        return sound(type.key(), source, f, f2);
    }

    @NotNull
    static Sound sound(@NotNull Supplier<? extends Type> supplier, @NotNull Source source, float f, float f2) {
        return sound().type(supplier).source(source).volume(f).pitch(f2).build();
    }

    @NotNull
    static Sound sound(@NotNull Key key, Source.Provider provider, float f, float f2) {
        return sound(key, provider.soundSource(), f, f2);
    }

    @NotNull
    static Sound sound(@NotNull Type type, Source.Provider provider, float f, float f2) {
        return sound(type, provider.soundSource(), f, f2);
    }

    @NotNull
    static Sound sound(@NotNull Supplier<? extends Type> supplier, Source.Provider provider, float f, float f2) {
        return sound(supplier, provider.soundSource(), f, f2);
    }

    @NotNull
    Key name();

    @NotNull
    Source source();

    float volume();

    float pitch();

    @NotNull
    OptionalLong seed();

    @NotNull
    SoundStop asStop();
}
