package me.ulrich.clans.library.enumconfig.library.events;

import me.ulrich.clans.library.enumconfig.library.error.Mark;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/events/NodeEvent.class */
public abstract class NodeEvent extends Event {
    private final String anchor;

    public NodeEvent(String str, Mark mark, Mark mark2) {
        super(mark, mark2);
        this.anchor = str;
    }

    public String getAnchor() {
        return this.anchor;
    }

    @Override // me.ulrich.clans.library.enumconfig.library.events.Event
    protected String getArguments() {
        return "anchor=" + this.anchor;
    }
}
