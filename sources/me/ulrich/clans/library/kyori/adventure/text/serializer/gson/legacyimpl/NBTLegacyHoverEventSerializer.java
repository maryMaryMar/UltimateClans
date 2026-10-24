package me.ulrich.clans.library.kyori.adventure.text.serializer.gson.legacyimpl;

import me.ulrich.clans.library.kyori.adventure.text.serializer.gson.LegacyHoverEventSerializer;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/serializer/gson/legacyimpl/NBTLegacyHoverEventSerializer.class */
@ApiStatus.ScheduledForRemoval(inVersion = "5.0.0")
@Deprecated
public interface NBTLegacyHoverEventSerializer extends LegacyHoverEventSerializer, me.ulrich.clans.library.kyori.adventure.text.serializer.json.legacyimpl.NBTLegacyHoverEventSerializer {
    @ApiStatus.ScheduledForRemoval(inVersion = "5.0.0")
    @Deprecated
    @NotNull
    static LegacyHoverEventSerializer get() {
        return NBTLegacyHoverEventSerializerImpl.INSTANCE;
    }
}
