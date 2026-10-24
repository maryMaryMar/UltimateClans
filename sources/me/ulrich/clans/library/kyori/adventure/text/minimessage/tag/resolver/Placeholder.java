package me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.resolver;

import java.util.Objects;
import me.ulrich.clans.library.kyori.adventure.text.Component;
import me.ulrich.clans.library.kyori.adventure.text.ComponentLike;
import me.ulrich.clans.library.kyori.adventure.text.format.StyleBuilderApplicable;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.Tag;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.TagPattern;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/minimessage/tag/resolver/Placeholder.class */
public final class Placeholder {
    private Placeholder() {
    }

    public static TagResolver.Single parsed(@TagPattern @NotNull String str, @NotNull String str2) {
        return TagResolver.resolver(str, Tag.preProcessParsed(str2));
    }

    public static TagResolver.Single unparsed(@TagPattern @NotNull String str, @NotNull String str2) {
        Objects.requireNonNull(str2, "value");
        return component(str, Component.text(str2));
    }

    public static TagResolver.Single component(@TagPattern @NotNull String str, @NotNull ComponentLike componentLike) {
        return TagResolver.resolver(str, Tag.selfClosingInserting(componentLike));
    }

    public static TagResolver.Single styling(@TagPattern @NotNull String str, @NotNull StyleBuilderApplicable... styleBuilderApplicableArr) {
        return TagResolver.resolver(str, Tag.styling(styleBuilderApplicableArr));
    }
}
