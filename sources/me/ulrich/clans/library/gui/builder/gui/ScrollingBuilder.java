package me.ulrich.clans.library.gui.builder.gui;

import java.util.function.Consumer;
import me.ulrich.clans.library.gui.components.ScrollType;
import me.ulrich.clans.library.gui.guis.ScrollingGui;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/gui/builder/gui/ScrollingBuilder.class */
public final class ScrollingBuilder extends BaseChestGuiBuilder<ScrollingGui, ScrollingBuilder> {
    private ScrollType scrollType;
    private int pageSize = 0;

    public ScrollingBuilder(@NotNull ScrollType scrollType) {
        this.scrollType = scrollType;
    }

    @Contract("_ -> this")
    @NotNull
    public ScrollingBuilder scrollType(@NotNull ScrollType scrollType) {
        this.scrollType = scrollType;
        return this;
    }

    @Contract("_ -> this")
    @NotNull
    public ScrollingBuilder pageSize(int i) {
        this.pageSize = i;
        return this;
    }

    @Override // me.ulrich.clans.library.gui.builder.gui.BaseGuiBuilder
    @Contract(" -> new")
    @NotNull
    public ScrollingGui create() {
        ScrollingGui scrollingGui = new ScrollingGui(createContainer(), this.pageSize, this.scrollType, getModifiers());
        Consumer<G> consumer = getConsumer();
        if (consumer != 0) {
            consumer.accept(scrollingGui);
        }
        return scrollingGui;
    }
}
