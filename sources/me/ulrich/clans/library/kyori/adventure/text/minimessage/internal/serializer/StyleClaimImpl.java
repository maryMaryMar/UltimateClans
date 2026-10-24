package me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.serializer;

import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Predicate;
import me.ulrich.clans.library.kyori.adventure.text.format.Style;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/minimessage/internal/serializer/StyleClaimImpl.class */
class StyleClaimImpl<V> implements StyleClaim<V> {
    private final String claimKey;
    private final Function<Style, V> lens;
    private final Predicate<V> filter;
    private final BiConsumer<V, TokenEmitter> emitable;

    StyleClaimImpl(String str, Function<Style, V> function, Predicate<V> predicate, BiConsumer<V, TokenEmitter> biConsumer) {
        this.claimKey = str;
        this.lens = function;
        this.filter = predicate;
        this.emitable = biConsumer;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.serializer.StyleClaim
    @NotNull
    public String claimKey() {
        return this.claimKey;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.serializer.StyleClaim
    @Nullable
    public Emitable apply(@NotNull Style style) {
        V vApply = this.lens.apply(style);
        if (vApply == null || !this.filter.test(vApply)) {
            return null;
        }
        return tokenEmitter -> {
            this.emitable.accept(vApply, tokenEmitter);
        };
    }

    public int hashCode() {
        return Objects.hash(this.claimKey);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof StyleClaimImpl) {
            return Objects.equals(this.claimKey, ((StyleClaimImpl) obj).claimKey);
        }
        return false;
    }
}
