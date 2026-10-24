package me.ulrich.clans.library.kyori.adventure.util;

import java.lang.Throwable;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/util/Codec.class */
public interface Codec<D, E, DX extends Throwable, EX extends Throwable> {

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/util/Codec$Decoder.class */
    public interface Decoder<D, E, X extends Throwable> {
        @NotNull
        D decode(@NotNull E e);
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/util/Codec$Encoder.class */
    public interface Encoder<D, E, X extends Throwable> {
        @NotNull
        E encode(@NotNull D d);
    }

    @NotNull
    static <D, E, DX extends Throwable, EX extends Throwable> Codec<D, E, DX, EX> codec(@NotNull final Decoder<D, E, DX> decoder, @NotNull final Encoder<D, E, EX> encoder) {
        return (Codec<D, E, DX, EX>) new Codec<D, E, DX, EX>() { // from class: me.ulrich.clans.library.kyori.adventure.util.Codec.1
            @Override // me.ulrich.clans.library.kyori.adventure.util.Codec
            @NotNull
            public D decode(@NotNull E e) {
                return (D) decoder.decode(e);
            }

            @Override // me.ulrich.clans.library.kyori.adventure.util.Codec
            @NotNull
            public E encode(@NotNull D d) {
                return (E) encoder.encode(d);
            }
        };
    }

    @ApiStatus.ScheduledForRemoval(inVersion = "5.0.0")
    @Deprecated
    @NotNull
    static <D, E, DX extends Throwable, EX extends Throwable> Codec<D, E, DX, EX> of(@NotNull final Decoder<D, E, DX> decoder, @NotNull final Encoder<D, E, EX> encoder) {
        return (Codec<D, E, DX, EX>) new Codec<D, E, DX, EX>() { // from class: me.ulrich.clans.library.kyori.adventure.util.Codec.2
            @Override // me.ulrich.clans.library.kyori.adventure.util.Codec
            @NotNull
            public D decode(@NotNull E e) {
                return (D) decoder.decode(e);
            }

            @Override // me.ulrich.clans.library.kyori.adventure.util.Codec
            @NotNull
            public E encode(@NotNull D d) {
                return (E) encoder.encode(d);
            }
        };
    }

    @NotNull
    D decode(@NotNull E e);

    @NotNull
    E encode(@NotNull D d);
}
