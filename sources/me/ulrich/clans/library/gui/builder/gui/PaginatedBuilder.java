package me.ulrich.clans.library.gui.builder.gui;

import java.util.function.Consumer;
import me.ulrich.clans.library.gui.guis.PaginatedGui;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/gui/builder/gui/PaginatedBuilder.class */
public class PaginatedBuilder extends BaseChestGuiBuilder<PaginatedGui, PaginatedBuilder> {
    private int pageSize = 0;

    @Contract("_ -> this")
    @NotNull
    public PaginatedBuilder pageSize(int i) {
        this.pageSize = i;
        return this;
    }

    @Override // me.ulrich.clans.library.gui.builder.gui.BaseGuiBuilder
    @Contract(" -> new")
    @NotNull
    public PaginatedGui create() {
        PaginatedGui paginatedGui = new PaginatedGui(createContainer(), this.pageSize, getModifiers());
        Consumer<G> consumer = getConsumer();
        if (consumer != 0) {
            consumer.accept(paginatedGui);
        }
        return paginatedGui;
    }
}
