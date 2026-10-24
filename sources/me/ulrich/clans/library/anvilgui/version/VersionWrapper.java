package me.ulrich.clans.library.anvilgui.version;

import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/anvilgui/version/VersionWrapper.class */
public interface VersionWrapper {

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/anvilgui/version/VersionWrapper$AnvilContainerWrapper.class */
    public interface AnvilContainerWrapper {
        default String getRenameText() {
            return null;
        }

        default void setRenameText(String str) {
        }

        Inventory getBukkitInventory();
    }

    int getNextContainerId(Player player, AnvilContainerWrapper anvilContainerWrapper);

    void handleInventoryCloseEvent(Player player);

    void sendPacketOpenWindow(Player player, int i, Object obj);

    void sendPacketCloseWindow(Player player, int i);

    void sendPacketExperienceChange(Player player, int i);

    void setActiveContainerDefault(Player player);

    void setActiveContainer(Player player, AnvilContainerWrapper anvilContainerWrapper);

    void setActiveContainerId(AnvilContainerWrapper anvilContainerWrapper, int i);

    void addActiveContainerSlotListener(AnvilContainerWrapper anvilContainerWrapper, Player player);

    AnvilContainerWrapper newContainerAnvil(Player player, Object obj);

    default boolean isCustomTitleSupported() {
        return true;
    }

    Object literalChatComponent(String str);

    Object jsonChatComponent(String str);
}
