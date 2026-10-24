package me.ulrich.clans.data.addons;

import java.util.UUID;
import org.bukkit.entity.Player;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/data/addons/WarInvite.class */
public class WarInvite {
    private UUID clanSender;
    private UUID clanReceiver;
    private Long expires;
    private String arena;
    private int max;
    private Player player;
    private String kit;

    public WarInvite(UUID uuid, UUID uuid2, Long l, String str, int i, Player player, String str2) {
        setClanSender(uuid);
        setClanReceiver(uuid2);
        setExpires(l);
        setArena(str);
        setMax(i);
        setPlayer(player);
        setKit(str2);
    }

    public UUID getClanSender() {
        return this.clanSender;
    }

    public void setClanSender(UUID uuid) {
        this.clanSender = uuid;
    }

    public UUID getClanReceiver() {
        return this.clanReceiver;
    }

    public void setClanReceiver(UUID uuid) {
        this.clanReceiver = uuid;
    }

    public Long getExpires() {
        return this.expires;
    }

    public void setExpires(Long l) {
        this.expires = l;
    }

    public String getArena() {
        return this.arena;
    }

    public void setArena(String str) {
        this.arena = str;
    }

    public int getMax() {
        return this.max;
    }

    public void setMax(int i) {
        this.max = i;
    }

    public Player getPlayer() {
        return this.player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public String getKit() {
        return this.kit;
    }

    public void setKit(String str) {
        this.kit = str;
    }
}
