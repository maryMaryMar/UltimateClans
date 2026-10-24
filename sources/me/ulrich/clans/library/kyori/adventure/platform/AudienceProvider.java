package me.ulrich.clans.library.kyori.adventure.platform;

import java.util.UUID;
import java.util.function.Function;
import me.ulrich.clans.library.kyori.adventure.audience.Audience;
import me.ulrich.clans.library.kyori.adventure.key.Key;
import me.ulrich.clans.library.kyori.adventure.pointer.Pointered;
import me.ulrich.clans.library.kyori.adventure.text.flattener.ComponentFlattener;
import me.ulrich.clans.library.kyori.adventure.text.renderer.ComponentRenderer;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/platform/AudienceProvider.class */
public interface AudienceProvider extends AutoCloseable {

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/platform/AudienceProvider$Builder.class */
    public interface Builder<P extends AudienceProvider, B extends Builder<P, B>> {
        @NotNull
        B componentRenderer(@NotNull ComponentRenderer<Pointered> componentRenderer);

        @NotNull
        B partition(@NotNull Function<Pointered, ?> function);

        @NotNull
        default <T> B componentRenderer(@NotNull Function<Pointered, T> function, @NotNull ComponentRenderer<T> componentRenderer) {
            return (B) partition(function).componentRenderer(componentRenderer.mapContext(function));
        }

        @NotNull
        P build();
    }

    @NotNull
    Audience all();

    @NotNull
    Audience console();

    @NotNull
    Audience players();

    @NotNull
    Audience player(@NotNull UUID uuid);

    @NotNull
    default Audience permission(@NotNull Key key) {
        return permission(key.namespace() + '.' + key.value());
    }

    @NotNull
    Audience permission(@NotNull String str);

    @NotNull
    Audience world(@NotNull Key key);

    @NotNull
    Audience server(@NotNull String str);

    @NotNull
    ComponentFlattener flattener();

    @Override // java.lang.AutoCloseable
    void close();
}
