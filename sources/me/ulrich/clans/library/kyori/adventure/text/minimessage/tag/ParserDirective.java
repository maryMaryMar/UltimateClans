package me.ulrich.clans.library.kyori.adventure.text.minimessage.tag;

import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/minimessage/tag/ParserDirective.class */
@ApiStatus.NonExtendable
public interface ParserDirective extends Tag {
    public static final Tag RESET = new ParserDirective() { // from class: me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.ParserDirective.1
        public String toString() {
            return "ParserDirective.RESET";
        }
    };
}
