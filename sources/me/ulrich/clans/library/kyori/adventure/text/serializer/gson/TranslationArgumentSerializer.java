package me.ulrich.clans.library.kyori.adventure.text.serializer.gson;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import me.ulrich.clans.library.kyori.adventure.text.Component;
import me.ulrich.clans.library.kyori.adventure.text.ComponentLike;
import me.ulrich.clans.library.kyori.adventure.text.TranslationArgument;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/serializer/gson/TranslationArgumentSerializer.class */
final class TranslationArgumentSerializer extends TypeAdapter<TranslationArgument> {
    private final Gson gson;

    /* JADX INFO: renamed from: me.ulrich.clans.library.kyori.adventure.text.serializer.gson.TranslationArgumentSerializer$1, reason: invalid class name */
    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/serializer/gson/TranslationArgumentSerializer$1.class */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$gson$stream$JsonToken = new int[JsonToken.values().length];

        static {
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.BOOLEAN.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.NUMBER.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    static TypeAdapter<TranslationArgument> create(Gson gson) {
        return new TranslationArgumentSerializer(gson).nullSafe();
    }

    private TranslationArgumentSerializer(Gson gson) {
        this.gson = gson;
    }

    public void write(JsonWriter jsonWriter, TranslationArgument translationArgument) {
        Object objValue = translationArgument.value();
        if (objValue instanceof Boolean) {
            jsonWriter.value((Boolean) objValue);
        } else if (objValue instanceof Number) {
            jsonWriter.value((Number) objValue);
        } else {
            if (!(objValue instanceof Component)) {
                throw new IllegalStateException("Unable to serialize translatable argument of type " + objValue.getClass() + ": " + objValue);
            }
            this.gson.toJson(objValue, SerializerFactory.COMPONENT_TYPE, jsonWriter);
        }
    }

    /* JADX INFO: renamed from: read, reason: merged with bridge method [inline-methods] */
    public TranslationArgument m783read(JsonReader jsonReader) {
        switch (AnonymousClass1.$SwitchMap$com$google$gson$stream$JsonToken[jsonReader.peek().ordinal()]) {
            case 1:
                return TranslationArgument.bool(jsonReader.nextBoolean());
            case 2:
                return TranslationArgument.numeric((Number) this.gson.fromJson(jsonReader, Number.class));
            default:
                return TranslationArgument.component((ComponentLike) this.gson.fromJson(jsonReader, SerializerFactory.COMPONENT_TYPE));
        }
    }
}
