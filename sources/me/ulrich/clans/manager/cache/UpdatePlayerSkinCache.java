package me.ulrich.clans.manager.cache;

import java.io.IOException;
import java.util.Base64;
import java.util.Optional;
import java.util.UUID;
import me.ulrich.clans.Clans;
import me.ulrich.clans.data.PlayerData;
import me.ulrich.clans.library.kyori.adventure.text.serializer.commons.ComponentTreeConstants;
import me.ulrich.clans.manager.EnumFiles.Lang;
import me.ulrich.clans.manager.utils.MessageUtils;
import net.skinsrestorer.api.SkinsRestorer;
import net.skinsrestorer.api.property.SkinProperty;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.json.JSONObject;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/manager/cache/UpdatePlayerSkinCache.class */
public class UpdatePlayerSkinCache {
    private Clans plugin;
    private UUID uuid;

    public UpdatePlayerSkinCache(Clans clans, UUID uuid) {
        this.plugin = clans;
        this.uuid = uuid;
        clans.getTaskManager().xtOheRiObl4QeAl().runTaskAsynchronously(() -> {
            run();
        });
    }

    public void run() {
        SkinsRestorer skinsRestorerAPI;
        String str;
        JSONObject jSONObject;
        String string;
        if (this.plugin.getFiles().p31abtwfBag2jhMH6K().getBoolean("Config.player.skin.store") && this.plugin.getPlayerManager().b4i2FbOkaKeg91LiAe6l(this.uuid)) {
            Optional<PlayerData> optionalP31abtwfBag2jhMH6K = this.plugin.getPlayerManager().p31abtwfBag2jhMH6K(this.uuid);
            if (optionalP31abtwfBag2jhMH6K.isPresent()) {
                if (!this.plugin.getFiles().p31abtwfBag2jhMH6K().getBoolean("Config.player.skin.prefer_to_hook")) {
                    String[] fromUUID = null;
                    if (this.plugin.getFiles().p31abtwfBag2jhMH6K().getBoolean("Config.player.skin.enable_offline")) {
                        try {
                            fromUUID = new SkinReader().getFromName(optionalP31abtwfBag2jhMH6K.get().getName());
                        } catch (Exception e) {
                        }
                    } else {
                        try {
                            fromUUID = new SkinReader().getFromUUID(this.uuid);
                        } catch (Exception e2) {
                        }
                    }
                    try {
                        if (fromUUID[0] != null && (str = fromUUID[0]) != null && (jSONObject = new JSONObject(new String(Base64.getDecoder().decode(str)))) != null && (string = jSONObject.getJSONObject("textures").getJSONObject("SKIN").getString(ComponentTreeConstants.CLICK_EVENT_URL)) != null) {
                            String strEncodeToString = Base64.getEncoder().encodeToString(("{\"textures\":{\"SKIN\":{\"url\":\"" + string + "\"}}}").getBytes());
                            if (strEncodeToString != null) {
                                optionalP31abtwfBag2jhMH6K.get().setCache(strEncodeToString);
                                this.plugin.getPlayerManager().v8qP8fE86HMhvNuYPFjqY(optionalP31abtwfBag2jhMH6K.get());
                                try {
                                    Player player = Bukkit.getPlayer(this.uuid);
                                    if (player.isOnline()) {
                                        MessageUtils.sendText((CommandSender) player, this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.CLAN_PLAYER_SKIN_FINISH_UPDATE));
                                    }
                                    return;
                                } catch (Exception e3) {
                                    return;
                                }
                            }
                            try {
                                Player player2 = Bukkit.getPlayer(this.uuid);
                                if (player2.isOnline()) {
                                    MessageUtils.sendText((CommandSender) player2, this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player2.getUniqueId())).getString(Lang.CLAN_PLAYER_SKIN_ERROR_UPDATE));
                                }
                            } catch (Exception e4) {
                            }
                        }
                        return;
                    } catch (Exception e5) {
                        return;
                    }
                }
                if (this.plugin.getFiles().p31abtwfBag2jhMH6K().getBoolean("Config.player.skin.hooks.skinsrestorer.enabled") && this.plugin.getHooksManager().isSkinsRestorer() && (skinsRestorerAPI = this.plugin.getHooksManager().getSkinsRestorerAPI()) != null) {
                    String value = null;
                    String str2 = null;
                    String string2 = this.plugin.getFiles().p31abtwfBag2jhMH6K().getString("Config.player.skin.hooks.skinsrestorer.useplaceholder");
                    if (!string2.isEmpty() && this.plugin.getHooksManager().isPlaceholderapi()) {
                        try {
                            String papi = this.plugin.getHooksManager().parsePapi(this.uuid, string2);
                            if (papi != null && !papi.equalsIgnoreCase(string2) && !papi.equalsIgnoreCase("error")) {
                                str2 = "{\"textures\":{\"SKIN\":{\"url\":\"" + papi + "\"}}}";
                                value = Base64.getEncoder().encodeToString(str2.getBytes());
                            }
                        } catch (Exception e6) {
                        }
                    }
                    if (value == null) {
                        try {
                            Optional skinOfPlayer = skinsRestorerAPI.getPlayerStorage().getSkinOfPlayer(this.uuid);
                            if (skinOfPlayer.isPresent() && ((SkinProperty) skinOfPlayer.get()).getValue() != null) {
                                value = ((SkinProperty) skinOfPlayer.get()).getValue();
                            }
                        } catch (Exception e7) {
                            e7.printStackTrace();
                        }
                    }
                    if (value == null) {
                        try {
                            Player player3 = Bukkit.getPlayer(this.uuid);
                            if (player3.isOnline()) {
                                MessageUtils.sendText((CommandSender) player3, this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player3.getUniqueId())).getString(Lang.CLAN_PLAYER_SKIN_ERROR_UPDATE));
                            }
                            return;
                        } catch (Exception e8) {
                            return;
                        }
                    }
                    Optional<String> optionalMojangSkinFix = MojangSkinFix(str2);
                    if (optionalMojangSkinFix.isPresent()) {
                        value = Base64.getEncoder().encodeToString(optionalMojangSkinFix.get().getBytes());
                    }
                    optionalP31abtwfBag2jhMH6K.get().setCache(value);
                    this.plugin.getPlayerManager().v8qP8fE86HMhvNuYPFjqY(optionalP31abtwfBag2jhMH6K.get());
                    try {
                        Player player4 = Bukkit.getPlayer(this.uuid);
                        if (player4.isOnline()) {
                            MessageUtils.sendText((CommandSender) player4, this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player4.getUniqueId())).getString(Lang.CLAN_PLAYER_SKIN_FINISH_UPDATE));
                        }
                    } catch (Exception e9) {
                    }
                }
            }
        }
    }

    public Optional<String> MojangSkinFix(String str) {
        JSONObject jSONObject = new JSONObject(str);
        JSONObject jSONObject2 = jSONObject.getJSONObject("textures");
        if (!jSONObject2.has("SKIN")) {
            return Optional.empty();
        }
        JSONObject jSONObject3 = jSONObject2.getJSONObject("SKIN");
        String string = jSONObject3.getString(ComponentTreeConstants.CLICK_EVENT_URL);
        if (!string.startsWith("http")) {
            jSONObject3.put(ComponentTreeConstants.CLICK_EVENT_URL, "http://textures.minecraft.net/texture/" + string);
        }
        return Optional.of(jSONObject.toString(2).replace(" ", ""));
    }
}
