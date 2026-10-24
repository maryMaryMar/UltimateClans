package me.ulrich.clans.library.scoreboardlibrary.implementation.commons;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import me.ulrich.clans.library.kyori.adventure.text.Component;
import me.ulrich.clans.library.kyori.adventure.text.TextComponent;
import me.ulrich.clans.library.kyori.adventure.text.format.NamedTextColor;
import me.ulrich.clans.library.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import me.ulrich.clans.library.kyori.adventure.text.serializer.legacy.LegacyFormat;
import me.ulrich.clans.library.kyori.adventure.translation.GlobalTranslator;
import org.bukkit.ChatColor;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/scoreboardlibrary/implementation/commons/LegacyFormatUtil.class */
public final class LegacyFormatUtil {
    private static final Map<NamedTextColor, ChatColor> chatColorMap;

    private LegacyFormatUtil() {
    }

    public static String limitLegacyText(String str, int i) {
        if (str.length() <= i) {
            return str;
        }
        int i2 = i - 1;
        while (str.charAt(i2) == 167) {
            i2--;
        }
        return str.substring(0, i2 + 1);
    }

    public static String serialize(@Nullable Component component, @Nullable Locale locale) {
        if (component == null || component == Component.empty()) {
            return "";
        }
        Component componentRender = locale != null ? GlobalTranslator.render(component, locale) : component;
        Component componentProcessLastTextComponent = processLastTextComponent(componentRender);
        String strSerialize = LegacyComponentSerializer.legacySection().serialize(componentProcessLastTextComponent);
        if (componentProcessLastTextComponent != componentRender) {
            strSerialize = strSerialize.substring(0, strSerialize.length() - 1);
        }
        return strSerialize;
    }

    private static Component processLastTextComponent(Component component) {
        List<Component> listChildren = component.children();
        if (listChildren.isEmpty()) {
            if (component instanceof TextComponent) {
                TextComponent textComponent = (TextComponent) component;
                if (textComponent.content().isEmpty()) {
                    return textComponent.content(" ");
                }
            }
            return component;
        }
        Component component2 = listChildren.get(listChildren.size() - 1);
        Component componentProcessLastTextComponent = processLastTextComponent(component2);
        if (componentProcessLastTextComponent == component2) {
            return component;
        }
        ArrayList arrayList = new ArrayList(listChildren);
        arrayList.set(arrayList.size() - 1, componentProcessLastTextComponent);
        return component.children(arrayList);
    }

    public static char getChar(@Nullable NamedTextColor namedTextColor) {
        if (namedTextColor == null) {
            return 'r';
        }
        return chatColorMap.getOrDefault(namedTextColor, ChatColor.WHITE).getChar();
    }

    public static int getIndex(@Nullable NamedTextColor namedTextColor) {
        return chatColorMap.getOrDefault(namedTextColor == null ? NamedTextColor.WHITE : namedTextColor, ChatColor.WHITE).ordinal();
    }

    static {
        ChatColor[] chatColorArrValues = ChatColor.values();
        chatColorMap = new HashMap(chatColorArrValues.length);
        for (ChatColor chatColor : chatColorArrValues) {
            if (chatColor.isColor()) {
                chatColorMap.put((NamedTextColor) ((LegacyFormat) Objects.requireNonNull(LegacyComponentSerializer.parseChar(chatColor.getChar()))).color(), chatColor);
            }
        }
    }
}
