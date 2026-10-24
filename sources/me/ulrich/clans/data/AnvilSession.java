package me.ulrich.clans.data;

import java.util.concurrent.CompletableFuture;
import org.bukkit.entity.Player;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/data/AnvilSession.class */
public interface AnvilSession {
    void close();

    boolean isOpen();

    Player getPlayer();

    CompletableFuture<AnvilResult> getFuture();
}
