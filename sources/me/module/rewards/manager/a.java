package me.module.rewards.manager;

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
import me.module.rewards.Rewards;
import me.module.rewards.manager.EnumFiles.Lang;
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

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Rewards.jar:me/module/rewards/manager/a.class */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private HashMap<String, AddonGuiData> f150a = new HashMap<>();
    private final HashMap<String, HashMap<String, AddonGuiData>> b = new HashMap<>();
    private List<Player> c = new ArrayList();
    private me.module.rewards.manager.b.a d;
    private static byte[] __aes_key_vxhckA9L = {(byte) 222, (byte) 189, (byte) 222, (byte) 24, (byte) 19, (byte) 220, (byte) 59, (byte) 21, (byte) 134, (byte) 239, (byte) 216, (byte) 14, (byte) 38, (byte) 24, (byte) 10, (byte) 131, (byte) 10, (byte) 26, (byte) 99, (byte) 65, (byte) 61, (byte) 30, (byte) 127, (byte) 140, (byte) 254, (byte) 11, (byte) 198, (byte) 65, (byte) 175, (byte) 68, (byte) 145, (byte) 114};
    private static byte[] __aes_iv_Di9cQVnW = {(byte) 108, (byte) 129, (byte) 4, (byte) 34, (byte) 210, (byte) 41, (byte) 153, (byte) 248, (byte) 219, (byte) 28, (byte) 123, (byte) 156, (byte) 57, (byte) 166, (byte) 203, (byte) 96};
    private static String __s_cache_lyK6rTv3_0;
    private static String __s_cache_2WHg8XBE_1;
    private static String __s_cache_JUFXhRWW_2;
    private static String __s_cache_IMhltLfU_3;
    private static String __s_cache_YD786tFi_4;
    private static String __s_cache_A7wsB02s_5;
    private static String __s_cache_mDteAgPt_6;
    private static String __s_cache_ycJyH4iG_7;
    private static String __s_cache_N9C1VHO9_8;
    private static String __s_cache_qoYNRtiV_9;
    private static String __s_cache_OdC7t0vn_10;
    private static String __s_cache_7G6PdMZi_11;
    private static String __s_cache_Cd4L8Nzj_12;
    private static String __s_cache_IPbBE2mT_13;
    private static String __s_cache_Edv6zsK7_14;
    private static String __s_cache_dWr2h5dF_15;
    private static String __s_cache_RLCjlr7q_16;
    private static String __s_cache_JtsB210S_17;
    private static String __s_cache_VE2hE5cd_18;
    private static String __s_cache_qoHAaiJw_19;
    private static String __s_cache_sSZvk3ZE_20;
    private static String __s_cache_K2BPzI5v_21;
    private static String __s_cache_TyeZrUKA_22;
    private static String __s_cache_hcvLLzO3_23;
    private static String __s_cache_klzjiKvG_24;
    private static String __s_cache_Uho8Qxv3_25;
    private static String __s_cache_KR7Lj4fv_26;

    public a() {
        b();
        this.d = new me.module.rewards.manager.b.a();
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
        HashMap<String, EnumConfiguration> mapF = Rewards.getModuleCore().c().f();
        if (mapF == null || mapF.isEmpty()) {
            this.f150a.clear();
            return;
        }
        Iterator<String> it = mapF.keySet().iterator();
        while (it.hasNext()) {
            a(it.next());
        }
        HashMap<String, AddonGuiData> next = this.b.get(Rewards.getModuleCore().c().a(Optional.empty()));
        if (next == null) {
            next = this.b.get("EN");
        }
        if (next == null && !this.b.isEmpty()) {
            next = this.b.values().iterator().next();
        }
        this.f150a = next != null ? next : new HashMap<>();
    }

    private void a(String str) {
        String string;
        List<String> stringList;
        EnumConfiguration enumConfiguration = Rewards.getModuleCore().c().f().get(str);
        if (enumConfiguration == null) {
            return;
        }
        HashMap<String, AddonGuiData> map = new HashMap<>();
        for (String str2 : Rewards.getModuleCore().c().m().getConfigurationSection("General").getKeys(false)) {
            HashMap map2 = new HashMap();
            for (String str3 : Rewards.getModuleCore().c().m().getConfigurationSection("General." + str2 + ".items").getKeys(false)) {
                if (!Rewards.getModuleCore().c().m().contains("General." + str2 + ".items." + str3 + ".enabled") || Rewards.getModuleCore().c().m().getBoolean("General." + str2 + ".items." + str3 + ".enabled")) {
                    List arrayList = new ArrayList();
                    try {
                        if (Rewards.getModuleCore().c().m().contains("General." + str2 + ".items." + str3 + ".nbt.string") && !Rewards.getModuleCore().c().m().getStringList("General." + str2 + ".items." + str3 + ".nbt.string").isEmpty()) {
                            arrayList = Rewards.getModuleCore().c().m().getStringList("General." + str2 + ".items." + str3 + ".nbt.string");
                        }
                    } catch (Exception e) {
                    }
                    NbtData nbtData = new NbtData(arrayList, 0);
                    ArrayList arrayList2 = new ArrayList();
                    int i = -1;
                    try {
                        if (Rewards.getModuleCore().c().m().contains("General." + str2 + ".items." + str3 + ".slot")) {
                            i = Rewards.getModuleCore().c().m().getInt("General." + str2 + ".items." + str3 + ".slot");
                        }
                    } catch (Exception e2) {
                    }
                    try {
                        if (Rewards.getModuleCore().c().m().contains("General." + str2 + ".items." + str3 + ".model")) {
                            nbtData.setModel(Rewards.getModuleCore().c().m().getInt("General." + str2 + ".items." + str3 + ".model"));
                        }
                    } catch (Exception e3) {
                    }
                    GuiItemsData_fill guiItemsData_fill = new GuiItemsData_fill(new ArrayList(), false, false, false, false);
                    try {
                        if (Rewards.getModuleCore().c().m().contains("General." + str2 + ".items." + str3 + ".mimeslots")) {
                            if (Rewards.getModuleCore().c().m().getStringList("General." + str2 + ".items." + str3 + ".mimeslots").contains("ALL")) {
                                guiItemsData_fill.setAll(true);
                            } else if (Rewards.getModuleCore().c().m().getStringList("General." + str2 + ".items." + str3 + ".mimeslots").contains("TOP")) {
                                guiItemsData_fill.setTop(true);
                            } else if (Rewards.getModuleCore().c().m().getStringList("General." + str2 + ".items." + str3 + ".mimeslots").contains("BOTTOM")) {
                                guiItemsData_fill.setBottom(true);
                            } else if (Rewards.getModuleCore().c().m().getStringList("General." + str2 + ".items." + str3 + ".mimeslots").contains("BORDER")) {
                                guiItemsData_fill.setBorder(true);
                            } else {
                                guiItemsData_fill.setSlots(Rewards.getModuleCore().c().m().getIntegerList("General." + str2 + ".items." + str3 + ".mimeslots"));
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
                        map2.put(str3, new AddonGuiItemsData(str3, Rewards.getModuleCore().c().m().getString("General." + str2 + ".items." + str3 + ".clicksound"), Rewards.getModuleCore().c().m().getString("General." + str2 + ".items." + str3 + ".material"), Rewards.getModuleCore().c().m().getInt("General." + str2 + ".items." + str3 + ".amount"), Rewards.getModuleCore().c().m().getBoolean("General." + str2 + ".items." + str3 + ".glow"), string, stringList, Rewards.getModuleCore().c().m().getString("General." + str2 + ".items." + str3 + ".texture"), nbtData, i, guiItemsData_fill, arrayList2, Arrays.asList(new String[0])));
                    } catch (Exception e5) {
                        e5.printStackTrace();
                    }
                }
            }
            if (map2 != null && map2.size() > 0) {
                String str__getString_TdwX3J4K_16 = "Empty";
                try {
                    str__getString_TdwX3J4K_16 = enumConfiguration.getString(Lang.valueOf("General_" + str2 + "_title"));
                } catch (Exception e6) {
                }
                map.put(str2, new AddonGuiData(str2, str__getString_TdwX3J4K_16, Rewards.getModuleCore().c().m().getInt("General." + str2 + ".rows"), Rewards.getModuleCore().c().m().getInt("General." + str2 + ".pagesize"), Rewards.getModuleCore().c().m().getString("General." + str2 + ".opensound"), map2));
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
        String str = addonGuiItemsData.getMaterial().split(":")[0];
        ItemBuilder itemBuilderFrom = null;
        String text = Rewards.a().getClanAPI().parseText(uuid, addonGuiItemsData.getTexture());
        String text2 = Rewards.getModuleCore().i().parseText(uuid, Rewards.a().getClanAPI().parseText(uuid, str));
        if (0 == 0 && text2 != null && !text2.isEmpty()) {
            itemBuilderFrom = ItemBuilder.from(new ItemStack(Material.valueOf(text2), addonGuiItemsData.getAmount()));
        }
        if (text != null && !text.isEmpty()) {
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
                        itemBuilderFrom = itemStackItemStackFromBase64 == null ? ItemBuilder.from(Material.valueOf(Rewards.a().getLibAPI().getDefaultBanner())) : ItemBuilder.from(itemStackItemStackFromBase64);
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
        itemBuilderFrom.name(Rewards.a().getColorAPI().addMiniColor(Rewards.getModuleCore().i().parseText(uuid, Rewards.a().getHooksAPI().parsePapi(uuid, Rewards.a().getClanAPI().parseText(uuid, a(addonGuiItemsData.getName(), list))))));
        itemBuilderFrom.glow(addonGuiItemsData.isGlow());
        List<String> lore = addonGuiItemsData.getLore();
        if (lore != null && !lore.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < lore.size(); i++) {
                arrayList.add(Rewards.a().getColorAPI().addMiniColor(Rewards.getModuleCore().i().parseText(uuid, Rewards.a().getHooksAPI().parsePapi(uuid, Rewards.a().getClanAPI().parseText(uuid, a(lore.get(i), list))))));
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
        return this.f150a;
    }

    public HashMap<String, AddonGuiData> a(Player player) {
        if (player == null) {
            return d();
        }
        HashMap<String, AddonGuiData> map = this.b.get(Rewards.getModuleCore().c().a(Optional.of(player.getUniqueId())));
        return map != null ? map : d();
    }

    public me.module.rewards.manager.b.a e() {
        return this.d;
    }

    private static String __unused_1375() {
        return "EN";
    }

    private static String __unused_1376() {
        return "General";
    }

    private static String __unused_1377() {
        return "ALL";
    }

    private static String __unused_1378() {
        return "TOP";
    }

    private static String __unused_1379() {
        return "BOTTOM";
    }

    private static String __unused_1380() {
        return "BORDER";
    }

    private static String __unused_1381() {
        return "Empty";
    }

    private static String __unused_1382() {
        return "previous";
    }

    private static String __unused_1383() {
        return "next";
    }

    private static String __unused_1384() {
        return "back";
    }

    private static String __unused_1385() {
        return "prev";
    }

    private static String __unused_1386() {
        return "General_common_previous_name";
    }

    private static String __unused_1387() {
        return "General_common_previous_lore";
    }

    private static String __unused_1388() {
        return "fill";
    }

    private static String __unused_1389() {
        return "General_common_fill_name";
    }

    private static String __unused_1390() {
        return "General_common_fill_lore";
    }

    private static String __unused_1391() {
        return "Empty";
    }

    private static String __unused_1392() {
        return ":";
    }

    private static String __unused_1393() {
        return "material:";
    }

    private static String __unused_1394() {
        return "\\:";
    }

    private static String __unused_1395() {
        return "base64:";
    }

    private static String __unused_1396() {
        return "\\:";
    }

    private static String __unused_1397() {
        return "serialized:";
    }

    private static String __unused_1398() {
        return "\\:";
    }

    private static String __unused_1399() {
        return ":";
    }

    private static String __unused_1400() {
        return ":";
    }

    private static String __unused_1401() {
        return ";";
    }
}
