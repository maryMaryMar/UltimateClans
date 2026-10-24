package me.ulrich.clans.library.kyori.adventure.pointer;

import me.ulrich.clans.library.kyori.adventure.internal.Internals;
import me.ulrich.clans.library.kyori.adventure.key.Key;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/pointer/PointerImpl.class */
final class PointerImpl<T> implements Pointer<T> {
    private final Class<T> type;
    private final Key key;

    PointerImpl(Class<T> cls, Key key) {
        this.type = cls;
        this.key = key;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.pointer.Pointer
    @NotNull
    public Class<T> type() {
        return this.type;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.pointer.Pointer
    @NotNull
    public Key key() {
        return this.key;
    }

    public String toString() {
        return Internals.toString(this);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PointerImpl pointerImpl = (PointerImpl) obj;
        return this.type.equals(pointerImpl.type) && this.key.equals(pointerImpl.key);
    }

    public int hashCode() {
        return (31 * this.type.hashCode()) + this.key.hashCode();
    }
}
