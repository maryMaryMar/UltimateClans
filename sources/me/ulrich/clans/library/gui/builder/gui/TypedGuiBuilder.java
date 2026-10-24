package me.ulrich.clans.library.gui.builder.gui;

import java.util.function.Consumer;
import me.ulrich.clans.library.gui.components.GuiContainer;
import me.ulrich.clans.library.gui.components.GuiType;
import me.ulrich.clans.library.gui.components.InventoryProvider;
import me.ulrich.clans.library.gui.components.util.Legacy;
import me.ulrich.clans.library.gui.guis.Gui;
import org.bukkit.Bukkit;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/gui/builder/gui/TypedGuiBuilder.class */
public final class TypedGuiBuilder extends BaseGuiBuilder<Gui, TypedGuiBuilder> {
    private GuiType guiType;
    private InventoryProvider.Typed inventoryProvider = (component, inventoryHolder, inventoryType) -> {
        return Bukkit.createInventory(inventoryHolder, inventoryType, Legacy.SERIALIZER.serialize(component));
    };

    public TypedGuiBuilder(@NotNull GuiType guiType) {
        this.guiType = guiType;
    }

    public TypedGuiBuilder(@NotNull GuiType guiType, @NotNull ChestGuiBuilder chestGuiBuilder) {
        this.guiType = guiType;
        consumeBuilder(chestGuiBuilder);
    }

    @Contract("_ -> this")
    @NotNull
    public TypedGuiBuilder type(@NotNull GuiType guiType) {
        this.guiType = guiType;
        return this;
    }

    @Contract("_ -> this")
    @NotNull
    public TypedGuiBuilder inventory(@NotNull InventoryProvider.Typed typed) {
        this.inventoryProvider = typed;
        return this;
    }

    @Override // me.ulrich.clans.library.gui.builder.gui.BaseGuiBuilder
    @Contract(" -> new")
    @NotNull
    public Gui create() {
        Gui gui = new Gui(new GuiContainer.Typed(getTitle(), this.inventoryProvider, this.guiType), getModifiers());
        Consumer<Gui> consumer = getConsumer();
        if (consumer != null) {
            consumer.accept(gui);
        }
        return gui;
    }
}
