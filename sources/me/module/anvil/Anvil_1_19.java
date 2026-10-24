package me.module.anvil;

import java.util.logging.Logger;
import me.module.anvil.manager.Implementation;
import me.ulrich.clans.Clans;
import me.ulrich.clans.data.Module;
import me.ulrich.clans.manager.utils.VersionUtil;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Anvil_1_19.jar:me/module/anvil/Anvil_1_19.class */
public class Anvil_1_19 extends Module {
    private static Anvil_1_19 moduleCore;
    private static Clans clanCore;
    private Logger logger = null;
    private Implementation implementation;

    @Override // me.ulrich.clans.data.Module
    public void onEnable() {
        moduleCore = this;
        clanCore = (Clans) getInstance();
        this.logger = Logger.getLogger(getName());
        if (!VersionUtil.is(VersionUtil.VersionEnum.V119)) {
            clanCore.getModuleEnabledList().put(this, false);
            setEnabled(false);
            onDisable();
        } else {
            this.implementation = new Implementation();
            clanCore.getIntegrationAPI().registerAnvilAPI(this.implementation);
            clanCore.getLogger().info(" - Module : Anvil (1_19)");
            clanCore.getModuleEnabledList().put(this, true);
        }
    }

    @Override // me.ulrich.clans.data.Module
    public void onDisable() {
        if (this.implementation != null) {
            clanCore.getIntegrationAPI().unregisterAnvilAPI(this.implementation);
        }
    }

    public static Anvil_1_19 getModuleCore() {
        return moduleCore;
    }

    public static Clans getClanCore() {
        return clanCore;
    }

    public Logger getLogger() {
        return this.logger;
    }
}
