package me.ulrich.clans.data;

import java.util.List;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/data/GuiItemsData_fill.class */
public class GuiItemsData_fill {
    private List<Integer> slots;
    private boolean top;
    private boolean bottom;
    private boolean all;
    private boolean border;

    public GuiItemsData_fill(List<Integer> list, boolean z, boolean z2, boolean z3, boolean z4) {
        setSlots(list);
        setTop(z);
        setBottom(z2);
        setAll(z3);
        setBorder(z4);
    }

    public List<Integer> getSlots() {
        return this.slots;
    }

    public void setSlots(List<Integer> list) {
        this.slots = list;
    }

    public boolean isTop() {
        return this.top;
    }

    public void setTop(boolean z) {
        this.top = z;
    }

    public boolean isBottom() {
        return this.bottom;
    }

    public void setBottom(boolean z) {
        this.bottom = z;
    }

    public boolean isAll() {
        return this.all;
    }

    public void setAll(boolean z) {
        this.all = z;
    }

    public boolean isBorder() {
        return this.border;
    }

    public void setBorder(boolean z) {
        this.border = z;
    }
}
