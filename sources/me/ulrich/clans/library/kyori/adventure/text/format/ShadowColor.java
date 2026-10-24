package me.ulrich.clans.library.kyori.adventure.text.format;

import me.ulrich.clans.library.kyori.adventure.util.ARGBLike;
import me.ulrich.clans.library.kyori.adventure.util.RGBLike;
import org.intellij.lang.annotations.Pattern;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/format/ShadowColor.class */
public interface ShadowColor extends StyleBuilderApplicable, ARGBLike {
    @NotNull
    static ShadowColor lerp(float f, @NotNull ARGBLike aRGBLike, @NotNull ARGBLike aRGBLike2) {
        float fMin = Math.min(1.0f, Math.max(0.0f, f));
        int iRed = aRGBLike.red();
        int iRed2 = aRGBLike2.red();
        int iGreen = aRGBLike.green();
        int iGreen2 = aRGBLike2.green();
        int iBlue = aRGBLike.blue();
        int iBlue2 = aRGBLike2.blue();
        int iAlpha = aRGBLike.alpha();
        return shadowColor(Math.round(iRed + (fMin * (iRed2 - iRed))), Math.round(iGreen + (fMin * (iGreen2 - iGreen))), Math.round(iBlue + (fMin * (iBlue2 - iBlue))), Math.round(iAlpha + (fMin * (aRGBLike2.alpha() - iAlpha))));
    }

    @NotNull
    static ShadowColor none() {
        return ShadowColorImpl.NONE;
    }

    @Contract(pure = true)
    @NotNull
    static ShadowColor shadowColor(int i) {
        return i == 0 ? none() : new ShadowColorImpl(i);
    }

    @Contract(pure = true)
    @NotNull
    static ShadowColor shadowColor(int i, int i2, int i3, int i4) {
        int i5 = ((i4 & 255) << 24) | ((i & 255) << 16) | ((i2 & 255) << 8) | (i3 & 255);
        return i5 == 0 ? none() : new ShadowColorImpl(i5);
    }

    @Contract(pure = true)
    @NotNull
    static ShadowColor shadowColor(@NotNull RGBLike rGBLike, int i) {
        return shadowColor(rGBLike.red(), rGBLike.green(), rGBLike.blue(), i);
    }

    @NotNull
    static ShadowColor shadowColor(@NotNull ARGBLike aRGBLike) {
        return aRGBLike instanceof ShadowColor ? (ShadowColor) aRGBLike : shadowColor(aRGBLike.red(), aRGBLike.green(), aRGBLike.blue(), aRGBLike.alpha());
    }

    @Contract(pure = true)
    @Nullable
    static ShadowColor fromHexString(@Pattern("#[0-9a-fA-F]{8}") @NotNull String str) {
        if (str.length() != 9 || !str.startsWith(TextColor.HEX_PREFIX)) {
            return null;
        }
        try {
            int i = Integer.parseInt(str.substring(1, 3), 16);
            int i2 = Integer.parseInt(str.substring(3, 5), 16);
            return new ShadowColorImpl((Integer.parseInt(str.substring(7, 9), 16) << 24) | (i << 16) | (i2 << 8) | Integer.parseInt(str.substring(5, 7), 16));
        } catch (NumberFormatException e) {
            return null;
        }
    }

    @NotNull
    default String asHexString() {
        int iValue = value();
        return String.format("#%02X%02X%02X%02X", Integer.valueOf((iValue >> 16) & 255), Integer.valueOf((iValue >> 8) & 255), Integer.valueOf(iValue & 255), Integer.valueOf((iValue >> 24) & 255));
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

    @Override // me.ulrich.clans.library.kyori.adventure.util.ARGBLike
    default int alpha() {
        return (value() >> 24) & 255;
    }

    int value();

    @Override // me.ulrich.clans.library.kyori.adventure.text.format.StyleBuilderApplicable
    default void styleApply(Style.Builder builder) {
        builder.shadowColor(this);
    }
}
