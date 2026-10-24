package me.ulrich.clans.tjCyMSV004ze7Mc.qjkRaOgynIj1;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import me.ulrich.clans.Clans;
import me.ulrich.clans.interfaces.ClaimImplement;
import me.ulrich.clans.interfaces.RegionImplement;
import me.ulrich.clans.manager.DTKXb4fQF6nDgxzg.tjCyMSV004ze7Mc.DTKXb4fQF6nDgxzg.ECMfR2SxjZy2nLBVbPf;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/tjCyMSV004ze7Mc/qjkRaOgynIj1/ZRp1tak21UvNaOVCtFx.class */
public class ZRp1tak21UvNaOVCtFx implements Listener {
    private Clans v8qP8fE86HMhvNuYPFjqY;
    private static String bIRCgeZI61Uqv3TUFlwx;
    private static String d9cPaDYbG6gnXRm;
    private static String gADkbXp9sQtlJR5xd;
    private static volatile String l6k67a4DAJtTIqGg;
    private static String LTvxz8cU7IOmoiYTP0E;
    private static final byte[] guLDOLbW51AS4XdyDXQ7 = {(byte) 220, (byte) 56, (byte) 101, (byte) 255, (byte) 135, (byte) 217, (byte) 213, (byte) 77, (byte) 125, (byte) 6, (byte) 66, (byte) 182, (byte) 240, (byte) 234, (byte) 138, (byte) 60, (byte) 24, (byte) 213, (byte) 20, (byte) 56, (byte) 137, (byte) 73, (byte) 255, (byte) 232, (byte) 223, (byte) 198, (byte) 158, (byte) 85, (byte) 247, (byte) 199, (byte) 49, (byte) 71, (byte) 31, (byte) 73, (byte) 180, (byte) 150, (byte) 75, (byte) 172, (byte) 191, (byte) 168, (byte) 232, (byte) 100, (byte) 241, (byte) 177, (byte) 200, (byte) 219, (byte) 13, (byte) 162};
    private static final byte[] ErX3i7rR5Zu1xSf = {(byte) 220, (byte) 56, (byte) 101, (byte) 255, (byte) 135, (byte) 217, (byte) 213, (byte) 77, (byte) 125, (byte) 6, (byte) 66, (byte) 182, (byte) 240, (byte) 234, (byte) 138, (byte) 60, (byte) 24, (byte) 213, (byte) 20, (byte) 56, (byte) 137, (byte) 73, (byte) 255, (byte) 232, (byte) 223, (byte) 198, (byte) 158, (byte) 85, (byte) 247, (byte) 199, (byte) 49, (byte) 71, (byte) 140, (byte) 93, (byte) 25, (byte) 169, (byte) 113, (byte) 163, (byte) 102, (byte) 2, (byte) 219, (byte) 38, (byte) 6, (byte) 214, (byte) 246, (byte) 236, (byte) 91, (byte) 174};
    private static final byte[] zT5FzvT6hmE15a27Fy = {(byte) 210, (byte) 17, (byte) 30, (byte) 45, (byte) 124, (byte) 111, (byte) 87, (byte) 180, (byte) 38, (byte) 56, (byte) 63, (byte) 191, (byte) 41, (byte) 115, (byte) 7, (byte) 82, (byte) 45, (byte) 109, (byte) 215, (byte) 174, (byte) 221, (byte) 209, (byte) 223, (byte) 120, (byte) 145, (byte) 71, (byte) 61, (byte) 44, (byte) 240, (byte) 240, (byte) 58, (byte) 177};
    private static final byte[] uoUiA1VLIQuRu7NMwaNuae = {(byte) 168, (byte) 158, (byte) 131, (byte) 7, (byte) 59, (byte) 0, (byte) 18, (byte) 190, (byte) 38, (byte) 108, (byte) 38, (byte) 156, (byte) 73, (byte) 120, (byte) 105, (byte) 173};

    public ZRp1tak21UvNaOVCtFx(Clans clans) {
        this.v8qP8fE86HMhvNuYPFjqY = clans;
        this.v8qP8fE86HMhvNuYPFjqY.getRegistredListeners().add(this);
    }

    @EventHandler
    public void v8qP8fE86HMhvNuYPFjqY(PlayerDeathEvent playerDeathEvent) {
        if (this.v8qP8fE86HMhvNuYPFjqY.getFiles().p31abtwfBag2jhMH6K().getBoolean(TwfaYwrccweZnlkwKqbdU())) {
            Player killer = playerDeathEvent.getEntity().getKiller();
            Player entity = playerDeathEvent.getEntity();
            if (this.v8qP8fE86HMhvNuYPFjqY.getFiles().p31abtwfBag2jhMH6K().getStringList(xXxwpfIoml1Qomq4ctKO()).stream().filter(str -> {
                return (str.endsWith(SpEvT66vP7FwzjHly679()) && entity.getWorld().getName().startsWith(str) && !entity.getWorld().getName().equals(str)) || entity.getWorld().getName().equals(str);
            }).findAny().isPresent()) {
                return;
            }
            try {
                List stringList = this.v8qP8fE86HMhvNuYPFjqY.getFiles().p31abtwfBag2jhMH6K().getStringList(assiurNCOvCLhtBa8Ptw6r());
                if (stringList.size() > 0) {
                    Iterator it = stringList.iterator();
                    while (it.hasNext()) {
                        Optional<ClaimImplement> optionalHX3ZfRb1nSpNq57s7x5ui = this.v8qP8fE86HMhvNuYPFjqY.getIntegrationManager().HX3ZfRb1nSpNq57s7x5ui((String) it.next());
                        if (optionalHX3ZfRb1nSpNq57s7x5ui.isPresent() && optionalHX3ZfRb1nSpNq57s7x5ui.get().hasClaimLocation(entity.getLocation())) {
                            return;
                        }
                    }
                }
            } catch (Exception e) {
            }
            Optional<RegionImplement> optionalHX3ZfRb1nSpNq57s7x5ui2 = this.v8qP8fE86HMhvNuYPFjqY.getIntegrationManager().HX3ZfRb1nSpNq57s7x5ui();
            if (!(optionalHX3ZfRb1nSpNq57s7x5ui2.isPresent() && optionalHX3ZfRb1nSpNq57s7x5ui2.get().playerHasRegionList(entity, this.v8qP8fE86HMhvNuYPFjqY.getFiles().p31abtwfBag2jhMH6K().getStringList(gGclil2G20794Kav74RM()))) && (playerDeathEvent.getEntity() instanceof Player) && (playerDeathEvent.getEntity().getKiller() instanceof Player)) {
                this.v8qP8fE86HMhvNuYPFjqY.getPlayerManager().iZTqZaRK5UGoe0Z(killer, entity);
            }
        }
    }

    private static String TwfaYwrccweZnlkwKqbdU() {
        return "Config.player.souls.enabled";
    }

    private static String xXxwpfIoml1Qomq4ctKO() {
        return "Config.player.souls.disabled_souls_worlds";
    }

    private static String assiurNCOvCLhtBa8Ptw6r() {
        return "Config.player.souls.disabled_souls_terrain";
    }

    private static String gGclil2G20794Kav74RM() {
        return "Config.player.souls.disabled_souls_regions";
    }

    private static String SpEvT66vP7FwzjHly679() {
        return "%";
    }
}
