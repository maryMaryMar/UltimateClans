package me.ulrich.clans.library.kyori.adventure.text.serializer.gson;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import me.ulrich.clans.library.kyori.adventure.key.Key;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/serializer/gson/KeySerializer.class */
final class KeySerializer extends TypeAdapter<Key> {
    static final TypeAdapter<Key> INSTANCE = new KeySerializer().nullSafe();

    private KeySerializer() {
    }

    public void write(JsonWriter jsonWriter, Key key) {
        jsonWriter.value(key.asString());
    }

    /* JADX INFO: renamed from: read, reason: merged with bridge method [inline-methods] */
    public Key m771read(JsonReader jsonReader) {
        return Key.key(jsonReader.nextString());
    }
}
