package me.ulrich.clans.library.kyori.adventure.identity;

import java.util.UUID;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/identity/NilIdentity.class */
final class NilIdentity implements Identity {
    static final UUID NIL_UUID = new UUID(0, 0);
    static final Identity INSTANCE = new NilIdentity();

    NilIdentity() {
    }

    @Override // me.ulrich.clans.library.kyori.adventure.identity.Identity
    @NotNull
    public UUID uuid() {
        return NIL_UUID;
    }

    public String toString() {
        return "Identity.nil()";
    }

    public boolean equals(@Nullable Object obj) {
        return this == obj;
    }

    public int hashCode() {
        return 0;
    }
}
