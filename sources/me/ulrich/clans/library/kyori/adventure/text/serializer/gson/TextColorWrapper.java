package me.ulrich.clans.library.kyori.adventure.text.serializer.gson;

import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import me.ulrich.clans.library.kyori.adventure.text.format.TextColor;
import me.ulrich.clans.library.kyori.adventure.text.format.TextDecoration;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/serializer/gson/TextColorWrapper.class */
final class TextColorWrapper {

    @Nullable
    final TextColor color;

    @Nullable
    final TextDecoration decoration;
    final boolean reset;

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/serializer/gson/TextColorWrapper$Serializer.class */
    static final class Serializer extends TypeAdapter<TextColorWrapper> {
        static final Serializer INSTANCE = new Serializer();

        private Serializer() {
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: com.google.gson.JsonSyntaxException */
        public void write(JsonWriter jsonWriter, TextColorWrapper textColorWrapper) throws JsonSyntaxException {
            throw new JsonSyntaxException("Cannot write TextColorWrapper instances");
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: com.google.gson.JsonParseException */
        /* JADX INFO: renamed from: read, reason: merged with bridge method [inline-methods] */
        public TextColorWrapper m781read(JsonReader jsonReader) throws JsonParseException {
            String strNextString = jsonReader.nextString();
            TextColor textColorFromString = TextColorSerializer.fromString(strNextString);
            TextDecoration textDecorationValue = TextDecoration.NAMES.value(strNextString);
            boolean z = textDecorationValue == null && strNextString.equals("reset");
            if (textColorFromString == null && textDecorationValue == null && !z) {
                throw new JsonParseException("Don't know how to parse " + strNextString + " at " + jsonReader.getPath());
            }
            return new TextColorWrapper(textColorFromString, textDecorationValue, z);
        }
    }

    TextColorWrapper(@Nullable TextColor textColor, @Nullable TextDecoration textDecoration, boolean z) {
        this.color = textColor;
        this.decoration = textDecoration;
        this.reset = z;
    }
}
