package me.ulrich.clans.library.kyori.adventure.bossbar;

import java.util.Collections;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/bossbar/BossBarImplementation.class */
@ApiStatus.Internal
public interface BossBarImplementation {

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/bossbar/BossBarImplementation$Provider.class */
    @ApiStatus.Internal
    public interface Provider {
        @ApiStatus.Internal
        @NotNull
        BossBarImplementation create(@NotNull BossBar bossBar);
    }

    @ApiStatus.Internal
    @NotNull
    static <I extends BossBarImplementation> I get(@NotNull BossBar bossBar, @NotNull Class<I> cls) {
        return (I) BossBarImpl.ImplementationAccessor.get(bossBar, cls);
    }

    @ApiStatus.Internal
    @NotNull
    default Iterable<? extends BossBarViewer> viewers() {
        return Collections.emptyList();
    }
}
