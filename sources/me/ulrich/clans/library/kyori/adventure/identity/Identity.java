package me.ulrich.clans.library.kyori.adventure.identity;

import java.util.Locale;
import java.util.UUID;
import java.util.stream.Stream;
import me.ulrich.clans.library.kyori.adventure.Adventure;
import me.ulrich.clans.library.kyori.adventure.key.Key;
import me.ulrich.clans.library.kyori.adventure.pointer.Pointer;
import me.ulrich.clans.library.kyori.adventure.text.Component;
import me.ulrich.clans.library.kyori.adventure.text.serializer.commons.ComponentTreeConstants;
import me.ulrich.clans.library.kyori.examination.Examinable;
import me.ulrich.clans.library.kyori.examination.ExaminableProperty;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/identity/Identity.class */
@ApiStatus.NonExtendable
public interface Identity extends Identified, Examinable {
    public static final Pointer<String> NAME = Pointer.pointer(String.class, Key.key(Adventure.NAMESPACE, "name"));
    public static final Pointer<UUID> UUID = Pointer.pointer(UUID.class, Key.key(Adventure.NAMESPACE, ComponentTreeConstants.SHOW_ENTITY_UUID));
    public static final Pointer<Component> DISPLAY_NAME = Pointer.pointer(Component.class, Key.key(Adventure.NAMESPACE, "display_name"));
    public static final Pointer<Locale> LOCALE = Pointer.pointer(Locale.class, Key.key(Adventure.NAMESPACE, "locale"));

    @NotNull
    static Identity nil() {
        return NilIdentity.INSTANCE;
    }

    @NotNull
    static Identity identity(@NotNull UUID uuid) {
        return uuid.equals(NilIdentity.NIL_UUID) ? NilIdentity.INSTANCE : new IdentityImpl(uuid);
    }

    @NotNull
    UUID uuid();

    @Override // me.ulrich.clans.library.kyori.adventure.identity.Identified
    @NotNull
    default Identity identity() {
        return this;
    }

    @Override // me.ulrich.clans.library.kyori.examination.Examinable
    @NotNull
    default Stream<? extends ExaminableProperty> examinableProperties() {
        return Stream.of(ExaminableProperty.of(ComponentTreeConstants.SHOW_ENTITY_UUID, uuid()));
    }
}
