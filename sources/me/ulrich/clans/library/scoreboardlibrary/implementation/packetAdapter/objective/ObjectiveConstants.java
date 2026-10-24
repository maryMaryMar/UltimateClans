package me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.objective;

import me.ulrich.clans.library.scoreboardlibrary.api.objective.ObjectiveDisplaySlot;
import me.ulrich.clans.library.scoreboardlibrary.implementation.commons.LegacyFormatUtil;
import me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.PropertiesPacketType;
import org.bukkit.ChatColor;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/scoreboardlibrary/implementation/packetAdapter/objective/ObjectiveConstants.class */
public final class ObjectiveConstants {
    public static final int MODE_CREATE = 0;
    public static final int MODE_REMOVE = 1;
    public static final int MODE_UPDATE = 2;
    public static final int LEGACY_VALUE_CHAR_LIMIT = 32;

    private ObjectiveConstants() {
    }

    public static int mode(@NotNull PropertiesPacketType propertiesPacketType) {
        switch (propertiesPacketType) {
            case CREATE:
                return 0;
            case UPDATE:
                return 2;
            default:
                throw new IllegalStateException();
        }
    }

    public static int displaySlotIndex(@NotNull ObjectiveDisplaySlot objectiveDisplaySlot) {
        return displaySlotIndex(objectiveDisplaySlot, true);
    }

    public static int displaySlotIndex(@NotNull ObjectiveDisplaySlot objectiveDisplaySlot, boolean z) {
        if (objectiveDisplaySlot instanceof ObjectiveDisplaySlot.PlayerList) {
            return 0;
        }
        if (objectiveDisplaySlot instanceof ObjectiveDisplaySlot.Sidebar) {
            return 1;
        }
        if (!z && (objectiveDisplaySlot instanceof ObjectiveDisplaySlot.TeamSidebar)) {
            return 1;
        }
        if (objectiveDisplaySlot instanceof ObjectiveDisplaySlot.BelowName) {
            return 2;
        }
        return 3 + ChatColor.getByChar(LegacyFormatUtil.getChar(((ObjectiveDisplaySlot.TeamSidebar) objectiveDisplaySlot).teamColor())).ordinal();
    }
}
