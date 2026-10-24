package me.ulrich.clans.library.kyori.adventure.identity;

import java.util.UUID;
import me.ulrich.clans.library.kyori.adventure.internal.Internals;
import me.ulrich.clans.library.kyori.examination.Examinable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/identity/IdentityImpl.class */
final class IdentityImpl implements Identity, Examinable {
    private final UUID uuid;

    IdentityImpl(UUID uuid) {
        this.uuid = uuid;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.identity.Identity
    @NotNull
    public UUID uuid() {
        return this.uuid;
    }

    public String toString() {
        return Internals.toString(this);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Identity) {
            return this.uuid.equals(((Identity) obj).uuid());
        }
        return false;
    }

    public int hashCode() {
        return this.uuid.hashCode();
    }
}
