package me.ulrich.clans;

import java.util.Optional;
import java.util.UUID;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import me.clip.placeholderapi.expansion.Relational;
import me.ulrich.clans.data.ClanData;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/PlaceholderHook.class */
public class PlaceholderHook extends PlaceholderExpansion implements Relational {
    private Clans plugin;

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/PlaceholderHook$Ijap9SQKkijXSxP5.class */
    enum Ijap9SQKkijXSxP5 {
        ALLY,
        RIVAL,
        SAME
    }

    public PlaceholderHook(Clans clans) {
        this.plugin = clans;
    }

    public String getIdentifier() {
        return "uclans";
    }

    public String getPlugin() {
        return null;
    }

    public String getAuthor() {
        return "UlrichBR";
    }

    public String getVersion() {
        return "UClans V8";
    }

    public boolean persist() {
        return true;
    }

    public String onRequest(OfflinePlayer offlinePlayer, String str) {
        boolean zEndsWith = str.endsWith("_raw");
        if (zEndsWith) {
            str = str.substring(0, str.length() - 4);
        }
        String strV8qP8fE86HMhvNuYPFjqY = this.plugin.getClanPlaceholderAPI().v8qP8fE86HMhvNuYPFjqY(offlinePlayer, str);
        return zEndsWith ? strV8qP8fE86HMhvNuYPFjqY : this.plugin.getColorManager().iZTqZaRK5UGoe0Z(strV8qP8fE86HMhvNuYPFjqY);
    }

    public String onPlaceholderRequest(Player player, String str) {
        boolean zEndsWith = str.endsWith("_raw");
        if (zEndsWith) {
            str = str.substring(0, str.length() - 4);
        }
        String strV8qP8fE86HMhvNuYPFjqY = this.plugin.getClanPlaceholderAPI().v8qP8fE86HMhvNuYPFjqY((OfflinePlayer) player, str);
        return zEndsWith ? strV8qP8fE86HMhvNuYPFjqY : this.plugin.getColorManager().iZTqZaRK5UGoe0Z(strV8qP8fE86HMhvNuYPFjqY);
    }

    public String onPlaceholderRequest(Player player, Player player2, String str) {
        String str2;
        String str3;
        String str4;
        boolean zEndsWith = str.endsWith("_raw");
        if (zEndsWith) {
            str = str.substring(0, str.length() - 4);
        }
        if (str.equals("reltext")) {
            if (this.plugin.getPlayerManager().zJnaNCVQSgEShq(player.getUniqueId()) && this.plugin.getPlayerManager().zJnaNCVQSgEShq(player2.getUniqueId())) {
                Optional<ClanData> optionalCDW4Fj1iwdIXEOqWjiJSR = this.plugin.getPlayerManager().CDW4Fj1iwdIXEOqWjiJSR(player.getUniqueId());
                Optional<ClanData> optionalCDW4Fj1iwdIXEOqWjiJSR2 = this.plugin.getPlayerManager().CDW4Fj1iwdIXEOqWjiJSR(player2.getUniqueId());
                if (optionalCDW4Fj1iwdIXEOqWjiJSR.isPresent() && optionalCDW4Fj1iwdIXEOqWjiJSR2.isPresent()) {
                    if (optionalCDW4Fj1iwdIXEOqWjiJSR.get().getRivalAlly().getAlly().contains(optionalCDW4Fj1iwdIXEOqWjiJSR2.get().getId()) || optionalCDW4Fj1iwdIXEOqWjiJSR2.get().getRivalAlly().getAlly().contains(optionalCDW4Fj1iwdIXEOqWjiJSR.get().getId())) {
                        str4 = "Clan.relation.ally.text";
                    } else if (optionalCDW4Fj1iwdIXEOqWjiJSR.get().getRivalAlly().getRival().contains(optionalCDW4Fj1iwdIXEOqWjiJSR2.get().getId()) || optionalCDW4Fj1iwdIXEOqWjiJSR2.get().getRivalAlly().getRival().contains(optionalCDW4Fj1iwdIXEOqWjiJSR.get().getId())) {
                        str4 = "Clan.relation.rival.text";
                    } else {
                        str4 = !optionalCDW4Fj1iwdIXEOqWjiJSR2.get().getId().equals(optionalCDW4Fj1iwdIXEOqWjiJSR.get().getId()) ? "Clan.relation.neutral.text" : "Clan.relation.sameclan.text";
                    }
                    String string = this.plugin.getFiles().p31abtwfBag2jhMH6K().getString(str4);
                    return zEndsWith ? string : this.plugin.getColorManager().iZTqZaRK5UGoe0Z(string);
                }
            }
            String string2 = this.plugin.getFiles().p31abtwfBag2jhMH6K().getString("Clan.relation.neutral.text");
            return zEndsWith ? string2 : this.plugin.getColorManager().iZTqZaRK5UGoe0Z(string2);
        }
        if (!str.equals("reltext_coloured")) {
            if (str.equals("relboolean_ally")) {
                return isRelation(player, player2, Ijap9SQKkijXSxP5.ALLY) ? "true" : "false";
            }
            if (str.equals("relboolean_rival")) {
                return isRelation(player, player2, Ijap9SQKkijXSxP5.RIVAL) ? "true" : "false";
            }
            if (str.equals("relboolean_member")) {
                return isRelation(player, player2, Ijap9SQKkijXSxP5.SAME) ? "true" : "false";
            }
            return "";
        }
        if (this.plugin.getPlayerManager().zJnaNCVQSgEShq(player.getUniqueId()) && this.plugin.getPlayerManager().zJnaNCVQSgEShq(player2.getUniqueId())) {
            Optional<ClanData> optionalCDW4Fj1iwdIXEOqWjiJSR3 = this.plugin.getPlayerManager().CDW4Fj1iwdIXEOqWjiJSR(player.getUniqueId());
            Optional<ClanData> optionalCDW4Fj1iwdIXEOqWjiJSR4 = this.plugin.getPlayerManager().CDW4Fj1iwdIXEOqWjiJSR(player2.getUniqueId());
            if (optionalCDW4Fj1iwdIXEOqWjiJSR3.isPresent() && optionalCDW4Fj1iwdIXEOqWjiJSR4.isPresent()) {
                if (optionalCDW4Fj1iwdIXEOqWjiJSR3.get().getRivalAlly().getAlly().contains(optionalCDW4Fj1iwdIXEOqWjiJSR4.get().getId()) || optionalCDW4Fj1iwdIXEOqWjiJSR4.get().getRivalAlly().getAlly().contains(optionalCDW4Fj1iwdIXEOqWjiJSR3.get().getId())) {
                    str2 = "Clan.relation.ally.color";
                    str3 = "Clan.relation.ally.text";
                } else if (optionalCDW4Fj1iwdIXEOqWjiJSR3.get().getRivalAlly().getRival().contains(optionalCDW4Fj1iwdIXEOqWjiJSR4.get().getId()) || optionalCDW4Fj1iwdIXEOqWjiJSR4.get().getRivalAlly().getRival().contains(optionalCDW4Fj1iwdIXEOqWjiJSR3.get().getId())) {
                    str2 = "Clan.relation.rival.color";
                    str3 = "Clan.relation.rival.text";
                } else if (optionalCDW4Fj1iwdIXEOqWjiJSR4.get().getId().equals(optionalCDW4Fj1iwdIXEOqWjiJSR3.get().getId())) {
                    str2 = "Clan.relation.sameclan.color";
                    str3 = "Clan.relation.sameclan.text";
                } else {
                    str2 = "Clan.relation.neutral.color";
                    str3 = "Clan.relation.neutral.text";
                }
                String str5 = this.plugin.getFiles().p31abtwfBag2jhMH6K().getString(str2) + this.plugin.getFiles().p31abtwfBag2jhMH6K().getString(str3);
                return zEndsWith ? str5 : this.plugin.getColorManager().iZTqZaRK5UGoe0Z(str5);
            }
        }
        String str6 = this.plugin.getFiles().p31abtwfBag2jhMH6K().getString("Clan.relation.neutral.color") + this.plugin.getFiles().p31abtwfBag2jhMH6K().getString("Clan.relation.neutral.text");
        return zEndsWith ? str6 : this.plugin.getColorManager().iZTqZaRK5UGoe0Z(str6);
    }

    private boolean isRelation(Player player, Player player2, Ijap9SQKkijXSxP5 ijap9SQKkijXSxP5) {
        if (!this.plugin.getPlayerManager().zJnaNCVQSgEShq(player.getUniqueId()) || !this.plugin.getPlayerManager().zJnaNCVQSgEShq(player2.getUniqueId())) {
            return false;
        }
        Optional<ClanData> optionalCDW4Fj1iwdIXEOqWjiJSR = this.plugin.getPlayerManager().CDW4Fj1iwdIXEOqWjiJSR(player.getUniqueId());
        Optional<ClanData> optionalCDW4Fj1iwdIXEOqWjiJSR2 = this.plugin.getPlayerManager().CDW4Fj1iwdIXEOqWjiJSR(player2.getUniqueId());
        if (!optionalCDW4Fj1iwdIXEOqWjiJSR.isPresent() || !optionalCDW4Fj1iwdIXEOqWjiJSR2.isPresent()) {
            return false;
        }
        UUID id = optionalCDW4Fj1iwdIXEOqWjiJSR.get().getId();
        UUID id2 = optionalCDW4Fj1iwdIXEOqWjiJSR2.get().getId();
        switch (ijap9SQKkijXSxP5) {
            case ALLY:
                return optionalCDW4Fj1iwdIXEOqWjiJSR.get().getRivalAlly().getAlly().contains(id2) || optionalCDW4Fj1iwdIXEOqWjiJSR2.get().getRivalAlly().getAlly().contains(id);
            case RIVAL:
                return optionalCDW4Fj1iwdIXEOqWjiJSR.get().getRivalAlly().getRival().contains(id2) || optionalCDW4Fj1iwdIXEOqWjiJSR2.get().getRivalAlly().getRival().contains(id);
            case SAME:
                return id.equals(id2);
            default:
                return false;
        }
    }
}
