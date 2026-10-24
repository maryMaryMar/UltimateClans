package me.ulrich.clans.library.kyori.adventure.text.event;

import me.ulrich.clans.library.kyori.adventure.audience.Audience;
import me.ulrich.clans.library.kyori.adventure.permission.PermissionChecker;
import me.ulrich.clans.library.kyori.adventure.util.Services;
import me.ulrich.clans.library.kyori.adventure.util.TriState;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/event/ClickCallbackInternals.class */
final class ClickCallbackInternals {
    static final PermissionChecker ALWAYS_FALSE = PermissionChecker.always(TriState.FALSE);
    static final ClickCallback.Provider PROVIDER = (ClickCallback.Provider) Services.service(ClickCallback.Provider.class).orElseGet(Fallback::new);

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/event/ClickCallbackInternals$Fallback.class */
    static final class Fallback implements ClickCallback.Provider {
        Fallback() {
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.event.ClickCallback.Provider
        @NotNull
        public ClickEvent create(@NotNull ClickCallback<Audience> clickCallback, ClickCallback.Options options) {
            return ClickEvent.suggestCommand("Callbacks are not supported on this platform!");
        }
    }

    private ClickCallbackInternals() {
    }
}
