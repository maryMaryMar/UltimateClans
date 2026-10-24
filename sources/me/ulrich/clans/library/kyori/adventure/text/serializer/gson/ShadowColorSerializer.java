package me.ulrich.clans.library.kyori.adventure.text.serializer.gson;

import com.google.gson.JsonParseException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import me.ulrich.clans.library.kyori.adventure.text.format.ShadowColor;
import me.ulrich.clans.library.kyori.adventure.text.serializer.json.JSONOptions;
import me.ulrich.clans.library.kyori.option.OptionState;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/serializer/gson/ShadowColorSerializer.class */
final class ShadowColorSerializer extends TypeAdapter<ShadowColor> {
    private final boolean emitArray;

    static TypeAdapter<ShadowColor> create(OptionState optionState) {
        return new ShadowColorSerializer(optionState.value(JSONOptions.SHADOW_COLOR_MODE) == JSONOptions.ShadowColorEmitMode.EMIT_ARRAY).nullSafe();
    }

    private ShadowColorSerializer(boolean z) {
        this.emitArray = z;
    }

    public void write(JsonWriter jsonWriter, ShadowColor shadowColor) {
        if (this.emitArray) {
            jsonWriter.beginArray().value(componentAsFloat(shadowColor.red())).value(componentAsFloat(shadowColor.green())).value(componentAsFloat(shadowColor.blue())).value(componentAsFloat(shadowColor.alpha())).endArray();
        } else {
            jsonWriter.value(shadowColor.value());
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.google.gson.JsonParseException */
    /* JADX INFO: renamed from: read, reason: merged with bridge method [inline-methods] */
    public ShadowColor m773read(JsonReader jsonReader) throws JsonParseException {
        if (jsonReader.peek() != JsonToken.BEGIN_ARRAY) {
            return ShadowColor.shadowColor(jsonReader.nextInt());
        }
        jsonReader.beginArray();
        double dNextDouble = jsonReader.nextDouble();
        double dNextDouble2 = jsonReader.nextDouble();
        double dNextDouble3 = jsonReader.nextDouble();
        double dNextDouble4 = jsonReader.nextDouble();
        if (jsonReader.peek() != JsonToken.END_ARRAY) {
            throw new JsonParseException("Failed to parse shadow colour at " + jsonReader.getPath() + ": expected end of 4-element array but got " + jsonReader.peek() + " instead.");
        }
        jsonReader.endArray();
        return ShadowColor.shadowColor(componentFromFloat(dNextDouble), componentFromFloat(dNextDouble2), componentFromFloat(dNextDouble3), componentFromFloat(dNextDouble4));
    }

    static float componentAsFloat(int i) {
        return i / 255.0f;
    }

    static int componentFromFloat(double d) {
        return (int) (((float) d) * 255.0f);
    }
}
