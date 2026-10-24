package me.module.anvil.manager;

import java.util.concurrent.CompletableFuture;
import me.ulrich.clans.data.AnvilResult;
import me.ulrich.clans.data.AnvilSession;
import me.ulrich.clans.library.anvilgui.AnvilGUI;
import org.bukkit.entity.Player;

/* JADX WARN: Classes with same name are omitted, all sources:
  UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Anvil_1_18.jar:me/module/anvil/manager/AnvilSessionImpl.class
  UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Anvil_1_19.jar:me/module/anvil/manager/AnvilSessionImpl.class
  UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Anvil_1_20.jar:me/module/anvil/manager/AnvilSessionImpl.class
  UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Anvil_1_21.jar:me/module/anvil/manager/AnvilSessionImpl.class
  UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Anvil_26.jar:me/module/anvil/manager/AnvilSessionImpl.class
 */
/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Anvil_1_18.jar:me/module/anvil/manager/AnvilSessionImpl.class */
public class AnvilSessionImpl implements AnvilSession {
    private final Player player;
    private final CompletableFuture<AnvilResult> future;
    private AnvilGUI gui;
    private boolean open = true;

    public AnvilSessionImpl(Player player, CompletableFuture<AnvilResult> future) {
        this.player = player;
        this.future = future;
    }

    public void setGui(AnvilGUI gui) {
        this.gui = gui;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    @Override // me.ulrich.clans.data.AnvilSession
    public void close() {
        if (this.open && this.player.getOpenInventory() != null) {
            this.player.closeInventory();
            this.open = false;
        }
    }

    @Override // me.ulrich.clans.data.AnvilSession
    public boolean isOpen() {
        return this.open;
    }

    @Override // me.ulrich.clans.data.AnvilSession
    public Player getPlayer() {
        return this.player;
    }

    @Override // me.ulrich.clans.data.AnvilSession
    public CompletableFuture<AnvilResult> getFuture() {
        return this.future;
    }
}
