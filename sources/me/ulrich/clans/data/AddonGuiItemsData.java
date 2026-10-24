package me.ulrich.clans.data;

import java.util.List;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/data/AddonGuiItemsData.class */
public class AddonGuiItemsData implements Cloneable {
    private String id;
    private String clickSound;
    private int amount;
    private String material;
    private boolean glow;
    private String name;
    private List<String> lore;
    private String texture;
    private NbtData nbt;
    private int slot;
    private List<String> leftActions;
    private List<String> rightAction;
    private GuiItemsData_fill mineSlots;

    public AddonGuiItemsData(String str, String str2, String str3, int i, boolean z, String str4, List<String> list, String str5, NbtData nbtData, int i2, GuiItemsData_fill guiItemsData_fill, List<String> list2, List<String> list3) {
        setId(str);
        setClickSound(str2);
        setMaterial(str3);
        setAmount(i);
        setGlow(z);
        setName(str4);
        setLore(list);
        setTexture(str5);
        setNbt(nbtData);
        setSlot(i2);
        setMineSlots(guiItemsData_fill);
        setLeftActions(list2);
        setRightAction(list3);
    }

    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public AddonGuiItemsData m386clone() {
        try {
            return (AddonGuiItemsData) super.clone();
        } catch (CloneNotSupportedException e) {
            return this;
        }
    }

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String getClickSound() {
        return this.clickSound;
    }

    public void setClickSound(String str) {
        this.clickSound = str;
    }

    public int getAmount() {
        return this.amount;
    }

    public void setAmount(int i) {
        this.amount = i;
    }

    public String getMaterial() {
        return this.material;
    }

    public void setMaterial(String str) {
        this.material = str;
    }

    public boolean isGlow() {
        return this.glow;
    }

    public void setGlow(boolean z) {
        this.glow = z;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public List<String> getLore() {
        return this.lore;
    }

    public void setLore(List<String> list) {
        this.lore = list;
    }

    public String getTexture() {
        return this.texture;
    }

    public void setTexture(String str) {
        this.texture = str;
    }

    public NbtData getNbt() {
        return this.nbt;
    }

    public void setNbt(NbtData nbtData) {
        this.nbt = nbtData;
    }

    public int getSlot() {
        return this.slot;
    }

    public void setSlot(int i) {
        this.slot = i;
    }

    public List<String> getLeftActions() {
        return this.leftActions;
    }

    public void setLeftActions(List<String> list) {
        this.leftActions = list;
    }

    public List<String> getRightAction() {
        return this.rightAction;
    }

    public void setRightAction(List<String> list) {
        this.rightAction = list;
    }

    public GuiItemsData_fill getMineSlots() {
        return this.mineSlots;
    }

    public void setMineSlots(GuiItemsData_fill guiItemsData_fill) {
        this.mineSlots = guiItemsData_fill;
    }
}
