package me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.standard;

import me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.ParserDirective;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.resolver.TagResolver;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/minimessage/tag/standard/ResetTag.class */
final class ResetTag {
    private static final String RESET = "reset";
    static final TagResolver RESOLVER = TagResolver.resolver(RESET, ParserDirective.RESET);

    private ResetTag() {
    }
}
