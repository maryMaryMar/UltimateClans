package me.module.levelup.manager.b;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import me.module.levelup.Levelup;
import me.ulrich.clans.data.ClanData;
import me.ulrich.clans.interfaces.MoneyImplement;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Levelup.jar:me/module/levelup/manager/b/a.class */
public class a {
    private static byte[] __aes_key_htWS5mkM = {(byte) 86, (byte) 249, (byte) 184, (byte) 152, (byte) 79, (byte) 111, (byte) 183, (byte) 87, (byte) 167, (byte) 144, (byte) 108, (byte) 109, (byte) 100, (byte) 105, (byte) 37, (byte) 45, (byte) 51, (byte) 157, (byte) 236, (byte) 239, (byte) 11, (byte) 66, (byte) 20, (byte) 199, (byte) 232, (byte) 212, (byte) 246, (byte) 215, (byte) 254, (byte) 9, (byte) 115, (byte) 219};
    private static byte[] __aes_iv_V5H5MB9e = {(byte) 17, (byte) 18, (byte) 197, (byte) 5, (byte) 14, (byte) 104, (byte) 62, (byte) 47, (byte) 143, (byte) 1, (byte) 236, (byte) 12, (byte) 218, (byte) 245, (byte) 129, (byte) 110};
    private static String __s_cache_69L9KlGX_0;
    private static String __s_cache_WIBNmXbE_1;
    private static String __s_cache_OjDacrxa_2;
    private static String __s_cache_Ejw2psKU_3;
    private static String __s_cache_fYJXIwY5_4;
    private static String __s_cache_jfeHJMda_5;
    private static String __s_cache_WaSDHqPa_6;
    private static String __s_cache_t6v7gKR4_7;
    private static String __s_cache_H7joaJ6y_8;
    private static String __s_cache_a8h4SgQz_9;
    private static String __s_cache_Ofi56Nlw_10;
    private static String __s_cache_MikvNHu0_11;
    private static String __s_cache_MzIryTgQ_12;
    private static String __s_cache_CKHf76YD_13;
    private static String __s_cache_AapFk9MT_14;
    private static String __s_cache_zPERF2y6_15;
    private static String __s_cache_9zyBtAJp_16;
    private static String __s_cache_stRvI2fG_17;

    public boolean a(UUID uuid, List<String> list) {
        Player player = Bukkit.getPlayer(uuid);
        if (player == null) {
            return false;
        }
        if (list == null || list.isEmpty()) {
            return true;
        }
        if (!a(player, list)) {
            return false;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (!b(player, it.next())) {
                return false;
            }
        }
        return true;
    }

    private boolean a(Player player, List<String> list) {
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (!a(player, it.next())) {
                return false;
            }
        }
        return true;
    }

    private boolean a(Player player, String str) {
        if (str == null) {
            return false;
        }
        String strTrim = str.trim();
        if (strTrim.startsWith("bank=")) {
            double dA = a(strTrim, "bank=");
            return a(dA) && b(player, dA);
        }
        if (strTrim.startsWith("money=")) {
            double dA2 = a(strTrim, "money=");
            return a(dA2) && a(player, dA2);
        }
        if (strTrim.startsWith("exp=")) {
            double dA3 = a(strTrim, "exp=");
            return a(dA3) && a(player, (int) dA3);
        }
        if (strTrim.startsWith("item=")) {
            return c(player, strTrim.replace("item=", "").trim());
        }
        return false;
    }

    private boolean b(Player player, String str) {
        String strTrim = str.trim();
        if (strTrim.startsWith("bank=")) {
            return c(player, a(strTrim, "bank="));
        }
        if (strTrim.startsWith("money=")) {
            return d(player, a(strTrim, "money="));
        }
        if (strTrim.startsWith("exp=")) {
            return b(player, (int) a(strTrim, "exp="));
        }
        if (strTrim.startsWith("item=")) {
            return d(player, strTrim.replace("item=", "").trim());
        }
        return false;
    }

    private boolean a(Player player, int i) {
        return i >= 0 && player.getLevel() >= i;
    }

    private boolean a(Player player, double d) {
        Optional<MoneyImplement> moneyAPI = Levelup.a().getIntegrationAPI().getMoneyAPI();
        return moneyAPI.isPresent() && moneyAPI.get().hasMoney(player, d);
    }

    private boolean b(Player player, double d) {
        Optional<ClanData> playerClan = Levelup.a().getPlayerAPI().getPlayerClan(player.getUniqueId());
        return playerClan.isPresent() && playerClan.get().getBank().doubleValue() >= d;
    }

    private boolean c(Player player, String str) {
        Map<String, Integer> mapA = a(str);
        if (mapA.isEmpty()) {
            return false;
        }
        for (Map.Entry<String, Integer> entry : mapA.entrySet()) {
            Material materialMatchMaterial = Material.matchMaterial(entry.getKey());
            if (materialMatchMaterial == null || !a(player, materialMatchMaterial, entry.getValue().intValue())) {
                return false;
            }
        }
        return true;
    }

    private boolean c(Player player, double d) {
        if (!a(d)) {
            return false;
        }
        Optional<ClanData> playerClan = Levelup.a().getPlayerAPI().getPlayerClan(player.getUniqueId());
        if (!playerClan.isPresent() || playerClan.get().getBank().doubleValue() < d) {
            return false;
        }
        playerClan.get().setBank(Double.valueOf(playerClan.get().getBank().doubleValue() - d));
        Levelup.a().getClanAPI().saveClanData(playerClan.get());
        return true;
    }

    private boolean d(Player player, double d) {
        if (!a(d)) {
            return false;
        }
        Optional<MoneyImplement> moneyAPI = Levelup.a().getIntegrationAPI().getMoneyAPI();
        return moneyAPI.isPresent() && moneyAPI.get().withdrawMoney(player, d);
    }

    private boolean b(Player player, int i) {
        if (i < 0 || player.getLevel() < i) {
            return false;
        }
        player.setLevel(player.getLevel() - i);
        return true;
    }

    private boolean d(Player player, String str) {
        Map<String, Integer> mapA = a(str);
        if (mapA.isEmpty()) {
            return false;
        }
        for (Map.Entry<String, Integer> entry : mapA.entrySet()) {
            Material materialMatchMaterial = Material.matchMaterial(entry.getKey());
            if (materialMatchMaterial == null || !a(player, materialMatchMaterial, entry.getValue().intValue())) {
                return false;
            }
        }
        for (Map.Entry<String, Integer> entry2 : mapA.entrySet()) {
            Material materialMatchMaterial2 = Material.matchMaterial(entry2.getKey());
            if (materialMatchMaterial2 == null || !b(player, materialMatchMaterial2, entry2.getValue().intValue())) {
                return false;
            }
        }
        return true;
    }

    private double a(String str, String str2) {
        try {
            return Double.parseDouble(c.a(str.substring(str2.length()).trim()));
        } catch (Exception e) {
            return Double.NaN;
        }
    }

    private boolean a(double d) {
        return Double.isFinite(d) && d >= 0.0d;
    }

    private Map<String, Integer> a(String str) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (str == null || str.trim().isEmpty()) {
            return linkedHashMap;
        }
        for (String str2 : str.split(",")) {
            String[] strArrSplit = str2.trim().split(":", 2);
            if (strArrSplit.length == 2) {
                try {
                    int i = Integer.parseInt(strArrSplit[1].trim());
                    if (i > 0) {
                        linkedHashMap.merge(strArrSplit[0].trim().toUpperCase(), Integer.valueOf(i), (v0, v1) -> {
                            return Integer.sum(v0, v1);
                        });
                    }
                } catch (NumberFormatException e) {
                }
            }
        }
        return linkedHashMap;
    }

    private boolean a(Player player, Material material, int i) {
        int amount = 0;
        for (ItemStack itemStack : player.getInventory().getContents()) {
            if (itemStack != null && itemStack.getType() == material) {
                amount += itemStack.getAmount();
                if (amount >= i) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean b(Player player, Material material, int i) {
        ItemStack[] contents = player.getInventory().getContents();
        int i2 = i;
        for (int i3 = 0; i3 < contents.length && i2 > 0; i3++) {
            ItemStack itemStack = contents[i3];
            if (itemStack != null && itemStack.getType() == material) {
                int amount = itemStack.getAmount();
                if (amount > i2) {
                    itemStack.setAmount(amount - i2);
                    i2 = 0;
                } else {
                    player.getInventory().setItem(i3, (ItemStack) null);
                    i2 -= amount;
                }
            }
        }
        return i2 == 0;
    }

    private static String __unused_997() {
        return "bank=";
    }

    private static String __unused_998() {
        return "bank=";
    }

    private static String __unused_999() {
        return "money=";
    }

    private static String __unused_1000() {
        return "money=";
    }

    private static String __unused_1001() {
        return "exp=";
    }

    private static String __unused_1002() {
        return "exp=";
    }

    private static String __unused_1003() {
        return "item=";
    }

    private static String __unused_1004() {
        return "item=";
    }

    private static String __unused_1005() {
        return "bank=";
    }

    private static String __unused_1006() {
        return "bank=";
    }

    private static String __unused_1007() {
        return "money=";
    }

    private static String __unused_1008() {
        return "money=";
    }

    private static String __unused_1009() {
        return "exp=";
    }

    private static String __unused_1010() {
        return "exp=";
    }

    private static String __unused_1011() {
        return "item=";
    }

    private static String __unused_1012() {
        return "item=";
    }

    private static String __unused_1013() {
        return ",";
    }

    private static String __unused_1014() {
        return ":";
    }
}
