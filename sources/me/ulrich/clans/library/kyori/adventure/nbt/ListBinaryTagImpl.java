package me.ulrich.clans.library.kyori.adventure.nbt;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Consumer;
import java.util.stream.Stream;
import me.ulrich.clans.library.kyori.examination.ExaminableProperty;
import org.jetbrains.annotations.Debug;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/nbt/ListBinaryTagImpl.class */
@Debug.Renderer(text = "\"ListBinaryTag[type=\" + this.type.toString() + \"]\"", childrenArray = "this.tags.toArray()", hasChildren = "!this.tags.isEmpty()")
final class ListBinaryTagImpl extends AbstractBinaryTag implements ListBinaryTag {
    static final ListBinaryTag EMPTY = new ListBinaryTagImpl(BinaryTagTypes.END, false, Collections.emptyList());
    private final List<BinaryTag> tags;
    private final boolean permitsHeterogeneity;
    private final BinaryTagType<? extends BinaryTag> elementType;
    private final int hashCode;

    ListBinaryTagImpl(BinaryTagType<? extends BinaryTag> binaryTagType, boolean z, List<BinaryTag> list) {
        this.tags = Collections.unmodifiableList(list);
        this.permitsHeterogeneity = z;
        this.elementType = binaryTagType;
        this.hashCode = list.hashCode();
    }

    @Override // me.ulrich.clans.library.kyori.adventure.nbt.ListBinaryTag
    @NotNull
    public BinaryTagType<? extends BinaryTag> elementType() {
        return this.elementType;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.nbt.ListBinaryTag
    public int size() {
        return this.tags.size();
    }

    @Override // me.ulrich.clans.library.kyori.adventure.nbt.ListBinaryTag
    public boolean isEmpty() {
        return this.tags.isEmpty();
    }

    @Override // me.ulrich.clans.library.kyori.adventure.nbt.ListBinaryTag
    @NotNull
    public BinaryTag get(int i) {
        return this.tags.get(i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // me.ulrich.clans.library.kyori.adventure.nbt.ListBinaryTag
    @NotNull
    public ListBinaryTag set(int i, @NotNull BinaryTag binaryTag, @Nullable Consumer<? super BinaryTag> consumer) {
        return edit(list -> {
            BinaryTag binaryTag2 = (BinaryTag) list.set(i, binaryTag);
            if (consumer != null) {
                consumer.accept(binaryTag2);
            }
        }, validateTagType(binaryTag, this.elementType, this.permitsHeterogeneity));
    }

    @Override // me.ulrich.clans.library.kyori.adventure.nbt.ListBinaryTag
    @NotNull
    public ListBinaryTag remove(int i, @Nullable Consumer<? super BinaryTag> consumer) {
        return edit(list -> {
            BinaryTag binaryTag = (BinaryTag) list.remove(i);
            if (consumer != null) {
                consumer.accept(binaryTag);
            }
        }, null);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // me.ulrich.clans.library.kyori.adventure.nbt.ListTagSetter
    @NotNull
    public ListBinaryTag add(BinaryTag binaryTag) {
        return edit(list -> {
            list.add(binaryTag);
        }, validateTagType(binaryTag, this.elementType, this.permitsHeterogeneity));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // me.ulrich.clans.library.kyori.adventure.nbt.ListTagSetter
    @NotNull
    public ListBinaryTag add(Iterable<? extends BinaryTag> iterable) {
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return this;
        }
        return edit(list -> {
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                list.add((BinaryTag) it.next());
            }
        }, validateTagType(iterable, this.permitsHeterogeneity));
    }

    static void noAddEnd(BinaryTag binaryTag) {
        if (binaryTag.type() == BinaryTagTypes.END) {
            throw new IllegalArgumentException(String.format("Cannot add a %s to a %s", BinaryTagTypes.END, BinaryTagTypes.LIST));
        }
    }

    static BinaryTagType<?> validateTagType(Iterable<? extends BinaryTag> iterable, boolean z) {
        BinaryTagType<? extends BinaryTag> binaryTagTypeType = null;
        for (BinaryTag binaryTag : iterable) {
            if (binaryTagTypeType == null) {
                noAddEnd(binaryTag);
                binaryTagTypeType = binaryTag.type();
            } else {
                validateTagType(binaryTag, binaryTagTypeType, z);
                if (binaryTagTypeType != binaryTag.type()) {
                    binaryTagTypeType = BinaryTagTypes.LIST_WILDCARD;
                }
            }
        }
        return binaryTagTypeType;
    }

    static BinaryTagType<?> validateTagType(BinaryTag binaryTag, BinaryTagType<? extends BinaryTag> binaryTagType, boolean z) {
        noAddEnd(binaryTag);
        if (binaryTagType == BinaryTagTypes.END) {
            return binaryTag.type();
        }
        if (binaryTag.type() == binaryTagType || z) {
            return binaryTag.type() != binaryTagType ? BinaryTagTypes.LIST_WILDCARD : binaryTagType;
        }
        throw new IllegalArgumentException(String.format("Trying to add tag of type %s to list of %s", binaryTag.type(), binaryTagType));
    }

    private ListBinaryTag edit(Consumer<List<BinaryTag>> consumer, @Nullable BinaryTagType<? extends BinaryTag> binaryTagType) {
        ArrayList arrayList = new ArrayList(this.tags);
        consumer.accept(arrayList);
        BinaryTagType<? extends BinaryTag> binaryTagType2 = this.elementType;
        if (binaryTagType != null) {
            binaryTagType2 = binaryTagType;
        }
        return new ListBinaryTagImpl(binaryTagType2, this.permitsHeterogeneity, new ArrayList(arrayList));
    }

    @Override // me.ulrich.clans.library.kyori.adventure.nbt.ListBinaryTag
    @NotNull
    public Stream<BinaryTag> stream() {
        return this.tags.stream();
    }

    @Override // me.ulrich.clans.library.kyori.adventure.nbt.ListBinaryTag
    @NotNull
    public ListBinaryTag unwrapHeterogeneity() {
        if (this.permitsHeterogeneity) {
            return this;
        }
        if (this.elementType != BinaryTagTypes.COMPOUND) {
            return new ListBinaryTagImpl(this.elementType, true, this.tags);
        }
        ArrayList arrayList = null;
        ListIterator<BinaryTag> listIterator = this.tags.listIterator();
        while (listIterator.hasNext()) {
            BinaryTag next = listIterator.next();
            BinaryTag binaryTagUnbox = ListBinaryTag0.unbox((CompoundBinaryTag) next);
            if (binaryTagUnbox != next && arrayList == null) {
                arrayList = new ArrayList(this.tags.size());
                int iNextIndex = listIterator.nextIndex() - 1;
                for (int i = 0; i < iNextIndex; i++) {
                    arrayList.add(this.tags.get(i));
                }
            }
            if (arrayList != null) {
                arrayList.add(binaryTagUnbox);
            }
        }
        return new ListBinaryTagImpl(arrayList == null ? BinaryTagTypes.COMPOUND : BinaryTagTypes.LIST_WILDCARD, true, arrayList == null ? this.tags : arrayList);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.nbt.ListBinaryTag
    @NotNull
    public ListBinaryTag wrapHeterogeneity() {
        if (this.elementType != BinaryTagTypes.LIST_WILDCARD) {
            return this;
        }
        ArrayList arrayList = new ArrayList(this.tags.size());
        Iterator<BinaryTag> it = this.tags.iterator();
        while (it.hasNext()) {
            arrayList.add(ListBinaryTag0.box(it.next()));
        }
        return new ListBinaryTagImpl(BinaryTagTypes.COMPOUND, false, arrayList);
    }

    @Override // java.lang.Iterable
    @NotNull
    public Iterator<BinaryTag> iterator() {
        final Iterator<BinaryTag> it = this.tags.iterator();
        return new Iterator<BinaryTag>() { // from class: me.ulrich.clans.library.kyori.adventure.nbt.ListBinaryTagImpl.1
            @Override // java.util.Iterator
            public boolean hasNext() {
                return it.hasNext();
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.Iterator
            public BinaryTag next() {
                return (BinaryTag) it.next();
            }

            @Override // java.util.Iterator
            public void forEachRemaining(Consumer<? super BinaryTag> consumer) {
                it.forEachRemaining(consumer);
            }
        };
    }

    @Override // java.lang.Iterable
    public void forEach(Consumer<? super BinaryTag> consumer) {
        this.tags.forEach(consumer);
    }

    @Override // java.lang.Iterable
    public Spliterator<BinaryTag> spliterator() {
        return Spliterators.spliterator(this.tags, 1040);
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof ListBinaryTagImpl) && this.tags.equals(((ListBinaryTagImpl) obj).tags));
    }

    public int hashCode() {
        return this.hashCode;
    }

    @Override // me.ulrich.clans.library.kyori.examination.Examinable
    @NotNull
    public Stream<? extends ExaminableProperty> examinableProperties() {
        return Stream.of((Object[]) new ExaminableProperty[]{ExaminableProperty.of("tags", this.tags), ExaminableProperty.of("type", this.elementType)});
    }

    @Override // me.ulrich.clans.library.kyori.adventure.nbt.ListTagSetter
    @NotNull
    public /* bridge */ /* synthetic */ ListBinaryTag add(Iterable iterable) {
        return add((Iterable<? extends BinaryTag>) iterable);
    }
}
