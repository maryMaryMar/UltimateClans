package me.ulrich.clans.library.kyori.adventure.text;

import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import me.ulrich.clans.library.kyori.adventure.text.event.HoverEvent;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/ComponentIteratorType.class */
@FunctionalInterface
@ApiStatus.NonExtendable
public interface ComponentIteratorType {
    public static final ComponentIteratorType DEPTH_FIRST = (component, deque, set) -> {
        if (set.contains(ComponentIteratorFlag.INCLUDE_TRANSLATABLE_COMPONENT_ARGUMENTS) && (component instanceof TranslatableComponent)) {
            List<TranslationArgument> listArguments = ((TranslatableComponent) component).arguments();
            for (int size = listArguments.size() - 1; size >= 0; size--) {
                deque.addFirst(listArguments.get(size).asComponent());
            }
        }
        HoverEvent<?> hoverEvent = component.hoverEvent();
        if (hoverEvent != null) {
            HoverEvent.Action<?> action = hoverEvent.action();
            if (set.contains(ComponentIteratorFlag.INCLUDE_HOVER_SHOW_ENTITY_NAME) && action == HoverEvent.Action.SHOW_ENTITY) {
                deque.addFirst(((HoverEvent.ShowEntity) hoverEvent.value()).name());
            } else if (set.contains(ComponentIteratorFlag.INCLUDE_HOVER_SHOW_TEXT_COMPONENT) && action == HoverEvent.Action.SHOW_TEXT) {
                deque.addFirst((Component) hoverEvent.value());
            }
        }
        List<Component> listChildren = component.children();
        for (int size2 = listChildren.size() - 1; size2 >= 0; size2--) {
            deque.addFirst(listChildren.get(size2));
        }
    };
    public static final ComponentIteratorType BREADTH_FIRST = (component, deque, set) -> {
        if (set.contains(ComponentIteratorFlag.INCLUDE_TRANSLATABLE_COMPONENT_ARGUMENTS) && (component instanceof TranslatableComponent)) {
            Iterator<TranslationArgument> it = ((TranslatableComponent) component).arguments().iterator();
            while (it.hasNext()) {
                deque.add(it.next().asComponent());
            }
        }
        HoverEvent<?> hoverEvent = component.hoverEvent();
        if (hoverEvent != null) {
            HoverEvent.Action<?> action = hoverEvent.action();
            if (set.contains(ComponentIteratorFlag.INCLUDE_HOVER_SHOW_ENTITY_NAME) && action == HoverEvent.Action.SHOW_ENTITY) {
                deque.addLast(((HoverEvent.ShowEntity) hoverEvent.value()).name());
            } else if (set.contains(ComponentIteratorFlag.INCLUDE_HOVER_SHOW_TEXT_COMPONENT) && action == HoverEvent.Action.SHOW_TEXT) {
                deque.addLast((Component) hoverEvent.value());
            }
        }
        deque.addAll(component.children());
    };

    void populate(@NotNull Component component, @NotNull Deque<Component> deque, @NotNull Set<ComponentIteratorFlag> set);
}
