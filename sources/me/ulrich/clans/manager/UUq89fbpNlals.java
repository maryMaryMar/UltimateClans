package me.ulrich.clans.manager;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import me.ulrich.clans.Clans;
import me.ulrich.clans.data.ClanData;
import me.ulrich.clans.data.InviteData;
import me.ulrich.clans.data.PlayerData;
import me.ulrich.clans.events.ClanPlayerInviteReceive;
import me.ulrich.clans.manager.EnumFiles.Lang;
import me.ulrich.clans.manager.utils.MessageUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/manager/UUq89fbpNlals.class */
public class UUq89fbpNlals {
    private Clans v8qP8fE86HMhvNuYPFjqY;
    private ConcurrentHashMap<UUID, List<InviteData>> jBUuLP0sWwaPyPOmogdX7l = new ConcurrentHashMap<>();
    private static final byte[] x956lpvPxhHEZEh1HB = {(byte) 176, (byte) 139, (byte) 27, (byte) 71, (byte) 137, (byte) 154, (byte) 11, (byte) 147, (byte) 205, (byte) 242, (byte) 212, (byte) 167, (byte) 57, (byte) 150, (byte) 28, (byte) 74, (byte) 79, (byte) 56, (byte) 7, (byte) 98, (byte) 96, (byte) 50, (byte) 155, (byte) 212, (byte) 183, (byte) 250, (byte) 143, (byte) 87, (byte) 254, (byte) 180, (byte) 127, (byte) 126};
    private static final byte[] lAtiuMyhTbOFr6FJ = {(byte) 176, (byte) 231, (byte) 164, (byte) 222, (byte) 4, (byte) 4, (byte) 165, (byte) 31, (byte) 206, (byte) 179, (byte) 11, (byte) 222, (byte) 138, (byte) 15, (byte) 241, (byte) 77};
    private static String XUnjbdLMeeWkK8o;

    public UUq89fbpNlals(Clans clans) {
        this.v8qP8fE86HMhvNuYPFjqY = clans;
    }

    public void v8qP8fE86HMhvNuYPFjqY(InviteData inviteData) {
        me.ulrich.clans.manager.DTKXb4fQF6nDgxzg.tjCyMSV004ze7Mc.DTKXb4fQF6nDgxzg.RuVgd0Dnv0ddhdcWL.v8qP8fE86HMhvNuYPFjqY(inviteData);
    }

    public void v8qP8fE86HMhvNuYPFjqY(UUID uuid) {
        me.ulrich.clans.manager.DTKXb4fQF6nDgxzg.tjCyMSV004ze7Mc.DTKXb4fQF6nDgxzg.Ijap9SQKkijXSxP5.v8qP8fE86HMhvNuYPFjqY(uuid);
    }

    public void jBUuLP0sWwaPyPOmogdX7l(UUID uuid) {
        me.ulrich.clans.manager.DTKXb4fQF6nDgxzg.tjCyMSV004ze7Mc.DTKXb4fQF6nDgxzg.ZRp1tak21UvNaOVCtFx.v8qP8fE86HMhvNuYPFjqY(uuid);
    }

    public void v8qP8fE86HMhvNuYPFjqY() {
        me.ulrich.clans.manager.DTKXb4fQF6nDgxzg.tjCyMSV004ze7Mc.DTKXb4fQF6nDgxzg.UsEbiuprSHpNw3qjITfH.v8qP8fE86HMhvNuYPFjqY();
    }

    public boolean ZwrsrwOCXRUscW6Q(UUID uuid) {
        return ZwrsrwOCXRUscW6Q().containsKey(uuid);
    }

    public List<InviteData> iZTqZaRK5UGoe0Z(UUID uuid) {
        return ZwrsrwOCXRUscW6Q(uuid) ? ZwrsrwOCXRUscW6Q().get(uuid) : new ArrayList();
    }

    public boolean v8qP8fE86HMhvNuYPFjqY(UUID uuid, UUID uuid2) {
        if (!ZwrsrwOCXRUscW6Q(uuid)) {
            return false;
        }
        Iterator<InviteData> it = ZwrsrwOCXRUscW6Q().get(uuid).iterator();
        while (it.hasNext()) {
            if (it.next().getId().equals(uuid2)) {
                return true;
            }
        }
        return false;
    }

    public Optional<InviteData> jBUuLP0sWwaPyPOmogdX7l(UUID uuid, UUID uuid2) {
        return ZwrsrwOCXRUscW6Q(uuid) ? ZwrsrwOCXRUscW6Q().get(uuid).stream().filter(inviteData -> {
            return inviteData.getId().equals(uuid2);
        }).findAny() : Optional.empty();
    }

    public boolean ZwrsrwOCXRUscW6Q(UUID uuid, UUID uuid2) {
        if (!ZwrsrwOCXRUscW6Q(uuid)) {
            return false;
        }
        Iterator<InviteData> it = ZwrsrwOCXRUscW6Q().get(uuid).iterator();
        while (it.hasNext()) {
            if (it.next().getClanID().equals(uuid2)) {
                return true;
            }
        }
        return false;
    }

    public boolean xtOheRiObl4QeAl(UUID uuid) {
        Iterator<Map.Entry<UUID, List<InviteData>>> it = ZwrsrwOCXRUscW6Q().entrySet().iterator();
        while (it.hasNext()) {
            Iterator<InviteData> it2 = it.next().getValue().iterator();
            while (it2.hasNext()) {
                if (it2.next().getClanID().equals(uuid)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean zJnaNCVQSgEShq(UUID uuid) {
        Iterator<Map.Entry<UUID, List<InviteData>>> it = ZwrsrwOCXRUscW6Q().entrySet().iterator();
        while (it.hasNext()) {
            Iterator<InviteData> it2 = it.next().getValue().iterator();
            while (it2.hasNext()) {
                InviteData next = it2.next();
                if (next.getClanID().equals(uuid)) {
                    it2.remove();
                    v8qP8fE86HMhvNuYPFjqY(next.getId());
                    return true;
                }
            }
        }
        return false;
    }

    public Optional<InviteData> iZTqZaRK5UGoe0Z(UUID uuid, UUID uuid2) {
        return ZwrsrwOCXRUscW6Q(uuid) ? ZwrsrwOCXRUscW6Q().get(uuid).stream().filter(inviteData -> {
            return inviteData.getClanID().equals(uuid2);
        }).findAny() : Optional.empty();
    }

    public boolean CDW4Fj1iwdIXEOqWjiJSR(UUID uuid) {
        if (!ZwrsrwOCXRUscW6Q(uuid)) {
            return false;
        }
        int i = 0;
        Iterator<InviteData> it = ZwrsrwOCXRUscW6Q().get(uuid).iterator();
        while (it.hasNext()) {
            InviteData next = it.next();
            it.remove();
            v8qP8fE86HMhvNuYPFjqY(next.getId());
            i++;
        }
        return i > 0;
    }

    public boolean xtOheRiObl4QeAl(UUID uuid, UUID uuid2) {
        if (!ZwrsrwOCXRUscW6Q(uuid)) {
            return false;
        }
        Optional<InviteData> optionalFindAny = ZwrsrwOCXRUscW6Q().get(uuid).stream().filter(inviteData -> {
            return inviteData.getId().equals(uuid2);
        }).findAny();
        if (!optionalFindAny.isPresent()) {
            return false;
        }
        ZwrsrwOCXRUscW6Q().get(uuid).removeIf(inviteData2 -> {
            return inviteData2.getId().equals(uuid2);
        });
        v8qP8fE86HMhvNuYPFjqY(optionalFindAny.get().getId());
        return true;
    }

    public boolean b4i2FbOkaKeg91LiAe6l(UUID uuid) {
        Optional<PlayerData> optionalP31abtwfBag2jhMH6K = this.v8qP8fE86HMhvNuYPFjqY.getPlayerManager().p31abtwfBag2jhMH6K(uuid);
        if (optionalP31abtwfBag2jhMH6K.isPresent() && optionalP31abtwfBag2jhMH6K.get().getSettings().isInvitations()) {
            return !ZwrsrwOCXRUscW6Q(uuid) || iZTqZaRK5UGoe0Z(uuid).size() < this.v8qP8fE86HMhvNuYPFjqY.getFiles().p31abtwfBag2jhMH6K().getInt(Lu5CHTIGYespMv());
        }
        return false;
    }

    public boolean v8qP8fE86HMhvNuYPFjqY(UUID uuid, UUID uuid2, UUID uuid3) {
        if (iZTqZaRK5UGoe0Z(uuid, uuid2).isPresent() || !this.v8qP8fE86HMhvNuYPFjqY.getClanManager().iZTqZaRK5UGoe0Z(uuid2).isPresent()) {
            return false;
        }
        InviteData inviteData = new InviteData(UUID.randomUUID(), uuid, uuid2, uuid3, System.currentTimeMillis() / 1000);
        if (ZwrsrwOCXRUscW6Q().containsKey(uuid)) {
            ZwrsrwOCXRUscW6Q().get(uuid).add(inviteData);
        } else {
            ArrayList arrayList = new ArrayList();
            arrayList.add(inviteData);
            ZwrsrwOCXRUscW6Q().put(uuid, arrayList);
        }
        v8qP8fE86HMhvNuYPFjqY(inviteData);
        Bukkit.getPluginManager().callEvent(new ClanPlayerInviteReceive(inviteData));
        return true;
    }

    public boolean zJnaNCVQSgEShq(UUID uuid, UUID uuid2) {
        Optional<InviteData> optionalJBUuLP0sWwaPyPOmogdX7l = jBUuLP0sWwaPyPOmogdX7l(uuid, uuid2);
        if (!optionalJBUuLP0sWwaPyPOmogdX7l.isPresent() || this.v8qP8fE86HMhvNuYPFjqY.getPlayerManager().zJnaNCVQSgEShq(uuid)) {
            return false;
        }
        Optional<ClanData> optionalIZTqZaRK5UGoe0Z = jBUuLP0sWwaPyPOmogdX7l().getClanManager().iZTqZaRK5UGoe0Z(optionalJBUuLP0sWwaPyPOmogdX7l.get().getClanID());
        if (!optionalIZTqZaRK5UGoe0Z.isPresent() || !this.v8qP8fE86HMhvNuYPFjqY.getPlayerManager().b4i2FbOkaKeg91LiAe6l(uuid, optionalIZTqZaRK5UGoe0Z.get().getId())) {
            return false;
        }
        CDW4Fj1iwdIXEOqWjiJSR(uuid);
        return true;
    }

    public boolean CDW4Fj1iwdIXEOqWjiJSR(UUID uuid, UUID uuid2) {
        Optional<InviteData> optionalJBUuLP0sWwaPyPOmogdX7l = jBUuLP0sWwaPyPOmogdX7l(uuid, uuid2);
        if (!optionalJBUuLP0sWwaPyPOmogdX7l.isPresent()) {
            return false;
        }
        Optional<ClanData> optionalIZTqZaRK5UGoe0Z = this.v8qP8fE86HMhvNuYPFjqY.getClanManager().iZTqZaRK5UGoe0Z(optionalJBUuLP0sWwaPyPOmogdX7l.get().getClanID());
        if (optionalIZTqZaRK5UGoe0Z.isPresent() && this.v8qP8fE86HMhvNuYPFjqY.getPlayerManager().v8qP8fE86HMhvNuYPFjqY(optionalJBUuLP0sWwaPyPOmogdX7l.get().getInviter(), optionalIZTqZaRK5UGoe0Z.get().getLeader())) {
            try {
                if (Bukkit.getPlayer(optionalJBUuLP0sWwaPyPOmogdX7l.get().getInviter()).isOnline()) {
                    MessageUtils.sendText((CommandSender) Bukkit.getPlayer(optionalJBUuLP0sWwaPyPOmogdX7l.get().getInviter()), jBUuLP0sWwaPyPOmogdX7l().getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(uuid)).getString(Lang.PLAYER_INVITATION_DANIED));
                }
            } catch (Exception e) {
            }
        }
        xtOheRiObl4QeAl(uuid, uuid2);
        return true;
    }

    public Clans jBUuLP0sWwaPyPOmogdX7l() {
        return this.v8qP8fE86HMhvNuYPFjqY;
    }

    public ConcurrentHashMap<UUID, List<InviteData>> ZwrsrwOCXRUscW6Q() {
        return this.jBUuLP0sWwaPyPOmogdX7l;
    }

    public void v8qP8fE86HMhvNuYPFjqY(ConcurrentHashMap<UUID, List<InviteData>> concurrentHashMap) {
        this.jBUuLP0sWwaPyPOmogdX7l = concurrentHashMap;
    }

    private static String cWE4PoR05RaPNWqWWaM(byte[] bArr) {
        return "";
    }

    private static String Lu5CHTIGYespMv() {
        return "Config.player.invites.max_store";
    }
}
