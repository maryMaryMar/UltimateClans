package me.ulrich.clans.tjCyMSV004ze7Mc;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import me.ulrich.clans.Clans;
import me.ulrich.clans.data.ClanData;
import me.ulrich.clans.data.PlayerData;
import me.ulrich.clans.manager.DTKXb4fQF6nDgxzg.tjCyMSV004ze7Mc.DTKXb4fQF6nDgxzg.ECMfR2SxjZy2nLBVbPf;
import me.ulrich.clans.manager.EnumFiles.Lang;
import me.ulrich.clans.manager.utils.Actionbar;
import me.ulrich.clans.manager.utils.MessageUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/tjCyMSV004ze7Mc/RuVgd0Dnv0ddhdcWL.class */
public class RuVgd0Dnv0ddhdcWL implements Listener {
    private Clans v8qP8fE86HMhvNuYPFjqY;
    private static String QsJ12l5O9ohnshKBV;
    private static volatile String gLfTx0Z0Jpqy5Fc;
    private static final byte[] KpiOkwwid7EIMAp = {(byte) 110, (byte) 9, (byte) 55, (byte) 15, (byte) 169, (byte) 155, (byte) 8, (byte) 75, (byte) 140, (byte) 128, (byte) 62, (byte) 222, (byte) 156, (byte) 13, (byte) 107, (byte) 146, (byte) 245, (byte) 84, (byte) 28, (byte) 117, (byte) 123, (byte) 219, (byte) 76, (byte) 166, (byte) 34, (byte) 120, (byte) 164, (byte) 158, (byte) 25, (byte) 67, (byte) 164, (byte) 52};
    private static final byte[] bpFIe2f5PPPioGxcCmtEW4 = {(byte) 110, (byte) 9, (byte) 55, (byte) 15, (byte) 169, (byte) 155, (byte) 8, (byte) 75, (byte) 140, (byte) 128, (byte) 62, (byte) 222, (byte) 156, (byte) 13, (byte) 107, (byte) 146, (byte) 245, (byte) 84, (byte) 28, (byte) 117, (byte) 123, (byte) 219, (byte) 76, (byte) 166, (byte) 34, (byte) 120, (byte) 164, (byte) 158, (byte) 25, (byte) 67, (byte) 164, (byte) 52};
    private static final byte[] eClHRL3LZqy5WQhsgbNl = {(byte) 244, (byte) 113, (byte) 136, (byte) 90, (byte) 231, (byte) 69, (byte) 245, (byte) 168, (byte) 8, (byte) 46, (byte) 155, (byte) 121, (byte) 205, (byte) 251, (byte) 180, (byte) 33, (byte) 243, (byte) 37, (byte) 35, (byte) 246, (byte) 40, (byte) 168, (byte) 126, (byte) 85, (byte) 164, (byte) 179, (byte) 140, (byte) 242, (byte) 0, (byte) 216, (byte) 209, (byte) 41};
    private static final byte[] d3yefnzjSBNcFATtMc8O = {(byte) 114, (byte) 255, (byte) 58, (byte) 40, (byte) 226, (byte) 15, (byte) 146, (byte) 207, (byte) 23, (byte) 110, (byte) 47, (byte) 99, (byte) 10, (byte) 95, (byte) 198, (byte) 206};

    public RuVgd0Dnv0ddhdcWL(Clans clans) {
        this.v8qP8fE86HMhvNuYPFjqY = clans;
        this.v8qP8fE86HMhvNuYPFjqY.getRegistredListeners().add(this);
    }

    @EventHandler
    public void v8qP8fE86HMhvNuYPFjqY(PlayerQuitEvent playerQuitEvent) {
        Player player = playerQuitEvent.getPlayer();
        Actionbar.resetActionbar(player);
        this.v8qP8fE86HMhvNuYPFjqY.getBossBarManager().v8qP8fE86HMhvNuYPFjqY(player);
        this.v8qP8fE86HMhvNuYPFjqY.getGuiManager().xtOheRiObl4QeAl().remove(player);
        Optional<PlayerData> optionalP31abtwfBag2jhMH6K = this.v8qP8fE86HMhvNuYPFjqY.getPlayerManager().p31abtwfBag2jhMH6K(player.getUniqueId());
        if (optionalP31abtwfBag2jhMH6K.isPresent()) {
            this.v8qP8fE86HMhvNuYPFjqY.getPlayerManager().jBUuLP0sWwaPyPOmogdX7l(optionalP31abtwfBag2jhMH6K.get().getId());
        }
        Optional<ClanData> optionalCDW4Fj1iwdIXEOqWjiJSR = this.v8qP8fE86HMhvNuYPFjqY.getPlayerManager().CDW4Fj1iwdIXEOqWjiJSR(player.getUniqueId());
        if (optionalCDW4Fj1iwdIXEOqWjiJSR.isPresent()) {
            if (optionalCDW4Fj1iwdIXEOqWjiJSR.get().getOnlineMembers().size() > 0) {
                List<UUID> onlineMembers = optionalCDW4Fj1iwdIXEOqWjiJSR.get().getOnlineMembers();
                if (onlineMembers.contains(player.getUniqueId())) {
                    onlineMembers.remove(player.getUniqueId());
                    optionalCDW4Fj1iwdIXEOqWjiJSR.get().setOnlineMembers(onlineMembers);
                }
            }
            if (this.v8qP8fE86HMhvNuYPFjqY.getFiles().p31abtwfBag2jhMH6K().getBoolean(A1fywS2PuCzkZ7IaZhU0w()) && !this.v8qP8fE86HMhvNuYPFjqY.getHooksManager().isInvisible(player) && optionalCDW4Fj1iwdIXEOqWjiJSR.get().getSettings().isJoinLeave()) {
                MessageUtils.clanMessageSend(optionalCDW4Fj1iwdIXEOqWjiJSR.get(), this.v8qP8fE86HMhvNuYPFjqY.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(optionalCDW4Fj1iwdIXEOqWjiJSR.get().getLeader())).getString(Lang.PLAYER_LEAVE, Arrays.asList("%player%;" + player.getName())));
            }
            this.v8qP8fE86HMhvNuYPFjqY.getChatManager().jBUuLP0sWwaPyPOmogdX7l(player);
        }
    }

    @EventHandler
    public void v8qP8fE86HMhvNuYPFjqY(PlayerJoinEvent playerJoinEvent) {
        if (playerJoinEvent.getPlayer() instanceof Player) {
            long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
            Player player = playerJoinEvent.getPlayer();
            this.v8qP8fE86HMhvNuYPFjqY.getPlayerManager().zJnaNCVQSgEShq(player);
            Optional<PlayerData> optionalP31abtwfBag2jhMH6K = this.v8qP8fE86HMhvNuYPFjqY.getPlayerManager().p31abtwfBag2jhMH6K(player.getUniqueId());
            if (optionalP31abtwfBag2jhMH6K.isPresent()) {
                this.v8qP8fE86HMhvNuYPFjqY.getPlayerManager().v8qP8fE86HMhvNuYPFjqY(optionalP31abtwfBag2jhMH6K.get().getId(), playerJoinEvent.getPlayer().getName(), this.v8qP8fE86HMhvNuYPFjqY.getServerName());
                if (jCurrentTimeMillis > optionalP31abtwfBag2jhMH6K.get().getLastSeen() + 86400) {
                    optionalP31abtwfBag2jhMH6K.get().setLastSeen(jCurrentTimeMillis);
                    if (!optionalP31abtwfBag2jhMH6K.get().getName().equals(player.getName())) {
                        optionalP31abtwfBag2jhMH6K.get().setName(player.getName());
                    }
                    this.v8qP8fE86HMhvNuYPFjqY.getPlayerManager().v8qP8fE86HMhvNuYPFjqY(optionalP31abtwfBag2jhMH6K.get());
                }
            }
            if (this.v8qP8fE86HMhvNuYPFjqY.getHooksManager().isInvisible(player)) {
                return;
            }
            Optional<ClanData> optionalCDW4Fj1iwdIXEOqWjiJSR = this.v8qP8fE86HMhvNuYPFjqY.getPlayerManager().CDW4Fj1iwdIXEOqWjiJSR(player.getUniqueId());
            if (optionalCDW4Fj1iwdIXEOqWjiJSR.isPresent()) {
                List<UUID> onlineMembers = optionalCDW4Fj1iwdIXEOqWjiJSR.get().getOnlineMembers();
                if (onlineMembers.size() == 0) {
                    this.v8qP8fE86HMhvNuYPFjqY.getModerationManager().iZTqZaRK5UGoe0Z(optionalCDW4Fj1iwdIXEOqWjiJSR.get().getId());
                }
                if (!onlineMembers.contains(player.getUniqueId())) {
                    onlineMembers.add(player.getUniqueId());
                    optionalCDW4Fj1iwdIXEOqWjiJSR.get().setOnlineMembers(onlineMembers);
                }
                if (this.v8qP8fE86HMhvNuYPFjqY.getFiles().p31abtwfBag2jhMH6K().getBoolean(aOodSou8SwxiwxoL57r0()) && optionalCDW4Fj1iwdIXEOqWjiJSR.get().getSettings().isJoinLeave()) {
                    MessageUtils.clanMessageSend(optionalCDW4Fj1iwdIXEOqWjiJSR.get(), this.v8qP8fE86HMhvNuYPFjqY.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(optionalCDW4Fj1iwdIXEOqWjiJSR.get().getLeader())).getString(Lang.PLAYER_JOIN, Arrays.asList("%player%;" + player.getName())));
                }
            }
        }
    }

    private static String A1fywS2PuCzkZ7IaZhU0w() {
        return "Config.player.join_quit";
    }

    private static String aOodSou8SwxiwxoL57r0() {
        return "Config.player.join_quit";
    }
}
