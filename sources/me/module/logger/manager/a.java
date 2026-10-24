package me.module.logger.manager;

import com.google.common.collect.HashMultimap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import me.module.logger.Logger;
import me.module.logger.manager.EnumFiles.Lang;
import me.ulrich.clans.data.AddonGuiData;
import me.ulrich.clans.data.AddonGuiItemsData;
import me.ulrich.clans.data.GuiItemsData_fill;
import me.ulrich.clans.data.NbtData;
import me.ulrich.clans.library.enumconfig.EnumConfiguration;
import me.ulrich.clans.library.gui.builder.item.ItemBuilder;
import me.ulrich.clans.library.gui.guis.Gui;
import me.ulrich.clans.library.gui.guis.GuiItem;
import me.ulrich.clans.library.gui.guis.PaginatedGui;
import me.ulrich.clans.library.gui.guis.StorageGui;
import me.ulrich.clans.manager.utils.Serialize;
import me.ulrich.clans.manager.utils.VersionUtil;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Logger.jar:me/module/logger/manager/a.class */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private HashMap<String, AddonGuiData> f123a = new HashMap<>();
    private final HashMap<String, HashMap<String, AddonGuiData>> b = new HashMap<>();
    private List<Player> c = new ArrayList();
    private me.module.logger.manager.b.a d;
    private static byte[] __aes_key_acmwIxY7 = {(byte) 189, (byte) 190, (byte) 104, (byte) 19, (byte) 177, (byte) 112, (byte) 80, (byte) 209, (byte) 131, (byte) 253, (byte) 237, (byte) 121, (byte) 7, (byte) 167, (byte) 97, (byte) 128, (byte) 253, (byte) 227, (byte) 59, (byte) 132, (byte) 9, (byte) 213, (byte) 228, (byte) 102, (byte) 70, (byte) 212, (byte) 180, (byte) 81, (byte) 87, (byte) 122, (byte) 3, (byte) 158};
    private static byte[] __aes_iv_YagvgtDL = {(byte) 242, (byte) 50, (byte) 90, (byte) 100, (byte) 65, (byte) 61, (byte) 74, (byte) 55, (byte) 208, (byte) 220, (byte) 249, (byte) 220, (byte) 253, (byte) 76, (byte) 118, (byte) 29};
    private static String __s_cache_G6AFHzXr_0;
    private static String __s_cache_M0EJ3vAc_1;
    private static String __s_cache_XztiwohL_2;
    private static String __s_cache_s6RHlu1M_3;
    private static String __s_cache_icLLtSFk_4;
    private static String __s_cache_VpDV84UP_5;
    private static String __s_cache_G89a8lfK_6;
    private static String __s_cache_BmWPIGal_7;
    private static String __s_cache_6u7WcysD_8;
    private static String __s_cache_bjS0HnAB_9;
    private static String __s_cache_5rCh3WNs_10;
    private static String __s_cache_jaRHslyb_11;
    private static String __s_cache_28FMqXxh_12;
    private static String __s_cache_jAWeJHzz_13;
    private static String __s_cache_TktJXafn_14;
    private static String __s_cache_0jwdfZEY_15;
    private static String __s_cache_atu8wkEt_16;
    private static String __s_cache_RbfNsqbK_17;
    private static String __s_cache_5erRF9Z4_18;
    private static String __s_cache_wGyIh28f_19;
    private static String __s_cache_edFu6Eny_20;
    private static String __s_cache_sxBnKcsr_21;
    private static String __s_cache_2RRysZ8h_22;
    private static String __s_cache_OBpTp2Zv_23;
    private static String __s_cache_q1tV2wZR_24;
    private static String __s_cache_9qubtCgR_25;
    private static String __s_cache_DSg5Mo73_26;

    public a() {
        b();
        this.d = new me.module.logger.manager.b.a();
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
        HashMap<String, EnumConfiguration> mapE = Logger.getModuleCore().c().e();
        if (mapE == null || mapE.isEmpty()) {
            this.f123a.clear();
            return;
        }
        Iterator<String> it = mapE.keySet().iterator();
        while (it.hasNext()) {
            a(it.next());
        }
        HashMap<String, AddonGuiData> next = this.b.get(Logger.getModuleCore().c().a(Optional.empty()));
        if (next == null) {
            next = this.b.get("EN");
        }
        if (next == null && !this.b.isEmpty()) {
            next = this.b.values().iterator().next();
        }
        this.f123a = next != null ? next : new HashMap<>();
    }

    private void a(String str) {
        String string;
        List<String> stringList;
        EnumConfiguration enumConfiguration = Logger.getModuleCore().c().e().get(str);
        if (enumConfiguration == null) {
            return;
        }
        HashMap<String, AddonGuiData> map = new HashMap<>();
        for (String str2 : Logger.getModuleCore().c().l().getConfigurationSection("General").getKeys(false)) {
            HashMap map2 = new HashMap();
            for (String str3 : Logger.getModuleCore().c().l().getConfigurationSection("General." + str2 + ".items").getKeys(false)) {
                if (!Logger.getModuleCore().c().l().contains("General." + str2 + ".items." + str3 + ".enabled") || Logger.getModuleCore().c().l().getBoolean("General." + str2 + ".items." + str3 + ".enabled")) {
                    List arrayList = new ArrayList();
                    try {
                        if (Logger.getModuleCore().c().l().contains("General." + str2 + ".items." + str3 + ".nbt.string") && !Logger.getModuleCore().c().l().getStringList("General." + str2 + ".items." + str3 + ".nbt.string").isEmpty()) {
                            arrayList = Logger.getModuleCore().c().l().getStringList("General." + str2 + ".items." + str3 + ".nbt.string");
                        }
                    } catch (Exception e) {
                    }
                    NbtData nbtData = new NbtData(arrayList, 0);
                    ArrayList arrayList2 = new ArrayList();
                    int i = -1;
                    try {
                        if (Logger.getModuleCore().c().l().contains("General." + str2 + ".items." + str3 + ".slot")) {
                            i = Logger.getModuleCore().c().l().getInt("General." + str2 + ".items." + str3 + ".slot");
                        }
                    } catch (Exception e2) {
                    }
                    try {
                        if (Logger.getModuleCore().c().l().contains("General." + str2 + ".items." + str3 + ".model")) {
                            nbtData.setModel(Logger.getModuleCore().c().l().getInt("General." + str2 + ".items." + str3 + ".model"));
                        }
                    } catch (Exception e3) {
                    }
                    GuiItemsData_fill guiItemsData_fill = new GuiItemsData_fill(new ArrayList(), false, false, false, false);
                    try {
                        if (Logger.getModuleCore().c().l().contains("General." + str2 + ".items." + str3 + ".mimeslots")) {
                            if (Logger.getModuleCore().c().l().getStringList("General." + str2 + ".items." + str3 + ".mimeslots").contains("ALL")) {
                                guiItemsData_fill.setAll(true);
                            } else if (Logger.getModuleCore().c().l().getStringList("General." + str2 + ".items." + str3 + ".mimeslots").contains("TOP")) {
                                guiItemsData_fill.setTop(true);
                            } else if (Logger.getModuleCore().c().l().getStringList("General." + str2 + ".items." + str3 + ".mimeslots").contains("BOTTOM")) {
                                guiItemsData_fill.setBottom(true);
                            } else if (Logger.getModuleCore().c().l().getStringList("General." + str2 + ".items." + str3 + ".mimeslots").contains("BORDER")) {
                                guiItemsData_fill.setBorder(true);
                            } else {
                                guiItemsData_fill.setSlots(Logger.getModuleCore().c().l().getIntegerList("General." + str2 + ".items." + str3 + ".mimeslots"));
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
                        } else {
                            string = enumConfiguration.getString(Lang.valueOf("General_" + str2 + "_items_" + str3 + "_name"));
                            stringList = enumConfiguration.getStringList(Lang.valueOf("General_" + str2 + "_items_" + str3 + "_lore"));
                        }
                        map2.put(str3, new AddonGuiItemsData(str3, Logger.getModuleCore().c().l().getString("General." + str2 + ".items." + str3 + ".clicksound"), Logger.getModuleCore().c().l().getString("General." + str2 + ".items." + str3 + ".material"), Logger.getModuleCore().c().l().getInt("General." + str2 + ".items." + str3 + ".amount"), Logger.getModuleCore().c().l().getBoolean("General." + str2 + ".items." + str3 + ".glow"), string, stringList, Logger.getModuleCore().c().l().getString("General." + str2 + ".items." + str3 + ".texture"), nbtData, i, guiItemsData_fill, arrayList2, Arrays.asList(new String[0])));
                    } catch (Exception e5) {
                        e5.printStackTrace();
                    }
                }
            }
            if (map2 != null && map2.size() > 0) {
                String str__getString_riUN950m_16 = "Empty";
                try {
                    str__getString_riUN950m_16 = enumConfiguration.getString(Lang.valueOf("General_" + str2 + "_title"));
                } catch (Exception e6) {
                }
                map.put(str2, new AddonGuiData(str2, str__getString_riUN950m_16, Logger.getModuleCore().c().l().getInt("General." + str2 + ".rows"), Logger.getModuleCore().c().l().getInt("General." + str2 + ".pagesize"), Logger.getModuleCore().c().l().getString("General." + str2 + ".opensound"), map2));
            }
        }
        this.b.put(str, map);
    }

    public void a(PaginatedGui paginatedGui, AddonGuiItemsData addonGuiItemsData, GuiItem guiItem) {
        if (addonGuiItemsData.getSlot() >= 0) {
            paginatedGui.setItem(addonGuiItemsData.getSlot(), guiItem);
        }
        if (addonGuiItemsData.getMineSlots().isTop()) {
            paginatedGui.getFiller().fillTop(guiItem);
        }
        if (addonGuiItemsData.getMineSlots().isBorder()) {
            paginatedGui.getFiller().fillBorder(guiItem);
        }
        if (addonGuiItemsData.getMineSlots().isBottom()) {
            paginatedGui.getFiller().fillBottom(guiItem);
        }
        if (addonGuiItemsData.getMineSlots().getSlots().size() > 0) {
            paginatedGui.setItem(addonGuiItemsData.getMineSlots().getSlots(), guiItem);
        }
    }

    public void a(StorageGui storageGui, AddonGuiItemsData addonGuiItemsData, GuiItem guiItem) {
        if (addonGuiItemsData.getSlot() >= 0) {
            storageGui.setItem(addonGuiItemsData.getSlot(), guiItem);
        }
        if (addonGuiItemsData.getMineSlots().isTop()) {
            storageGui.getFiller().fillTop(guiItem);
        }
        if (addonGuiItemsData.getMineSlots().isBorder()) {
            storageGui.getFiller().fillBorder(guiItem);
        }
        if (addonGuiItemsData.getMineSlots().isBottom()) {
            storageGui.getFiller().fillBottom(guiItem);
        }
        if (addonGuiItemsData.getMineSlots().getSlots().size() > 0) {
            storageGui.setItem(addonGuiItemsData.getMineSlots().getSlots(), guiItem);
        }
    }

    public void a(Gui gui, AddonGuiItemsData addonGuiItemsData, GuiItem guiItem) {
        if (addonGuiItemsData.getMineSlots().isAll()) {
            gui.getFiller().fill(guiItem);
        }
        if (addonGuiItemsData.getMineSlots().isTop()) {
            gui.getFiller().fillTop(guiItem);
        }
        if (addonGuiItemsData.getMineSlots().isBorder()) {
            gui.getFiller().fillBorder(guiItem);
        }
        if (addonGuiItemsData.getMineSlots().isBottom()) {
            gui.getFiller().fillBottom(guiItem);
        }
        if (addonGuiItemsData.getMineSlots().getSlots().size() > 0) {
            gui.setItem(addonGuiItemsData.getMineSlots().getSlots(), guiItem);
        }
        if (addonGuiItemsData.getSlot() >= 0) {
            gui.setItem(addonGuiItemsData.getSlot(), guiItem);
        }
    }

    public Set<Integer> a(StorageGui storageGui, AddonGuiItemsData addonGuiItemsData) {
        HashSet hashSet = new HashSet();
        if (addonGuiItemsData.getSlot() >= 0) {
            hashSet.add(Integer.valueOf(addonGuiItemsData.getSlot()));
        }
        if (addonGuiItemsData.getMineSlots().isTop()) {
            hashSet.addAll(a(storageGui.getRows()));
        }
        if (addonGuiItemsData.getMineSlots().isBorder()) {
            hashSet.addAll(b(storageGui.getRows()));
        }
        if (addonGuiItemsData.getMineSlots().isBottom()) {
            hashSet.addAll(c(storageGui.getRows()));
        }
        if (!addonGuiItemsData.getMineSlots().getSlots().isEmpty()) {
            hashSet.addAll(addonGuiItemsData.getMineSlots().getSlots());
        }
        return hashSet;
    }

    public Set<Integer> a(PaginatedGui paginatedGui, AddonGuiItemsData addonGuiItemsData) {
        HashSet hashSet = new HashSet();
        if (addonGuiItemsData.getSlot() >= 0) {
            hashSet.add(Integer.valueOf(addonGuiItemsData.getSlot()));
        }
        if (addonGuiItemsData.getMineSlots().isTop()) {
            hashSet.addAll(a(paginatedGui.getRows()));
        }
        if (addonGuiItemsData.getMineSlots().isBorder()) {
            hashSet.addAll(b(paginatedGui.getRows()));
        }
        if (addonGuiItemsData.getMineSlots().isBottom()) {
            hashSet.addAll(c(paginatedGui.getRows()));
        }
        if (!addonGuiItemsData.getMineSlots().getSlots().isEmpty()) {
            hashSet.addAll(addonGuiItemsData.getMineSlots().getSlots());
        }
        return hashSet;
    }

    private Set<Integer> a(int i) {
        HashSet hashSet = new HashSet();
        for (int i2 = 0; i2 < 9; i2++) {
            hashSet.add(Integer.valueOf(i2));
        }
        return hashSet;
    }

    private Set<Integer> b(int i) {
        HashSet hashSet = new HashSet();
        int i2 = i * 9;
        for (int i3 = 0; i3 < i2; i3++) {
            if (i3 < 9 || i3 >= i2 - 9 || i3 % 9 == 0 || (i3 + 1) % 9 == 0) {
                hashSet.add(Integer.valueOf(i3));
            }
        }
        return hashSet;
    }

    private Set<Integer> c(int i) {
        HashSet hashSet = new HashSet();
        int i2 = i * 9;
        for (int i3 = i2 - 9; i3 < i2; i3++) {
            hashSet.add(Integer.valueOf(i3));
        }
        return hashSet;
    }

    public ItemBuilder a(AddonGuiItemsData addonGuiItemsData, UUID uuid, List<String> list) {
        try {
            String str = addonGuiItemsData.getMaterial().split(":")[0];
            ItemBuilder itemBuilderFrom = null;
            String text = Logger.a().getClanAPI().parseText(uuid, addonGuiItemsData.getTexture());
            String text2 = Logger.getModuleCore().e().parseText(uuid, Logger.a().getClanAPI().parseText(uuid, str));
            if (0 == 0 && text2 != null && !text2.isEmpty()) {
                itemBuilderFrom = ItemBuilder.from(new ItemStack(Material.valueOf(text2), addonGuiItemsData.getAmount()));
            }
            if (addonGuiItemsData.getTexture() != null && !addonGuiItemsData.getTexture().isEmpty()) {
                if (text.startsWith("material:")) {
                    itemBuilderFrom = ItemBuilder.from(new ItemStack(Material.valueOf(text.split("\\:")[1]), 1));
                } else if (text.startsWith("base64:")) {
                    String[] strArrSplit = text.split("\\:");
                    if (strArrSplit[1] != null) {
                        itemBuilderFrom = ItemBuilder.from(ItemBuilder.skull().texture(strArrSplit[1]).build());
                    }
                } else if (text.startsWith("serialized:")) {
                    try {
                        String[] strArrSplit2 = text.split("\\:");
                        if (strArrSplit2[1] != null && !strArrSplit2[1].isEmpty()) {
                            ItemStack itemStackItemStackFromBase64 = new Serialize().itemStackFromBase64(strArrSplit2[1]);
                            itemBuilderFrom = itemStackItemStackFromBase64 == null ? ItemBuilder.from(Material.valueOf(Logger.a().getLibAPI().getDefaultBanner())) : ItemBuilder.from(itemStackItemStackFromBase64);
                        }
                    } catch (Exception e) {
                    }
                } else {
                    itemBuilderFrom = ItemBuilder.from(ItemBuilder.skull().texture(text).build());
                }
            }
            if (itemBuilderFrom == null) {
                return null;
            }
            try {
                if (addonGuiItemsData.getNbt() != null && !addonGuiItemsData.getNbt().getString().isEmpty()) {
                    for (String str2 : addonGuiItemsData.getNbt().getString()) {
                        if (str2.contains(":")) {
                            String[] strArrSplit3 = str2.split(":");
                            itemBuilderFrom.setNbt(strArrSplit3[0], String.valueOf(strArrSplit3[1]));
                        }
                    }
                }
            } catch (Exception e2) {
            }
            try {
                if (addonGuiItemsData.getNbt().getModel() > 0) {
                    itemBuilderFrom.model(addonGuiItemsData.getNbt().getModel());
                }
            } catch (Exception e3) {
            }
            itemBuilderFrom.name(Logger.a().getColorAPI().addMiniColor(Logger.getModuleCore().e().parseText(uuid, Logger.a().getHooksAPI().parsePapi(uuid, Logger.a().getClanAPI().parseText(uuid, a(addonGuiItemsData.getName(), list))))));
            itemBuilderFrom.glow(addonGuiItemsData.isGlow());
            List<String> lore = addonGuiItemsData.getLore();
            if (lore != null && !lore.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < lore.size(); i++) {
                    arrayList.add(Logger.a().getColorAPI().addMiniColor(Logger.getModuleCore().e().parseText(uuid, Logger.a().getHooksAPI().parsePapi(uuid, Logger.a().getClanAPI().parseText(uuid, a(lore.get(i), list))))));
                }
                if (arrayList.size() > 0 && arrayList != null) {
                    itemBuilderFrom.lore(arrayList);
                }
            }
            if ((!VersionUtil.is(VersionUtil.VersionEnum.V120) || VersionUtil.BUILD_VERSION.intValue() < 3) && !VersionUtil.isAbove(VersionUtil.VersionEnum.V121)) {
                try {
                    itemBuilderFrom.flags(ItemFlag.HIDE_ATTRIBUTES);
                } catch (Exception e4) {
                }
                try {
                    itemBuilderFrom.flags(ItemFlag.HIDE_ENCHANTS);
                } catch (Exception e5) {
                }
            } else {
                ItemStack itemStackBuild = itemBuilderFrom.build();
                try {
                    itemStackBuild = a(itemStackBuild, ItemFlag.HIDE_ATTRIBUTES);
                } catch (Exception e6) {
                }
                try {
                    itemStackBuild = a(itemStackBuild, ItemFlag.HIDE_ENCHANTS);
                } catch (Exception e7) {
                }
                itemBuilderFrom = ItemBuilder.from(itemStackBuild);
            }
            return itemBuilderFrom;
        } catch (Exception e8) {
            e8.printStackTrace();
            return null;
        }
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
        return this.f123a;
    }

    public HashMap<String, AddonGuiData> a(Player player) {
        if (player == null) {
            return d();
        }
        HashMap<String, AddonGuiData> map = this.b.get(Logger.getModuleCore().c().a(Optional.of(player.getUniqueId())));
        return map != null ? map : d();
    }

    public void a(HashMap<String, AddonGuiData> map) {
        this.f123a = map;
    }

    public me.module.logger.manager.b.a e() {
        return this.d;
    }

    private static String __unused_129() {
        return "EN";
    }

    private static String __unused_130() {
        return "General";
    }

    private static String __unused_131() {
        return "ALL";
    }

    private static String __unused_132() {
        return "TOP";
    }

    private static String __unused_133() {
        return "BOTTOM";
    }

    private static String __unused_134() {
        return "BORDER";
    }

    private static String __unused_135() {
        return "Empty";
    }

    private static String __unused_136() {
        return "previous";
    }

    private static String __unused_137() {
        return "next";
    }

    private static String __unused_138() {
        return "back";
    }

    private static String __unused_139() {
        return "prev";
    }

    private static String __unused_140() {
        return "General_common_previous_name";
    }

    private static String __unused_141() {
        return "General_common_previous_lore";
    }

    private static String __unused_142() {
        return "fill";
    }

    private static String __unused_143() {
        return "General_common_fill_name";
    }

    private static String __unused_144() {
        return "General_common_fill_lore";
    }

    private static String __unused_145() {
        return "Empty";
    }

    private static String __unused_146() {
        return ":";
    }

    private static String __unused_147() {
        return "material:";
    }

    private static String __unused_148() {
        return "\\:";
    }

    private static String __unused_149() {
        return "base64:";
    }

    private static String __unused_150() {
        return "\\:";
    }

    private static String __unused_151() {
        return "serialized:";
    }

    private static String __unused_152() {
        return "\\:";
    }

    private static String __unused_153() {
        return ":";
    }

    private static String __unused_154() {
        return ":";
    }

    private static String __unused_155() {
        return ";";
    }
}
