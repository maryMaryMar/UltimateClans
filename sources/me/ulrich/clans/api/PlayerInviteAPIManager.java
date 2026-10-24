package me.ulrich.clans.api;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import me.ulrich.clans.Clans;
import me.ulrich.clans.data.InviteData;
import me.ulrich.clans.interfaces.InviteAPI;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/api/PlayerInviteAPIManager.class */
public class PlayerInviteAPIManager implements InviteAPI {
    @Override // me.ulrich.clans.interfaces.InviteAPI
    public void saveInviteData(InviteData inviteData) {
        Clans.getClanCore().getPlayerInviteManager().v8qP8fE86HMhvNuYPFjqY(inviteData);
    }

    @Override // me.ulrich.clans.interfaces.InviteAPI
    public void deleteInviteData(UUID uuid) {
        Clans.getClanCore().getPlayerInviteManager().v8qP8fE86HMhvNuYPFjqY(uuid);
    }

    @Override // me.ulrich.clans.interfaces.InviteAPI
    public void reloadInviteData(UUID uuid) {
        Clans.getClanCore().getPlayerInviteManager().jBUuLP0sWwaPyPOmogdX7l(uuid);
    }

    @Override // me.ulrich.clans.interfaces.InviteAPI
    public void loadAllInviteData() {
        Clans.getClanCore().getPlayerInviteManager().v8qP8fE86HMhvNuYPFjqY();
    }

    @Override // me.ulrich.clans.interfaces.InviteAPI
    public boolean hasInvite(UUID uuid) {
        return Clans.getClanCore().getPlayerInviteManager().ZwrsrwOCXRUscW6Q(uuid);
    }

    @Override // me.ulrich.clans.interfaces.InviteAPI
    public List<InviteData> getInvites(UUID uuid) {
        return Clans.getClanCore().getPlayerInviteManager().iZTqZaRK5UGoe0Z(uuid);
    }

    @Override // me.ulrich.clans.interfaces.InviteAPI
    public boolean hasInvite(UUID uuid, UUID uuid2) {
        return Clans.getClanCore().getPlayerInviteManager().v8qP8fE86HMhvNuYPFjqY(uuid, uuid2);
    }

    @Override // me.ulrich.clans.interfaces.InviteAPI
    public Optional<InviteData> getInvite(UUID uuid, UUID uuid2) {
        return Clans.getClanCore().getPlayerInviteManager().jBUuLP0sWwaPyPOmogdX7l(uuid, uuid2);
    }

    @Override // me.ulrich.clans.interfaces.InviteAPI
    public boolean hasClanInvite(UUID uuid, UUID uuid2) {
        return Clans.getClanCore().getPlayerInviteManager().ZwrsrwOCXRUscW6Q(uuid, uuid2);
    }

    @Override // me.ulrich.clans.interfaces.InviteAPI
    public boolean hasClanInvite(UUID uuid) {
        return Clans.getClanCore().getPlayerInviteManager().xtOheRiObl4QeAl(uuid);
    }

    @Override // me.ulrich.clans.interfaces.InviteAPI
    public boolean deleteClanInviteByClanID(UUID uuid) {
        return Clans.getClanCore().getPlayerInviteManager().zJnaNCVQSgEShq(uuid);
    }

    @Override // me.ulrich.clans.interfaces.InviteAPI
    public Optional<InviteData> getClanInvite(UUID uuid, UUID uuid2) {
        return Clans.getClanCore().getPlayerInviteManager().iZTqZaRK5UGoe0Z(uuid, uuid2);
    }

    @Override // me.ulrich.clans.interfaces.InviteAPI
    public boolean removeInvites(UUID uuid) {
        return Clans.getClanCore().getPlayerInviteManager().CDW4Fj1iwdIXEOqWjiJSR(uuid);
    }

    @Override // me.ulrich.clans.interfaces.InviteAPI
    public boolean removeInvites(UUID uuid, UUID uuid2) {
        return Clans.getClanCore().getPlayerInviteManager().xtOheRiObl4QeAl(uuid, uuid2);
    }

    @Override // me.ulrich.clans.interfaces.InviteAPI
    public boolean canReceiveInvitations(UUID uuid) {
        return Clans.getClanCore().getPlayerInviteManager().b4i2FbOkaKeg91LiAe6l(uuid);
    }

    @Override // me.ulrich.clans.interfaces.InviteAPI
    public boolean createInvite(UUID uuid, UUID uuid2, UUID uuid3) {
        return Clans.getClanCore().getPlayerInviteManager().v8qP8fE86HMhvNuYPFjqY(uuid, uuid2, uuid3);
    }

    @Override // me.ulrich.clans.interfaces.InviteAPI
    public boolean inviteAccept(UUID uuid, UUID uuid2) {
        return Clans.getClanCore().getPlayerInviteManager().zJnaNCVQSgEShq(uuid, uuid2);
    }

    @Override // me.ulrich.clans.interfaces.InviteAPI
    public boolean inviteDeny(UUID uuid, UUID uuid2) {
        return Clans.getClanCore().getPlayerInviteManager().CDW4Fj1iwdIXEOqWjiJSR(uuid, uuid2);
    }

    @Override // me.ulrich.clans.interfaces.InviteAPI
    public ConcurrentHashMap<UUID, List<InviteData>> getInviteData() {
        return Clans.getClanCore().getPlayerInviteManager().ZwrsrwOCXRUscW6Q();
    }

    @Override // me.ulrich.clans.interfaces.InviteAPI
    public void setInviteData(ConcurrentHashMap<UUID, List<InviteData>> concurrentHashMap) {
        Clans.getClanCore().getPlayerInviteManager().v8qP8fE86HMhvNuYPFjqY(concurrentHashMap);
    }
}
