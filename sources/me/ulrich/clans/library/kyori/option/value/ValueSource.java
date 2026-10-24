package me.ulrich.clans.library.kyori.option.value;

import me.ulrich.clans.library.kyori.option.Option;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/option/value/ValueSource.class */
@FunctionalInterface
public interface ValueSource {
    static ValueSource environmentVariable() {
        return environmentVariable("");
    }

    static ValueSource environmentVariable(String str) {
        return new ValueSources.EnvironmentVariable(str);
    }

    static ValueSource systemProperty() {
        return systemProperty("");
    }

    static ValueSource systemProperty(String str) {
        return new ValueSources.SystemProperty(str);
    }

    <T> T value(Option<T> option);
}
