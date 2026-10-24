package me.ulrich.clans.data;

import java.util.List;
import org.bukkit.Location;
import org.bukkit.entity.Player;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/data/RegroupInvite.class */
public class RegroupInvite {
    private ClanData clan;
    private Long expires;
    private Player sender;
    private List<Player> deny;
    private List<Player> accepted;
    private Location location;

    public RegroupInvite(ClanData clanData, Long l, Player player, List<Player> list, List<Player> list2, Location location) {
        setClan(clanData);
        setExpires(l);
        setSender(player);
        setDeny(list);
        setAccepted(list2);
        setLocation(location);
    }

    public ClanData getClan() {
        return this.clan;
    }

    public void setClan(ClanData clanData) {
        this.clan = clanData;
    }

    public Long getExpires() {
        return this.expires;
    }

    public void setExpires(Long l) {
        this.expires = l;
    }

    public Player getSender() {
        return this.sender;
    }

    public void setSender(Player player) {
        this.sender = player;
    }

    public List<Player> getDeny() {
        return this.deny;
    }

    public void setDeny(List<Player> list) {
        this.deny = list;
    }

    public List<Player> getAccepted() {
        return this.accepted;
    }

    public void setAccepted(List<Player> list) {
        this.accepted = list;
    }

    public Location getLocation() {
        return this.location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
