package me.ulrich.clans.data;

import java.util.List;
import me.ulrich.clans.library.kyori.adventure.bossbar.BossBar;
import org.bukkit.entity.Player;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/data/BossBarData.class */
public class BossBarData {
    private List<Player> sender;
    private BossBar bossbar;

    public BossBarData(List<Player> list, BossBar bossBar) {
        setSender(list);
        setBossbar(bossBar);
    }

    public List<Player> getSender() {
        return this.sender;
    }

    public void setSender(List<Player> list) {
        this.sender = list;
    }

    public BossBar getBossbar() {
        return this.bossbar;
    }

    public void setBossbar(BossBar bossBar) {
        this.bossbar = bossBar;
    }
}
