package me.ulrich.clans.manager;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import me.ulrich.clans.Clans;
import me.ulrich.clans.data.ClanData;
import me.ulrich.clans.data.GuiItemsData;
import me.ulrich.clans.data.ModerationData;
import me.ulrich.clans.data.NbtData;
import me.ulrich.clans.data.PlayerData;
import org.bukkit.Bukkit;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/manager/aK2d7aNWeGp9kLTwl.class */
public class aK2d7aNWeGp9kLTwl {
    private final Clans v8qP8fE86HMhvNuYPFjqY;
    private HashMap<String, ModerationData> jBUuLP0sWwaPyPOmogdX7l = new HashMap<>();
    private HashMap<UUID, HashMap<String, HashMap<String, Boolean>>> ZwrsrwOCXRUscW6Q = new HashMap<>();
    private static volatile String KxzQxQgsR0LrV9cuQXqblJ;
    private static String wTCs8z42ozvwUpFALnlv;
    private static String MUFFNckmGWlHxf6bl9;
    private static String bXblsaQ4njxDPo;
    private static String thuObQb2hJLjatWNshj78;
    private static String Dxkoq24PdnQVDOREl;
    private static String s5KLeifgV6XEJxtqZpAAt;
    private static volatile String IaxiaJji1XrwWNzX;
    private static volatile String pepUmcPuu2DQpACn3pgFC6;
    private static String o0R7Dm7neN4veKJs8;
    private static String tkidnw933pK5rQ;
    private static volatile String VNzpFGBpGQDoThwgj4I;
    private static String RciS2Yg5FYHMswzzwa;
    private static volatile String kWGx93LRNu9bgs5ZAugj;
    private static final byte[] Qek5jLA7Mwddhklwje7 = {(byte) 132, (byte) 91, (byte) 234, (byte) 138, (byte) 205, (byte) 235, (byte) 18, (byte) 212, (byte) 142, (byte) 45, (byte) 81, (byte) 111, (byte) 112, (byte) 142, (byte) 25, (byte) 64, (byte) 66, (byte) 74, (byte) 130, (byte) 81, (byte) 170, (byte) 234, (byte) 62, (byte) 128, (byte) 133, (byte) 142, (byte) 23, (byte) 50, (byte) 41, (byte) 109, (byte) 43, (byte) 59, (byte) 127, (byte) 195, (byte) 46, (byte) 124, (byte) 169, (byte) 146, (byte) 66, (byte) 189, (byte) 26, (byte) 79, (byte) 78, (byte) 143, (byte) 157, (byte) 103, (byte) 228, (byte) 64};
    private static final byte[] l5Ft6Sz72cUDca0Diwb = {(byte) 25, (byte) 14, (byte) 100, (byte) 36, (byte) 100, (byte) 138, (byte) 126, (byte) 23, (byte) 193, (byte) 110, (byte) 114, (byte) 31, (byte) 9, (byte) 138, (byte) 52, (byte) 15, (byte) 171, (byte) 47, (byte) 18, (byte) 133, (byte) 104, (byte) 17, (byte) 151, (byte) 53, (byte) 59, (byte) 133, (byte) 157, (byte) 102, (byte) 134, (byte) 181, (byte) 253, (byte) 95, (byte) 217, (byte) 218, (byte) 57, (byte) 234, (byte) 122, (byte) 21, (byte) 78, (byte) 183, (byte) 242, (byte) 77, (byte) 57, (byte) 174, (byte) 200, (byte) 130, (byte) 3, (byte) 133};
    private static final byte[] XDGaEKTh8ZDN2acwnP1E = {(byte) 25, (byte) 14, (byte) 100, (byte) 36, (byte) 100, (byte) 138, (byte) 126, (byte) 23, (byte) 193, (byte) 110, (byte) 114, (byte) 31, (byte) 9, (byte) 138, (byte) 52, (byte) 15, (byte) 171, (byte) 47, (byte) 18, (byte) 133, (byte) 104, (byte) 17, (byte) 151, (byte) 53, (byte) 59, (byte) 133, (byte) 157, (byte) 102, (byte) 134, (byte) 181, (byte) 253, (byte) 95, (byte) 217, (byte) 218, (byte) 57, (byte) 234, (byte) 122, (byte) 21, (byte) 78, (byte) 183, (byte) 242, (byte) 77, (byte) 57, (byte) 174, (byte) 200, (byte) 130, (byte) 3, (byte) 133};
    private static final byte[] pFcrHQu11iGuXi = {(byte) 209, (byte) 36, (byte) 216, (byte) 33, (byte) 145, (byte) 46, (byte) 74, (byte) 66, (byte) 215, (byte) 159, (byte) 93, (byte) 110, (byte) 108, (byte) 5, (byte) 144, (byte) 197};
    private static final byte[] hySY0vNoTY8gpGsZ = {(byte) 209, (byte) 36, (byte) 216, (byte) 33, (byte) 145, (byte) 46, (byte) 74, (byte) 66, (byte) 215, (byte) 159, (byte) 93, (byte) 110, (byte) 108, (byte) 5, (byte) 144, (byte) 197};
    private static final byte[] UZz9JEeSRYAon1METf = {(byte) 209, (byte) 36, (byte) 216, (byte) 33, (byte) 145, (byte) 46, (byte) 74, (byte) 66, (byte) 215, (byte) 159, (byte) 93, (byte) 110, (byte) 108, (byte) 5, (byte) 144, (byte) 197};
    private static final byte[] F76iThXnpXsmavN7wXV = {(byte) 227, (byte) 114, (byte) 11, (byte) 94, (byte) 2, (byte) 49, (byte) 182, (byte) 168, (byte) 82, (byte) 217, (byte) 143, (byte) 109, (byte) 77, (byte) 7, (byte) 174, (byte) 115};
    private static final byte[] yg9rYJ3wXyhi1J = {(byte) 41, (byte) 185, (byte) 162, (byte) 192, (byte) 242, (byte) 54, (byte) 190, (byte) 58, (byte) 180, (byte) 200, (byte) 72, (byte) 192, (byte) 14, (byte) 210, (byte) 168, (byte) 87};
    private static final byte[] YuEJIrU2AASrNNzH = {(byte) 198, (byte) 98, (byte) 3, (byte) 202, (byte) 158, (byte) 49, (byte) 9, (byte) 74, (byte) 44, (byte) 162, (byte) 221, (byte) 33, (byte) 118, (byte) 171, (byte) 223, (byte) 155, (byte) 133, (byte) 22, (byte) 108, (byte) 40, (byte) 52, (byte) 189, (byte) 187, (byte) 154, (byte) 222, (byte) 59, (byte) 159, (byte) 232, (byte) 107, (byte) 213, (byte) 163, (byte) 69, (byte) 62, (byte) 131, (byte) 108, (byte) 208, (byte) 185, (byte) 142, (byte) 32, (byte) 177, (byte) 92, (byte) 79, (byte) 81, (byte) 25, (byte) 49, (byte) 95, (byte) 243, (byte) 120};

    public aK2d7aNWeGp9kLTwl(Clans clans) {
        this.v8qP8fE86HMhvNuYPFjqY = clans;
        v8qP8fE86HMhvNuYPFjqY();
    }

    public void v8qP8fE86HMhvNuYPFjqY(UUID uuid, HashMap<String, HashMap<String, Boolean>> map) {
        me.ulrich.clans.manager.DTKXb4fQF6nDgxzg.qjkRaOgynIj1.DTKXb4fQF6nDgxzg.RuVgd0Dnv0ddhdcWL.v8qP8fE86HMhvNuYPFjqY(uuid, map);
    }

    public void v8qP8fE86HMhvNuYPFjqY(UUID uuid) {
        me.ulrich.clans.manager.DTKXb4fQF6nDgxzg.qjkRaOgynIj1.DTKXb4fQF6nDgxzg.Ijap9SQKkijXSxP5.v8qP8fE86HMhvNuYPFjqY(uuid);
    }

    public void jBUuLP0sWwaPyPOmogdX7l(UUID uuid) {
        me.ulrich.clans.manager.DTKXb4fQF6nDgxzg.qjkRaOgynIj1.DTKXb4fQF6nDgxzg.ZRp1tak21UvNaOVCtFx.v8qP8fE86HMhvNuYPFjqY(uuid);
    }

    public void v8qP8fE86HMhvNuYPFjqY(boolean z) {
        me.ulrich.clans.manager.DTKXb4fQF6nDgxzg.qjkRaOgynIj1.DTKXb4fQF6nDgxzg.UsEbiuprSHpNw3qjITfH.v8qP8fE86HMhvNuYPFjqY();
    }

    public void v8qP8fE86HMhvNuYPFjqY() {
        Set<String> keys;
        zJnaNCVQSgEShq().clear();
        ConfigurationSection configurationSection = this.v8qP8fE86HMhvNuYPFjqY.getFiles().IO1OGSMpoP1ZjOsbXi3a().getConfigurationSection(IZSjnv4IyGiswPpUL9());
        if (configurationSection == null || (keys = configurationSection.getKeys(false)) == null) {
            return;
        }
        for (String str : keys) {
            try {
                HashMap<String, Boolean> map = new HashMap<>();
                try {
                    for (String str2 : this.v8qP8fE86HMhvNuYPFjqY.getFiles().IO1OGSMpoP1ZjOsbXi3a().getStringList("Moderation.list." + str + ".default_permissions")) {
                        boolean zBooleanValue = true;
                        if (str2.contains(cQyY6yRuDh96Hh1zP())) {
                            String[] strArrSplit = str2.split(OPC5MNwsEOOU06hSdcMsN());
                            if (strArrSplit.length == 2) {
                                String str3 = strArrSplit[0];
                                try {
                                    zBooleanValue = Boolean.valueOf(strArrSplit[1]).booleanValue();
                                } catch (Exception e) {
                                }
                                map.put(v8qP8fE86HMhvNuYPFjqY(str3), Boolean.valueOf(zBooleanValue));
                            }
                        } else {
                            map.put(v8qP8fE86HMhvNuYPFjqY(str2), true);
                        }
                    }
                } catch (Exception e2) {
                }
                GuiItemsData guiItemsData = null;
                try {
                    if (this.v8qP8fE86HMhvNuYPFjqY.getFiles().IO1OGSMpoP1ZjOsbXi3a().contains("Moderation.list." + str + ".icon")) {
                        guiItemsData = new GuiItemsData(str, str, this.v8qP8fE86HMhvNuYPFjqY.getFiles().IO1OGSMpoP1ZjOsbXi3a().getString("Moderation.list." + str + ".icon.material"), this.v8qP8fE86HMhvNuYPFjqY.getFiles().IO1OGSMpoP1ZjOsbXi3a().getInt("Moderation.list." + str + ".icon.amount"), this.v8qP8fE86HMhvNuYPFjqY.getFiles().IO1OGSMpoP1ZjOsbXi3a().getBoolean("Moderation.list." + str + ".icon.glow"), this.v8qP8fE86HMhvNuYPFjqY.getFiles().IO1OGSMpoP1ZjOsbXi3a().getString("Moderation.list." + str + ".icon.name"), this.v8qP8fE86HMhvNuYPFjqY.getFiles().IO1OGSMpoP1ZjOsbXi3a().getStringList("Moderation.list." + str + ".icon.lore"), this.v8qP8fE86HMhvNuYPFjqY.getFiles().IO1OGSMpoP1ZjOsbXi3a().getString("Moderation.list." + str + ".icon.texture"), new NbtData(Arrays.asList(new String[0]), this.v8qP8fE86HMhvNuYPFjqY.getFiles().IO1OGSMpoP1ZjOsbXi3a().getInt("Moderation.list." + str + ".icon.model")), this.v8qP8fE86HMhvNuYPFjqY.getFiles().IO1OGSMpoP1ZjOsbXi3a().getInt("Moderation.list." + str + ".icon.slot"), null, Arrays.asList(new String[0]), Arrays.asList(new String[0]));
                    }
                } catch (Exception e3) {
                }
                zJnaNCVQSgEShq().put(str, new ModerationData(str, this.v8qP8fE86HMhvNuYPFjqY.getFiles().IO1OGSMpoP1ZjOsbXi3a().getString("Moderation.list." + str + ".name"), this.v8qP8fE86HMhvNuYPFjqY.getFiles().IO1OGSMpoP1ZjOsbXi3a().getInt("Moderation.list." + str + ".priority"), map, this.v8qP8fE86HMhvNuYPFjqY.getFiles().IO1OGSMpoP1ZjOsbXi3a().getBoolean("Moderation.list." + str + ".editable"), this.v8qP8fE86HMhvNuYPFjqY.getFiles().IO1OGSMpoP1ZjOsbXi3a().getBoolean("Moderation.list." + str + ".upgradable"), guiItemsData, Optional.empty()));
            } catch (Exception e4) {
                this.v8qP8fE86HMhvNuYPFjqY.getLogger().warning("Moderation '" + str + "' cannot be loaded because it contains errors.");
            }
        }
    }

    public String v8qP8fE86HMhvNuYPFjqY(String str) {
        return this.v8qP8fE86HMhvNuYPFjqY.getFiles().IO1OGSMpoP1ZjOsbXi3a().contains("Moderation.permissions." + str + ".name") ? this.v8qP8fE86HMhvNuYPFjqY.getFiles().IO1OGSMpoP1ZjOsbXi3a().getString("Moderation.permissions." + str + ".name").replace(" ", zauJ0BI0KM1t5g()) : str;
    }

    public Optional<ModerationData> jBUuLP0sWwaPyPOmogdX7l() {
        try {
            if (zJnaNCVQSgEShq().containsKey(ShFSh7We6OtLNVd())) {
                return Optional.of(zJnaNCVQSgEShq().get(z81AnUietYbRMPzgaxm()));
            }
        } catch (Exception e) {
        }
        return Optional.empty();
    }

    public Optional<ModerationData> ZwrsrwOCXRUscW6Q() {
        return zJnaNCVQSgEShq().values().stream().min(Comparator.comparingInt((v0) -> {
            return v0.getPriority();
        }));
    }

    public Optional<ModerationData> iZTqZaRK5UGoe0Z() {
        try {
            if (zJnaNCVQSgEShq().size() > 0) {
                LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>();
                zJnaNCVQSgEShq().entrySet().iterator().forEachRemaining(entry -> {
                    linkedHashMap.put(((ModerationData) entry.getValue()).getId(), Integer.valueOf(((ModerationData) entry.getValue()).getPriority()));
                });
                ModerationData moderationData = zJnaNCVQSgEShq().get((String) ((Map.Entry) ((Map) linkedHashMap.entrySet().stream().sorted(Map.Entry.comparingByValue()).collect(Collectors.toMap((v0) -> {
                    return v0.getKey();
                }, (v0) -> {
                    return v0.getValue();
                }, (num, num2) -> {
                    return num2;
                }, LinkedHashMap::new))).entrySet().iterator().next()).getKey());
                if (moderationData != null) {
                    return Optional.of(moderationData);
                }
            }
        } catch (Exception e) {
        }
        return Optional.empty();
    }

    public HashMap<String, HashMap<String, Boolean>> ZwrsrwOCXRUscW6Q(UUID uuid) {
        return CDW4Fj1iwdIXEOqWjiJSR().containsKey(uuid) ? CDW4Fj1iwdIXEOqWjiJSR().get(uuid) : iZTqZaRK5UGoe0Z(uuid);
    }

    public HashMap<String, HashMap<String, Boolean>> iZTqZaRK5UGoe0Z(UUID uuid) {
        HashMap<String, HashMap<String, Boolean>> map = new HashMap<>();
        if (CDW4Fj1iwdIXEOqWjiJSR().containsKey(uuid)) {
            map = CDW4Fj1iwdIXEOqWjiJSR().get(uuid);
        }
        HashMap<String, HashMap<String, Boolean>> map2 = new HashMap<>();
        int i = 0;
        for (Map.Entry<String, ModerationData> entry : zJnaNCVQSgEShq().entrySet()) {
            HashMap<String, Boolean> map3 = new HashMap<>();
            for (Map.Entry<String, Boolean> entry2 : entry.getValue().getPermissionList().entrySet()) {
                if (!entry2.getKey().equalsIgnoreCase(o7Hkxsivho7FtT9qQAkEV())) {
                    if (map.containsKey(entry.getValue().getId())) {
                        HashMap<String, Boolean> map4 = map.get(entry.getValue().getId());
                        if (map4.containsKey(entry2.getKey())) {
                            map3.put(entry2.getKey(), map4.get(entry2.getKey()));
                        }
                    }
                    map3.put(entry2.getKey(), entry2.getValue());
                    i++;
                }
            }
            map2.put(entry.getValue().getId(), map3);
        }
        if (i > 0) {
            CDW4Fj1iwdIXEOqWjiJSR().put(uuid, map2);
            v8qP8fE86HMhvNuYPFjqY(uuid, map2);
        }
        return map2;
    }

    public HashMap<String, HashMap<String, Boolean>> xtOheRiObl4QeAl(UUID uuid) {
        HashMap<String, HashMap<String, Boolean>> map = new HashMap<>();
        for (Map.Entry<String, ModerationData> entry : zJnaNCVQSgEShq().entrySet()) {
            HashMap<String, Boolean> map2 = new HashMap<>();
            for (Map.Entry<String, Boolean> entry2 : entry.getValue().getPermissionList().entrySet()) {
                if (!entry2.getKey().equalsIgnoreCase(w0OxosnfWPfsvnf())) {
                    map2.put(entry2.getKey(), entry2.getValue());
                }
            }
            map.put(entry.getValue().getId(), map2);
        }
        CDW4Fj1iwdIXEOqWjiJSR().put(uuid, map);
        v8qP8fE86HMhvNuYPFjqY(uuid, map);
        return map;
    }

    public HashMap<String, Boolean> zJnaNCVQSgEShq(UUID uuid) {
        HashMap<String, Boolean> map = new HashMap<>();
        if (!this.v8qP8fE86HMhvNuYPFjqY.getPlayerManager().zJnaNCVQSgEShq(uuid)) {
            return map;
        }
        Optional<ClanData> optionalCDW4Fj1iwdIXEOqWjiJSR = this.v8qP8fE86HMhvNuYPFjqY.getPlayerManager().CDW4Fj1iwdIXEOqWjiJSR(uuid);
        if (!optionalCDW4Fj1iwdIXEOqWjiJSR.isPresent()) {
            return map;
        }
        HashMap<String, Boolean> map2 = new HashMap<>();
        zJnaNCVQSgEShq().values().forEach(moderationData -> {
            if (moderationData.getPermissionList() != null) {
                map2.putAll(moderationData.getPermissionList());
            }
        });
        HashMap<String, HashMap<String, Boolean>> mapZwrsrwOCXRUscW6Q = ZwrsrwOCXRUscW6Q(optionalCDW4Fj1iwdIXEOqWjiJSR.get().getId());
        if (mapZwrsrwOCXRUscW6Q != null) {
            mapZwrsrwOCXRUscW6Q.values().forEach(map3 -> {
                if (map3 != null) {
                    map2.putAll(map3);
                }
            });
        }
        for (String str : map2.keySet()) {
            if (!str.equalsIgnoreCase(huqNEh6IL7xkozhy())) {
                map.put(str, Boolean.valueOf(v8qP8fE86HMhvNuYPFjqY(uuid, str)));
            }
        }
        return map;
    }

    public HashMap<String, Boolean> CDW4Fj1iwdIXEOqWjiJSR(UUID uuid) {
        Player player;
        HashMap<String, Boolean> map = new HashMap<>();
        if (!this.v8qP8fE86HMhvNuYPFjqY.getPlayerManager().zJnaNCVQSgEShq(uuid)) {
            return map;
        }
        Optional<ModerationData> optionalB4i2FbOkaKeg91LiAe6l = b4i2FbOkaKeg91LiAe6l(uuid);
        String string = this.v8qP8fE86HMhvNuYPFjqY.getFiles().p31abtwfBag2jhMH6K().getString(AyN1dJuTkKnaarRZwG());
        if (string != null && !string.isEmpty() && (player = Bukkit.getPlayer(uuid)) != null && player.isOnline() && player.hasPermission(string)) {
            optionalB4i2FbOkaKeg91LiAe6l = jBUuLP0sWwaPyPOmogdX7l();
        }
        if (this.v8qP8fE86HMhvNuYPFjqY.getPlayerManager().vVo2VUvxrriklPdRxI(uuid)) {
            optionalB4i2FbOkaKeg91LiAe6l = jBUuLP0sWwaPyPOmogdX7l();
        }
        if (!optionalB4i2FbOkaKeg91LiAe6l.isPresent()) {
            return map;
        }
        Optional<ClanData> optionalCDW4Fj1iwdIXEOqWjiJSR = this.v8qP8fE86HMhvNuYPFjqY.getPlayerManager().CDW4Fj1iwdIXEOqWjiJSR(uuid);
        if (!optionalCDW4Fj1iwdIXEOqWjiJSR.isPresent()) {
            return map;
        }
        HashMap<String, HashMap<String, Boolean>> map2 = CDW4Fj1iwdIXEOqWjiJSR().get(optionalCDW4Fj1iwdIXEOqWjiJSR.get().getId());
        if (map2 == null) {
            return map;
        }
        Iterator<Map.Entry<String, HashMap<String, Boolean>>> it = map2.entrySet().iterator();
        while (it.hasNext()) {
            HashMap<String, Boolean> value = it.next().getValue();
            if (value != null) {
                map.putAll(value);
            }
        }
        return map;
    }

    public boolean v8qP8fE86HMhvNuYPFjqY(UUID uuid, String str) {
        String strV8qP8fE86HMhvNuYPFjqY = v8qP8fE86HMhvNuYPFjqY(str);
        if (!this.v8qP8fE86HMhvNuYPFjqY.getPlayerManager().zJnaNCVQSgEShq(uuid)) {
            return false;
        }
        if (this.v8qP8fE86HMhvNuYPFjqY.getPlayerManager().vVo2VUvxrriklPdRxI(uuid)) {
            return true;
        }
        if (!this.v8qP8fE86HMhvNuYPFjqY.getFiles().p31abtwfBag2jhMH6K().getString(LJxZIxgrxpMQLx()).isEmpty()) {
            Player player = null;
            try {
                player = Bukkit.getPlayer(uuid);
            } catch (Exception e) {
            }
            if (player != null && player.isOnline() && player.hasPermission(this.v8qP8fE86HMhvNuYPFjqY.getFiles().p31abtwfBag2jhMH6K().getString(ynostSwA4VkfqPPnzZ()))) {
                return true;
            }
        }
        Optional<ModerationData> optionalB4i2FbOkaKeg91LiAe6l = b4i2FbOkaKeg91LiAe6l(uuid);
        if (!optionalB4i2FbOkaKeg91LiAe6l.isPresent()) {
            return false;
        }
        Optional<ClanData> optionalCDW4Fj1iwdIXEOqWjiJSR = this.v8qP8fE86HMhvNuYPFjqY.getPlayerManager().CDW4Fj1iwdIXEOqWjiJSR(uuid);
        if (!optionalCDW4Fj1iwdIXEOqWjiJSR.isPresent()) {
            return false;
        }
        if (CDW4Fj1iwdIXEOqWjiJSR().containsKey(optionalCDW4Fj1iwdIXEOqWjiJSR.get().getId())) {
            HashMap<String, HashMap<String, Boolean>> map = CDW4Fj1iwdIXEOqWjiJSR().get(optionalCDW4Fj1iwdIXEOqWjiJSR.get().getId());
            if (map.containsKey(optionalB4i2FbOkaKeg91LiAe6l.get().getId()) && map.get(optionalB4i2FbOkaKeg91LiAe6l.get().getId()).containsKey(strV8qP8fE86HMhvNuYPFjqY)) {
                return map.get(optionalB4i2FbOkaKeg91LiAe6l.get().getId()).get(strV8qP8fE86HMhvNuYPFjqY).booleanValue();
            }
            return false;
        }
        HashMap<String, HashMap<String, Boolean>> mapZwrsrwOCXRUscW6Q = ZwrsrwOCXRUscW6Q(optionalCDW4Fj1iwdIXEOqWjiJSR.get().getId());
        if (mapZwrsrwOCXRUscW6Q.containsKey(optionalB4i2FbOkaKeg91LiAe6l.get().getId()) && mapZwrsrwOCXRUscW6Q.get(optionalB4i2FbOkaKeg91LiAe6l.get().getId()).containsKey(strV8qP8fE86HMhvNuYPFjqY)) {
            return mapZwrsrwOCXRUscW6Q.get(optionalB4i2FbOkaKeg91LiAe6l.get().getId()).get(strV8qP8fE86HMhvNuYPFjqY).booleanValue();
        }
        return false;
    }

    public Optional<ModerationData> v8qP8fE86HMhvNuYPFjqY(String str, boolean z) {
        Optional<ModerationData> optionalFindAny = zJnaNCVQSgEShq().values().stream().filter(moderationData -> {
            return moderationData.getId().equals(str) && (!z ? !(moderationData.isUpgradable() || !moderationData.isUpgradable()) : !moderationData.isUpgradable());
        }).findAny();
        return optionalFindAny.isPresent() ? optionalFindAny : ZwrsrwOCXRUscW6Q();
    }

    public List<String> jBUuLP0sWwaPyPOmogdX7l(boolean z) {
        ArrayList arrayList = new ArrayList();
        zJnaNCVQSgEShq().entrySet().iterator().forEachRemaining(entry -> {
            if (z && ((ModerationData) entry.getValue()).isUpgradable()) {
                arrayList.add(((ModerationData) entry.getValue()).getId());
            } else {
                if (z) {
                    return;
                }
                arrayList.add(((ModerationData) entry.getValue()).getId());
            }
        });
        return arrayList;
    }

    public List<String> v8qP8fE86HMhvNuYPFjqY(boolean z, int i) {
        ArrayList arrayList = new ArrayList();
        zJnaNCVQSgEShq().entrySet().iterator().forEachRemaining(entry -> {
            if (z && ((ModerationData) entry.getValue()).isUpgradable() && ((ModerationData) entry.getValue()).getPriority() > i) {
                arrayList.add(((ModerationData) entry.getValue()).getId());
            } else {
                if (z) {
                    return;
                }
                arrayList.add(((ModerationData) entry.getValue()).getId());
            }
        });
        return arrayList;
    }

    public List<String> jBUuLP0sWwaPyPOmogdX7l(boolean z, int i) {
        ArrayList arrayList = new ArrayList();
        zJnaNCVQSgEShq().entrySet().iterator().forEachRemaining(entry -> {
            if (z && ((ModerationData) entry.getValue()).isUpgradable() && ((ModerationData) entry.getValue()).getPriority() < i) {
                arrayList.add(((ModerationData) entry.getValue()).getId());
            } else {
                if (z) {
                    return;
                }
                arrayList.add(((ModerationData) entry.getValue()).getId());
            }
        });
        return arrayList;
    }

    public Optional<ModerationData> b4i2FbOkaKeg91LiAe6l(UUID uuid) {
        if (this.v8qP8fE86HMhvNuYPFjqY.getPlayerManager().zJnaNCVQSgEShq(uuid)) {
            if (this.v8qP8fE86HMhvNuYPFjqY.getPlayerManager().vVo2VUvxrriklPdRxI(uuid)) {
                return jBUuLP0sWwaPyPOmogdX7l();
            }
            Optional<PlayerData> optionalP31abtwfBag2jhMH6K = this.v8qP8fE86HMhvNuYPFjqY.getPlayerManager().p31abtwfBag2jhMH6K(uuid);
            if (optionalP31abtwfBag2jhMH6K.isPresent() && zJnaNCVQSgEShq().containsKey(optionalP31abtwfBag2jhMH6K.get().getRole())) {
                return Optional.of(zJnaNCVQSgEShq().get(optionalP31abtwfBag2jhMH6K.get().getRole()));
            }
        }
        return ZwrsrwOCXRUscW6Q();
    }

    public Optional<ModerationData> v8qP8fE86HMhvNuYPFjqY(UUID uuid, boolean z) {
        if (!this.v8qP8fE86HMhvNuYPFjqY.getPlayerManager().zJnaNCVQSgEShq(uuid)) {
            return ZwrsrwOCXRUscW6Q();
        }
        if (this.v8qP8fE86HMhvNuYPFjqY.getPlayerManager().vVo2VUvxrriklPdRxI(uuid)) {
            return jBUuLP0sWwaPyPOmogdX7l();
        }
        Optional<ModerationData> optionalB4i2FbOkaKeg91LiAe6l = b4i2FbOkaKeg91LiAe6l(uuid);
        HashMap<String, ModerationData> mapZJnaNCVQSgEShq = zJnaNCVQSgEShq();
        if (optionalB4i2FbOkaKeg91LiAe6l.isEmpty() || mapZJnaNCVQSgEShq.isEmpty()) {
            return ZwrsrwOCXRUscW6Q();
        }
        List list = (List) mapZJnaNCVQSgEShq.values().stream().sorted(Comparator.comparingInt((v0) -> {
            return v0.getPriority();
        })).collect(Collectors.toList());
        int i = -1;
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (((ModerationData) list.get(i2)).getId().equals(optionalB4i2FbOkaKeg91LiAe6l.get().getId())) {
                i = i2;
                break;
            }
        }
        if (i == -1) {
            return ZwrsrwOCXRUscW6Q();
        }
        int i3 = z ? 1 : -1;
        int i4 = i;
        while (true) {
            int i5 = i4 + i3;
            if (i5 < 0 || i5 >= list.size()) {
                break;
            }
            ModerationData moderationData = (ModerationData) list.get(i5);
            if (moderationData.isUpgradable()) {
                return Optional.of(moderationData);
            }
            i4 = i5;
        }
        return optionalB4i2FbOkaKeg91LiAe6l;
    }

    public Optional<ModerationData> jBUuLP0sWwaPyPOmogdX7l(UUID uuid, boolean z) {
        if (!this.v8qP8fE86HMhvNuYPFjqY.getPlayerManager().zJnaNCVQSgEShq(uuid)) {
            return ZwrsrwOCXRUscW6Q();
        }
        if (this.v8qP8fE86HMhvNuYPFjqY.getPlayerManager().vVo2VUvxrriklPdRxI(uuid)) {
            return jBUuLP0sWwaPyPOmogdX7l();
        }
        Optional<ModerationData> optionalB4i2FbOkaKeg91LiAe6l = b4i2FbOkaKeg91LiAe6l(uuid);
        if (!optionalB4i2FbOkaKeg91LiAe6l.isPresent() || zJnaNCVQSgEShq().isEmpty()) {
            return ZwrsrwOCXRUscW6Q();
        }
        List list = (List) zJnaNCVQSgEShq().values().stream().sorted(Comparator.comparingInt((v0) -> {
            return v0.getPriority();
        })).collect(Collectors.toList());
        for (int i = 0; i < list.size(); i++) {
            if (((ModerationData) list.get(i)).getId().equals(optionalB4i2FbOkaKeg91LiAe6l.get().getId())) {
                int i2 = z ? i + 1 : i - 1;
                if (i2 < 0 || i2 >= list.size()) {
                    break;
                }
                ModerationData moderationData = (ModerationData) list.get(i2);
                if (!moderationData.isUpgradable()) {
                    break;
                }
                return Optional.of(moderationData);
            }
        }
        return Optional.of(optionalB4i2FbOkaKeg91LiAe6l.get());
    }

    public Optional<ModerationData> p31abtwfBag2jhMH6K(UUID uuid) {
        return v8qP8fE86HMhvNuYPFjqY(uuid, true);
    }

    public Optional<ModerationData> Un3NRLL6aWivTcbodkcK(UUID uuid) {
        return v8qP8fE86HMhvNuYPFjqY(uuid, false);
    }

    public Map<UUID, Integer> ZwrsrwOCXRUscW6Q(UUID uuid, boolean z) {
        LinkedHashMap<UUID, Integer> linkedHashMap = new LinkedHashMap<>();
        if (uuid == null) {
            return linkedHashMap;
        }
        Optional<ClanData> optionalIZTqZaRK5UGoe0Z = xtOheRiObl4QeAl().getClanManager().iZTqZaRK5UGoe0Z(uuid);
        if (!optionalIZTqZaRK5UGoe0Z.isPresent()) {
            return linkedHashMap;
        }
        ClanData clanData = optionalIZTqZaRK5UGoe0Z.get();
        HashMap<UUID, Integer> map = new HashMap<>();
        for (UUID uuid2 : clanData.getMembers()) {
            if (z || !xtOheRiObl4QeAl().getPlayerManager().lGGwXL678c4Kv7skJb5NiE(uuid2, uuid)) {
                Optional<ModerationData> optionalB4i2FbOkaKeg91LiAe6l = xtOheRiObl4QeAl().getModerationManager().b4i2FbOkaKeg91LiAe6l(uuid2);
                if (optionalB4i2FbOkaKeg91LiAe6l.isPresent()) {
                    map.put(uuid2, Integer.valueOf(optionalB4i2FbOkaKeg91LiAe6l.get().getPriority()));
                }
            }
        }
        map.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).forEach(entry -> {
            linkedHashMap.put((UUID) entry.getKey(), (Integer) entry.getValue());
        });
        return linkedHashMap;
    }

    public boolean v8qP8fE86HMhvNuYPFjqY(UUID uuid, String str, String str2, Boolean bool) {
        if (CDW4Fj1iwdIXEOqWjiJSR().containsKey(uuid)) {
            CDW4Fj1iwdIXEOqWjiJSR().get(uuid).get(str).put(str2, bool);
            v8qP8fE86HMhvNuYPFjqY(uuid, CDW4Fj1iwdIXEOqWjiJSR().get(uuid));
            return true;
        }
        HashMap<String, Boolean> map = new HashMap<>();
        map.put(str2, bool);
        HashMap<String, HashMap<String, Boolean>> map2 = new HashMap<>();
        map2.put(str, map);
        CDW4Fj1iwdIXEOqWjiJSR().put(uuid, map2);
        return false;
    }

    public void lGGwXL678c4Kv7skJb5NiE(UUID uuid) {
        if (CDW4Fj1iwdIXEOqWjiJSR().containsKey(uuid)) {
            CDW4Fj1iwdIXEOqWjiJSR().remove(uuid);
            v8qP8fE86HMhvNuYPFjqY(uuid);
        }
    }

    public HashMap<String, HashMap<String, Boolean>> v8qP8fE86HMhvNuYPFjqY(HashMap<String, HashMap<String, Boolean>> map) {
        HashMap<String, HashMap<String, Boolean>> map2 = new HashMap<>();
        for (Map.Entry<String, ModerationData> entry : this.v8qP8fE86HMhvNuYPFjqY.getModerationManager().zJnaNCVQSgEShq().entrySet()) {
            HashMap<String, Boolean> map3 = new HashMap<>();
            if (map.containsKey(entry.getValue().getId())) {
                for (Map.Entry<String, Boolean> entry2 : map.get(entry.getValue().getId()).entrySet()) {
                    if (entry.getValue().getPermissionList().containsKey(entry2.getKey())) {
                        map3.put(entry2.getKey(), entry2.getValue());
                    } else {
                        map3.putAll(entry.getValue().getPermissionList());
                    }
                }
            } else {
                map3.putAll(entry.getValue().getPermissionList());
            }
            map2.put(entry.getValue().getId(), map3);
        }
        return map2;
    }

    public boolean v8qP8fE86HMhvNuYPFjqY(UUID uuid, UUID uuid2) {
        if (!this.v8qP8fE86HMhvNuYPFjqY.getFiles().IO1OGSMpoP1ZjOsbXi3a().getBoolean(KiK8spR8MOonGDeU2Dvqk()) || !this.v8qP8fE86HMhvNuYPFjqY.getPlayerManager().v8qP8fE86HMhvNuYPFjqY(uuid, uuid2)) {
            return false;
        }
        Optional<ModerationData> optionalB4i2FbOkaKeg91LiAe6l = b4i2FbOkaKeg91LiAe6l(uuid);
        Optional<ModerationData> optionalB4i2FbOkaKeg91LiAe6l2 = b4i2FbOkaKeg91LiAe6l(uuid2);
        return optionalB4i2FbOkaKeg91LiAe6l.isPresent() && optionalB4i2FbOkaKeg91LiAe6l2.isPresent() && optionalB4i2FbOkaKeg91LiAe6l.get().getPriority() < optionalB4i2FbOkaKeg91LiAe6l2.get().getPriority();
    }

    public boolean jBUuLP0sWwaPyPOmogdX7l(UUID uuid, UUID uuid2) {
        if (!this.v8qP8fE86HMhvNuYPFjqY.getFiles().IO1OGSMpoP1ZjOsbXi3a().getBoolean(XI36zJwQWn4QEG3h9a8OEq()) || !this.v8qP8fE86HMhvNuYPFjqY.getPlayerManager().v8qP8fE86HMhvNuYPFjqY(uuid, uuid2)) {
            return false;
        }
        Optional<ModerationData> optionalB4i2FbOkaKeg91LiAe6l = b4i2FbOkaKeg91LiAe6l(uuid);
        Optional<ModerationData> optionalB4i2FbOkaKeg91LiAe6l2 = b4i2FbOkaKeg91LiAe6l(uuid2);
        return optionalB4i2FbOkaKeg91LiAe6l.isPresent() && optionalB4i2FbOkaKeg91LiAe6l2.isPresent() && optionalB4i2FbOkaKeg91LiAe6l.get().getPriority() > optionalB4i2FbOkaKeg91LiAe6l2.get().getPriority();
    }

    public Clans xtOheRiObl4QeAl() {
        return this.v8qP8fE86HMhvNuYPFjqY;
    }

    public HashMap<String, ModerationData> zJnaNCVQSgEShq() {
        return this.jBUuLP0sWwaPyPOmogdX7l;
    }

    public void jBUuLP0sWwaPyPOmogdX7l(HashMap<String, ModerationData> map) {
        this.jBUuLP0sWwaPyPOmogdX7l = map;
    }

    public HashMap<UUID, HashMap<String, HashMap<String, Boolean>>> CDW4Fj1iwdIXEOqWjiJSR() {
        return this.ZwrsrwOCXRUscW6Q;
    }

    public void ZwrsrwOCXRUscW6Q(HashMap<UUID, HashMap<String, HashMap<String, Boolean>>> map) {
        this.ZwrsrwOCXRUscW6Q = map;
    }

    private static String xqJxYn5mksConLZJrW(byte[] bArr) {
        return "";
    }

    private static String IZSjnv4IyGiswPpUL9() {
        return "Moderation.list";
    }

    private static String cQyY6yRuDh96Hh1zP() {
        return ":";
    }

    private static String OPC5MNwsEOOU06hSdcMsN() {
        return ":";
    }

    private static String zauJ0BI0KM1t5g() {
        return "-";
    }

    private static String ShFSh7We6OtLNVd() {
        return "leader";
    }

    private static String z81AnUietYbRMPzgaxm() {
        return "leader";
    }

    private static String o7Hkxsivho7FtT9qQAkEV() {
        return "default";
    }

    private static String w0OxosnfWPfsvnf() {
        return "default";
    }

    private static String huqNEh6IL7xkozhy() {
        return "default";
    }

    private static String AyN1dJuTkKnaarRZwG() {
        return "Config.special_permissions.bypass_leader";
    }

    private static String LJxZIxgrxpMQLx() {
        return "Config.special_permissions.bypass_leader";
    }

    private static String ynostSwA4VkfqPPnzZ() {
        return "Config.special_permissions.bypass_leader";
    }

    private static String KiK8spR8MOonGDeU2Dvqk() {
        return "Moderation.disable_actions_higher_roles";
    }

    private static String XI36zJwQWn4QEG3h9a8OEq() {
        return "Moderation.disable_actions_higher_roles";
    }
}
