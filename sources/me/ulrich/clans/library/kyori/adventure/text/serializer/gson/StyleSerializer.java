package me.ulrich.clans.library.kyori.adventure.text.serializer.gson;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.EnumSet;
import java.util.Map;
import me.ulrich.clans.library.kyori.adventure.key.Key;
import me.ulrich.clans.library.kyori.adventure.text.Component;
import me.ulrich.clans.library.kyori.adventure.text.event.ClickEvent;
import me.ulrich.clans.library.kyori.adventure.text.event.HoverEvent;
import me.ulrich.clans.library.kyori.adventure.text.event.HoverEventSource;
import me.ulrich.clans.library.kyori.adventure.text.format.ShadowColor;
import me.ulrich.clans.library.kyori.adventure.text.format.Style;
import me.ulrich.clans.library.kyori.adventure.text.format.TextColor;
import me.ulrich.clans.library.kyori.adventure.text.format.TextDecoration;
import me.ulrich.clans.library.kyori.adventure.text.serializer.commons.ComponentTreeConstants;
import me.ulrich.clans.library.kyori.adventure.text.serializer.json.JSONOptions;
import me.ulrich.clans.library.kyori.adventure.util.ARGBLike;
import me.ulrich.clans.library.kyori.adventure.util.Codec;
import me.ulrich.clans.library.kyori.option.OptionState;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/serializer/gson/StyleSerializer.class */
final class StyleSerializer extends TypeAdapter<Style> {
    private static final TextDecoration[] DECORATIONS;
    private final me.ulrich.clans.library.kyori.adventure.text.serializer.json.LegacyHoverEventSerializer legacyHover;
    private final boolean emitValueFieldHover;
    private final boolean emitCamelCaseHover;
    private final boolean emitSnakeCaseHover;
    private final boolean emitCamelCaseClick;
    private final boolean emitSnakeCaseClick;
    private final boolean strictEventValues;
    private final boolean emitShadowColor;
    private final Gson gson;
    static final /* synthetic */ boolean $assertionsDisabled;

    static TypeAdapter<Style> create(me.ulrich.clans.library.kyori.adventure.text.serializer.json.LegacyHoverEventSerializer legacyHoverEventSerializer, OptionState optionState, Gson gson) {
        JSONOptions.HoverEventValueMode hoverEventValueMode = (JSONOptions.HoverEventValueMode) optionState.value(JSONOptions.EMIT_HOVER_EVENT_TYPE);
        JSONOptions.ClickEventValueMode clickEventValueMode = (JSONOptions.ClickEventValueMode) optionState.value(JSONOptions.EMIT_CLICK_EVENT_TYPE);
        return new StyleSerializer(legacyHoverEventSerializer, hoverEventValueMode == JSONOptions.HoverEventValueMode.VALUE_FIELD || hoverEventValueMode == JSONOptions.HoverEventValueMode.ALL, hoverEventValueMode == JSONOptions.HoverEventValueMode.CAMEL_CASE || hoverEventValueMode == JSONOptions.HoverEventValueMode.ALL, hoverEventValueMode == JSONOptions.HoverEventValueMode.SNAKE_CASE || hoverEventValueMode == JSONOptions.HoverEventValueMode.ALL, clickEventValueMode == JSONOptions.ClickEventValueMode.CAMEL_CASE || clickEventValueMode == JSONOptions.ClickEventValueMode.BOTH, clickEventValueMode == JSONOptions.ClickEventValueMode.SNAKE_CASE || clickEventValueMode == JSONOptions.ClickEventValueMode.BOTH, ((Boolean) optionState.value(JSONOptions.VALIDATE_STRICT_EVENTS)).booleanValue(), optionState.value(JSONOptions.SHADOW_COLOR_MODE) != JSONOptions.ShadowColorEmitMode.NONE, gson).nullSafe();
    }

    private StyleSerializer(me.ulrich.clans.library.kyori.adventure.text.serializer.json.LegacyHoverEventSerializer legacyHoverEventSerializer, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, Gson gson) {
        this.legacyHover = legacyHoverEventSerializer;
        this.emitValueFieldHover = z;
        this.emitCamelCaseHover = z2;
        this.emitSnakeCaseHover = z3;
        this.emitCamelCaseClick = z4;
        this.emitSnakeCaseClick = z5;
        this.strictEventValues = z6;
        this.emitShadowColor = z7;
        this.gson = gson;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.google.gson.JsonParseException */
    /* JADX INFO: renamed from: read, reason: merged with bridge method [inline-methods] */
    public Style m777read(JsonReader jsonReader) throws JsonParseException {
        JsonPrimitive asJsonPrimitive;
        Object objFromJson;
        jsonReader.beginObject();
        Style.Builder builderStyle = Style.style();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            if (strNextName.equals("font")) {
                builderStyle.font((Key) this.gson.fromJson(jsonReader, SerializerFactory.KEY_TYPE));
            } else if (strNextName.equals("color")) {
                TextColorWrapper textColorWrapper = (TextColorWrapper) this.gson.fromJson(jsonReader, SerializerFactory.COLOR_WRAPPER_TYPE);
                if (textColorWrapper.color != null) {
                    builderStyle.color(textColorWrapper.color);
                } else if (textColorWrapper.decoration != null) {
                    builderStyle.decoration(textColorWrapper.decoration, TextDecoration.State.TRUE);
                }
            } else if (strNextName.equals("shadow_color")) {
                builderStyle.shadowColor((ARGBLike) this.gson.fromJson(jsonReader, SerializerFactory.SHADOW_COLOR_TYPE));
            } else if (TextDecoration.NAMES.keys().contains(strNextName)) {
                builderStyle.decoration(TextDecoration.NAMES.value(strNextName), GsonHacks.readBoolean(jsonReader));
            } else if (strNextName.equals("insertion")) {
                builderStyle.insertion(jsonReader.nextString());
            } else if (strNextName.equals(ComponentTreeConstants.CLICK_EVENT_SNAKE) || strNextName.equals("clickEvent")) {
                jsonReader.beginObject();
                ClickEvent.Action action = null;
                String strNextString = null;
                while (jsonReader.hasNext()) {
                    String strNextName2 = jsonReader.nextName();
                    if (strNextName2.equals("action")) {
                        action = (ClickEvent.Action) this.gson.fromJson(jsonReader, SerializerFactory.CLICK_ACTION_TYPE);
                    } else if (!strNextName2.equals("value") && !strNextName2.equals(ComponentTreeConstants.CLICK_EVENT_URL) && !strNextName2.equals(ComponentTreeConstants.CLICK_EVENT_PATH) && !strNextName2.equals(ComponentTreeConstants.CLICK_EVENT_COMMAND) && !strNextName2.equals(ComponentTreeConstants.CLICK_EVENT_PAGE)) {
                        jsonReader.skipValue();
                    } else if (jsonReader.peek() != JsonToken.NULL) {
                        strNextString = jsonReader.nextString();
                    } else {
                        if (this.strictEventValues) {
                            throw ComponentSerializerImpl.notSureHowToDeserialize(strNextName2);
                        }
                        jsonReader.nextNull();
                    }
                }
                if (action != null && action.readable() && strNextString != null) {
                    builderStyle.clickEvent(ClickEvent.clickEvent(action, strNextString));
                }
                jsonReader.endObject();
            } else if (strNextName.equals(ComponentTreeConstants.HOVER_EVENT_SNAKE) || strNextName.equals("hoverEvent")) {
                JsonObject jsonObject = (JsonObject) this.gson.fromJson(jsonReader, JsonObject.class);
                if (jsonObject != null && (asJsonPrimitive = jsonObject.getAsJsonPrimitive("action")) != null) {
                    HoverEvent.Action<?> action2 = (HoverEvent.Action) this.gson.fromJson(asJsonPrimitive, SerializerFactory.HOVER_ACTION_TYPE);
                    if (action2.readable()) {
                        Class<?> clsType = action2.type();
                        if (jsonObject.has("contents")) {
                            JsonElement jsonElement = jsonObject.get("contents");
                            if (GsonHacks.isNullOrEmpty(jsonElement)) {
                                if (this.strictEventValues) {
                                    throw ComponentSerializerImpl.notSureHowToDeserialize(jsonElement);
                                }
                                objFromJson = null;
                            } else if (SerializerFactory.COMPONENT_TYPE.isAssignableFrom(clsType)) {
                                objFromJson = this.gson.fromJson(jsonElement, SerializerFactory.COMPONENT_TYPE);
                            } else if (SerializerFactory.SHOW_ITEM_TYPE.isAssignableFrom(clsType)) {
                                objFromJson = this.gson.fromJson(jsonElement, SerializerFactory.SHOW_ITEM_TYPE);
                            } else {
                                objFromJson = SerializerFactory.SHOW_ENTITY_TYPE.isAssignableFrom(clsType) ? this.gson.fromJson(jsonElement, SerializerFactory.SHOW_ENTITY_TYPE) : null;
                            }
                        } else if (jsonObject.has("value")) {
                            JsonElement jsonElement2 = jsonObject.get("value");
                            if (GsonHacks.isNullOrEmpty(jsonElement2)) {
                                if (this.strictEventValues) {
                                    throw ComponentSerializerImpl.notSureHowToDeserialize(jsonElement2);
                                }
                                objFromJson = null;
                            } else if (SerializerFactory.COMPONENT_TYPE.isAssignableFrom(clsType)) {
                                objFromJson = legacyHoverEventContents(action2, (Component) this.gson.fromJson(jsonElement2, SerializerFactory.COMPONENT_TYPE));
                            } else {
                                objFromJson = SerializerFactory.STRING_TYPE.isAssignableFrom(clsType) ? this.gson.fromJson(jsonElement2, SerializerFactory.STRING_TYPE) : null;
                            }
                        } else if (SerializerFactory.SHOW_ITEM_TYPE.isAssignableFrom(clsType)) {
                            objFromJson = this.gson.fromJson(jsonObject, SerializerFactory.SHOW_ITEM_TYPE);
                        } else if (SerializerFactory.SHOW_ENTITY_TYPE.isAssignableFrom(clsType)) {
                            objFromJson = this.gson.fromJson(jsonObject, SerializerFactory.SHOW_ENTITY_TYPE);
                        } else {
                            if (this.strictEventValues) {
                                throw ComponentSerializerImpl.notSureHowToDeserialize(jsonObject);
                            }
                            objFromJson = null;
                        }
                        if (objFromJson != null) {
                            builderStyle.hoverEvent((HoverEventSource<?>) HoverEvent.hoverEvent(action2, objFromJson));
                        }
                    } else {
                        continue;
                    }
                }
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        return builderStyle.build2();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.google.gson.JsonParseException */
    private Object legacyHoverEventContents(HoverEvent.Action<?> action, Component component) throws JsonParseException {
        if (action == HoverEvent.Action.SHOW_TEXT) {
            return component;
        }
        if (this.legacyHover != null) {
            try {
                if (action == HoverEvent.Action.SHOW_ENTITY) {
                    return this.legacyHover.deserializeShowEntity(component, decoder());
                }
                if (action == HoverEvent.Action.SHOW_ITEM) {
                    return this.legacyHover.deserializeShowItem(component);
                }
            } catch (IOException e) {
                throw new JsonParseException(e);
            }
        }
        throw new UnsupportedOperationException();
    }

    private Codec.Decoder<Component, String, JsonParseException> decoder() {
        return str -> {
            return (Component) this.gson.fromJson(str, SerializerFactory.COMPONENT_TYPE);
        };
    }

    private Codec.Encoder<Component, String, JsonParseException> encoder() {
        return component -> {
            return this.gson.toJson(component, SerializerFactory.COMPONENT_TYPE);
        };
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.google.gson.JsonParseException */
    /* JADX INFO: Thrown type has an unknown type hierarchy: com.google.gson.JsonSyntaxException */
    public void write(JsonWriter jsonWriter, Style style) throws JsonParseException, JsonSyntaxException {
        jsonWriter.beginObject();
        int length = DECORATIONS.length;
        for (int i = 0; i < length; i++) {
            TextDecoration textDecoration = DECORATIONS[i];
            TextDecoration.State stateDecoration = style.decoration(textDecoration);
            if (stateDecoration != TextDecoration.State.NOT_SET) {
                String strKey = TextDecoration.NAMES.key(textDecoration);
                if (!$assertionsDisabled && strKey == null) {
                    throw new AssertionError();
                }
                jsonWriter.name(strKey);
                jsonWriter.value(stateDecoration == TextDecoration.State.TRUE);
            }
        }
        TextColor textColorColor = style.color();
        if (textColorColor != null) {
            jsonWriter.name("color");
            this.gson.toJson(textColorColor, SerializerFactory.COLOR_TYPE, jsonWriter);
        }
        ShadowColor shadowColor = style.shadowColor();
        if (shadowColor != null && this.emitShadowColor) {
            jsonWriter.name("shadow_color");
            this.gson.toJson(shadowColor, SerializerFactory.SHADOW_COLOR_TYPE, jsonWriter);
        }
        String strInsertion = style.insertion();
        if (strInsertion != null) {
            jsonWriter.name("insertion");
            jsonWriter.value(strInsertion);
        }
        ClickEvent clickEvent = style.clickEvent();
        if (clickEvent != null) {
            ClickEvent.Action action = clickEvent.action();
            if (this.emitSnakeCaseClick) {
                jsonWriter.name(ComponentTreeConstants.CLICK_EVENT_SNAKE);
                jsonWriter.beginObject();
                jsonWriter.name("action");
                this.gson.toJson(action, SerializerFactory.CLICK_ACTION_TYPE, jsonWriter);
                if (action == ClickEvent.Action.OPEN_URL) {
                    jsonWriter.name(ComponentTreeConstants.CLICK_EVENT_URL);
                } else if (action == ClickEvent.Action.OPEN_FILE) {
                    jsonWriter.name(ComponentTreeConstants.CLICK_EVENT_PATH);
                } else if (action == ClickEvent.Action.RUN_COMMAND || action == ClickEvent.Action.SUGGEST_COMMAND) {
                    jsonWriter.name(ComponentTreeConstants.CLICK_EVENT_COMMAND);
                } else if (action == ClickEvent.Action.CHANGE_PAGE) {
                    jsonWriter.name(ComponentTreeConstants.CLICK_EVENT_PAGE);
                } else {
                    jsonWriter.name("value");
                }
                if (action == ClickEvent.Action.CHANGE_PAGE) {
                    jsonWriter.value(Integer.parseInt(clickEvent.value()));
                } else if (action != ClickEvent.Action.OPEN_URL || clickEvent.value().startsWith("http://") || clickEvent.value().startsWith("https://")) {
                    jsonWriter.value(clickEvent.value());
                } else {
                    jsonWriter.value("https://" + clickEvent.value());
                }
                jsonWriter.endObject();
            }
            if (this.emitCamelCaseClick) {
                jsonWriter.name("clickEvent");
                jsonWriter.beginObject();
                jsonWriter.name("action");
                this.gson.toJson(action, SerializerFactory.CLICK_ACTION_TYPE, jsonWriter);
                jsonWriter.name("value");
                jsonWriter.value(clickEvent.value());
                jsonWriter.endObject();
            }
        }
        HoverEvent<?> hoverEvent = style.hoverEvent();
        if (hoverEvent != null && (((this.emitSnakeCaseHover || this.emitCamelCaseHover) && hoverEvent.action() != HoverEvent.Action.SHOW_ACHIEVEMENT) || this.emitValueFieldHover)) {
            HoverEvent.Action<?> action2 = hoverEvent.action();
            if (this.emitSnakeCaseHover && action2 != HoverEvent.Action.SHOW_ACHIEVEMENT) {
                jsonWriter.name(ComponentTreeConstants.HOVER_EVENT_SNAKE);
                jsonWriter.beginObject();
                jsonWriter.name("action");
                this.gson.toJson(action2, SerializerFactory.HOVER_ACTION_TYPE, jsonWriter);
                if (action2 == HoverEvent.Action.SHOW_ITEM) {
                    for (Map.Entry entry : this.gson.toJsonTree(hoverEvent.value(), SerializerFactory.SHOW_ITEM_TYPE).getAsJsonObject().entrySet()) {
                        jsonWriter.name((String) entry.getKey());
                        this.gson.toJson((JsonElement) entry.getValue(), jsonWriter);
                    }
                } else if (action2 == HoverEvent.Action.SHOW_ENTITY) {
                    for (Map.Entry entry2 : this.gson.toJsonTree(hoverEvent.value(), SerializerFactory.SHOW_ENTITY_TYPE).getAsJsonObject().entrySet()) {
                        jsonWriter.name((String) entry2.getKey());
                        this.gson.toJson((JsonElement) entry2.getValue(), jsonWriter);
                    }
                } else {
                    if (action2 != HoverEvent.Action.SHOW_TEXT) {
                        throw new JsonParseException("Don't know how to serialize " + hoverEvent.value());
                    }
                    jsonWriter.name("value");
                    this.gson.toJson(hoverEvent.value(), SerializerFactory.COMPONENT_TYPE, jsonWriter);
                }
                jsonWriter.endObject();
            }
            if (this.emitCamelCaseHover || this.emitValueFieldHover) {
                jsonWriter.name("hoverEvent");
                jsonWriter.beginObject();
                jsonWriter.name("action");
                this.gson.toJson(action2, SerializerFactory.HOVER_ACTION_TYPE, jsonWriter);
                if (this.emitCamelCaseHover && action2 != HoverEvent.Action.SHOW_ACHIEVEMENT) {
                    jsonWriter.name("contents");
                    if (action2 == HoverEvent.Action.SHOW_ITEM) {
                        this.gson.toJson(hoverEvent.value(), SerializerFactory.SHOW_ITEM_TYPE, jsonWriter);
                    } else if (action2 == HoverEvent.Action.SHOW_ENTITY) {
                        this.gson.toJson(hoverEvent.value(), SerializerFactory.SHOW_ENTITY_TYPE, jsonWriter);
                    } else {
                        if (action2 != HoverEvent.Action.SHOW_TEXT) {
                            throw new JsonParseException("Don't know how to serialize " + hoverEvent.value());
                        }
                        this.gson.toJson(hoverEvent.value(), SerializerFactory.COMPONENT_TYPE, jsonWriter);
                    }
                }
                if (this.emitValueFieldHover) {
                    jsonWriter.name("value");
                    serializeLegacyHoverEvent(hoverEvent, jsonWriter);
                }
                jsonWriter.endObject();
            }
        }
        Key keyFont = style.font();
        if (keyFont != null) {
            jsonWriter.name("font");
            this.gson.toJson(keyFont, SerializerFactory.KEY_TYPE, jsonWriter);
        }
        jsonWriter.endObject();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.google.gson.JsonSyntaxException */
    private void serializeLegacyHoverEvent(HoverEvent<?> hoverEvent, JsonWriter jsonWriter) throws JsonSyntaxException {
        if (hoverEvent.action() == HoverEvent.Action.SHOW_TEXT) {
            this.gson.toJson(hoverEvent.value(), SerializerFactory.COMPONENT_TYPE, jsonWriter);
            return;
        }
        if (hoverEvent.action() == HoverEvent.Action.SHOW_ACHIEVEMENT) {
            this.gson.toJson(hoverEvent.value(), String.class, jsonWriter);
            return;
        }
        if (this.legacyHover == null) {
            jsonWriter.nullValue();
            return;
        }
        Component componentSerializeShowItem = null;
        try {
            if (hoverEvent.action() == HoverEvent.Action.SHOW_ENTITY) {
                componentSerializeShowItem = this.legacyHover.serializeShowEntity((HoverEvent.ShowEntity) hoverEvent.value(), encoder());
            } else if (hoverEvent.action() == HoverEvent.Action.SHOW_ITEM) {
                componentSerializeShowItem = this.legacyHover.serializeShowItem((HoverEvent.ShowItem) hoverEvent.value());
            }
            if (componentSerializeShowItem != null) {
                this.gson.toJson(componentSerializeShowItem, SerializerFactory.COMPONENT_TYPE, jsonWriter);
            } else {
                jsonWriter.nullValue();
            }
        } catch (IOException e) {
            throw new JsonSyntaxException(e);
        }
    }

    static {
        $assertionsDisabled = !StyleSerializer.class.desiredAssertionStatus();
        DECORATIONS = new TextDecoration[]{TextDecoration.BOLD, TextDecoration.ITALIC, TextDecoration.UNDERLINED, TextDecoration.STRIKETHROUGH, TextDecoration.OBFUSCATED};
        EnumSet enumSetAllOf = EnumSet.allOf(TextDecoration.class);
        for (TextDecoration textDecoration : DECORATIONS) {
            enumSetAllOf.remove(textDecoration);
        }
        if (!enumSetAllOf.isEmpty()) {
            throw new IllegalStateException("Gson serializer is missing some text decorations: " + enumSetAllOf);
        }
    }
}
