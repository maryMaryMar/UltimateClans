package me.ulrich.clans.tjCyMSV004ze7Mc.DTKXb4fQF6nDgxzg;

import java.util.Arrays;
import java.util.Optional;
import me.ulrich.clans.Clans;
import me.ulrich.clans.data.ClanData;
import me.ulrich.clans.data.ClanEnum;
import me.ulrich.clans.events.ClanMessageEvent;
import me.ulrich.clans.events.ClanPlayerInviteReceive;
import me.ulrich.clans.manager.EnumFiles.Lang;
import me.ulrich.clans.manager.t5552Hwi8n9ivJHRmI;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/tjCyMSV004ze7Mc/DTKXb4fQF6nDgxzg/Ijap9SQKkijXSxP5.class */
public class Ijap9SQKkijXSxP5 implements Listener {
    private final Clans v8qP8fE86HMhvNuYPFjqY;

    public Ijap9SQKkijXSxP5(Clans clans) {
        this.v8qP8fE86HMhvNuYPFjqY = clans;
        this.v8qP8fE86HMhvNuYPFjqY.getRegistredListeners().add(this);
    }

    @EventHandler
    public void v8qP8fE86HMhvNuYPFjqY(ClanPlayerInviteReceive clanPlayerInviteReceive) {
        Optional<ClanData> optionalIZTqZaRK5UGoe0Z = this.v8qP8fE86HMhvNuYPFjqY.getClanManager().iZTqZaRK5UGoe0Z(clanPlayerInviteReceive.getInviteData().getClanID());
        if (optionalIZTqZaRK5UGoe0Z.isPresent()) {
            Player player = null;
            try {
                player = Bukkit.getPlayer(clanPlayerInviteReceive.getInviteData().getPlayer());
            } catch (Exception e) {
            }
            if (player == null || !player.isOnline()) {
                return;
            }
            Player player2 = player;
            this.v8qP8fE86HMhvNuYPFjqY.getTaskManager().v8qP8fE86HMhvNuYPFjqY((Entity) player2, () -> {
                if (t5552Hwi8n9ivJHRmI.v8qP8fE86HMhvNuYPFjqY(player2, ClanEnum.ChatDataType.INVITERECEIVE, Arrays.asList("%clan_tag_nocolor%;" + ((ClanData) optionalIZTqZaRK5UGoe0Z.get()).getTagNoColor(), "%uclans_tag_nocolor%;" + ((ClanData) optionalIZTqZaRK5UGoe0Z.get()).getTagNoColor()), false, false, 0)) {
                    return;
                }
                String string = this.v8qP8fE86HMhvNuYPFjqY.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player2.getUniqueId())).getString(Lang.PLAYER_NEW_INVITE);
                if (string.isEmpty()) {
                    return;
                }
                Bukkit.getPluginManager().callEvent(new ClanMessageEvent(this.v8qP8fE86HMhvNuYPFjqY.getClanManager().jBUuLP0sWwaPyPOmogdX7l(((ClanData) optionalIZTqZaRK5UGoe0Z.get()).getLeader(), this.v8qP8fE86HMhvNuYPFjqY.getCommandManager().jBUuLP0sWwaPyPOmogdX7l(string)), false, false, true, clanPlayerInviteReceive.getInviteData().getPlayer()));
            });
        }
    }

    public Clans v8qP8fE86HMhvNuYPFjqY() {
        return this.v8qP8fE86HMhvNuYPFjqY;
    }
}
