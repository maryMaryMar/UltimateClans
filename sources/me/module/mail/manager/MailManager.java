package me.module.mail.manager;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import me.ulrich.clans.data.ClanEnum;
import me.ulrich.clans.data.MailData;
import me.ulrich.clans.interfaces.MailModuleAPI;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Mail.jar:me/module/mail/manager/MailManager.class */
public class MailManager implements MailModuleAPI {
    public MailManager() {
        f.a();
    }

    @Override // me.ulrich.clans.interfaces.MailModuleAPI
    public ConcurrentHashMap<UUID, List<MailData>> getMailData() {
        return f.b();
    }

    @Override // me.ulrich.clans.interfaces.MailModuleAPI
    public void SaveMailData(MailData mailData) {
        f.a(mailData);
    }

    @Override // me.ulrich.clans.interfaces.MailModuleAPI
    public void DeleteMailData(UUID uuid) {
        f.a(uuid);
    }

    @Override // me.ulrich.clans.interfaces.MailModuleAPI
    public void ReloadMailData(UUID uuid) {
        f.b(uuid);
    }

    @Override // me.ulrich.clans.interfaces.MailModuleAPI
    public void ClearMailData(UUID uuid) {
        f.c(uuid);
    }

    @Override // me.ulrich.clans.interfaces.MailModuleAPI
    public void LoadAllMailData() {
        f.c();
    }

    @Override // me.ulrich.clans.interfaces.MailModuleAPI
    public boolean hasClanMail(UUID uuid) {
        return f.d(uuid);
    }

    @Override // me.ulrich.clans.interfaces.MailModuleAPI
    public List<MailData> getClanMail(UUID uuid) {
        return f.e(uuid);
    }

    @Override // me.ulrich.clans.interfaces.MailModuleAPI
    public Optional<MailData> getMailById(UUID uuid) {
        return f.f(uuid);
    }

    @Override // me.ulrich.clans.interfaces.MailModuleAPI
    public List<MailData> getClanMailTimed(UUID uuid, UUID uuid2, ClanEnum.MailTime mailTime) {
        return f.a(uuid, uuid2, mailTime);
    }

    @Override // me.ulrich.clans.interfaces.MailModuleAPI
    public List<MailData> getFromToMail(UUID uuid, UUID uuid2) {
        return f.a(uuid, uuid2);
    }

    @Override // me.ulrich.clans.interfaces.MailModuleAPI
    public boolean removeClanMail(UUID uuid) {
        return f.g(uuid);
    }

    @Override // me.ulrich.clans.interfaces.MailModuleAPI
    public boolean addReadmail(UUID uuid, UUID uuid2) {
        return f.b(uuid, uuid2);
    }

    @Override // me.ulrich.clans.interfaces.MailModuleAPI
    public boolean clearClanMail(UUID uuid) {
        return f.h(uuid);
    }

    @Override // me.ulrich.clans.interfaces.MailModuleAPI
    public boolean addClanMail(UUID uuid, UUID uuid2, UUID uuid3, String str) {
        return f.a(uuid, uuid2, uuid3, str);
    }

    @Override // me.ulrich.clans.interfaces.MailModuleAPI
    public String parseText(UUID uuid, String str) {
        return f.a(uuid, str);
    }
}
