package me.module.banner.listeners;

import me.module.banner.Banner;
import org.bukkit.event.Listener;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Banner.jar:me/module/banner/listeners/ClanbannerListern.class */
public class ClanbannerListern implements Listener {
    public ClanbannerListern() {
        Banner.getModuleCore().f().add(this);
    }
}
