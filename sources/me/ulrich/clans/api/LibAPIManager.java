package me.ulrich.clans.api;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import me.ulrich.clans.Clans;
import me.ulrich.clans.data.AddonGuiItemsData;
import me.ulrich.clans.data.BossBarData;
import me.ulrich.clans.data.ClanEnum;
import me.ulrich.clans.data.CustomChatPrompt;
import me.ulrich.clans.interfaces.LibAPI;
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
import me.ulrich.clans.manager.Ijap9SQKkijXSxP5;
import me.ulrich.clans.tasks.AsyncTaskExecutor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/api/LibAPIManager.class */
public class LibAPIManager implements LibAPI {
    private final Clans plugin;

    public LibAPIManager(Clans clans) {
        this.plugin = clans;
    }

    @Override // me.ulrich.clans.interfaces.LibAPI
    public BukkitAudiences getAdventure() {
        return this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY();
    }

    @Override // me.ulrich.clans.interfaces.LibAPI
    public boolean isUseGUI() {
        return this.plugin.isUseGUI();
    }

    @Override // me.ulrich.clans.interfaces.LibAPI
    public String getPluginTag() {
        return this.plugin.getTagpl();
    }

    @Override // me.ulrich.clans.interfaces.LibAPI
    public String translate(ClanEnum.TranslatableKey translatableKey, String str, String... strArr) {
        return this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(translatableKey, str, strArr);
    }

    @Override // me.ulrich.clans.interfaces.LibAPI
    @Deprecated
    public String translateOutReference(String str, String str2, String... strArr) {
        return this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(str, str2, strArr);
    }

    public Clans getPlugin() {
        return this.plugin;
    }

    @Override // me.ulrich.clans.interfaces.LibAPI
    public boolean isTaskInitialized() {
        return this.plugin.getTaskManager().ZwrsrwOCXRUscW6Q();
    }

    @Override // me.ulrich.clans.interfaces.LibAPI
    public boolean isFolia() {
        return this.plugin.getTaskManager().iZTqZaRK5UGoe0Z();
    }

    @Override // me.ulrich.clans.interfaces.LibAPI
    public TaskScheduler getScheduler() {
        return this.plugin.getTaskManager().xtOheRiObl4QeAl();
    }

    @Override // me.ulrich.clans.interfaces.LibAPI
    public ConcurrentHashMap<UUID, MyScheduledTask> getBossbarTasks() {
        return this.plugin.getTaskManager().zJnaNCVQSgEShq();
    }

    @Override // me.ulrich.clans.interfaces.LibAPI
    public ConcurrentHashMap<UUID, MyScheduledTask> getLibTasks() {
        return this.plugin.getTaskManager().CDW4Fj1iwdIXEOqWjiJSR();
    }

    @Override // me.ulrich.clans.interfaces.LibAPI
    public boolean hasLibTask(UUID uuid) {
        return this.plugin.getTaskManager().iZTqZaRK5UGoe0Z(uuid);
    }

    @Override // me.ulrich.clans.interfaces.LibAPI
    public Optional<MyScheduledTask> getLibTask(UUID uuid) {
        return this.plugin.getTaskManager().xtOheRiObl4QeAl(uuid);
    }

    @Override // me.ulrich.clans.interfaces.LibAPI
    public boolean stopLibTask(UUID uuid) {
        return this.plugin.getTaskManager().zJnaNCVQSgEShq(uuid);
    }

    @Override // me.ulrich.clans.interfaces.LibAPI
    public Optional<MyScheduledTask> createLibTask(UUID uuid, MyScheduledTask myScheduledTask) {
        return this.plugin.getTaskManager().jBUuLP0sWwaPyPOmogdX7l(uuid, myScheduledTask);
    }

    @Override // me.ulrich.clans.interfaces.LibAPI
    public boolean playSoundForAll(String str) {
        return this.plugin.getLibManager().ZwrsrwOCXRUscW6Q(str);
    }

    @Override // me.ulrich.clans.interfaces.LibAPI
    public void playSoundForAll(List<String> list) {
        this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(list);
    }

    @Override // me.ulrich.clans.interfaces.LibAPI
    public boolean playSound(Player player, List<String> list) {
        return this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, list);
    }

    @Override // me.ulrich.clans.interfaces.LibAPI
    public boolean playSound(Player player, String str) {
        return this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, str);
    }

    @Override // me.ulrich.clans.interfaces.LibAPI
    public AsyncTaskExecutor getAsyncTaskExecutor() {
        return this.plugin.getTaskManager().b4i2FbOkaKeg91LiAe6l();
    }

    @Override // me.ulrich.clans.interfaces.LibAPI
    public String getDefaultBanner() {
        return this.plugin.getLibManager().ZwrsrwOCXRUscW6Q();
    }

    @Override // me.ulrich.clans.interfaces.LibAPI
    public void setDefaultBanner(String str) {
        this.plugin.getLibManager().xtOheRiObl4QeAl(str);
    }

    @Override // me.ulrich.clans.interfaces.LibAPI
    public boolean showScoreboard(Player player, String str, List<String> list) {
        return this.plugin.getScoreboardmanager().v8qP8fE86HMhvNuYPFjqY(player, str, list);
    }

    @Override // me.ulrich.clans.interfaces.LibAPI
    public void hideScoreboard(Player player) {
        this.plugin.getScoreboardmanager().jBUuLP0sWwaPyPOmogdX7l(player);
    }

    @Override // me.ulrich.clans.interfaces.LibAPI
    public ConcurrentHashMap<UUID, Sidebar> getBoards() {
        return this.plugin.getScoreboardmanager().iZTqZaRK5UGoe0Z();
    }

    @Override // me.ulrich.clans.interfaces.LibAPI
    public void filler(PaginatedGui paginatedGui, AddonGuiItemsData addonGuiItemsData, GuiItem guiItem) {
        Ijap9SQKkijXSxP5.v8qP8fE86HMhvNuYPFjqY(paginatedGui, addonGuiItemsData, guiItem);
    }

    @Override // me.ulrich.clans.interfaces.LibAPI
    public void filler(StorageGui storageGui, AddonGuiItemsData addonGuiItemsData, GuiItem guiItem) {
        Ijap9SQKkijXSxP5.v8qP8fE86HMhvNuYPFjqY(storageGui, addonGuiItemsData, guiItem);
    }

    @Override // me.ulrich.clans.interfaces.LibAPI
    public void filler(Gui gui, AddonGuiItemsData addonGuiItemsData, GuiItem guiItem) {
        Ijap9SQKkijXSxP5.v8qP8fE86HMhvNuYPFjqY(gui, addonGuiItemsData, guiItem);
    }

    @Override // me.ulrich.clans.interfaces.LibAPI
    public ItemBuilder mountItem(AddonGuiItemsData addonGuiItemsData, UUID uuid, List<String> list) {
        return Ijap9SQKkijXSxP5.v8qP8fE86HMhvNuYPFjqY(addonGuiItemsData, uuid, list);
    }

    @Override // me.ulrich.clans.interfaces.LibAPI
    public ItemBuilder mountItem(AddonGuiItemsData addonGuiItemsData, ItemStack itemStack, UUID uuid, List<String> list) {
        return Ijap9SQKkijXSxP5.v8qP8fE86HMhvNuYPFjqY(addonGuiItemsData, itemStack, uuid, list);
    }

    @Override // me.ulrich.clans.interfaces.LibAPI
    public ItemBuilder createBaseItem(AddonGuiItemsData addonGuiItemsData, UUID uuid) {
        return Ijap9SQKkijXSxP5.v8qP8fE86HMhvNuYPFjqY(addonGuiItemsData, uuid);
    }

    @Override // me.ulrich.clans.interfaces.LibAPI
    public ItemBuilder changeTooltip(ItemBuilder itemBuilder, boolean z) {
        return Ijap9SQKkijXSxP5.v8qP8fE86HMhvNuYPFjqY(itemBuilder, z);
    }

    @Override // me.ulrich.clans.interfaces.LibAPI
    public ItemStack addItemFlag(ItemStack itemStack, ItemFlag itemFlag) {
        return Ijap9SQKkijXSxP5.v8qP8fE86HMhvNuYPFjqY(itemStack, itemFlag);
    }

    @Override // me.ulrich.clans.interfaces.LibAPI
    public HashMap<UUID, BossBarData> getBossBarData() {
        return Clans.getClanCore().getBossBarManager().v8qP8fE86HMhvNuYPFjqY();
    }

    @Override // me.ulrich.clans.interfaces.LibAPI
    public void removeBar(UUID uuid) {
        Clans.getClanCore().getBossBarManager().v8qP8fE86HMhvNuYPFjqY(uuid);
    }

    @Override // me.ulrich.clans.interfaces.LibAPI
    public void removeAllBar(UUID uuid) {
        Clans.getClanCore().getBossBarManager().jBUuLP0sWwaPyPOmogdX7l(uuid);
    }

    @Override // me.ulrich.clans.interfaces.LibAPI
    public void removeAllBar(Player player) {
        Clans.getClanCore().getBossBarManager().v8qP8fE86HMhvNuYPFjqY(player);
    }

    @Override // me.ulrich.clans.interfaces.LibAPI
    public void removeAllBar() {
        Clans.getClanCore().getBossBarManager().ZwrsrwOCXRUscW6Q();
    }

    @Override // me.ulrich.clans.interfaces.LibAPI
    public UUID customBossBar(Player player, BossBar.Color color, BossBar.Overlay overlay, List<BossBar.Flag> list, String str, int i, boolean z, List<String> list2) {
        return Clans.getClanCore().getBossBarManager().v8qP8fE86HMhvNuYPFjqY(player, color, overlay, list, str, i, z, list2);
    }

    @Override // me.ulrich.clans.interfaces.LibAPI
    public HashMap<UUID, MyScheduledTask> getActivetasks() {
        return Clans.getClanCore().getBossBarManager().jBUuLP0sWwaPyPOmogdX7l();
    }

    @Override // me.ulrich.clans.interfaces.LibAPI
    public boolean hasChat(Player player) {
        return Clans.getClanCore().getChatManager().v8qP8fE86HMhvNuYPFjqY(player);
    }

    @Override // me.ulrich.clans.interfaces.LibAPI
    public boolean startChat(Player player, CustomChatPrompt customChatPrompt) {
        return Clans.getClanCore().getChatManager().v8qP8fE86HMhvNuYPFjqY(player, customChatPrompt);
    }

    @Override // me.ulrich.clans.interfaces.LibAPI
    public void handleInput(Player player, String str) {
        Clans.getClanCore().getChatManager().v8qP8fE86HMhvNuYPFjqY(player, str);
    }

    @Override // me.ulrich.clans.interfaces.LibAPI
    public boolean cancelChat(Player player) {
        return Clans.getClanCore().getChatManager().jBUuLP0sWwaPyPOmogdX7l(player);
    }

    @Override // me.ulrich.clans.interfaces.LibAPI
    public boolean cancelChat(Player player, boolean z) {
        return Clans.getClanCore().getChatManager().v8qP8fE86HMhvNuYPFjqY(player, z);
    }
}
