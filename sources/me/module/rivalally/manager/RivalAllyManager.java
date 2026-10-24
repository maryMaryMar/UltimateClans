package me.module.rivalally.manager;

import java.util.UUID;
import me.ulrich.clans.data.ClanData;
import me.ulrich.clans.data.ClanEnum;
import me.ulrich.clans.interfaces.RivalAllyModuleAPI;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Rivalally.jar:me/module/rivalally/manager/RivalAllyManager.class */
public class RivalAllyManager implements RivalAllyModuleAPI {
    public RivalAllyManager() {
        e.c();
    }

    @Override // me.ulrich.clans.interfaces.RivalAllyModuleAPI
    public String parseText(UUID uuid, String str) {
        return e.a(uuid, str);
    }

    @Override // me.ulrich.clans.interfaces.RivalAllyModuleAPI
    public int allyRivalCount(ClanData clanData, ClanEnum.RivalAllyCount rivalAllyCount) {
        return e.a(clanData, rivalAllyCount);
    }

    @Override // me.ulrich.clans.interfaces.RivalAllyModuleAPI
    public ClanEnum.AllyInviteReturn allySend(UUID uuid, UUID uuid2, boolean z) {
        return e.a(uuid, uuid2, z);
    }

    @Override // me.ulrich.clans.interfaces.RivalAllyModuleAPI
    public boolean allyAdd(UUID uuid, UUID uuid2) {
        return e.a(uuid, uuid2);
    }

    @Override // me.ulrich.clans.interfaces.RivalAllyModuleAPI
    public boolean allyRemove(UUID uuid, UUID uuid2) {
        return e.b(uuid, uuid2);
    }

    @Override // me.ulrich.clans.interfaces.RivalAllyModuleAPI
    public ClanEnum.RivalRemoveReturn rivalRemoveSend(UUID uuid, UUID uuid2, boolean z) {
        return e.b(uuid, uuid2, z);
    }

    @Override // me.ulrich.clans.interfaces.RivalAllyModuleAPI
    public boolean rivalAdd(UUID uuid, UUID uuid2) {
        return e.c(uuid, uuid2);
    }

    @Override // me.ulrich.clans.interfaces.RivalAllyModuleAPI
    public boolean rivalRemove(UUID uuid, UUID uuid2) {
        return e.d(uuid, uuid2);
    }

    @Override // me.ulrich.clans.interfaces.RivalAllyModuleAPI
    public boolean isClanAlly(UUID uuid, UUID uuid2) {
        return e.e(uuid, uuid2);
    }

    @Override // me.ulrich.clans.interfaces.RivalAllyModuleAPI
    public boolean isClanRival(UUID uuid, UUID uuid2) {
        return e.f(uuid, uuid2);
    }

    @Override // me.ulrich.clans.interfaces.RivalAllyModuleAPI
    public boolean isRival(UUID uuid, UUID uuid2) {
        return e.g(uuid, uuid2);
    }

    @Override // me.ulrich.clans.interfaces.RivalAllyModuleAPI
    public boolean isAlly(UUID uuid, UUID uuid2) {
        return e.h(uuid, uuid2);
    }
}
