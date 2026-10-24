package me.ulrich.clans.library.kyori.adventure.text.serializer.gson;

import com.google.gson.TypeAdapter;
import me.ulrich.clans.library.kyori.adventure.text.event.HoverEvent;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/serializer/gson/HoverEventActionSerializer.class */
final class HoverEventActionSerializer {
    static final TypeAdapter<HoverEvent.Action<?>> INSTANCE = IndexedSerializer.lenient("hover action", HoverEvent.Action.NAMES);

    private HoverEventActionSerializer() {
    }
}
