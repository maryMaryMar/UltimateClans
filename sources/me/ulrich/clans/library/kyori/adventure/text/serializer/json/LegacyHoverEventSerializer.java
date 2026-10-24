package me.ulrich.clans.library.kyori.adventure.text.serializer.json;

import me.ulrich.clans.library.kyori.adventure.text.Component;
import me.ulrich.clans.library.kyori.adventure.text.event.HoverEvent;
import me.ulrich.clans.library.kyori.adventure.util.Codec;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/serializer/json/LegacyHoverEventSerializer.class */
public interface LegacyHoverEventSerializer {
    HoverEvent.ShowItem deserializeShowItem(@NotNull Component component);

    @NotNull
    Component serializeShowItem(HoverEvent.ShowItem showItem);

    HoverEvent.ShowEntity deserializeShowEntity(@NotNull Component component, Codec.Decoder<Component, String, ? extends RuntimeException> decoder);

    @NotNull
    Component serializeShowEntity(HoverEvent.ShowEntity showEntity, Codec.Encoder<Component, String, ? extends RuntimeException> encoder);
}
