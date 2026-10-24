package me.ulrich.clans.library.kyori.adventure.text.serializer.gson;

import com.google.gson.JsonParseException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import me.ulrich.clans.library.kyori.adventure.text.BlockNBTComponent;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/serializer/gson/BlockNBTComponentPosSerializer.class */
final class BlockNBTComponentPosSerializer extends TypeAdapter<BlockNBTComponent.Pos> {
    static final TypeAdapter<BlockNBTComponent.Pos> INSTANCE = new BlockNBTComponentPosSerializer().nullSafe();

    private BlockNBTComponentPosSerializer() {
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.google.gson.JsonParseException */
    /* JADX INFO: renamed from: read, reason: merged with bridge method [inline-methods] */
    public BlockNBTComponent.Pos m762read(JsonReader jsonReader) throws JsonParseException {
        String strNextString = jsonReader.nextString();
        try {
            return BlockNBTComponent.Pos.fromString(strNextString);
        } catch (IllegalArgumentException e) {
            throw new JsonParseException("Don't know how to turn " + strNextString + " into a Position");
        }
    }

    public void write(JsonWriter jsonWriter, BlockNBTComponent.Pos pos) {
        jsonWriter.value(pos.asString());
    }
}
