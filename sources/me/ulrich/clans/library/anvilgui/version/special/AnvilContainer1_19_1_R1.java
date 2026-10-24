package me.ulrich.clans.library.anvilgui.version.special;

import me.ulrich.clans.library.anvilgui.version.VersionWrapper;
import net.minecraft.core.BlockPosition;
import net.minecraft.network.chat.IChatBaseComponent;
import net.minecraft.world.IInventory;
import net.minecraft.world.entity.player.EntityHuman;
import net.minecraft.world.inventory.ContainerAccess;
import net.minecraft.world.inventory.ContainerAnvil;
import net.minecraft.world.inventory.Slot;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/anvilgui/version/special/AnvilContainer1_19_1_R1.class */
public class AnvilContainer1_19_1_R1 extends ContainerAnvil implements VersionWrapper.AnvilContainerWrapper {
    public AnvilContainer1_19_1_R1(Player player, int i, IChatBaseComponent iChatBaseComponent) {
        super(i, ((CraftPlayer) player).getHandle().fA(), ContainerAccess.a(player.getWorld().getHandle(), new BlockPosition(0, 0, 0)));
        this.checkReachable = false;
        setTitle(iChatBaseComponent);
    }

    public void l() {
        Slot slotB = b(2);
        if (!slotB.f()) {
            slotB.e(b(0).e().o());
        }
        this.w.a(0);
        b();
        d();
    }

    public void b(EntityHuman entityHuman) {
    }

    protected void a(EntityHuman entityHuman, IInventory iInventory) {
    }

    @Override // me.ulrich.clans.library.anvilgui.version.VersionWrapper.AnvilContainerWrapper
    public String getRenameText() {
        return this.v;
    }

    @Override // me.ulrich.clans.library.anvilgui.version.VersionWrapper.AnvilContainerWrapper
    public void setRenameText(String str) {
        Slot slotB = b(0);
        if (slotB.f()) {
            slotB.e().a(IChatBaseComponent.b(str));
        }
    }

    public int getContainerId() {
        return this.j;
    }

    @Override // me.ulrich.clans.library.anvilgui.version.VersionWrapper.AnvilContainerWrapper
    public Inventory getBukkitInventory() {
        return getBukkitView().getTopInventory();
    }
}
