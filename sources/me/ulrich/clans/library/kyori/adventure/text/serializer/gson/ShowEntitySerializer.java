package me.ulrich.clans.library.kyori.adventure.text.serializer.gson;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.util.UUID;
import me.ulrich.clans.library.kyori.adventure.key.InvalidKeyException;
import me.ulrich.clans.library.kyori.adventure.key.Key;
import me.ulrich.clans.library.kyori.adventure.text.Component;
import me.ulrich.clans.library.kyori.adventure.text.event.HoverEvent;
import me.ulrich.clans.library.kyori.adventure.text.serializer.commons.ComponentTreeConstants;
import me.ulrich.clans.library.kyori.adventure.text.serializer.json.JSONOptions;
import me.ulrich.clans.library.kyori.option.OptionState;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/serializer/gson/ShowEntitySerializer.class */
final class ShowEntitySerializer extends TypeAdapter<HoverEvent.ShowEntity> {
    private final Gson gson;
    private final boolean emitKeyAsTypeAndUuidAsId;

    static TypeAdapter<HoverEvent.ShowEntity> create(Gson gson, OptionState optionState) {
        return new ShowEntitySerializer(gson, ((Boolean) optionState.value(JSONOptions.EMIT_HOVER_SHOW_ENTITY_KEY_AS_TYPE_AND_UUID_AS_ID)).booleanValue()).nullSafe();
    }

    private ShowEntitySerializer(Gson gson, boolean z) {
        this.gson = gson;
        this.emitKeyAsTypeAndUuidAsId = z;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.google.gson.JsonParseException */
    /* JADX INFO: renamed from: read, reason: merged with bridge method [inline-methods] */
    public HoverEvent.ShowEntity m774read(JsonReader jsonReader) throws JsonParseException {
        jsonReader.beginObject();
        Key key = null;
        UUID uuidFromString = null;
        Component component = null;
        while (jsonReader.hasNext()) {
            switch (jsonReader.nextName()) {
                case "id":
                    if (jsonReader.peek() == JsonToken.BEGIN_ARRAY) {
                        uuidFromString = (UUID) this.gson.fromJson(jsonReader, UUID.class);
                        break;
                    } else {
                        String strNextString = jsonReader.nextString();
                        if (strNextString.contains(":")) {
                            key = Key.key(strNextString);
                        }
                        try {
                            uuidFromString = UUID.fromString(strNextString);
                        } catch (IllegalArgumentException e) {
                            try {
                                key = Key.key(strNextString);
                            } catch (InvalidKeyException e2) {
                            }
                        }
                        break;
                    }
                    break;
                case "type":
                    key = (Key) this.gson.fromJson(jsonReader, Key.class);
                    break;
                case "uuid":
                    uuidFromString = (UUID) this.gson.fromJson(jsonReader, UUID.class);
                    break;
                case "name":
                    component = (Component) this.gson.fromJson(jsonReader, SerializerFactory.COMPONENT_TYPE);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        if (key == null || uuidFromString == null) {
            throw new JsonParseException("A show entity hover event needs type and id fields to be deserialized");
        }
        jsonReader.endObject();
        return HoverEvent.ShowEntity.showEntity(key, uuidFromString, component);
    }

    public void write(JsonWriter jsonWriter, HoverEvent.ShowEntity showEntity) {
        jsonWriter.beginObject();
        jsonWriter.name(this.emitKeyAsTypeAndUuidAsId ? "type" : "id");
        this.gson.toJson(showEntity.type(), SerializerFactory.KEY_TYPE, jsonWriter);
        jsonWriter.name(this.emitKeyAsTypeAndUuidAsId ? "id" : ComponentTreeConstants.SHOW_ENTITY_UUID);
        this.gson.toJson(showEntity.id(), SerializerFactory.UUID_TYPE, jsonWriter);
        Component componentName = showEntity.name();
        if (componentName != null) {
            jsonWriter.name("name");
            this.gson.toJson(componentName, SerializerFactory.COMPONENT_TYPE, jsonWriter);
        }
        jsonWriter.endObject();
    }
}
