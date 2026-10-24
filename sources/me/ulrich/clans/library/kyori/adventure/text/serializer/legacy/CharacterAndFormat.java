package me.ulrich.clans.library.kyori.adventure.text.serializer.legacy;

import java.util.List;
import java.util.stream.Stream;
import me.ulrich.clans.library.kyori.adventure.text.format.NamedTextColor;
import me.ulrich.clans.library.kyori.adventure.text.format.TextDecoration;
import me.ulrich.clans.library.kyori.adventure.text.format.TextFormat;
import me.ulrich.clans.library.kyori.examination.Examinable;
import me.ulrich.clans.library.kyori.examination.ExaminableProperty;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/serializer/legacy/CharacterAndFormat.class */
@ApiStatus.NonExtendable
public interface CharacterAndFormat extends Examinable {
    public static final CharacterAndFormat BLACK = characterAndFormat('0', NamedTextColor.BLACK, true);
    public static final CharacterAndFormat DARK_BLUE = characterAndFormat('1', NamedTextColor.DARK_BLUE, true);
    public static final CharacterAndFormat DARK_GREEN = characterAndFormat('2', NamedTextColor.DARK_GREEN, true);
    public static final CharacterAndFormat DARK_AQUA = characterAndFormat('3', NamedTextColor.DARK_AQUA, true);
    public static final CharacterAndFormat DARK_RED = characterAndFormat('4', NamedTextColor.DARK_RED, true);
    public static final CharacterAndFormat DARK_PURPLE = characterAndFormat('5', NamedTextColor.DARK_PURPLE, true);
    public static final CharacterAndFormat GOLD = characterAndFormat('6', NamedTextColor.GOLD, true);
    public static final CharacterAndFormat GRAY = characterAndFormat('7', NamedTextColor.GRAY, true);
    public static final CharacterAndFormat DARK_GRAY = characterAndFormat('8', NamedTextColor.DARK_GRAY, true);
    public static final CharacterAndFormat BLUE = characterAndFormat('9', NamedTextColor.BLUE, true);
    public static final CharacterAndFormat GREEN = characterAndFormat('a', NamedTextColor.GREEN, true);
    public static final CharacterAndFormat AQUA = characterAndFormat('b', NamedTextColor.AQUA, true);
    public static final CharacterAndFormat RED = characterAndFormat('c', NamedTextColor.RED, true);
    public static final CharacterAndFormat LIGHT_PURPLE = characterAndFormat('d', NamedTextColor.LIGHT_PURPLE, true);
    public static final CharacterAndFormat YELLOW = characterAndFormat('e', NamedTextColor.YELLOW, true);
    public static final CharacterAndFormat WHITE = characterAndFormat('f', NamedTextColor.WHITE, true);
    public static final CharacterAndFormat OBFUSCATED = characterAndFormat('k', TextDecoration.OBFUSCATED, true);
    public static final CharacterAndFormat BOLD = characterAndFormat('l', TextDecoration.BOLD, true);
    public static final CharacterAndFormat STRIKETHROUGH = characterAndFormat('m', TextDecoration.STRIKETHROUGH, true);
    public static final CharacterAndFormat UNDERLINED = characterAndFormat('n', TextDecoration.UNDERLINED, true);
    public static final CharacterAndFormat ITALIC = characterAndFormat('o', TextDecoration.ITALIC, true);
    public static final CharacterAndFormat RESET = characterAndFormat('r', Reset.INSTANCE, true);

    @NotNull
    static CharacterAndFormat characterAndFormat(char c, @NotNull TextFormat textFormat) {
        return characterAndFormat(c, textFormat, false);
    }

    @NotNull
    static CharacterAndFormat characterAndFormat(char c, @NotNull TextFormat textFormat, boolean z) {
        return new CharacterAndFormatImpl(c, textFormat, z);
    }

    @NotNull
    static List<CharacterAndFormat> defaults() {
        return CharacterAndFormatImpl.Defaults.DEFAULTS;
    }

    char character();

    @NotNull
    TextFormat format();

    boolean caseInsensitive();

    @Override // me.ulrich.clans.library.kyori.examination.Examinable
    @NotNull
    default Stream<? extends ExaminableProperty> examinableProperties() {
        return Stream.of((Object[]) new ExaminableProperty[]{ExaminableProperty.of("character", character()), ExaminableProperty.of("format", format()), ExaminableProperty.of("caseInsensitive", caseInsensitive())});
    }
}
