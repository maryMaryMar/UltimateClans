package me.ulrich.clans.data;

import java.util.HashMap;
import java.util.UUID;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/data/ClanModeration.class */
public class ClanModeration {
    private UUID clanUUID;
    private HashMap<String, ClanModeration_permissions> permissions;

    public ClanModeration(UUID uuid, HashMap<String, ClanModeration_permissions> map) {
        setClanUUID(uuid);
        setPermissions(map);
    }

    public UUID getClanUUID() {
        return this.clanUUID;
    }

    public void setClanUUID(UUID uuid) {
        this.clanUUID = uuid;
    }

    public HashMap<String, ClanModeration_permissions> getPermissions() {
        return this.permissions;
    }

    public void setPermissions(HashMap<String, ClanModeration_permissions> map) {
        this.permissions = map;
    }
}
