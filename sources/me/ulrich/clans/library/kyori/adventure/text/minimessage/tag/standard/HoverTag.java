package me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.standard;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.function.BiFunction;
import me.ulrich.clans.library.kyori.adventure.key.InvalidKeyException;
import me.ulrich.clans.library.kyori.adventure.key.Key;
import me.ulrich.clans.library.kyori.adventure.nbt.api.BinaryTagHolder;
import me.ulrich.clans.library.kyori.adventure.text.Component;
import me.ulrich.clans.library.kyori.adventure.text.event.DataComponentValue;
import me.ulrich.clans.library.kyori.adventure.text.event.HoverEvent;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.Context;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.serializer.SerializableResolver;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.serializer.StyleClaim;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.serializer.TokenEmitter;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.Tag;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.resolver.ArgumentQueue;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.resolver.TagResolver;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/minimessage/tag/standard/HoverTag.class */
final class HoverTag {
    private static final String HOVER = "hover";
    static final TagResolver RESOLVER = SerializableResolver.claimingStyle(HOVER, (BiFunction<ArgumentQueue, Context, Tag>) HoverTag::create, (StyleClaim<?>) StyleClaim.claim(HOVER, (v0) -> {
        return v0.hoverEvent();
    }, HoverTag::emit));

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/minimessage/tag/standard/HoverTag$ActionHandler.class */
    interface ActionHandler<V> {
        @NotNull
        V parse(@NotNull ArgumentQueue argumentQueue, @NotNull Context context);

        void emit(V v, TokenEmitter tokenEmitter);
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/minimessage/tag/standard/HoverTag$ShowEntity.class */
    static final class ShowEntity implements ActionHandler<HoverEvent.ShowEntity> {
        static final ShowEntity INSTANCE = new ShowEntity();

        private ShowEntity() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.standard.HoverTag.ActionHandler
        public HoverEvent.ShowEntity parse(@NotNull ArgumentQueue argumentQueue, @NotNull Context context) {
            try {
                Key key = Key.key(argumentQueue.popOr("Show entity needs a type argument").value());
                UUID uuidFromString = UUID.fromString(argumentQueue.popOr("Show entity needs an entity UUID").value());
                return argumentQueue.hasNext() ? HoverEvent.ShowEntity.showEntity(key, uuidFromString, context.deserialize(argumentQueue.pop().value())) : HoverEvent.ShowEntity.showEntity(key, uuidFromString);
            } catch (IllegalArgumentException | InvalidKeyException e) {
                throw context.newException("Exception parsing show_entity hover", e, argumentQueue);
            }
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.standard.HoverTag.ActionHandler
        public void emit(HoverEvent.ShowEntity showEntity, TokenEmitter tokenEmitter) {
            tokenEmitter.argument(HoverTag.compactAsString(showEntity.type())).argument(showEntity.id().toString());
            if (showEntity.name() != null) {
                tokenEmitter.argument(showEntity.name());
            }
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/minimessage/tag/standard/HoverTag$ShowItem.class */
    static final class ShowItem implements ActionHandler<HoverEvent.ShowItem> {
        private static final ShowItem INSTANCE = new ShowItem();

        private ShowItem() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.standard.HoverTag.ActionHandler
        public HoverEvent.ShowItem parse(@NotNull ArgumentQueue argumentQueue, @NotNull Context context) {
            try {
                Key key = Key.key(argumentQueue.popOr("Show item hover needs at least an item ID").value());
                int iOrElseThrow = argumentQueue.hasNext() ? argumentQueue.pop().asInt().orElseThrow(() -> {
                    return context.newException("The count argument was not a valid integer");
                }) : 1;
                if (!argumentQueue.hasNext()) {
                    return HoverEvent.ShowItem.showItem(key, iOrElseThrow);
                }
                String strValue = argumentQueue.peek().value();
                if (strValue.startsWith("{")) {
                    argumentQueue.pop();
                    return legacyShowItem(key, iOrElseThrow, strValue);
                }
                HashMap map = new HashMap();
                while (argumentQueue.hasNext()) {
                    Key key2 = Key.key(argumentQueue.pop().value());
                    map.put(key2, BinaryTagHolder.binaryTagHolder(argumentQueue.popOr("a value was expected for key " + key2).value()));
                }
                return HoverEvent.ShowItem.showItem(key, iOrElseThrow, map);
            } catch (NumberFormatException | InvalidKeyException e) {
                throw context.newException("Exception parsing show_item hover", e, argumentQueue);
            }
        }

        private static HoverEvent.ShowItem legacyShowItem(Key key, int i, String str) {
            return HoverEvent.ShowItem.showItem(key, i, BinaryTagHolder.binaryTagHolder(str));
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.standard.HoverTag.ActionHandler
        public void emit(HoverEvent.ShowItem showItem, TokenEmitter tokenEmitter) {
            tokenEmitter.argument(HoverTag.compactAsString(showItem.item()));
            if (showItem.count() == 1 && !hasLegacy(showItem) && showItem.dataComponents().isEmpty()) {
                return;
            }
            tokenEmitter.argument(Integer.toString(showItem.count()));
            if (hasLegacy(showItem)) {
                emitLegacyHover(showItem, tokenEmitter);
                return;
            }
            for (Map.Entry entry : showItem.dataComponentsAs(DataComponentValue.TagSerializable.class).entrySet()) {
                tokenEmitter.argument(((Key) entry.getKey()).asMinimalString());
                tokenEmitter.argument(((DataComponentValue.TagSerializable) entry.getValue()).asBinaryTag().string());
            }
        }

        static boolean hasLegacy(HoverEvent.ShowItem showItem) {
            return showItem.nbt() != null;
        }

        static void emitLegacyHover(HoverEvent.ShowItem showItem, TokenEmitter tokenEmitter) {
            if (showItem.nbt() != null) {
                tokenEmitter.argument(showItem.nbt().string());
            }
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/minimessage/tag/standard/HoverTag$ShowText.class */
    static final class ShowText implements ActionHandler<Component> {
        private static final ShowText INSTANCE = new ShowText();

        private ShowText() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.standard.HoverTag.ActionHandler
        @NotNull
        public Component parse(@NotNull ArgumentQueue argumentQueue, @NotNull Context context) {
            return context.deserialize(argumentQueue.popOr("show_text action requires a message").value());
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.standard.HoverTag.ActionHandler
        public void emit(Component component, TokenEmitter tokenEmitter) {
            tokenEmitter.argument(component);
        }
    }

    private HoverTag() {
    }

    static Tag create(ArgumentQueue argumentQueue, Context context) {
        HoverEvent.Action<?> actionValue = HoverEvent.Action.NAMES.value(argumentQueue.popOr("Hover event requires an action as its first argument").value());
        ActionHandler actionHandler = actionHandler(actionValue);
        if (actionHandler == null) {
            throw context.newException("Don't know how to turn '" + argumentQueue + "' into a hover event", argumentQueue);
        }
        return Tag.styling(HoverEvent.hoverEvent(actionValue, actionHandler.parse(argumentQueue, context)));
    }

    static void emit(HoverEvent<?> hoverEvent, TokenEmitter tokenEmitter) {
        ActionHandler actionHandler = actionHandler(hoverEvent.action());
        tokenEmitter.tag(HOVER).argument(HoverEvent.Action.NAMES.key(hoverEvent.action()));
        actionHandler.emit(hoverEvent.value(), tokenEmitter);
    }

    @Nullable
    static <V> ActionHandler<V> actionHandler(HoverEvent.Action<V> action) {
        ActionHandler<V> actionHandler = null;
        if (action == HoverEvent.Action.SHOW_TEXT) {
            actionHandler = ShowText.INSTANCE;
        } else if (action == HoverEvent.Action.SHOW_ITEM) {
            actionHandler = ShowItem.INSTANCE;
        } else if (action == HoverEvent.Action.SHOW_ENTITY) {
            actionHandler = ShowEntity.INSTANCE;
        }
        return actionHandler;
    }

    @NotNull
    static String compactAsString(@NotNull Key key) {
        return key.namespace().equals(Key.MINECRAFT_NAMESPACE) ? key.value() : key.asString();
    }
}
