package me.ulrich.clans.library.kyori.examination.string;

import java.util.stream.Stream;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/examination/string/Strings.class */
final class Strings {
    private Strings() {
    }

    @NotNull
    static String withSuffix(String str, char c) {
        return str + c;
    }

    @NotNull
    static String wrapIn(String str, char c) {
        return c + str + c;
    }

    static int maxLength(Stream<String> stream) {
        return stream.mapToInt((v0) -> {
            return v0.length();
        }).max().orElse(0);
    }

    @NotNull
    static String repeat(@NotNull String str, int i) {
        if (i == 0) {
            return "";
        }
        if (i == 1) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str.length() * i);
        for (int i2 = 0; i2 < i; i2++) {
            sb.append(str);
        }
        return sb.toString();
    }

    @NotNull
    static String padEnd(@NotNull String str, int i, char c) {
        return str.length() >= i ? str : String.format("%-" + i + "s", Character.valueOf(c));
    }
}
