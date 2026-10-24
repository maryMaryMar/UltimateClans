package me.ulrich.clans.library.kyori.adventure.text.serializer.gson;

import com.google.gson.TypeAdapter;
import me.ulrich.clans.library.kyori.adventure.text.format.TextDecoration;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/serializer/gson/TextDecorationSerializer.class */
final class TextDecorationSerializer {
    static final TypeAdapter<TextDecoration> INSTANCE = IndexedSerializer.strict("text decoration", TextDecoration.NAMES);

    private TextDecorationSerializer() {
    }
}
