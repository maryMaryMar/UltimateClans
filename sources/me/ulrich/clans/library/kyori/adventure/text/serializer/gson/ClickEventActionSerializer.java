package me.ulrich.clans.library.kyori.adventure.text.serializer.gson;

import com.google.gson.TypeAdapter;
import me.ulrich.clans.library.kyori.adventure.text.event.ClickEvent;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/serializer/gson/ClickEventActionSerializer.class */
final class ClickEventActionSerializer {
    static final TypeAdapter<ClickEvent.Action> INSTANCE = IndexedSerializer.lenient("click action", ClickEvent.Action.NAMES);

    private ClickEventActionSerializer() {
    }
}
