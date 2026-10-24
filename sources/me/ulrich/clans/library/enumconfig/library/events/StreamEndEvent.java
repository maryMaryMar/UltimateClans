package me.ulrich.clans.library.enumconfig.library.events;

import me.ulrich.clans.library.enumconfig.library.error.Mark;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/events/StreamEndEvent.class */
public final class StreamEndEvent extends Event {
    public StreamEndEvent(Mark mark, Mark mark2) {
        super(mark, mark2);
    }

    @Override // me.ulrich.clans.library.enumconfig.library.events.Event
    public Event.ID getEventId() {
        return Event.ID.StreamEnd;
    }
}
