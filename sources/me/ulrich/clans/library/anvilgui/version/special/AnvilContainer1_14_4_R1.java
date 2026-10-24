package me.ulrich.clans.library.anvilgui.version.special;

import me.ulrich.clans.library.anvilgui.version.VersionWrapper;
import net.minecraft.server.v1_14_R1.BlockPosition;
import net.minecraft.server.v1_14_R1.ChatComponentText;
import net.minecraft.server.v1_14_R1.ContainerAccess;
import net.minecraft.server.v1_14_R1.ContainerAnvil;
import net.minecraft.server.v1_14_R1.EntityHuman;
import net.minecraft.server.v1_14_R1.IChatBaseComponent;
import net.minecraft.server.v1_14_R1.IInventory;
import net.minecraft.server.v1_14_R1.Slot;
import net.minecraft.server.v1_14_R1.World;
import org.bukkit.craftbukkit.v1_14_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/anvilgui/version/special/AnvilContainer1_14_4_R1.class */
public class AnvilContainer1_14_4_R1 extends ContainerAnvil implements VersionWrapper.AnvilContainerWrapper {
    public AnvilContainer1_14_4_R1(Player player, int i, IChatBaseComponent iChatBaseComponent) {
        super(i, ((CraftPlayer) player).getHandle().inventory, ContainerAccess.at(player.getWorld().getHandle(), new BlockPosition(0, 0, 0)));
        this.checkReachable = false;
        setTitle(iChatBaseComponent);
    }

    public void e() {
        Slot slot = getSlot(2);
        if (!slot.hasItem()) {
            Slot slot2 = getSlot(0);
            if (slot2.hasItem()) {
                slot.set(slot2.getItem().cloneItemStack());
            }
        }
        this.levelCost.set(0);
        c();
    }

    public void b(EntityHuman entityHuman) {
    }

    protected void a(EntityHuman entityHuman, World world, IInventory iInventory) {
    }

    public int getContainerId() {
        return this.windowId;
    }

    @Override // me.ulrich.clans.library.anvilgui.version.VersionWrapper.AnvilContainerWrapper
    public String getRenameText() {
        return this.renameText;
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
