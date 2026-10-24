package me.ulrich.clans.library.gui.guis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import me.ulrich.clans.library.gui.components.GuiContainer;
import me.ulrich.clans.library.gui.components.InteractionModifier;
import me.ulrich.clans.library.kyori.adventure.text.Component;
import org.bukkit.entity.HumanEntity;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/gui/guis/PaginatedGui.class */
public class PaginatedGui extends BaseGui {
    private final List<GuiItem> pageItems;
    private final Map<Integer, GuiItem> currentPage;
    private int pageSize;
    private int pageNum;

    public PaginatedGui(@NotNull GuiContainer guiContainer, int i, @NotNull Set<InteractionModifier> set) {
        super(guiContainer, set);
        this.pageItems = new ArrayList();
        this.pageNum = 1;
        this.pageSize = i;
        this.currentPage = new LinkedHashMap(guiContainer.inventorySize());
    }

    public BaseGui setPageSize(int i) {
        this.pageSize = i;
        return this;
    }

    public void addItem(@NotNull GuiItem guiItem) {
        this.pageItems.add(guiItem);
    }

    @Override // me.ulrich.clans.library.gui.guis.BaseGui
    public void addItem(@NotNull GuiItem... guiItemArr) {
        this.pageItems.addAll(Arrays.asList(guiItemArr));
    }

    @Override // me.ulrich.clans.library.gui.guis.BaseGui
    public void update() {
        getInventory().clear();
        populateGui();
        updatePage();
    }

    public void updatePageItem(int i, @NotNull ItemStack itemStack) {
        if (this.currentPage.containsKey(Integer.valueOf(i))) {
            GuiItem guiItem = this.currentPage.get(Integer.valueOf(i));
            guiItem.setItemStack(itemStack);
            getInventory().setItem(i, guiItem.getItemStack());
        }
    }

    public void updatePageItem(int i, int i2, @NotNull ItemStack itemStack) {
        updateItem(getSlotFromRowCol(i, i2), itemStack);
    }

    public void updatePageItem(int i, @NotNull GuiItem guiItem) {
        if (this.currentPage.containsKey(Integer.valueOf(i))) {
            this.currentPage.get(Integer.valueOf(i));
            int iIndexOf = this.pageItems.indexOf(this.currentPage.get(Integer.valueOf(i)));
            this.currentPage.put(Integer.valueOf(i), guiItem);
            this.pageItems.set(iIndexOf, guiItem);
            getInventory().setItem(i, guiItem.getItemStack());
        }
    }

    public void updatePageItem(int i, int i2, @NotNull GuiItem guiItem) {
        updateItem(getSlotFromRowCol(i, i2), guiItem);
    }

    public void removePageItem(@NotNull GuiItem guiItem) {
        this.pageItems.remove(guiItem);
        updatePage();
    }

    public void removePageItem(@NotNull ItemStack itemStack) {
        this.pageItems.stream().filter(guiItem -> {
            return guiItem.getItemStack().equals(itemStack);
        }).findFirst().ifPresent(this::removePageItem);
    }

    @Override // me.ulrich.clans.library.gui.guis.BaseGui
    public void open(@NotNull HumanEntity humanEntity) {
        open(humanEntity, 1);
    }

    public void open(@NotNull HumanEntity humanEntity, int i) {
        if (humanEntity.isSleeping()) {
            return;
        }
        if (i <= getPagesNum() || i > 0) {
            this.pageNum = i;
        }
        getInventory().clear();
        this.currentPage.clear();
        populateGui();
        if (this.pageSize == 0) {
            this.pageSize = calculatePageSize();
        }
        populatePage();
        humanEntity.openInventory(getInventory());
    }

    @Override // me.ulrich.clans.library.gui.guis.BaseGui
    @NotNull
    public BaseGui updateTitle(@NotNull Component component) {
        setUpdating(true);
        ArrayList arrayList = new ArrayList(getInventory().getViewers());
        GuiContainer guiContainer = guiContainer();
        guiContainer.title(component);
        setInventory(guiContainer.createInventory(this));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            open((HumanEntity) it.next(), getPageNum());
        }
        setUpdating(false);
        return this;
    }

    @NotNull
    public Map<Integer, GuiItem> getCurrentPageItems() {
        return Collections.unmodifiableMap(this.currentPage);
    }

    @NotNull
    public List<GuiItem> getPageItems() {
        return Collections.unmodifiableList(this.pageItems);
    }

    public int getCurrentPageNum() {
        return this.pageNum;
    }

    public int getNextPageNum() {
        return this.pageNum + 1 > getPagesNum() ? this.pageNum : this.pageNum + 1;
    }

    public int getPrevPageNum() {
        return this.pageNum - 1 == 0 ? this.pageNum : this.pageNum - 1;
    }

    public boolean next() {
        if (this.pageNum + 1 > getPagesNum()) {
            return false;
        }
        this.pageNum++;
        updatePage();
        return true;
    }

    public boolean previous() {
        if (this.pageNum - 1 == 0) {
            return false;
        }
        this.pageNum--;
        updatePage();
        return true;
    }

    GuiItem getPageItem(int i) {
        return this.currentPage.get(Integer.valueOf(i));
    }

    private List<GuiItem> getPageNum(int i) {
        int i2 = i - 1;
        ArrayList arrayList = new ArrayList();
        int size = (i2 * this.pageSize) + this.pageSize;
        if (size > this.pageItems.size()) {
            size = this.pageItems.size();
        }
        for (int i3 = i2 * this.pageSize; i3 < size; i3++) {
            arrayList.add(this.pageItems.get(i3));
        }
        return arrayList;
    }

    public int getPagesNum() {
        if (this.pageSize == 0) {
            this.pageSize = calculatePageSize();
        }
        return (int) Math.ceil(((double) this.pageItems.size()) / ((double) this.pageSize));
    }

    private void populatePage() {
        int i = 0;
        int size = getInventory().getSize();
        Iterator<GuiItem> it = getPageNum(this.pageNum).iterator();
        while (it.hasNext() && i < size) {
            if (getGuiItem(i) == null && getInventory().getItem(i) == null) {
                GuiItem next = it.next();
                this.currentPage.put(Integer.valueOf(i), next);
                getInventory().setItem(i, next.getItemStack());
                i++;
            } else {
                i++;
            }
        }
    }

    Map<Integer, GuiItem> getMutableCurrentPageItems() {
        return this.currentPage;
    }

    void clearPage() {
        Iterator<Map.Entry<Integer, GuiItem>> it = this.currentPage.entrySet().iterator();
        while (it.hasNext()) {
            getInventory().setItem(it.next().getKey().intValue(), (ItemStack) null);
        }
    }

    public void clearPageItems(boolean z) {
        this.pageItems.clear();
        if (z) {
            update();
        }
    }

    public void clearPageItems() {
        clearPageItems(false);
    }

    int getPageSize() {
        return this.pageSize;
    }

    int getPageNum() {
        return this.pageNum;
    }

    public void setPageNum(int i) {
        this.pageNum = i;
    }

    void updatePage() {
        clearPage();
        populatePage();
    }

    int calculatePageSize() {
        int i = 0;
        for (int i2 = 0; i2 < getRows() * 9; i2++) {
            if (getGuiItem(i2) == null) {
                i++;
            }
        }
        if (i == 0) {
            return 1;
        }
        return i;
    }
}
