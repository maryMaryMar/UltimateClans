package me.ulrich.clans.library.kyori.adventure.audience;

import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Consumer;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import me.ulrich.clans.library.kyori.adventure.resource.ResourcePackCallback;
import me.ulrich.clans.library.kyori.adventure.text.ComponentLike;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/audience/Audiences.class */
public final class Audiences {
    static final Collector<? super Audience, ?, ForwardingAudience> COLLECTOR = Collectors.collectingAndThen(Collectors.toCollection(ArrayList::new), arrayList -> {
        return Audience.audience(Collections.unmodifiableCollection(arrayList));
    });

    private Audiences() {
    }

    @NotNull
    public static Consumer<? super Audience> sendingMessage(@NotNull ComponentLike componentLike) {
        return audience -> {
            audience.sendMessage(componentLike);
        };
    }

    @NotNull
    static ResourcePackCallback unwrapCallback(Audience audience, Audience audience2, @NotNull ResourcePackCallback resourcePackCallback) {
        return resourcePackCallback == ResourcePackCallback.noOp() ? resourcePackCallback : (uuid, resourcePackStatus, audience3) -> {
            resourcePackCallback.packEventReceived(uuid, resourcePackStatus, audience3 == audience2 ? audience : audience3);
        };
    }
}
