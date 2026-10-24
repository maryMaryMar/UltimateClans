package me.ulrich.clans.library.enumconfig.library.events;

import me.ulrich.clans.library.enumconfig.library.error.Mark;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/events/MappingEndEvent.class */
public final class MappingEndEvent extends CollectionEndEvent {
    public MappingEndEvent(Mark mark, Mark mark2) {
        super(mark, mark2);
    }

    @Override // me.ulrich.clans.library.enumconfig.library.events.Event
    public Event.ID getEventId() {
        return Event.ID.MappingEnd;
    }
}
