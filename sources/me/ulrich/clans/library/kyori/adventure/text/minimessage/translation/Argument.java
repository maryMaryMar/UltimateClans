package me.ulrich.clans.library.kyori.adventure.text.minimessage.translation;

import java.util.Objects;
import me.ulrich.clans.library.kyori.adventure.pointer.Pointered;
import me.ulrich.clans.library.kyori.adventure.text.Component;
import me.ulrich.clans.library.kyori.adventure.text.ComponentLike;
import me.ulrich.clans.library.kyori.adventure.text.TranslationArgument;
import me.ulrich.clans.library.kyori.adventure.text.TranslationArgumentLike;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.Tag;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.TagPattern;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.resolver.TagResolver;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/minimessage/translation/Argument.class */
public final class Argument {
    private Argument() {
    }

    @NotNull
    public static ComponentLike bool(@TagPattern @NotNull String str, boolean z) {
        return argument(str, TranslationArgument.bool(z));
    }

    @NotNull
    public static ComponentLike numeric(@TagPattern @NotNull String str, @NotNull Number number) {
        return argument(str, TranslationArgument.numeric(number));
    }

    @Deprecated
    @NotNull
    public static ComponentLike numeric(@TagPattern @NotNull String str, @NotNull String str2) {
        return string(str, str2);
    }

    @NotNull
    public static ComponentLike string(@TagPattern @NotNull String str, @NotNull String str2) {
        return argument(str, TranslationArgument.component(Component.text(str2)));
    }

    @NotNull
    public static ComponentLike component(@TagPattern @NotNull String str, @NotNull ComponentLike componentLike) {
        return argument(str, TranslationArgument.component(componentLike));
    }

    @NotNull
    public static ComponentLike argument(@TagPattern @NotNull String str, @NotNull TranslationArgumentLike translationArgumentLike) {
        return argument(str, ((TranslationArgumentLike) Objects.requireNonNull(translationArgumentLike, "argument")).asTranslationArgument());
    }

    @NotNull
    public static ComponentLike argument(@TagPattern @NotNull String str, @NotNull TranslationArgument translationArgument) {
        return Component.virtual(Void.class, new MiniMessageTranslatorArgument(str, (TranslationArgument) Objects.requireNonNull(translationArgument, "argument")));
    }

    @NotNull
    public static ComponentLike tag(@TagPattern @NotNull String str, @NotNull Tag tag) {
        return Component.virtual(Void.class, new MiniMessageTranslatorArgument(str, (Tag) Objects.requireNonNull(tag, "tag")));
    }

    @NotNull
    public static ComponentLike tagResolver(@NotNull TagResolver... tagResolverArr) {
        return tagResolver(TagResolver.resolver(tagResolverArr));
    }

    @NotNull
    public static ComponentLike tagResolver(@NotNull Iterable<TagResolver> iterable) {
        return tagResolver(TagResolver.resolver(iterable));
    }

    @NotNull
    public static ComponentLike tagResolver(@NotNull TagResolver tagResolver) {
        return Component.virtual(Void.class, new MiniMessageTranslatorArgument("unused", (TagResolver) Objects.requireNonNull(tagResolver, "tagResolver")));
    }

    @NotNull
    public static ComponentLike target(@NotNull Pointered pointered) {
        return Component.virtual(Void.class, new MiniMessageTranslatorTarget((Pointered) Objects.requireNonNull(pointered, "target")));
    }
}
