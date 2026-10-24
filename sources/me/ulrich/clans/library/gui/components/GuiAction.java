package me.ulrich.clans.library.gui.components;

import org.bukkit.event.Event;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/gui/components/GuiAction.class */
@FunctionalInterface
public interface GuiAction<T extends Event> {
    void execute(T t);
}
