package me.ulrich.clans.library.kyori.adventure.text.object;

import java.util.Collections;
import java.util.Objects;
import java.util.UUID;
import me.ulrich.clans.library.kyori.adventure.key.Key;
import me.ulrich.clans.library.kyori.examination.Examinable;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/object/ObjectContents.class */
@ApiStatus.NonExtendable
public interface ObjectContents extends Examinable {
    @Contract(value = "_, _ -> new", pure = true)
    @NotNull
    static SpriteObjectContents sprite(@NotNull Key key, @NotNull Key key2) {
        return new SpriteObjectContentsImpl((Key) Objects.requireNonNull(key, "atlas"), (Key) Objects.requireNonNull(key2, "sprite"));
    }

    @Contract(value = "_ -> new", pure = true)
    @NotNull
    static SpriteObjectContents sprite(@NotNull Key key) {
        return new SpriteObjectContentsImpl(SpriteObjectContents.DEFAULT_ATLAS, (Key) Objects.requireNonNull(key, "sprite"));
    }

    @Contract(value = "-> new", pure = true)
    static PlayerHeadObjectContents.Builder playerHead() {
        return new PlayerHeadObjectContentsImpl.BuilderImpl();
    }

    @Contract(value = "_ -> new", pure = true)
    @NotNull
    static PlayerHeadObjectContents playerHead(@NotNull String str) {
        return new PlayerHeadObjectContentsImpl(str, null, Collections.emptyList(), true, null);
    }

    @Contract(value = "_ -> new", pure = true)
    @NotNull
    static PlayerHeadObjectContents playerHead(@NotNull UUID uuid) {
        return new PlayerHeadObjectContentsImpl(null, uuid, Collections.emptyList(), true, null);
    }

    @Contract(value = "_ -> new", pure = true)
    @NotNull
    static PlayerHeadObjectContents playerHead(PlayerHeadObjectContents.SkinSource skinSource) {
        return playerHead().skin(skinSource).build();
    }
}
