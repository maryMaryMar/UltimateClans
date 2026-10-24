package me.ulrich.clans.library.gui.components.exception;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/gui/components/exception/GuiException.class */
public final class GuiException extends RuntimeException {
    public GuiException(String str) {
        super(str);
    }

    public GuiException(String str, Exception exc) {
        super(str, exc);
    }
}
