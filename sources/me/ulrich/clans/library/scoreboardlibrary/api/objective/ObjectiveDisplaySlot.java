package me.ulrich.clans.library.scoreboardlibrary.api.objective;

import com.google.common.base.Preconditions;
import me.ulrich.clans.library.kyori.adventure.text.format.NamedTextColor;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/scoreboardlibrary/api/objective/ObjectiveDisplaySlot.class */
@ApiStatus.NonExtendable
public interface ObjectiveDisplaySlot {

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/scoreboardlibrary/api/objective/ObjectiveDisplaySlot$BelowName.class */
    public static class BelowName implements ObjectiveDisplaySlot {
        private static final BelowName INSTANCE = new BelowName();

        private BelowName() {
        }

        public String toString() {
            return "BelowName";
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/scoreboardlibrary/api/objective/ObjectiveDisplaySlot$PlayerList.class */
    public static class PlayerList implements ObjectiveDisplaySlot {
        private static final PlayerList INSTANCE = new PlayerList();

        private PlayerList() {
        }

        public String toString() {
            return "PlayerList";
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/scoreboardlibrary/api/objective/ObjectiveDisplaySlot$Sidebar.class */
    public static class Sidebar implements ObjectiveDisplaySlot {
        private static final Sidebar INSTANCE = new Sidebar();

        private Sidebar() {
        }

        public String toString() {
            return "Sidebar";
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/scoreboardlibrary/api/objective/ObjectiveDisplaySlot$TeamSidebar.class */
    public static class TeamSidebar implements ObjectiveDisplaySlot {
        private final NamedTextColor teamColor;

        private TeamSidebar(@NotNull NamedTextColor namedTextColor) {
            this.teamColor = namedTextColor;
        }

        @NotNull
        public NamedTextColor teamColor() {
            return this.teamColor;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            return this.teamColor.equals(((TeamSidebar) obj).teamColor);
        }

        public int hashCode() {
            return this.teamColor.hashCode();
        }

        public String toString() {
            return "TeamSidebar{teamColor=" + this.teamColor + "}";
        }
    }

    @NotNull
    static PlayerList playerList() {
        return PlayerList.INSTANCE;
    }

    @NotNull
    static Sidebar sidebar() {
        return Sidebar.INSTANCE;
    }

    @NotNull
    static BelowName belowName() {
        return BelowName.INSTANCE;
    }

    @NotNull
    static TeamSidebar teamSidebar(@NotNull NamedTextColor namedTextColor) {
        Preconditions.checkNotNull(namedTextColor);
        return new TeamSidebar(namedTextColor);
    }
}
