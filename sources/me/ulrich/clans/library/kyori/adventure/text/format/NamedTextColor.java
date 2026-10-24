package me.ulrich.clans.library.kyori.adventure.text.format;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;
import me.ulrich.clans.library.kyori.adventure.util.HSVLike;
import me.ulrich.clans.library.kyori.adventure.util.Index;
import me.ulrich.clans.library.kyori.examination.ExaminableProperty;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/format/NamedTextColor.class */
public final class NamedTextColor implements TextColor {
    private static final int BLACK_VALUE = 0;
    private final String name;
    private final int value;
    private final HSVLike hsv = HSVLike.fromRGB(red(), green(), blue());
    public static final NamedTextColor BLACK = new NamedTextColor("black", 0);
    private static final int DARK_BLUE_VALUE = 170;
    public static final NamedTextColor DARK_BLUE = new NamedTextColor("dark_blue", DARK_BLUE_VALUE);
    private static final int DARK_GREEN_VALUE = 43520;
    public static final NamedTextColor DARK_GREEN = new NamedTextColor("dark_green", DARK_GREEN_VALUE);
    private static final int DARK_AQUA_VALUE = 43690;
    public static final NamedTextColor DARK_AQUA = new NamedTextColor("dark_aqua", DARK_AQUA_VALUE);
    private static final int DARK_RED_VALUE = 11141120;
    public static final NamedTextColor DARK_RED = new NamedTextColor("dark_red", DARK_RED_VALUE);
    private static final int DARK_PURPLE_VALUE = 11141290;
    public static final NamedTextColor DARK_PURPLE = new NamedTextColor("dark_purple", DARK_PURPLE_VALUE);
    private static final int GOLD_VALUE = 16755200;
    public static final NamedTextColor GOLD = new NamedTextColor("gold", GOLD_VALUE);
    private static final int GRAY_VALUE = 11184810;
    public static final NamedTextColor GRAY = new NamedTextColor("gray", GRAY_VALUE);
    private static final int DARK_GRAY_VALUE = 5592405;
    public static final NamedTextColor DARK_GRAY = new NamedTextColor("dark_gray", DARK_GRAY_VALUE);
    private static final int BLUE_VALUE = 5592575;
    public static final NamedTextColor BLUE = new NamedTextColor("blue", BLUE_VALUE);
    private static final int GREEN_VALUE = 5635925;
    public static final NamedTextColor GREEN = new NamedTextColor("green", GREEN_VALUE);
    private static final int AQUA_VALUE = 5636095;
    public static final NamedTextColor AQUA = new NamedTextColor("aqua", AQUA_VALUE);
    private static final int RED_VALUE = 16733525;
    public static final NamedTextColor RED = new NamedTextColor("red", RED_VALUE);
    private static final int LIGHT_PURPLE_VALUE = 16733695;
    public static final NamedTextColor LIGHT_PURPLE = new NamedTextColor("light_purple", LIGHT_PURPLE_VALUE);
    private static final int YELLOW_VALUE = 16777045;
    public static final NamedTextColor YELLOW = new NamedTextColor("yellow", YELLOW_VALUE);
    private static final int WHITE_VALUE = 16777215;
    public static final NamedTextColor WHITE = new NamedTextColor("white", WHITE_VALUE);
    private static final List<NamedTextColor> VALUES = Collections.unmodifiableList(Arrays.asList(BLACK, DARK_BLUE, DARK_GREEN, DARK_AQUA, DARK_RED, DARK_PURPLE, GOLD, GRAY, DARK_GRAY, BLUE, GREEN, AQUA, RED, LIGHT_PURPLE, YELLOW, WHITE));
    public static final Index<String, NamedTextColor> NAMES = Index.create(namedTextColor -> {
        return namedTextColor.name;
    }, VALUES);

    @Nullable
    public static NamedTextColor namedColor(int i) {
        switch (i) {
            case 0:
                return BLACK;
            case DARK_BLUE_VALUE /* 170 */:
                return DARK_BLUE;
            case DARK_GREEN_VALUE /* 43520 */:
                return DARK_GREEN;
            case DARK_AQUA_VALUE /* 43690 */:
                return DARK_AQUA;
            case DARK_GRAY_VALUE /* 5592405 */:
                return DARK_GRAY;
            case BLUE_VALUE /* 5592575 */:
                return BLUE;
            case GREEN_VALUE /* 5635925 */:
                return GREEN;
            case AQUA_VALUE /* 5636095 */:
                return AQUA;
            case DARK_RED_VALUE /* 11141120 */:
                return DARK_RED;
            case DARK_PURPLE_VALUE /* 11141290 */:
                return DARK_PURPLE;
            case GRAY_VALUE /* 11184810 */:
                return GRAY;
            case RED_VALUE /* 16733525 */:
                return RED;
            case LIGHT_PURPLE_VALUE /* 16733695 */:
                return LIGHT_PURPLE;
            case GOLD_VALUE /* 16755200 */:
                return GOLD;
            case YELLOW_VALUE /* 16777045 */:
                return YELLOW;
            case WHITE_VALUE /* 16777215 */:
                return WHITE;
            default:
                return null;
        }
    }

    @ApiStatus.ScheduledForRemoval(inVersion = "5.0.0")
    @Deprecated
    @Nullable
    public static NamedTextColor ofExact(int i) {
        switch (i) {
            case 0:
                return BLACK;
            case DARK_BLUE_VALUE /* 170 */:
                return DARK_BLUE;
            case DARK_GREEN_VALUE /* 43520 */:
                return DARK_GREEN;
            case DARK_AQUA_VALUE /* 43690 */:
                return DARK_AQUA;
            case DARK_GRAY_VALUE /* 5592405 */:
                return DARK_GRAY;
            case BLUE_VALUE /* 5592575 */:
                return BLUE;
            case GREEN_VALUE /* 5635925 */:
                return GREEN;
            case AQUA_VALUE /* 5636095 */:
                return AQUA;
            case DARK_RED_VALUE /* 11141120 */:
                return DARK_RED;
            case DARK_PURPLE_VALUE /* 11141290 */:
                return DARK_PURPLE;
            case GRAY_VALUE /* 11184810 */:
                return GRAY;
            case RED_VALUE /* 16733525 */:
                return RED;
            case LIGHT_PURPLE_VALUE /* 16733695 */:
                return LIGHT_PURPLE;
            case GOLD_VALUE /* 16755200 */:
                return GOLD;
            case YELLOW_VALUE /* 16777045 */:
                return YELLOW;
            case WHITE_VALUE /* 16777215 */:
                return WHITE;
            default:
                return null;
        }
    }

    @NotNull
    public static NamedTextColor nearestTo(@NotNull TextColor textColor) {
        return textColor instanceof NamedTextColor ? (NamedTextColor) textColor : (NamedTextColor) TextColor.nearestColorTo(VALUES, textColor);
    }

    private NamedTextColor(String str, int i) {
        this.name = str;
        this.value = i;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.format.TextColor
    public int value() {
        return this.value;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.util.RGBLike
    @NotNull
    public HSVLike asHSV() {
        return this.hsv;
    }

    @NotNull
    public String toString() {
        return this.name;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.format.TextColor, me.ulrich.clans.library.kyori.examination.Examinable
    @NotNull
    public Stream<? extends ExaminableProperty> examinableProperties() {
        return Stream.concat(Stream.of(ExaminableProperty.of("name", this.name)), super.examinableProperties());
    }
}
