package me.ulrich.clans.data;

import java.util.List;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/data/GuiItemStack.class */
public class GuiItemStack {
    private String id;
    private String itemstack;
    private String skullOwner;
    private String texture;
    private int data;
    private int amount;
    private int slot;
    private String name;
    private List<String> lore;
    private List<String> enchants;
    private List<String> flags;
    private List<String> leftAction;
    private List<String> rightAction;
    private String soundClick;
    private String banner;
    private NbtData nbt;
    private List<Integer> imitate;

    public GuiItemStack(String str, String str2, String str3, String str4, int i, int i2, int i3, String str5, List<String> list, List<String> list2, List<String> list3, List<String> list4, List<String> list5, String str6, String str7, NbtData nbtData, List<Integer> list6) {
        setId(str);
        setItemstack(str2);
        setSkullOwner(str3);
        setTexture(str4);
        setData(i);
        setAmount(i2);
        setSlot(i3);
        setName(str5);
        setLore(list);
        setEnchants(list2);
        setFlags(list3);
        setLeftAction(list4);
        setRightAction(list5);
        setSoundClick(str6);
        setBanner(str7);
        setNbt(nbtData);
        setImitate(list6);
    }

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String getItemstack() {
        return this.itemstack;
    }

    public void setItemstack(String str) {
        this.itemstack = str;
    }

    public String getSkullOwner() {
        return this.skullOwner;
    }

    public void setSkullOwner(String str) {
        this.skullOwner = str;
    }

    public String getTexture() {
        return this.texture;
    }

    public void setTexture(String str) {
        this.texture = str;
    }

    public int getData() {
        return this.data;
    }

    public void setData(int i) {
        this.data = i;
    }

    public int getAmount() {
        return this.amount;
    }

    public void setAmount(int i) {
        this.amount = i;
    }

    public int getSlot() {
        return this.slot;
    }

    public void setSlot(int i) {
        this.slot = i;
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

    public List<String> getEnchants() {
        return this.enchants;
    }

    public void setEnchants(List<String> list) {
        this.enchants = list;
    }

    public List<String> getFlags() {
        return this.flags;
    }

    public void setFlags(List<String> list) {
        this.flags = list;
    }

    public List<String> getLeftAction() {
        return this.leftAction;
    }

    public void setLeftAction(List<String> list) {
        this.leftAction = list;
    }

    public List<String> getRightAction() {
        return this.rightAction;
    }

    public void setRightAction(List<String> list) {
        this.rightAction = list;
    }

    public String getSoundClick() {
        return this.soundClick;
    }

    public void setSoundClick(String str) {
        this.soundClick = str;
    }

    public String getBanner() {
        return this.banner;
    }

    public void setBanner(String str) {
        this.banner = str;
    }

    public NbtData getNbt() {
        return this.nbt;
    }

    public void setNbt(NbtData nbtData) {
        this.nbt = nbtData;
    }

    public List<Integer> getImitate() {
        return this.imitate;
    }

    public void setImitate(List<Integer> list) {
        this.imitate = list;
    }
}
