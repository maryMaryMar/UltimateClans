package me.ulrich.clans.library.kyori.adventure.text.event;

import java.util.function.UnaryOperator;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/event/HoverEventSource.class */
public interface HoverEventSource<V> {
    @Nullable
    static <V> HoverEvent<V> unbox(@Nullable HoverEventSource<V> hoverEventSource) {
        if (hoverEventSource != null) {
            return hoverEventSource.asHoverEvent();
        }
        return null;
    }

    @NotNull
    default HoverEvent<V> asHoverEvent() {
        return asHoverEvent(UnaryOperator.identity());
    }

    @NotNull
    HoverEvent<V> asHoverEvent(@NotNull UnaryOperator<V> unaryOperator);
}
