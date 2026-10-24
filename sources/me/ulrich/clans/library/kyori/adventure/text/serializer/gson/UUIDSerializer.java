package me.ulrich.clans.library.kyori.adventure.text.serializer.gson;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.util.UUID;
import me.ulrich.clans.library.kyori.adventure.text.serializer.json.JSONOptions;
import me.ulrich.clans.library.kyori.option.OptionState;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/serializer/gson/UUIDSerializer.class */
final class UUIDSerializer extends TypeAdapter<UUID> {
    private final boolean emitIntArray;

    static TypeAdapter<UUID> uuidSerializer(OptionState optionState) {
        return new UUIDSerializer(((Boolean) optionState.value(JSONOptions.EMIT_HOVER_SHOW_ENTITY_ID_AS_INT_ARRAY)).booleanValue()).nullSafe();
    }

    private UUIDSerializer(boolean z) {
        this.emitIntArray = z;
    }

    public void write(JsonWriter jsonWriter, UUID uuid) {
        if (!this.emitIntArray) {
            jsonWriter.value(uuid.toString());
            return;
        }
        jsonWriter.beginArray().value((int) (uuid.getMostSignificantBits() >> 32)).value((int) (uuid.getMostSignificantBits() & 4294967295L)).value((int) (uuid.getLeastSignificantBits() >> 32)).value((int) (uuid.getLeastSignificantBits() & 4294967295L)).endArray();
    }

    /* JADX INFO: renamed from: read, reason: merged with bridge method [inline-methods] */
    public UUID m785read(JsonReader jsonReader) {
        if (jsonReader.peek() != JsonToken.BEGIN_ARRAY) {
            return UUID.fromString(jsonReader.nextString());
        }
        jsonReader.beginArray();
        int iNextInt = jsonReader.nextInt();
        int iNextInt2 = jsonReader.nextInt();
        int iNextInt3 = jsonReader.nextInt();
        int iNextInt4 = jsonReader.nextInt();
        jsonReader.endArray();
        return new UUID((((long) iNextInt) << 32) | (((long) iNextInt2) & 4294967295L), (((long) iNextInt3) << 32) | (((long) iNextInt4) & 4294967295L));
    }
}
