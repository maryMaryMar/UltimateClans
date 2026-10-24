package me.ulrich.clans.library.anvilgui.version;

import net.minecraft.core.BlockPosition;
import net.minecraft.network.chat.IChatBaseComponent;
import net.minecraft.network.protocol.game.PacketPlayOutCloseWindow;
import net.minecraft.network.protocol.game.PacketPlayOutExperience;
import net.minecraft.network.protocol.game.PacketPlayOutOpenWindow;
import net.minecraft.server.level.EntityPlayer;
import net.minecraft.world.IInventory;
import net.minecraft.world.entity.player.EntityHuman;
import net.minecraft.world.inventory.Container;
import net.minecraft.world.inventory.ContainerAccess;
import net.minecraft.world.inventory.ContainerAnvil;
import net.minecraft.world.inventory.Containers;
import net.minecraft.world.inventory.Slot;
import org.bukkit.craftbukkit.v1_19_R3.entity.CraftPlayer;
import org.bukkit.craftbukkit.v1_19_R3.event.CraftEventFactory;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/anvilgui/version/Wrapper1_19_R3.class */
public final class Wrapper1_19_R3 implements VersionWrapper {

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/anvilgui/version/Wrapper1_19_R3$AnvilContainer.class */
    private static class AnvilContainer extends ContainerAnvil implements VersionWrapper.AnvilContainerWrapper {
        public AnvilContainer(Player player, int i, IChatBaseComponent iChatBaseComponent) {
            super(i, ((CraftPlayer) player).getHandle().fJ(), ContainerAccess.a(player.getWorld().getHandle(), new BlockPosition(0, 0, 0)));
            this.checkReachable = false;
            setTitle(iChatBaseComponent);
        }

        public void m() {
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

        public int getContainerId() {
            return this.j;
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

        @Override // me.ulrich.clans.library.anvilgui.version.VersionWrapper.AnvilContainerWrapper
        public Inventory getBukkitInventory() {
            return getBukkitView().getTopInventory();
        }
    }

    private int getRealNextContainerId(Player player) {
        return toNMS(player).nextContainerCounter();
    }

    private EntityPlayer toNMS(Player player) {
        return ((CraftPlayer) player).getHandle();
    }

    @Override // me.ulrich.clans.library.anvilgui.version.VersionWrapper
    public int getNextContainerId(Player player, VersionWrapper.AnvilContainerWrapper anvilContainerWrapper) {
        return ((AnvilContainer) anvilContainerWrapper).getContainerId();
    }

    @Override // me.ulrich.clans.library.anvilgui.version.VersionWrapper
    public void handleInventoryCloseEvent(Player player) {
        CraftEventFactory.handleInventoryCloseEvent(toNMS(player));
        toNMS(player).r();
    }

    @Override // me.ulrich.clans.library.anvilgui.version.VersionWrapper
    public void sendPacketOpenWindow(Player player, int i, Object obj) {
        toNMS(player).b.a(new PacketPlayOutOpenWindow(i, Containers.h, (IChatBaseComponent) obj));
    }

    @Override // me.ulrich.clans.library.anvilgui.version.VersionWrapper
    public void sendPacketCloseWindow(Player player, int i) {
        toNMS(player).b.a(new PacketPlayOutCloseWindow(i));
    }

    @Override // me.ulrich.clans.library.anvilgui.version.VersionWrapper
    public void sendPacketExperienceChange(Player player, int i) {
        toNMS(player).b.a(new PacketPlayOutExperience(0.0f, 0, i));
    }

    @Override // me.ulrich.clans.library.anvilgui.version.VersionWrapper
    public void setActiveContainerDefault(Player player) {
        toNMS(player).bP = toNMS(player).bO;
    }

    @Override // me.ulrich.clans.library.anvilgui.version.VersionWrapper
    public void setActiveContainer(Player player, VersionWrapper.AnvilContainerWrapper anvilContainerWrapper) {
        toNMS(player).bP = (Container) anvilContainerWrapper;
    }

    @Override // me.ulrich.clans.library.anvilgui.version.VersionWrapper
    public void setActiveContainerId(VersionWrapper.AnvilContainerWrapper anvilContainerWrapper, int i) {
    }

    @Override // me.ulrich.clans.library.anvilgui.version.VersionWrapper
    public void addActiveContainerSlotListener(VersionWrapper.AnvilContainerWrapper anvilContainerWrapper, Player player) {
        toNMS(player).a((Container) anvilContainerWrapper);
    }

    @Override // me.ulrich.clans.library.anvilgui.version.VersionWrapper
    public VersionWrapper.AnvilContainerWrapper newContainerAnvil(Player player, Object obj) {
        return new AnvilContainer(player, getRealNextContainerId(player), (IChatBaseComponent) obj);
    }

    @Override // me.ulrich.clans.library.anvilgui.version.VersionWrapper
    public Object literalChatComponent(String str) {
        return IChatBaseComponent.b(str);
    }

    @Override // me.ulrich.clans.library.anvilgui.version.VersionWrapper
    public Object jsonChatComponent(String str) {
        return IChatBaseComponent.ChatSerializer.a(str);
    }
}
