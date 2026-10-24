package me.ulrich.clans.library.kyori.adventure.text.serializer.gson;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.util.Locale;
import me.ulrich.clans.library.kyori.adventure.text.format.NamedTextColor;
import me.ulrich.clans.library.kyori.adventure.text.format.TextColor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/serializer/gson/TextColorSerializer.class */
final class TextColorSerializer extends TypeAdapter<TextColor> {
    static final TypeAdapter<TextColor> INSTANCE = new TextColorSerializer(false).nullSafe();
    static final TypeAdapter<TextColor> DOWNSAMPLE_COLOR = new TextColorSerializer(true).nullSafe();
    private final boolean downsampleColor;

    private TextColorSerializer(boolean z) {
        this.downsampleColor = z;
    }

    public void write(JsonWriter jsonWriter, TextColor textColor) {
        if (textColor instanceof NamedTextColor) {
            jsonWriter.value(NamedTextColor.NAMES.key((NamedTextColor) textColor));
        } else if (this.downsampleColor) {
            jsonWriter.value(NamedTextColor.NAMES.key(NamedTextColor.nearestTo(textColor)));
        } else {
            jsonWriter.value(asUpperCaseHexString(textColor));
        }
    }

    private static String asUpperCaseHexString(TextColor textColor) {
        return String.format(Locale.ROOT, "%c%06X", '#', Integer.valueOf(textColor.value()));
    }

    @Nullable
    /* JADX INFO: renamed from: read, reason: merged with bridge method [inline-methods] */
    public TextColor m779read(JsonReader jsonReader) {
        TextColor textColorFromString = fromString(jsonReader.nextString());
        if (textColorFromString == null) {
            return null;
        }
        return this.downsampleColor ? NamedTextColor.nearestTo(textColorFromString) : textColorFromString;
    }

    @Nullable
    static TextColor fromString(@NotNull String str) {
        return str.startsWith(TextColor.HEX_PREFIX) ? TextColor.fromHexString(str) : NamedTextColor.NAMES.value(str);
    }
}
