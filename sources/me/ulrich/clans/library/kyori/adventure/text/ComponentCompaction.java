package me.ulrich.clans.library.kyori.adventure.text;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import me.ulrich.clans.library.kyori.adventure.text.format.Style;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.VisibleForTesting;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/ComponentCompaction.class */
final class ComponentCompaction {

    @VisibleForTesting
    static final boolean SIMPLIFY_STYLE_FOR_BLANK_COMPONENTS = false;

    private ComponentCompaction() {
    }

    static Component compact(@NotNull Component component, @Nullable Style style) {
        List<Component> listChildren = component.children();
        Component componentChildren = component.children(Collections.emptyList());
        if (style != null) {
            componentChildren = componentChildren.style(component.style().unmerge(style));
        }
        int size = listChildren.size();
        if (size == 0) {
            if (isBlank(componentChildren)) {
                componentChildren = componentChildren.style(simplifyStyleForBlank(componentChildren.style(), style));
            }
            return componentChildren;
        }
        if (size == 1 && isText(componentChildren) && ((TextComponent) componentChildren).content().isEmpty()) {
            Component component2 = listChildren.get(0);
            return component2.style(component2.style().merge(componentChildren.style(), Style.Merge.Strategy.IF_ABSENT_ON_TARGET)).compact();
        }
        Style style2 = componentChildren.style();
        if (style != null) {
            style2 = style2.merge(style, Style.Merge.Strategy.IF_ABSENT_ON_TARGET);
        }
        ArrayList arrayList = new ArrayList(listChildren.size());
        for (int i = 0; i < listChildren.size(); i++) {
            Component componentCompact = compact(listChildren.get(i), style2);
            if (!componentCompact.children().isEmpty() || !isText(componentCompact) || !((TextComponent) componentCompact).content().isEmpty()) {
                arrayList.add(componentCompact);
            }
        }
        if (isText(componentChildren)) {
            while (!arrayList.isEmpty()) {
                Component component3 = (Component) arrayList.get(0);
                Style styleMerge = component3.style().merge(style2, Style.Merge.Strategy.IF_ABSENT_ON_TARGET);
                if (!isText(component3) || !Objects.equals(styleMerge, style2)) {
                    break;
                }
                componentChildren = joinText((TextComponent) componentChildren, (TextComponent) component3);
                arrayList.remove(0);
                arrayList.addAll(0, component3.children());
            }
        }
        int i2 = 0;
        while (i2 + 1 < arrayList.size()) {
            Component component4 = (Component) arrayList.get(i2);
            Component component5 = (Component) arrayList.get(i2 + 1);
            if (component4.children().isEmpty() && isText(component4) && isText(component5) && component4.style().merge(style2, Style.Merge.Strategy.IF_ABSENT_ON_TARGET).equals(component5.style().merge(style2, Style.Merge.Strategy.IF_ABSENT_ON_TARGET))) {
                arrayList.set(i2, joinText((TextComponent) component4, (TextComponent) component5));
                arrayList.remove(i2 + 1);
            } else {
                i2++;
            }
        }
        if (arrayList.isEmpty() && isBlank(componentChildren)) {
            componentChildren = componentChildren.style(simplifyStyleForBlank(componentChildren.style(), style));
        }
        return componentChildren.children(arrayList);
    }

    private static boolean isBlank(Component component) {
        if (!isText(component)) {
            return false;
        }
        String strContent = ((TextComponent) component).content();
        for (int i = 0; i < strContent.length(); i++) {
            if (strContent.charAt(i) != ' ') {
                return false;
            }
        }
        return true;
    }

    @NotNull
    private static Style simplifyStyleForBlank(@NotNull Style style, @Nullable Style style2) {
        return style;
    }

    private static TextComponent joinText(TextComponent textComponent, TextComponent textComponent2) {
        return TextComponentImpl.create(textComponent2.children(), textComponent.style(), textComponent.content() + textComponent2.content());
    }

    private static boolean isText(Component component) {
        return (component instanceof TextComponent) && !(component instanceof VirtualComponent);
    }
}
