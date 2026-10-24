package me.ulrich.clans.library.kyori.adventure.text.format;

import java.util.stream.Stream;
import me.ulrich.clans.library.kyori.adventure.internal.Internals;
import me.ulrich.clans.library.kyori.examination.Examinable;
import me.ulrich.clans.library.kyori.examination.ExaminableProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/format/ShadowColorImpl.class */
final class ShadowColorImpl implements ShadowColor, Examinable {
    static final int NONE_VALUE = 0;
    static final ShadowColorImpl NONE = new ShadowColorImpl(0);
    private final int value;

    ShadowColorImpl(int i) {
        this.value = i;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.format.ShadowColor
    public int value() {
        return this.value;
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof ShadowColorImpl) && this.value == ((ShadowColorImpl) obj).value;
    }

    public int hashCode() {
        return Integer.hashCode(this.value);
    }

    public String toString() {
        return Internals.toString(this);
    }

    @Override // me.ulrich.clans.library.kyori.examination.Examinable
    @NotNull
    public Stream<? extends ExaminableProperty> examinableProperties() {
        return Stream.of(ExaminableProperty.of("value", this.value));
    }
}
