package me.ulrich.clans.tasks;

import java.util.Iterator;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import me.ulrich.clans.Clans;
import me.ulrich.clans.data.ClanData;
import me.ulrich.clans.data.RegroupInvite;
import me.ulrich.clans.manager.EnumFiles.Lang;
import me.ulrich.clans.manager.utils.MessageUtils;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/tasks/zTcC5XsAfoa1Tc1.class */
public class zTcC5XsAfoa1Tc1 implements Runnable {
    private Clans v8qP8fE86HMhvNuYPFjqY;

    public zTcC5XsAfoa1Tc1(Clans clans) {
        this.v8qP8fE86HMhvNuYPFjqY = clans;
    }

    @Override // java.lang.Runnable
    public void run() {
        long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
        try {
            Iterator<Map.Entry<UUID, RegroupInvite>> it = this.v8qP8fE86HMhvNuYPFjqY.getClanManager().zJnaNCVQSgEShq().entrySet().iterator();
            if (it != null) {
                it.forEachRemaining(entry -> {
                    if (entry == null || jCurrentTimeMillis <= ((RegroupInvite) entry.getValue()).getExpires().longValue()) {
                        return;
                    }
                    Optional<ClanData> optionalIZTqZaRK5UGoe0Z = this.v8qP8fE86HMhvNuYPFjqY.getClanManager().iZTqZaRK5UGoe0Z((UUID) entry.getKey());
                    this.v8qP8fE86HMhvNuYPFjqY.getBossBarManager().v8qP8fE86HMhvNuYPFjqY(((RegroupInvite) entry.getValue()).getSender());
                    if (optionalIZTqZaRK5UGoe0Z.isPresent()) {
                        MessageUtils.clanMessageSend(optionalIZTqZaRK5UGoe0Z.get(), this.v8qP8fE86HMhvNuYPFjqY.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(optionalIZTqZaRK5UGoe0Z.get().getLeader())).getString(Lang.CLAN_REGROUP_INVITE_EXPIRED));
                    }
                    it.remove();
                });
            }
        } catch (Exception e) {
        }
    }
}
