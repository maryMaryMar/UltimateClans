package me.ulrich.clans.library.kyori.adventure.key;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.OptionalInt;
import java.util.stream.Stream;
import me.ulrich.clans.library.kyori.examination.ExaminableProperty;
import org.intellij.lang.annotations.RegExp;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/key/KeyImpl.class */
final class KeyImpl implements Key {
    static final Comparator<? super Key> COMPARATOR = Comparator.comparing((v0) -> {
        return v0.value();
    }).thenComparing((v0) -> {
        return v0.namespace();
    });

    @RegExp
    static final String NAMESPACE_PATTERN = "[a-z0-9_\\-.]+";

    @RegExp
    static final String VALUE_PATTERN = "[a-z0-9_\\-./]+";
    private final String namespace;
    private final String value;

    KeyImpl(@NotNull String str, @NotNull String str2) {
        checkError("namespace", str, str, str2, Key.checkNamespace(str), NAMESPACE_PATTERN);
        checkError("value", str2, str, str2, Key.checkValue(str2), VALUE_PATTERN);
        this.namespace = (String) Objects.requireNonNull(str, "namespace");
        this.value = (String) Objects.requireNonNull(str2, "value");
    }

    private static void checkError(String str, String str2, String str3, String str4, OptionalInt optionalInt, String str5) {
        if (optionalInt.isPresent()) {
            int asInt = optionalInt.getAsInt();
            char cCharAt = str2.charAt(asInt);
            throw new InvalidKeyException(str3, str4, String.format("Non " + str5 + " character in %s of Key[%s] at index %d ('%s', bytes: %s)", str, asString(str3, str4), Integer.valueOf(asInt), Character.valueOf(cCharAt), Arrays.toString(String.valueOf(cCharAt).getBytes(StandardCharsets.UTF_8))));
        }
    }

    static boolean allowedInNamespace(char c) {
        return c == '_' || c == '-' || (c >= 'a' && c <= 'z') || ((c >= '0' && c <= '9') || c == '.');
    }

    static boolean allowedInValue(char c) {
        return c == '_' || c == '-' || (c >= 'a' && c <= 'z') || ((c >= '0' && c <= '9') || c == '.' || c == '/');
    }

    @Override // me.ulrich.clans.library.kyori.adventure.key.Key, me.ulrich.clans.library.kyori.adventure.key.Namespaced
    @NotNull
    public String namespace() {
        return this.namespace;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.key.Key
    @NotNull
    public String value() {
        return this.value;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.key.Key
    @NotNull
    public String asString() {
        return asString(this.namespace, this.value);
    }

    @NotNull
    private static String asString(@NotNull String str, @NotNull String str2) {
        return str + ':' + str2;
    }

    @NotNull
    public String toString() {
        return asString();
    }

    @Override // me.ulrich.clans.library.kyori.adventure.key.Key, me.ulrich.clans.library.kyori.examination.Examinable
    @NotNull
    public Stream<? extends ExaminableProperty> examinableProperties() {
        return Stream.of((Object[]) new ExaminableProperty[]{ExaminableProperty.of("namespace", this.namespace), ExaminableProperty.of("value", this.value)});
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Key)) {
            return false;
        }
        Key key = (Key) obj;
        return Objects.equals(this.namespace, key.namespace()) && Objects.equals(this.value, key.value());
    }

    public int hashCode() {
        return (31 * this.namespace.hashCode()) + this.value.hashCode();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // me.ulrich.clans.library.kyori.adventure.key.Key, java.lang.Comparable
    public int compareTo(@NotNull Key key) {
        return super.compareTo(key);
    }
}
