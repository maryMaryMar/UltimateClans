package me.ulrich.clans.library.kyori.adventure.text;

import java.util.List;
import java.util.Objects;
import me.ulrich.clans.library.kyori.adventure.text.format.Style;
import me.ulrich.clans.library.kyori.examination.string.StringExaminer;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Debug;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/AbstractComponent.class */
@ApiStatus.ScheduledForRemoval(inVersion = "5.0.0")
@Deprecated
@Debug.Renderer(text = "this.debuggerString()", childrenArray = "this.children().toArray()", hasChildren = "!this.children().isEmpty()")
public abstract class AbstractComponent implements Component {
    protected final List<Component> children;
    protected final Style style;

    protected AbstractComponent(@NotNull List<? extends ComponentLike> list, @NotNull Style style) {
        this.children = ComponentLike.asComponents(list, IS_NOT_EMPTY);
        this.style = style;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.Component
    @NotNull
    public final List<Component> children() {
        return this.children;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.Component
    @NotNull
    public final Style style() {
        return this.style;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AbstractComponent)) {
            return false;
        }
        AbstractComponent abstractComponent = (AbstractComponent) obj;
        return Objects.equals(this.children, abstractComponent.children) && Objects.equals(this.style, abstractComponent.style);
    }

    public int hashCode() {
        return (31 * this.children.hashCode()) + this.style.hashCode();
    }

    public abstract String toString();

    /* JADX WARN: Multi-variable type inference failed */
    @Override // me.ulrich.clans.library.kyori.adventure.text.Component
    @NotNull
    /* JADX INFO: renamed from: toBuilder */
    public ComponentBuilder<?, ?> mo683toBuilder() {
        return ((BuildableComponent) this).mo683toBuilder();
    }

    private String debuggerString() {
        return StringExaminer.simpleEscaping().examine(examinableName(), examinableProperties().filter(examinableProperty -> {
            return !examinableProperty.name().equals("children");
        }));
    }
}
