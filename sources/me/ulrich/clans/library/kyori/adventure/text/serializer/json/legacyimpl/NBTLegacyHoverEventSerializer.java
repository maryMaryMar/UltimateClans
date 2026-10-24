package me.ulrich.clans.library.kyori.adventure.text.serializer.json.legacyimpl;

import me.ulrich.clans.library.kyori.adventure.text.serializer.json.LegacyHoverEventSerializer;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/serializer/json/legacyimpl/NBTLegacyHoverEventSerializer.class */
public interface NBTLegacyHoverEventSerializer extends LegacyHoverEventSerializer {
    @NotNull
    static LegacyHoverEventSerializer get() {
        return NBTLegacyHoverEventSerializerImpl.INSTANCE;
    }
}
