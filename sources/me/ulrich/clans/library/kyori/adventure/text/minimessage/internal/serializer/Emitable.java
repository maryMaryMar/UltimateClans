package me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.serializer;

import me.ulrich.clans.library.kyori.adventure.text.Component;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/minimessage/internal/serializer/Emitable.class */
@FunctionalInterface
public interface Emitable {
    void emit(@NotNull TokenEmitter tokenEmitter);

    @Nullable
    default Component substitute() {
        return null;
    }
}
