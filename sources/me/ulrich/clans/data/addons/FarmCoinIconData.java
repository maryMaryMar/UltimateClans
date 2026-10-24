package me.ulrich.clans.data.addons;

import java.util.List;
import org.bukkit.Material;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/data/addons/FarmCoinIconData.class */
public class FarmCoinIconData {
    private Material material;
    private String name;
    private List<String> lore;
    private List<String> nbts;
    private Integer model;

    public FarmCoinIconData(Material material, String str, List<String> list, List<String> list2, Integer num) {
        setMaterial(material);
        setName(str);
        setLore(list);
        setNbts(list2);
        setModel(num);
    }

    public Material getMaterial() {
        return this.material;
    }

    public void setMaterial(Material material) {
        this.material = material;
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

    public List<String> getNbts() {
        return this.nbts;
    }

    public void setNbts(List<String> list) {
        this.nbts = list;
    }

    public Integer getModel() {
        return this.model;
    }

    public void setModel(Integer num) {
        this.model = num;
    }
}
