package me.ulrich.clans;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.logging.Level;
import me.ulrich.clans.api.ClanAPIManager;
import me.ulrich.clans.api.ColorAPIManager;
import me.ulrich.clans.api.CommandAPIManager;
import me.ulrich.clans.api.EntityAPIManager;
import me.ulrich.clans.api.GuiAPIManager;
import me.ulrich.clans.api.HooksAPIManager;
import me.ulrich.clans.api.IntegrationAPIManager;
import me.ulrich.clans.api.LibAPIManager;
import me.ulrich.clans.api.ModerationAPIManager;
import me.ulrich.clans.api.PlayerAPIManager;
import me.ulrich.clans.api.PlayerInviteAPIManager;
import me.ulrich.clans.data.Addon;
import me.ulrich.clans.data.AddonInfo;
import me.ulrich.clans.data.ClanEnum;
import me.ulrich.clans.data.Extension;
import me.ulrich.clans.data.Module;
import me.ulrich.clans.events.ClanPluginEvent;
import me.ulrich.clans.interfaces.UClans;
import me.ulrich.clans.library.kyori.adventure.platform.bukkit.BukkitAudiences;

import me.ulrich.clans.library.udojava.evalex.Expression;
import me.ulrich.clans.library.universalScheduler.scheduling.tasks.MyScheduledTask;
import me.ulrich.clans.loader.Serializer;
import me.ulrich.clans.loader.addon.AddonManager;
import me.ulrich.clans.loader.extension.ExtensionManager;
import me.ulrich.clans.loader.module.ModuleManager;
import me.ulrich.clans.manager.DJJU8UefX5VWXi;
import me.ulrich.clans.manager.DQoauhaxduHZi;
import me.ulrich.clans.manager.HooksManager;
import me.ulrich.clans.manager.KG0dzbdBSFtZuuPbyPn;
import me.ulrich.clans.manager.Qk09tA47G6CbKTZ;
import me.ulrich.clans.manager.TT1XiyOqwowi4;
import me.ulrich.clans.manager.TZTjwgGMwzxVd5AxjtP;
import me.ulrich.clans.manager.UUq89fbpNlals;
import me.ulrich.clans.manager.VEf2qW4PQbSn0GNh3FI;
import me.ulrich.clans.manager.XQWpFH32TPMOVKV5;
import me.ulrich.clans.manager.ZRp1tak21UvNaOVCtFx;
import me.ulrich.clans.manager.aK2d7aNWeGp9kLTwl;
import me.ulrich.clans.manager.bUQFEznViQX6XlU8D;
import me.ulrich.clans.manager.fOBoGnrhJe3J6K;
import me.ulrich.clans.manager.hZj37I9dZHauT;
import me.ulrich.clans.manager.jBWyXxi9EyWxcPiz;
import me.ulrich.clans.manager.lO8DsfpVA7lKO;
import me.ulrich.clans.manager.lusTj7BhhrQvAt6I;
import me.ulrich.clans.manager.sePx9kYBAc4ZOPKCkj;
import me.ulrich.clans.manager.utils.VersionUtil;
import me.ulrich.clans.manager.yxa7K4wJS7Peol;
import me.ulrich.clans.manager.z8MICAC4yDYZiO;
import me.ulrich.clans.manager.zTcC5XsAfoa1Tc1;
import me.ulrich.clans.qjkRaOgynIj1.E0Zb3L2jgpdfCu9HPY;
import me.ulrich.clans.tjCyMSV004ze7Mc.Ijap9SQKkijXSxP5;
import me.ulrich.clans.tjCyMSV004ze7Mc.RuVgd0Dnv0ddhdcWL;
import me.ulrich.clans.tjCyMSV004ze7Mc.qjkRaOgynIj1.UsEbiuprSHpNw3qjITfH;
import me.ulrich.entitywizard.entitylib.EntityLib;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.event.EventPriority;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/Clans.class */
public final class Clans extends JavaPlugin implements UClans {
    private DQoauhaxduHZi clanManager;
    private hZj37I9dZHauT playerManager;
    private zTcC5XsAfoa1Tc1 bossBarManager;
    private KG0dzbdBSFtZuuPbyPn files;
    private lO8DsfpVA7lKO guiManager;
    private HooksManager hooksManager;
    private DJJU8UefX5VWXi libManager;
    private Qk09tA47G6CbKTZ databaseManager;
    private XQWpFH32TPMOVKV5 clanPlaceholderAPI;
    private AddonManager addonManager;
    private ExtensionManager extensionManager;
    private ModuleManager moduleManager;
    private VEf2qW4PQbSn0GNh3FI commandManager;
    private BukkitAudiences adventure;
    private TZTjwgGMwzxVd5AxjtP colorManager;
    private bUQFEznViQX6XlU8D chatManager;
    private UUq89fbpNlals playerInviteManager;
    private aK2d7aNWeGp9kLTwl moderationManager;
    private z8MICAC4yDYZiO taskManager;
    private ZRp1tak21UvNaOVCtFx anvilGuiManager;
    private fOBoGnrhJe3J6K scoreboardmanager;
    private yxa7K4wJS7Peol topManager;
    private lusTj7BhhrQvAt6I entityManager;
    private TT1XiyOqwowi4 integrationManager;
    private HashMap<Addon, AddonInfo> addonEnabledList;
    private HashMap<Extension, Boolean> extensionEnabledList;
    private HashMap<Module, Boolean> moduleEnabledList;
    private List<Listener> registredListeners;
    private List<MyScheduledTask> registredtasks;
    private Metrics metrics;

    private ScheduledFuture<?> threadPool;
    private static Clans clanCore;
    private String tagpl = "UltimateClans |";
    private String language = "EN";
    private String timeZone = "America/Sao_Paulo";
    private String serverName = "Clans";
    private ClanEnum.ClanStorage databaseType = ClanEnum.ClanStorage.YAML;
    private String memberVersion = jBWyXxi9EyWxcPiz.v8qP8fE86HMhvNuYPFjqY();
    private boolean title_alerts = true;
    private String nmsTagGui = "uclansgui";
    private String nmsTagGui_type = "uclansgui_type";
    private String nmsTagGui_item = "uclansgui_item";
    private String nmsTagGui_id = "uclansgui_id";
    private String nmsTagGui_extra = "uclansgui_extra";
    private UUID pluginUUID = UUID.randomUUID();
    private List<UUID> toDelete = new ArrayList();
    private ClanEnum.ClanStorage pluginStorage = null;
    private boolean isAdventureCompatible = false;
    private boolean useGUI = false;
    private boolean isLoaded = false;
    private boolean entity = false;
    private sePx9kYBAc4ZOPKCkj umetrics = null;
    private final ClanAPIManager ClanAPI = new ClanAPIManager(this);
    private final PlayerAPIManager PlayerAPI = new PlayerAPIManager(this);
    private final HooksAPIManager HooksAPI = new HooksAPIManager(this);
    private final IntegrationAPIManager integrationAPI = new IntegrationAPIManager(this);
    private final LibAPIManager libAPI = new LibAPIManager(this);
    private final ModerationAPIManager modAPI = new ModerationAPIManager(this);
    private final CommandAPIManager commandAPI = new CommandAPIManager(this);
    private final GuiAPIManager guiAPI = new GuiAPIManager(this);
    private EntityAPIManager entityAPI = new EntityAPIManager(this);
    private ColorAPIManager colorAPI = new ColorAPIManager(this);
    private PlayerInviteAPIManager inviteAPI = new PlayerInviteAPIManager();

    public void onLoad() {
    }

    public void onEnable() {
        clanCore = this;
        getLogger().info("========================================");
        printSimpleLogo();
        me.ulrich.clans.qjkRaOgynIj1.bUQFEznViQX6XlU8D.v8qP8fE86HMhvNuYPFjqY();
        getLogger().info("Setup Assistant:");
        if (!Bukkit.getPluginManager().isPluginEnabled("EntityWizard")) {
            getLogger().info(" ! Not found");
        } else if (EntityLib.getApi() == null) {
            getLogger().info(" ! EntityWizard: Incompatible version");
        } else if (VersionUtil.isAbove(VersionUtil.VersionEnum.V118)) {
            this.entity = true;
            getLogger().info(" - Implementation: EntityWizard");
        } else {
            getLogger().info(" ! EntityWizard: Need Minecraft version 1.18+");
        }
        pluginEnable();
        this.metrics = new Metrics(this, 15517, this.taskManager.xtOheRiObl4QeAl());
        getAddonEnabledList().entrySet().iterator().forEachRemaining(entry -> {
            this.metrics.addCustomChart(new Metrics.XQWpFH32TPMOVKV5("Addons", () -> {
                return ((Addon) entry.getKey()).getName();
            }));
        });
        getExtensionEnabledList().entrySet().iterator().forEachRemaining(entry2 -> {
            this.metrics.addCustomChart(new Metrics.XQWpFH32TPMOVKV5("Extensions", () -> {
                return ((Extension) entry2.getKey()).getName();
            }));
        });
        getLogger().info("========================================");
    }

    public void onDisable() {
        pluginDisable(true);
        this.taskManager.b4i2FbOkaKeg91LiAe6l().shutdown();
        this.toDelete.clear();
    }

    @Override // me.ulrich.clans.interfaces.UClans
    public void registerEvents() {
        EventPriority eventPriorityValueOf;
        getLogger().info("Register events...");
        try {
            try {
                eventPriorityValueOf = EventPriority.valueOf(this.files.QXoNfOxIPaPrSlQMNR().getString("Chat.config.priority"));
            } catch (IllegalArgumentException e) {
                eventPriorityValueOf = EventPriority.NORMAL;
            }
            me.ulrich.clans.tjCyMSV004ze7Mc.ZRp1tak21UvNaOVCtFx zRp1tak21UvNaOVCtFx = new me.ulrich.clans.tjCyMSV004ze7Mc.ZRp1tak21UvNaOVCtFx();
            getServer().getPluginManager().registerEvents(zRp1tak21UvNaOVCtFx, this);
            getServer().getPluginManager().registerEvent(AsyncPlayerChatEvent.class, zRp1tak21UvNaOVCtFx, eventPriorityValueOf, zRp1tak21UvNaOVCtFx, getPlugin(), true);
        } catch (Exception e2) {
            getLogger().warning("An error occurred while registering the Chat Action Listener!");
        }
        Bukkit.getPluginManager().registerEvents(new RuVgd0Dnv0ddhdcWL(this), this);
        Bukkit.getPluginManager().registerEvents(new Ijap9SQKkijXSxP5(this), this);
        Bukkit.getPluginManager().registerEvents(new me.ulrich.clans.tjCyMSV004ze7Mc.qjkRaOgynIj1.Ijap9SQKkijXSxP5(this), this);
        Bukkit.getPluginManager().registerEvents(new UsEbiuprSHpNw3qjITfH(this), this);
        Bukkit.getPluginManager().registerEvents(new me.ulrich.clans.tjCyMSV004ze7Mc.qjkRaOgynIj1.ZRp1tak21UvNaOVCtFx(this), this);
        Bukkit.getPluginManager().registerEvents(new me.ulrich.clans.tjCyMSV004ze7Mc.DTKXb4fQF6nDgxzg.Ijap9SQKkijXSxP5(this), this);
        Bukkit.getPluginManager().registerEvents(new me.ulrich.clans.tjCyMSV004ze7Mc.zTcC5XsAfoa1Tc1(this), this);
    }

    @Override // me.ulrich.clans.interfaces.UClans
    public void startTasks() {
        getRegistredtasks().add(this.taskManager.xtOheRiObl4QeAl().runTaskTimer(new me.ulrich.clans.tasks.zTcC5XsAfoa1Tc1(this), 200L, 100L));
        getRegistredtasks().add(this.taskManager.xtOheRiObl4QeAl().runTaskTimer(new me.ulrich.clans.tasks.RuVgd0Dnv0ddhdcWL(this), 1200L, 1200L));
    }

    public void pluginEnable() {
        try {
            this.adventure = BukkitAudiences.create(this);
            if (setupCore()) {
                setupFilesAndConfig();
                if (setupDatabase()) {
                    setupBasicManagers();
                    setupGameplayManagers();
                    setupImplementations();
                    setupCommandsAndEvents();
                    loadExtensions();
                    loadModules();
                    loadAddons();
                    startLoaders();
                }
            }
        } catch (NoSuchMethodError e) {
            getLogger().warning("THE JAR YOU ARE USING LOOKS OLD AND DOES NOT SUPPORT CURRENT APIS. COMPATIBILITY MODE OFF!");
            onDisable();
        }
    }

    private boolean setupCore() {
        this.addonEnabledList = new HashMap<>();
        this.extensionEnabledList = new HashMap<>();
        this.moduleEnabledList = new HashMap<>();
        this.registredListeners = new ArrayList();
        this.registredtasks = new ArrayList();
        return true;
    }

    private void setupFilesAndConfig() {
        this.files = new KG0dzbdBSFtZuuPbyPn(this);
        this.taskManager = new z8MICAC4yDYZiO(this);
        if (getTaskManager().jBUuLP0sWwaPyPOmogdX7l()) {
            getLogger().info(" - Paper lib found");
        }
        this.useGUI = VersionUtil.isAbove(VersionUtil.VersionEnum.V18) && this.files.p31abtwfBag2jhMH6K().getBoolean("Config.gui.enabled");
        getLogger().info(" - Use gui: " + this.useGUI);
        this.title_alerts = !this.files.p31abtwfBag2jhMH6K().getBoolean("Config.gui.disable_title_alerts");
        checkScriptEngine();
    }

    private boolean setupDatabase() {
        this.databaseManager = new Qk09tA47G6CbKTZ(this);
        if (this.databaseManager.iZTqZaRK5UGoe0Z()) {
            return true;
        }
        onDisable();
        return false;
    }

    private void setupBasicManagers() {
        this.colorManager = new TZTjwgGMwzxVd5AxjtP(this);
        this.hooksManager = new HooksManager(this);
        this.libManager = new DJJU8UefX5VWXi(this);
        this.anvilGuiManager = new ZRp1tak21UvNaOVCtFx(this);
        this.integrationManager = new TT1XiyOqwowi4();
    }

    private void setupGameplayManagers() {
        this.clanManager = new DQoauhaxduHZi(this);
        this.playerManager = new hZj37I9dZHauT(this);
        this.playerInviteManager = new UUq89fbpNlals(this);
        this.moderationManager = new aK2d7aNWeGp9kLTwl(this);
        this.topManager = new yxa7K4wJS7Peol(this);
        this.guiManager = new lO8DsfpVA7lKO(this);
        this.bossBarManager = new zTcC5XsAfoa1Tc1();
        this.chatManager = new bUQFEznViQX6XlU8D();
        this.scoreboardmanager = new fOBoGnrhJe3J6K(this);
        if (this.entity) {
            this.entityManager = new lusTj7BhhrQvAt6I(this);
        }
    }

    private void setupImplementations() {
        this.clanPlaceholderAPI = new XQWpFH32TPMOVKV5(this);
    }

    private void setupCommandsAndEvents() {
        this.commandManager = new VEf2qW4PQbSn0GNh3FI(this);
        this.commandManager.v8qP8fE86HMhvNuYPFjqY();
        registerEvents();
    }

    private void startLoaders() {
        getLogger().info("Start data loaders...");
        me.ulrich.clans.manager.DTKXb4fQF6nDgxzg.DTKXb4fQF6nDgxzg.DTKXb4fQF6nDgxzg.ZRp1tak21UvNaOVCtFx.v8qP8fE86HMhvNuYPFjqY().thenCompose(r5 -> {
            return CompletableFuture.allOf(me.ulrich.clans.manager.DTKXb4fQF6nDgxzg.kSFM3X0M9q2n7XFSS.DTKXb4fQF6nDgxzg.ZRp1tak21UvNaOVCtFx.v8qP8fE86HMhvNuYPFjqY());
        }).thenCompose(r2 -> {
            return me.ulrich.clans.manager.DTKXb4fQF6nDgxzg.tjCyMSV004ze7Mc.DTKXb4fQF6nDgxzg.UsEbiuprSHpNw3qjITfH.v8qP8fE86HMhvNuYPFjqY();
        }).thenCompose(r6 -> {
            return CompletableFuture.allOf(me.ulrich.clans.manager.DTKXb4fQF6nDgxzg.qjkRaOgynIj1.DTKXb4fQF6nDgxzg.UsEbiuprSHpNw3qjITfH.v8qP8fE86HMhvNuYPFjqY());
        }).thenRun(() -> {
            getLogger().info("All data loaded successfully!");
            getTaskManager().xtOheRiObl4QeAl().runTask(this::finalizeSetup);
        }).exceptionally(th -> {
            th.printStackTrace();
            return null;
        });
    }

    private void finalizeSetup() {
        startTasks();
        startThreadpoll();
        getPlayerManager().v8qP8fE86HMhvNuYPFjqY();
        Bukkit.getPluginManager().callEvent(new ClanPluginEvent(true, true));
        this.umetrics = new sePx9kYBAc4ZOPKCkj(this, this.taskManager.xtOheRiObl4QeAl());
        this.hooksManager.loadBefore();
        setLoaded(true);
        new me.ulrich.clans.tasks.Ijap9SQKkijXSxP5(this);
        E0Zb3L2jgpdfCu9HPY.v8qP8fE86HMhvNuYPFjqY();
    }

    private void checkScriptEngine() {
        try {
            if (new Expression("1+1").eval().doubleValue() == 2.0d) {
                getLogger().info(" - ScriptEngine: Loaded successfully");
            }
        } catch (Exception e) {
            getLogger().warning(" - ScriptEngine failed: using predefined expressions.");
        }
    }

    public void startThreadpoll() {
        int i;
        if (this.files.p31abtwfBag2jhMH6K().getBoolean("Config.top.realtime") || (i = this.files.p31abtwfBag2jhMH6K().getInt("Config.top.update_time")) <= 0) {
            return;
        }
        this.threadPool = Executors.newScheduledThreadPool(1).scheduleAtFixedRate(new me.ulrich.clans.tasks.bUQFEznViQX6XlU8D(getPlugin()), 10L, i, TimeUnit.SECONDS);
    }

    @Override // me.ulrich.clans.interfaces.UClans
    public void loadAddons() {
        getLogger().info("Setup Addons...");
        AddonManager addonManager = new AddonManager(this, new Serializer(this, false), new Serializer(this, false));
        addonManager.load();
        addonManager.enableAddons();
        this.addonManager = addonManager;
    }

    @Override // me.ulrich.clans.interfaces.UClans
    public void loadExtensions() {
        getLogger().info("Setup Extensions...");
        getExtensionEnabledList().clear();
        ExtensionManager extensionManager = new ExtensionManager(this, new Serializer(this, false), new Serializer(this, false));
        extensionManager.loadExtensions();
        extensionManager.enableExtensions();
        this.extensionManager = extensionManager;
        StringBuilder sb = new StringBuilder();
        getExtensionEnabledList().entrySet().stream().filter(entry -> {
            return !((Boolean) entry.getValue()).booleanValue();
        }).iterator().forEachRemaining(entry2 -> {
            sb.append(((Extension) entry2.getKey()).getName() + ", ");
        });
        String strTrim = sb.toString().trim();
        if (strTrim.length() > 0) {
            getLogger().warning(" ! Disabled: [" + strTrim + "]");
        }
    }

    public void verificarEBaixarModulosAutomatico() {
        if (!this.files.MoSLgFbw3mkSoqkObMHJ4().getBoolean("Config.modules.auto_update")) {
            getLogger().fine("Self-checking for modules is disabled.");
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (ClanEnum.ClansModules clansModules : ClanEnum.ClansModules.values()) {
            if (clansModules.isCompatibleWithServer()) {
                arrayList.add(clansModules);
            } else {
                getLogger().fine("Skipping module " + clansModules.name() + " (Incompatible with the server version.).");
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        processarFilaModulos(arrayList, 0, new ArrayList());
    }

    private void processarFilaModulos(List<ClanEnum.ClansModules> list, int i, List<CompletableFuture<Boolean>> list2) {
        if (i >= list.size()) {
            getLogger().fine("All compatible modules have been queued. Awaiting completion...");
            CompletableFuture.allOf((CompletableFuture[]) list2.toArray(new CompletableFuture[0])).thenAccept(r7 -> {
                long jCount = list2.stream().map((v0) -> {
                    return v0.join();
                }).filter(bool -> {
                    return bool.booleanValue();
                }).count();
                getLogger().info("Self-verification of modules completed. Total modules updated: " + jCount);
                if (jCount > 0) {
                    pluginDisableModules(false);
                    getClanCore().getTaskManager().xtOheRiObl4QeAl().runTask(() -> {
                        loadModules();
                    });
                }
            });
        } else {
            ClanEnum.ClansModules clansModules = list.get(i);
            getLogger().info("Self-Verification: Analyzing Module " + clansModules.name() + "...");
            list2.add(this.files.v8qP8fE86HMhvNuYPFjqY((CommandSender) Bukkit.getConsoleSender(), clansModules, false, true));
            getClanCore().getTaskManager().xtOheRiObl4QeAl().runTaskLaterAsynchronously(() -> {
                processarFilaModulos(list, i + 1, list2);
            }, 60L);
        }
    }

    public void verificarEBaixarExtensoesAutomatico() {
        if (!this.files.MoSLgFbw3mkSoqkObMHJ4().getBoolean("Config.extensions.auto_download")) {
            getLogger().fine("Self-checking for extensions is disabled.");
            return;
        }
        getLogger().fine("Self-verification for extensions is enabled, initializing...");
        ArrayList arrayList = new ArrayList();
        for (ClanEnum.ClansExtensions clansExtensions : ClanEnum.ClansExtensions.values()) {
            if (Bukkit.getPluginManager().isPluginEnabled(clansExtensions.getPluginName())) {
                arrayList.add(clansExtensions);
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        processarFilaDownloads(arrayList, 0, new ArrayList());
    }

    private void processarFilaDownloads(List<ClanEnum.ClansExtensions> list, int i, List<CompletableFuture<Boolean>> list2) {
        if (i >= list.size()) {
            getLogger().fine("All extensions have been queued. Awaiting download completion...");
            CompletableFuture.allOf((CompletableFuture[]) list2.toArray(new CompletableFuture[0])).thenAccept(r7 -> {
                long jCount = list2.stream().map((v0) -> {
                    return v0.join();
                }).filter(bool -> {
                    return bool.booleanValue();
                }).count();
                getLogger().info("Self-verification completed. Total extensions updated: " + jCount);
                if (jCount > 0) {
                    pluginDisableExtensions(false);
                    getClanCore().getTaskManager().xtOheRiObl4QeAl().runTask(() -> {
                        loadExtensions();
                    });
                }
            });
        } else {
            ClanEnum.ClansExtensions clansExtensions = list.get(i);
            getLogger().info("Self-Verification: Analyzing " + clansExtensions.name() + "...");
            list2.add(this.files.v8qP8fE86HMhvNuYPFjqY((CommandSender) Bukkit.getConsoleSender(), clansExtensions, false, true));
            getClanCore().getTaskManager().xtOheRiObl4QeAl().runTaskLaterAsynchronously(() -> {
                processarFilaDownloads(list, i + 1, list2);
            }, 60L);
        }
    }

    @Override // me.ulrich.clans.interfaces.UClans
    public void loadModules() {
        getLogger().info("Setup Modules...");
        getModuleEnabledList().clear();
        ModuleManager moduleManager = new ModuleManager(this, new Serializer(this, false), new Serializer(this, false));
        moduleManager.load();
        moduleManager.enableModules();
        setModuleManager(moduleManager);
        StringBuilder sb = new StringBuilder();
        getModuleEnabledList().entrySet().stream().filter(entry -> {
            return !((Boolean) entry.getValue()).booleanValue();
        }).iterator().forEachRemaining(entry2 -> {
            sb.append(((Module) entry2.getKey()).getName() + ", ");
        });
        String strTrim = sb.toString().trim();
        if (strTrim.length() > 0) {
            getLogger().warning(" ! Disabled: [" + strTrim + "]");
        }
    }

    public void pluginDisable(boolean z) {
        setLoaded(false);
        if (z) {
            getLogger().info("Starting shutdown ...");
        }
        if (this.entity) {
            if (z) {
                getLogger().info("Stoping entities...");
            }
            this.entityManager.v8qP8fE86HMhvNuYPFjqY();
        }
        if (this.threadPool != null && !this.threadPool.isCancelled()) {
            if (z) {
                getLogger().info("Stoping thread...");
            }
            this.threadPool.cancel(true);
        }
        if (this.taskManager != null) {
            this.taskManager.xtOheRiObl4QeAl().cancelTasks();
        }
        if (this.guiManager != null) {
            this.guiManager.v8qP8fE86HMhvNuYPFjqY();
        }
        if (this.databaseManager != null) {
            if (z) {
                getLogger().info("Closing storage...");
            }
            this.databaseManager.v8qP8fE86HMhvNuYPFjqY();
            System.gc();
        }
        if (this.bossBarManager != null) {
            this.bossBarManager.ZwrsrwOCXRUscW6Q();
        }
        pluginDisableAddons(true);
        pluginDisableExtensions(true);
        pluginDisableModules(true);
        if (this.commandManager != null) {
            this.commandManager.ZwrsrwOCXRUscW6Q().clear();
            this.commandManager.iZTqZaRK5UGoe0Z().clear();
        }
        this.addonEnabledList.clear();
        if (this.adventure != null) {
            if (z) {
                getLogger().info("Disabling Adventure...");
            }
            this.adventure.close();
            this.adventure = null;
        }
        if (this.registredListeners != null) {
            if (z) {
                getLogger().info("Unregister Listeners...");
            }
            this.registredListeners.iterator().forEachRemaining(listener -> {
                HandlerList.unregisterAll(listener);
            });
        }
        if (this.hooksManager != null && this.hooksManager.isPlaceholderapi() && this.hooksManager.getPlaceholderHook() != null) {
            if (z) {
                getLogger().info("Unregister Papi...");
            }
            this.hooksManager.getPlaceholderHook().unregister();
        }
        if (this.registredtasks != null) {
            if (z) {
                getLogger().info("Canceling Tasks...");
            }
            this.registredtasks.iterator().forEachRemaining(myScheduledTask -> {
                myScheduledTask.cancel();
            });
        }
        if (z) {
            getLogger().info("Goodbye!");
        }
    }

    public void pluginDisableExtensions(boolean z) {
        if (this.extensionManager != null) {
            if (z) {
                getLogger().info("Disabling extensions...");
            }
            this.extensionManager.disableExtensions();
            this.extensionEnabledList.clear();
        }
    }

    public void pluginDisableModules(boolean z) {
        if (this.moduleManager != null) {
            if (z) {
                getLogger().info("Disabling modules...");
            }
            this.moduleManager.disableModules();
            this.moduleEnabledList.clear();
        }
    }

    public void pluginDisableAddons(boolean z) {
        if (this.addonManager != null) {
            if (z) {
                getLogger().info("Disabling addons...");
            }
            this.addonManager.disableAddons();
            this.addonEnabledList.clear();
        }
    }

    private void printSimpleLogo() {
        getLogger().log(Level.INFO, " _     _  _        _                              ______  _                     ");
        getLogger().log(Level.INFO, "| |   | || | _    (_)               _            / _____)| |                  V9");
        getLogger().log(Level.INFO, "| |   | || || |_   _  ____    ____ | |_    ____ | /      | |  ____  ____    ___ ");
        getLogger().log(Level.INFO, "| |   | || ||  _) | ||    \\  / _  ||  _)  / _  )| |      | | / _  ||  _ \\  /___)");
        getLogger().log(Level.INFO, "| |___| || || |__ | || | | |( ( | || |__ ( (/ / | \\_____ | |( ( | || | | ||___ |");
        getLogger().log(Level.INFO, " \\______||_| \\___)|_||_|_|_| \\_||_| \\___) \\____) \\______)|_| \\_||_||_| |_|(___/ ");
        getLogger().log(Level.INFO, " ");
    }

    @Override // me.ulrich.clans.interfaces.UClans
    public Clans getPlugin() {
        return this;
    }

    @Override // me.ulrich.clans.interfaces.UClans
    public ClanAPIManager getClanAPI() {
        return this.ClanAPI;
    }

    @Override // me.ulrich.clans.interfaces.UClans
    public PlayerAPIManager getPlayerAPI() {
        return this.PlayerAPI;
    }

    public DQoauhaxduHZi getClanManager() {
        return this.clanManager;
    }

    public hZj37I9dZHauT getPlayerManager() {
        return this.playerManager;
    }

    public lO8DsfpVA7lKO getGuiManager() {
        return this.guiManager;
    }

    public zTcC5XsAfoa1Tc1 getBossBarManager() {
        return this.bossBarManager;
    }

    public XQWpFH32TPMOVKV5 getClanPlaceholderAPI() {
        return this.clanPlaceholderAPI;
    }

    public AddonManager getAddonManager() {
        return this.addonManager;
    }

    public VEf2qW4PQbSn0GNh3FI getCommandManager() {
        return this.commandManager;
    }

    public ClanEnum.ClanStorage getPluginStorage() {
        return this.pluginStorage;
    }

    public void setPluginStorage(ClanEnum.ClanStorage clanStorage) {
        this.pluginStorage = clanStorage;
    }

    public HashMap<Addon, AddonInfo> getAddonEnabledList() {
        return this.addonEnabledList;
    }

    public String getNmsTagGui() {
        return this.nmsTagGui;
    }

    public void setNmsTagGui(String str) {
        this.nmsTagGui = str;
    }

    public String getNmsTagGui_type() {
        return this.nmsTagGui_type;
    }

    public void setNmsTagGui_type(String str) {
        this.nmsTagGui_type = str;
    }

    public String getNmsTagGui_item() {
        return this.nmsTagGui_item;
    }

    public void setNmsTagGui_item(String str) {
        this.nmsTagGui_item = str;
    }

    public String getNmsTagGui_id() {
        return this.nmsTagGui_id;
    }

    public void setNmsTagGui_id(String str) {
        this.nmsTagGui_id = str;
    }

    public String getNmsTagGui_extra() {
        return this.nmsTagGui_extra;
    }

    public void setNmsTagGui_extra(String str) {
        this.nmsTagGui_extra = str;
    }

    public String getTagpl() {
        return this.tagpl;
    }

    public void setTagpl(String str) {
        this.tagpl = str;
    }

    public KG0dzbdBSFtZuuPbyPn getFiles() {
        return this.files;
    }

    public void setFiles(KG0dzbdBSFtZuuPbyPn kG0dzbdBSFtZuuPbyPn) {
        this.files = kG0dzbdBSFtZuuPbyPn;
    }

    public HooksManager getHooksManager() {
        return this.hooksManager;
    }

    @Override // me.ulrich.clans.interfaces.UClans
    public HooksAPIManager getHooksAPI() {
        return this.HooksAPI;
    }

    @Override // me.ulrich.clans.interfaces.UClans
    public IntegrationAPIManager getIntegrationAPI() {
        return this.integrationAPI;
    }

    public DJJU8UefX5VWXi getLibManager() {
        return this.libManager;
    }

    @Override // me.ulrich.clans.interfaces.UClans
    public LibAPIManager getLibAPI() {
        return this.libAPI;
    }

    public Qk09tA47G6CbKTZ getDatabaseManager() {
        return this.databaseManager;
    }

    public BukkitAudiences getAdventure() {
        if (this.adventure == null) {
            throw new IllegalStateException("Tried to access Adventure when the plugin was disabled!");
        }
        return this.adventure;
    }

    public TZTjwgGMwzxVd5AxjtP getColorManager() {
        return this.colorManager;
    }

    public boolean isAdventureCompatible() {
        return this.isAdventureCompatible;
    }

    public bUQFEznViQX6XlU8D getChatManager() {
        return this.chatManager;
    }

    public UUID getPluginUUID() {
        return this.pluginUUID;
    }

    public void setPluginUUID(UUID uuid) {
        this.pluginUUID = uuid;
    }

    public List<Listener> getRegistredListeners() {
        return this.registredListeners;
    }

    public void setRegistredListeners(List<Listener> list) {
        this.registredListeners = list;
    }

    public boolean isUseGUI() {
        return this.useGUI;
    }

    public void setUseGUI(boolean z) {
        this.useGUI = z;
    }

    public UUq89fbpNlals getPlayerInviteManager() {
        return this.playerInviteManager;
    }

    public void setPlayerInviteManager(UUq89fbpNlals uUq89fbpNlals) {
        this.playerInviteManager = uUq89fbpNlals;
    }

    public aK2d7aNWeGp9kLTwl getModerationManager() {
        return this.moderationManager;
    }

    public void setModerationManager(aK2d7aNWeGp9kLTwl ak2d7anwegp9kltwl) {
        this.moderationManager = ak2d7anwegp9kltwl;
    }

    @Override // me.ulrich.clans.interfaces.UClans
    public ModerationAPIManager getModAPI() {
        return this.modAPI;
    }

    @Override // me.ulrich.clans.interfaces.UClans
    public CommandAPIManager getCommandAPI() {
        return this.commandAPI;
    }

    public boolean isLoaded() {
        return this.isLoaded;
    }

    public void setLoaded(boolean z) {
        this.isLoaded = z;
    }

    public List<UUID> getToDelete() {
        return this.toDelete;
    }

    public void setToDelete(List<UUID> list) {
        this.toDelete = list;
    }

    public List<MyScheduledTask> getRegistredtasks() {
        return this.registredtasks;
    }

    public HashMap<Extension, Boolean> getExtensionEnabledList() {
        return this.extensionEnabledList;
    }

    public ExtensionManager getExtensionManager() {
        return this.extensionManager;
    }

    public z8MICAC4yDYZiO getTaskManager() {
        return this.taskManager;
    }

    public sePx9kYBAc4ZOPKCkj getUmetrics() {
        return this.umetrics;
    }

    public ZRp1tak21UvNaOVCtFx getAnvilGuiManager() {
        return this.anvilGuiManager;
    }

    public fOBoGnrhJe3J6K getScoreboardmanager() {
        return this.scoreboardmanager;
    }

    @Override // me.ulrich.clans.interfaces.UClans
    public GuiAPIManager getGuiAPI() {
        return this.guiAPI;
    }

    public static Clans getClanCore() {
        return clanCore;
    }

    public ScheduledFuture<?> getThreadPool() {
        return this.threadPool;
    }

    public yxa7K4wJS7Peol getTopManager() {
        return this.topManager;
    }

    public String getLanguage() {
        return this.language;
    }

    public void setLanguage(String str) {
        this.language = str;
    }

    public boolean isEntity() {
        return this.entity;
    }

    public lusTj7BhhrQvAt6I getEntityManager() {
        return this.entityManager;
    }

    @Override // me.ulrich.clans.interfaces.UClans
    public EntityAPIManager getEntityAPI() {
        return this.entityAPI;
    }

    public String getMemberVersion() {
        return this.memberVersion;
    }

    public ClanEnum.ClanStorage getDatabaseType() {
        return this.databaseType;
    }

    public void setDatabaseType(ClanEnum.ClanStorage clanStorage) {
        this.databaseType = clanStorage;
    }

    public boolean isTitleAlerts() {
        return this.title_alerts;
    }

    public HashMap<Module, Boolean> getModuleEnabledList() {
        return this.moduleEnabledList;
    }

    public void setModuleEnabledList(HashMap<Module, Boolean> map) {
        this.moduleEnabledList = map;
    }

    public ModuleManager getModuleManager() {
        return this.moduleManager;
    }

    public void setModuleManager(ModuleManager moduleManager) {
        this.moduleManager = moduleManager;
    }

    @Override // me.ulrich.clans.interfaces.UClans
    public ColorAPIManager getColorAPI() {
        return this.colorAPI;
    }

    public String getResourceUid() {
        return "632059";
    }

    public String getResourceAgent() {
        return me.ulrich.clans.manager.UsEbiuprSHpNw3qjITfH.jBUuLP0sWwaPyPOmogdX7l().toString().toUpperCase();
    }

    public String getServerName() {
        return this.serverName;
    }

    public void setServerName(String str) {
        this.serverName = str;
    }

    @Override // me.ulrich.clans.interfaces.UClans
    public PlayerInviteAPIManager getInviteAPI() {
        return this.inviteAPI;
    }

    public TT1XiyOqwowi4 getIntegrationManager() {
        return this.integrationManager;
    }

    public String getTimeZone() {
        return this.timeZone;
    }

    public void setTimeZone(String str) {
        this.timeZone = str;
    }
}
