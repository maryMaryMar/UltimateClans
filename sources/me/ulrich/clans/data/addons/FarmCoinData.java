package me.ulrich.clans.data.addons;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/data/addons/FarmCoinData.class */
public class FarmCoinData {
    private String id;
    private String name;
    private String permission;
    private Double chance;
    private Integer minValue;
    private Integer maxValue;
    private List<String> mobs;
    private List<String> miner;
    private List<String> players;
    private FarmCoinIconData icon;
    private List<String> fishing;
    private AddonEnum.CoinType type;
    private AddonEnum.Coin coin;
    private List<String> enabledRegions;
    private List<String> enabledWorlds;
    private boolean league;
    private HashMap<Integer, Double> chance_level;
    private HashMap<String, Double> chance_role;
    private Optional<String> dropSound;

    public FarmCoinData(String str, String str2, String str3, List<String> list, List<String> list2, AddonEnum.CoinType coinType, AddonEnum.Coin coin, Double d, HashMap<Integer, Double> map, HashMap<String, Double> map2, Integer num, Integer num2, Optional<String> optional, List<String> list3, List<String> list4, List<String> list5, List<String> list6, boolean z, FarmCoinIconData farmCoinIconData) {
        setId(str);
        setName(str2);
        setPermission(str3);
        setEnabledRegions(list);
        setEnabledWorlds(list2);
        setType(coinType);
        setCoin(coin);
        setChance(d);
        setMinValue(num);
        setMaxValue(num2);
        setDropSound(optional);
        setMobs(list3);
        setMiner(list4);
        setPlayers(list5);
        setFishing(list6);
        setLeague(z);
        setIcon(farmCoinIconData);
        setChance_level(map);
        setChance_role(map2);
    }

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String getPermission() {
        return this.permission;
    }

    public void setPermission(String str) {
        this.permission = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public Double getChance() {
        return this.chance;
    }

    public void setChance(Double d) {
        this.chance = d;
    }

    public Integer getMinValue() {
        return this.minValue;
    }

    public void setMinValue(Integer num) {
        this.minValue = num;
    }

    public Integer getMaxValue() {
        return this.maxValue;
    }

    public void setMaxValue(Integer num) {
        this.maxValue = num;
    }

    public List<String> getMobs() {
        return this.mobs;
    }

    public void setMobs(List<String> list) {
        this.mobs = list;
    }

    public List<String> getMiner() {
        return this.miner;
    }

    public void setMiner(List<String> list) {
        this.miner = list;
    }

    public List<String> getPlayers() {
        return this.players;
    }

    public void setPlayers(List<String> list) {
        this.players = list;
    }

    public FarmCoinIconData getIcon() {
        return this.icon;
    }

    public void setIcon(FarmCoinIconData farmCoinIconData) {
        this.icon = farmCoinIconData;
    }

    public List<String> getFishing() {
        return this.fishing;
    }

    public void setFishing(List<String> list) {
        this.fishing = list;
    }

    public AddonEnum.CoinType getType() {
        return this.type;
    }

    public void setType(AddonEnum.CoinType coinType) {
        this.type = coinType;
    }

    public AddonEnum.Coin getCoin() {
        return this.coin;
    }

    public void setCoin(AddonEnum.Coin coin) {
        this.coin = coin;
    }

    public List<String> getEnabledRegions() {
        return this.enabledRegions;
    }

    public void setEnabledRegions(List<String> list) {
        this.enabledRegions = list;
    }

    public List<String> getEnabledWorlds() {
        return this.enabledWorlds;
    }

    public void setEnabledWorlds(List<String> list) {
        this.enabledWorlds = list;
    }

    public boolean isLeague() {
        return this.league;
    }

    public void setLeague(boolean z) {
        this.league = z;
    }

    public HashMap<Integer, Double> getChance_level() {
        return this.chance_level;
    }

    public void setChance_level(HashMap<Integer, Double> map) {
        this.chance_level = map;
    }

    public HashMap<String, Double> getChance_role() {
        return this.chance_role;
    }

    public void setChance_role(HashMap<String, Double> map) {
        this.chance_role = map;
    }

    public Optional<String> getDropSound() {
        return this.dropSound;
    }

    public void setDropSound(Optional<String> optional) {
        this.dropSound = optional;
    }
}
