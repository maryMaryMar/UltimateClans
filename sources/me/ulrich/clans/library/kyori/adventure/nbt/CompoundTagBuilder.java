package me.ulrich.clans.library.kyori.adventure.nbt;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/nbt/CompoundTagBuilder.class */
final class CompoundTagBuilder implements CompoundBinaryTag.Builder {

    @Nullable
    private Map<String, BinaryTag> tags;

    CompoundTagBuilder() {
    }

    private Map<String, BinaryTag> tags() {
        if (this.tags == null) {
            this.tags = new HashMap();
        }
        return this.tags;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // me.ulrich.clans.library.kyori.adventure.nbt.CompoundTagSetter
    public CompoundBinaryTag.Builder put(@NotNull String str, @NotNull BinaryTag binaryTag) {
        tags().put(str, binaryTag);
        return this;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // me.ulrich.clans.library.kyori.adventure.nbt.CompoundTagSetter
    public CompoundBinaryTag.Builder put(@NotNull CompoundBinaryTag compoundBinaryTag) {
        Map<String, BinaryTag> mapTags = tags();
        for (String str : compoundBinaryTag.keySet()) {
            mapTags.put(str, compoundBinaryTag.get(str));
        }
        return this;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // me.ulrich.clans.library.kyori.adventure.nbt.CompoundTagSetter
    public CompoundBinaryTag.Builder put(@NotNull Map<String, ? extends BinaryTag> map) {
        tags().putAll(map);
        return this;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // me.ulrich.clans.library.kyori.adventure.nbt.CompoundTagSetter
    public CompoundBinaryTag.Builder remove(@NotNull String str, @Nullable Consumer<? super BinaryTag> consumer) {
        if (this.tags != null) {
            BinaryTag binaryTagRemove = this.tags.remove(str);
            if (consumer != null) {
                consumer.accept(binaryTagRemove);
            }
        }
        return this;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.nbt.CompoundBinaryTag.Builder
    @NotNull
    public CompoundBinaryTag build() {
        return this.tags == null ? CompoundBinaryTag.empty() : new CompoundBinaryTagImpl(new HashMap(this.tags));
    }

    @Override // me.ulrich.clans.library.kyori.adventure.nbt.CompoundTagSetter
    public /* bridge */ /* synthetic */ CompoundBinaryTag.Builder remove(@NotNull String str, @Nullable Consumer consumer) {
        return remove(str, (Consumer<? super BinaryTag>) consumer);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.nbt.CompoundTagSetter
    public /* bridge */ /* synthetic */ CompoundBinaryTag.Builder put(@NotNull Map map) {
        return put((Map<String, ? extends BinaryTag>) map);
    }
}
