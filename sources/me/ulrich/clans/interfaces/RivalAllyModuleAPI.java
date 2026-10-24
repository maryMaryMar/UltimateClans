package me.ulrich.clans.interfaces;

import java.util.UUID;
import me.ulrich.clans.data.ClanData;
import me.ulrich.clans.data.ClanEnum;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/interfaces/RivalAllyModuleAPI.class */
public interface RivalAllyModuleAPI {
    String parseText(UUID uuid, String str);

    int allyRivalCount(ClanData clanData, ClanEnum.RivalAllyCount rivalAllyCount);

    ClanEnum.AllyInviteReturn allySend(UUID uuid, UUID uuid2, boolean z);

    boolean allyAdd(UUID uuid, UUID uuid2);

    boolean allyRemove(UUID uuid, UUID uuid2);

    ClanEnum.RivalRemoveReturn rivalRemoveSend(UUID uuid, UUID uuid2, boolean z);

    boolean rivalAdd(UUID uuid, UUID uuid2);

    boolean rivalRemove(UUID uuid, UUID uuid2);

    boolean isClanAlly(UUID uuid, UUID uuid2);

    boolean isClanRival(UUID uuid, UUID uuid2);

    boolean isRival(UUID uuid, UUID uuid2);

    boolean isAlly(UUID uuid, UUID uuid2);
}
