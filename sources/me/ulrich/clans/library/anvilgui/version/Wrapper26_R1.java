package me.ulrich.clans.library.anvilgui.version;

import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.game.ClientboundContainerClosePacket;
import net.minecraft.network.protocol.game.ClientboundOpenScreenPacket;
import net.minecraft.network.protocol.game.ClientboundSetExperiencePacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.Container;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.AnvilMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.Slot;
import org.bukkit.craftbukkit.entity.CraftPlayer;
import org.bukkit.craftbukkit.event.CraftEventFactory;
import org.bukkit.craftbukkit.util.CraftChatMessage;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/anvilgui/version/Wrapper26_R1.class */
public final class Wrapper26_R1 implements VersionWrapper {

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/anvilgui/version/Wrapper26_R1$AnvilContainer.class */
    private static class AnvilContainer extends AnvilMenu implements VersionWrapper.AnvilContainerWrapper {
        public AnvilContainer(Player player, int i, Component component) {
            super(i, ((CraftPlayer) player).getHandle().getInventory(), ContainerLevelAccess.create(player.getWorld().getHandle(), new BlockPos(0, 0, 0)));
            this.checkReachable = false;
            setTitle(component);
        }

        public void createResult() {
            Slot slot = getSlot(2);
            if (!slot.hasItem()) {
                slot.set(getSlot(0).getItem().copy());
            }
            this.cost.set(0);
            sendAllDataToRemote();
            broadcastChanges();
        }

        public void removed(net.minecraft.world.entity.player.Player player) {
        }

        protected void clearContainer(net.minecraft.world.entity.player.Player player, Container container) {
        }

        public int getContainerId() {
            return this.containerId;
        }

        @Override // me.ulrich.clans.library.anvilgui.version.VersionWrapper.AnvilContainerWrapper
        public String getRenameText() {
            return this.itemName;
        }

        @Override // me.ulrich.clans.library.anvilgui.version.VersionWrapper.AnvilContainerWrapper
        public void setRenameText(String str) {
            Slot slot = getSlot(0);
            if (slot.hasItem()) {
                slot.getItem().set(DataComponents.CUSTOM_NAME, Component.literal(str));
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

    private ServerPlayer toNMS(Player player) {
        return ((CraftPlayer) player).getHandle();
    }

    @Override // me.ulrich.clans.library.anvilgui.version.VersionWrapper
    public int getNextContainerId(Player player, VersionWrapper.AnvilContainerWrapper anvilContainerWrapper) {
        return ((AnvilContainer) anvilContainerWrapper).getContainerId();
    }

    @Override // me.ulrich.clans.library.anvilgui.version.VersionWrapper
    public void handleInventoryCloseEvent(Player player) {
        try {
            CraftEventFactory.handleInventoryCloseEvent(toNMS(player));
        } catch (NoSuchMethodError e) {
            try {
                Class<?> cls = Class.forName("org.bukkit.event.inventory.InventoryCloseEvent$Reason");
                CraftEventFactory.class.getMethod("handleInventoryCloseEvent", net.minecraft.world.entity.player.Player.class, cls).invoke(null, toNMS(player), cls.getField("UNKNOWN").get(null));
            } catch (ReflectiveOperationException e2) {
                throw new RuntimeException(e2);
            }
        }
        toNMS(player).doCloseContainer();
    }

    @Override // me.ulrich.clans.library.anvilgui.version.VersionWrapper
    public void sendPacketOpenWindow(Player player, int i, Object obj) {
        toNMS(player).connection.send(new ClientboundOpenScreenPacket(i, MenuType.ANVIL, (Component) obj));
    }

    @Override // me.ulrich.clans.library.anvilgui.version.VersionWrapper
    public void sendPacketCloseWindow(Player player, int i) {
        toNMS(player).connection.send(new ClientboundContainerClosePacket(i));
    }

    @Override // me.ulrich.clans.library.anvilgui.version.VersionWrapper
    public void sendPacketExperienceChange(Player player, int i) {
        toNMS(player).connection.send(new ClientboundSetExperiencePacket(0.0f, 0, i));
    }

    @Override // me.ulrich.clans.library.anvilgui.version.VersionWrapper
    public void setActiveContainerDefault(Player player) {
        toNMS(player).containerMenu = toNMS(player).inventoryMenu;
    }

    @Override // me.ulrich.clans.library.anvilgui.version.VersionWrapper
    public void setActiveContainer(Player player, VersionWrapper.AnvilContainerWrapper anvilContainerWrapper) {
        toNMS(player).containerMenu = (AbstractContainerMenu) anvilContainerWrapper;
    }

    @Override // me.ulrich.clans.library.anvilgui.version.VersionWrapper
    public void setActiveContainerId(VersionWrapper.AnvilContainerWrapper anvilContainerWrapper, int i) {
    }

    @Override // me.ulrich.clans.library.anvilgui.version.VersionWrapper
    public void addActiveContainerSlotListener(VersionWrapper.AnvilContainerWrapper anvilContainerWrapper, Player player) {
        toNMS(player).initMenu((AbstractContainerMenu) anvilContainerWrapper);
    }

    @Override // me.ulrich.clans.library.anvilgui.version.VersionWrapper
    public VersionWrapper.AnvilContainerWrapper newContainerAnvil(Player player, Object obj) {
        return new AnvilContainer(player, getRealNextContainerId(player), (Component) obj);
    }

    @Override // me.ulrich.clans.library.anvilgui.version.VersionWrapper
    public Object literalChatComponent(String str) {
        return Component.literal(str);
    }

    @Override // me.ulrich.clans.library.anvilgui.version.VersionWrapper
    public Object jsonChatComponent(String str) {
        return CraftChatMessage.fromJSON(str);
    }
}
