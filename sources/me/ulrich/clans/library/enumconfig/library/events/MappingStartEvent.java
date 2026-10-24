package me.ulrich.clans.library.enumconfig.library.events;

import me.ulrich.clans.library.enumconfig.library.DumperOptions;
import me.ulrich.clans.library.enumconfig.library.error.Mark;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/events/MappingStartEvent.class */
public final class MappingStartEvent extends CollectionStartEvent {
    public MappingStartEvent(String str, String str2, boolean z, Mark mark, Mark mark2, DumperOptions.FlowStyle flowStyle) {
        super(str, str2, z, mark, mark2, flowStyle);
    }

    @Override // me.ulrich.clans.library.enumconfig.library.events.Event
    public Event.ID getEventId() {
        return Event.ID.MappingStart;
    }
}
