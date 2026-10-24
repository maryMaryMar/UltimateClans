package me.ulrich.clans.interfaces;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import me.ulrich.clans.data.AddonGuiItemsData;
import me.ulrich.clans.data.BossBarData;
import me.ulrich.clans.data.ClanEnum;
import me.ulrich.clans.data.CustomChatPrompt;
import me.ulrich.clans.library.gui.builder.item.ItemBuilder;
import me.ulrich.clans.library.gui.guis.Gui;
import me.ulrich.clans.library.gui.guis.GuiItem;
import me.ulrich.clans.library.gui.guis.PaginatedGui;
import me.ulrich.clans.library.gui.guis.StorageGui;
import me.ulrich.clans.library.kyori.adventure.bossbar.BossBar;
import me.ulrich.clans.library.kyori.adventure.platform.bukkit.BukkitAudiences;
import me.ulrich.clans.library.scoreboardlibrary.api.sidebar.Sidebar;
import me.ulrich.clans.library.universalScheduler.scheduling.schedulers.TaskScheduler;
import me.ulrich.clans.library.universalScheduler.scheduling.tasks.MyScheduledTask;
import me.ulrich.clans.tasks.AsyncTaskExecutor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/interfaces/LibAPI.class */
public interface LibAPI {
    boolean showScoreboard(Player player, String str, List<String> list);

    void hideScoreboard(Player player);

    ConcurrentHashMap<UUID, Sidebar> getBoards();

    String getDefaultBanner();

    void setDefaultBanner(String str);

    String getPluginTag();

    BukkitAudiences getAdventure();

    boolean isUseGUI();

    String translate(ClanEnum.TranslatableKey translatableKey, String str, String... strArr);

    String translateOutReference(String str, String str2, String... strArr);

    boolean isTaskInitialized();

    HashMap<UUID, BossBarData> getBossBarData();

    void removeBar(UUID uuid);

    void removeAllBar(UUID uuid);

    void removeAllBar(Player player);

    void removeAllBar();

    UUID customBossBar(Player player, BossBar.Color color, BossBar.Overlay overlay, List<BossBar.Flag> list, String str, int i, boolean z, List<String> list2);

    HashMap<UUID, MyScheduledTask> getActivetasks();

    boolean hasLibTask(UUID uuid);

    Optional<MyScheduledTask> getLibTask(UUID uuid);

    boolean stopLibTask(UUID uuid);

    Optional<MyScheduledTask> createLibTask(UUID uuid, MyScheduledTask myScheduledTask);

    boolean isFolia();

    TaskScheduler getScheduler();

    AsyncTaskExecutor getAsyncTaskExecutor();

    ConcurrentHashMap<UUID, MyScheduledTask> getBossbarTasks();

    ConcurrentHashMap<UUID, MyScheduledTask> getLibTasks();

    boolean playSoundForAll(String str);

    void playSoundForAll(List<String> list);

    boolean playSound(Player player, List<String> list);

    boolean playSound(Player player, String str);

    void filler(PaginatedGui paginatedGui, AddonGuiItemsData addonGuiItemsData, GuiItem guiItem);

    void filler(StorageGui storageGui, AddonGuiItemsData addonGuiItemsData, GuiItem guiItem);

    void filler(Gui gui, AddonGuiItemsData addonGuiItemsData, GuiItem guiItem);

    ItemBuilder mountItem(AddonGuiItemsData addonGuiItemsData, UUID uuid, List<String> list);

    ItemBuilder mountItem(AddonGuiItemsData addonGuiItemsData, ItemStack itemStack, UUID uuid, List<String> list);

    ItemBuilder createBaseItem(AddonGuiItemsData addonGuiItemsData, UUID uuid);

    ItemBuilder changeTooltip(ItemBuilder itemBuilder, boolean z);

    ItemStack addItemFlag(ItemStack itemStack, ItemFlag itemFlag);

    boolean hasChat(Player player);

    boolean startChat(Player player, CustomChatPrompt customChatPrompt);

    void handleInput(Player player, String str);

    boolean cancelChat(Player player);

    boolean cancelChat(Player player, boolean z);
}
