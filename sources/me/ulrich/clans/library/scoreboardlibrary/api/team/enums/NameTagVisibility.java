package me.ulrich.clans.library.scoreboardlibrary.api.team.enums;

import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/scoreboardlibrary/api/team/enums/NameTagVisibility.class */
public enum NameTagVisibility {
    ALWAYS("always"),
    NEVER("never"),
    HIDE_FOR_OTHER_TEAMS("hideForOtherTeams"),
    HIDE_FOR_OWN_TEAM("hideForOwnTeam");

    private final String key;

    NameTagVisibility(String str) {
        this.key = str;
    }

    @ApiStatus.Internal
    public String key() {
        return this.key;
    }
}
