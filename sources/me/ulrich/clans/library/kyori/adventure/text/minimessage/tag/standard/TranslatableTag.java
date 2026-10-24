package me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.standard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import me.ulrich.clans.library.kyori.adventure.text.Component;
import me.ulrich.clans.library.kyori.adventure.text.ComponentLike;
import me.ulrich.clans.library.kyori.adventure.text.TranslatableComponent;
import me.ulrich.clans.library.kyori.adventure.text.TranslationArgument;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.Context;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.serializer.Emitable;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.serializer.SerializableResolver;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.Tag;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.resolver.ArgumentQueue;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.resolver.TagResolver;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/minimessage/tag/standard/TranslatableTag.class */
final class TranslatableTag {
    private static final String TRANSLATE = "translate";
    private static final String LANG = "lang";
    private static final String TR = "tr";
    static final TagResolver RESOLVER = SerializableResolver.claimingComponent(StandardTags.names(LANG, "translate", TR), (BiFunction<ArgumentQueue, Context, Tag>) TranslatableTag::create, (Function<Component, Emitable>) TranslatableTag::claim);

    private TranslatableTag() {
    }

    static Tag create(ArgumentQueue argumentQueue, Context context) {
        List listEmptyList;
        String strValue = argumentQueue.popOr("A translation key is required").value();
        if (argumentQueue.hasNext()) {
            listEmptyList = new ArrayList();
            while (argumentQueue.hasNext()) {
                listEmptyList.add(context.deserialize(argumentQueue.pop().value()));
            }
        } else {
            listEmptyList = Collections.emptyList();
        }
        return Tag.inserting((Component) Component.translatable(strValue, (List<? extends ComponentLike>) listEmptyList));
    }

    @Nullable
    static Emitable claim(Component component) {
        if (!(component instanceof TranslatableComponent) || ((TranslatableComponent) component).fallback() != null) {
            return null;
        }
        TranslatableComponent translatableComponent = (TranslatableComponent) component;
        return tokenEmitter -> {
            tokenEmitter.tag(LANG);
            tokenEmitter.argument(translatableComponent.key());
            Iterator<TranslationArgument> it = translatableComponent.arguments().iterator();
            while (it.hasNext()) {
                tokenEmitter.argument(it.next().asComponent());
            }
        };
    }
}
