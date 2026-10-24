package me.ulrich.clans.library.enumconfig.library.events;

import me.ulrich.clans.library.enumconfig.library.DumperOptions;
import me.ulrich.clans.library.enumconfig.library.error.Mark;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/events/ScalarEvent.class */
public final class ScalarEvent extends NodeEvent {
    private final String tag;
    private final DumperOptions.ScalarStyle style;
    private final String value;
    private final ImplicitTuple implicit;

    public ScalarEvent(String str, String str2, ImplicitTuple implicitTuple, String str3, Mark mark, Mark mark2, DumperOptions.ScalarStyle scalarStyle) {
        super(str, mark, mark2);
        this.tag = str2;
        this.implicit = implicitTuple;
        if (str3 == null) {
            throw new NullPointerException("Value must be provided.");
        }
        this.value = str3;
        if (scalarStyle == null) {
            throw new NullPointerException("Style must be provided.");
        }
        this.style = scalarStyle;
    }

    public String getTag() {
        return this.tag;
    }

    public DumperOptions.ScalarStyle getScalarStyle() {
        return this.style;
    }

    public String getValue() {
        return this.value;
    }

    public ImplicitTuple getImplicit() {
        return this.implicit;
    }

    @Override // me.ulrich.clans.library.enumconfig.library.events.NodeEvent, me.ulrich.clans.library.enumconfig.library.events.Event
    protected String getArguments() {
        return super.getArguments() + ", tag=" + this.tag + ", style=" + this.style + "," + this.implicit + ", value=" + this.value;
    }

    @Override // me.ulrich.clans.library.enumconfig.library.events.Event
    public Event.ID getEventId() {
        return Event.ID.Scalar;
    }

    public boolean isPlain() {
        return this.style == DumperOptions.ScalarStyle.PLAIN;
    }

    public boolean isLiteral() {
        return this.style == DumperOptions.ScalarStyle.LITERAL;
    }

    public boolean isSQuoted() {
        return this.style == DumperOptions.ScalarStyle.SINGLE_QUOTED;
    }

    public boolean isDQuoted() {
        return this.style == DumperOptions.ScalarStyle.DOUBLE_QUOTED;
    }

    public boolean isFolded() {
        return this.style == DumperOptions.ScalarStyle.FOLDED;
    }

    public boolean isJson() {
        return this.style == DumperOptions.ScalarStyle.JSON_SCALAR_STYLE;
    }
}
