package me.ulrich.clans.library.kyori.adventure.text.minimessage.translation;

import me.ulrich.clans.library.kyori.adventure.pointer.Pointered;
import me.ulrich.clans.library.kyori.adventure.text.ComponentLike;
import me.ulrich.clans.library.kyori.adventure.text.VirtualComponentRenderer;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/minimessage/translation/MiniMessageTranslatorTarget.class */
final class MiniMessageTranslatorTarget implements VirtualComponentRenderer<Void> {
    private final Pointered pointered;

    MiniMessageTranslatorTarget(@NotNull Pointered pointered) {
        this.pointered = pointered;
    }

    @NotNull
    Pointered pointered() {
        return this.pointered;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.VirtualComponentRenderer
    public ComponentLike apply(@NotNull Void r3) {
        return null;
    }
}
