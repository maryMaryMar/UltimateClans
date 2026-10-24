package me.ulrich.clans.interfaces;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import me.ulrich.clans.data.ClanEnum;
import me.ulrich.clans.data.MailData;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/interfaces/MailModuleAPI.class */
public interface MailModuleAPI {
    void SaveMailData(MailData mailData);

    void DeleteMailData(UUID uuid);

    void ReloadMailData(UUID uuid);

    void ClearMailData(UUID uuid);

    void LoadAllMailData();

    boolean hasClanMail(UUID uuid);

    List<MailData> getClanMail(UUID uuid);

    Optional<MailData> getMailById(UUID uuid);

    List<MailData> getClanMailTimed(UUID uuid, UUID uuid2, ClanEnum.MailTime mailTime);

    List<MailData> getFromToMail(UUID uuid, UUID uuid2);

    boolean removeClanMail(UUID uuid);

    boolean addReadmail(UUID uuid, UUID uuid2);

    boolean clearClanMail(UUID uuid);

    boolean addClanMail(UUID uuid, UUID uuid2, UUID uuid3, String str);

    String parseText(UUID uuid, String str);

    ConcurrentHashMap<UUID, List<MailData>> getMailData();
}
