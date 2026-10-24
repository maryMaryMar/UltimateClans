package me.ulrich.clans.library.kyori.adventure.text.object;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import me.ulrich.clans.library.kyori.adventure.internal.Internals;
import me.ulrich.clans.library.kyori.adventure.key.Key;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/object/PlayerHeadObjectContentsImpl.class */
final class PlayerHeadObjectContentsImpl implements PlayerHeadObjectContents {

    @Nullable
    private final String name;

    @Nullable
    private final UUID id;
    private final List<PlayerHeadObjectContents.ProfileProperty> properties;
    private final boolean hat;

    @Nullable
    private final Key texture;

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/object/PlayerHeadObjectContentsImpl$BuilderImpl.class */
    static final class BuilderImpl implements PlayerHeadObjectContents.Builder {

        @Nullable
        private String name;

        @Nullable
        private UUID id;
        private final List<PlayerHeadObjectContents.ProfileProperty> properties;
        private boolean hat;

        @Nullable
        private Key texture;

        BuilderImpl() {
            this.properties = new ArrayList();
            this.hat = true;
        }

        BuilderImpl(@NotNull PlayerHeadObjectContentsImpl playerHeadObjectContentsImpl) {
            this.properties = new ArrayList();
            this.hat = true;
            this.name = playerHeadObjectContentsImpl.name;
            this.id = playerHeadObjectContentsImpl.id;
            this.properties.addAll(playerHeadObjectContentsImpl.properties);
            this.hat = playerHeadObjectContentsImpl.hat;
            this.texture = playerHeadObjectContentsImpl.texture;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.object.PlayerHeadObjectContents.Builder
        public PlayerHeadObjectContents.Builder name(@Nullable String str) {
            this.name = str;
            return this;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.object.PlayerHeadObjectContents.Builder
        public PlayerHeadObjectContents.Builder id(@Nullable UUID uuid) {
            this.id = uuid;
            return this;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.object.PlayerHeadObjectContents.Builder
        public PlayerHeadObjectContents.Builder profileProperty(PlayerHeadObjectContents.ProfileProperty profileProperty) {
            this.properties.add((PlayerHeadObjectContents.ProfileProperty) Objects.requireNonNull(profileProperty, "property"));
            return this;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.object.PlayerHeadObjectContents.Builder
        public PlayerHeadObjectContents.Builder profileProperties(@NotNull Collection<PlayerHeadObjectContents.ProfileProperty> collection) {
            Iterator it = ((Collection) Objects.requireNonNull(collection, "properties")).iterator();
            while (it.hasNext()) {
                profileProperty((PlayerHeadObjectContents.ProfileProperty) it.next());
            }
            return this;
        }

        private void clearProfile() {
            this.name = null;
            this.id = null;
            this.properties.clear();
            this.texture = null;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.object.PlayerHeadObjectContents.Builder
        public PlayerHeadObjectContents.Builder skin(PlayerHeadObjectContents.SkinSource skinSource) {
            clearProfile();
            ((PlayerHeadObjectContents.SkinSource) Objects.requireNonNull(skinSource, "skinSource")).applySkinToPlayerHeadContents(this);
            return this;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.object.PlayerHeadObjectContents.Builder
        public PlayerHeadObjectContents.Builder hat(boolean z) {
            this.hat = z;
            return this;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.object.PlayerHeadObjectContents.Builder
        public PlayerHeadObjectContents.Builder texture(@Nullable Key key) {
            this.texture = key;
            return this;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.object.PlayerHeadObjectContents.Builder
        @NotNull
        public PlayerHeadObjectContents build() {
            return new PlayerHeadObjectContentsImpl(this.name, this.id, this.properties, this.hat, this.texture);
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/object/PlayerHeadObjectContentsImpl$ProfilePropertyImpl.class */
    static final class ProfilePropertyImpl implements PlayerHeadObjectContents.ProfileProperty {
        private final String name;
        private final String value;

        @Nullable
        private final String signature;

        ProfilePropertyImpl(@NotNull String str, @NotNull String str2, @Nullable String str3) {
            this.name = str;
            this.value = str2;
            this.signature = str3;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.object.PlayerHeadObjectContents.ProfileProperty
        @NotNull
        public String name() {
            return this.name;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.object.PlayerHeadObjectContents.ProfileProperty
        @NotNull
        public String value() {
            return this.value;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.object.PlayerHeadObjectContents.ProfileProperty
        @Nullable
        public String signature() {
            return this.signature;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ProfilePropertyImpl)) {
                return false;
            }
            ProfilePropertyImpl profilePropertyImpl = (ProfilePropertyImpl) obj;
            return Objects.equals(this.name, profilePropertyImpl.name) && Objects.equals(this.value, profilePropertyImpl.value) && Objects.equals(this.signature, profilePropertyImpl.signature);
        }

        public int hashCode() {
            return Objects.hash(this.name, this.value, this.signature);
        }

        public String toString() {
            return Internals.toString(this);
        }
    }

    PlayerHeadObjectContentsImpl(@Nullable String str, @Nullable UUID uuid, @NotNull List<PlayerHeadObjectContents.ProfileProperty> list, boolean z, @Nullable Key key) {
        this.name = str;
        this.id = uuid;
        if (list.isEmpty()) {
            this.properties = Collections.emptyList();
        } else {
            this.properties = Collections.unmodifiableList(new ArrayList((Collection) Objects.requireNonNull(list, "properties")));
        }
        this.hat = z;
        this.texture = key;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.object.PlayerHeadObjectContents
    @Nullable
    public String name() {
        return this.name;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.object.PlayerHeadObjectContents
    @Nullable
    public UUID id() {
        return this.id;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.object.PlayerHeadObjectContents
    @NotNull
    public List<PlayerHeadObjectContents.ProfileProperty> profileProperties() {
        return this.properties;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.object.PlayerHeadObjectContents
    public boolean hat() {
        return this.hat;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.object.PlayerHeadObjectContents
    @Nullable
    public Key texture() {
        return this.texture;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.object.PlayerHeadObjectContents
    @NotNull
    public PlayerHeadObjectContents.Builder toBuilder() {
        return new BuilderImpl(this);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlayerHeadObjectContents)) {
            return false;
        }
        PlayerHeadObjectContentsImpl playerHeadObjectContentsImpl = (PlayerHeadObjectContentsImpl) obj;
        return Objects.equals(this.name, playerHeadObjectContentsImpl.name) && Objects.equals(this.id, playerHeadObjectContentsImpl.id) && Objects.equals(this.properties, playerHeadObjectContentsImpl.properties) && this.hat == playerHeadObjectContentsImpl.hat && Objects.equals(this.texture, playerHeadObjectContentsImpl.texture);
    }

    public int hashCode() {
        return Objects.hash(this.name, this.id, this.properties, Boolean.valueOf(this.hat), this.texture);
    }

    public String toString() {
        return Internals.toString(this);
    }
}
