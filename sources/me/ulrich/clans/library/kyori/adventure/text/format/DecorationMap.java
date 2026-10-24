package me.ulrich.clans.library.kyori.adventure.text.format;

import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import java.util.Spliterators;
import java.util.stream.Stream;
import me.ulrich.clans.library.kyori.examination.Examinable;
import me.ulrich.clans.library.kyori.examination.ExaminableProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Unmodifiable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/format/DecorationMap.class */
@Unmodifiable
final class DecorationMap extends AbstractMap<TextDecoration, TextDecoration.State> implements Examinable {
    static final TextDecoration[] DECORATIONS = TextDecoration.values();
    private static final TextDecoration.State[] STATES = TextDecoration.State.values();
    private static final int MAP_SIZE = DECORATIONS.length;
    private static final TextDecoration.State[] EMPTY_STATE_ARRAY = new TextDecoration.State[0];
    static final DecorationMap EMPTY = new DecorationMap(0);
    private static final KeySet KEY_SET = new KeySet();
    private final int bitSet;
    private volatile EntrySet entrySet = null;
    private volatile Values values = null;

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/format/DecorationMap$EntrySet.class */
    final class EntrySet extends AbstractSet<Map.Entry<TextDecoration, TextDecoration.State>> {
        EntrySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        @NotNull
        public Iterator<Map.Entry<TextDecoration, TextDecoration.State>> iterator() {
            return new Iterator<Map.Entry<TextDecoration, TextDecoration.State>>() { // from class: me.ulrich.clans.library.kyori.adventure.text.format.DecorationMap.EntrySet.1
                private final Iterator<TextDecoration> decorations = DecorationMap.KEY_SET.iterator();
                private final Iterator<TextDecoration.State> states;

                {
                    this.states = DecorationMap.this.values().iterator();
                }

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.decorations.hasNext() && this.states.hasNext();
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.Iterator
                public Map.Entry<TextDecoration, TextDecoration.State> next() {
                    if (hasNext()) {
                        return new AbstractMap.SimpleImmutableEntry(this.decorations.next(), this.states.next());
                    }
                    throw new NoSuchElementException();
                }
            };
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return DecorationMap.MAP_SIZE;
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/format/DecorationMap$KeySet.class */
    static final class KeySet extends AbstractSet<TextDecoration> {
        KeySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return obj instanceof TextDecoration;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return Arrays.copyOf(DecorationMap.DECORATIONS, DecorationMap.MAP_SIZE, Object[].class);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            if (tArr.length < DecorationMap.MAP_SIZE) {
                return (T[]) Arrays.copyOf(DecorationMap.DECORATIONS, DecorationMap.MAP_SIZE, tArr.getClass());
            }
            System.arraycopy(DecorationMap.DECORATIONS, 0, tArr, 0, DecorationMap.MAP_SIZE);
            if (tArr.length > DecorationMap.MAP_SIZE) {
                tArr[DecorationMap.MAP_SIZE] = null;
            }
            return tArr;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        @NotNull
        public Iterator<TextDecoration> iterator() {
            return Spliterators.iterator(Arrays.spliterator(DecorationMap.DECORATIONS));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return DecorationMap.MAP_SIZE;
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/format/DecorationMap$Values.class */
    final class Values extends AbstractCollection<TextDecoration.State> {
        Values() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        @NotNull
        public Iterator<TextDecoration.State> iterator() {
            return Spliterators.iterator(Arrays.spliterator((TextDecoration.State[]) toArray(DecorationMap.EMPTY_STATE_ARRAY)));
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public Object[] toArray() {
            Object[] objArr = new Object[DecorationMap.MAP_SIZE];
            for (int i = 0; i < DecorationMap.MAP_SIZE; i++) {
                objArr[i] = DecorationMap.this.get((Object) DecorationMap.DECORATIONS[i]);
            }
            return objArr;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            if (tArr.length < DecorationMap.MAP_SIZE) {
                return (T[]) Arrays.copyOf(toArray(), DecorationMap.MAP_SIZE, tArr.getClass());
            }
            System.arraycopy(toArray(), 0, tArr, 0, DecorationMap.MAP_SIZE);
            if (tArr.length > DecorationMap.MAP_SIZE) {
                tArr[DecorationMap.MAP_SIZE] = null;
            }
            return tArr;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return (obj instanceof TextDecoration.State) && super.contains(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return DecorationMap.MAP_SIZE;
        }
    }

    static DecorationMap fromMap(Map<TextDecoration, TextDecoration.State> map) {
        if (map instanceof DecorationMap) {
            return (DecorationMap) map;
        }
        int iOrdinal = 0;
        for (TextDecoration textDecoration : DECORATIONS) {
            iOrdinal |= map.getOrDefault(textDecoration, TextDecoration.State.NOT_SET).ordinal() * offset(textDecoration);
        }
        return withBitSet(iOrdinal);
    }

    static DecorationMap merge(Map<TextDecoration, TextDecoration.State> map, Map<TextDecoration, TextDecoration.State> map2) {
        int iOrdinal = 0;
        for (TextDecoration textDecoration : DECORATIONS) {
            iOrdinal |= map.getOrDefault(textDecoration, map2.getOrDefault(textDecoration, TextDecoration.State.NOT_SET)).ordinal() * offset(textDecoration);
        }
        return withBitSet(iOrdinal);
    }

    private static DecorationMap withBitSet(int i) {
        return i == 0 ? EMPTY : new DecorationMap(i);
    }

    private static int offset(TextDecoration textDecoration) {
        return 1 << (textDecoration.ordinal() * 2);
    }

    private DecorationMap(int i) {
        this.bitSet = i;
    }

    @NotNull
    public DecorationMap with(@NotNull TextDecoration textDecoration, TextDecoration.State state) {
        Objects.requireNonNull(state, "state");
        Objects.requireNonNull(textDecoration, "decoration");
        int iOffset = offset(textDecoration);
        return withBitSet((this.bitSet & ((3 * iOffset) ^ (-1))) | (state.ordinal() * iOffset));
    }

    @Override // me.ulrich.clans.library.kyori.examination.Examinable
    @NotNull
    public Stream<? extends ExaminableProperty> examinableProperties() {
        return Arrays.stream(DECORATIONS).map(textDecoration -> {
            return ExaminableProperty.of(textDecoration.toString(), get((Object) textDecoration));
        });
    }

    @Override // java.util.AbstractMap, java.util.Map
    public TextDecoration.State get(Object obj) {
        if (obj instanceof TextDecoration) {
            return STATES[(this.bitSet >> (((TextDecoration) obj).ordinal() * 2)) & 3];
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return obj instanceof TextDecoration;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return MAP_SIZE;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    @NotNull
    public Set<Map.Entry<TextDecoration, TextDecoration.State>> entrySet() {
        if (this.entrySet == null) {
            synchronized (this) {
                if (this.entrySet == null) {
                    this.entrySet = new EntrySet();
                }
            }
        }
        return this.entrySet;
    }

    @Override // java.util.AbstractMap, java.util.Map
    @NotNull
    public Set<TextDecoration> keySet() {
        return KEY_SET;
    }

    @Override // java.util.AbstractMap, java.util.Map
    @NotNull
    public Collection<TextDecoration.State> values() {
        if (this.values == null) {
            synchronized (this) {
                if (this.values == null) {
                    this.values = new Values();
                }
            }
        }
        return this.values;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return obj != null && obj.getClass() == DecorationMap.class && this.bitSet == ((DecorationMap) obj).bitSet;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int hashCode() {
        return this.bitSet;
    }
}
