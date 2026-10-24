package me.ulrich.clans.library.scoreboardlibrary.api.sidebar.component;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.UnmodifiableIterator;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import me.ulrich.clans.library.kyori.adventure.text.Component;
import me.ulrich.clans.library.kyori.adventure.text.ComponentLike;
import me.ulrich.clans.library.scoreboardlibrary.api.objective.ScoreFormat;
import me.ulrich.clans.library.scoreboardlibrary.api.sidebar.component.animation.SidebarAnimation;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/scoreboardlibrary/api/sidebar/component/SidebarComponent.class */
public interface SidebarComponent {

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/scoreboardlibrary/api/sidebar/component/SidebarComponent$Builder.class */
    public static final class Builder {
        private final List<SidebarComponent> children;

        private Builder() {
            this.children = new ArrayList(4);
        }

        @NotNull
        public Builder addComponent(@NotNull SidebarComponent sidebarComponent) {
            Preconditions.checkNotNull(sidebarComponent);
            this.children.add(sidebarComponent);
            return this;
        }

        @NotNull
        public Builder addStaticLine(@NotNull ComponentLike componentLike) {
            return addComponent(SidebarComponent.staticLine(componentLike));
        }

        @NotNull
        public Builder addStaticLine(@NotNull ComponentLike componentLike, @NotNull ScoreFormat scoreFormat) {
            return addComponent(SidebarComponent.staticLine(componentLike, scoreFormat));
        }

        @NotNull
        public Builder addBlankLine() {
            return addComponent(SidebarComponent.blankLine());
        }

        @NotNull
        public <T extends ComponentLike> Builder addDynamicLine(@NotNull Supplier<T> supplier) {
            return addComponent(SidebarComponent.dynamicLine(supplier));
        }

        @NotNull
        public <T extends ComponentLike> Builder addAnimatedLine(@NotNull SidebarAnimation<T> sidebarAnimation) {
            return addComponent(SidebarComponent.animatedLine(sidebarAnimation));
        }

        @NotNull
        public <T extends SidebarComponent> Builder addAnimatedComponent(@NotNull SidebarAnimation<T> sidebarAnimation) {
            return addComponent(SidebarComponent.animatedComponent(sidebarAnimation));
        }

        @NotNull
        public SidebarComponent build() {
            ImmutableList immutableListCopyOf = ImmutableList.copyOf(this.children);
            return lineDrawable -> {
                UnmodifiableIterator it = immutableListCopyOf.iterator();
                while (it.hasNext()) {
                    ((SidebarComponent) it.next()).draw(lineDrawable);
                }
            };
        }
    }

    @NotNull
    static SidebarComponent staticLine(@NotNull ComponentLike componentLike) {
        Preconditions.checkNotNull(componentLike);
        return lineDrawable -> {
            lineDrawable.drawLine(componentLike);
        };
    }

    @NotNull
    static SidebarComponent staticLine(@NotNull ComponentLike componentLike, @NotNull ScoreFormat scoreFormat) {
        Preconditions.checkNotNull(componentLike);
        return lineDrawable -> {
            lineDrawable.drawLine(componentLike, scoreFormat);
        };
    }

    @NotNull
    static SidebarComponent blankLine() {
        return lineDrawable -> {
            lineDrawable.drawLine(Component.empty());
        };
    }

    @NotNull
    static <T extends ComponentLike> SidebarComponent dynamicLine(@NotNull Supplier<T> supplier) {
        return lineDrawable -> {
            lineDrawable.drawLine((ComponentLike) supplier.get());
        };
    }

    @NotNull
    static <T extends ComponentLike> SidebarComponent animatedLine(@NotNull SidebarAnimation<T> sidebarAnimation) {
        Preconditions.checkNotNull(sidebarAnimation);
        return lineDrawable -> {
            lineDrawable.drawLine((ComponentLike) sidebarAnimation.currentFrame());
        };
    }

    @NotNull
    static <T extends SidebarComponent> SidebarComponent animatedComponent(@NotNull SidebarAnimation<T> sidebarAnimation) {
        Preconditions.checkNotNull(sidebarAnimation);
        return lineDrawable -> {
            ((SidebarComponent) sidebarAnimation.currentFrame()).draw(lineDrawable);
        };
    }

    @NotNull
    static Builder builder() {
        return new Builder();
    }

    void draw(@NotNull LineDrawable lineDrawable);
}
