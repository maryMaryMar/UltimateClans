package me.ulrich.clans.library.scoreboardlibrary.api.sidebar.component.animation;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.util.Collection;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/scoreboardlibrary/api/sidebar/component/animation/CollectionSidebarAnimation.class */
public final class CollectionSidebarAnimation<T> implements FramedSidebarAnimation<T> {
    private final List<T> frames;
    private int currentFrameIndex;

    public CollectionSidebarAnimation(@NotNull Collection<T> collection) {
        Preconditions.checkNotNull(collection);
        Preconditions.checkArgument(!collection.isEmpty());
        this.frames = ImmutableList.copyOf(collection);
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.sidebar.component.animation.FramedSidebarAnimation
    @NotNull
    public List<T> frames() {
        return this.frames;
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.sidebar.component.animation.FramedSidebarAnimation
    public int currentFrameIndex() {
        return this.currentFrameIndex;
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.sidebar.component.animation.FramedSidebarAnimation
    public void switchFrame(int i) {
        if (i < 0 || i >= this.frames.size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        this.currentFrameIndex = i;
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.sidebar.component.animation.SidebarAnimation
    @NotNull
    public T currentFrame() {
        return this.frames.get(this.currentFrameIndex);
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.sidebar.component.animation.SidebarAnimation
    public void nextFrame() {
        int i = this.currentFrameIndex + 1;
        this.currentFrameIndex = i;
        if (i == this.frames.size()) {
            this.currentFrameIndex = 0;
        }
    }
}
