package me.ulrich.clans.library.kyori.adventure.text.serializer.gson;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import me.ulrich.clans.library.kyori.adventure.key.Key;
import me.ulrich.clans.library.kyori.adventure.text.BlockNBTComponent;
import me.ulrich.clans.library.kyori.adventure.text.BuildableComponent;
import me.ulrich.clans.library.kyori.adventure.text.Component;
import me.ulrich.clans.library.kyori.adventure.text.ComponentBuilder;
import me.ulrich.clans.library.kyori.adventure.text.ComponentLike;
import me.ulrich.clans.library.kyori.adventure.text.EntityNBTComponent;
import me.ulrich.clans.library.kyori.adventure.text.KeybindComponent;
import me.ulrich.clans.library.kyori.adventure.text.NBTComponent;
import me.ulrich.clans.library.kyori.adventure.text.NBTComponentBuilder;
import me.ulrich.clans.library.kyori.adventure.text.ScoreComponent;
import me.ulrich.clans.library.kyori.adventure.text.SelectorComponent;
import me.ulrich.clans.library.kyori.adventure.text.StorageNBTComponent;
import me.ulrich.clans.library.kyori.adventure.text.TextComponent;
import me.ulrich.clans.library.kyori.adventure.text.TranslatableComponent;
import me.ulrich.clans.library.kyori.adventure.text.TranslationArgument;
import me.ulrich.clans.library.kyori.adventure.text.format.Style;
import me.ulrich.clans.library.kyori.adventure.text.serializer.json.JSONOptions;
import me.ulrich.clans.library.kyori.option.OptionState;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/serializer/gson/ComponentSerializerImpl.class */
final class ComponentSerializerImpl extends TypeAdapter<Component> {
    static final Type COMPONENT_LIST_TYPE = new TypeToken<List<Component>>() { // from class: me.ulrich.clans.library.kyori.adventure.text.serializer.gson.ComponentSerializerImpl.1
    }.getType();
    static final Type TRANSLATABLE_ARGUMENT_LIST_TYPE = new TypeToken<List<TranslationArgument>>() { // from class: me.ulrich.clans.library.kyori.adventure.text.serializer.gson.ComponentSerializerImpl.2
    }.getType();
    private final boolean emitCompactTextComponent;
    private final Gson gson;

    static TypeAdapter<Component> create(OptionState optionState, Gson gson) {
        return new ComponentSerializerImpl(((Boolean) optionState.value(JSONOptions.EMIT_COMPACT_TEXT_COMPONENT)).booleanValue(), gson).nullSafe();
    }

    private ComponentSerializerImpl(boolean z, Gson gson) {
        this.emitCompactTextComponent = z;
        this.gson = gson;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.google.gson.JsonParseException */
    /* JADX INFO: renamed from: read, reason: merged with bridge method [inline-methods] */
    public BuildableComponent<?, ?> m765read(JsonReader jsonReader) throws JsonParseException {
        ComponentBuilder componentBuilderStorage;
        JsonToken jsonTokenPeek = jsonReader.peek();
        if (jsonTokenPeek == JsonToken.STRING || jsonTokenPeek == JsonToken.NUMBER || jsonTokenPeek == JsonToken.BOOLEAN) {
            return Component.text(GsonHacks.readString(jsonReader));
        }
        if (jsonTokenPeek == JsonToken.BEGIN_ARRAY) {
            ComponentBuilder componentBuilderMo683toBuilder = null;
            jsonReader.beginArray();
            while (jsonReader.hasNext()) {
                BuildableComponent<?, ?> buildableComponentM765read = m765read(jsonReader);
                if (componentBuilderMo683toBuilder == null) {
                    componentBuilderMo683toBuilder = buildableComponentM765read.mo683toBuilder();
                } else {
                    componentBuilderMo683toBuilder.append((Component) buildableComponentM765read);
                }
            }
            if (componentBuilderMo683toBuilder == null) {
                throw notSureHowToDeserialize(jsonReader.getPath());
            }
            jsonReader.endArray();
            return componentBuilderMo683toBuilder.build2();
        }
        if (jsonTokenPeek != JsonToken.BEGIN_OBJECT) {
            throw notSureHowToDeserialize(jsonReader.getPath());
        }
        JsonObject jsonObject = new JsonObject();
        List listEmptyList = Collections.emptyList();
        String string = null;
        String strNextString = null;
        String strNextString2 = null;
        List<? extends ComponentLike> list = null;
        String strNextString3 = null;
        String strNextString4 = null;
        String strNextString5 = null;
        String strNextString6 = null;
        String strNextString7 = null;
        String strNextString8 = null;
        boolean zNextBoolean = false;
        BlockNBTComponent.Pos pos = null;
        String strNextString9 = null;
        Key key = null;
        BuildableComponent<?, ?> buildableComponentM765read2 = null;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            if (strNextName.equals("text")) {
                string = GsonHacks.readString(jsonReader);
            } else if (strNextName.equals("translate")) {
                strNextString = jsonReader.nextString();
            } else if (strNextName.equals("fallback")) {
                strNextString2 = jsonReader.nextString();
            } else if (strNextName.equals("with")) {
                list = (List) this.gson.fromJson(jsonReader, TRANSLATABLE_ARGUMENT_LIST_TYPE);
            } else if (strNextName.equals("score")) {
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    String strNextName2 = jsonReader.nextName();
                    if (strNextName2.equals("name")) {
                        strNextString3 = jsonReader.nextString();
                    } else if (strNextName2.equals("objective")) {
                        strNextString4 = jsonReader.nextString();
                    } else if (strNextName2.equals("value")) {
                        strNextString5 = jsonReader.nextString();
                    } else {
                        jsonReader.skipValue();
                    }
                }
                if (strNextString3 == null || strNextString4 == null) {
                    throw new JsonParseException("A score component requires a name and objective");
                }
                jsonReader.endObject();
            } else if (strNextName.equals("selector")) {
                strNextString6 = jsonReader.nextString();
            } else if (strNextName.equals("keybind")) {
                strNextString7 = jsonReader.nextString();
            } else if (strNextName.equals("nbt")) {
                strNextString8 = jsonReader.nextString();
            } else if (strNextName.equals("interpret")) {
                zNextBoolean = jsonReader.nextBoolean();
            } else if (strNextName.equals("block")) {
                pos = (BlockNBTComponent.Pos) this.gson.fromJson(jsonReader, SerializerFactory.BLOCK_NBT_POS_TYPE);
            } else if (strNextName.equals("entity")) {
                strNextString9 = jsonReader.nextString();
            } else if (strNextName.equals("storage")) {
                key = (Key) this.gson.fromJson(jsonReader, SerializerFactory.KEY_TYPE);
            } else if (strNextName.equals("extra")) {
                listEmptyList = (List) this.gson.fromJson(jsonReader, COMPONENT_LIST_TYPE);
            } else if (strNextName.equals("separator")) {
                buildableComponentM765read2 = m765read(jsonReader);
            } else {
                jsonObject.add(strNextName, (JsonElement) this.gson.fromJson(jsonReader, JsonElement.class));
            }
        }
        if (string != null) {
            componentBuilderStorage = Component.text().content(string);
        } else if (strNextString != null) {
            componentBuilderStorage = list != null ? Component.translatable().key(strNextString).fallback(strNextString2).arguments(list) : Component.translatable().key(strNextString).fallback(strNextString2);
        } else if (strNextString3 != null && strNextString4 != null) {
            componentBuilderStorage = strNextString5 == null ? Component.score().name(strNextString3).objective(strNextString4) : Component.score().name(strNextString3).objective(strNextString4).value(strNextString5);
        } else if (strNextString6 != null) {
            componentBuilderStorage = Component.selector().pattern(strNextString6).separator(buildableComponentM765read2);
        } else if (strNextString7 != null) {
            componentBuilderStorage = Component.keybind().keybind(strNextString7);
        } else {
            if (strNextString8 == null) {
                throw notSureHowToDeserialize(jsonReader.getPath());
            }
            if (pos != null) {
                componentBuilderStorage = ((BlockNBTComponent.Builder) nbt(Component.blockNBT(), strNextString8, zNextBoolean, buildableComponentM765read2)).pos(pos);
            } else if (strNextString9 != null) {
                componentBuilderStorage = ((EntityNBTComponent.Builder) nbt(Component.entityNBT(), strNextString8, zNextBoolean, buildableComponentM765read2)).selector(strNextString9);
            } else {
                if (key == null) {
                    throw notSureHowToDeserialize(jsonReader.getPath());
                }
                componentBuilderStorage = ((StorageNBTComponent.Builder) nbt(Component.storageNBT(), strNextString8, zNextBoolean, buildableComponentM765read2)).storage(key);
            }
        }
        componentBuilderStorage.style((Style) this.gson.fromJson(jsonObject, SerializerFactory.STYLE_TYPE)).append(listEmptyList);
        jsonReader.endObject();
        return componentBuilderStorage.build2();
    }

    private static <C extends NBTComponent<C, B>, B extends NBTComponentBuilder<C, B>> B nbt(B b, String str, boolean z, @Nullable Component component) {
        return (B) b.nbtPath(str).interpret(z).separator(component);
    }

    public void write(JsonWriter jsonWriter, Component component) {
        if ((component instanceof TextComponent) && component.children().isEmpty() && !component.hasStyling() && this.emitCompactTextComponent) {
            jsonWriter.value(((TextComponent) component).content());
            return;
        }
        jsonWriter.beginObject();
        if (component.hasStyling()) {
            JsonElement jsonTree = this.gson.toJsonTree(component.style(), SerializerFactory.STYLE_TYPE);
            if (jsonTree.isJsonObject()) {
                for (Map.Entry entry : jsonTree.getAsJsonObject().entrySet()) {
                    jsonWriter.name((String) entry.getKey());
                    this.gson.toJson((JsonElement) entry.getValue(), jsonWriter);
                }
            }
        }
        if (!component.children().isEmpty()) {
            jsonWriter.name("extra");
            this.gson.toJson(component.children(), COMPONENT_LIST_TYPE, jsonWriter);
        }
        if (component instanceof TextComponent) {
            jsonWriter.name("text");
            jsonWriter.value(((TextComponent) component).content());
        } else if (component instanceof TranslatableComponent) {
            TranslatableComponent translatableComponent = (TranslatableComponent) component;
            jsonWriter.name("translate");
            jsonWriter.value(translatableComponent.key());
            String strFallback = translatableComponent.fallback();
            if (strFallback != null) {
                jsonWriter.name("fallback");
                jsonWriter.value(strFallback);
            }
            if (!translatableComponent.arguments().isEmpty()) {
                jsonWriter.name("with");
                this.gson.toJson(translatableComponent.arguments(), TRANSLATABLE_ARGUMENT_LIST_TYPE, jsonWriter);
            }
        } else if (component instanceof ScoreComponent) {
            ScoreComponent scoreComponent = (ScoreComponent) component;
            jsonWriter.name("score");
            jsonWriter.beginObject();
            jsonWriter.name("name");
            jsonWriter.value(scoreComponent.name());
            jsonWriter.name("objective");
            jsonWriter.value(scoreComponent.objective());
            if (scoreComponent.value() != null) {
                jsonWriter.name("value");
                jsonWriter.value(scoreComponent.value());
            }
            jsonWriter.endObject();
        } else if (component instanceof SelectorComponent) {
            SelectorComponent selectorComponent = (SelectorComponent) component;
            jsonWriter.name("selector");
            jsonWriter.value(selectorComponent.pattern());
            serializeSeparator(jsonWriter, selectorComponent.separator());
        } else if (component instanceof KeybindComponent) {
            jsonWriter.name("keybind");
            jsonWriter.value(((KeybindComponent) component).keybind());
        } else {
            if (!(component instanceof NBTComponent)) {
                throw notSureHowToSerialize(component);
            }
            NBTComponent nBTComponent = (NBTComponent) component;
            jsonWriter.name("nbt");
            jsonWriter.value(nBTComponent.nbtPath());
            jsonWriter.name("interpret");
            jsonWriter.value(nBTComponent.interpret());
            serializeSeparator(jsonWriter, nBTComponent.separator());
            if (component instanceof BlockNBTComponent) {
                jsonWriter.name("block");
                this.gson.toJson(((BlockNBTComponent) component).pos(), SerializerFactory.BLOCK_NBT_POS_TYPE, jsonWriter);
            } else if (component instanceof EntityNBTComponent) {
                jsonWriter.name("entity");
                jsonWriter.value(((EntityNBTComponent) component).selector());
            } else {
                if (!(component instanceof StorageNBTComponent)) {
                    throw notSureHowToSerialize(component);
                }
                jsonWriter.name("storage");
                this.gson.toJson(((StorageNBTComponent) component).storage(), SerializerFactory.KEY_TYPE, jsonWriter);
            }
        }
        jsonWriter.endObject();
    }

    private void serializeSeparator(JsonWriter jsonWriter, @Nullable Component component) {
        if (component != null) {
            jsonWriter.name("separator");
            write(jsonWriter, component);
        }
    }

    static JsonParseException notSureHowToDeserialize(Object obj) {
        return new JsonParseException("Don't know how to turn " + obj + " into a Component");
    }

    private static IllegalArgumentException notSureHowToSerialize(Component component) {
        return new IllegalArgumentException("Don't know how to serialize " + component + " as a Component");
    }
}
