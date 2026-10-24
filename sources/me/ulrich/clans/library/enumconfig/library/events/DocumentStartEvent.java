package me.ulrich.clans.library.enumconfig.library.events;

import java.util.Map;
import me.ulrich.clans.library.enumconfig.library.DumperOptions;
import me.ulrich.clans.library.enumconfig.library.error.Mark;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/events/DocumentStartEvent.class */
public final class DocumentStartEvent extends Event {
    private final boolean explicit;
    private final DumperOptions.Version version;
    private final Map<String, String> tags;

    public DocumentStartEvent(Mark mark, Mark mark2, boolean z, DumperOptions.Version version, Map<String, String> map) {
        super(mark, mark2);
        this.explicit = z;
        this.version = version;
        this.tags = map;
    }

    public boolean getExplicit() {
        return this.explicit;
    }

    public DumperOptions.Version getVersion() {
        return this.version;
    }

    public Map<String, String> getTags() {
        return this.tags;
    }

    @Override // me.ulrich.clans.library.enumconfig.library.events.Event
    public Event.ID getEventId() {
        return Event.ID.DocumentStart;
    }
}
