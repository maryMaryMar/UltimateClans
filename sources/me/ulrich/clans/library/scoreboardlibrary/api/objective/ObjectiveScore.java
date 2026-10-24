package me.ulrich.clans.library.scoreboardlibrary.api.objective;

import java.util.Objects;
import me.ulrich.clans.library.kyori.adventure.text.Component;
import me.ulrich.clans.library.kyori.adventure.text.ComponentLike;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/scoreboardlibrary/api/objective/ObjectiveScore.class */
public final class ObjectiveScore {
    private final int value;
    private final Component displayName;
    private final ScoreFormat format;

    public ObjectiveScore(int i, @Nullable ComponentLike componentLike, @Nullable ScoreFormat scoreFormat) {
        this.value = i;
        this.displayName = componentLike == null ? null : componentLike.asComponent();
        this.format = scoreFormat;
    }

    public int value() {
        return this.value;
    }

    @Nullable
    public Component displayName() {
        return this.displayName;
    }

    @Nullable
    public ScoreFormat format() {
        return this.format;
    }

    public String toString() {
        return "ObjectiveScore{value=" + this.value + ", displayName=" + this.displayName + ", format=" + this.format + '}';
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ObjectiveScore objectiveScore = (ObjectiveScore) obj;
        if (this.value == objectiveScore.value && Objects.equals(this.displayName, objectiveScore.displayName)) {
            return Objects.equals(this.format, objectiveScore.format);
        }
        return false;
    }

    public int hashCode() {
        return (31 * ((31 * this.value) + (this.displayName != null ? this.displayName.hashCode() : 0))) + (this.format != null ? this.format.hashCode() : 0);
    }
}
