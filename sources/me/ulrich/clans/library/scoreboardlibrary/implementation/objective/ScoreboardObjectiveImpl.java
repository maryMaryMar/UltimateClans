package me.ulrich.clans.library.scoreboardlibrary.implementation.objective;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import me.ulrich.clans.library.kyori.adventure.text.Component;
import me.ulrich.clans.library.kyori.adventure.text.ComponentLike;
import me.ulrich.clans.library.scoreboardlibrary.api.objective.ObjectiveRenderType;
import me.ulrich.clans.library.scoreboardlibrary.api.objective.ObjectiveScore;
import me.ulrich.clans.library.scoreboardlibrary.api.objective.ScoreFormat;
import me.ulrich.clans.library.scoreboardlibrary.api.objective.ScoreboardObjective;
import me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.PropertiesPacketType;
import me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.objective.ObjectivePacketAdapter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/scoreboardlibrary/implementation/objective/ScoreboardObjectiveImpl.class */
public final class ScoreboardObjectiveImpl implements ScoreboardObjective {
    private final ObjectivePacketAdapter packetAdapter;
    private final Queue<ObjectiveManagerTask> taskQueue;
    private final String name;
    private final Map<String, ObjectiveScore> scores = new HashMap();
    private Component value = Component.empty();
    private ObjectiveRenderType renderType = ObjectiveRenderType.INTEGER;
    private ScoreFormat defaultScoreFormat;
    private boolean closed;
    private boolean wasDisplayed;

    public ScoreboardObjectiveImpl(@NotNull ObjectivePacketAdapter objectivePacketAdapter, @NotNull Queue<ObjectiveManagerTask> queue, @NotNull String str) {
        this.packetAdapter = objectivePacketAdapter;
        this.taskQueue = queue;
        this.name = str;
    }

    public ObjectivePacketAdapter packetAdapter() {
        return this.packetAdapter;
    }

    @NotNull
    public Map<String, ObjectiveScore> scores() {
        return this.scores;
    }

    @NotNull
    public String name() {
        return this.name;
    }

    public void close() {
        this.closed = true;
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.objective.ScoreboardObjective
    @NotNull
    public Component value() {
        return this.value;
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.objective.ScoreboardObjective
    @NotNull
    public ScoreboardObjective value(@NotNull ComponentLike componentLike) {
        Component componentAsComponent = componentLike.asComponent();
        if (!this.value.equals(componentAsComponent)) {
            this.value = componentAsComponent;
            if (!this.closed) {
                this.taskQueue.add(new ObjectiveManagerTask.UpdateObjective(this));
            }
        }
        return this;
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.objective.ScoreboardObjective
    @NotNull
    public ObjectiveRenderType renderType() {
        return this.renderType;
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.objective.ScoreboardObjective
    @NotNull
    public ScoreboardObjective renderType(@NotNull ObjectiveRenderType objectiveRenderType) {
        if (this.renderType != objectiveRenderType) {
            this.renderType = objectiveRenderType;
            if (!this.closed) {
                this.taskQueue.add(new ObjectiveManagerTask.UpdateObjective(this));
            }
        }
        return this;
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.objective.ScoreboardObjective
    @Nullable
    public ScoreFormat defaultScoreFormat() {
        return this.defaultScoreFormat;
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.objective.ScoreboardObjective
    public void defaultScoreFormat(@Nullable ScoreFormat scoreFormat) {
        if (Objects.equals(this.defaultScoreFormat, scoreFormat)) {
            return;
        }
        this.defaultScoreFormat = scoreFormat;
        this.taskQueue.add(new ObjectiveManagerTask.UpdateObjective(this));
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.objective.ScoreboardObjective
    public void refreshProperties() {
        if (this.closed) {
            return;
        }
        this.taskQueue.add(new ObjectiveManagerTask.UpdateObjective(this));
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.objective.ScoreboardObjective
    @Nullable
    public ObjectiveScore scoreInfo(@NotNull String str) {
        return this.scores.get(str);
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.objective.ScoreboardObjective
    @NotNull
    public ScoreboardObjective score(@NotNull String str, ObjectiveScore objectiveScore) {
        if (!Objects.equals(this.scores.put(str, objectiveScore), objectiveScore)) {
            this.taskQueue.add(new ObjectiveManagerTask.UpdateScore(this, str, objectiveScore));
        }
        return this;
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.objective.ScoreboardObjective
    @NotNull
    public ScoreboardObjective removeScore(@NotNull String str) {
        if (this.scores.remove(str) != null) {
            this.taskQueue.add(new ObjectiveManagerTask.UpdateScore(this, str, null));
        }
        return this;
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.objective.ScoreboardObjective
    public void refreshScore(@NotNull String str) {
        ObjectiveScore objectiveScore = this.scores.get(str);
        if (objectiveScore != null) {
            this.taskQueue.add(new ObjectiveManagerTask.UpdateScore(this, str, objectiveScore));
        }
    }

    public void sendProperties(@NotNull Collection<Player> collection, @NotNull PropertiesPacketType propertiesPacketType) {
        this.packetAdapter.sendProperties(collection, propertiesPacketType, this.value, this.renderType, this.defaultScoreFormat);
    }

    public boolean wasDisplayed() {
        return this.wasDisplayed;
    }

    public void wasDisplayed(boolean z) {
        this.wasDisplayed = z;
    }
}
