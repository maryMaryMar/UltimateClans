package me.ulrich.clans.manager;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import me.ulrich.clans.Clans;
import me.ulrich.clans.data.ClanEnum;
import me.ulrich.clans.data.CommandData;
import me.ulrich.clans.data.CommandData_actionbar;
import me.ulrich.clans.data.CommandData_disable;
import me.ulrich.clans.data.CommandData_show;
import me.ulrich.clans.data.CommandData_sound;
import me.ulrich.clans.data.CommandData_title;
import me.ulrich.clans.interfaces.ClansCommand;
import me.ulrich.clans.library.kyori.adventure.key.Key;
import me.ulrich.clans.library.kyori.adventure.platform.bukkit.BukkitAudiences;
import me.ulrich.clans.library.kyori.adventure.sound.Sound;
import me.ulrich.clans.manager.DTKXb4fQF6nDgxzg.tjCyMSV004ze7Mc.DTKXb4fQF6nDgxzg.ECMfR2SxjZy2nLBVbPf;
import me.ulrich.clans.manager.utils.CooldownAPI;
import me.ulrich.clans.manager.utils.VersionUtil;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/manager/DJJU8UefX5VWXi.class */
public class DJJU8UefX5VWXi {
    private final Clans v8qP8fE86HMhvNuYPFjqY;
    private String jBUuLP0sWwaPyPOmogdX7l = JMWinWNFIabWPu();
    private static String XuhUT7iXeJFsycpIz8oRYk;
    private static volatile String wdAACZLJVzxQu0o2;
    private static String FbnXInx62tftMYzgJHK;
    private static String fWp99wQf2w6Rg1czgmX;
    private static volatile String XxAv6v0g9qCOklMBA3;
    private static volatile String B84lWERNpzTTHe;
    private static String zbVxcgV5T7EwuyXpW7d;
    private static volatile String jeWkNECK7cEeYYIpneqkSu;
    private static volatile String PJ31o2RLfCeYV0K1;
    private static String FpPCnxmm9Zr4cdIhdFwC;
    private static volatile String w2erahTb8CoAqZ1;
    private static volatile String VatpwsBCDFo8yflMs8DUL;
    private static String aXj3z3fB2ygTkRBc4;
    private static volatile String kDn2jLuwJf4jXfQ;
    private static String BU7rmYTr6RCJXS;
    private static volatile String EhDSDYh8TuNLCPAo4ld;
    private static volatile String QlQilTb3rRRAoswErja8;
    private static volatile String eNCxU3ztxG40SPOoB2;
    private static String tvzfNLmnuUB0jgS2e;
    private static final byte[] b35fBEuNgMFYJHzpMYQvqX = {(byte) 183, (byte) 29, (byte) 168, (byte) 5, (byte) 242, (byte) 97, (byte) 142, (byte) 255, (byte) 125, (byte) 105, (byte) 215, (byte) 11, (byte) 216, (byte) 235, (byte) 71, (byte) 43};
    private static final byte[] OLyGt5So0EsH4v = {(byte) 27, (byte) 189, (byte) 109, (byte) 104, (byte) 85, (byte) 141, (byte) 55, (byte) 252, (byte) 158, (byte) 128, (byte) 51, (byte) 24, (byte) 157, (byte) 173, (byte) 70, (byte) 42, (byte) 180, (byte) 20, (byte) 214, (byte) 49, (byte) 75, (byte) 7, (byte) 20, (byte) 13, (byte) 155, (byte) 252, (byte) 95, (byte) 242, (byte) 25, (byte) 55, (byte) 14, (byte) 189};
    private static final byte[] FJ7Y23EhqkdcKmMTisXG = {(byte) 27, (byte) 189, (byte) 109, (byte) 104, (byte) 85, (byte) 141, (byte) 55, (byte) 252, (byte) 158, (byte) 128, (byte) 51, (byte) 24, (byte) 157, (byte) 173, (byte) 70, (byte) 42, (byte) 89, (byte) 114, (byte) 148, (byte) 243, (byte) 183, (byte) 127, (byte) 62, (byte) 91, (byte) 254, (byte) 244, (byte) 197, (byte) 95, (byte) 153, (byte) 141, (byte) 56, (byte) 227};
    private static final byte[] txZbtEC6CFG855Tkw9soR5 = {(byte) 147, (byte) 79, (byte) 180, (byte) 126, (byte) 129, (byte) 121, (byte) 34, (byte) 55, (byte) 239, (byte) 21, (byte) 230, (byte) 32, (byte) 127, (byte) 1, (byte) 178, (byte) 117, (byte) 88, (byte) 72, (byte) 175, (byte) 58, (byte) 241, (byte) 99, (byte) 157, (byte) 219, (byte) 120, (byte) 102, (byte) 5, (byte) 189, (byte) 231, (byte) 88, (byte) 96, (byte) 206};
    private static final byte[] lZMhopFOc1XmK0ThS = {(byte) 59, (byte) 139, (byte) 58, (byte) 174, (byte) 199, (byte) 174, (byte) 7, (byte) 132, (byte) 175, (byte) 148, (byte) 242, (byte) 232, (byte) 178, (byte) 211, (byte) 181, (byte) 93};
    private static final byte[] RKW7HOkHmMcBtDs55hNdJ2 = {(byte) 12, (byte) 9, (byte) 72, (byte) 245, (byte) 32, (byte) 42, (byte) 218, (byte) 22, (byte) 250, (byte) 119, (byte) 157, (byte) 204, (byte) 138, (byte) 122, (byte) 109, (byte) 6};
    private static final byte[] KgWndoPKwxpBglnbu6SC5 = {(byte) 99, (byte) 54, (byte) 30, (byte) 121, (byte) 25, (byte) 255, (byte) 216, (byte) 197, (byte) 151, (byte) 151, (byte) 113, (byte) 55, (byte) 138, (byte) 2, (byte) 77, (byte) 206};
    private static final byte[] vhO4FbrLZFo4k9lSI7g = {(byte) 12, (byte) 9, (byte) 72, (byte) 245, (byte) 32, (byte) 42, (byte) 218, (byte) 22, (byte) 250, (byte) 119, (byte) 157, (byte) 204, (byte) 138, (byte) 122, (byte) 109, (byte) 6};
    private static final byte[] VgdUUG6lwOwcr7Q0s = {(byte) 32, (byte) 73, (byte) 203, (byte) 153, (byte) 19, (byte) 57, (byte) 95, (byte) 162, (byte) 244, (byte) 102, (byte) 231, (byte) 44, (byte) 236, (byte) 36, (byte) 220, (byte) 11};
    private static final byte[] ruBe61Q8R5o30Smj = {(byte) 117, (byte) 67, (byte) 229, (byte) 3, (byte) 186, (byte) 223, (byte) 193, (byte) 231, (byte) 42, (byte) 118, (byte) 90, (byte) 19, (byte) 117, (byte) 25, (byte) 168, (byte) 245, (byte) 12, (byte) 173, (byte) 197, (byte) 134, (byte) 53, (byte) 237, (byte) 148, (byte) 61, (byte) 202, (byte) 219, (byte) 93, (byte) 75, (byte) 255, (byte) 218, (byte) 237, (byte) 183};
    private static final byte[] NvwXvf9SDoDyAhg = {(byte) 210, (byte) 177, (byte) 77, (byte) 58, (byte) 51, (byte) 142, (byte) 162, (byte) 70, (byte) 193, (byte) 219, (byte) 193, (byte) 74, (byte) 252, (byte) 224, (byte) 113, (byte) 71};
    private static final byte[] kiZMMSPOG0HUsgTYbaKjr = {(byte) 62, (byte) 111, (byte) 246, (byte) 148, (byte) 26, (byte) 131, (byte) 22, (byte) 63, (byte) 151, (byte) 80, (byte) 146, (byte) 154, (byte) 130, (byte) 18, (byte) 204, (byte) 214, (byte) 85, (byte) 69, (byte) 115, (byte) 111, (byte) 228, (byte) 72, (byte) 138, (byte) 106, (byte) 224, (byte) 125, (byte) 160, (byte) 8, (byte) 195, (byte) 41, (byte) 73, (byte) 176};
    private static final byte[] LAMt2xywlMNbvHWPUJvE = {(byte) 122, (byte) 143, (byte) 87, (byte) 55, (byte) 145, (byte) 183, (byte) 90, (byte) 227, (byte) 223, (byte) 167, (byte) 153, (byte) 48, (byte) 253, (byte) 228, (byte) 39, (byte) 245};

    public DJJU8UefX5VWXi(Clans clans) {
        this.v8qP8fE86HMhvNuYPFjqY = clans;
    }

    public BukkitAudiences v8qP8fE86HMhvNuYPFjqY() {
        return this.v8qP8fE86HMhvNuYPFjqY.getAdventure();
    }

    public void v8qP8fE86HMhvNuYPFjqY(String str) {
        if (this.v8qP8fE86HMhvNuYPFjqY.getCommandManager().CDW4Fj1iwdIXEOqWjiJSR().registered().containsKey(str)) {
            this.v8qP8fE86HMhvNuYPFjqY.getCommandManager().CDW4Fj1iwdIXEOqWjiJSR().unregisterCommand(str);
        }
    }

    public void v8qP8fE86HMhvNuYPFjqY(String str, ClansCommand clansCommand) {
        this.v8qP8fE86HMhvNuYPFjqY.getCommandManager().CDW4Fj1iwdIXEOqWjiJSR().registerCommand(str, clansCommand);
    }

    public void v8qP8fE86HMhvNuYPFjqY(String str, String str2, String str3, double d, int i, CommandData_show commandData_show, CommandData_title commandData_title, CommandData_actionbar commandData_actionbar, CommandData_sound commandData_sound, HashMap<String, CommandData_show> map, CommandData_disable commandData_disable) {
        this.v8qP8fE86HMhvNuYPFjqY.getCommandManager().ZwrsrwOCXRUscW6Q().put(str, new CommandData(str, str2, str3, d, i, commandData_show, commandData_title, commandData_actionbar, commandData_sound, map, commandData_disable));
    }

    @Deprecated
    public String jBUuLP0sWwaPyPOmogdX7l(String str) {
        return ChatColor.translateAlternateColorCodes('&', this.v8qP8fE86HMhvNuYPFjqY.getColorManager().iZTqZaRK5UGoe0Z(str));
    }

    public Clans jBUuLP0sWwaPyPOmogdX7l() {
        return this.v8qP8fE86HMhvNuYPFjqY;
    }

    public ItemStack v8qP8fE86HMhvNuYPFjqY(ItemStack itemStack, String str) {
        if (itemStack != null) {
            try {
                if (!itemStack.getType().equals(Material.AIR)) {
                    return itemStack;
                }
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return itemStack;
    }

    public String v8qP8fE86HMhvNuYPFjqY(ClanEnum.TranslatableKey translatableKey, String str, String... strArr) {
        if (this.v8qP8fE86HMhvNuYPFjqY.getFiles().p31abtwfBag2jhMH6K().getBoolean(MBVWcrpMNLVC25ahVwQCA()) && VersionUtil.isAbove(VersionUtil.VersionEnum.V113) && this.v8qP8fE86HMhvNuYPFjqY.getFiles().p31abtwfBag2jhMH6K().contains("Config.translate.reference." + translatableKey.toString().toLowerCase())) {
            try {
                if (translatableKey.equals(ClanEnum.TranslatableKey.item) || translatableKey.equals(ClanEnum.TranslatableKey.block)) {
                    translatableKey = Material.valueOf(str.toUpperCase()).isBlock() ? ClanEnum.TranslatableKey.block : ClanEnum.TranslatableKey.item;
                }
            } catch (Exception e) {
            }
            StringBuilder sb = new StringBuilder();
            sb.append(F4IFQjN6SEI3Za5YwQ61u());
            sb.append(this.v8qP8fE86HMhvNuYPFjqY.getFiles().p31abtwfBag2jhMH6K().getString("Config.translate.reference." + translatableKey.toString().toLowerCase()).replace(BtNvLFYgvN2zva8ePy(), str.toLowerCase()));
            if (strArr != null && strArr.length > 0) {
                for (String str2 : strArr) {
                    sb.append(":" + str2);
                }
            }
            sb.append(zipQ7VLVQAgCbDI());
            str = sb.toString();
        }
        return str;
    }

    @Deprecated
    public String v8qP8fE86HMhvNuYPFjqY(String str, String str2, String... strArr) {
        if (this.v8qP8fE86HMhvNuYPFjqY.getFiles().p31abtwfBag2jhMH6K().getBoolean(DccgGsDAUzAKCxMAIHm1Ww()) && this.v8qP8fE86HMhvNuYPFjqY.getFiles().p31abtwfBag2jhMH6K().contains("Config.translate.reference." + str.toString().toLowerCase())) {
            StringBuilder sb = new StringBuilder();
            sb.append(riFzg9UmcR2k1UPaRQjE());
            sb.append(this.v8qP8fE86HMhvNuYPFjqY.getFiles().p31abtwfBag2jhMH6K().getString("Config.translate.reference." + str.toString().toLowerCase()).replace(KEwRl0D3rdHaJJ4CoChrX7(), str2.toLowerCase()));
            if (strArr != null && strArr.length > 0) {
                for (String str3 : strArr) {
                    sb.append(":" + str3);
                }
            }
            sb.append(KLqolTHqcf3n3T());
            str2 = sb.toString();
        }
        return str2;
    }

    public boolean ZwrsrwOCXRUscW6Q(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        Optional<Sound> optionalZJnaNCVQSgEShq = zJnaNCVQSgEShq(str);
        if (!optionalZJnaNCVQSgEShq.isPresent()) {
            return true;
        }
        this.v8qP8fE86HMhvNuYPFjqY.getAdventure().all().playSound(optionalZJnaNCVQSgEShq.get());
        return true;
    }

    public void v8qP8fE86HMhvNuYPFjqY(List<String> list) {
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            try {
                ZwrsrwOCXRUscW6Q(it.next());
            } catch (Exception e) {
            }
        }
    }

    public boolean v8qP8fE86HMhvNuYPFjqY(Player player, List<String> list) {
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            try {
                v8qP8fE86HMhvNuYPFjqY(player, it.next());
            } catch (Exception e) {
            }
        }
        return true;
    }

    public boolean v8qP8fE86HMhvNuYPFjqY(Player player, String str) {
        if (CooldownAPI.isInCooldown(this.v8qP8fE86HMhvNuYPFjqY.getPluginUUID(), NNVXUghYyKGwHRhsKeKvv()) || str == null || str.isEmpty() || !this.v8qP8fE86HMhvNuYPFjqY.getFiles().p31abtwfBag2jhMH6K().getBoolean(yX6xaBCmEWTuuyhlZ())) {
            return false;
        }
        Optional<Sound> optionalZJnaNCVQSgEShq = zJnaNCVQSgEShq(str);
        if (!optionalZJnaNCVQSgEShq.isPresent() || this.v8qP8fE86HMhvNuYPFjqY.getFiles().p31abtwfBag2jhMH6K().getBoolean(v0KOe85rwKHMhzL3VKnS())) {
            return false;
        }
        this.v8qP8fE86HMhvNuYPFjqY.getAdventure().player(player).playSound(optionalZJnaNCVQSgEShq.get());
        return true;
    }

    private Optional<Sound> zJnaNCVQSgEShq(String str) {
        if (str == null || str.isEmpty()) {
            return Optional.empty();
        }
        try {
            float f = (float) this.v8qP8fE86HMhvNuYPFjqY.getFiles().p31abtwfBag2jhMH6K().getDouble(JZQv4HJ0YOJ4BS2To8xxND());
            float f2 = (float) this.v8qP8fE86HMhvNuYPFjqY.getFiles().p31abtwfBag2jhMH6K().getDouble(fMm5P3HAg36oPyuoH());
            Sound.Source source = Sound.Source.MASTER;
            String[] strArrSplit = str.split(dRJlaTwKwmQXq5Y6R());
            String strReplace = strArrSplit[0];
            if (strReplace.startsWith(oHO15eh5wZfzXBzbJ2())) {
                strReplace = strReplace.replace(Vx51cZSKk81fP6i(), "");
            }
            float fV8qP8fE86HMhvNuYPFjqY = strArrSplit.length > 1 ? v8qP8fE86HMhvNuYPFjqY(strArrSplit[1], f) : f;
            float fV8qP8fE86HMhvNuYPFjqY2 = strArrSplit.length > 2 ? v8qP8fE86HMhvNuYPFjqY(strArrSplit[2], f2) : f2;
            Sound.Source sourceV8qP8fE86HMhvNuYPFjqY = strArrSplit.length > 1 ? v8qP8fE86HMhvNuYPFjqY(strArrSplit[1], source) : source;
            Key key = null;
            try {
                key = Key.key(strReplace);
            } catch (Exception e) {
            }
            if (key != null) {
                return Optional.of(Sound.sound(key, sourceV8qP8fE86HMhvNuYPFjqY, fV8qP8fE86HMhvNuYPFjqY, fV8qP8fE86HMhvNuYPFjqY2));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return Optional.empty();
    }

    public Key iZTqZaRK5UGoe0Z(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        try {
            return Key.key("minecraft:" + str.toLowerCase().replace(hmwP8FWzFKPupm68Ylu(), ApHEkr83ek8t5xx65xoJzs()));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private Sound.Source v8qP8fE86HMhvNuYPFjqY(String str, Sound.Source source) {
        try {
            return Sound.Source.valueOf(str.toUpperCase());
        } catch (IllegalArgumentException | NullPointerException e) {
            return source;
        }
    }

    private float v8qP8fE86HMhvNuYPFjqY(String str, float f) {
        try {
            return Float.parseFloat(str);
        } catch (NumberFormatException e) {
            return f;
        }
    }

    public String ZwrsrwOCXRUscW6Q() {
        return this.jBUuLP0sWwaPyPOmogdX7l;
    }

    public void xtOheRiObl4QeAl(String str) {
        this.jBUuLP0sWwaPyPOmogdX7l = str;
    }

    private static String JMWinWNFIabWPu() {
        return "ARMOR_STAND";
    }

    private static String MBVWcrpMNLVC25ahVwQCA() {
        return "Config.translate.enabled";
    }

    private static String F4IFQjN6SEI3Za5YwQ61u() {
        return "<lang:";
    }

    private static String BtNvLFYgvN2zva8ePy() {
        return "{object}";
    }

    private static String zipQ7VLVQAgCbDI() {
        return ">";
    }

    private static String DccgGsDAUzAKCxMAIHm1Ww() {
        return "Config.translate.enabled";
    }

    private static String riFzg9UmcR2k1UPaRQjE() {
        return "<lang:";
    }

    private static String KEwRl0D3rdHaJJ4CoChrX7() {
        return "{object}";
    }

    private static String KLqolTHqcf3n3T() {
        return ">";
    }

    private static String NNVXUghYyKGwHRhsKeKvv() {
        return "reload";
    }

    private static String yX6xaBCmEWTuuyhlZ() {
        return "Config.sound.enabled";
    }

    private static String v0KOe85rwKHMhzL3VKnS() {
        return "Config.sound.only_legacy";
    }

    private static String JZQv4HJ0YOJ4BS2To8xxND() {
        return "Config.sound.default_volume";
    }

    private static String fMm5P3HAg36oPyuoH() {
        return "Config.sound.default_pitch";
    }

    private static String dRJlaTwKwmQXq5Y6R() {
        return ":";
    }

    private static String oHO15eh5wZfzXBzbJ2() {
        return "minecraft:";
    }

    private static String Vx51cZSKk81fP6i() {
        return "minecraft:";
    }

    private static String hmwP8FWzFKPupm68Ylu() {
        return "_";
    }

    private static String ApHEkr83ek8t5xx65xoJzs() {
        return ".";
    }
}
