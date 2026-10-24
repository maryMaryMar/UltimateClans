package me.ulrich.clans.manager;

import com.google.common.collect.HashMultimap;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import me.ulrich.clans.Clans;
import me.ulrich.clans.data.GuiData;
import me.ulrich.clans.data.GuiItemsData;
import me.ulrich.clans.data.GuiItemsData_fill;
import me.ulrich.clans.data.NbtData;
import me.ulrich.clans.interfaces.ItemParseImplement;
import me.ulrich.clans.library.gui.builder.item.ItemBuilder;
import me.ulrich.clans.library.gui.guis.Gui;
import me.ulrich.clans.library.gui.guis.GuiItem;
import me.ulrich.clans.library.gui.guis.PaginatedGui;
import me.ulrich.clans.manager.EnumFiles.Gui_Lang;
import me.ulrich.clans.manager.gui.AdminExtensionGuiManager;
import me.ulrich.clans.manager.gui.AdminGuiManager;
import me.ulrich.clans.manager.gui.AdminModuleGuiManager;
import me.ulrich.clans.manager.gui.GeneralGuiManager;
import me.ulrich.clans.manager.gui.PaginationGui;
import me.ulrich.clans.manager.gui.ProfileGuiManager;
import me.ulrich.clans.manager.gui.SettingsGuiManager;
import me.ulrich.clans.manager.utils.Nbts;
import me.ulrich.clans.manager.utils.Serialize;
import me.ulrich.clans.manager.utils.VersionUtil;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/manager/lO8DsfpVA7lKO.class */
public class lO8DsfpVA7lKO {
    public GeneralGuiManager xtOheRiObl4QeAl;
    public PaginationGui zJnaNCVQSgEShq;
    public ProfileGuiManager CDW4Fj1iwdIXEOqWjiJSR;
    public SettingsGuiManager b4i2FbOkaKeg91LiAe6l;
    public AdminGuiManager p31abtwfBag2jhMH6K;
    public AdminExtensionGuiManager Un3NRLL6aWivTcbodkcK;
    public AdminModuleGuiManager lGGwXL678c4Kv7skJb5NiE;
    public Clans o1VU1x4DAlrEtGKZ3jAdhE;
    private static String P4vciW5DN4sVwdzmOZiU;
    private static volatile String cdJzRGV5DnZrgK;
    private static volatile String fD7pkbc1akvJlK;
    private static volatile String wEe1ml671AGuOus;
    private static String eVZk2EIfWlRBJjykT;
    private static volatile String M611jQrN95y7qwfPY8mm;
    private static String Ka8zCm5oNzw9dL;
    private static volatile String W4K17trPArBhkqaOtVmCG;
    private static String krasWIpVOGd5YsG0ln;
    private static volatile String X7hAnjIK3gmaAiWcEc4C;
    private static volatile String fGpzRgWo4HgZUg2vQR;
    private static String bWFlmJvYnok2oBC4;
    private static String PfLxnxSlgsFYP1AzyVtX0R;
    private static String dEVmDZ1ABJw6Dr;
    private static String in24qO56W3ExZRkMCfa;
    private static String e1SNqJivIVR8YsZTBzUdm;
    private static volatile String h5UPDNtUlVsvbDoGuUeAC6;
    private static String MfRw5w2ZQX14JxeSbaW;
    private static String xVld6fNr7rRCAwrE;
    private static String TIBEaiqywz8WApH1X4;
    private static String vaAIj4I8UPCVQjo1D;
    private static volatile String HwdJPq3BgBrkNtoI6;
    private static String T8bjcWwENNiCEhtO4H9;
    private static String f4cg6FeepTCe52t;
    private static String qMCDGf5paRyUKc;
    private static String Fj84B85tuSA43yat0;
    private static String RygmurTO67zoZs;
    private static String acEFKbDeg7xgoJrVVAmzW;
    private static volatile String fkbxHWXVITCe7LLjI1i;
    private static volatile String ibJjl7OYq9emnafaBjTS;
    private static String Z8kmEux19Izs6cXGJk3W;
    private static String veTZ5aGCV42KYs;
    private static volatile String aFc5yuCin9e7fuP;
    private static volatile String PXeMkcyWOopDaYz;
    private static String vFHaC6b10IboWBY6LXEyZ;
    private static volatile String NFJRgHCSvsWxvK7dV9A4;
    private static volatile String MfohR8eFZTFVVCmBW7fRK;
    private static volatile String FCeMHdJQ7MsAcWDynKev2;
    private static final byte[] QOVxQ8UU1lL0Wfh = {(byte) 214, (byte) 2, (byte) 120, (byte) 246, (byte) 195, (byte) 151, (byte) 51, (byte) 116, (byte) 224, (byte) 6, (byte) 53, (byte) 152, (byte) 213, (byte) 2, (byte) 109, (byte) 71};
    private static final byte[] oM3x1mIKypt4dBxfEJxyCT = {(byte) 82, (byte) 97, (byte) 117, (byte) 139, (byte) 205, (byte) 169, (byte) 162, (byte) 7, (byte) 197, (byte) 195, (byte) 194, (byte) 52, (byte) 183, (byte) 208, (byte) 49, (byte) 146};
    private static final byte[] gHRxFDpBCobaCe2QJ4 = {(byte) 71, (byte) 211, (byte) 71, (byte) 94, (byte) 149, (byte) 239, (byte) 209, (byte) 191, (byte) 231, (byte) 99, (byte) 77, (byte) 130, (byte) 198, (byte) 163, (byte) 42, (byte) 0};
    private static final byte[] S08HudtnkMi3gMjeQJBekD = {(byte) 198, (byte) 218, (byte) 90, (byte) 113, (byte) 110, (byte) 226, (byte) 129, (byte) 122, (byte) 48, (byte) 247, (byte) 241, (byte) 6, (byte) 11, (byte) 184, (byte) 29, (byte) 184};
    private static final byte[] edyx2DOpdplklL = {(byte) 29, (byte) 54, (byte) 53, (byte) 100, (byte) 98, (byte) 213, (byte) 178, (byte) 0, (byte) 246, (byte) 240, (byte) 90, (byte) 144, (byte) 157, (byte) 35, (byte) 117, (byte) 208};
    private static final byte[] H039LQfoxRTwHVras0f8Jd = {(byte) 82, (byte) 97, (byte) 117, (byte) 139, (byte) 205, (byte) 169, (byte) 162, (byte) 7, (byte) 197, (byte) 195, (byte) 194, (byte) 52, (byte) 183, (byte) 208, (byte) 49, (byte) 146};
    private static final byte[] dNFJIZtO2dru0ipsBbDG = {(byte) 216, (byte) 127, (byte) 120, (byte) 71, (byte) 79, (byte) 177, (byte) 224, (byte) 142, (byte) 63, (byte) 188, (byte) 247, (byte) 76, (byte) 13, (byte) 254, (byte) 252, (byte) 227};
    private static final byte[] DeQYKzQYEy0L6pgo = {(byte) 180, (byte) 6, (byte) 134, (byte) 186, (byte) 32, (byte) 48, (byte) 115, (byte) 152, (byte) 186, (byte) 19, (byte) 144, (byte) 48, (byte) 162, (byte) 95, (byte) 143, (byte) 203};
    private static final byte[] rdiO7nqVB4e1M0pRzCCDr6 = {(byte) 108, (byte) 162, (byte) 44, (byte) 181, (byte) 113, (byte) 217, (byte) 53, (byte) 227, (byte) 10, (byte) 25, (byte) 207, (byte) 16, (byte) 164, (byte) 204, (byte) 2, (byte) 234};
    private static final byte[] Lu9m0LYboM5J9a0eDEHsy = {(byte) 8, (byte) 211, (byte) 92, (byte) 51, (byte) 164, (byte) 203, (byte) 34, (byte) 154, (byte) 248, (byte) 7, (byte) 96, (byte) 56, (byte) 58, (byte) 86, (byte) 217, (byte) 108};
    private static final byte[] VjxGkYMXnCulo8zJR = {(byte) 140, (byte) 6, (byte) 47, (byte) 69, (byte) 43, (byte) 112, (byte) 84, (byte) 255, (byte) 38, (byte) 48, (byte) 183, (byte) 72, (byte) 238, (byte) 176, (byte) 200, (byte) 86};
    private static final byte[] rYCb3U6M8EfdN6iotmar6I = {(byte) 102, (byte) 140, (byte) 202, (byte) 73, (byte) 212, (byte) 149, (byte) 90, (byte) 152, (byte) 90, (byte) 55, (byte) 190, (byte) 116, (byte) 20, (byte) 74, (byte) 54, (byte) 150};
    private static final byte[] oXOquQSqzzYrNXPeq4c = {(byte) 39, (byte) 140, (byte) 131, (byte) 94, (byte) 32, (byte) 145, (byte) 105, (byte) 50, (byte) 1, (byte) 149, (byte) 245, (byte) 124, (byte) 106, (byte) 3, (byte) 164, (byte) 49};
    private static final byte[] WiLCRDp4CbQEzzjzzrXQ20 = {(byte) 31, (byte) 170, (byte) 244, (byte) 27, (byte) 54, (byte) 234, (byte) 244, (byte) 145, (byte) 254, (byte) 175, (byte) 108, (byte) 73, (byte) 158, (byte) 159, (byte) 108, (byte) 75};
    private static final byte[] sG5Fo2BRN9ilc9J = {(byte) 200, (byte) 212, (byte) 39, (byte) 144, (byte) 59, (byte) 127, (byte) 93, (byte) 39, (byte) 140, (byte) 241, (byte) 48, (byte) 22, (byte) 91, (byte) 185, (byte) 30, (byte) 188};
    private static final byte[] mXE04P2D3Pg9Wniwwb1Cl = {(byte) 108, (byte) 184, (byte) 194, (byte) 194, (byte) 166, (byte) 146, (byte) 98, (byte) 173, (byte) 51, (byte) 129, (byte) 170, (byte) 197, (byte) 243, (byte) 189, (byte) 211, (byte) 166};
    private static final byte[] gNSgsjnJUCM3eot = {(byte) 54, (byte) 134, (byte) 71, (byte) 252, (byte) 181, (byte) 155, (byte) 43, (byte) 21, (byte) 0, (byte) 78, (byte) 98, (byte) 200, (byte) 74, (byte) 131, (byte) 190, (byte) 69};
    private static final byte[] UnAYM5hfPwSjyFzIU1Zlog = {(byte) 108, (byte) 162, (byte) 44, (byte) 181, (byte) 113, (byte) 217, (byte) 53, (byte) 227, (byte) 10, (byte) 25, (byte) 207, (byte) 16, (byte) 164, (byte) 204, (byte) 2, (byte) 234};
    private static final byte[] VcfDUCT6bF0MTHZPXiy = {(byte) 8, (byte) 211, (byte) 92, (byte) 51, (byte) 164, (byte) 203, (byte) 34, (byte) 154, (byte) 248, (byte) 7, (byte) 96, (byte) 56, (byte) 58, (byte) 86, (byte) 217, (byte) 108};
    private static final byte[] c6YsTbcy8f0r6lv7f4 = {(byte) 140, (byte) 6, (byte) 47, (byte) 69, (byte) 43, (byte) 112, (byte) 84, (byte) 255, (byte) 38, (byte) 48, (byte) 183, (byte) 72, (byte) 238, (byte) 176, (byte) 200, (byte) 86};
    private static final byte[] Bo2lO4XSgRY5vbB04 = {(byte) 141, (byte) 18, (byte) 252, (byte) 163, (byte) 62, (byte) 19, (byte) 106, (byte) 83, (byte) 148, (byte) 108, (byte) 216, (byte) 244, (byte) 150, (byte) 156, (byte) 177, (byte) 125, (byte) 157, (byte) 34, (byte) 120, (byte) 184, (byte) 126, (byte) 97, (byte) 135, (byte) 210, (byte) 86, (byte) 209, (byte) 56, (byte) 53, (byte) 46, (byte) 245, (byte) 151, (byte) 3};
    private static final byte[] GpjjgZo2JwvkkvsiDmP = {(byte) 250, (byte) 195, (byte) 80, (byte) 239, (byte) 180, (byte) 157, (byte) 151, (byte) 184, (byte) 196, (byte) 65, (byte) 11, (byte) 106, (byte) 135, (byte) 178, (byte) 190, (byte) 196};
    private final ConcurrentHashMap<String, Map<String, String>> vVo2VUvxrriklPdRxI = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, Map<String, List<String>>> Fc3p9FhCjSD1k5Ra4 = new ConcurrentHashMap<>();
    public ConcurrentHashMap<String, HashMap<String, GuiData>> v8qP8fE86HMhvNuYPFjqY = new ConcurrentHashMap<>();
    public ConcurrentHashMap<String, GuiData> jBUuLP0sWwaPyPOmogdX7l = new ConcurrentHashMap<>();
    public ConcurrentHashMap<String, GuiData> ZwrsrwOCXRUscW6Q = new ConcurrentHashMap<>();
    public List<Player> iZTqZaRK5UGoe0Z = new CopyOnWriteArrayList();

    public lO8DsfpVA7lKO(Clans clans) {
        this.o1VU1x4DAlrEtGKZ3jAdhE = clans;
        this.xtOheRiObl4QeAl = new GeneralGuiManager(clans);
        this.zJnaNCVQSgEShq = new PaginationGui(clans);
        this.CDW4Fj1iwdIXEOqWjiJSR = new ProfileGuiManager(clans);
        this.b4i2FbOkaKeg91LiAe6l = new SettingsGuiManager(clans);
        this.p31abtwfBag2jhMH6K = new AdminGuiManager(clans);
        this.Un3NRLL6aWivTcbodkcK = new AdminExtensionGuiManager(clans);
        this.lGGwXL678c4Kv7skJb5NiE = new AdminModuleGuiManager(clans);
        jBUuLP0sWwaPyPOmogdX7l();
    }

    public ItemBuilder v8qP8fE86HMhvNuYPFjqY(ItemBuilder itemBuilder, boolean z) {
        ItemStack itemStackClone = itemBuilder.build().clone();
        ItemMeta itemMeta = itemStackClone.getItemMeta();
        if (itemMeta != null) {
            try {
                itemMeta.getClass().getMethod(ctMQBO3VP6aw5omN(), Boolean.TYPE).invoke(itemMeta, Boolean.valueOf(z));
            } catch (NoSuchMethodException e) {
            } catch (Exception e2) {
            }
            itemStackClone.setItemMeta(itemMeta);
        }
        return ItemBuilder.from(itemStackClone);
    }

    public ItemStack v8qP8fE86HMhvNuYPFjqY(ItemStack itemStack, ItemFlag itemFlag) {
        ItemMeta itemMeta = itemStack.getItemMeta();
        if (itemMeta.getAttributeModifiers() == null) {
            itemMeta.setAttributeModifiers(HashMultimap.create());
        }
        itemMeta.addItemFlags(new ItemFlag[]{itemFlag});
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    public void v8qP8fE86HMhvNuYPFjqY() {
        new ArrayList<Player>(xtOheRiObl4QeAl()).forEach(this::v8qP8fE86HMhvNuYPFjqY);
    }

    public boolean v8qP8fE86HMhvNuYPFjqY(Player player) {
        if (player == null || !xtOheRiObl4QeAl().contains(player)) {
            return false;
        }
        xtOheRiObl4QeAl().remove(player);
        if (!player.isOnline()) {
            return false;
        }
        z8MICAC4yDYZiO taskManager = this.o1VU1x4DAlrEtGKZ3jAdhE.getTaskManager();
        Objects.requireNonNull(player);
        taskManager.v8qP8fE86HMhvNuYPFjqY((Entity) player, player::closeInventory);
        return true;
    }

    public void jBUuLP0sWwaPyPOmogdX7l() {
        v8qP8fE86HMhvNuYPFjqY();
        try {
            Nz8xKv4RePC2a0f0iuYU().clear();
        } catch (Exception e) {
        }
        this.o1VU1x4DAlrEtGKZ3jAdhE.getFiles().hqTnbBoUmxDUXvki().forEach(str -> {
            v8qP8fE86HMhvNuYPFjqY(CDW4Fj1iwdIXEOqWjiJSR().getFiles().V3DAV3orG0so43Del8NdO(), str, false);
            v8qP8fE86HMhvNuYPFjqY(CDW4Fj1iwdIXEOqWjiJSR().getFiles().Y9J1Kd6E1T8FcF(), str, true);
        });
        ZwrsrwOCXRUscW6Q();
        this.o1VU1x4DAlrEtGKZ3jAdhE.getLogger().info("Loaded " + Nz8xKv4RePC2a0f0iuYU().size() + " gui languages menus.");
    }

    public void v8qP8fE86HMhvNuYPFjqY(FileConfiguration fileConfiguration, String str) {
        v8qP8fE86HMhvNuYPFjqY(fileConfiguration, str, false);
    }

    public void v8qP8fE86HMhvNuYPFjqY(FileConfiguration fileConfiguration, String str, boolean z) {
        String string;
        List<String> stringList;
        KG0dzbdBSFtZuuPbyPn.UsEbiuprSHpNw3qjITfH usEbiuprSHpNw3qjITfHZwrsrwOCXRUscW6Q = this.o1VU1x4DAlrEtGKZ3jAdhE.getFiles().ZwrsrwOCXRUscW6Q(str);
        if (usEbiuprSHpNw3qjITfHZwrsrwOCXRUscW6Q.ZwrsrwOCXRUscW6Q()) {
            HashMap<String, GuiData> orDefault = Nz8xKv4RePC2a0f0iuYU().getOrDefault(str, new HashMap<>());
            ConfigurationSection configurationSection = fileConfiguration.getConfigurationSection(MqFAza39AFiqCPniaAt());
            if (configurationSection == null) {
                return;
            }
            for (String str2 : configurationSection.getKeys(false)) {
                if (str2.toLowerCase().startsWith(Go87ILce4sQ5DSFRoP8VF()) == z) {
                    try {
                        HashMap map = new HashMap();
                        for (String str3 : fileConfiguration.getConfigurationSection("General." + str2 + ".items").getKeys(false)) {
                            if (fileConfiguration.getBoolean("General." + str2 + ".items." + str3 + ".enabled", true)) {
                                List stringList2 = fileConfiguration.getStringList("General." + str2 + ".items." + str3 + ".nbt.string");
                                int i = fileConfiguration.getInt("General." + str2 + ".items." + str3 + ".model", 0);
                                int i2 = fileConfiguration.getInt("General." + str2 + ".items." + str3 + ".slot", -1);
                                List stringList3 = fileConfiguration.getStringList("General." + str2 + ".items." + str3 + ".click_action");
                                NbtData nbtData = new NbtData(stringList2, i);
                                GuiItemsData_fill guiItemsData_fill = new GuiItemsData_fill(new ArrayList(), false, false, false, false);
                                if (fileConfiguration.contains("General." + str2 + ".items." + str3 + ".mimeslots")) {
                                    List stringList4 = fileConfiguration.getStringList("General." + str2 + ".items." + str3 + ".mimeslots");
                                    if (stringList4.contains(IsFnbTX6sIWECSGO4())) {
                                        guiItemsData_fill.setAll(true);
                                    } else if (stringList4.contains(RACw6qg1ZItqqjUeL())) {
                                        guiItemsData_fill.setTop(true);
                                    } else if (stringList4.contains(RCOv3RlVa49kDVBZH0())) {
                                        guiItemsData_fill.setBottom(true);
                                    } else if (stringList4.contains(KFFPWxzKN9bB03())) {
                                        guiItemsData_fill.setBorder(true);
                                    } else {
                                        guiItemsData_fill.setSlots(fileConfiguration.getIntegerList("General." + str2 + ".items." + str3 + ".mimeslots"));
                                    }
                                }
                                exCmAR6sLhSocnLfCG6L();
                                new ArrayList();
                                try {
                                    if (str3.equalsIgnoreCase(YFxOWDgIZtjh5ltBvF()) || str3.equalsIgnoreCase(brgFvr9qberD1b()) || str3.equalsIgnoreCase(foRM1KsDCFaRp6t())) {
                                        string = usEbiuprSHpNw3qjITfHZwrsrwOCXRUscW6Q.jBUuLP0sWwaPyPOmogdX7l().getString(Gui_Lang.valueOf("General_common_" + str3 + "_name"));
                                        stringList = usEbiuprSHpNw3qjITfHZwrsrwOCXRUscW6Q.jBUuLP0sWwaPyPOmogdX7l().getStringList(Gui_Lang.valueOf("General_common_" + str3 + "_lore"));
                                    } else if (str3.equalsIgnoreCase(XTrXxxaIiK1tEAgR())) {
                                        string = usEbiuprSHpNw3qjITfHZwrsrwOCXRUscW6Q.jBUuLP0sWwaPyPOmogdX7l().getString(Gui_Lang.valueOf(TS4SPnzE8WuJpiYckYpv()));
                                        stringList = usEbiuprSHpNw3qjITfHZwrsrwOCXRUscW6Q.jBUuLP0sWwaPyPOmogdX7l().getStringList(Gui_Lang.valueOf(gQdAaAteAb4z58EW()));
                                    } else if (str3.startsWith(LiNTEye2o6iaJvQ19xsg())) {
                                        string = usEbiuprSHpNw3qjITfHZwrsrwOCXRUscW6Q.jBUuLP0sWwaPyPOmogdX7l().getString(Gui_Lang.valueOf(vLHarvSKB2RufQGb4ela()));
                                        stringList = usEbiuprSHpNw3qjITfHZwrsrwOCXRUscW6Q.jBUuLP0sWwaPyPOmogdX7l().getStringList(Gui_Lang.valueOf(KQRnpHYJA4u2Zv()));
                                    } else {
                                        string = usEbiuprSHpNw3qjITfHZwrsrwOCXRUscW6Q.jBUuLP0sWwaPyPOmogdX7l().getString(Gui_Lang.valueOf("General_" + str2 + "_items_" + str3 + "_name"));
                                        stringList = usEbiuprSHpNw3qjITfHZwrsrwOCXRUscW6Q.jBUuLP0sWwaPyPOmogdX7l().getStringList(Gui_Lang.valueOf("General_" + str2 + "_items_" + str3 + "_lore"));
                                    }
                                    map.put(str3, new GuiItemsData(str3, fileConfiguration.getString("General." + str2 + ".items." + str3 + ".clicksound"), fileConfiguration.getString("General." + str2 + ".items." + str3 + ".material"), fileConfiguration.getInt("General." + str2 + ".items." + str3 + ".amount"), fileConfiguration.getBoolean("General." + str2 + ".items." + str3 + ".glow"), string, stringList, fileConfiguration.getString("General." + str2 + ".items." + str3 + ".texture"), nbtData, i2, guiItemsData_fill, stringList3, new ArrayList()));
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                        if (!map.isEmpty()) {
                            orDefault.put(str2, new GuiData(str2, usEbiuprSHpNw3qjITfHZwrsrwOCXRUscW6Q.jBUuLP0sWwaPyPOmogdX7l().getString(Gui_Lang.valueOf("General_" + str2 + "_title")), fileConfiguration.getInt("General." + str2 + ".rows"), fileConfiguration.getInt("General." + str2 + ".pagesize"), fileConfiguration.getString("General." + str2 + ".opensound"), map));
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }
            Nz8xKv4RePC2a0f0iuYU().put(str, orDefault);
        }
    }

    public void ZwrsrwOCXRUscW6Q() {
        Set<String> keys;
        try {
            zJnaNCVQSgEShq().clear();
        } catch (Exception e) {
        }
        if (CDW4Fj1iwdIXEOqWjiJSR().getFiles().V3DAV3orG0so43Del8NdO().getConfigurationSection(ZjjOkcIoedWiM1aoW()) == null || (keys = CDW4Fj1iwdIXEOqWjiJSR().getFiles().V3DAV3orG0so43Del8NdO().getConfigurationSection(DCm2ZulikL23U2Co()).getKeys(false)) == null) {
            return;
        }
        for (String str : keys) {
            HashMap map = new HashMap();
            for (String str2 : CDW4Fj1iwdIXEOqWjiJSR().getFiles().V3DAV3orG0so43Del8NdO().getConfigurationSection("Insertion." + str).getKeys(false)) {
                for (String str3 : CDW4Fj1iwdIXEOqWjiJSR().getFiles().V3DAV3orG0so43Del8NdO().getConfigurationSection("Insertion." + str + "." + str2 + ".items").getKeys(false)) {
                    List arrayList = new ArrayList();
                    int i = 0;
                    try {
                        if (CDW4Fj1iwdIXEOqWjiJSR().getFiles().V3DAV3orG0so43Del8NdO().contains("Insertion." + str + "." + str2 + ".items." + str3 + ".nbt.string") && !CDW4Fj1iwdIXEOqWjiJSR().getFiles().V3DAV3orG0so43Del8NdO().getStringList("Insertion." + str + "." + str2 + ".items." + str3 + ".nbt.string").isEmpty()) {
                            arrayList = CDW4Fj1iwdIXEOqWjiJSR().getFiles().V3DAV3orG0so43Del8NdO().getStringList("Insertion." + str + "." + str2 + ".items." + str3 + ".nbt.string");
                        }
                    } catch (Exception e2) {
                    }
                    try {
                        if (CDW4Fj1iwdIXEOqWjiJSR().getFiles().V3DAV3orG0so43Del8NdO().contains("Insertion." + str + "." + str2 + ".items." + str3 + ".model") && CDW4Fj1iwdIXEOqWjiJSR().getFiles().V3DAV3orG0so43Del8NdO().getInt("Insertion." + str + "." + str2 + ".items." + str3 + ".model") > 0) {
                            i = CDW4Fj1iwdIXEOqWjiJSR().getFiles().V3DAV3orG0so43Del8NdO().getInt("Insertion." + str + "." + str2 + ".items." + str3 + ".model");
                        }
                    } catch (Exception e3) {
                    }
                    NbtData nbtData = new NbtData(arrayList, i);
                    List arrayList2 = new ArrayList();
                    try {
                        arrayList2 = CDW4Fj1iwdIXEOqWjiJSR().getFiles().V3DAV3orG0so43Del8NdO().getStringList("Insertion." + str + "." + str2 + ".items." + str3 + ".click_action");
                    } catch (Exception e4) {
                    }
                    int i2 = -1;
                    try {
                        i2 = CDW4Fj1iwdIXEOqWjiJSR().getFiles().V3DAV3orG0so43Del8NdO().getInt("Insertion." + str + "." + str2 + ".items." + str3 + ".slot");
                    } catch (Exception e5) {
                    }
                    GuiItemsData_fill guiItemsData_fill = new GuiItemsData_fill(new ArrayList(), false, false, false, false);
                    try {
                        if (CDW4Fj1iwdIXEOqWjiJSR().getFiles().V3DAV3orG0so43Del8NdO().contains("Insertion." + str + "." + str2 + ".items." + str3 + ".mimeslots")) {
                            if (CDW4Fj1iwdIXEOqWjiJSR().getFiles().V3DAV3orG0so43Del8NdO().getStringList("Insertion." + str + "." + str2 + ".items." + str3 + ".mimeslots").contains(p1d9DDRjlnzy5cp7a())) {
                                guiItemsData_fill.setAll(true);
                            } else if (CDW4Fj1iwdIXEOqWjiJSR().getFiles().V3DAV3orG0so43Del8NdO().getStringList("Insertion." + str + "." + str2 + ".items." + str3 + ".mimeslots").contains(ELGCqI3wvBtGdhf())) {
                                guiItemsData_fill.setTop(true);
                            } else if (CDW4Fj1iwdIXEOqWjiJSR().getFiles().V3DAV3orG0so43Del8NdO().getStringList("Insertion." + str + "." + str2 + ".items." + str3 + ".mimeslots").contains(pUgjnUKaiLXTl6rfT8JpZe())) {
                                guiItemsData_fill.setBottom(true);
                            } else if (CDW4Fj1iwdIXEOqWjiJSR().getFiles().V3DAV3orG0so43Del8NdO().getStringList("Insertion." + str + "." + str2 + ".items." + str3 + ".mimeslots").contains(XKVBLs2usRhtbFF0mjn0mn())) {
                                guiItemsData_fill.setBorder(true);
                            } else {
                                guiItemsData_fill.setSlots(CDW4Fj1iwdIXEOqWjiJSR().getFiles().V3DAV3orG0so43Del8NdO().getIntegerList("Insertion." + str + "." + str2 + ".items." + str3 + ".mimeslots"));
                            }
                        }
                    } catch (Exception e6) {
                        e6.printStackTrace();
                    }
                    map.put(str3, new GuiItemsData(str2, CDW4Fj1iwdIXEOqWjiJSR().getFiles().V3DAV3orG0so43Del8NdO().getString("Insertion." + str + "." + str2 + ".items." + str3 + ".clicksound"), CDW4Fj1iwdIXEOqWjiJSR().getFiles().V3DAV3orG0so43Del8NdO().getString("Insertion." + str + "." + str2 + ".items." + str3 + ".material"), CDW4Fj1iwdIXEOqWjiJSR().getFiles().V3DAV3orG0so43Del8NdO().getInt("Insertion." + str + "." + str2 + ".items." + str3 + ".amount"), CDW4Fj1iwdIXEOqWjiJSR().getFiles().V3DAV3orG0so43Del8NdO().getBoolean("Insertion." + str + "." + str2 + ".items." + str3 + ".glow"), CDW4Fj1iwdIXEOqWjiJSR().getFiles().V3DAV3orG0so43Del8NdO().getString("Insertion." + str + "." + str2 + ".items." + str3 + ".name"), CDW4Fj1iwdIXEOqWjiJSR().getFiles().V3DAV3orG0so43Del8NdO().getStringList("Insertion." + str + "." + str2 + ".items." + str3 + ".lore"), CDW4Fj1iwdIXEOqWjiJSR().getFiles().V3DAV3orG0so43Del8NdO().getString("Insertion." + str + "." + str2 + ".items." + str3 + ".texture"), nbtData, i2, guiItemsData_fill, arrayList2, Arrays.asList(new String[0])));
                }
            }
            if (map != null && map.size() > 0) {
                zJnaNCVQSgEShq().put(str, new GuiData(str, null, 0, 0, null, map));
            }
        }
    }

    public void v8qP8fE86HMhvNuYPFjqY(String str, String str2, Map<String, String> map, Map<String, List<String>> map2) {
        if (str == null || str2 == null) {
            return;
        }
        String strV8qP8fE86HMhvNuYPFjqY = v8qP8fE86HMhvNuYPFjqY(str, str2);
        if (map == null || map.isEmpty()) {
            this.vVo2VUvxrriklPdRxI.remove(strV8qP8fE86HMhvNuYPFjqY);
        } else {
            this.vVo2VUvxrriklPdRxI.put(strV8qP8fE86HMhvNuYPFjqY, new HashMap(map));
        }
        if (map2 == null || map2.isEmpty()) {
            this.Fc3p9FhCjSD1k5Ra4.remove(strV8qP8fE86HMhvNuYPFjqY);
            return;
        }
        HashMap map3 = new HashMap();
        map2.forEach((str3, list) -> {
            map3.put(str3, list != null ? new ArrayList(list) : new ArrayList());
        });
        this.Fc3p9FhCjSD1k5Ra4.put(strV8qP8fE86HMhvNuYPFjqY, map3);
    }

    private String v8qP8fE86HMhvNuYPFjqY(String str, String str2) {
        return str + "::" + str2;
    }

    private void v8qP8fE86HMhvNuYPFjqY(String str, String str2, GuiItemsData guiItemsData, UUID uuid) {
        if (guiItemsData == null || str == null || str2 == null) {
            return;
        }
        String strV8qP8fE86HMhvNuYPFjqY = v8qP8fE86HMhvNuYPFjqY(str, str2);
        Map<String, String> map = this.vVo2VUvxrriklPdRxI.get(strV8qP8fE86HMhvNuYPFjqY);
        Map<String, List<String>> map2 = this.Fc3p9FhCjSD1k5Ra4.get(strV8qP8fE86HMhvNuYPFjqY);
        if ((map == null || map.isEmpty()) && (map2 == null || map2.isEmpty())) {
            return;
        }
        String strV8qP8fE86HMhvNuYPFjqY2 = this.o1VU1x4DAlrEtGKZ3jAdhE.getFiles().v8qP8fE86HMhvNuYPFjqY(Optional.ofNullable(uuid));
        if (map != null) {
            String str3 = map.get(strV8qP8fE86HMhvNuYPFjqY2);
            if (str3 == null) {
                str3 = map.get(TaqkQ1ZAZRYK8557x());
            }
            if (str3 != null) {
                guiItemsData.setName(str3);
            }
        }
        if (map2 != null) {
            List<String> list = map2.get(strV8qP8fE86HMhvNuYPFjqY2);
            if (list == null) {
                list = map2.get(f8pI1PEP1UqlZYS33());
            }
            if (list != null) {
                guiItemsData.setLore(new ArrayList(list));
            }
        }
    }

    public void v8qP8fE86HMhvNuYPFjqY(Gui gui, String str, String str2, Player player) {
        if (zJnaNCVQSgEShq().containsKey(str)) {
            zJnaNCVQSgEShq().get(str).getItems().entrySet().iterator().forEachRemaining(entry -> {
                ItemBuilder itemBuilderV8qP8fE86HMhvNuYPFjqY;
                GuiItemsData guiItemsDataM427clone = ((GuiItemsData) entry.getValue()).m427clone();
                v8qP8fE86HMhvNuYPFjqY(str, (String) entry.getKey(), guiItemsDataM427clone, player.getUniqueId());
                if (!guiItemsDataM427clone.getId().equals(str2) || (itemBuilderV8qP8fE86HMhvNuYPFjqY = v8qP8fE86HMhvNuYPFjqY(guiItemsDataM427clone, player.getUniqueId(), (List<String>) null)) == null) {
                    return;
                }
                this.o1VU1x4DAlrEtGKZ3jAdhE.getGuiManager().v8qP8fE86HMhvNuYPFjqY(gui, guiItemsDataM427clone, itemBuilderV8qP8fE86HMhvNuYPFjqY.asGuiItem(inventoryClickEvent -> {
                    try {
                        if (guiItemsDataM427clone.getClickSound() != null && !guiItemsDataM427clone.getClickSound().isEmpty()) {
                            this.o1VU1x4DAlrEtGKZ3jAdhE.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsDataM427clone.getClickSound());
                        }
                    } catch (Exception e) {
                    }
                    inventoryClickEvent.setCancelled(true);
                    if (guiItemsDataM427clone.getLeftActions().isEmpty() || guiItemsDataM427clone.getLeftActions() == null) {
                        return;
                    }
                    for (String str3 : guiItemsDataM427clone.getLeftActions()) {
                        if (str3.equalsIgnoreCase(LJeRIcl1s8ULdKjH())) {
                            this.o1VU1x4DAlrEtGKZ3jAdhE.getTaskManager().xtOheRiObl4QeAl().runTask((Entity) player, () -> {
                                player.closeInventory();
                            });
                        } else {
                            player.chat(CDW4Fj1iwdIXEOqWjiJSR().getClanManager().jBUuLP0sWwaPyPOmogdX7l(player.getUniqueId(), str3));
                        }
                    }
                }));
            });
        }
    }

    public void v8qP8fE86HMhvNuYPFjqY(PaginatedGui paginatedGui, String str, String str2, Player player) {
        if (zJnaNCVQSgEShq().containsKey(str)) {
            zJnaNCVQSgEShq().get(str).getItems().entrySet().iterator().forEachRemaining(entry -> {
                ItemBuilder itemBuilderV8qP8fE86HMhvNuYPFjqY;
                GuiItemsData guiItemsDataM427clone = ((GuiItemsData) entry.getValue()).m427clone();
                v8qP8fE86HMhvNuYPFjqY(str, (String) entry.getKey(), guiItemsDataM427clone, player.getUniqueId());
                if (!guiItemsDataM427clone.getId().equals(str2) || (itemBuilderV8qP8fE86HMhvNuYPFjqY = v8qP8fE86HMhvNuYPFjqY(guiItemsDataM427clone, player.getUniqueId(), (List<String>) null)) == null) {
                    return;
                }
                paginatedGui.setItem(guiItemsDataM427clone.getSlot(), itemBuilderV8qP8fE86HMhvNuYPFjqY.asGuiItem(inventoryClickEvent -> {
                    try {
                        if (guiItemsDataM427clone.getClickSound() != null && !guiItemsDataM427clone.getClickSound().isEmpty()) {
                            this.o1VU1x4DAlrEtGKZ3jAdhE.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsDataM427clone.getClickSound());
                        }
                    } catch (Exception e) {
                    }
                    inventoryClickEvent.setCancelled(true);
                    if (guiItemsDataM427clone.getLeftActions().isEmpty() || guiItemsDataM427clone.getLeftActions() == null) {
                        return;
                    }
                    for (String str3 : guiItemsDataM427clone.getLeftActions()) {
                        if (str3.equalsIgnoreCase(C03F0VsqcTGGao())) {
                            this.o1VU1x4DAlrEtGKZ3jAdhE.getTaskManager().xtOheRiObl4QeAl().runTask((Entity) player, () -> {
                                player.closeInventory();
                            });
                        } else {
                            player.chat(CDW4Fj1iwdIXEOqWjiJSR().getClanManager().jBUuLP0sWwaPyPOmogdX7l(player.getUniqueId(), str3));
                        }
                    }
                }));
            });
        }
    }

    public ItemBuilder v8qP8fE86HMhvNuYPFjqY(GuiItemsData guiItemsData, UUID uuid, List<String> list) {
        ItemBuilder itemBuilderV8qP8fE86HMhvNuYPFjqY = v8qP8fE86HMhvNuYPFjqY(guiItemsData);
        if (itemBuilderV8qP8fE86HMhvNuYPFjqY == null) {
            return null;
        }
        return v8qP8fE86HMhvNuYPFjqY(guiItemsData, itemBuilderV8qP8fE86HMhvNuYPFjqY.build(), uuid, list);
    }

    public ItemBuilder v8qP8fE86HMhvNuYPFjqY(GuiItemsData guiItemsData, ItemStack itemStack, UUID uuid, List<String> list) {
        try {
            ItemBuilder itemBuilderFrom = itemStack != null ? ItemBuilder.from(itemStack) : v8qP8fE86HMhvNuYPFjqY(guiItemsData);
            if (itemBuilderFrom == null) {
                return null;
            }
            ItemBuilder itemBuilderV8qP8fE86HMhvNuYPFjqY = v8qP8fE86HMhvNuYPFjqY(guiItemsData, Optional.ofNullable(uuid), itemBuilderFrom);
            v8qP8fE86HMhvNuYPFjqY(guiItemsData, itemBuilderV8qP8fE86HMhvNuYPFjqY, uuid, list);
            ItemBuilder itemBuilderV8qP8fE86HMhvNuYPFjqY2 = v8qP8fE86HMhvNuYPFjqY(guiItemsData, itemBuilderV8qP8fE86HMhvNuYPFjqY);
            v8qP8fE86HMhvNuYPFjqY(itemBuilderV8qP8fE86HMhvNuYPFjqY2);
            return itemBuilderV8qP8fE86HMhvNuYPFjqY2;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ItemBuilder v8qP8fE86HMhvNuYPFjqY(GuiItemsData guiItemsData) {
        try {
            String material = guiItemsData.getMaterial();
            if (material == null || guiItemsData.getMaterial().isEmpty()) {
                material = TlMa319cJQkX4DI9H();
            }
            return ItemBuilder.from(new ItemStack(Material.valueOf(material), guiItemsData.getAmount()));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ItemBuilder v8qP8fE86HMhvNuYPFjqY(GuiItemsData guiItemsData, ItemBuilder itemBuilder) {
        ItemStack item;
        if (guiItemsData.getNbt() == null) {
            return itemBuilder;
        }
        boolean z = false;
        if (guiItemsData.getNbt().getString() != null) {
            Iterator<String> it = guiItemsData.getNbt().getString().iterator();
            while (it.hasNext()) {
                String[] strArrSplit = it.next().split(CsmGF5OsicZT1Jy(), 2);
                String strTrim = strArrSplit[0].trim();
                String strTrim2 = strArrSplit.length > 1 ? strArrSplit[1].trim() : "";
                if (strTrim.equalsIgnoreCase(kSiv2VZYOzyGdN1bZSjR7o())) {
                    z = true;
                } else {
                    Optional<ItemParseImplement> optionalJBUuLP0sWwaPyPOmogdX7l = Clans.getClanCore().getIntegrationManager().jBUuLP0sWwaPyPOmogdX7l(strTrim);
                    itemBuilder = (!optionalJBUuLP0sWwaPyPOmogdX7l.isPresent() || (item = optionalJBUuLP0sWwaPyPOmogdX7l.get().getItem(strTrim2)) == null) ? ItemBuilder.from(new Nbts().solveNbt(itemBuilder.build(), strTrim, strTrim2)) : ItemBuilder.from(item);
                }
            }
        }
        if (guiItemsData.getNbt().getModel() > 0) {
            itemBuilder.model(guiItemsData.getNbt().getModel());
        }
        if (z) {
            itemBuilder = v8qP8fE86HMhvNuYPFjqY(itemBuilder, true);
        }
        return itemBuilder;
    }

    public void v8qP8fE86HMhvNuYPFjqY(GuiItemsData guiItemsData, ItemBuilder itemBuilder, UUID uuid, List<String> list) {
        itemBuilder.name(this.o1VU1x4DAlrEtGKZ3jAdhE.getColorManager().ZwrsrwOCXRUscW6Q(this.o1VU1x4DAlrEtGKZ3jAdhE.getHooksManager().parsePapi(uuid, this.o1VU1x4DAlrEtGKZ3jAdhE.getClanManager().jBUuLP0sWwaPyPOmogdX7l(uuid, new jBWyXxi9EyWxcPiz(this.o1VU1x4DAlrEtGKZ3jAdhE).v8qP8fE86HMhvNuYPFjqY(guiItemsData.getName(), list)))));
        itemBuilder.glow(guiItemsData.isGlow());
        if (guiItemsData.getLore() == null || guiItemsData.getLore().isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = guiItemsData.getLore().iterator();
        while (it.hasNext()) {
            arrayList.add(this.o1VU1x4DAlrEtGKZ3jAdhE.getColorManager().ZwrsrwOCXRUscW6Q(this.o1VU1x4DAlrEtGKZ3jAdhE.getHooksManager().parsePapi(uuid, this.o1VU1x4DAlrEtGKZ3jAdhE.getClanManager().jBUuLP0sWwaPyPOmogdX7l(uuid, new jBWyXxi9EyWxcPiz(this.o1VU1x4DAlrEtGKZ3jAdhE).v8qP8fE86HMhvNuYPFjqY(it.next(), list)))));
        }
        itemBuilder.lore(arrayList);
    }

    public void v8qP8fE86HMhvNuYPFjqY(ItemBuilder itemBuilder) {
        ItemStack itemStackBuild = itemBuilder.build();
        if ((!VersionUtil.is(VersionUtil.VersionEnum.V120) || VersionUtil.BUILD_VERSION.intValue() < 3) && !VersionUtil.isAbove(VersionUtil.VersionEnum.V121)) {
            try {
                itemBuilder.flags(ItemFlag.HIDE_ATTRIBUTES);
            } catch (Exception e) {
            }
            try {
                itemBuilder.flags(ItemFlag.HIDE_ENCHANTS);
            } catch (Exception e2) {
            }
        } else {
            try {
                itemStackBuild = v8qP8fE86HMhvNuYPFjqY(itemStackBuild, ItemFlag.HIDE_ATTRIBUTES);
            } catch (Exception e3) {
            }
            try {
                itemStackBuild = v8qP8fE86HMhvNuYPFjqY(itemStackBuild, ItemFlag.HIDE_ENCHANTS);
            } catch (Exception e4) {
            }
        }
        ItemBuilder.from(itemStackBuild);
    }

    public ItemBuilder v8qP8fE86HMhvNuYPFjqY(GuiItemsData guiItemsData, Optional<UUID> optional, ItemBuilder itemBuilder) {
        String texture = guiItemsData.getTexture();
        if (texture == null || texture.isEmpty() || texture.equalsIgnoreCase(NANgnSLki3ePGc1x())) {
            return itemBuilder;
        }
        if (optional.isPresent()) {
            texture = CDW4Fj1iwdIXEOqWjiJSR().getClanManager().jBUuLP0sWwaPyPOmogdX7l(optional.get(), texture);
        }
        try {
            if (texture.startsWith(BbaC7ffBfUNT1bu81hsuM())) {
                itemBuilder = ItemBuilder.from(new ItemStack(Material.valueOf(texture.split(IXdwpJ39tFmO1zgCrjo())[1]), 1));
            } else if (texture.startsWith(J0ozNl31WWtsuWBTd())) {
                String strSubstring = texture.substring(hqn2y1T1tN1pS2nRfwL().length());
                if (!strSubstring.isEmpty() && strSubstring.length() > 16) {
                    itemBuilder = ItemBuilder.from(ItemBuilder.skull().texture(strSubstring).build());
                }
            } else if (texture.startsWith(bT38YOBmidNH8cADat5Pr2())) {
                ItemStack itemStackItemStackFromBase64 = new Serialize().itemStackFromBase64(texture.substring(j5y5mL3KThl5TS2En().length()));
                itemBuilder = itemStackItemStackFromBase64 != null ? ItemBuilder.from(itemStackItemStackFromBase64) : ItemBuilder.from(Material.valueOf(this.o1VU1x4DAlrEtGKZ3jAdhE.getLibManager().ZwrsrwOCXRUscW6Q()));
            } else if (texture.length() > 16) {
                itemBuilder = ItemBuilder.from(ItemBuilder.skull().texture(texture).build());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return itemBuilder;
    }

    public Material v8qP8fE86HMhvNuYPFjqY(String str) {
        try {
            String str2 = str.split(boo5wTjOAfum4hgzrAMuBS())[0];
            ItemBuilder itemBuilderFrom = null;
            if (0 == 0 && str2 != null && !str2.isEmpty()) {
                itemBuilderFrom = ItemBuilder.from(new ItemStack(Material.valueOf(str2), 1));
            }
            if (itemBuilderFrom != null) {
                return itemBuilderFrom.build().getType();
            }
        } catch (Exception e) {
        }
        return Material.STONE;
    }

    public List<Integer> v8qP8fE86HMhvNuYPFjqY(int i, List<Integer> list) {
        if (i <= 2) {
            return list;
        }
        List<Integer> listV8qP8fE86HMhvNuYPFjqY = v8qP8fE86HMhvNuYPFjqY(i, list, i * 9);
        for (int i2 = 0; i2 < i * 9; i2++) {
            if (i2 <= 8 || i2 >= (i * 9) - 9 || i2 == 9 || i2 == 18 || i2 == 27 || i2 == 36 || i2 == 17 || i2 == 26 || i2 == 35 || i2 == 44) {
                listV8qP8fE86HMhvNuYPFjqY.add(Integer.valueOf(i2));
            }
        }
        return listV8qP8fE86HMhvNuYPFjqY;
    }

    public List<Integer> jBUuLP0sWwaPyPOmogdX7l(int i, List<Integer> list) {
        for (int i2 = 0; i2 < i * 9; i2++) {
            list.add(Integer.valueOf(i2));
        }
        return list;
    }

    public List<Integer> ZwrsrwOCXRUscW6Q(int i, List<Integer> list) {
        List<Integer> listV8qP8fE86HMhvNuYPFjqY = v8qP8fE86HMhvNuYPFjqY(i, list, i * 9);
        for (int i2 = 9; i2 > 0; i2--) {
            if (listV8qP8fE86HMhvNuYPFjqY.get((i * 9) - i2) == null) {
                listV8qP8fE86HMhvNuYPFjqY.add((i * 9) - i2, listV8qP8fE86HMhvNuYPFjqY.get(i2));
            }
        }
        return listV8qP8fE86HMhvNuYPFjqY;
    }

    public List<Integer> iZTqZaRK5UGoe0Z(int i, List<Integer> list) {
        List<Integer> listV8qP8fE86HMhvNuYPFjqY = v8qP8fE86HMhvNuYPFjqY(i, list, i * 9);
        for (int i2 = 0; i2 < 9; i2++) {
            if (!listV8qP8fE86HMhvNuYPFjqY.contains(Integer.valueOf(i2))) {
                list.add(Integer.valueOf(i2));
            }
        }
        return listV8qP8fE86HMhvNuYPFjqY;
    }

    public List<Integer> v8qP8fE86HMhvNuYPFjqY(int i, List<Integer> list, int i2) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        List<List<Integer>> listNCopies = Collections.nCopies(i * 9, list);
        listNCopies.forEach(v1 -> {
            arrayList.addAll(v1);
        });
        return arrayList;
    }

    public void v8qP8fE86HMhvNuYPFjqY(Gui gui, GuiItemsData guiItemsData, GuiItem guiItem) {
        if (guiItemsData.getSlot() >= 0) {
            gui.setItem(guiItemsData.getSlot(), guiItem);
        }
        if (guiItemsData.getMimeSlots().isAll()) {
            gui.getFiller().fill(guiItem);
        }
        if (guiItemsData.getMimeSlots().isTop()) {
            gui.getFiller().fillTop(guiItem);
        }
        if (guiItemsData.getMimeSlots().isBorder()) {
            gui.getFiller().fillBorder(guiItem);
        }
        if (guiItemsData.getMimeSlots().isBottom()) {
            gui.getFiller().fillBottom(guiItem);
        }
        if (guiItemsData.getMimeSlots().getSlots().size() > 0) {
            gui.setItem(guiItemsData.getMimeSlots().getSlots(), guiItem);
        }
    }

    public void v8qP8fE86HMhvNuYPFjqY(PaginatedGui paginatedGui, GuiItemsData guiItemsData, GuiItem guiItem) {
        if (guiItemsData.getSlot() >= 0) {
            paginatedGui.setItem(guiItemsData.getSlot(), guiItem);
        }
        if (guiItemsData.getMimeSlots().isTop()) {
            paginatedGui.getFiller().fillTop(guiItem);
        }
        if (guiItemsData.getMimeSlots().isBorder()) {
            paginatedGui.getFiller().fillBorder(guiItem);
        }
        if (guiItemsData.getMimeSlots().isBottom()) {
            paginatedGui.getFiller().fillBottom(guiItem);
        }
        if (guiItemsData.getMimeSlots().getSlots().size() > 0) {
            paginatedGui.setItem(guiItemsData.getMimeSlots().getSlots(), guiItem);
        }
    }

    public ConcurrentHashMap<String, GuiData> iZTqZaRK5UGoe0Z() {
        return this.jBUuLP0sWwaPyPOmogdX7l;
    }

    public void v8qP8fE86HMhvNuYPFjqY(ConcurrentHashMap<String, GuiData> concurrentHashMap) {
        this.jBUuLP0sWwaPyPOmogdX7l = concurrentHashMap;
    }

    public List<Player> xtOheRiObl4QeAl() {
        return this.iZTqZaRK5UGoe0Z;
    }

    public void v8qP8fE86HMhvNuYPFjqY(List<Player> list) {
        this.iZTqZaRK5UGoe0Z = new CopyOnWriteArrayList(list);
    }

    public ConcurrentHashMap<String, GuiData> zJnaNCVQSgEShq() {
        return this.ZwrsrwOCXRUscW6Q;
    }

    public void jBUuLP0sWwaPyPOmogdX7l(ConcurrentHashMap<String, GuiData> concurrentHashMap) {
        this.ZwrsrwOCXRUscW6Q = concurrentHashMap;
    }

    public Clans CDW4Fj1iwdIXEOqWjiJSR() {
        return this.o1VU1x4DAlrEtGKZ3jAdhE;
    }

    public GeneralGuiManager b4i2FbOkaKeg91LiAe6l() {
        return this.xtOheRiObl4QeAl;
    }

    public PaginationGui p31abtwfBag2jhMH6K() {
        return this.zJnaNCVQSgEShq;
    }

    public ProfileGuiManager Un3NRLL6aWivTcbodkcK() {
        return this.CDW4Fj1iwdIXEOqWjiJSR;
    }

    public void v8qP8fE86HMhvNuYPFjqY(ProfileGuiManager profileGuiManager) {
        this.CDW4Fj1iwdIXEOqWjiJSR = profileGuiManager;
    }

    public SettingsGuiManager lGGwXL678c4Kv7skJb5NiE() {
        return this.b4i2FbOkaKeg91LiAe6l;
    }

    public void v8qP8fE86HMhvNuYPFjqY(SettingsGuiManager settingsGuiManager) {
        this.b4i2FbOkaKeg91LiAe6l = settingsGuiManager;
    }

    public AdminGuiManager o1VU1x4DAlrEtGKZ3jAdhE() {
        return this.p31abtwfBag2jhMH6K;
    }

    public AdminExtensionGuiManager vVo2VUvxrriklPdRxI() {
        return this.Un3NRLL6aWivTcbodkcK;
    }

    public AdminModuleGuiManager Fc3p9FhCjSD1k5Ra4() {
        return this.lGGwXL678c4Kv7skJb5NiE;
    }

    public ConcurrentHashMap<String, HashMap<String, GuiData>> Nz8xKv4RePC2a0f0iuYU() {
        return this.v8qP8fE86HMhvNuYPFjqY;
    }

    public void ZwrsrwOCXRUscW6Q(ConcurrentHashMap<String, HashMap<String, GuiData>> concurrentHashMap) {
        this.v8qP8fE86HMhvNuYPFjqY = concurrentHashMap;
    }

    private static String faImWBxIsYlHwMLfML3(byte[] bArr) {
        return "";
    }

    private static String ctMQBO3VP6aw5omN() {
        return "setHideTooltip";
    }

    private static String MqFAza39AFiqCPniaAt() {
        return "General";
    }

    private static String Go87ILce4sQ5DSFRoP8VF() {
        return "admin_";
    }

    private static String IsFnbTX6sIWECSGO4() {
        return "ALL";
    }

    private static String RACw6qg1ZItqqjUeL() {
        return "TOP";
    }

    private static String RCOv3RlVa49kDVBZH0() {
        return "BOTTOM";
    }

    private static String KFFPWxzKN9bB03() {
        return "BORDER";
    }

    private static String exCmAR6sLhSocnLfCG6L() {
        return "Empty";
    }

    private static String YFxOWDgIZtjh5ltBvF() {
        return "previous";
    }

    private static String brgFvr9qberD1b() {
        return "next";
    }

    private static String foRM1KsDCFaRp6t() {
        return "back";
    }

    private static String XTrXxxaIiK1tEAgR() {
        return "prev";
    }

    private static String TS4SPnzE8WuJpiYckYpv() {
        return "General_common_previous_name";
    }

    private static String gQdAaAteAb4z58EW() {
        return "General_common_previous_lore";
    }

    private static String LiNTEye2o6iaJvQ19xsg() {
        return "fill";
    }

    private static String vLHarvSKB2RufQGb4ela() {
        return "General_common_fill_name";
    }

    private static String KQRnpHYJA4u2Zv() {
        return "General_common_fill_lore";
    }

    private static String ZjjOkcIoedWiM1aoW() {
        return "Insertion";
    }

    private static String DCm2ZulikL23U2Co() {
        return "Insertion";
    }

    private static String p1d9DDRjlnzy5cp7a() {
        return "ALL";
    }

    private static String ELGCqI3wvBtGdhf() {
        return "TOP";
    }

    private static String pUgjnUKaiLXTl6rfT8JpZe() {
        return "BOTTOM";
    }

    private static String XKVBLs2usRhtbFF0mjn0mn() {
        return "BORDER";
    }

    private static String TaqkQ1ZAZRYK8557x() {
        return "EN";
    }

    private static String f8pI1PEP1UqlZYS33() {
        return "EN";
    }

    private static String TlMa319cJQkX4DI9H() {
        return "PAPER";
    }

    private static String CsmGF5OsicZT1Jy() {
        return ":";
    }

    private static String kSiv2VZYOzyGdN1bZSjR7o() {
        return "HideTooltip";
    }

    private static String NANgnSLki3ePGc1x() {
        return "null";
    }

    private static String BbaC7ffBfUNT1bu81hsuM() {
        return "material:";
    }

    private static String IXdwpJ39tFmO1zgCrjo() {
        return ":";
    }

    private static String J0ozNl31WWtsuWBTd() {
        return "base64:";
    }

    private static String hqn2y1T1tN1pS2nRfwL() {
        return "base64:";
    }

    private static String bT38YOBmidNH8cADat5Pr2() {
        return "serialized:";
    }

    private static String j5y5mL3KThl5TS2En() {
        return "serialized:";
    }

    private static String boo5wTjOAfum4hgzrAMuBS() {
        return ":";
    }

    private static String C03F0VsqcTGGao() {
        return "{close_gui}";
    }

    private static String LJeRIcl1s8ULdKjH() {
        return "{close_gui}";
    }
}
