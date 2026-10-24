package me.ulrich.clans.library.kyori.adventure.platform.facet;

import me.ulrich.clans.library.kyori.adventure.key.Key;
import me.ulrich.clans.library.kyori.adventure.pointer.Pointer;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/platform/facet/FacetPointers.class */
@ApiStatus.Internal
public final class FacetPointers {
    private static final String NAMESPACE = "adventure_platform";
    public static final Pointer<String> SERVER = Pointer.pointer(String.class, Key.key(NAMESPACE, "server"));
    public static final Pointer<Key> WORLD = Pointer.pointer(Key.class, Key.key(NAMESPACE, "world"));
    public static final Pointer<Type> TYPE = Pointer.pointer(Type.class, Key.key(NAMESPACE, "type"));

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/platform/facet/FacetPointers$Type.class */
    public enum Type {
        PLAYER,
        CONSOLE,
        OTHER
    }

    private FacetPointers() {
    }
}
