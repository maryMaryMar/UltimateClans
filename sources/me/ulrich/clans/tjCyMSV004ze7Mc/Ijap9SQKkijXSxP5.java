package me.ulrich.clans.tjCyMSV004ze7Mc;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Optional;
import java.util.UUID;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import me.ulrich.clans.Clans;
import me.ulrich.clans.data.ClanData;
import me.ulrich.clans.data.ClanEnum;
import me.ulrich.clans.data.PlayerData;
import me.ulrich.clans.events.ClanCreateEvent;
import me.ulrich.clans.events.ClanDeleteEvent;
import me.ulrich.clans.events.ClanEntityEndEvent;
import me.ulrich.clans.events.ClanExtraChestEvent;
import me.ulrich.clans.events.ClanGlobalFriendlyFire;
import me.ulrich.clans.events.ClanKDRChangeEvent;
import me.ulrich.clans.events.ClanLeaderChangeEvent;
import me.ulrich.clans.events.ClanMessageEvent;
import me.ulrich.clans.events.ClanModTagEvent;
import me.ulrich.clans.events.ClanPlayerBanEvent;
import me.ulrich.clans.events.ClanPlayerJoinEvent;
import me.ulrich.clans.events.ClanPlayerKDRChangeEvent;
import me.ulrich.clans.events.ClanPlayerKickedEvent;
import me.ulrich.clans.events.ClanPlayerLeaveEvent;
import me.ulrich.clans.events.ClanPlayerRoleChangeEvent;
import me.ulrich.clans.events.ClanPlayerSoulsChangeEvent;
import me.ulrich.clans.events.ClanSoulsChangeEvent;
import me.ulrich.clans.events.ClanVerifyChangeEvent;
import me.ulrich.clans.manager.EnumFiles.Lang;
import me.ulrich.clans.manager.utils.MessageUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/tjCyMSV004ze7Mc/Ijap9SQKkijXSxP5.class */
public class Ijap9SQKkijXSxP5 implements Listener {
    private Clans v8qP8fE86HMhvNuYPFjqY;
    private static volatile String p1vM33XRz2MRRzNN67oMl;
    private static String QseG3fTvyPGRIt6;
    private static String lmJhx5QJnIGgM22jgOyM;
    private static volatile String xobPbOT1fT4WAgq7yitY;
    private static volatile String vZ07463aKmVnlr8o;
    private static String RNphAjQmJxeezQe8buNtpi;
    private static String yDvbHgh8ETq2QCGUi;
    private static String QNzu3qLp481pnUfBMzN8;
    private static final byte[] w379SKPmZncpHpinGoiXK = {(byte) 113, (byte) 186, (byte) 134, (byte) 138, (byte) 250, (byte) 39, (byte) 95, (byte) 65, (byte) 76, (byte) 167, (byte) 77, (byte) 70, (byte) 88, (byte) 124, (byte) 21, (byte) 60};
    private static final byte[] nNlGE8ylqXsVHa = {(byte) 113, (byte) 186, (byte) 134, (byte) 138, (byte) 250, (byte) 39, (byte) 95, (byte) 65, (byte) 76, (byte) 167, (byte) 77, (byte) 70, (byte) 88, (byte) 124, (byte) 21, (byte) 60};
    private static final byte[] H17LqNjJtd7KpS = {(byte) 113, (byte) 186, (byte) 134, (byte) 138, (byte) 250, (byte) 39, (byte) 95, (byte) 65, (byte) 76, (byte) 167, (byte) 77, (byte) 70, (byte) 88, (byte) 124, (byte) 21, (byte) 60};
    private static final byte[] fAL7iLPhOn7at0Jv5Javi = {(byte) 98, (byte) 127, (byte) 162, (byte) 56, (byte) 222, (byte) 251, (byte) 192, (byte) 47, (byte) 252, (byte) 238, (byte) 30, (byte) 16, (byte) 163, (byte) 200, (byte) 81, (byte) 44, (byte) 170, (byte) 217, (byte) 83, (byte) 251, (byte) 188, (byte) 51, (byte) 66, (byte) 147, (byte) 244, (byte) 153, (byte) 96, (byte) 197, (byte) 235, (byte) 16, (byte) 99, (byte) 144};
    private static final byte[] l4kGH667Jk7alVlkQiUKvg = {(byte) 37, (byte) 246, (byte) 195, (byte) 147, (byte) 16, (byte) 99, (byte) 38, (byte) 76, (byte) 56, (byte) 80, (byte) 166, (byte) 106, (byte) 181, (byte) 160, (byte) 39, (byte) 232};

    public Ijap9SQKkijXSxP5(Clans clans) {
        this.v8qP8fE86HMhvNuYPFjqY = clans;
        this.v8qP8fE86HMhvNuYPFjqY.getRegistredListeners().add(this);
    }

    @EventHandler
    public void v8qP8fE86HMhvNuYPFjqY(ClanEntityEndEvent clanEntityEndEvent) {
    }

    @EventHandler
    public void v8qP8fE86HMhvNuYPFjqY(ClanVerifyChangeEvent clanVerifyChangeEvent) {
        Optional<ClanData> optionalIZTqZaRK5UGoe0Z = this.v8qP8fE86HMhvNuYPFjqY.getClanManager().iZTqZaRK5UGoe0Z(clanVerifyChangeEvent.getClanID());
        if (optionalIZTqZaRK5UGoe0Z.isPresent()) {
            String string = this.v8qP8fE86HMhvNuYPFjqY.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(optionalIZTqZaRK5UGoe0Z.get().getLeader())).getString(Lang.CLAN_VERIFY_CHANGED, Arrays.asList("%value%;" + this.v8qP8fE86HMhvNuYPFjqY.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(optionalIZTqZaRK5UGoe0Z.get().getLeader())).getString(Lang.valueOf("TRANSLACTION_NOYES_" + String.valueOf(optionalIZTqZaRK5UGoe0Z.get().isVerified()).toUpperCase()))));
            if (string.isEmpty()) {
                return;
            }
            Bukkit.getPluginManager().callEvent(new ClanMessageEvent(string, false, true, false, optionalIZTqZaRK5UGoe0Z.get().getId()));
        }
    }

    @EventHandler
    public void v8qP8fE86HMhvNuYPFjqY(ClanPlayerRoleChangeEvent clanPlayerRoleChangeEvent) {
        Optional<ClanData> optionalIZTqZaRK5UGoe0Z = this.v8qP8fE86HMhvNuYPFjqY.getClanManager().iZTqZaRK5UGoe0Z(clanPlayerRoleChangeEvent.getClanID());
        if (optionalIZTqZaRK5UGoe0Z.isPresent()) {
            if (clanPlayerRoleChangeEvent.getAction().equals(ClanEnum.ClanActions.PROMOTEMEMBER)) {
                String string = this.v8qP8fE86HMhvNuYPFjqY.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(clanPlayerRoleChangeEvent.getPlayer())).getString(Lang.CLAN_NEW_PROMOTE);
                if (string.isEmpty()) {
                    return;
                }
                Bukkit.getPluginManager().callEvent(new ClanMessageEvent(this.v8qP8fE86HMhvNuYPFjqY.getClanManager().jBUuLP0sWwaPyPOmogdX7l(clanPlayerRoleChangeEvent.getPlayer(), string), false, true, false, optionalIZTqZaRK5UGoe0Z.get().getId()));
                return;
            }
            if (clanPlayerRoleChangeEvent.getAction().equals(ClanEnum.ClanActions.DEMOTEMEMBER)) {
                String string2 = this.v8qP8fE86HMhvNuYPFjqY.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(clanPlayerRoleChangeEvent.getPlayer())).getString(Lang.CLAN_NEW_DEMOTE);
                if (string2.isEmpty()) {
                    return;
                }
                Bukkit.getPluginManager().callEvent(new ClanMessageEvent(this.v8qP8fE86HMhvNuYPFjqY.getClanManager().jBUuLP0sWwaPyPOmogdX7l(clanPlayerRoleChangeEvent.getPlayer(), string2), false, true, false, optionalIZTqZaRK5UGoe0Z.get().getId()));
            }
        }
    }

    @EventHandler
    public void v8qP8fE86HMhvNuYPFjqY(ClanPlayerBanEvent clanPlayerBanEvent) {
        Optional<ClanData> optionalIZTqZaRK5UGoe0Z = this.v8qP8fE86HMhvNuYPFjqY.getClanManager().iZTqZaRK5UGoe0Z(clanPlayerBanEvent.getClanID());
        Optional<PlayerData> optionalP31abtwfBag2jhMH6K = this.v8qP8fE86HMhvNuYPFjqY.getPlayerManager().p31abtwfBag2jhMH6K(clanPlayerBanEvent.getPlayer());
        if (optionalIZTqZaRK5UGoe0Z.isPresent()) {
            String string = this.v8qP8fE86HMhvNuYPFjqY.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(optionalIZTqZaRK5UGoe0Z.get().getLeader())).getString(Lang.CLAN_PLAYER_KICKED_OUTBY);
            if (!string.isEmpty()) {
                if (optionalP31abtwfBag2jhMH6K.isPresent()) {
                    string = string.replace(WmRKxS1NtqfnhLaWjEMd9U(), optionalP31abtwfBag2jhMH6K.get().getName());
                }
                Bukkit.getPluginManager().callEvent(new ClanMessageEvent(this.v8qP8fE86HMhvNuYPFjqY.getClanManager().jBUuLP0sWwaPyPOmogdX7l(clanPlayerBanEvent.getSender(), string), false, true, false, optionalIZTqZaRK5UGoe0Z.get().getId()));
            }
            if (optionalP31abtwfBag2jhMH6K.isPresent()) {
                Player player = null;
                try {
                    player = Bukkit.getPlayer(optionalP31abtwfBag2jhMH6K.get().getId());
                } catch (Exception e) {
                }
                if (player == null || !player.isOnline()) {
                    return;
                }
                Player player2 = player;
                this.v8qP8fE86HMhvNuYPFjqY.getTaskManager().v8qP8fE86HMhvNuYPFjqY((Entity) player2, () -> {
                    if (this.v8qP8fE86HMhvNuYPFjqY.getPlayerManager().zJnaNCVQSgEShq(((PlayerData) optionalP31abtwfBag2jhMH6K.get()).getId())) {
                        return;
                    }
                    player2.closeInventory();
                    if (this.v8qP8fE86HMhvNuYPFjqY.getPlayerManager().ZwrsrwOCXRUscW6Q(player2)) {
                        this.v8qP8fE86HMhvNuYPFjqY.getPlayerManager().iZTqZaRK5UGoe0Z(player2);
                    }
                    String string2 = this.v8qP8fE86HMhvNuYPFjqY.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(((ClanData) optionalIZTqZaRK5UGoe0Z.get()).getLeader())).getString(Lang.CLAN_PLAYER_KICKED_OUT);
                    if (string2.isEmpty()) {
                        return;
                    }
                    MessageUtils.sendText((CommandSender) player2, this.v8qP8fE86HMhvNuYPFjqY.getClanManager().jBUuLP0sWwaPyPOmogdX7l(((ClanData) optionalIZTqZaRK5UGoe0Z.get()).getLeader(), string2));
                });
            }
        }
    }

    @EventHandler
    public void v8qP8fE86HMhvNuYPFjqY(ClanLeaderChangeEvent clanLeaderChangeEvent) {
        Optional<ClanData> optionalIZTqZaRK5UGoe0Z = this.v8qP8fE86HMhvNuYPFjqY.getClanManager().iZTqZaRK5UGoe0Z(clanLeaderChangeEvent.getClanID());
        Optional<PlayerData> optionalP31abtwfBag2jhMH6K = this.v8qP8fE86HMhvNuYPFjqY.getPlayerManager().p31abtwfBag2jhMH6K(clanLeaderChangeEvent.getOldLeader());
        if (optionalIZTqZaRK5UGoe0Z.isPresent()) {
            String string = this.v8qP8fE86HMhvNuYPFjqY.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(clanLeaderChangeEvent.getNewLeader())).getString(Lang.CLAN_NEW_LEADER);
            if (string.isEmpty()) {
                return;
            }
            if (optionalP31abtwfBag2jhMH6K.isPresent()) {
                string = string.replace(U3y7OvZJSNhjaMeQpVg4n(), optionalP31abtwfBag2jhMH6K.get().getName());
            }
            Bukkit.getPluginManager().callEvent(new ClanMessageEvent(this.v8qP8fE86HMhvNuYPFjqY.getClanManager().jBUuLP0sWwaPyPOmogdX7l(optionalIZTqZaRK5UGoe0Z.get().getLeader(), string), false, true, false, optionalIZTqZaRK5UGoe0Z.get().getId()));
        }
    }

    @EventHandler
    public void v8qP8fE86HMhvNuYPFjqY(ClanModTagEvent clanModTagEvent) {
        Optional<ClanData> optionalIZTqZaRK5UGoe0Z = this.v8qP8fE86HMhvNuYPFjqY.getClanManager().iZTqZaRK5UGoe0Z(clanModTagEvent.getClanID());
        if (optionalIZTqZaRK5UGoe0Z.isPresent()) {
            String string = this.v8qP8fE86HMhvNuYPFjqY.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(optionalIZTqZaRK5UGoe0Z.get().getLeader())).getString(Lang.CLAN_TAG_CHANGED);
            if (string.isEmpty()) {
                return;
            }
            Bukkit.getPluginManager().callEvent(new ClanMessageEvent(this.v8qP8fE86HMhvNuYPFjqY.getClanManager().jBUuLP0sWwaPyPOmogdX7l(optionalIZTqZaRK5UGoe0Z.get().getLeader(), string), false, true, false, optionalIZTqZaRK5UGoe0Z.get().getId()));
        }
    }

    @EventHandler
    public void v8qP8fE86HMhvNuYPFjqY(ClanGlobalFriendlyFire clanGlobalFriendlyFire) {
        String string = this.v8qP8fE86HMhvNuYPFjqY.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.empty()).getString(Lang.CLAN_GLOBALFF_CHANGED);
        if (string.isEmpty()) {
            return;
        }
        Bukkit.getPluginManager().callEvent(new ClanMessageEvent(this.v8qP8fE86HMhvNuYPFjqY.getClanManager().jBUuLP0sWwaPyPOmogdX7l((UUID) null, string), true, false, false, null));
    }

    @EventHandler
    public void v8qP8fE86HMhvNuYPFjqY(ClanDeleteEvent clanDeleteEvent) {
        String string = this.v8qP8fE86HMhvNuYPFjqY.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.empty()).getString(Lang.CLAN_DELETED);
        if (string.isEmpty()) {
            return;
        }
        Bukkit.getPluginManager().callEvent(new ClanMessageEvent(string.replace(kxV2CDgIroznk6Aaqk(), clanDeleteEvent.getTag()), true, false, false, null));
    }

    @EventHandler
    public void v8qP8fE86HMhvNuYPFjqY(ClanCreateEvent clanCreateEvent) {
        Optional<ClanData> optionalIZTqZaRK5UGoe0Z = this.v8qP8fE86HMhvNuYPFjqY.getClanManager().iZTqZaRK5UGoe0Z(clanCreateEvent.getClanID());
        if (optionalIZTqZaRK5UGoe0Z.isPresent()) {
            String string = this.v8qP8fE86HMhvNuYPFjqY.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(optionalIZTqZaRK5UGoe0Z.get().getLeader())).getString(Lang.CLAN_CREATED);
            if (string.isEmpty()) {
                return;
            }
            Bukkit.getPluginManager().callEvent(new ClanMessageEvent(this.v8qP8fE86HMhvNuYPFjqY.getClanManager().jBUuLP0sWwaPyPOmogdX7l(optionalIZTqZaRK5UGoe0Z.get().getLeader(), string), true, false, false, null));
        }
    }

    @EventHandler
    public void v8qP8fE86HMhvNuYPFjqY(ClanKDRChangeEvent clanKDRChangeEvent) {
        Optional<ClanData> optionalIZTqZaRK5UGoe0Z = this.v8qP8fE86HMhvNuYPFjqY.getClanManager().iZTqZaRK5UGoe0Z(clanKDRChangeEvent.getClanID());
        if (optionalIZTqZaRK5UGoe0Z.isPresent()) {
            String string = this.v8qP8fE86HMhvNuYPFjqY.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(optionalIZTqZaRK5UGoe0Z.get().getLeader())).getString(Lang.CLAN_RESETED_KDR);
            if (string.isEmpty()) {
                return;
            }
            Bukkit.getPluginManager().callEvent(new ClanMessageEvent(this.v8qP8fE86HMhvNuYPFjqY.getClanManager().jBUuLP0sWwaPyPOmogdX7l(optionalIZTqZaRK5UGoe0Z.get().getLeader(), string), false, true, false, optionalIZTqZaRK5UGoe0Z.get().getId()));
        }
    }

    @EventHandler
    public void v8qP8fE86HMhvNuYPFjqY(ClanExtraChestEvent clanExtraChestEvent) {
        Optional<ClanData> optionalIZTqZaRK5UGoe0Z = this.v8qP8fE86HMhvNuYPFjqY.getClanManager().iZTqZaRK5UGoe0Z(clanExtraChestEvent.getClanID());
        String name = clanExtraChestEvent.getSender().getName();
        if (clanExtraChestEvent.getSender() instanceof Player) {
            Optional<PlayerData> optionalP31abtwfBag2jhMH6K = this.v8qP8fE86HMhvNuYPFjqY.getPlayerManager().p31abtwfBag2jhMH6K(((Player) clanExtraChestEvent.getSender()).getUniqueId());
            if (optionalP31abtwfBag2jhMH6K.isPresent()) {
                name = optionalP31abtwfBag2jhMH6K.get().getName();
            }
        }
        if (optionalIZTqZaRK5UGoe0Z.isPresent()) {
            String string = this.v8qP8fE86HMhvNuYPFjqY.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(optionalIZTqZaRK5UGoe0Z.get().getLeader())).getString(Lang.CHEST_EXTRA_BUYED_UPDATE);
            if (string.isEmpty()) {
                return;
            }
            Bukkit.getPluginManager().callEvent(new ClanMessageEvent(this.v8qP8fE86HMhvNuYPFjqY.getClanManager().jBUuLP0sWwaPyPOmogdX7l(optionalIZTqZaRK5UGoe0Z.get().getLeader(), string.replace(mZoi6G94gR5nNmxyH7(), name)), false, true, false, optionalIZTqZaRK5UGoe0Z.get().getId()));
        }
    }

    @EventHandler
    public void v8qP8fE86HMhvNuYPFjqY(ClanPlayerJoinEvent clanPlayerJoinEvent) {
        Optional<ClanData> optionalIZTqZaRK5UGoe0Z = this.v8qP8fE86HMhvNuYPFjqY.getClanManager().iZTqZaRK5UGoe0Z(clanPlayerJoinEvent.getClanID());
        Optional<PlayerData> optionalP31abtwfBag2jhMH6K = this.v8qP8fE86HMhvNuYPFjqY.getPlayerManager().p31abtwfBag2jhMH6K(clanPlayerJoinEvent.getPlayer());
        if (optionalIZTqZaRK5UGoe0Z.isPresent()) {
            String string = this.v8qP8fE86HMhvNuYPFjqY.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(clanPlayerJoinEvent.getPlayer())).getString(Lang.CLAN_NEW_JOIN);
            if (string.isEmpty()) {
                return;
            }
            if (optionalP31abtwfBag2jhMH6K.isPresent()) {
                string = string.replace(wSQe5UOcASc6W3x2E88(), optionalP31abtwfBag2jhMH6K.get().getName());
            }
            Bukkit.getPluginManager().callEvent(new ClanMessageEvent(this.v8qP8fE86HMhvNuYPFjqY.getClanManager().jBUuLP0sWwaPyPOmogdX7l(optionalIZTqZaRK5UGoe0Z.get().getLeader(), string), false, true, false, optionalIZTqZaRK5UGoe0Z.get().getId()));
        }
    }

    @EventHandler
    public void v8qP8fE86HMhvNuYPFjqY(ClanPlayerKickedEvent clanPlayerKickedEvent) {
        Optional<ClanData> optionalIZTqZaRK5UGoe0Z = this.v8qP8fE86HMhvNuYPFjqY.getClanManager().iZTqZaRK5UGoe0Z(clanPlayerKickedEvent.getClanID());
        Optional<PlayerData> optionalP31abtwfBag2jhMH6K = this.v8qP8fE86HMhvNuYPFjqY.getPlayerManager().p31abtwfBag2jhMH6K(clanPlayerKickedEvent.getPlayerKicked());
        if (optionalIZTqZaRK5UGoe0Z.isPresent() && optionalP31abtwfBag2jhMH6K.isPresent()) {
            String string = this.v8qP8fE86HMhvNuYPFjqY.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(optionalIZTqZaRK5UGoe0Z.get().getLeader())).getString(Lang.CLAN_NEW_KICK);
            if (string.isEmpty()) {
                return;
            }
            if (optionalP31abtwfBag2jhMH6K.isPresent()) {
                string = string.replace(VqjKkZ1XytCtmO(), optionalP31abtwfBag2jhMH6K.get().getName());
            }
            if (clanPlayerKickedEvent.getSender().isPresent()) {
                Optional<PlayerData> optionalP31abtwfBag2jhMH6K2 = this.v8qP8fE86HMhvNuYPFjqY.getPlayerManager().p31abtwfBag2jhMH6K(clanPlayerKickedEvent.getSender().get());
                if (optionalP31abtwfBag2jhMH6K2.isPresent()) {
                    string = string.replace(v0JH2DgEyIXppwQZGZE(), optionalP31abtwfBag2jhMH6K2.get().getName());
                }
            }
            Bukkit.getPluginManager().callEvent(new ClanMessageEvent(this.v8qP8fE86HMhvNuYPFjqY.getClanManager().jBUuLP0sWwaPyPOmogdX7l(optionalIZTqZaRK5UGoe0Z.get().getLeader(), string), false, true, false, optionalIZTqZaRK5UGoe0Z.get().getId()));
        }
    }

    @EventHandler
    public void v8qP8fE86HMhvNuYPFjqY(ClanPlayerLeaveEvent clanPlayerLeaveEvent) {
        Optional<ClanData> optionalIZTqZaRK5UGoe0Z = this.v8qP8fE86HMhvNuYPFjqY.getClanManager().iZTqZaRK5UGoe0Z(clanPlayerLeaveEvent.getClanID());
        Optional<PlayerData> optionalP31abtwfBag2jhMH6K = this.v8qP8fE86HMhvNuYPFjqY.getPlayerManager().p31abtwfBag2jhMH6K(clanPlayerLeaveEvent.getPlayer());
        if (optionalIZTqZaRK5UGoe0Z.isPresent()) {
            String string = this.v8qP8fE86HMhvNuYPFjqY.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(clanPlayerLeaveEvent.getPlayer())).getString(Lang.CLAN_NEW_LEAVE);
            if (string.isEmpty()) {
                return;
            }
            if (optionalP31abtwfBag2jhMH6K.isPresent()) {
                string = string.replace(gQGIk0fJ5Fot1uR9bRRgqP(), optionalP31abtwfBag2jhMH6K.get().getName());
            }
            Bukkit.getPluginManager().callEvent(new ClanMessageEvent(this.v8qP8fE86HMhvNuYPFjqY.getClanManager().jBUuLP0sWwaPyPOmogdX7l(optionalIZTqZaRK5UGoe0Z.get().getLeader(), string), false, true, false, optionalIZTqZaRK5UGoe0Z.get().getId()));
        }
    }

    @EventHandler
    public void v8qP8fE86HMhvNuYPFjqY(ClanPlayerKDRChangeEvent clanPlayerKDRChangeEvent) {
        Optional<ClanData> optionalCDW4Fj1iwdIXEOqWjiJSR = this.v8qP8fE86HMhvNuYPFjqY.getPlayerManager().CDW4Fj1iwdIXEOqWjiJSR(clanPlayerKDRChangeEvent.getPlayerUUID());
        Optional<PlayerData> optionalP31abtwfBag2jhMH6K = this.v8qP8fE86HMhvNuYPFjqY.getPlayerManager().p31abtwfBag2jhMH6K(clanPlayerKDRChangeEvent.getPlayerUUID());
        if (optionalP31abtwfBag2jhMH6K.isPresent() && optionalCDW4Fj1iwdIXEOqWjiJSR.isPresent()) {
            String string = this.v8qP8fE86HMhvNuYPFjqY.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(optionalCDW4Fj1iwdIXEOqWjiJSR.get().getLeader())).getString(Lang.PLAYER_CHANGED_KDR);
            if (string.isEmpty()) {
                return;
            }
            Bukkit.getPluginManager().callEvent(new ClanMessageEvent(this.v8qP8fE86HMhvNuYPFjqY.getClanManager().jBUuLP0sWwaPyPOmogdX7l(optionalP31abtwfBag2jhMH6K.get().getId(), string), false, true, false, optionalCDW4Fj1iwdIXEOqWjiJSR.get().getId()));
        }
    }

    @EventHandler
    public void v8qP8fE86HMhvNuYPFjqY(ClanSoulsChangeEvent clanSoulsChangeEvent) {
        Optional<ClanData> optionalIZTqZaRK5UGoe0Z = this.v8qP8fE86HMhvNuYPFjqY.getClanManager().iZTqZaRK5UGoe0Z(clanSoulsChangeEvent.getClanUUID());
        if (optionalIZTqZaRK5UGoe0Z.isPresent()) {
            String string = this.v8qP8fE86HMhvNuYPFjqY.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(optionalIZTqZaRK5UGoe0Z.get().getLeader())).getString(Lang.CLAN_CHANGED_SOULS);
            if (string.isEmpty()) {
                return;
            }
            Bukkit.getPluginManager().callEvent(new ClanMessageEvent(this.v8qP8fE86HMhvNuYPFjqY.getClanManager().jBUuLP0sWwaPyPOmogdX7l(optionalIZTqZaRK5UGoe0Z.get().getLeader(), string), false, true, false, optionalIZTqZaRK5UGoe0Z.get().getId()));
        }
    }

    @EventHandler
    public void v8qP8fE86HMhvNuYPFjqY(ClanPlayerSoulsChangeEvent clanPlayerSoulsChangeEvent) {
        Optional<PlayerData> optionalP31abtwfBag2jhMH6K = this.v8qP8fE86HMhvNuYPFjqY.getPlayerManager().p31abtwfBag2jhMH6K(clanPlayerSoulsChangeEvent.getPlayerUUID());
        if (optionalP31abtwfBag2jhMH6K.isPresent()) {
            String string = this.v8qP8fE86HMhvNuYPFjqY.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(clanPlayerSoulsChangeEvent.getPlayerUUID())).getString(Lang.PLAYER_CHANGED_SOULS);
            if (string.isEmpty()) {
                return;
            }
            Bukkit.getPluginManager().callEvent(new ClanMessageEvent(this.v8qP8fE86HMhvNuYPFjqY.getClanManager().jBUuLP0sWwaPyPOmogdX7l(optionalP31abtwfBag2jhMH6K.get().getId(), string), false, false, true, optionalP31abtwfBag2jhMH6K.get().getId()));
        }
    }

    private static String lYMgDJaSiNvB6RB6(byte[] bArr) {
        return "";
    }

    private static String WmRKxS1NtqfnhLaWjEMd9U() {
        return "{player_other}";
    }

    private static String U3y7OvZJSNhjaMeQpVg4n() {
        return "{player_other}";
    }

    private static String kxV2CDgIroznk6Aaqk() {
        return "{deleted_clan}";
    }

    private static String mZoi6G94gR5nNmxyH7() {
        return "{player_other}";
    }

    private static String wSQe5UOcASc6W3x2E88() {
        return "{player_other}";
    }

    private static String VqjKkZ1XytCtmO() {
        return "{player_other}";
    }

    private static String v0JH2DgEyIXppwQZGZE() {
        return "{player_kicker}";
    }

    private static String gQGIk0fJ5Fot1uR9bRRgqP() {
        return "{player_other}";
    }
}
