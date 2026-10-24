package me.ulrich.clans.library.kyori.adventure.text.serializer.gson;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonParseException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.util.HashMap;
import java.util.Map;
import me.ulrich.clans.library.kyori.adventure.key.Key;
import me.ulrich.clans.library.kyori.adventure.nbt.api.BinaryTagHolder;
import me.ulrich.clans.library.kyori.adventure.text.event.DataComponentValue;
import me.ulrich.clans.library.kyori.adventure.text.event.HoverEvent;
import me.ulrich.clans.library.kyori.adventure.text.serializer.json.JSONOptions;
import me.ulrich.clans.library.kyori.option.OptionState;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/serializer/gson/ShowItemSerializer.class */
final class ShowItemSerializer extends TypeAdapter<HoverEvent.ShowItem> {
    private static final String LEGACY_SHOW_ITEM_TAG = "tag";
    private static final String DATA_COMPONENT_REMOVAL_PREFIX = "!";
    private final Gson gson;
    private final boolean emitDefaultQuantity;
    private final JSONOptions.ShowItemHoverDataMode itemDataMode;

    static TypeAdapter<HoverEvent.ShowItem> create(Gson gson, OptionState optionState) {
        return new ShowItemSerializer(gson, ((Boolean) optionState.value(JSONOptions.EMIT_DEFAULT_ITEM_HOVER_QUANTITY)).booleanValue(), (JSONOptions.ShowItemHoverDataMode) optionState.value(JSONOptions.SHOW_ITEM_HOVER_DATA_MODE)).nullSafe();
    }

    private ShowItemSerializer(Gson gson, boolean z, JSONOptions.ShowItemHoverDataMode showItemHoverDataMode) {
        this.gson = gson;
        this.emitDefaultQuantity = z;
        this.itemDataMode = showItemHoverDataMode;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.google.gson.JsonParseException */
    /* JADX INFO: renamed from: read, reason: merged with bridge method [inline-methods] */
    public HoverEvent.ShowItem m775read(JsonReader jsonReader) throws JsonParseException {
        Key key;
        boolean z;
        jsonReader.beginObject();
        Key key2 = null;
        int iNextInt = 1;
        BinaryTagHolder binaryTagHolder = null;
        HashMap map = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            if (strNextName.equals("id")) {
                key2 = (Key) this.gson.fromJson(jsonReader, SerializerFactory.KEY_TYPE);
            } else if (strNextName.equals("count")) {
                iNextInt = jsonReader.nextInt();
            } else if (strNextName.equals("tag")) {
                JsonToken jsonTokenPeek = jsonReader.peek();
                if (jsonTokenPeek == JsonToken.STRING || jsonTokenPeek == JsonToken.NUMBER) {
                    binaryTagHolder = BinaryTagHolder.binaryTagHolder(jsonReader.nextString());
                } else if (jsonTokenPeek == JsonToken.BOOLEAN) {
                    binaryTagHolder = BinaryTagHolder.binaryTagHolder(String.valueOf(jsonReader.nextBoolean()));
                } else {
                    if (jsonTokenPeek != JsonToken.NULL) {
                        throw new JsonParseException("Expected tag to be a string");
                    }
                    jsonReader.nextNull();
                }
            } else if (strNextName.equals("components")) {
                jsonReader.beginObject();
                while (jsonReader.peek() != JsonToken.END_OBJECT) {
                    String strNextName2 = jsonReader.nextName();
                    if (strNextName2.startsWith("!")) {
                        key = Key.key(strNextName2.substring(1));
                        z = true;
                    } else {
                        key = Key.key(strNextName2);
                        z = false;
                    }
                    JsonElement jsonElement = (JsonElement) this.gson.fromJson(jsonReader, JsonElement.class);
                    if (map == null) {
                        map = new HashMap();
                    }
                    map.put(key, z ? DataComponentValue.removed() : GsonDataComponentValue.gsonDataComponentValue(jsonElement));
                }
                jsonReader.endObject();
            } else {
                jsonReader.skipValue();
            }
        }
        if (key2 == null) {
            throw new JsonParseException("Not sure how to deserialize show_item hover event");
        }
        jsonReader.endObject();
        return map != null ? HoverEvent.ShowItem.showItem(key2, iNextInt, map) : HoverEvent.ShowItem.showItem(key2, iNextInt, binaryTagHolder);
    }

    public void write(JsonWriter jsonWriter, HoverEvent.ShowItem showItem) {
        jsonWriter.beginObject();
        jsonWriter.name("id");
        this.gson.toJson(showItem.item(), SerializerFactory.KEY_TYPE, jsonWriter);
        int iCount = showItem.count();
        if (iCount != 1 || this.emitDefaultQuantity) {
            jsonWriter.name("count");
            jsonWriter.value(iCount);
        }
        if (!showItem.dataComponents().isEmpty() && this.itemDataMode != JSONOptions.ShowItemHoverDataMode.EMIT_LEGACY_NBT) {
            jsonWriter.name("components");
            jsonWriter.beginObject();
            for (Map.Entry entry : showItem.dataComponentsAs(GsonDataComponentValue.class).entrySet()) {
                JsonElement jsonElementElement = ((GsonDataComponentValue) entry.getValue()).element();
                if (jsonElementElement instanceof JsonNull) {
                    jsonWriter.name("!" + ((Key) entry.getKey()).asString());
                    jsonWriter.beginObject().endObject();
                } else {
                    jsonWriter.name(((Key) entry.getKey()).asString());
                    this.gson.toJson(jsonElementElement, jsonWriter);
                }
            }
            jsonWriter.endObject();
        } else if (this.itemDataMode != JSONOptions.ShowItemHoverDataMode.EMIT_DATA_COMPONENTS) {
            maybeWriteLegacy(jsonWriter, showItem);
        }
        jsonWriter.endObject();
    }

    private static void maybeWriteLegacy(JsonWriter jsonWriter, HoverEvent.ShowItem showItem) {
        BinaryTagHolder binaryTagHolderNbt = showItem.nbt();
        if (binaryTagHolderNbt != null) {
            jsonWriter.name("tag");
            jsonWriter.value(binaryTagHolderNbt.string());
        }
    }
}
