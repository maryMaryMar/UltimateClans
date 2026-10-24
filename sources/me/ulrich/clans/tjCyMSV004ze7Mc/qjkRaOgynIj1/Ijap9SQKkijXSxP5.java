package me.ulrich.clans.tjCyMSV004ze7Mc.qjkRaOgynIj1;

import org.bukkit.entity.Entity;

import java.util.Optional;
import java.util.UUID;
import me.ulrich.clans.Clans;
import me.ulrich.clans.manager.DTKXb4fQF6nDgxzg.tjCyMSV004ze7Mc.DTKXb4fQF6nDgxzg.ECMfR2SxjZy2nLBVbPf;
import me.ulrich.clans.manager.EnumFiles.Lang;
import me.ulrich.clans.manager.hZj37I9dZHauT;
import me.ulrich.clans.manager.utils.CooldownAPI;
import me.ulrich.clans.manager.utils.MessageUtils;
import me.ulrich.clans.manager.utils.VersionUtil;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/tjCyMSV004ze7Mc/qjkRaOgynIj1/Ijap9SQKkijXSxP5.class */
public class Ijap9SQKkijXSxP5 implements Listener {
    private final Clans v8qP8fE86HMhvNuYPFjqY;
    private static String PrUEDOs87rzhGE2;
    private static String ARjA6dwlv77okQ9Akc;
    private static String HvlRf0CMx2w2gIjSRf;
    private static volatile String TWDB0gZUeeDwF8ibN;
    private static String JmlYxoMNKaQiar;
    private static final byte[] j9RoX6JDAjBtdMkwO8X = {(byte) 248, (byte) 211, (byte) 229, (byte) 77, (byte) 66, (byte) 157, (byte) 170, (byte) 119, (byte) 201, (byte) 103, (byte) 72, (byte) 229, (byte) 239, (byte) 134, (byte) 99, (byte) 46};
    private static final byte[] ubimFTJKjFb65P99NmEz = {(byte) 212, (byte) 134, (byte) 103, (byte) 29, (byte) 196, (byte) 106, (byte) 33, (byte) 136, (byte) 15, (byte) 203, (byte) 163, (byte) 67, (byte) 21, (byte) 174, (byte) 105, (byte) 253};
    private static final byte[] MQRepbyqKZX4rE = {(byte) 112, (byte) 97, (byte) 201, (byte) 223, (byte) 247, (byte) 197, (byte) 50, (byte) 107, (byte) 241, (byte) 132, (byte) 86, (byte) 88, (byte) 133, (byte) 79, (byte) 16, (byte) 122, (byte) 162, (byte) 50, (byte) 250, (byte) 148, (byte) 33, (byte) 52, (byte) 91, (byte) 184, (byte) 106, (byte) 12, (byte) 134, (byte) 41, (byte) 58, (byte) 237, (byte) 186, (byte) 251};
    private static final byte[] LPQaKcoCRldr3pv = {(byte) 121, (byte) 206, (byte) 197, (byte) 1, (byte) 105, (byte) 111, (byte) 215, (byte) 222, (byte) 21, (byte) 171, (byte) 65, (byte) 142, (byte) 150, (byte) 30, (byte) 136, (byte) 136, (byte) 131, (byte) 178, (byte) 2, (byte) 200, (byte) 152, (byte) 113, (byte) 182, (byte) 234, (byte) 50, (byte) 147, (byte) 169, (byte) 79, (byte) 250, (byte) 195, (byte) 185, (byte) 42};
    private static final byte[] mtQzZc8L8mh1GF8y = {(byte) 77, (byte) 146, (byte) 48, (byte) 127, (byte) 230, (byte) 55, (byte) 171, (byte) 182, (byte) 97, (byte) 161, (byte) 164, (byte) 199, (byte) 101, (byte) 69, (byte) 198, (byte) 67};

    public Ijap9SQKkijXSxP5(Clans clans) {
        this.v8qP8fE86HMhvNuYPFjqY = clans;
        this.v8qP8fE86HMhvNuYPFjqY.getRegistredListeners().add(this);
    }

    @EventHandler
    public void v8qP8fE86HMhvNuYPFjqY(EntityDamageEvent entityDamageEvent) {
        if (!entityDamageEvent.isCancelled() && this.v8qP8fE86HMhvNuYPFjqY.getFiles().p31abtwfBag2jhMH6K().getBoolean(qIFL0KEWmZBMaffF()) && (entityDamageEvent instanceof EntityDamageByEntityEvent) && !this.v8qP8fE86HMhvNuYPFjqY.getClanManager().b4i2FbOkaKeg91LiAe6l()) {
            EntityDamageByEntityEvent entityDamageByEntityEvent = (EntityDamageByEntityEvent) entityDamageEvent;
            if (entityDamageByEntityEvent.getEntity() == null || entityDamageByEntityEvent.getDamager() == null || !(entityDamageByEntityEvent.getEntity() instanceof Player)) {
                return;
            }
            Player entity = (Player) entityDamageByEntityEvent.getEntity();
            Player player = null;
            Entity damager = entityDamageByEntityEvent.getDamager();
            if (damager instanceof Player) {
                player = (Player) damager;
            }
            if (damager instanceof Projectile) {
                Projectile projectile = (Projectile) damager;
                if (projectile.getShooter() instanceof Player) {
                    player = (Player) projectile.getShooter();
                }
            }
            if (VersionUtil.isAbove(VersionUtil.VersionEnum.V113) && damager.getType().name().equals(N9WEkWar25tgkaPHRE6())) {
                try {
                    Object objInvoke = damager.getClass().getMethod(a6ZaYrG9xJYTJ8rudPMPJj(), new Class[0]).invoke(damager, new Object[0]);
                    if (objInvoke instanceof Player) {
                        player = (Player) objInvoke;
                    }
                } catch (Exception e) {
                }
            }
            if (player == null || player.equals(entity) || this.v8qP8fE86HMhvNuYPFjqY.getHooksManager().isInDuel(entity) || this.v8qP8fE86HMhvNuYPFjqY.getHooksManager().isInDuel(player)) {
                return;
            }
            UUID uniqueId = player.getUniqueId();
            hZj37I9dZHauT playerManager = this.v8qP8fE86HMhvNuYPFjqY.getPlayerManager();
            if (playerManager.v8qP8fE86HMhvNuYPFjqY(player, entity)) {
                playerManager.v8qP8fE86HMhvNuYPFjqY(player, entity, entityDamageEvent.getDamage());
                return;
            }
            entityDamageEvent.setCancelled(true);
            if (CooldownAPI.isInCooldown(uniqueId, EHoq7BuZe20VTlDea2wg())) {
                return;
            }
            MessageUtils.sendText((CommandSender) player, this.v8qP8fE86HMhvNuYPFjqY.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(uniqueId)).getString(Lang.CLAN_PVP_DISABLED));
            new CooldownAPI(uniqueId, CbmWRyh4M369Fjp61dBnJb(), 1).start();
        }
    }

    public Clans v8qP8fE86HMhvNuYPFjqY() {
        return this.v8qP8fE86HMhvNuYPFjqY;
    }

    private static String qIFL0KEWmZBMaffF() {
        return "Config.player.ff.enabled";
    }

    private static String N9WEkWar25tgkaPHRE6() {
        return "FIREWORK";
    }

    private static String a6ZaYrG9xJYTJ8rudPMPJj() {
        return "getShooter";
    }

    private static String EHoq7BuZe20VTlDea2wg() {
        return "pvp";
    }

    private static String CbmWRyh4M369Fjp61dBnJb() {
        return "pvp";
    }
}
