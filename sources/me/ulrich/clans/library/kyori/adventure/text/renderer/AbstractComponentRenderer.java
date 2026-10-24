package me.ulrich.clans.library.kyori.adventure.text.renderer;

import me.ulrich.clans.library.kyori.adventure.text.BlockNBTComponent;
import me.ulrich.clans.library.kyori.adventure.text.Component;
import me.ulrich.clans.library.kyori.adventure.text.EntityNBTComponent;
import me.ulrich.clans.library.kyori.adventure.text.KeybindComponent;
import me.ulrich.clans.library.kyori.adventure.text.NBTComponent;
import me.ulrich.clans.library.kyori.adventure.text.ScoreComponent;
import me.ulrich.clans.library.kyori.adventure.text.SelectorComponent;
import me.ulrich.clans.library.kyori.adventure.text.StorageNBTComponent;
import me.ulrich.clans.library.kyori.adventure.text.TextComponent;
import me.ulrich.clans.library.kyori.adventure.text.TranslatableComponent;
import me.ulrich.clans.library.kyori.adventure.text.VirtualComponent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/renderer/AbstractComponentRenderer.class */
public abstract class AbstractComponentRenderer<C> implements ComponentRenderer<C> {
    @Override // me.ulrich.clans.library.kyori.adventure.text.renderer.ComponentRenderer
    @NotNull
    public Component render(@NotNull Component component, @NotNull C c) {
        if (component instanceof VirtualComponent) {
            component = renderVirtual((VirtualComponent) component, c);
        }
        if (component instanceof TextComponent) {
            return renderText((TextComponent) component, c);
        }
        if (component instanceof TranslatableComponent) {
            return renderTranslatable((TranslatableComponent) component, c);
        }
        if (component instanceof KeybindComponent) {
            return renderKeybind((KeybindComponent) component, c);
        }
        if (component instanceof ScoreComponent) {
            return renderScore((ScoreComponent) component, c);
        }
        if (component instanceof SelectorComponent) {
            return renderSelector((SelectorComponent) component, c);
        }
        if (component instanceof NBTComponent) {
            if (component instanceof BlockNBTComponent) {
                return renderBlockNbt((BlockNBTComponent) component, c);
            }
            if (component instanceof EntityNBTComponent) {
                return renderEntityNbt((EntityNBTComponent) component, c);
            }
            if (component instanceof StorageNBTComponent) {
                return renderStorageNbt((StorageNBTComponent) component, c);
            }
        }
        return component;
    }

    @NotNull
    protected abstract Component renderBlockNbt(@NotNull BlockNBTComponent blockNBTComponent, @NotNull C c);

    @NotNull
    protected abstract Component renderEntityNbt(@NotNull EntityNBTComponent entityNBTComponent, @NotNull C c);

    @NotNull
    protected abstract Component renderStorageNbt(@NotNull StorageNBTComponent storageNBTComponent, @NotNull C c);

    @NotNull
    protected abstract Component renderKeybind(@NotNull KeybindComponent keybindComponent, @NotNull C c);

    @NotNull
    protected abstract Component renderScore(@NotNull ScoreComponent scoreComponent, @NotNull C c);

    @NotNull
    protected abstract Component renderSelector(@NotNull SelectorComponent selectorComponent, @NotNull C c);

    @NotNull
    protected abstract Component renderText(@NotNull TextComponent textComponent, @NotNull C c);

    @NotNull
    protected Component renderVirtual(@NotNull VirtualComponent virtualComponent, @NotNull C c) {
        return virtualComponent;
    }

    @NotNull
    protected abstract Component renderTranslatable(@NotNull TranslatableComponent translatableComponent, @NotNull C c);
}
