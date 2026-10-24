package me.ulrich.clans.library.kyori.adventure.resource;

import java.util.UUID;
import java.util.function.BiConsumer;
import me.ulrich.clans.library.kyori.adventure.audience.Audience;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/resource/ResourcePackCallback.class */
@FunctionalInterface
public interface ResourcePackCallback {
    @NotNull
    static ResourcePackCallback noOp() {
        return ResourcePackCallbacks.NO_OP;
    }

    @NotNull
    static ResourcePackCallback onTerminal(@NotNull BiConsumer<UUID, Audience> biConsumer, @NotNull BiConsumer<UUID, Audience> biConsumer2) {
        return (uuid, resourcePackStatus, audience) -> {
            if (resourcePackStatus == ResourcePackStatus.SUCCESSFULLY_LOADED) {
                biConsumer.accept(uuid, audience);
            } else {
                if (resourcePackStatus.intermediate()) {
                    return;
                }
                biConsumer2.accept(uuid, audience);
            }
        };
    }

    void packEventReceived(@NotNull UUID uuid, @NotNull ResourcePackStatus resourcePackStatus, @NotNull Audience audience);
}
