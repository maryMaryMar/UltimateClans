package me.ulrich.clans.library.gui.components.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import me.ulrich.clans.library.gui.components.GuiType;
import me.ulrich.clans.library.gui.components.exception.GuiException;
import me.ulrich.clans.library.gui.guis.BaseGui;
import me.ulrich.clans.library.gui.guis.GuiItem;
import me.ulrich.clans.library.gui.guis.PaginatedGui;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/gui/components/util/GuiFiller.class */
public final class GuiFiller {
    private final BaseGui gui;

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/gui/components/util/GuiFiller$Side.class */
    public enum Side {
        LEFT,
        RIGHT,
        BOTH
    }

    public GuiFiller(BaseGui baseGui) {
        this.gui = baseGui;
    }

    public void fillTop(@NotNull GuiItem guiItem) {
        fillTop(Collections.singletonList(guiItem));
    }

    public void fillTop(@NotNull List<GuiItem> list) {
        List<GuiItem> listRepeatList = repeatList(list);
        for (int i = 0; i < 9; i++) {
            if (!this.gui.getGuiItems().containsKey(Integer.valueOf(i))) {
                this.gui.setItem(i, listRepeatList.get(i));
            }
        }
    }

    public void fillBottom(@NotNull GuiItem guiItem) {
        fillBottom(Collections.singletonList(guiItem));
    }

    public void fillBottom(@NotNull List<GuiItem> list) {
        int rows = this.gui.getRows();
        List<GuiItem> listRepeatList = repeatList(list);
        for (int i = 9; i > 0; i--) {
            if (this.gui.getGuiItems().get(Integer.valueOf((rows * 9) - i)) == null) {
                this.gui.setItem((rows * 9) - i, listRepeatList.get(i));
            }
        }
    }

    public void fillBorder(@NotNull GuiItem guiItem) {
        fillBorder(Collections.singletonList(guiItem));
    }

    public void fillBorder(@NotNull List<GuiItem> list) {
        int rows = this.gui.getRows();
        if (rows <= 2) {
            return;
        }
        List<GuiItem> listRepeatList = repeatList(list);
        for (int i = 0; i < rows * 9; i++) {
            if (i <= 8 || ((i >= (rows * 9) - 8 && i <= (rows * 9) - 2) || i % 9 == 0 || i % 9 == 8)) {
                this.gui.setItem(i, listRepeatList.get(i));
            }
        }
    }

    public void fillBetweenPoints(int i, int i2, int i3, int i4, @NotNull GuiItem guiItem) {
        fillBetweenPoints(i, i2, i3, i4, Collections.singletonList(guiItem));
    }

    public void fillBetweenPoints(int i, int i2, int i3, int i4, @NotNull List<GuiItem> list) {
        int iMin = Math.min(i, i3);
        int iMax = Math.max(i, i3);
        int iMin2 = Math.min(i2, i4);
        int iMax2 = Math.max(i2, i4);
        int rows = this.gui.getRows();
        List<GuiItem> listRepeatList = repeatList(list);
        for (int i5 = 1; i5 <= rows; i5++) {
            for (int i6 = 1; i6 <= 9; i6++) {
                int slotFromRowCol = getSlotFromRowCol(i5, i6);
                if (i5 >= iMin && i5 <= iMax && i6 >= iMin2 && i6 <= iMax2) {
                    this.gui.setItem(slotFromRowCol, listRepeatList.get(slotFromRowCol));
                }
            }
        }
    }

    public void fill(@NotNull GuiItem guiItem) {
        fill(Collections.singletonList(guiItem));
    }

    public void fill(@NotNull List<GuiItem> list) {
        if (this.gui instanceof PaginatedGui) {
            throw new GuiException("Full filling a GUI is not supported in a Paginated GUI!");
        }
        GuiType guiType = this.gui.guiType();
        int rows = guiType == GuiType.CHEST ? this.gui.getRows() * guiType.getLimit() : guiType.getFillSize();
        List<GuiItem> listRepeatList = repeatList(list);
        for (int i = 0; i < rows; i++) {
            if (this.gui.getGuiItems().get(Integer.valueOf(i)) == null) {
                this.gui.setItem(i, listRepeatList.get(i));
            }
        }
    }

    public void fillSide(@NotNull Side side, @NotNull List<GuiItem> list) {
        switch (side) {
            case LEFT:
                fillBetweenPoints(1, 1, this.gui.getRows(), 1, list);
                break;
            case RIGHT:
                fillBetweenPoints(1, 9, this.gui.getRows(), 9, list);
                break;
            case BOTH:
                fillSide(Side.LEFT, list);
                fillSide(Side.RIGHT, list);
                break;
        }
    }

    private List<GuiItem> repeatList(@NotNull List<GuiItem> list) {
        ArrayList arrayList = new ArrayList();
        List listNCopies = Collections.nCopies(this.gui.getRows() * 9, list);
        Objects.requireNonNull(arrayList);
        listNCopies.forEach((v1) -> {
            r1.addAll(v1);
        });
        return arrayList;
    }

    private int getSlotFromRowCol(int i, int i2) {
        return (i2 + ((i - 1) * 9)) - 1;
    }
}
