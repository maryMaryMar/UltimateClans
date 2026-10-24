package me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.serializer;

import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Predicate;
import me.ulrich.clans.library.kyori.adventure.text.format.Style;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/minimessage/internal/serializer/StyleClaim.class */
public interface StyleClaim<V> {
    @NotNull
    static <T> StyleClaim<T> claim(@NotNull String str, @NotNull Function<Style, T> function, @NotNull BiConsumer<T, TokenEmitter> biConsumer) {
        return claim(str, function, obj -> {
            return true;
        }, biConsumer);
    }

    @NotNull
    static <T> StyleClaim<T> claim(@NotNull String str, @NotNull Function<Style, T> function, @NotNull Predicate<T> predicate, @NotNull BiConsumer<T, TokenEmitter> biConsumer) {
        return new StyleClaimImpl((String) Objects.requireNonNull(str, "claimKey"), (Function) Objects.requireNonNull(function, "lens"), (Predicate) Objects.requireNonNull(predicate, "filter"), (BiConsumer) Objects.requireNonNull(biConsumer, "emitable"));
    }

    @NotNull
    String claimKey();

    @Nullable
    Emitable apply(@NotNull Style style);
}
