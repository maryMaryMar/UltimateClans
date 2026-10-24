package me.ulrich.clans.library.kyori.adventure.text.object;

import java.util.Objects;
import me.ulrich.clans.library.kyori.adventure.internal.Internals;
import me.ulrich.clans.library.kyori.adventure.key.Key;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/object/SpriteObjectContentsImpl.class */
final class SpriteObjectContentsImpl implements SpriteObjectContents {
    private final Key atlas;
    private final Key sprite;

    SpriteObjectContentsImpl(@NotNull Key key, @NotNull Key key2) {
        this.atlas = key;
        this.sprite = key2;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.object.SpriteObjectContents
    @NotNull
    public Key atlas() {
        return this.atlas;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.object.SpriteObjectContents
    @NotNull
    public Key sprite() {
        return this.sprite;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SpriteObjectContents)) {
            return false;
        }
        SpriteObjectContentsImpl spriteObjectContentsImpl = (SpriteObjectContentsImpl) obj;
        return Objects.equals(this.atlas, spriteObjectContentsImpl.atlas()) && Objects.equals(this.sprite, spriteObjectContentsImpl.sprite());
    }

    public int hashCode() {
        return (31 * this.atlas.hashCode()) + this.sprite.hashCode();
    }

    public String toString() {
        return Internals.toString(this);
    }
}
