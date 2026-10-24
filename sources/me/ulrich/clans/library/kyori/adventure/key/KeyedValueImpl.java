package me.ulrich.clans.library.kyori.adventure.key;

import java.util.stream.Stream;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.standard.KeybindTag;
import me.ulrich.clans.library.kyori.examination.Examinable;
import me.ulrich.clans.library.kyori.examination.ExaminableProperty;
import me.ulrich.clans.library.kyori.examination.string.StringExaminer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/key/KeyedValueImpl.class */
final class KeyedValueImpl<T> implements KeyedValue<T>, Examinable {
    private final Key key;
    private final T value;

    KeyedValueImpl(Key key, T t) {
        this.key = key;
        this.value = t;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.key.Keyed
    @NotNull
    public Key key() {
        return this.key;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.key.KeyedValue
    @NotNull
    public T value() {
        return this.value;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        KeyedValueImpl keyedValueImpl = (KeyedValueImpl) obj;
        return this.key.equals(keyedValueImpl.key) && this.value.equals(keyedValueImpl.value);
    }

    public int hashCode() {
        return (31 * this.key.hashCode()) + this.value.hashCode();
    }

    @Override // me.ulrich.clans.library.kyori.examination.Examinable
    @NotNull
    public Stream<? extends ExaminableProperty> examinableProperties() {
        return Stream.of((Object[]) new ExaminableProperty[]{ExaminableProperty.of(KeybindTag.KEYBIND, this.key), ExaminableProperty.of("value", this.value)});
    }

    public String toString() {
        return (String) examine(StringExaminer.simpleEscaping());
    }
}
