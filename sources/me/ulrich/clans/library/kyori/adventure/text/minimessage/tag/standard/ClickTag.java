package me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.standard;

import java.util.function.BiFunction;
import me.ulrich.clans.library.kyori.adventure.text.event.ClickEvent;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.Context;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.serializer.QuotingOverride;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.serializer.SerializableResolver;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.serializer.StyleClaim;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.Tag;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.resolver.ArgumentQueue;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.resolver.TagResolver;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/minimessage/tag/standard/ClickTag.class */
final class ClickTag {
    private static final String CLICK = "click";
    static final TagResolver RESOLVER = SerializableResolver.claimingStyle(CLICK, (BiFunction<ArgumentQueue, Context, Tag>) ClickTag::create, (StyleClaim<?>) StyleClaim.claim(CLICK, (v0) -> {
        return v0.clickEvent();
    }, (clickEvent, tokenEmitter) -> {
        tokenEmitter.tag(CLICK).argument(ClickEvent.Action.NAMES.key(clickEvent.action())).argument(clickEvent.value(), QuotingOverride.QUOTED);
    }));

    private ClickTag() {
    }

    static Tag create(ArgumentQueue argumentQueue, Context context) {
        String strLowerValue = argumentQueue.popOr(() -> {
            return "A click tag requires an action of one of " + ClickEvent.Action.NAMES.keys();
        }).lowerValue();
        ClickEvent.Action actionValue = ClickEvent.Action.NAMES.value(strLowerValue);
        if (actionValue == null) {
            throw context.newException("Unknown click event action '" + strLowerValue + "'", argumentQueue);
        }
        return Tag.styling(ClickEvent.clickEvent(actionValue, argumentQueue.popOr("Click event actions require a value").value()));
    }
}
