package me.ulrich.clans.library.scoreboardlibrary.implementation.sidebar.line;

import me.ulrich.clans.library.kyori.adventure.text.Component;
import me.ulrich.clans.library.scoreboardlibrary.api.objective.ScoreFormat;
import me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.team.TeamsPacketAdapter;
import me.ulrich.clans.library.scoreboardlibrary.implementation.sidebar.AbstractSidebar;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/scoreboardlibrary/implementation/sidebar/line/GlobalLineInfo.class */
public final class GlobalLineInfo {
    private final String player;
    private final int line;
    private final TeamsPacketAdapter packetAdapter;
    private Component value;
    private ScoreFormat scoreFormat;
    private int objectiveScore;
    private boolean updateScore;

    public GlobalLineInfo(@NotNull AbstractSidebar abstractSidebar, @NotNull String str, int i) {
        this.player = str;
        this.line = i;
        this.packetAdapter = abstractSidebar.scoreboardLibrary().packetAdapter().createTeamPacketAdapter("sidebar_line_" + i);
    }

    @NotNull
    public String player() {
        return this.player;
    }

    public int line() {
        return this.line;
    }

    @NotNull
    public TeamsPacketAdapter packetAdapter() {
        return this.packetAdapter;
    }

    @Nullable
    public Component value() {
        return this.value;
    }

    public void value(@Nullable Component component) {
        this.value = component;
    }

    @Nullable
    public ScoreFormat scoreFormat() {
        return this.scoreFormat;
    }

    public void scoreFormat(@Nullable ScoreFormat scoreFormat) {
        this.scoreFormat = scoreFormat;
    }

    public int objectiveScore() {
        return this.objectiveScore;
    }

    public void objectiveScore(int i) {
        this.objectiveScore = i;
    }

    public boolean updateScore() {
        return this.updateScore;
    }

    public void updateScore(boolean z) {
        this.updateScore = z;
    }
}
