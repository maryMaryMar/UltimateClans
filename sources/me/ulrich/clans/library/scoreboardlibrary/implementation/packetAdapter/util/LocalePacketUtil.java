package me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.util;

import java.util.Collection;
import java.util.HashMap;
import java.util.Locale;
import java.util.function.Function;
import me.ulrich.clans.library.scoreboardlibrary.implementation.commons.LocaleProvider;
import me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.impl.nms.NmsPacketSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/scoreboardlibrary/implementation/packetAdapter/util/LocalePacketUtil.class */
public final class LocalePacketUtil {
    private LocalePacketUtil() {
    }

    public static void sendLocalePackets(@NotNull NmsPacketSender nmsPacketSender, @NotNull Collection<Player> collection, @NotNull Function<Locale, Object> function) {
        if (collection.isEmpty()) {
            return;
        }
        if (collection.size() == 1) {
            Player next = collection.iterator().next();
            nmsPacketSender.sendPacket(next, function.apply(LocaleProvider.locale(next)));
            return;
        }
        HashMap map = new HashMap(1);
        for (Player player : collection) {
            Locale locale = LocaleProvider.locale(player);
            nmsPacketSender.sendPacket(player, map.computeIfAbsent(locale, locale2 -> {
                return function.apply(locale);
            }));
        }
    }
}
