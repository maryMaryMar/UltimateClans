package me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.standard;

import java.util.function.BiFunction;
import java.util.function.Function;
import me.ulrich.clans.library.kyori.adventure.text.Component;
import me.ulrich.clans.library.kyori.adventure.text.SelectorComponent;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.Context;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.serializer.Emitable;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.serializer.SerializableResolver;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.Tag;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.resolver.ArgumentQueue;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.resolver.TagResolver;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/minimessage/tag/standard/SelectorTag.class */
final class SelectorTag {
    private static final String SELECTOR = "selector";
    private static final String SEL = "sel";
    static final TagResolver RESOLVER = SerializableResolver.claimingComponent(StandardTags.names(SEL, "selector"), (BiFunction<ArgumentQueue, Context, Tag>) SelectorTag::create, (Function<Component, Emitable>) SelectorTag::claim);

    private SelectorTag() {
    }

    static Tag create(ArgumentQueue argumentQueue, Context context) {
        String strValue = argumentQueue.popOr("A selection key is required").value();
        Component componentDeserialize = null;
        if (argumentQueue.hasNext()) {
            componentDeserialize = context.deserialize(argumentQueue.pop().value());
        }
        return Tag.inserting((Component) Component.selector(strValue, componentDeserialize));
    }

    @Nullable
    static Emitable claim(Component component) {
        if (!(component instanceof SelectorComponent)) {
            return null;
        }
        SelectorComponent selectorComponent = (SelectorComponent) component;
        return tokenEmitter -> {
            tokenEmitter.tag(SEL);
            tokenEmitter.argument(selectorComponent.pattern());
            if (selectorComponent.separator() != null) {
                tokenEmitter.argument(selectorComponent.separator());
            }
        };
    }
}
