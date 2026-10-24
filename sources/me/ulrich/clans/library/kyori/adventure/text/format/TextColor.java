package me.ulrich.clans.library.kyori.adventure.text.format;

import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.stream.Stream;
import me.ulrich.clans.library.kyori.adventure.util.HSVLike;
import me.ulrich.clans.library.kyori.adventure.util.RGBLike;
import me.ulrich.clans.library.kyori.examination.Examinable;
import me.ulrich.clans.library.kyori.examination.ExaminableProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/format/TextColor.class */
public interface TextColor extends Comparable<TextColor>, StyleBuilderApplicable, TextFormat, RGBLike, Examinable {
    public static final char HEX_CHARACTER = '#';
    public static final String HEX_PREFIX = "#";

    @NotNull
    static TextColor color(int i) {
        int i2 = i & 16777215;
        NamedTextColor namedTextColorNamedColor = NamedTextColor.namedColor(i2);
        return namedTextColorNamedColor != null ? namedTextColorNamedColor : new TextColorImpl(i2);
    }

    @NotNull
    static TextColor color(@NotNull RGBLike rGBLike) {
        return rGBLike instanceof TextColor ? (TextColor) rGBLike : color(rGBLike.red(), rGBLike.green(), rGBLike.blue());
    }

    @NotNull
    static TextColor color(@NotNull HSVLike hSVLike) {
        float fS = hSVLike.s();
        float fV = hSVLike.v();
        if (fS == 0.0f) {
            return color(fV, fV, fV);
        }
        float fH = hSVLike.h() * 6.0f;
        int iFloor = (int) Math.floor(fH);
        float f = fH - iFloor;
        float f2 = fV * (1.0f - fS);
        float f3 = fV * (1.0f - (fS * f));
        float f4 = fV * (1.0f - (fS * (1.0f - f)));
        if (iFloor == 0) {
            return color(fV, f4, f2);
        }
        if (iFloor == 1) {
            return color(f3, fV, f2);
        }
        if (iFloor == 2) {
            return color(f2, fV, f4);
        }
        if (iFloor == 3) {
            return color(f2, f3, fV);
        }
        return iFloor == 4 ? color(f4, f2, fV) : color(fV, f2, f3);
    }

    @NotNull
    static TextColor color(int i, int i2, int i3) {
        return color(((i & 255) << 16) | ((i2 & 255) << 8) | (i3 & 255));
    }

    @NotNull
    static TextColor color(float f, float f2, float f3) {
        return color((int) (f * 255.0f), (int) (f2 * 255.0f), (int) (f3 * 255.0f));
    }

    @Nullable
    static TextColor fromHexString(@NotNull String str) {
        if (!str.startsWith(HEX_PREFIX)) {
            return null;
        }
        try {
            return color(Integer.parseInt(str.substring(1), 16));
        } catch (NumberFormatException e) {
            return null;
        }
    }

    @Nullable
    static TextColor fromCSSHexString(@NotNull String str) {
        if (!str.startsWith(HEX_PREFIX)) {
            return null;
        }
        String strSubstring = str.substring(1);
        if (strSubstring.length() != 3 && strSubstring.length() != 6) {
            return null;
        }
        try {
            int i = Integer.parseInt(strSubstring, 16);
            return strSubstring.length() == 6 ? color(i) : color(((i & 3840) >> 8) | ((i & 3840) >> 4), ((i & 240) >> 4) | (i & 240), ((i & 15) << 4) | (i & 15));
        } catch (NumberFormatException e) {
            return null;
        }
    }

    int value();

    @NotNull
    default String asHexString() {
        StringBuilder sb = new StringBuilder();
        sb.append(HEX_PREFIX);
        String hexString = Integer.toHexString(value());
        for (int i = 0; i < 6 - hexString.length(); i++) {
            sb.append('0');
        }
        sb.append(hexString);
        return sb.toString().toUpperCase(Locale.ROOT);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.util.RGBLike
    default int red() {
        return (value() >> 16) & 255;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.util.RGBLike
    default int green() {
        return (value() >> 8) & 255;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.util.RGBLike
    default int blue() {
        return value() & 255;
    }

    @NotNull
    static TextColor lerp(float f, @NotNull RGBLike rGBLike, @NotNull RGBLike rGBLike2) {
        float fMin = Math.min(1.0f, Math.max(0.0f, f));
        int iRed = rGBLike.red();
        int iRed2 = rGBLike2.red();
        int iGreen = rGBLike.green();
        int iGreen2 = rGBLike2.green();
        int iBlue = rGBLike.blue();
        return color(Math.round(iRed + (fMin * (iRed2 - iRed))), Math.round(iGreen + (fMin * (iGreen2 - iGreen))), Math.round(iBlue + (fMin * (rGBLike2.blue() - iBlue))));
    }

    @NotNull
    static <C extends TextColor> C nearestColorTo(@NotNull List<C> list, @NotNull TextColor textColor) {
        Objects.requireNonNull(textColor, "color");
        float f = Float.MAX_VALUE;
        C c = list.get(0);
        int size = list.size();
        for (int i = 0; i < size; i++) {
            C c2 = list.get(i);
            float fDistance = TextColorImpl.distance(textColor.asHSV(), c2.asHSV());
            if (fDistance < f) {
                c = c2;
                f = fDistance;
            }
            if (fDistance == 0.0f) {
                break;
            }
        }
        return c;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.format.StyleBuilderApplicable
    default void styleApply(Style.Builder builder) {
        builder.color(this);
    }

    @Override // java.lang.Comparable
    default int compareTo(TextColor textColor) {
        return Integer.compare(value(), textColor.value());
    }

    @NotNull
    default Stream<? extends ExaminableProperty> examinableProperties() {
        return Stream.of(ExaminableProperty.of("value", asHexString()));
    }
}
