package me.ulrich.clans.library.kyori.adventure.nbt;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import me.ulrich.clans.library.kyori.adventure.nbt.BinaryTag;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/nbt/ListTagBuilder.class */
final class ListTagBuilder<T extends BinaryTag> implements ListBinaryTag.Builder<T> {

    @Nullable
    private List<BinaryTag> tags;
    private final boolean permitsHeterogeneity;
    private BinaryTagType<? extends BinaryTag> elementType;

    ListTagBuilder(boolean z) {
        this(z, BinaryTagTypes.END);
    }

    ListTagBuilder(boolean z, BinaryTagType<? extends BinaryTag> binaryTagType) {
        this.permitsHeterogeneity = z;
        this.elementType = binaryTagType;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.nbt.ListTagSetter
    public ListBinaryTag.Builder<T> add(BinaryTag binaryTag) {
        this.elementType = ListBinaryTagImpl.validateTagType(binaryTag, this.elementType, this.permitsHeterogeneity);
        if (this.tags == null) {
            this.tags = new ArrayList();
        }
        this.tags.add(binaryTag);
        return this;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.nbt.ListTagSetter
    public ListBinaryTag.Builder<T> add(Iterable<? extends T> iterable) {
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            add((BinaryTag) it.next());
        }
        return this;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.nbt.ListBinaryTag.Builder
    @NotNull
    public ListBinaryTag build() {
        return this.tags == null ? ListBinaryTag.empty() : new ListBinaryTagImpl(this.elementType, this.permitsHeterogeneity, new ArrayList(this.tags));
    }
}
