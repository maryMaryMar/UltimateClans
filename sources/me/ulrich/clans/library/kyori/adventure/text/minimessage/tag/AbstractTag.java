package me.ulrich.clans.library.kyori.adventure.text.minimessage.tag;

import me.ulrich.clans.library.kyori.adventure.internal.Internals;
import me.ulrich.clans.library.kyori.examination.Examinable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/minimessage/tag/AbstractTag.class */
abstract class AbstractTag implements Tag, Examinable {
    AbstractTag() {
    }

    public final String toString() {
        return Internals.toString(this);
    }
}
