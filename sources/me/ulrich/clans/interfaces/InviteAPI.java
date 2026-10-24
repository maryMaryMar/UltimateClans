package me.ulrich.clans.interfaces;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import me.ulrich.clans.data.InviteData;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/interfaces/InviteAPI.class */
public interface InviteAPI {
    void saveInviteData(InviteData inviteData);

    void deleteInviteData(UUID uuid);

    void reloadInviteData(UUID uuid);

    void loadAllInviteData();

    boolean hasInvite(UUID uuid);

    List<InviteData> getInvites(UUID uuid);

    boolean hasInvite(UUID uuid, UUID uuid2);

    Optional<InviteData> getInvite(UUID uuid, UUID uuid2);

    boolean hasClanInvite(UUID uuid, UUID uuid2);

    boolean hasClanInvite(UUID uuid);

    boolean deleteClanInviteByClanID(UUID uuid);

    Optional<InviteData> getClanInvite(UUID uuid, UUID uuid2);

    boolean removeInvites(UUID uuid);

    boolean removeInvites(UUID uuid, UUID uuid2);

    boolean canReceiveInvitations(UUID uuid);

    boolean createInvite(UUID uuid, UUID uuid2, UUID uuid3);

    boolean inviteAccept(UUID uuid, UUID uuid2);

    boolean inviteDeny(UUID uuid, UUID uuid2);

    ConcurrentHashMap<UUID, List<InviteData>> getInviteData();

    void setInviteData(ConcurrentHashMap<UUID, List<InviteData>> concurrentHashMap);
}
