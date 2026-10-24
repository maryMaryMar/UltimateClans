package me.ulrich.clans.library.kyori.adventure.text.event;

import java.util.Objects;
import java.util.function.BiFunction;
import java.util.stream.Stream;
import me.ulrich.clans.library.kyori.adventure.internal.Internals;
import me.ulrich.clans.library.kyori.adventure.key.Key;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.standard.KeybindTag;
import me.ulrich.clans.library.kyori.examination.ExaminableProperty;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/event/DataComponentValueConversionImpl.class */
final class DataComponentValueConversionImpl<I, O> implements DataComponentValueConverterRegistry.Conversion<I, O> {
    private final Class<I> source;
    private final Class<O> destination;
    private final BiFunction<Key, I, O> conversion;

    DataComponentValueConversionImpl(@NotNull Class<I> cls, @NotNull Class<O> cls2, @NotNull BiFunction<Key, I, O> biFunction) {
        this.source = cls;
        this.destination = cls2;
        this.conversion = biFunction;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.event.DataComponentValueConverterRegistry.Conversion
    @NotNull
    public Class<I> source() {
        return this.source;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.event.DataComponentValueConverterRegistry.Conversion
    @NotNull
    public Class<O> destination() {
        return this.destination;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.event.DataComponentValueConverterRegistry.Conversion
    @NotNull
    public O convert(@NotNull Key key, @NotNull I i) {
        return this.conversion.apply((Key) Objects.requireNonNull(key, KeybindTag.KEYBIND), (I) Objects.requireNonNull(i, "input"));
    }

    @Override // me.ulrich.clans.library.kyori.examination.Examinable
    @NotNull
    public Stream<? extends ExaminableProperty> examinableProperties() {
        return Stream.of((Object[]) new ExaminableProperty[]{ExaminableProperty.of("source", this.source), ExaminableProperty.of("destination", this.destination), ExaminableProperty.of("conversion", this.conversion)});
    }

    public String toString() {
        return Internals.toString(this);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        DataComponentValueConversionImpl dataComponentValueConversionImpl = (DataComponentValueConversionImpl) obj;
        return Objects.equals(this.source, dataComponentValueConversionImpl.source) && Objects.equals(this.destination, dataComponentValueConversionImpl.destination) && Objects.equals(this.conversion, dataComponentValueConversionImpl.conversion);
    }

    public int hashCode() {
        return Objects.hash(this.source, this.destination, this.conversion);
    }
}
