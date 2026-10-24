package me.ulrich.clans.library.gui.guis;

import java.util.Set;
import me.ulrich.clans.library.gui.builder.gui.ChestGuiBuilder;
import me.ulrich.clans.library.gui.builder.gui.PaginatedBuilder;
import me.ulrich.clans.library.gui.builder.gui.ScrollingBuilder;
import me.ulrich.clans.library.gui.builder.gui.StorageBuilder;
import me.ulrich.clans.library.gui.builder.gui.TypedGuiBuilder;
import me.ulrich.clans.library.gui.components.GuiContainer;
import me.ulrich.clans.library.gui.components.GuiType;
import me.ulrich.clans.library.gui.components.InteractionModifier;
import me.ulrich.clans.library.gui.components.ScrollType;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/gui/guis/Gui.class */
public class Gui extends BaseGui {
    public Gui(@NotNull GuiContainer guiContainer, @NotNull Set<InteractionModifier> set) {
        super(guiContainer, set);
    }

    @Contract("_ -> new")
    @NotNull
    public static TypedGuiBuilder gui(@NotNull GuiType guiType) {
        return new TypedGuiBuilder(guiType);
    }

    @Contract(" -> new")
    @NotNull
    public static ChestGuiBuilder gui() {
        return new ChestGuiBuilder();
    }

    @Contract(" -> new")
    @NotNull
    public static StorageBuilder storage() {
        return new StorageBuilder();
    }

    @Contract(" -> new")
    @NotNull
    public static PaginatedBuilder paginated() {
        return new PaginatedBuilder();
    }

    @Contract("_ -> new")
    @NotNull
    public static ScrollingBuilder scrolling(@NotNull ScrollType scrollType) {
        return new ScrollingBuilder(scrollType);
    }

    @Contract(" -> new")
    @NotNull
    public static ScrollingBuilder scrolling() {
        return scrolling(ScrollType.VERTICAL);
    }
}
