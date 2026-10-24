package me.ulrich.clans.interfaces;

import java.util.List;
import me.ulrich.clans.library.kyori.adventure.text.Component;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/interfaces/ColorAPI.class */
public interface ColorAPI {
    String removeDecoration(String str, List<String> list);

    Component addMiniColor(String str);

    Component addMiniColor(String str, boolean z);

    String toLegacyColor(String str);

    String toCodeColor(String str);

    String removeColor(String str);

    String parseLegacytoCode(String str);

    String parseCodeToLegacy(String str);

    String addLegacyColor(String str);
}
