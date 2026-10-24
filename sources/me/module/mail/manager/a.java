package me.module.mail.manager;

import com.google.common.collect.HashMultimap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import me.module.mail.Mail;
import me.module.mail.manager.EnumFiles.Lang;
import me.ulrich.clans.data.AddonGuiData;
import me.ulrich.clans.data.AddonGuiItemsData;
import me.ulrich.clans.data.GuiItemsData_fill;
import me.ulrich.clans.data.NbtData;
import me.ulrich.clans.library.enumconfig.EnumConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Mail.jar:me/module/mail/manager/a.class */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private HashMap<String, AddonGuiData> f133a = new HashMap<>();
    private final HashMap<String, HashMap<String, AddonGuiData>> b = new HashMap<>();
    private List<Player> c = new ArrayList();
    private me.module.mail.manager.b.a d;
    private static byte[] __aes_key_sTZiiK86 = {(byte) 118, (byte) 161, (byte) 138, (byte) 14, (byte) 114, (byte) 92, (byte) 224, (byte) 28, (byte) 113, (byte) 30, (byte) 242, (byte) 103, (byte) 129, (byte) 14, (byte) 62, (byte) 228, (byte) 56, (byte) 147, (byte) 255, (byte) 179, (byte) 250, (byte) 38, (byte) 72, (byte) 99, (byte) 51, (byte) 189, (byte) 141, (byte) 54, (byte) 146, (byte) 200, (byte) 142, (byte) 80};
    private static byte[] __aes_iv_aNSfx54y = {(byte) 108, (byte) 147, (byte) 184, (byte) 179, (byte) 21, (byte) 110, (byte) 108, (byte) 71, (byte) 40, (byte) 178, (byte) 213, (byte) 194, (byte) 127, (byte) 238, (byte) 139, (byte) 112};
    private static String __s_cache_f7MnkCsN_0;
    private static String __s_cache_u6bL8THB_1;
    private static String __s_cache_Iqfiv0rS_2;
    private static String __s_cache_McVr8mfL_3;
    private static String __s_cache_JRjkxI7z_4;
    private static String __s_cache_CDBWDTwq_5;
    private static String __s_cache_IaiL3AfS_6;
    private static String __s_cache_PDDuT7Na_7;
    private static String __s_cache_O6NalgpC_8;
    private static String __s_cache_7roycUqI_9;
    private static String __s_cache_6graANxk_10;
    private static String __s_cache_3dc16EZJ_11;
    private static String __s_cache_3zuiHCgb_12;
    private static String __s_cache_jtod6qGR_13;
    private static String __s_cache_76J9aAJf_14;
    private static String __s_cache_jUpDTWiA_15;
    private static String __s_cache_E7BOUybx_16;
    private static String __s_cache_cTRpnlBh_17;
    private static String __s_cache_Qdndf7G6_18;
    private static String __s_cache_88bwVbUW_19;
    private static String __s_cache_CVOS6lNL_20;

    public a() {
        b();
        this.d = new me.module.mail.manager.b.a();
    }

    public void a() {
        try {
            Iterator<Player> it = c().iterator();
            while (it.hasNext()) {
                it.next().closeInventory();
            }
        } catch (Exception e) {
        }
    }

    public ItemStack a(ItemStack itemStack, ItemFlag itemFlag) {
        ItemMeta itemMeta = itemStack.getItemMeta();
        if (itemMeta.getAttributeModifiers() == null) {
            itemMeta.setAttributeModifiers(HashMultimap.create());
        }
        itemMeta.addItemFlags(new ItemFlag[]{itemFlag});
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    public void b() {
        this.b.clear();
        HashMap<String, EnumConfiguration> mapF = Mail.getModuleCore().c().f();
        if (mapF == null || mapF.isEmpty()) {
            this.f133a.clear();
            return;
        }
        Iterator<String> it = mapF.keySet().iterator();
        while (it.hasNext()) {
            a(it.next());
        }
        HashMap<String, AddonGuiData> next = this.b.get(Mail.getModuleCore().c().a(Optional.empty()));
        if (next == null) {
            next = this.b.get("EN");
        }
        if (next == null && !this.b.isEmpty()) {
            next = this.b.values().iterator().next();
        }
        this.f133a = next != null ? next : new HashMap<>();
    }

    private void a(String str) {
        String string;
        List<String> stringList;
        EnumConfiguration enumConfiguration = Mail.getModuleCore().c().f().get(str);
        if (enumConfiguration == null) {
            return;
        }
        HashMap<String, AddonGuiData> map = new HashMap<>();
        for (String str2 : Mail.getModuleCore().c().m().getConfigurationSection("General").getKeys(false)) {
            HashMap map2 = new HashMap();
            for (String str3 : Mail.getModuleCore().c().m().getConfigurationSection("General." + str2 + ".items").getKeys(false)) {
                if (!Mail.getModuleCore().c().m().contains("General." + str2 + ".items." + str3 + ".enabled") || Mail.getModuleCore().c().m().getBoolean("General." + str2 + ".items." + str3 + ".enabled")) {
                    List arrayList = new ArrayList();
                    try {
                        if (Mail.getModuleCore().c().m().contains("General." + str2 + ".items." + str3 + ".nbt.string") && !Mail.getModuleCore().c().m().getStringList("General." + str2 + ".items." + str3 + ".nbt.string").isEmpty()) {
                            arrayList = Mail.getModuleCore().c().m().getStringList("General." + str2 + ".items." + str3 + ".nbt.string");
                        }
                    } catch (Exception e) {
                    }
                    NbtData nbtData = new NbtData(arrayList, 0);
                    ArrayList arrayList2 = new ArrayList();
                    int i = -1;
                    try {
                        if (Mail.getModuleCore().c().m().contains("General." + str2 + ".items." + str3 + ".slot")) {
                            i = Mail.getModuleCore().c().m().getInt("General." + str2 + ".items." + str3 + ".slot");
                        }
                    } catch (Exception e2) {
                    }
                    try {
                        if (Mail.getModuleCore().c().m().contains("General." + str2 + ".items." + str3 + ".model")) {
                            nbtData.setModel(Mail.getModuleCore().c().m().getInt("General." + str2 + ".items." + str3 + ".model"));
                        }
                    } catch (Exception e3) {
                    }
                    GuiItemsData_fill guiItemsData_fill = new GuiItemsData_fill(new ArrayList(), false, false, false, false);
                    try {
                        if (Mail.getModuleCore().c().m().contains("General." + str2 + ".items." + str3 + ".mimeslots")) {
                            if (Mail.getModuleCore().c().m().getStringList("General." + str2 + ".items." + str3 + ".mimeslots").contains("ALL")) {
                                guiItemsData_fill.setAll(true);
                            } else if (Mail.getModuleCore().c().m().getStringList("General." + str2 + ".items." + str3 + ".mimeslots").contains("TOP")) {
                                guiItemsData_fill.setTop(true);
                            } else if (Mail.getModuleCore().c().m().getStringList("General." + str2 + ".items." + str3 + ".mimeslots").contains("BOTTOM")) {
                                guiItemsData_fill.setBottom(true);
                            } else if (Mail.getModuleCore().c().m().getStringList("General." + str2 + ".items." + str3 + ".mimeslots").contains("BORDER")) {
                                guiItemsData_fill.setBorder(true);
                            } else {
                                guiItemsData_fill.setSlots(Mail.getModuleCore().c().m().getIntegerList("General." + str2 + ".items." + str3 + ".mimeslots"));
                            }
                        }
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                    Arrays.asList(new String[0]);
                    try {
                        if (str3.equalsIgnoreCase("previous") || str3.equalsIgnoreCase("next") || str3.equalsIgnoreCase("back")) {
                            string = enumConfiguration.getString(Lang.valueOf("General_common_" + str3 + "_name"));
                            stringList = enumConfiguration.getStringList(Lang.valueOf("General_common_" + str3 + "_lore"));
                        } else if (str3.equalsIgnoreCase("prev")) {
                            string = enumConfiguration.getString(Lang.valueOf("General_common_previous_name"));
                            stringList = enumConfiguration.getStringList(Lang.valueOf("General_common_previous_lore"));
                        } else if (str3.startsWith("fill")) {
                            string = enumConfiguration.getString(Lang.valueOf("General_common_fill_name"));
                            stringList = enumConfiguration.getStringList(Lang.valueOf("General_common_fill_lore"));
                        } else if (str3.startsWith("fill2")) {
                            string = enumConfiguration.getString(Lang.valueOf("General_common_fill2_name"));
                            stringList = enumConfiguration.getStringList(Lang.valueOf("General_common_fill2_lore"));
                        } else {
                            string = enumConfiguration.getString(Lang.valueOf("General_" + str2 + "_items_" + str3 + "_name"));
                            stringList = enumConfiguration.getStringList(Lang.valueOf("General_" + str2 + "_items_" + str3 + "_lore"));
                        }
                        map2.put(str3, new AddonGuiItemsData(str3, Mail.getModuleCore().c().m().getString("General." + str2 + ".items." + str3 + ".clicksound"), Mail.getModuleCore().c().m().getString("General." + str2 + ".items." + str3 + ".material"), Mail.getModuleCore().c().m().getInt("General." + str2 + ".items." + str3 + ".amount"), Mail.getModuleCore().c().m().getBoolean("General." + str2 + ".items." + str3 + ".glow"), string, stringList, Mail.getModuleCore().c().m().getString("General." + str2 + ".items." + str3 + ".texture"), nbtData, i, guiItemsData_fill, arrayList2, Arrays.asList(new String[0])));
                    } catch (Exception e5) {
                        e5.printStackTrace();
                    }
                }
            }
            if (map2 != null && map2.size() > 0) {
                String str__getString_oTmd69yS_19 = "Empty";
                try {
                    str__getString_oTmd69yS_19 = enumConfiguration.getString(Lang.valueOf("General_" + str2 + "_title"));
                } catch (Exception e6) {
                }
                map.put(str2, new AddonGuiData(str2, str__getString_oTmd69yS_19, Mail.getModuleCore().c().m().getInt("General." + str2 + ".rows"), Mail.getModuleCore().c().m().getInt("General." + str2 + ".pagesize"), Mail.getModuleCore().c().m().getString("General." + str2 + ".opensound"), map2));
            }
        }
        this.b.put(str, map);
    }

    public String a(String str, List<String> list) {
        if (list != null) {
            try {
                Iterator<String> it = list.iterator();
                while (it.hasNext()) {
                    String[] strArrSplit = it.next().split(";");
                    str = str.replace(strArrSplit[0], strArrSplit[1]);
                }
                return str;
            } catch (Exception e) {
            }
        }
        return str;
    }

    public List<Player> c() {
        return this.c;
    }

    public void a(List<Player> list) {
        this.c = list;
    }

    public HashMap<String, AddonGuiData> d() {
        return this.f133a;
    }

    public HashMap<String, AddonGuiData> a(Player player) {
        if (player == null) {
            return d();
        }
        HashMap<String, AddonGuiData> map = this.b.get(Mail.getModuleCore().c().a(Optional.of(player.getUniqueId())));
        return map != null ? map : d();
    }

    public void a(HashMap<String, AddonGuiData> map) {
        this.f133a = map;
    }

    public me.module.mail.manager.b.a e() {
        return this.d;
    }

    private static String __unused_669() {
        return "EN";
    }

    private static String __unused_670() {
        return "General";
    }

    private static String __unused_671() {
        return "ALL";
    }

    private static String __unused_672() {
        return "TOP";
    }

    private static String __unused_673() {
        return "BOTTOM";
    }

    private static String __unused_674() {
        return "BORDER";
    }

    private static String __unused_675() {
        return "Empty";
    }

    private static String __unused_676() {
        return "previous";
    }

    private static String __unused_677() {
        return "next";
    }

    private static String __unused_678() {
        return "back";
    }

    private static String __unused_679() {
        return "prev";
    }

    private static String __unused_680() {
        return "General_common_previous_name";
    }

    private static String __unused_681() {
        return "General_common_previous_lore";
    }

    private static String __unused_682() {
        return "fill";
    }

    private static String __unused_683() {
        return "General_common_fill_name";
    }

    private static String __unused_684() {
        return "General_common_fill_lore";
    }

    private static String __unused_685() {
        return "fill2";
    }

    private static String __unused_686() {
        return "General_common_fill2_name";
    }

    private static String __unused_687() {
        return "General_common_fill2_lore";
    }

    private static String __unused_688() {
        return "Empty";
    }

    private static String __unused_689() {
        return ";";
    }
}
