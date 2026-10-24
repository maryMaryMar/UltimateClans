package me.ulrich.clans.library.kyori.adventure.text.format;

import me.ulrich.clans.library.kyori.adventure.util.HSVLike;
import org.jetbrains.annotations.Debug;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/format/TextColorImpl.class */
@Debug.Renderer(text = "asHexString()")
final class TextColorImpl implements TextColor {
    private final int value;

    TextColorImpl(int i) {
        this.value = i;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.format.TextColor
    public int value() {
        return this.value;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof TextColorImpl) && this.value == ((TextColorImpl) obj).value;
    }

    public int hashCode() {
        return this.value;
    }

    public String toString() {
        return asHexString();
    }

    static float distance(@NotNull HSVLike hSVLike, @NotNull HSVLike hSVLike2) {
        float fMin = 3.0f * Math.min(Math.abs(hSVLike.h() - hSVLike2.h()), 1.0f - Math.abs(hSVLike.h() - hSVLike2.h()));
        float fS = hSVLike.s() - hSVLike2.s();
        float fV = hSVLike.v() - hSVLike2.v();
        return (fMin * fMin) + (fS * fS) + (fV * fV);
    }
}
