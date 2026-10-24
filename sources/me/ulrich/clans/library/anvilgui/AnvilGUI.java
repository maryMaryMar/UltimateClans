package me.ulrich.clans.library.anvilgui;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.logging.Level;
import me.ulrich.clans.library.anvilgui.version.VersionMatcher;
import me.ulrich.clans.library.anvilgui.version.VersionWrapper;
import org.apache.commons.lang.Validate;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.geysermc.geyser.api.GeyserApi;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/anvilgui/AnvilGUI.class */
public class AnvilGUI {
    private static final VersionWrapper WRAPPER = new VersionMatcher().match();
    private static final ItemStack AIR = new ItemStack(Material.AIR);
    private final Plugin plugin;
    private final Player player;
    private final Executor mainThreadExecutor;
    private final Object titleComponent;
    private final ItemStack[] initialContents;
    private final boolean preventClose;
    private final boolean geyserCompatibility;
    private final Set<Integer> interactableSlots;
    private final Consumer<StateSnapshot> closeListener;
    private final boolean concurrentClickHandlerExecution;
    private final ClickHandler clickHandler;
    private int containerId;
    private Inventory inventory;
    private final ListenUp listener;
    private boolean open;
    private VersionWrapper.AnvilContainerWrapper container;

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/anvilgui/AnvilGUI$Builder.class */
    public static class Builder {
        private Executor mainThreadExecutor;
        private Consumer<StateSnapshot> closeListener;
        private ClickHandler clickHandler;
        private Plugin plugin;
        private String itemText;
        private ItemStack itemLeft;
        private ItemStack itemRight;
        private ItemStack itemOutput;
        private boolean concurrentClickHandlerExecution = false;
        private boolean preventClose = false;
        private boolean geyserCompatibility = true;
        private Set<Integer> interactableSlots = Collections.emptySet();
        private Object titleComponent = AnvilGUI.WRAPPER.literalChatComponent("Repair & Name");

        public Builder mainThreadExecutor(Executor executor) {
            Validate.notNull(executor, "Executor cannot be null");
            this.mainThreadExecutor = executor;
            return this;
        }

        public Builder preventClose() {
            this.preventClose = true;
            return this;
        }

        public Builder disableGeyserCompat() {
            this.geyserCompatibility = false;
            return this;
        }

        public Builder interactableSlots(int... iArr) {
            HashSet hashSet = new HashSet();
            for (int i : iArr) {
                hashSet.add(Integer.valueOf(i));
            }
            this.interactableSlots = hashSet;
            return this;
        }

        public Builder onClose(Consumer<StateSnapshot> consumer) {
            Validate.notNull(consumer, "closeListener cannot be null");
            this.closeListener = consumer;
            return this;
        }

        public Builder onClickAsync(ClickHandler clickHandler) {
            Validate.notNull(clickHandler, "click function cannot be null");
            this.clickHandler = clickHandler;
            return this;
        }

        public Builder allowConcurrentClickHandlerExecution() {
            this.concurrentClickHandlerExecution = true;
            return this;
        }

        public Builder onClick(BiFunction<Integer, StateSnapshot, List<ResponseAction>> biFunction) {
            Validate.notNull(biFunction, "click function cannot be null");
            this.clickHandler = (num, stateSnapshot) -> {
                return CompletableFuture.completedFuture((List) biFunction.apply(num, stateSnapshot));
            };
            return this;
        }

        public Builder plugin(Plugin plugin) {
            Validate.notNull(plugin, "Plugin cannot be null");
            this.plugin = plugin;
            return this;
        }

        public Builder text(String str) {
            Validate.notNull(str, "Text cannot be null");
            this.itemText = str;
            return this;
        }

        public Builder title(String str) {
            Validate.notNull(str, "title cannot be null");
            this.titleComponent = AnvilGUI.WRAPPER.literalChatComponent(str);
            return this;
        }

        public Builder jsonTitle(String str) {
            Validate.notNull(str, "json cannot be null");
            this.titleComponent = AnvilGUI.WRAPPER.jsonChatComponent(str);
            return this;
        }

        public Builder itemLeft(ItemStack itemStack) {
            Validate.notNull(itemStack, "item cannot be null");
            this.itemLeft = itemStack;
            return this;
        }

        public Builder itemRight(ItemStack itemStack) {
            this.itemRight = itemStack;
            return this;
        }

        public Builder itemOutput(ItemStack itemStack) {
            this.itemOutput = itemStack;
            return this;
        }

        public AnvilGUI open(Player player) {
            Validate.notNull(this.plugin, "Plugin cannot be null");
            Validate.notNull(this.clickHandler, "click handler cannot be null");
            Validate.notNull(player, "Player cannot be null");
            if (this.itemText != null) {
                if (this.itemLeft == null) {
                    this.itemLeft = new ItemStack(Material.PAPER);
                }
                ItemMeta itemMeta = this.itemLeft.getItemMeta();
                itemMeta.setDisplayName(this.itemText);
                this.itemLeft.setItemMeta(itemMeta);
            }
            if (this.mainThreadExecutor == null) {
                this.mainThreadExecutor = runnable -> {
                    Bukkit.getScheduler().runTask(this.plugin, runnable);
                };
            }
            AnvilGUI anvilGUI = new AnvilGUI(this.plugin, player, this.mainThreadExecutor, this.titleComponent, new ItemStack[]{this.itemLeft, this.itemRight, this.itemOutput}, this.preventClose, this.geyserCompatibility, this.interactableSlots, this.closeListener, this.concurrentClickHandlerExecution, this.clickHandler);
            anvilGUI.openInventory();
            return anvilGUI;
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/anvilgui/AnvilGUI$ClickHandler.class */
    @FunctionalInterface
    public interface ClickHandler extends BiFunction<Integer, StateSnapshot, CompletableFuture<List<ResponseAction>>> {
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/anvilgui/AnvilGUI$ListenUp.class */
    private class ListenUp implements Listener {
        private boolean clickHandlerRunning;

        private ListenUp() {
            this.clickHandlerRunning = false;
        }

        @EventHandler
        public void onInventoryClick(InventoryClickEvent inventoryClickEvent) {
            int rawSlot;
            if (inventoryClickEvent.getInventory().equals(AnvilGUI.this.inventory) && (rawSlot = inventoryClickEvent.getRawSlot()) != -999) {
                Player whoClicked = inventoryClickEvent.getWhoClicked();
                Inventory clickedInventory = inventoryClickEvent.getClickedInventory();
                if (clickedInventory != null) {
                    if (clickedInventory.equals(whoClicked.getInventory())) {
                        if (inventoryClickEvent.getClick().equals(ClickType.DOUBLE_CLICK)) {
                            inventoryClickEvent.setCancelled(true);
                            return;
                        } else if (inventoryClickEvent.isShiftClick()) {
                            inventoryClickEvent.setCancelled(true);
                            return;
                        }
                    }
                    if (inventoryClickEvent.getCursor() != null && inventoryClickEvent.getCursor().getType() != Material.AIR && !AnvilGUI.this.interactableSlots.contains(Integer.valueOf(rawSlot)) && inventoryClickEvent.getClickedInventory().equals(AnvilGUI.this.inventory)) {
                        inventoryClickEvent.setCancelled(true);
                        return;
                    }
                }
                if ((rawSlot >= 3 || rawSlot < 0) && !inventoryClickEvent.getAction().equals(InventoryAction.MOVE_TO_OTHER_INVENTORY)) {
                    return;
                }
                inventoryClickEvent.setCancelled(!AnvilGUI.this.interactableSlots.contains(Integer.valueOf(rawSlot)));
                if (!this.clickHandlerRunning || AnvilGUI.this.concurrentClickHandlerExecution) {
                    CompletableFuture<List<ResponseAction>> completableFutureApply = AnvilGUI.this.clickHandler.apply(Integer.valueOf(rawSlot), StateSnapshot.fromAnvilGUI(AnvilGUI.this));
                    Consumer<? super List<ResponseAction>> consumer = list -> {
                        Iterator it = list.iterator();
                        while (it.hasNext()) {
                            ((ResponseAction) it.next()).accept(AnvilGUI.this, whoClicked);
                        }
                    };
                    if (completableFutureApply.isDone()) {
                        completableFutureApply.thenAccept(consumer).join();
                    } else {
                        this.clickHandlerRunning = true;
                        completableFutureApply.thenAcceptAsync(consumer, AnvilGUI.this.mainThreadExecutor).handle((r6, th) -> {
                            if (th != null) {
                                AnvilGUI.this.plugin.getLogger().log(Level.SEVERE, "An exception occurred in the AnvilGUI clickHandler", th);
                            }
                            this.clickHandlerRunning = false;
                            return null;
                        });
                    }
                }
            }
        }

        @EventHandler
        public void onInventoryDrag(InventoryDragEvent inventoryDragEvent) {
            if (inventoryDragEvent.getInventory().equals(AnvilGUI.this.inventory)) {
                for (int i : Slot.values()) {
                    if (inventoryDragEvent.getRawSlots().contains(Integer.valueOf(i))) {
                        inventoryDragEvent.setCancelled(!AnvilGUI.this.interactableSlots.contains(Integer.valueOf(i)));
                        return;
                    }
                }
            }
        }

        @EventHandler
        public void onInventoryClose(InventoryCloseEvent inventoryCloseEvent) {
            if (AnvilGUI.this.open && inventoryCloseEvent.getInventory().equals(AnvilGUI.this.inventory)) {
                AnvilGUI.this.closeInventory(false);
                if (AnvilGUI.this.preventClose) {
                    Executor executor = AnvilGUI.this.mainThreadExecutor;
                    AnvilGUI anvilGUI = AnvilGUI.this;
                    executor.execute(() -> {
                        anvilGUI.openInventory();
                    });
                }
            }
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/anvilgui/AnvilGUI$Response.class */
    @Deprecated
    public static class Response {
        public static List<ResponseAction> close() {
            return Arrays.asList(ResponseAction.close());
        }

        public static List<ResponseAction> text(String str) {
            return Arrays.asList(ResponseAction.replaceInputText(str));
        }

        public static List<ResponseAction> openInventory(Inventory inventory) {
            return Arrays.asList(ResponseAction.openInventory(inventory));
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/anvilgui/AnvilGUI$ResponseAction.class */
    @FunctionalInterface
    public interface ResponseAction extends BiConsumer<AnvilGUI, Player> {
        static ResponseAction replaceInputText(String str) {
            Validate.notNull(str, "text cannot be null");
            return (anvilGUI, player) -> {
                ItemStack item = anvilGUI.getInventory().getItem(2);
                if (item == null) {
                    item = anvilGUI.getInventory().getItem(0);
                }
                if (item == null) {
                    throw new IllegalStateException("replaceInputText can only be used if slots OUTPUT or INPUT_LEFT are not empty");
                }
                ItemStack itemStackClone = item.clone();
                ItemMeta itemMeta = itemStackClone.getItemMeta();
                itemMeta.setDisplayName(str);
                itemStackClone.setItemMeta(itemMeta);
                anvilGUI.getInventory().setItem(0, itemStackClone);
            };
        }

        static ResponseAction updateTitle(String str, boolean z) {
            Validate.notNull(str, "literalTitle cannot be null");
            return (anvilGUI, player) -> {
                anvilGUI.setTitle(str, z);
            };
        }

        static ResponseAction updateJsonTitle(String str, boolean z) {
            Validate.notNull(str, "json cannot be null");
            return (anvilGUI, player) -> {
                anvilGUI.setJsonTitle(str, z);
            };
        }

        static ResponseAction openInventory(Inventory inventory) {
            Validate.notNull(inventory, "otherInventory cannot be null");
            return (anvilGUI, player) -> {
                player.openInventory(inventory);
            };
        }

        static ResponseAction close() {
            return (anvilGUI, player) -> {
                anvilGUI.closeInventory();
            };
        }

        static ResponseAction run(Runnable runnable) {
            Validate.notNull(runnable, "runnable cannot be null");
            return (anvilGUI, player) -> {
                runnable.run();
            };
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/anvilgui/AnvilGUI$Slot.class */
    public static class Slot {
        private static final int[] values = {0, 1, 2};
        public static final int INPUT_LEFT = 0;
        public static final int INPUT_RIGHT = 1;
        public static final int OUTPUT = 2;

        public static int[] values() {
            return values;
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/anvilgui/AnvilGUI$StateSnapshot.class */
    public static final class StateSnapshot {
        private final ItemStack leftItem;
        private final ItemStack rightItem;
        private final ItemStack outputItem;
        private final Player player;

        /* JADX INFO: Access modifiers changed from: private */
        public static StateSnapshot fromAnvilGUI(AnvilGUI anvilGUI) {
            Inventory inventory = anvilGUI.getInventory();
            return new StateSnapshot(AnvilGUI.itemNotNull(inventory.getItem(0)).clone(), AnvilGUI.itemNotNull(inventory.getItem(1)).clone(), AnvilGUI.itemNotNull(inventory.getItem(2)).clone(), anvilGUI.player);
        }

        public StateSnapshot(ItemStack itemStack, ItemStack itemStack2, ItemStack itemStack3, Player player) {
            this.leftItem = itemStack;
            this.rightItem = itemStack2;
            this.outputItem = itemStack3;
            this.player = player;
        }

        public ItemStack getLeftItem() {
            return this.leftItem;
        }

        public ItemStack getRightItem() {
            return this.rightItem;
        }

        public ItemStack getOutputItem() {
            return this.outputItem;
        }

        public Player getPlayer() {
            return this.player;
        }

        public String getText() {
            return this.outputItem.hasItemMeta() ? this.outputItem.getItemMeta().getDisplayName() : "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ItemStack itemNotNull(ItemStack itemStack) {
        return itemStack == null ? AIR : itemStack;
    }

    private AnvilGUI(Plugin plugin, Player player, Executor executor, Object obj, ItemStack[] itemStackArr, boolean z, boolean z2, Set<Integer> set, Consumer<StateSnapshot> consumer, boolean z3, ClickHandler clickHandler) {
        this.listener = new ListenUp();
        this.plugin = plugin;
        this.player = player;
        this.mainThreadExecutor = executor;
        this.titleComponent = obj;
        this.initialContents = itemStackArr;
        this.preventClose = z;
        this.geyserCompatibility = z2;
        this.interactableSlots = Collections.unmodifiableSet(set);
        this.closeListener = consumer;
        this.concurrentClickHandlerExecution = z3;
        this.clickHandler = clickHandler;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openInventory() {
        Bukkit.getPluginManager().registerEvents(this.listener, this.plugin);
        this.container = WRAPPER.newContainerAnvil(this.player, this.titleComponent);
        this.inventory = this.container.getBukkitInventory();
        for (int i = 0; i < this.initialContents.length; i++) {
            this.inventory.setItem(i, this.initialContents[i]);
        }
        this.containerId = WRAPPER.getNextContainerId(this.player, this.container);
        WRAPPER.handleInventoryCloseEvent(this.player);
        WRAPPER.sendPacketOpenWindow(this.player, this.containerId, this.titleComponent);
        WRAPPER.setActiveContainer(this.player, this.container);
        WRAPPER.setActiveContainerId(this.container, this.containerId);
        WRAPPER.addActiveContainerSlotListener(this.container, this.player);
        if (this.geyserCompatibility && this.plugin.getServer().getPluginManager().getPlugin("Geyser-Spigot") != null && this.plugin.getServer().getPluginManager().getPlugin("Geyser-Spigot").isEnabled() && GeyserApi.api().isBedrockPlayer(this.player.getUniqueId())) {
            WRAPPER.sendPacketExperienceChange(this.player, 20);
        }
        this.open = true;
    }

    public void closeInventory() {
        closeInventory(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void closeInventory(boolean z) {
        if (this.open) {
            this.open = false;
            HandlerList.unregisterAll(this.listener);
            if (z) {
                WRAPPER.handleInventoryCloseEvent(this.player);
                WRAPPER.setActiveContainerDefault(this.player);
                WRAPPER.sendPacketCloseWindow(this.player, this.containerId);
            }
            if (this.geyserCompatibility && this.plugin.getServer().getPluginManager().getPlugin("Geyser-Spigot") != null && this.plugin.getServer().getPluginManager().getPlugin("Geyser-Spigot").isEnabled() && GeyserApi.api().isBedrockPlayer(this.player.getUniqueId())) {
                WRAPPER.sendPacketExperienceChange(this.player, this.player.getLevel());
            }
            if (this.closeListener != null) {
                this.closeListener.accept(StateSnapshot.fromAnvilGUI(this));
            }
        }
    }

    public void setTitle(String str, boolean z) {
        Validate.notNull(str, "literalTitle cannot be null");
        setTitle(WRAPPER.literalChatComponent(str), z);
    }

    public void setJsonTitle(String str, boolean z) {
        Validate.notNull(str, "json cannot be null");
        setTitle(WRAPPER.jsonChatComponent(str), z);
    }

    private void setTitle(Object obj, boolean z) {
        if (WRAPPER.isCustomTitleSupported()) {
            String renameText = this.container.getRenameText();
            WRAPPER.sendPacketOpenWindow(this.player, this.containerId, obj);
            if (z) {
                this.container.setRenameText(renameText == null ? "" : renameText);
            }
        }
    }

    public Inventory getInventory() {
        return this.inventory;
    }
}
