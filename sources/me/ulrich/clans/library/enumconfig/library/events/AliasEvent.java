package me.ulrich.clans.library.enumconfig.library.events;

import me.ulrich.clans.library.enumconfig.library.error.Mark;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/events/AliasEvent.class */
public final class AliasEvent extends NodeEvent {
    public AliasEvent(String str, Mark mark, Mark mark2) {
        super(str, mark, mark2);
        if (str == null) {
            throw new NullPointerException("anchor is not specified for alias");
        }
    }

    @Override // me.ulrich.clans.library.enumconfig.library.events.Event
    public Event.ID getEventId() {
        return Event.ID.Alias;
    }
}
