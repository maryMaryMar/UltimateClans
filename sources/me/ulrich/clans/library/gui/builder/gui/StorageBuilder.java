package me.ulrich.clans.library.gui.builder.gui;

import java.util.function.Consumer;
import me.ulrich.clans.library.gui.guis.StorageGui;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/gui/builder/gui/StorageBuilder.class */
public final class StorageBuilder extends BaseChestGuiBuilder<StorageGui, StorageBuilder> {
    @Override // me.ulrich.clans.library.gui.builder.gui.BaseGuiBuilder
    @Contract(" -> new")
    @NotNull
    public StorageGui create() {
        StorageGui storageGui = new StorageGui(createContainer(), getModifiers());
        Consumer<G> consumer = getConsumer();
        if (consumer != 0) {
            consumer.accept(storageGui);
        }
        return storageGui;
    }
}
