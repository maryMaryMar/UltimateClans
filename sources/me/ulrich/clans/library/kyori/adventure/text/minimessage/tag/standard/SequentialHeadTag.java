package me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.standard;

import java.util.Objects;
import java.util.UUID;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.regex.Pattern;
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
import me.ulrich.clans.library.kyori.adventure.text.object.PlayerHeadObjectContents;
import me.ulrich.clans.library.kyori.adventure.util.TriState;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/minimessage/tag/standard/SequentialHeadTag.class */
final class SequentialHeadTag {
    private static final Pattern UUIDv4_PATTERN = Pattern.compile("[0-9a-f]{8}-[0-9a-f]{4}-4[0-9a-f]{3}-[89ABCD][0-9a-f]{3}-[0-9a-f]{12}", 2);
    private static final String HEAD = "head";
    static final TagResolver RESOLVER = SerializableResolver.claimingComponent(HEAD, (BiFunction<ArgumentQueue, Context, Tag>) SequentialHeadTag::create, (Function<Component, Emitable>) SequentialHeadTag::claimComponent);

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/minimessage/tag/standard/SequentialHeadTag$PresentType.class */
    private enum PresentType {
        NAME((v0) -> {
            return v0.name();
        }),
        ID(playerHeadObjectContents -> {
            return ((UUID) Objects.requireNonNull(playerHeadObjectContents.id())).toString();
        }),
        TEXTURE(playerHeadObjectContents2 -> {
            return ((Key) Objects.requireNonNull(playerHeadObjectContents2.texture())).asMinimalString();
        });

        private final Function<PlayerHeadObjectContents, String> mappingFunction;

        PresentType(Function function) {
            this.mappingFunction = function;
        }

        public String map(PlayerHeadObjectContents playerHeadObjectContents) {
            return this.mappingFunction.apply(playerHeadObjectContents);
        }
    }

    private SequentialHeadTag() {
    }

    static Tag create(ArgumentQueue argumentQueue, Context context) {
        TriState triStateArgumentToTriState;
        if (!argumentQueue.hasNext()) {
            return Tag.selfClosingInserting((Component) Component.object(ObjectContents.playerHead().build()));
        }
        Tag.Argument argumentPop = argumentQueue.pop();
        String strValue = argumentPop.value();
        if (argumentQueue.hasNext()) {
            triStateArgumentToTriState = argumentToTriState(argumentQueue.pop());
        } else {
            triStateArgumentToTriState = argumentToTriState(argumentPop);
            if (triStateArgumentToTriState != TriState.NOT_SET) {
                return Tag.selfClosingInserting((Component) Component.object(ObjectContents.playerHead().hat(triStateArgumentToTriState.toBooleanOrElse(true)).build()));
            }
        }
        if (argumentQueue.hasNext()) {
            throw context.newException("Too many arguments present", argumentQueue);
        }
        if (UUIDv4_PATTERN.matcher(strValue).matches()) {
            return Tag.selfClosingInserting((Component) Component.object(ObjectContents.playerHead().id(UUID.fromString(strValue)).hat(triStateArgumentToTriState.toBooleanOrElse(true)).build()));
        }
        return (strValue.contains("/") && Key.parseable(strValue)) ? Tag.selfClosingInserting((Component) Component.object(ObjectContents.playerHead().texture(Key.key(strValue)).hat(triStateArgumentToTriState.toBooleanOrElse(true)).build())) : Tag.selfClosingInserting((Component) Component.object(ObjectContents.playerHead().name(strValue).hat(triStateArgumentToTriState.toBooleanOrElse(true)).build()));
    }

    @Nullable
    static Emitable claimComponent(Component component) {
        if (!(component instanceof ObjectComponent)) {
            return null;
        }
        ObjectContents objectContentsContents = ((ObjectComponent) component).contents();
        if (!(objectContentsContents instanceof PlayerHeadObjectContents)) {
            return null;
        }
        PlayerHeadObjectContents playerHeadObjectContents = (PlayerHeadObjectContents) objectContentsContents;
        PresentType presentType = null;
        if (playerHeadObjectContents.name() != null) {
            presentType = PresentType.NAME;
        }
        if (playerHeadObjectContents.id() != null) {
            if (presentType != null) {
                return null;
            }
            presentType = PresentType.ID;
        }
        if (playerHeadObjectContents.texture() != null) {
            if (presentType != null) {
                return null;
            }
            presentType = PresentType.TEXTURE;
        }
        if (presentType == null) {
            return tokenEmitter -> {
                tokenEmitter.tag(HEAD);
                if (!playerHeadObjectContents.hat()) {
                    tokenEmitter.argument(Boolean.toString(playerHeadObjectContents.hat()));
                }
            };
        }
        PresentType presentType2 = presentType;
        return tokenEmitter2 -> {
            tokenEmitter2.tag(HEAD);
            tokenEmitter2.argument(presentType2.map(playerHeadObjectContents));
            if (!playerHeadObjectContents.hat()) {
                tokenEmitter2.argument(Boolean.toString(playerHeadObjectContents.hat()));
            }
        };
    }

    private static TriState argumentToTriState(Tag.Argument argument) {
        if (argument.isTrue()) {
            return TriState.TRUE;
        }
        return argument.isFalse() ? TriState.FALSE : TriState.NOT_SET;
    }
}
