package me.ulrich.clans.library.kyori.adventure.text;

import me.ulrich.clans.library.kyori.adventure.util.Nag;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/LegacyFormattingDetected.class */
final class LegacyFormattingDetected extends Nag {
    private static final long serialVersionUID = -947793022628807411L;

    LegacyFormattingDetected(Component component) {
        super("Legacy formatting codes have been detected in a component - this is unsupported behaviour. Please refer to the Adventure documentation (https://docs.papermc.io/adventure/) for more information. Component: " + component);
    }
}
