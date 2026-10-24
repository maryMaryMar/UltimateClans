package me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.team;

import me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.PropertiesPacketType;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/scoreboardlibrary/implementation/packetAdapter/team/TeamConstants.class */
public final class TeamConstants {
    public static final int DISPLAY_NAME_LEGACY_LIMIT = 32;
    public static final int PREFIX_SUFFIX_LEGACY_LIMIT = 16;
    public static final int MODE_CREATE = 0;
    public static final int MODE_REMOVE = 1;
    public static final int MODE_UPDATE = 2;
    public static final int MODE_ADD_ENTRIES = 3;
    public static final int MODE_REMOVE_ENTRIES = 4;

    private TeamConstants() {
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

    public static int mode(@NotNull EntriesPacketType entriesPacketType) {
        switch (entriesPacketType) {
            case ADD:
                return 3;
            case REMOVE:
                return 4;
            default:
                throw new IllegalStateException();
        }
    }
}
