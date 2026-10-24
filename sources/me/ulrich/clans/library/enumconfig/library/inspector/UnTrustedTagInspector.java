package me.ulrich.clans.library.enumconfig.library.inspector;

import me.ulrich.clans.library.enumconfig.library.nodes.Tag;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/inspector/UnTrustedTagInspector.class */
public final class UnTrustedTagInspector implements TagInspector {
    @Override // me.ulrich.clans.library.enumconfig.library.inspector.TagInspector
    public boolean isGlobalTagAllowed(Tag tag) {
        return false;
    }
}
