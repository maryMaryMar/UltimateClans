package me.ulrich.clans.library.kyori.adventure.resource;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;
import java.util.Locale;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.stream.Stream;
import me.ulrich.clans.library.kyori.adventure.internal.Internals;
import me.ulrich.clans.library.kyori.examination.ExaminableProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/resource/ResourcePackInfoImpl.class */
final class ResourcePackInfoImpl implements ResourcePackInfo {
    private final UUID id;
    private final URI uri;
    private final String hash;

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/resource/ResourcePackInfoImpl$BuilderImpl.class */
    static final class BuilderImpl implements ResourcePackInfo.Builder {
        private UUID id;
        private URI uri;
        private String hash;

        BuilderImpl() {
        }

        @Override // me.ulrich.clans.library.kyori.adventure.resource.ResourcePackInfo.Builder
        @NotNull
        public ResourcePackInfo.Builder id(@NotNull UUID uuid) {
            this.id = (UUID) Objects.requireNonNull(uuid, "id");
            return this;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.resource.ResourcePackInfo.Builder
        @NotNull
        public ResourcePackInfo.Builder uri(@NotNull URI uri) {
            this.uri = (URI) Objects.requireNonNull(uri, "uri");
            if (this.id == null) {
                this.id = UUID.nameUUIDFromBytes(uri.toString().getBytes(StandardCharsets.UTF_8));
            }
            return this;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.resource.ResourcePackInfo.Builder
        @NotNull
        public ResourcePackInfo.Builder hash(@NotNull String str) {
            this.hash = (String) Objects.requireNonNull(str, "hash");
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // me.ulrich.clans.library.kyori.adventure.resource.ResourcePackInfo.Builder, me.ulrich.clans.library.kyori.adventure.builder.AbstractBuilder, me.ulrich.clans.library.kyori.adventure.util.Buildable.Builder
        @NotNull
        /* JADX INFO: renamed from: build */
        public ResourcePackInfo build2() {
            return new ResourcePackInfoImpl(this.id, this.uri, this.hash);
        }

        @Override // me.ulrich.clans.library.kyori.adventure.resource.ResourcePackInfo.Builder
        @NotNull
        public CompletableFuture<ResourcePackInfo> computeHashAndBuild(@NotNull Executor executor) {
            return ResourcePackInfoImpl.computeHash((URI) Objects.requireNonNull(this.uri, "uri"), executor).thenApply(str -> {
                hash(str);
                return build2();
            });
        }
    }

    ResourcePackInfoImpl(@NotNull UUID uuid, @NotNull URI uri, @NotNull String str) {
        this.id = (UUID) Objects.requireNonNull(uuid, "id");
        this.uri = (URI) Objects.requireNonNull(uri, "uri");
        this.hash = (String) Objects.requireNonNull(str, "hash");
    }

    @Override // me.ulrich.clans.library.kyori.adventure.resource.ResourcePackInfo
    @NotNull
    public UUID id() {
        return this.id;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.resource.ResourcePackInfo
    @NotNull
    public URI uri() {
        return this.uri;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.resource.ResourcePackInfo
    @NotNull
    public String hash() {
        return this.hash;
    }

    @Override // me.ulrich.clans.library.kyori.examination.Examinable
    @NotNull
    public Stream<? extends ExaminableProperty> examinableProperties() {
        return Stream.of((Object[]) new ExaminableProperty[]{ExaminableProperty.of("id", this.id), ExaminableProperty.of("uri", this.uri), ExaminableProperty.of("hash", this.hash)});
    }

    public String toString() {
        return Internals.toString(this);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ResourcePackInfoImpl)) {
            return false;
        }
        ResourcePackInfoImpl resourcePackInfoImpl = (ResourcePackInfoImpl) obj;
        return this.id.equals(resourcePackInfoImpl.id) && this.uri.equals(resourcePackInfoImpl.uri) && this.hash.equals(resourcePackInfoImpl.hash);
    }

    public int hashCode() {
        return (31 * ((31 * this.id.hashCode()) + this.uri.hashCode())) + this.hash.hashCode();
    }

    static CompletableFuture<String> computeHash(URI uri, Executor executor) {
        CompletableFuture<String> completableFuture = new CompletableFuture<>();
        executor.execute(() -> {
            try {
                URLConnection uRLConnectionOpenConnection = uri.toURL().openConnection();
                uRLConnectionOpenConnection.addRequestProperty("User-Agent", "adventure/" + ResourcePackInfoImpl.class.getPackage().getSpecificationVersion() + " (pack-fetcher)");
                InputStream inputStream = uRLConnectionOpenConnection.getInputStream();
                try {
                    MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int i = inputStream.read(bArr);
                        if (i == -1) {
                            break;
                        } else {
                            messageDigest.update(bArr, 0, i);
                        }
                        completableFuture.completeExceptionally(e);
                    }
                    completableFuture.complete(bytesToString(messageDigest.digest()));
                    if (inputStream != null) {
                        inputStream.close();
                    }
                } catch (Throwable th) {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            } catch (IOException | NoSuchAlgorithmException e) {
                completableFuture.completeExceptionally(e);
            }
        });
        return completableFuture;
    }

    static String bytesToString(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        Formatter formatter = new Formatter(sb, Locale.ROOT);
        for (byte b : bArr) {
            formatter.format("%02x", Integer.valueOf(b & 255));
        }
        return sb.toString();
    }
}
