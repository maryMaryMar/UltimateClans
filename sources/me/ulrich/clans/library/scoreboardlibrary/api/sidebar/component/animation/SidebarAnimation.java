package me.ulrich.clans.library.scoreboardlibrary.api.sidebar.component.animation;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/scoreboardlibrary/api/sidebar/component/animation/SidebarAnimation.class */
public interface SidebarAnimation<T> {
    @NotNull
    T currentFrame();

    void nextFrame();
}
