package me.ulrich.clans.api;

import java.util.List;
import me.ulrich.clans.Clans;
import me.ulrich.clans.interfaces.ColorAPI;
import me.ulrich.clans.library.kyori.adventure.text.Component;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/api/ColorAPIManager.class */
public class ColorAPIManager implements ColorAPI {
    private final Clans plugin;

    public ColorAPIManager(Clans clans) {
        this.plugin = clans;
    }

    public Clans getPlugin() {
        return this.plugin;
    }

    @Override // me.ulrich.clans.interfaces.ColorAPI
    public String removeDecoration(String str, List<String> list) {
        return this.plugin.getColorManager().v8qP8fE86HMhvNuYPFjqY(str, list);
    }

    @Override // me.ulrich.clans.interfaces.ColorAPI
    public Component addMiniColor(String str) {
        return this.plugin.getColorManager().ZwrsrwOCXRUscW6Q(str);
    }

    @Override // me.ulrich.clans.interfaces.ColorAPI
    public Component addMiniColor(String str, boolean z) {
        return this.plugin.getColorManager().v8qP8fE86HMhvNuYPFjqY(str, z);
    }

    @Override // me.ulrich.clans.interfaces.ColorAPI
    public String toLegacyColor(String str) {
        return this.plugin.getColorManager().iZTqZaRK5UGoe0Z(str);
    }

    @Override // me.ulrich.clans.interfaces.ColorAPI
    public String toCodeColor(String str) {
        return this.plugin.getColorManager().xtOheRiObl4QeAl(str);
    }

    @Override // me.ulrich.clans.interfaces.ColorAPI
    public String removeColor(String str) {
        return this.plugin.getColorManager().zJnaNCVQSgEShq(str);
    }

    @Override // me.ulrich.clans.interfaces.ColorAPI
    public String parseLegacytoCode(String str) {
        return this.plugin.getColorManager().CDW4Fj1iwdIXEOqWjiJSR(str);
    }

    @Override // me.ulrich.clans.interfaces.ColorAPI
    public String parseCodeToLegacy(String str) {
        return this.plugin.getColorManager().b4i2FbOkaKeg91LiAe6l(str);
    }

    @Override // me.ulrich.clans.interfaces.ColorAPI
    public String addLegacyColor(String str) {
        return this.plugin.getColorManager().v8qP8fE86HMhvNuYPFjqY(str);
    }
}
