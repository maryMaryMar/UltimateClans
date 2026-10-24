package me.ulrich.clans.library.kyori.adventure.platform.facet;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/platform/facet/FacetBase.class */
public abstract class FacetBase<V> implements Facet<V> {
    protected final Class<? extends V> viewerClass;

    protected FacetBase(@Nullable Class<? extends V> cls) {
        this.viewerClass = cls;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.platform.facet.Facet
    public boolean isSupported() {
        return this.viewerClass != null;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.platform.facet.Facet
    public boolean isApplicable(@NotNull V v) {
        return this.viewerClass != null && this.viewerClass.isInstance(v);
    }
}
