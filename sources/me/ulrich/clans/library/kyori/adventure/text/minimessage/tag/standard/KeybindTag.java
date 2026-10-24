package me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.standard;

import java.util.function.BiFunction;
import java.util.function.Function;
import me.ulrich.clans.library.kyori.adventure.text.Component;
import me.ulrich.clans.library.kyori.adventure.text.KeybindComponent;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.Context;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.serializer.Emitable;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.serializer.SerializableResolver;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.Tag;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.resolver.ArgumentQueue;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.resolver.TagResolver;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/minimessage/tag/standard/KeybindTag.class */
final class KeybindTag {
    public static final String KEYBIND = "key";
    static final TagResolver RESOLVER = SerializableResolver.claimingComponent(KEYBIND, (BiFunction<ArgumentQueue, Context, Tag>) KeybindTag::create, (Function<Component, Emitable>) KeybindTag::emit);

    private KeybindTag() {
    }

    static Tag create(ArgumentQueue argumentQueue, Context context) {
        return Tag.inserting((Component) Component.keybind(argumentQueue.popOr("A keybind id is required").value()));
    }

    @Nullable
    static Emitable emit(Component component) {
        if (!(component instanceof KeybindComponent)) {
            return null;
        }
        String strKeybind = ((KeybindComponent) component).keybind();
        return tokenEmitter -> {
            tokenEmitter.tag(KEYBIND).argument(strKeybind);
        };
    }
}
