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

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/tjCyMSV004ze7Mc/qjkRaOgynIj1/UsEbiuprSHpNw3qjITfH.class */
public class UsEbiuprSHpNw3qjITfH implements Listener {
    private Clans v8qP8fE86HMhvNuYPFjqY;
    private static String xV63mjisHHePJGYJk;
    private static volatile String Lurg7kpSrQsmXt;
    private static String lyglY0mRNTzbrJ3nuC;
    private static String mr6U1uQTCyRJKSSR8HW4N;
    private static volatile String ZZvcGCrhjsCDS6q;
    private static final byte[] qq9265bF3e6D5YH9 = {(byte) 248, (byte) 156, (byte) 127, (byte) 162, (byte) 164, (byte) 45, (byte) 21, (byte) 165, (byte) 241, (byte) 237, (byte) 41, (byte) 132, (byte) 175, (byte) 151, (byte) 150, (byte) 80};
    private static final byte[] GzJknqf7oxd1VsBMkIDb = {(byte) 220, (byte) 154, (byte) 78, (byte) 223, (byte) 191, (byte) 121, (byte) 171, (byte) 164, (byte) 4, (byte) 230, (byte) 180, (byte) 187, (byte) 89, (byte) 41, (byte) 175, (byte) 15, (byte) 155, (byte) 93, (byte) 153, (byte) 115, (byte) 250, (byte) 62, (byte) 49, (byte) 141, (byte) 80, (byte) 205, (byte) 79, (byte) 173, (byte) 130, (byte) 176, (byte) 88, (byte) 10, (byte) 243, (byte) 120, (byte) 101, (byte) 37, (byte) 235, (byte) 215, (byte) 245, (byte) 249, (byte) 239, (byte) 113, (byte) 243, (byte) 122, (byte) 169, (byte) 214, (byte) 188, (byte) 132};
    private static final byte[] FxPFOh1LEIJa1oRPQk = {(byte) 39, (byte) 40, (byte) 226, (byte) 2, (byte) 57, (byte) 97, (byte) 23, (byte) 236, (byte) 147, (byte) 171, (byte) 20, (byte) 146, (byte) 41, (byte) 189, (byte) 203, (byte) 65, (byte) 89, (byte) 242, (byte) 200, (byte) 210, (byte) 206, (byte) 11, (byte) 255, (byte) 32, (byte) 198, (byte) 164, (byte) 119, (byte) 134, (byte) 29, (byte) 196, (byte) 25, (byte) 214};
    private static final byte[] yfTGNOLjq7zhUmDGumB1y = {(byte) 232, (byte) 102, (byte) 5, (byte) 151, (byte) 187, (byte) 86, (byte) 195, (byte) 80, (byte) 103, (byte) 60, (byte) 122, (byte) 102, (byte) 235, (byte) 188, (byte) 135, (byte) 214};

    public UsEbiuprSHpNw3qjITfH(Clans clans) {
        this.v8qP8fE86HMhvNuYPFjqY = clans;
        this.v8qP8fE86HMhvNuYPFjqY.getRegistredListeners().add(this);
    }

    @EventHandler
    public void v8qP8fE86HMhvNuYPFjqY(PlayerDeathEvent playerDeathEvent) {
        if (this.v8qP8fE86HMhvNuYPFjqY.getFiles().p31abtwfBag2jhMH6K().getBoolean(VkFI0Sl0NWlkTJi1I())) {
            Player killer = playerDeathEvent.getEntity().getKiller();
            Player entity = playerDeathEvent.getEntity();
            if (this.v8qP8fE86HMhvNuYPFjqY.getFiles().p31abtwfBag2jhMH6K().getStringList(A1IgJC9POLxmwZiq2P8Ojz()).stream().filter(str -> {
                return (str.endsWith(vFrNhVB6gwuHnmuH0z()) && entity.getWorld().getName().startsWith(str) && !entity.getWorld().getName().equals(str)) || entity.getWorld().getName().equals(str);
            }).findAny().isPresent()) {
                return;
            }
            try {
                List stringList = this.v8qP8fE86HMhvNuYPFjqY.getFiles().p31abtwfBag2jhMH6K().getStringList(DzjNsIl7zTrZXgIl3());
                if (stringList.size() > 0) {
                    Iterator it = stringList.iterator();
                    while (it.hasNext()) {
                        Optional<ClaimImplement> optionalHX3ZfRb1nSpNq57s7x5ui = this.v8qP8fE86HMhvNuYPFjqY.getIntegrationManager().HX3ZfRb1nSpNq57s7x5ui((String) it.next());
                        if (optionalHX3ZfRb1nSpNq57s7x5ui.isPresent() && optionalHX3ZfRb1nSpNq57s7x5ui.isPresent() && optionalHX3ZfRb1nSpNq57s7x5ui.get().hasClaimLocation(entity.getLocation())) {
                            return;
                        }
                    }
                }
            } catch (Exception e) {
            }
            Optional<RegionImplement> optionalHX3ZfRb1nSpNq57s7x5ui2 = this.v8qP8fE86HMhvNuYPFjqY.getIntegrationManager().HX3ZfRb1nSpNq57s7x5ui();
            if (!(optionalHX3ZfRb1nSpNq57s7x5ui2.isPresent() && optionalHX3ZfRb1nSpNq57s7x5ui2.get().playerHasRegionList(entity, this.v8qP8fE86HMhvNuYPFjqY.getFiles().p31abtwfBag2jhMH6K().getStringList(h5WOgQUNMCIMaYj()))) && (playerDeathEvent.getEntity() instanceof Player)) {
                if (!(playerDeathEvent.getEntity().getKiller() instanceof Player)) {
                    this.v8qP8fE86HMhvNuYPFjqY.getPlayerManager().xtOheRiObl4QeAl((Player) null, entity);
                } else {
                    if (this.v8qP8fE86HMhvNuYPFjqY.getPlayerAPI().isSameClan(killer.getUniqueId(), entity.getUniqueId())) {
                        return;
                    }
                    this.v8qP8fE86HMhvNuYPFjqY.getPlayerManager().xtOheRiObl4QeAl(killer, entity);
                }
            }
        }
    }

    private static String VkFI0Sl0NWlkTJi1I() {
        return "Config.player.kdr.enabled";
    }

    private static String A1IgJC9POLxmwZiq2P8Ojz() {
        return "Config.player.kdr.disabled_kdr_worlds";
    }

    private static String DzjNsIl7zTrZXgIl3() {
        return "Config.player.kdr.disabled_kdr_terrain";
    }

    private static String h5WOgQUNMCIMaYj() {
        return "Config.player.kdr.disabled_kdr_regions";
    }

    private static String vFrNhVB6gwuHnmuH0z() {
        return "%";
    }
}
