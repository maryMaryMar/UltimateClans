package me.ulrich.clans.library.gui.builder.gui;

import java.util.function.Consumer;
import me.ulrich.clans.library.gui.components.GuiType;
import me.ulrich.clans.library.gui.guis.Gui;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/gui/builder/gui/ChestGuiBuilder.class */
public final class ChestGuiBuilder extends BaseChestGuiBuilder<Gui, ChestGuiBuilder> {
    @Contract("_ -> new")
    @NotNull
    public TypedGuiBuilder type(@NotNull GuiType guiType) {
        return new TypedGuiBuilder(guiType, this);
    }

    @Override // me.ulrich.clans.library.gui.builder.gui.BaseGuiBuilder
    @Contract(" -> new")
    @NotNull
    public Gui create() {
        Gui gui = new Gui(createContainer(), getModifiers());
        Consumer<G> consumer = getConsumer();
        if (consumer != 0) {
            consumer.accept(gui);
        }
        return gui;
    }
}
