package me.ulrich.clans.library.kyori.adventure.text.serializer.gson;

import com.google.gson.JsonParseException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import me.ulrich.clans.library.kyori.adventure.util.Index;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/serializer/gson/IndexedSerializer.class */
final class IndexedSerializer<E> extends TypeAdapter<E> {
    private final String name;
    private final Index<String, E> map;
    private final boolean throwOnUnknownKey;

    public static <E> TypeAdapter<E> strict(String str, Index<String, E> index) {
        return new IndexedSerializer(str, index, true).nullSafe();
    }

    public static <E> TypeAdapter<E> lenient(String str, Index<String, E> index) {
        return new IndexedSerializer(str, index, false).nullSafe();
    }

    private IndexedSerializer(String str, Index<String, E> index, boolean z) {
        this.name = str;
        this.map = index;
        this.throwOnUnknownKey = z;
    }

    public void write(JsonWriter jsonWriter, E e) {
        jsonWriter.value(this.map.key(e));
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.google.gson.JsonParseException */
    public E read(JsonReader jsonReader) throws JsonParseException {
        String strNextString = jsonReader.nextString();
        E eValue = this.map.value(strNextString);
        if (eValue != null) {
            return eValue;
        }
        if (this.throwOnUnknownKey) {
            throw new JsonParseException("invalid " + this.name + ":  " + strNextString);
        }
        return null;
    }
}
