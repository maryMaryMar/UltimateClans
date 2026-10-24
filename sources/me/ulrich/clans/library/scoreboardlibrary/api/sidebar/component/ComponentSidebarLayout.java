package me.ulrich.clans.library.scoreboardlibrary.api.sidebar.component;

import com.google.common.base.Preconditions;
import me.ulrich.clans.library.kyori.adventure.text.Component;
import me.ulrich.clans.library.kyori.adventure.text.ComponentLike;
import me.ulrich.clans.library.scoreboardlibrary.api.objective.ScoreFormat;
import me.ulrich.clans.library.scoreboardlibrary.api.sidebar.Sidebar;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/scoreboardlibrary/api/sidebar/component/ComponentSidebarLayout.class */
public final class ComponentSidebarLayout {
    private final SidebarComponent titleComponent;
    private final SidebarComponent linesComponent;

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/scoreboardlibrary/api/sidebar/component/ComponentSidebarLayout$SidebarLineDrawable.class */
    private static class SidebarLineDrawable implements LineDrawable {
        private final Sidebar sidebar;
        private int index = 0;

        public SidebarLineDrawable(@NotNull Sidebar sidebar) {
            this.sidebar = sidebar;
        }

        @Override // me.ulrich.clans.library.scoreboardlibrary.api.sidebar.component.LineDrawable
        public void drawLine(@NotNull ComponentLike componentLike, @Nullable ScoreFormat scoreFormat) {
            Preconditions.checkNotNull(componentLike);
            if (this.index < this.sidebar.maxLines()) {
                Sidebar sidebar = this.sidebar;
                int i = this.index;
                this.index = i + 1;
                sidebar.line(i, componentLike, scoreFormat);
            }
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/scoreboardlibrary/api/sidebar/component/ComponentSidebarLayout$SidebarTitleDrawable.class */
    private static class SidebarTitleDrawable implements LineDrawable {
        private Component title;

        private SidebarTitleDrawable() {
        }

        @Override // me.ulrich.clans.library.scoreboardlibrary.api.sidebar.component.LineDrawable
        public void drawLine(@NotNull ComponentLike componentLike, @Nullable ScoreFormat scoreFormat) {
            Preconditions.checkNotNull(componentLike);
            if (this.title == null) {
                this.title = componentLike.asComponent();
            }
        }
    }

    public ComponentSidebarLayout(@NotNull SidebarComponent sidebarComponent, @NotNull SidebarComponent sidebarComponent2) {
        Preconditions.checkNotNull(sidebarComponent);
        Preconditions.checkNotNull(sidebarComponent2);
        this.titleComponent = sidebarComponent;
        this.linesComponent = sidebarComponent2;
    }

    @NotNull
    public SidebarComponent titleComponent() {
        return this.titleComponent;
    }

    @NotNull
    public SidebarComponent linesComponent() {
        return this.linesComponent;
    }

    public void apply(@NotNull Sidebar sidebar) {
        Preconditions.checkNotNull(sidebar);
        SidebarTitleDrawable sidebarTitleDrawable = new SidebarTitleDrawable();
        this.titleComponent.draw(sidebarTitleDrawable);
        sidebar.title(sidebarTitleDrawable.title == null ? Component.empty() : sidebarTitleDrawable.title);
        SidebarLineDrawable sidebarLineDrawable = new SidebarLineDrawable(sidebar);
        this.linesComponent.draw(sidebarLineDrawable);
        for (int i = sidebarLineDrawable.index; i < 15; i++) {
            sidebar.line(i, null);
        }
    }
}
