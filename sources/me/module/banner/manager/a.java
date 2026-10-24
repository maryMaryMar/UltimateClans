package me.module.banner.manager;

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
import me.module.banner.Banner;
import me.module.banner.manager.EnumFiles.Lang;
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

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Banner.jar:me/module/banner/manager/a.class */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private HashMap<String, AddonGuiData> f100a = new HashMap<>();
    private final HashMap<String, HashMap<String, AddonGuiData>> b = new HashMap<>();
    private List<Player> c = new ArrayList();
    private me.module.banner.manager.a.a d;
    private static byte[] __aes_key_skHtTfwe = {(byte) 136, (byte) 52, (byte) 56, (byte) 212, (byte) 5, (byte) 163, (byte) 220, (byte) 218, (byte) 50, (byte) 79, (byte) 73, (byte) 140, (byte) 247, (byte) 238, (byte) 59, (byte) 66, (byte) 230, (byte) 178, (byte) 173, (byte) 92, (byte) 103, (byte) 106, (byte) 130, (byte) 85, (byte) 179, (byte) 196, (byte) 70, (byte) 200, (byte) 50, (byte) 182, (byte) 85, (byte) 28};
    private static byte[] __aes_iv_psx2S4MO = {(byte) 26, (byte) 148, (byte) 211, (byte) 194, (byte) 196, (byte) 18, (byte) 146, (byte) 123, (byte) 14, (byte) 186, (byte) 234, (byte) 155, (byte) 19, (byte) 18, (byte) 215, (byte) 211};
    private static String __s_cache_UdlHcN6l_0;
    private static String __s_cache_wSR5Btn5_1;
    private static String __s_cache_9lwkN59D_2;
    private static String __s_cache_mnBmP6Zu_3;
    private static String __s_cache_Dl80YIxG_4;
    private static String __s_cache_nXEe2aw5_5;
    private static String __s_cache_ctGDBs7u_6;
    private static String __s_cache_AVoyG5gN_7;
    private static String __s_cache_wy8B7mTX_8;
    private static String __s_cache_sPwHd8LV_9;
    private static String __s_cache_w0QV5zA5_10;
    private static String __s_cache_ZhmgWTu2_11;
    private static String __s_cache_w5BHHADu_12;
    private static String __s_cache_jEwO6QMM_13;
    private static String __s_cache_oNDt5vNf_14;
    private static String __s_cache_QHK9ruqN_15;
    private static String __s_cache_Kf1StWu7_16;
    private static String __s_cache_QUaA4PfL_17;
    private static String __s_cache_hK4nte7n_18;
    private static String __s_cache_aKB5md7b_19;
    private static String __s_cache_bO5CgrRJ_20;
    private static String __s_cache_MwOKGUL1_21;
    private static String __s_cache_vUn1S7bZ_22;
    private static String __s_cache_HU1J3PNG_23;
    private static String __s_cache_4A8ESb4e_24;
    private static String __s_cache_wZf43YTY_25;
    private static String __s_cache_Iexcgwny_26;
    private static String __s_cache_aap9MHTA_27;
    private static String __s_cache_gy4UK5LA_28;

    public a() {
        b();
        this.d = new me.module.banner.manager.a.a();
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
        HashMap<String, EnumConfiguration> mapD = Banner.getModuleCore().c().d();
        if (mapD == null || mapD.isEmpty()) {
            this.f100a.clear();
            return;
        }
        Iterator<String> it = mapD.keySet().iterator();
        while (it.hasNext()) {
            a(it.next());
        }
        HashMap<String, AddonGuiData> next = this.b.get(Banner.getModuleCore().c().a(Optional.empty()));
        if (next == null) {
            next = this.b.get("EN");
        }
        if (next == null && !this.b.isEmpty()) {
            next = this.b.values().iterator().next();
        }
        this.f100a = next != null ? next : new HashMap<>();
    }

    private void a(String str) {
        String string;
        List<String> stringList;
        EnumConfiguration enumConfiguration = Banner.getModuleCore().c().d().get(str);
        if (enumConfiguration == null) {
            return;
        }
        HashMap<String, AddonGuiData> map = new HashMap<>();
        if (Banner.getModuleCore().c().j().getConfigurationSection("General") == null) {
            this.b.put(str, map);
            return;
        }
        for (String str2 : Banner.getModuleCore().c().j().getConfigurationSection("General").getKeys(false)) {
            HashMap map2 = new HashMap();
            if (Banner.getModuleCore().c().j().getConfigurationSection("General." + str2 + ".items") != null) {
                for (String str3 : Banner.getModuleCore().c().j().getConfigurationSection("General." + str2 + ".items").getKeys(false)) {
                    if (!Banner.getModuleCore().c().j().contains("General." + str2 + ".items." + str3 + ".enabled") || Banner.getModuleCore().c().j().getBoolean("General." + str2 + ".items." + str3 + ".enabled")) {
                        List arrayList = new ArrayList();
                        try {
                            if (Banner.getModuleCore().c().j().contains("General." + str2 + ".items." + str3 + ".nbt.string") && !Banner.getModuleCore().c().j().getStringList("General." + str2 + ".items." + str3 + ".nbt.string").isEmpty()) {
                                arrayList = Banner.getModuleCore().c().j().getStringList("General." + str2 + ".items." + str3 + ".nbt.string");
                            }
                        } catch (Exception e) {
                        }
                        NbtData nbtData = new NbtData(arrayList, 0);
                        ArrayList arrayList2 = new ArrayList();
                        int i = -1;
                        try {
                            if (Banner.getModuleCore().c().j().contains("General." + str2 + ".items." + str3 + ".slot")) {
                                i = Banner.getModuleCore().c().j().getInt("General." + str2 + ".items." + str3 + ".slot");
                            }
                        } catch (Exception e2) {
                        }
                        try {
                            if (Banner.getModuleCore().c().j().contains("General." + str2 + ".items." + str3 + ".model")) {
                                nbtData.setModel(Banner.getModuleCore().c().j().getInt("General." + str2 + ".items." + str3 + ".model"));
                            }
                        } catch (Exception e3) {
                        }
                        GuiItemsData_fill guiItemsData_fill = new GuiItemsData_fill(new ArrayList(), false, false, false, false);
                        try {
                            if (Banner.getModuleCore().c().j().contains("General." + str2 + ".items." + str3 + ".mimeslots")) {
                                if (Banner.getModuleCore().c().j().getStringList("General." + str2 + ".items." + str3 + ".mimeslots").contains("ALL")) {
                                    guiItemsData_fill.setAll(true);
                                } else if (Banner.getModuleCore().c().j().getStringList("General." + str2 + ".items." + str3 + ".mimeslots").contains("TOP")) {
                                    guiItemsData_fill.setTop(true);
                                } else if (Banner.getModuleCore().c().j().getStringList("General." + str2 + ".items." + str3 + ".mimeslots").contains("BOTTOM")) {
                                    guiItemsData_fill.setBottom(true);
                                } else if (Banner.getModuleCore().c().j().getStringList("General." + str2 + ".items." + str3 + ".mimeslots").contains("BORDER")) {
                                    guiItemsData_fill.setBorder(true);
                                } else {
                                    guiItemsData_fill.setSlots(Banner.getModuleCore().c().j().getIntegerList("General." + str2 + ".items." + str3 + ".mimeslots"));
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
                            map2.put(str3, new AddonGuiItemsData(str3, Banner.getModuleCore().c().j().getString("General." + str2 + ".items." + str3 + ".clicksound"), Banner.getModuleCore().c().j().getString("General." + str2 + ".items." + str3 + ".material"), Banner.getModuleCore().c().j().getInt("General." + str2 + ".items." + str3 + ".amount"), Banner.getModuleCore().c().j().getBoolean("General." + str2 + ".items." + str3 + ".glow"), string, stringList, Banner.getModuleCore().c().j().getString("General." + str2 + ".items." + str3 + ".texture"), nbtData, i, guiItemsData_fill, arrayList2, Arrays.asList(new String[0])));
                        } catch (Exception e5) {
                            e5.printStackTrace();
                        }
                    }
                }
                if (map2.size() > 0) {
                    String str__getString_1amrAcN8_17 = "Empty";
                    try {
                        str__getString_1amrAcN8_17 = enumConfiguration.getString(Lang.valueOf("General_" + str2 + "_title"));
                    } catch (Exception e6) {
                    }
                    map.put(str2, new AddonGuiData(str2, str__getString_1amrAcN8_17, Banner.getModuleCore().c().j().getInt("General." + str2 + ".rows"), Banner.getModuleCore().c().j().getInt("General." + str2 + ".pagesize"), Banner.getModuleCore().c().j().getString("General." + str2 + ".opensound"), map2));
                }
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

    public ItemBuilder a(AddonGuiItemsData addonGuiItemsData, ItemStack itemStack, UUID uuid, List<String> list) {
        System.out.println(">> USOU ITEMSTACK");
        return a(addonGuiItemsData, uuid, list);
    }

    public ItemBuilder a(AddonGuiItemsData addonGuiItemsData, UUID uuid, List<String> list) {
        try {
            String str = addonGuiItemsData.getMaterial().split(":")[0];
            ItemBuilder itemBuilderFrom = null;
            String text = Banner.a().getClanAPI().parseText(uuid, addonGuiItemsData.getTexture());
            String text2 = Banner.a().getClanAPI().parseText(uuid, str);
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
                            itemBuilderFrom = itemStackItemStackFromBase64 == null ? ItemBuilder.from(Material.valueOf(Banner.a().getLibAPI().getDefaultBanner())) : ItemBuilder.from(itemStackItemStackFromBase64);
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
            itemBuilderFrom.name(Banner.a().getColorAPI().addMiniColor(Banner.a().getHooksAPI().parsePapi(uuid, Banner.a().getClanAPI().parseText(uuid, a(addonGuiItemsData.getName(), list)))));
            itemBuilderFrom.glow(addonGuiItemsData.isGlow());
            List<String> lore = addonGuiItemsData.getLore();
            if (lore != null && !lore.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < lore.size(); i++) {
                    arrayList.add(Banner.a().getColorAPI().addMiniColor(Banner.a().getHooksAPI().parsePapi(uuid, Banner.a().getClanAPI().parseText(uuid, a(lore.get(i), list)))));
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
        return this.f100a;
    }

    public HashMap<String, AddonGuiData> a(Player player) {
        if (player == null) {
            return d();
        }
        HashMap<String, AddonGuiData> map = this.b.get(Banner.getModuleCore().c().a(Optional.of(player.getUniqueId())));
        return map != null ? map : d();
    }

    public void a(HashMap<String, AddonGuiData> map) {
        this.f100a = map;
    }

    public me.module.banner.manager.a.a e() {
        return this.d;
    }

    private static String __unused_1642() {
        return "EN";
    }

    private static String __unused_1643() {
        return "General";
    }

    private static String __unused_1644() {
        return "General";
    }

    private static String __unused_1645() {
        return "ALL";
    }

    private static String __unused_1646() {
        return "TOP";
    }

    private static String __unused_1647() {
        return "BOTTOM";
    }

    private static String __unused_1648() {
        return "BORDER";
    }

    private static String __unused_1649() {
        return "Empty";
    }

    private static String __unused_1650() {
        return "previous";
    }

    private static String __unused_1651() {
        return "next";
    }

    private static String __unused_1652() {
        return "back";
    }

    private static String __unused_1653() {
        return "prev";
    }

    private static String __unused_1654() {
        return "General_common_previous_name";
    }

    private static String __unused_1655() {
        return "General_common_previous_lore";
    }

    private static String __unused_1656() {
        return "fill";
    }

    private static String __unused_1657() {
        return "General_common_fill_name";
    }

    private static String __unused_1658() {
        return "General_common_fill_lore";
    }

    private static String __unused_1659() {
        return "Empty";
    }

    private static String __unused_1660() {
        return ">> USOU ITEMSTACK";
    }

    private static String __unused_1661() {
        return ":";
    }

    private static String __unused_1662() {
        return "material:";
    }

    private static String __unused_1663() {
        return "\\:";
    }

    private static String __unused_1664() {
        return "base64:";
    }

    private static String __unused_1665() {
        return "\\:";
    }

    private static String __unused_1666() {
        return "serialized:";
    }

    private static String __unused_1667() {
        return "\\:";
    }

    private static String __unused_1668() {
        return ":";
    }

    private static String __unused_1669() {
        return ":";
    }

    private static String __unused_1670() {
        return ";";
    }
}
