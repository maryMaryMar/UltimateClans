package me.ulrich.clans.library.anvilgui.version.special;

import me.ulrich.clans.library.anvilgui.version.VersionWrapper;
import net.minecraft.core.BlockPosition;
import net.minecraft.network.chat.ChatComponentText;
import net.minecraft.network.chat.IChatBaseComponent;
import net.minecraft.world.IInventory;
import net.minecraft.world.entity.player.EntityHuman;
import net.minecraft.world.inventory.ContainerAccess;
import net.minecraft.world.inventory.ContainerAnvil;
import net.minecraft.world.inventory.Slot;
import org.bukkit.craftbukkit.v1_17_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/anvilgui/version/special/AnvilContainer1_17_1_R1.class */
public class AnvilContainer1_17_1_R1 extends ContainerAnvil implements VersionWrapper.AnvilContainerWrapper {
    public AnvilContainer1_17_1_R1(Player player, int i, IChatBaseComponent iChatBaseComponent) {
        super(i, ((CraftPlayer) player).getHandle().getInventory(), ContainerAccess.at(player.getWorld().getHandle(), new BlockPosition(0, 0, 0)));
        this.checkReachable = false;
        setTitle(iChatBaseComponent);
    }

    public void l() {
        Slot slot = getSlot(2);
        if (!slot.hasItem()) {
            Slot slot2 = getSlot(0);
            if (slot2.hasItem()) {
                slot.set(slot2.getItem().cloneItemStack());
            }
        }
        this.w.set(0);
        updateInventory();
        d();
    }

    public void b(EntityHuman entityHuman) {
    }

    protected void a(EntityHuman entityHuman, IInventory iInventory) {
    }

    public int getContainerId() {
        return this.j;
    }

    @Override // me.ulrich.clans.library.anvilgui.version.VersionWrapper.AnvilContainerWrapper
    public String getRenameText() {
        return this.v;
    }

    @Override // me.ulrich.clans.library.anvilgui.version.VersionWrapper.AnvilContainerWrapper
    public void setRenameText(String str) {
        Slot slot = getSlot(0);
        if (slot.hasItem()) {
            slot.getItem().a(new ChatComponentText(str));
        }
    }

    @Override // me.ulrich.clans.library.anvilgui.version.VersionWrapper.AnvilContainerWrapper
    public Inventory getBukkitInventory() {
        return getBukkitView().getTopInventory();
    }
}
