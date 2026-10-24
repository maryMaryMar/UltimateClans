package me.ulrich.clans.library.gui.guis;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import me.ulrich.clans.library.gui.components.GuiContainer;
import me.ulrich.clans.library.gui.components.InteractionModifier;
import me.ulrich.clans.library.gui.components.ScrollType;
import org.bukkit.entity.HumanEntity;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/gui/guis/ScrollingGui.class */
public class ScrollingGui extends PaginatedGui {
    private final ScrollType scrollType;
    private int scrollSize;

    public ScrollingGui(@NotNull GuiContainer guiContainer, int i, @NotNull ScrollType scrollType, @NotNull Set<InteractionModifier> set) {
        super(guiContainer, i, set);
        this.scrollSize = 0;
        this.scrollType = scrollType;
    }

    @Override // me.ulrich.clans.library.gui.guis.PaginatedGui
    public boolean next() {
        if ((getPageNum() * this.scrollSize) + getPageSize() >= getPageItems().size() + this.scrollSize) {
            return false;
        }
        setPageNum(getPageNum() + 1);
        updatePage();
        return true;
    }

    @Override // me.ulrich.clans.library.gui.guis.PaginatedGui
    public boolean previous() {
        if (getPageNum() - 1 == 0) {
            return false;
        }
        setPageNum(getPageNum() - 1);
        updatePage();
        return true;
    }

    @Override // me.ulrich.clans.library.gui.guis.PaginatedGui, me.ulrich.clans.library.gui.guis.BaseGui
    public void open(@NotNull HumanEntity humanEntity) {
        open(humanEntity, 1);
    }

    @Override // me.ulrich.clans.library.gui.guis.PaginatedGui
    public void open(@NotNull HumanEntity humanEntity, int i) {
        if (humanEntity.isSleeping()) {
            return;
        }
        getInventory().clear();
        getMutableCurrentPageItems().clear();
        populateGui();
        if (getPageSize() == 0) {
            setPageSize(calculatePageSize());
        }
        if (this.scrollSize == 0) {
            this.scrollSize = calculateScrollSize();
        }
        if (i > 0 && (i * this.scrollSize) + getPageSize() <= getPageItems().size() + this.scrollSize) {
            setPageNum(i);
        }
        populatePage();
        humanEntity.openInventory(getInventory());
    }

    @Override // me.ulrich.clans.library.gui.guis.PaginatedGui
    void updatePage() {
        clearPage();
        populatePage();
    }

    private void populatePage() {
        for (GuiItem guiItem : getPage(getPageNum())) {
            if (this.scrollType == ScrollType.HORIZONTAL) {
                putItemHorizontally(guiItem);
            } else {
                putItemVertically(guiItem);
            }
        }
    }

    private int calculateScrollSize() {
        int i = 0;
        if (this.scrollType == ScrollType.VERTICAL) {
            boolean z = false;
            for (int i2 = 1; i2 <= getRows(); i2++) {
                for (int i3 = 1; i3 <= 9; i3++) {
                    if (getInventory().getItem(getSlotFromRowCol(i2, i3)) == null) {
                        if (!z) {
                            z = true;
                        }
                        i++;
                    }
                }
                if (z) {
                    return i;
                }
            }
            return i;
        }
        boolean z2 = false;
        for (int i4 = 1; i4 <= 9; i4++) {
            for (int i5 = 1; i5 <= getRows(); i5++) {
                if (getInventory().getItem(getSlotFromRowCol(i5, i4)) == null) {
                    if (!z2) {
                        z2 = true;
                    }
                    i++;
                }
            }
            if (z2) {
                return i;
            }
        }
        return i;
    }

    private void putItemVertically(GuiItem guiItem) {
        for (int i = 0; i < getRows() * 9; i++) {
            if (getGuiItem(i) == null && getInventory().getItem(i) == null) {
                getMutableCurrentPageItems().put(Integer.valueOf(i), guiItem);
                getInventory().setItem(i, guiItem.getItemStack());
                return;
            }
        }
    }

    private void putItemHorizontally(GuiItem guiItem) {
        for (int i = 1; i < 10; i++) {
            for (int i2 = 1; i2 <= getRows(); i2++) {
                int slotFromRowCol = getSlotFromRowCol(i2, i);
                if (getGuiItem(slotFromRowCol) == null && getInventory().getItem(slotFromRowCol) == null) {
                    getMutableCurrentPageItems().put(Integer.valueOf(slotFromRowCol), guiItem);
                    getInventory().setItem(slotFromRowCol, guiItem.getItemStack());
                    return;
                }
            }
        }
    }

    private List<GuiItem> getPage(int i) {
        int i2 = i - 1;
        int size = getPageItems().size();
        ArrayList arrayList = new ArrayList();
        int pageSize = (i2 * this.scrollSize) + getPageSize();
        if (pageSize > size) {
            pageSize = size;
        }
        for (int i3 = i2 * this.scrollSize; i3 < pageSize; i3++) {
            arrayList.add(getPageItems().get(i3));
        }
        return arrayList;
    }
}
