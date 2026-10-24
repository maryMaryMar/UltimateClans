package me.ulrich.clans.api;

import java.util.HashMap;
import java.util.Optional;
import java.util.UUID;
import me.ulrich.clans.Clans;
import me.ulrich.clans.data.ModerationData;
import me.ulrich.clans.interfaces.ModAPI;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/api/ModerationAPIManager.class */
public class ModerationAPIManager implements ModAPI {
    private final Clans plugin;

    public ModerationAPIManager(Clans clans) {
        this.plugin = clans;
    }

    @Override // me.ulrich.clans.interfaces.ModAPI
    public Optional<ModerationData> getLeaderRole() {
        return this.plugin.getModerationManager().ZwrsrwOCXRUscW6Q();
    }

    @Override // me.ulrich.clans.interfaces.ModAPI
    public Optional<ModerationData> getFirstRoleId() {
        return this.plugin.getModerationManager().ZwrsrwOCXRUscW6Q();
    }

    @Override // me.ulrich.clans.interfaces.ModAPI
    public HashMap<String, HashMap<String, Boolean>> getClanModeration(UUID uuid) {
        return this.plugin.getModerationManager().ZwrsrwOCXRUscW6Q(uuid);
    }

    @Override // me.ulrich.clans.interfaces.ModAPI
    public boolean playerHasPermission(UUID uuid, String str) {
        return this.plugin.getModerationManager().v8qP8fE86HMhvNuYPFjqY(uuid, str);
    }

    @Override // me.ulrich.clans.interfaces.ModAPI
    public Optional<ModerationData> getPlayerRole(UUID uuid) {
        return this.plugin.getModerationManager().b4i2FbOkaKeg91LiAe6l(uuid);
    }

    @Override // me.ulrich.clans.interfaces.ModAPI
    public Optional<ModerationData> getPlayerNextRole(UUID uuid) {
        return this.plugin.getModerationManager().p31abtwfBag2jhMH6K(uuid);
    }

    @Override // me.ulrich.clans.interfaces.ModAPI
    public Optional<ModerationData> getPlayerPreviousRole(UUID uuid) {
        return this.plugin.getModerationManager().Un3NRLL6aWivTcbodkcK(uuid);
    }

    @Override // me.ulrich.clans.interfaces.ModAPI
    public HashMap<String, ModerationData> getDefaultModerationData() {
        return this.plugin.getModerationManager().zJnaNCVQSgEShq();
    }

    @Override // me.ulrich.clans.interfaces.ModAPI
    public HashMap<UUID, HashMap<String, HashMap<String, Boolean>>> getModerationData() {
        return this.plugin.getModerationManager().CDW4Fj1iwdIXEOqWjiJSR();
    }

    @Override // me.ulrich.clans.interfaces.ModAPI
    public HashMap<String, HashMap<String, Boolean>> syncClanModeration(UUID uuid) {
        return this.plugin.getModerationManager().iZTqZaRK5UGoe0Z(uuid);
    }

    @Override // me.ulrich.clans.interfaces.ModAPI
    public void saveModerationData(UUID uuid, HashMap<String, HashMap<String, Boolean>> map) {
        this.plugin.getModerationManager().v8qP8fE86HMhvNuYPFjqY(uuid, map);
    }

    @Override // me.ulrich.clans.interfaces.ModAPI
    public void deleteModerationData(UUID uuid) {
        this.plugin.getModerationManager().v8qP8fE86HMhvNuYPFjqY(uuid);
    }

    @Override // me.ulrich.clans.interfaces.ModAPI
    public void loadModerationData(UUID uuid) {
        this.plugin.getModerationManager().jBUuLP0sWwaPyPOmogdX7l(uuid);
    }

    @Override // me.ulrich.clans.interfaces.ModAPI
    public void loadAllModerationData(boolean z) {
        this.plugin.getModerationManager().v8qP8fE86HMhvNuYPFjqY(z);
    }
}
