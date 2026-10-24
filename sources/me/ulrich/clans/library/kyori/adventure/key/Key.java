package me.ulrich.clans.library.kyori.adventure.key;

import java.util.Comparator;
import java.util.Objects;
import java.util.OptionalInt;
import java.util.stream.Stream;
import me.ulrich.clans.library.kyori.examination.Examinable;
import me.ulrich.clans.library.kyori.examination.ExaminableProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/key/Key.class */
public interface Key extends Comparable<Key>, Keyed, Namespaced, Examinable {
    public static final String MINECRAFT_NAMESPACE = "minecraft";
    public static final char DEFAULT_SEPARATOR = ':';

    @NotNull
    static Key key(@KeyPattern @NotNull String str) {
        return key(str, ':');
    }

    @NotNull
    static Key key(@NotNull String str, char c) {
        Objects.requireNonNull(str, "string");
        int iIndexOf = str.indexOf(c);
        return key(iIndexOf >= 1 ? str.substring(0, iIndexOf) : MINECRAFT_NAMESPACE, iIndexOf >= 0 ? str.substring(iIndexOf + 1) : str);
    }

    @NotNull
    static Key key(@NotNull Namespaced namespaced, @KeyPattern.Value @NotNull String str) {
        return key(((Namespaced) Objects.requireNonNull(namespaced, "namespaced")).namespace(), str);
    }

    @NotNull
    static Key key(@KeyPattern.Namespace @NotNull String str, @KeyPattern.Value @NotNull String str2) {
        return new KeyImpl(str, str2);
    }

    @NotNull
    static Comparator<? super Key> comparator() {
        return KeyImpl.COMPARATOR;
    }

    static boolean parseable(@Nullable String str) {
        if (str == null) {
            return false;
        }
        int iIndexOf = str.indexOf(58);
        return parseableNamespace(iIndexOf >= 1 ? str.substring(0, iIndexOf) : MINECRAFT_NAMESPACE) && parseableValue(iIndexOf >= 0 ? str.substring(iIndexOf + 1) : str);
    }

    static boolean parseableNamespace(@NotNull String str) {
        return !checkNamespace(str).isPresent();
    }

    @NotNull
    static OptionalInt checkNamespace(@NotNull String str) {
        Objects.requireNonNull(str, "namespace");
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (!allowedInNamespace(str.charAt(i))) {
                return OptionalInt.of(i);
            }
        }
        return OptionalInt.empty();
    }

    static boolean parseableValue(@NotNull String str) {
        return !checkValue(str).isPresent();
    }

    @NotNull
    static OptionalInt checkValue(@NotNull String str) {
        Objects.requireNonNull(str, "value");
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (!allowedInValue(str.charAt(i))) {
                return OptionalInt.of(i);
            }
        }
        return OptionalInt.empty();
    }

    static boolean allowedInNamespace(char c) {
        return KeyImpl.allowedInNamespace(c);
    }

    static boolean allowedInValue(char c) {
        return KeyImpl.allowedInValue(c);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.key.Namespaced
    @KeyPattern.Namespace
    @NotNull
    String namespace();

    @KeyPattern.Value
    @NotNull
    String value();

    @NotNull
    String asString();

    @NotNull
    default String asMinimalString() {
        return namespace().equals(MINECRAFT_NAMESPACE) ? value() : asString();
    }

    @Override // me.ulrich.clans.library.kyori.examination.Examinable
    @NotNull
    default Stream<? extends ExaminableProperty> examinableProperties() {
        return Stream.of((Object[]) new ExaminableProperty[]{ExaminableProperty.of("namespace", namespace()), ExaminableProperty.of("value", value())});
    }

    @Override // java.lang.Comparable
    default int compareTo(@NotNull Key key) {
        return comparator().compare(this, key);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.key.Keyed
    @NotNull
    default Key key() {
        return this;
    }
}
