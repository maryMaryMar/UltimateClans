package me.ulrich.clans.library.kyori.adventure.text.object;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Stream;
import me.ulrich.clans.library.kyori.adventure.key.Key;
import me.ulrich.clans.library.kyori.adventure.util.PlatformAPI;
import me.ulrich.clans.library.kyori.examination.Examinable;
import me.ulrich.clans.library.kyori.examination.ExaminableProperty;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/object/PlayerHeadObjectContents.class */
@ApiStatus.NonExtendable
public interface PlayerHeadObjectContents extends ObjectContents {
    public static final boolean DEFAULT_HAT = true;

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/object/PlayerHeadObjectContents$Builder.class */
    public interface Builder {
        @Contract("_ -> this")
        @NotNull
        Builder name(@Nullable String str);

        @Contract("_ -> this")
        @NotNull
        Builder id(@Nullable UUID uuid);

        @Contract("_ -> this")
        @NotNull
        Builder profileProperty(@NotNull ProfileProperty profileProperty);

        @Contract("_ -> this")
        @NotNull
        Builder profileProperties(@NotNull Collection<ProfileProperty> collection);

        @Contract("_ -> this")
        @NotNull
        Builder skin(@NotNull SkinSource skinSource);

        @Contract("_ -> this")
        @NotNull
        Builder hat(boolean z);

        @Contract("_ -> this")
        @NotNull
        Builder texture(@Nullable Key key);

        @Contract(value = "-> new", pure = true)
        @NotNull
        PlayerHeadObjectContents build();
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/object/PlayerHeadObjectContents$ProfileProperty.class */
    public interface ProfileProperty extends Examinable {
        @NotNull
        String name();

        @NotNull
        String value();

        @Nullable
        String signature();

        @Override // me.ulrich.clans.library.kyori.examination.Examinable
        @NotNull
        default Stream<? extends ExaminableProperty> examinableProperties() {
            return Stream.of((Object[]) new ExaminableProperty[]{ExaminableProperty.of("name", name()), ExaminableProperty.of("value", value()), ExaminableProperty.of("signature", signature())});
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/object/PlayerHeadObjectContents$SkinSource.class */
    public interface SkinSource {
        @ApiStatus.Internal
        @PlatformAPI
        void applySkinToPlayerHeadContents(@NotNull Builder builder);
    }

    @Nullable
    String name();

    @Nullable
    UUID id();

    @NotNull
    List<ProfileProperty> profileProperties();

    boolean hat();

    @Nullable
    Key texture();

    @Contract(value = "-> new", pure = true)
    @NotNull
    Builder toBuilder();

    @Contract(value = "_, _ -> new", pure = true)
    static ProfileProperty property(@NotNull String str, @NotNull String str2) {
        return new PlayerHeadObjectContentsImpl.ProfilePropertyImpl((String) Objects.requireNonNull(str, "name"), (String) Objects.requireNonNull(str2, "value"), null);
    }

    @Contract(value = "_, _, _ -> new", pure = true)
    static ProfileProperty property(@NotNull String str, @NotNull String str2, @Nullable String str3) {
        return new PlayerHeadObjectContentsImpl.ProfilePropertyImpl((String) Objects.requireNonNull(str, "name"), (String) Objects.requireNonNull(str2, "value"), str3);
    }

    @Override // me.ulrich.clans.library.kyori.examination.Examinable
    @NotNull
    default Stream<? extends ExaminableProperty> examinableProperties() {
        return Stream.of((Object[]) new ExaminableProperty[]{ExaminableProperty.of("name", name()), ExaminableProperty.of("id", id()), ExaminableProperty.of("profileProperties", profileProperties()), ExaminableProperty.of("hat", hat()), ExaminableProperty.of("texture", texture())});
    }
}
