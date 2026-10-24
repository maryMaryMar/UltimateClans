package me.ulrich.clans.library.kyori.adventure.text.serializer.legacy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import me.ulrich.clans.library.kyori.adventure.internal.Internals;
import me.ulrich.clans.library.kyori.adventure.text.format.TextFormat;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/serializer/legacy/CharacterAndFormatImpl.class */
final class CharacterAndFormatImpl implements CharacterAndFormat {
    private final char character;
    private final TextFormat format;
    private final boolean caseInsensitive;

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/serializer/legacy/CharacterAndFormatImpl$Defaults.class */
    static final class Defaults {
        static final List<CharacterAndFormat> DEFAULTS = createDefaults();

        private Defaults() {
        }

        static List<CharacterAndFormat> createDefaults() {
            ArrayList arrayList = new ArrayList(22);
            arrayList.add(CharacterAndFormat.BLACK);
            arrayList.add(CharacterAndFormat.DARK_BLUE);
            arrayList.add(CharacterAndFormat.DARK_GREEN);
            arrayList.add(CharacterAndFormat.DARK_AQUA);
            arrayList.add(CharacterAndFormat.DARK_RED);
            arrayList.add(CharacterAndFormat.DARK_PURPLE);
            arrayList.add(CharacterAndFormat.GOLD);
            arrayList.add(CharacterAndFormat.GRAY);
            arrayList.add(CharacterAndFormat.DARK_GRAY);
            arrayList.add(CharacterAndFormat.BLUE);
            arrayList.add(CharacterAndFormat.GREEN);
            arrayList.add(CharacterAndFormat.AQUA);
            arrayList.add(CharacterAndFormat.RED);
            arrayList.add(CharacterAndFormat.LIGHT_PURPLE);
            arrayList.add(CharacterAndFormat.YELLOW);
            arrayList.add(CharacterAndFormat.WHITE);
            arrayList.add(CharacterAndFormat.OBFUSCATED);
            arrayList.add(CharacterAndFormat.BOLD);
            arrayList.add(CharacterAndFormat.STRIKETHROUGH);
            arrayList.add(CharacterAndFormat.UNDERLINED);
            arrayList.add(CharacterAndFormat.ITALIC);
            arrayList.add(CharacterAndFormat.RESET);
            return Collections.unmodifiableList(arrayList);
        }
    }

    CharacterAndFormatImpl(char c, @NotNull TextFormat textFormat, boolean z) {
        this.character = c;
        this.format = (TextFormat) Objects.requireNonNull(textFormat, "format");
        this.caseInsensitive = z;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.serializer.legacy.CharacterAndFormat
    public char character() {
        return this.character;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.serializer.legacy.CharacterAndFormat
    @NotNull
    public TextFormat format() {
        return this.format;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.serializer.legacy.CharacterAndFormat
    public boolean caseInsensitive() {
        return this.caseInsensitive;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CharacterAndFormatImpl)) {
            return false;
        }
        CharacterAndFormatImpl characterAndFormatImpl = (CharacterAndFormatImpl) obj;
        return this.character == characterAndFormatImpl.character && this.format.equals(characterAndFormatImpl.format) && this.caseInsensitive == characterAndFormatImpl.caseInsensitive;
    }

    public int hashCode() {
        return (31 * ((31 * this.character) + this.format.hashCode())) + Boolean.hashCode(this.caseInsensitive);
    }

    @NotNull
    public String toString() {
        return Internals.toString(this);
    }
}
