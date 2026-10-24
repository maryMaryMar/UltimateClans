package me.ulrich.clans.library.scoreboardlibrary.api.sidebar.component.animation;

import java.util.List;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/scoreboardlibrary/api/sidebar/component/animation/FramedSidebarAnimation.class */
public interface FramedSidebarAnimation<T> extends SidebarAnimation<T> {
    @NotNull
    List<T> frames();

    int currentFrameIndex();

    void switchFrame(int i);
}
