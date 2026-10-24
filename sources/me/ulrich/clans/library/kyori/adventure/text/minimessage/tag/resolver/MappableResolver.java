package me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.resolver;

import java.util.Map;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.Tag;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/minimessage/tag/resolver/MappableResolver.class */
interface MappableResolver {
    boolean contributeToMap(@NotNull Map<String, Tag> map);
}
