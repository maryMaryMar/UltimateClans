package me.ulrich.clans.library.gui.guis;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import me.ulrich.clans.library.gui.TriumphGui;
import me.ulrich.clans.library.gui.components.GuiAction;
import me.ulrich.clans.library.gui.components.GuiContainer;
import me.ulrich.clans.library.gui.components.GuiType;
import me.ulrich.clans.library.gui.components.InteractionModifier;
import me.ulrich.clans.library.gui.components.exception.GuiException;
import me.ulrich.clans.library.gui.components.util.GuiFiller;
import me.ulrich.clans.library.gui.components.util.VersionHelper;
import me.ulrich.clans.library.kyori.adventure.text.Component;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.standard.DecorationTag;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/gui/guis/BaseGui.class */
public abstract class BaseGui implements InventoryHolder {
    private static final Plugin plugin = TriumphGui.getPlugin();
    private static Method GET_SCHEDULER_METHOD;
    private static Method EXECUTE_METHOD;
    private final Map<Integer, GuiItem> guiItems;
    private final Map<Integer, GuiAction<InventoryClickEvent>> slotActions;
    private final Set<InteractionModifier> interactionModifiers;
    private final GuiContainer guiContainer;
    private Inventory inventory;
    private GuiAction<InventoryClickEvent> defaultClickAction;
    private GuiAction<InventoryClickEvent> defaultTopClickAction;
    private GuiAction<InventoryClickEvent> playerInventoryAction;
    private GuiAction<InventoryDragEvent> dragAction;
    private GuiAction<InventoryCloseEvent> closeGuiAction;
    private GuiAction<InventoryOpenEvent> openGuiAction;
    private GuiAction<InventoryClickEvent> outsideClickAction;
    private boolean updating;
    private final GuiFiller filler = new GuiFiller(this);
    private boolean runCloseAction = true;
    private boolean runOpenAction = true;

    public BaseGui(@NotNull GuiContainer guiContainer, @NotNull Set<InteractionModifier> set) {
        this.interactionModifiers = safeCopyOf(set);
        this.guiContainer = guiContainer;
        this.inventory = guiContainer.createInventory(this);
        this.slotActions = new LinkedHashMap(guiContainer.inventorySize());
        this.guiItems = new LinkedHashMap(guiContainer.inventorySize());
    }

    @NotNull
    private Set<InteractionModifier> safeCopyOf(@NotNull Set<InteractionModifier> set) {
        return set.isEmpty() ? EnumSet.noneOf(InteractionModifier.class) : EnumSet.copyOf((Collection) set);
    }

    @NotNull
    public Component title() {
        return this.guiContainer.title();
    }

    public void setItem(int i, @NotNull GuiItem guiItem) {
        validateSlot(i);
        this.guiItems.put(Integer.valueOf(i), guiItem);
    }

    public void removeItem(@NotNull GuiItem guiItem) {
        this.guiItems.entrySet().stream().filter(entry -> {
            return ((GuiItem) entry.getValue()).equals(guiItem);
        }).findFirst().ifPresent(entry2 -> {
            this.guiItems.remove(entry2.getKey());
            this.inventory.remove(((GuiItem) entry2.getValue()).getItemStack());
        });
    }

    public void removeItem(@NotNull ItemStack itemStack) {
        this.guiItems.entrySet().stream().filter(entry -> {
            return ((GuiItem) entry.getValue()).getItemStack().equals(itemStack);
        }).findFirst().ifPresent(entry2 -> {
            this.guiItems.remove(entry2.getKey());
            this.inventory.remove(itemStack);
        });
    }

    public void removeItem(int i) {
        validateSlot(i);
        this.guiItems.remove(Integer.valueOf(i));
        this.inventory.setItem(i, (ItemStack) null);
    }

    public void removeItem(int i, int i2) {
        removeItem(getSlotFromRowCol(i, i2));
    }

    public void setItem(@NotNull List<Integer> list, @NotNull GuiItem guiItem) {
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            setItem(it.next().intValue(), guiItem);
        }
    }

    public void setItem(int i, int i2, @NotNull GuiItem guiItem) {
        setItem(getSlotFromRowCol(i, i2), guiItem);
    }

    public void clearItems() {
        this.guiItems.clear();
    }

    public void addItem(@NotNull GuiItem... guiItemArr) {
        addItem(false, guiItemArr);
    }

    public void addItem(boolean z, @NotNull GuiItem... guiItemArr) {
        ArrayList arrayList = new ArrayList();
        int iRows = this.guiContainer.rows();
        GuiType guiType = this.guiContainer.guiType();
        for (GuiItem guiItem : guiItemArr) {
            for (int i = 0; i < iRows * 9; i++) {
                if (this.guiItems.get(Integer.valueOf(i)) == null) {
                    this.guiItems.put(Integer.valueOf(i), guiItem);
                    break;
                } else {
                    if (i == (iRows * 9) - 1) {
                        arrayList.add(guiItem);
                    }
                }
            }
        }
        if (z && iRows < 6 && !arrayList.isEmpty() && guiType == GuiType.CHEST && (this.guiContainer instanceof GuiContainer.Chest)) {
            ((GuiContainer.Chest) this.guiContainer).rows(this.guiContainer.rows() + 1);
            this.inventory = this.guiContainer.createInventory(this);
            update();
            addItem(true, (GuiItem[]) arrayList.toArray(new GuiItem[0]));
        }
    }

    public void addSlotAction(int i, @Nullable GuiAction<InventoryClickEvent> guiAction) {
        validateSlot(i);
        this.slotActions.put(Integer.valueOf(i), guiAction);
    }

    public void addSlotAction(int i, int i2, @Nullable GuiAction<InventoryClickEvent> guiAction) {
        addSlotAction(getSlotFromRowCol(i, i2), guiAction);
    }

    @Nullable
    public GuiItem getGuiItem(int i) {
        return this.guiItems.get(Integer.valueOf(i));
    }

    public boolean isUpdating() {
        return this.updating;
    }

    public void setUpdating(boolean z) {
        this.updating = z;
    }

    public void open(@NotNull HumanEntity humanEntity) {
        if (humanEntity.isSleeping()) {
            return;
        }
        this.inventory.clear();
        populateGui();
        humanEntity.openInventory(this.inventory);
    }

    public void close(@NotNull HumanEntity humanEntity) {
        close(humanEntity, true);
    }

    public void close(@NotNull HumanEntity humanEntity, boolean z) {
        Runnable runnable = () -> {
            this.runCloseAction = z;
            humanEntity.closeInventory();
            this.runCloseAction = true;
        };
        if (!VersionHelper.IS_FOLIA) {
            Bukkit.getScheduler().runTaskLater(plugin, runnable, 2L);
        } else {
            if (GET_SCHEDULER_METHOD == null || EXECUTE_METHOD == null) {
                throw new GuiException("Could not find Folia Scheduler methods.");
            }
            try {
                EXECUTE_METHOD.invoke(GET_SCHEDULER_METHOD.invoke(humanEntity, new Object[0]), plugin, runnable, null, 2L);
            } catch (IllegalAccessException | InvocationTargetException e) {
                throw new GuiException("Could not invoke Folia task.", e);
            }
        }
    }

    public void update() {
        this.inventory.clear();
        populateGui();
    }

    @Contract("_ -> this")
    @NotNull
    public BaseGui updateTitle(@NotNull Component component) {
        this.updating = true;
        ArrayList arrayList = new ArrayList(this.inventory.getViewers());
        this.guiContainer.title(component);
        this.inventory = this.guiContainer.createInventory(this);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            open((HumanEntity) it.next());
        }
        this.updating = false;
        return this;
    }

    public void updateItem(int i, @NotNull ItemStack itemStack) {
        GuiItem guiItem = this.guiItems.get(Integer.valueOf(i));
        if (guiItem == null) {
            updateItem(i, new GuiItem(itemStack));
        } else {
            guiItem.setItemStack(itemStack);
            updateItem(i, guiItem);
        }
    }

    public void updateItem(int i, int i2, @NotNull ItemStack itemStack) {
        updateItem(getSlotFromRowCol(i, i2), itemStack);
    }

    public void updateItem(int i, @NotNull GuiItem guiItem) {
        this.guiItems.put(Integer.valueOf(i), guiItem);
        this.inventory.setItem(i, guiItem.getItemStack());
    }

    public void updateItem(int i, int i2, @NotNull GuiItem guiItem) {
        updateItem(getSlotFromRowCol(i, i2), guiItem);
    }

    @Contract(" -> this")
    @NotNull
    public BaseGui disableItemPlace() {
        this.interactionModifiers.add(InteractionModifier.PREVENT_ITEM_PLACE);
        return this;
    }

    @Contract(" -> this")
    @NotNull
    public BaseGui disableItemTake() {
        this.interactionModifiers.add(InteractionModifier.PREVENT_ITEM_TAKE);
        return this;
    }

    @Contract(" -> this")
    @NotNull
    public BaseGui disableItemSwap() {
        this.interactionModifiers.add(InteractionModifier.PREVENT_ITEM_SWAP);
        return this;
    }

    @Contract(" -> this")
    @NotNull
    public BaseGui disableItemDrop() {
        this.interactionModifiers.add(InteractionModifier.PREVENT_ITEM_DROP);
        return this;
    }

    @Contract(" -> this")
    @NotNull
    public BaseGui disableOtherActions() {
        this.interactionModifiers.add(InteractionModifier.PREVENT_OTHER_ACTIONS);
        return this;
    }

    @Contract(" -> this")
    @NotNull
    public BaseGui disableAllInteractions() {
        this.interactionModifiers.addAll(InteractionModifier.VALUES);
        return this;
    }

    @Contract(" -> this")
    @NotNull
    public BaseGui enableItemPlace() {
        this.interactionModifiers.remove(InteractionModifier.PREVENT_ITEM_PLACE);
        return this;
    }

    @Contract(" -> this")
    @NotNull
    public BaseGui enableItemTake() {
        this.interactionModifiers.remove(InteractionModifier.PREVENT_ITEM_TAKE);
        return this;
    }

    @Contract(" -> this")
    @NotNull
    public BaseGui enableItemSwap() {
        this.interactionModifiers.remove(InteractionModifier.PREVENT_ITEM_SWAP);
        return this;
    }

    @Contract(" -> this")
    @NotNull
    public BaseGui enableItemDrop() {
        this.interactionModifiers.remove(InteractionModifier.PREVENT_ITEM_DROP);
        return this;
    }

    @Contract(" -> this")
    @NotNull
    public BaseGui enableOtherActions() {
        this.interactionModifiers.remove(InteractionModifier.PREVENT_OTHER_ACTIONS);
        return this;
    }

    @Contract(" -> this")
    @NotNull
    public BaseGui enableAllInteractions() {
        this.interactionModifiers.clear();
        return this;
    }

    public boolean allInteractionsDisabled() {
        return this.interactionModifiers.size() == InteractionModifier.VALUES.size();
    }

    public boolean canPlaceItems() {
        return !this.interactionModifiers.contains(InteractionModifier.PREVENT_ITEM_PLACE);
    }

    public boolean canTakeItems() {
        return !this.interactionModifiers.contains(InteractionModifier.PREVENT_ITEM_TAKE);
    }

    public boolean canSwapItems() {
        return !this.interactionModifiers.contains(InteractionModifier.PREVENT_ITEM_SWAP);
    }

    public boolean canDropItems() {
        return !this.interactionModifiers.contains(InteractionModifier.PREVENT_ITEM_DROP);
    }

    public boolean allowsOtherActions() {
        return !this.interactionModifiers.contains(InteractionModifier.PREVENT_OTHER_ACTIONS);
    }

    @NotNull
    public GuiFiller getFiller() {
        return this.filler;
    }

    @NotNull
    public Map<Integer, GuiItem> getGuiItems() {
        return Collections.unmodifiableMap(this.guiItems);
    }

    @NotNull
    public Inventory getInventory() {
        return this.inventory;
    }

    public void setInventory(@NotNull Inventory inventory) {
        this.inventory = inventory;
    }

    public int getRows() {
        return this.guiContainer.rows();
    }

    @NotNull
    public GuiType guiType() {
        return this.guiContainer.guiType();
    }

    @Nullable
    GuiAction<InventoryClickEvent> getDefaultClickAction() {
        return this.defaultClickAction;
    }

    public void setDefaultClickAction(@Nullable GuiAction<InventoryClickEvent> guiAction) {
        this.defaultClickAction = guiAction;
    }

    @Nullable
    GuiAction<InventoryClickEvent> getDefaultTopClickAction() {
        return this.defaultTopClickAction;
    }

    public void setDefaultTopClickAction(@Nullable GuiAction<InventoryClickEvent> guiAction) {
        this.defaultTopClickAction = guiAction;
    }

    @Nullable
    GuiAction<InventoryClickEvent> getPlayerInventoryAction() {
        return this.playerInventoryAction;
    }

    public void setPlayerInventoryAction(@Nullable GuiAction<InventoryClickEvent> guiAction) {
        this.playerInventoryAction = guiAction;
    }

    @Nullable
    GuiAction<InventoryDragEvent> getDragAction() {
        return this.dragAction;
    }

    public void setDragAction(@Nullable GuiAction<InventoryDragEvent> guiAction) {
        this.dragAction = guiAction;
    }

    @Nullable
    GuiAction<InventoryCloseEvent> getCloseGuiAction() {
        return this.closeGuiAction;
    }

    public void setCloseGuiAction(@Nullable GuiAction<InventoryCloseEvent> guiAction) {
        this.closeGuiAction = guiAction;
    }

    @Nullable
    GuiAction<InventoryOpenEvent> getOpenGuiAction() {
        return this.openGuiAction;
    }

    public void setOpenGuiAction(@Nullable GuiAction<InventoryOpenEvent> guiAction) {
        this.openGuiAction = guiAction;
    }

    @Nullable
    GuiAction<InventoryClickEvent> getOutsideClickAction() {
        return this.outsideClickAction;
    }

    public void setOutsideClickAction(@Nullable GuiAction<InventoryClickEvent> guiAction) {
        this.outsideClickAction = guiAction;
    }

    @Nullable
    GuiAction<InventoryClickEvent> getSlotAction(int i) {
        return this.slotActions.get(Integer.valueOf(i));
    }

    void populateGui() {
        for (Map.Entry<Integer, GuiItem> entry : this.guiItems.entrySet()) {
            this.inventory.setItem(entry.getKey().intValue(), entry.getValue().getItemStack());
        }
    }

    boolean shouldRunCloseAction() {
        return this.runCloseAction;
    }

    boolean shouldRunOpenAction() {
        return this.runOpenAction;
    }

    int getSlotFromRowCol(int i, int i2) {
        return (i2 + ((i - 1) * 9)) - 1;
    }

    private void validateSlot(int i) {
        GuiType guiType = this.guiContainer.guiType();
        int limit = guiType.getLimit();
        if (guiType == GuiType.CHEST) {
            if (i < 0 || i >= this.guiContainer.rows() * limit) {
                throwInvalidSlot(i);
                return;
            }
            return;
        }
        if (i < 0 || i > limit) {
            throwInvalidSlot(i);
        }
    }

    private void throwInvalidSlot(int i) {
        if (this.guiContainer.guiType() != GuiType.CHEST) {
            throw new GuiException("Slot " + i + " is not valid for the gui type - " + this.guiContainer.guiType().name() + DecorationTag.REVERT);
        }
        throw new GuiException("Slot " + i + " is not valid for the gui type - " + this.guiContainer.guiType().name() + " and rows - " + this.guiContainer.rows() + DecorationTag.REVERT);
    }

    @NotNull
    protected GuiContainer guiContainer() {
        return this.guiContainer;
    }

    static {
        GET_SCHEDULER_METHOD = null;
        EXECUTE_METHOD = null;
        try {
            GET_SCHEDULER_METHOD = Entity.class.getMethod("getScheduler", new Class[0]);
            EXECUTE_METHOD = Class.forName("io.papermc.paper.threadedregions.scheduler.EntityScheduler").getMethod("execute", Plugin.class, Runnable.class, Runnable.class, Long.TYPE);
        } catch (ClassNotFoundException | NoSuchMethodException e) {
        }
        Bukkit.getPluginManager().registerEvents(new GuiListener(), plugin);
        Bukkit.getPluginManager().registerEvents(new InteractionModifierListener(), plugin);
    }
}
