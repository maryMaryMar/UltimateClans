package me.ulrich.clans.library.scoreboardlibrary.api.team.enums;

import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/scoreboardlibrary/api/team/enums/CollisionRule.class */
public enum CollisionRule {
    ALWAYS("always"),
    NEVER("never"),
    PUSH_OTHER_TEAMS("pushOtherTeams"),
    PUSH_OWN_TEAM("pushOwnTeam");

    private final String key;

    CollisionRule(String str) {
        this.key = str;
    }

    @ApiStatus.Internal
    public String key() {
        return this.key;
    }
}
