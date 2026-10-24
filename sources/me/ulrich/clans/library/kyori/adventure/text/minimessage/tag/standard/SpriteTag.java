package me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.standard;

import java.util.function.BiFunction;
import java.util.function.Function;
import me.ulrich.clans.library.kyori.adventure.key.Key;
import me.ulrich.clans.library.kyori.adventure.text.Component;
import me.ulrich.clans.library.kyori.adventure.text.ObjectComponent;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.Context;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.serializer.Emitable;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.serializer.SerializableResolver;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.Tag;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.resolver.ArgumentQueue;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.resolver.TagResolver;
import me.ulrich.clans.library.kyori.adventure.text.object.ObjectContents;
import me.ulrich.clans.library.kyori.adventure.text.object.SpriteObjectContents;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/minimessage/tag/standard/SpriteTag.class */
final class SpriteTag {
    private static final String SPRITE = "sprite";
    static final TagResolver RESOLVER = SerializableResolver.claimingComponent(SPRITE, (BiFunction<ArgumentQueue, Context, Tag>) SpriteTag::create, (Function<Component, Emitable>) SpriteTag::claimComponent);

    private SpriteTag() {
    }

    static Tag create(ArgumentQueue argumentQueue, Context context) {
        String strValue = argumentQueue.popOr("An atlas id and or a sprite id is required to produce a sprite object component").value();
        String strValue2 = argumentQueue.hasNext() ? argumentQueue.pop().value() : null;
        return strValue2 == null ? Tag.selfClosingInserting((Component) Component.object(ObjectContents.sprite(Key.key(strValue)))) : Tag.selfClosingInserting((Component) Component.object(ObjectContents.sprite(Key.key(strValue), Key.key(strValue2))));
    }

    @Nullable
    static Emitable claimComponent(Component component) {
        if (!(component instanceof ObjectComponent)) {
            return null;
        }
        ObjectContents objectContentsContents = ((ObjectComponent) component).contents();
        if (!(objectContentsContents instanceof SpriteObjectContents)) {
            return null;
        }
        SpriteObjectContents spriteObjectContents = (SpriteObjectContents) objectContentsContents;
        Key keyAtlas = spriteObjectContents.atlas();
        Key keySprite = spriteObjectContents.sprite();
        return keyAtlas == SpriteObjectContents.DEFAULT_ATLAS ? tokenEmitter -> {
            tokenEmitter.tag(SPRITE).argument(keySprite.asString());
        } : tokenEmitter2 -> {
            tokenEmitter2.tag(SPRITE).argument(keyAtlas.asString()).argument(keySprite.asString());
        };
    }
}
