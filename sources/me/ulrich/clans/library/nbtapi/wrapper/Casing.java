package me.ulrich.clans.library.nbtapi.wrapper;

import java.util.function.UnaryOperator;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/nbtapi/wrapper/Casing.class */
public enum Casing {
    camelCase(str -> {
        return str.length() < 2 ? str.toLowerCase() : Character.toLowerCase(str.charAt(0)) + str.substring(1);
    }),
    snake_case(str2 -> {
        StringBuilder sb = new StringBuilder();
        sb.append(Character.toLowerCase(str2.charAt(0)));
        for (int i = 1; i < str2.length(); i++) {
            char cCharAt = str2.charAt(i);
            if (Character.isUpperCase(cCharAt)) {
                sb.append('_').append(Character.toLowerCase(cCharAt));
            } else {
                sb.append(cCharAt);
            }
        }
        return sb.toString();
    }),
    PascalCase(str3 -> {
        return str3.length() < 2 ? str3.toUpperCase() : Character.toUpperCase(str3.charAt(0)) + str3.substring(1);
    }),
    lowercase((v0) -> {
        return v0.toLowerCase();
    }),
    UPPERCASE((v0) -> {
        return v0.toUpperCase();
    });

    private UnaryOperator<String> convert;

    Casing(UnaryOperator unaryOperator) {
        this.convert = unaryOperator;
    }

    public String convertString(String str) {
        return (String) this.convert.apply(str);
    }
}
