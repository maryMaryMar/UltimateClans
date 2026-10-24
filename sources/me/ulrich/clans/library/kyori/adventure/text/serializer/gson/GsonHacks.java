package me.ulrich.clans.library.kyori.adventure.text.serializer.gson;

import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/serializer/gson/GsonHacks.class */
final class GsonHacks {
    private GsonHacks() {
    }

    static boolean isNullOrEmpty(@Nullable JsonElement jsonElement) {
        return jsonElement == null || jsonElement.isJsonNull() || (jsonElement.isJsonArray() && jsonElement.getAsJsonArray().size() == 0) || (jsonElement.isJsonObject() && jsonElement.getAsJsonObject().entrySet().isEmpty());
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.google.gson.JsonParseException */
    static boolean readBoolean(JsonReader jsonReader) throws JsonParseException {
        JsonToken jsonTokenPeek = jsonReader.peek();
        if (jsonTokenPeek == JsonToken.BOOLEAN) {
            return jsonReader.nextBoolean();
        }
        if (jsonTokenPeek == JsonToken.STRING) {
            return Boolean.parseBoolean(jsonReader.nextString());
        }
        if (jsonTokenPeek == JsonToken.NUMBER) {
            return jsonReader.nextString().equals("1");
        }
        throw new JsonParseException("Token of type " + jsonTokenPeek + " cannot be interpreted as a boolean");
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.google.gson.JsonParseException */
    static String readString(JsonReader jsonReader) throws JsonParseException {
        JsonToken jsonTokenPeek = jsonReader.peek();
        if (jsonTokenPeek == JsonToken.STRING || jsonTokenPeek == JsonToken.NUMBER) {
            return jsonReader.nextString();
        }
        if (jsonTokenPeek == JsonToken.BOOLEAN) {
            return String.valueOf(jsonReader.nextBoolean());
        }
        throw new JsonParseException("Token of type " + jsonTokenPeek + " cannot be interpreted as a string");
    }
}
