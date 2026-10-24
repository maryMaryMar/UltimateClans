package me.ulrich.clans.data;

import java.util.HashMap;
import java.util.List;
import org.bukkit.inventory.ItemStack;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/data/BannerGroupData.class */
public class BannerGroupData {
    private String id;
    private HashMap<String, ItemStack> banners;
    private HashMap<String, ItemStack> heads;
    private List<String> common;

    public BannerGroupData(String str, HashMap<String, ItemStack> map, HashMap<String, ItemStack> map2, List<String> list) {
        setId(str);
        setBanners(map);
        setHeads(map2);
        setCommon(list);
    }

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public HashMap<String, ItemStack> getBanners() {
        return this.banners;
    }

    public void setBanners(HashMap<String, ItemStack> map) {
        this.banners = map;
    }

    public HashMap<String, ItemStack> getHeads() {
        return this.heads;
    }

    public void setHeads(HashMap<String, ItemStack> map) {
        this.heads = map;
    }

    public List<String> getCommon() {
        return this.common;
    }

    public void setCommon(List<String> list) {
        this.common = list;
    }
}
