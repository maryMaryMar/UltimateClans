package me.ulrich.clans.library.kyori.adventure.text.object;

import java.util.stream.Stream;
import me.ulrich.clans.library.kyori.adventure.key.Key;
import me.ulrich.clans.library.kyori.examination.ExaminableProperty;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/object/SpriteObjectContents.class */
@ApiStatus.NonExtendable
public interface SpriteObjectContents extends ObjectContents {
    public static final Key DEFAULT_ATLAS = Key.key("minecraft:blocks");

    @NotNull
    Key atlas();

    @NotNull
    Key sprite();

    @Override // me.ulrich.clans.library.kyori.examination.Examinable
    @NotNull
    default Stream<? extends ExaminableProperty> examinableProperties() {
        return Stream.of((Object[]) new ExaminableProperty[]{ExaminableProperty.of("atlas", atlas()), ExaminableProperty.of("sprite", sprite())});
    }
}
