package me.ulrich.clans.library.kyori.adventure.title;

import me.ulrich.clans.library.kyori.adventure.text.Component;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/title/TitlePart.class */
@ApiStatus.NonExtendable
public interface TitlePart<T> {
    public static final TitlePart<Component> TITLE = new TitlePart<Component>() { // from class: me.ulrich.clans.library.kyori.adventure.title.TitlePart.1
        public String toString() {
            return "TitlePart.TITLE";
        }
    };
    public static final TitlePart<Component> SUBTITLE = new TitlePart<Component>() { // from class: me.ulrich.clans.library.kyori.adventure.title.TitlePart.2
        public String toString() {
            return "TitlePart.SUBTITLE";
        }
    };
    public static final TitlePart<Title.Times> TIMES = new TitlePart<Title.Times>() { // from class: me.ulrich.clans.library.kyori.adventure.title.TitlePart.3
        public String toString() {
            return "TitlePart.TIMES";
        }
    };
}
