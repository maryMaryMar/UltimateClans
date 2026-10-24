package me.ulrich.clans.data;

import java.util.List;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/data/CommandData_disable.class */
public class CommandData_disable {
    private List<String> disabledWorlds;
    private List<String> disabledRegions;

    public CommandData_disable(List<String> list, List<String> list2) {
        setDisabledWorlds(list);
        setDisabledRegions(list2);
    }

    public List<String> getDisabledWorlds() {
        return this.disabledWorlds;
    }

    public void setDisabledWorlds(List<String> list) {
        this.disabledWorlds = list;
    }

    public List<String> getDisabledRegions() {
        return this.disabledRegions;
    }

    public void setDisabledRegions(List<String> list) {
        this.disabledRegions = list;
    }
}
