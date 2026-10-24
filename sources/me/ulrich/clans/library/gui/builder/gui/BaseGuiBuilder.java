package me.ulrich.clans.library.gui.builder.gui;

import java.util.EnumSet;
import java.util.Set;
import java.util.function.Consumer;
import me.ulrich.clans.library.gui.builder.gui.BaseGuiBuilder;
import me.ulrich.clans.library.gui.components.InteractionModifier;
import me.ulrich.clans.library.gui.components.exception.GuiException;
import me.ulrich.clans.library.gui.guis.BaseGui;
import me.ulrich.clans.library.kyori.adventure.text.Component;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/gui/builder/gui/BaseGuiBuilder.class */
public abstract class BaseGuiBuilder<G extends BaseGui, B extends BaseGuiBuilder<G, B>> {
    private Component title = null;
    private final EnumSet<InteractionModifier> interactionModifiers = EnumSet.noneOf(InteractionModifier.class);
    private Consumer<G> consumer;

    @Contract("_ -> this")
    @NotNull
    public B title(@NotNull Component component) {
        this.title = component;
        return this;
    }

    @Contract(" -> this")
    @NotNull
    public B disableItemPlace() {
        this.interactionModifiers.add(InteractionModifier.PREVENT_ITEM_PLACE);
        return this;
    }

    @Contract(" -> this")
    @NotNull
    public B disableItemTake() {
        this.interactionModifiers.add(InteractionModifier.PREVENT_ITEM_TAKE);
        return this;
    }

    @Contract(" -> this")
    @NotNull
    public B disableItemSwap() {
        this.interactionModifiers.add(InteractionModifier.PREVENT_ITEM_SWAP);
        return this;
    }

    @Contract(" -> this")
    @NotNull
    public B disableItemDrop() {
        this.interactionModifiers.add(InteractionModifier.PREVENT_ITEM_DROP);
        return this;
    }

    @Contract(" -> this")
    @NotNull
    public B disableOtherActions() {
        this.interactionModifiers.add(InteractionModifier.PREVENT_OTHER_ACTIONS);
        return this;
    }

    @Contract(" -> this")
    @NotNull
    public B disableAllInteractions() {
        this.interactionModifiers.addAll(InteractionModifier.VALUES);
        return this;
    }

    @Contract(" -> this")
    @NotNull
    public B enableItemPlace() {
        this.interactionModifiers.remove(InteractionModifier.PREVENT_ITEM_PLACE);
        return this;
    }

    @Contract(" -> this")
    @NotNull
    public B enableItemTake() {
        this.interactionModifiers.remove(InteractionModifier.PREVENT_ITEM_TAKE);
        return this;
    }

    @Contract(" -> this")
    @NotNull
    public B enableItemSwap() {
        this.interactionModifiers.remove(InteractionModifier.PREVENT_ITEM_SWAP);
        return this;
    }

    @Contract(" -> this")
    @NotNull
    public B enableItemDrop() {
        this.interactionModifiers.remove(InteractionModifier.PREVENT_ITEM_DROP);
        return this;
    }

    @Contract(" -> this")
    @NotNull
    public B enableOtherActions() {
        this.interactionModifiers.remove(InteractionModifier.PREVENT_OTHER_ACTIONS);
        return this;
    }

    @Contract(" -> this")
    @NotNull
    public B enableAllInteractions() {
        this.interactionModifiers.clear();
        return this;
    }

    @Contract("_ -> this")
    @NotNull
    public B apply(@NotNull Consumer<G> consumer) {
        this.consumer = consumer;
        return this;
    }

    @Contract(" -> new")
    @NotNull
    public abstract G create();

    @NotNull
    protected Component getTitle() {
        if (this.title == null) {
            throw new GuiException("GUI title is missing!");
        }
        return this.title;
    }

    @Nullable
    protected Consumer<G> getConsumer() {
        return this.consumer;
    }

    @NotNull
    protected Set<InteractionModifier> getModifiers() {
        return this.interactionModifiers;
    }

    protected void consumeBuilder(@NotNull BaseGuiBuilder<?, ?> baseGuiBuilder) {
        this.title = baseGuiBuilder.title;
        this.interactionModifiers.addAll(baseGuiBuilder.interactionModifiers);
    }
}
