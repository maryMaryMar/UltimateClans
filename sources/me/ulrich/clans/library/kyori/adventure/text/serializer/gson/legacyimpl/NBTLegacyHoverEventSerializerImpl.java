package me.ulrich.clans.library.kyori.adventure.text.serializer.gson.legacyimpl;

import me.ulrich.clans.library.kyori.adventure.text.Component;
import me.ulrich.clans.library.kyori.adventure.text.event.HoverEvent;
import me.ulrich.clans.library.kyori.adventure.text.serializer.gson.LegacyHoverEventSerializer;
import me.ulrich.clans.library.kyori.adventure.util.Codec;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/serializer/gson/legacyimpl/NBTLegacyHoverEventSerializerImpl.class */
@Deprecated
final class NBTLegacyHoverEventSerializerImpl implements LegacyHoverEventSerializer {
    static final NBTLegacyHoverEventSerializerImpl INSTANCE = new NBTLegacyHoverEventSerializerImpl();
    static final me.ulrich.clans.library.kyori.adventure.text.serializer.json.LegacyHoverEventSerializer NEW_INSTANCE = me.ulrich.clans.library.kyori.adventure.text.serializer.json.legacyimpl.NBTLegacyHoverEventSerializer.get();

    private NBTLegacyHoverEventSerializerImpl() {
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.serializer.json.LegacyHoverEventSerializer
    public HoverEvent.ShowItem deserializeShowItem(@NotNull Component component) {
        return NEW_INSTANCE.deserializeShowItem(component);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.serializer.json.LegacyHoverEventSerializer
    public HoverEvent.ShowEntity deserializeShowEntity(@NotNull Component component, Codec.Decoder<Component, String, ? extends RuntimeException> decoder) {
        return NEW_INSTANCE.deserializeShowEntity(component, decoder);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.serializer.json.LegacyHoverEventSerializer
    @NotNull
    public Component serializeShowItem(HoverEvent.ShowItem showItem) {
        return NEW_INSTANCE.serializeShowItem(showItem);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.serializer.json.LegacyHoverEventSerializer
    @NotNull
    public Component serializeShowEntity(HoverEvent.ShowEntity showEntity, Codec.Encoder<Component, String, ? extends RuntimeException> encoder) {
        return NEW_INSTANCE.serializeShowEntity(showEntity, encoder);
    }
}
