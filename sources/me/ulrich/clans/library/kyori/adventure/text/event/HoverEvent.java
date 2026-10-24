package me.ulrich.clans.library.kyori.adventure.text.event;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;
import me.ulrich.clans.library.kyori.adventure.internal.Internals;
import me.ulrich.clans.library.kyori.adventure.key.Key;
import me.ulrich.clans.library.kyori.adventure.key.Keyed;
import me.ulrich.clans.library.kyori.adventure.nbt.api.BinaryTagHolder;
import me.ulrich.clans.library.kyori.adventure.text.Component;
import me.ulrich.clans.library.kyori.adventure.text.ComponentLike;
import me.ulrich.clans.library.kyori.adventure.text.format.Style;
import me.ulrich.clans.library.kyori.adventure.text.format.StyleBuilderApplicable;
import me.ulrich.clans.library.kyori.adventure.text.renderer.ComponentRenderer;
import me.ulrich.clans.library.kyori.adventure.util.Index;
import me.ulrich.clans.library.kyori.examination.Examinable;
import me.ulrich.clans.library.kyori.examination.ExaminableProperty;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/event/HoverEvent.class */
public final class HoverEvent<V> implements HoverEventSource<V>, StyleBuilderApplicable, Examinable {
    private final Action<V> action;
    private final V value;

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/event/HoverEvent$Action.class */
    public static final class Action<V> {
        public static final Action<Component> SHOW_TEXT = new Action<>("show_text", Component.class, true, new Renderer<Component>() { // from class: me.ulrich.clans.library.kyori.adventure.text.event.HoverEvent.Action.1
            @NotNull
            /* JADX INFO: renamed from: render, reason: avoid collision after fix types in other method */
            public <C> Component render2(@NotNull ComponentRenderer<C> componentRenderer, @NotNull C c, @NotNull Component component) {
                return componentRenderer.render(component, c);
            }

            @Override // me.ulrich.clans.library.kyori.adventure.text.event.HoverEvent.Action.Renderer
            @NotNull
            public /* bridge */ /* synthetic */ Component render(@NotNull ComponentRenderer componentRenderer, @NotNull Object obj, @NotNull Component component) {
                return render2((ComponentRenderer<Object>) componentRenderer, obj, component);
            }
        });
        public static final Action<ShowItem> SHOW_ITEM = new Action<>("show_item", ShowItem.class, true, new Renderer<ShowItem>() { // from class: me.ulrich.clans.library.kyori.adventure.text.event.HoverEvent.Action.2
            @NotNull
            /* JADX INFO: renamed from: render, reason: avoid collision after fix types in other method */
            public <C> ShowItem render2(@NotNull ComponentRenderer<C> componentRenderer, @NotNull C c, @NotNull ShowItem showItem) {
                return showItem;
            }

            @Override // me.ulrich.clans.library.kyori.adventure.text.event.HoverEvent.Action.Renderer
            @NotNull
            public /* bridge */ /* synthetic */ ShowItem render(@NotNull ComponentRenderer componentRenderer, @NotNull Object obj, @NotNull ShowItem showItem) {
                return render2((ComponentRenderer<Object>) componentRenderer, obj, showItem);
            }
        });
        public static final Action<ShowEntity> SHOW_ENTITY = new Action<>("show_entity", ShowEntity.class, true, new Renderer<ShowEntity>() { // from class: me.ulrich.clans.library.kyori.adventure.text.event.HoverEvent.Action.3
            @NotNull
            /* JADX INFO: renamed from: render, reason: avoid collision after fix types in other method */
            public <C> ShowEntity render2(@NotNull ComponentRenderer<C> componentRenderer, @NotNull C c, @NotNull ShowEntity showEntity) {
                return showEntity.name == null ? showEntity : showEntity.name(componentRenderer.render(showEntity.name, c));
            }

            @Override // me.ulrich.clans.library.kyori.adventure.text.event.HoverEvent.Action.Renderer
            @NotNull
            public /* bridge */ /* synthetic */ ShowEntity render(@NotNull ComponentRenderer componentRenderer, @NotNull Object obj, @NotNull ShowEntity showEntity) {
                return render2((ComponentRenderer<Object>) componentRenderer, obj, showEntity);
            }
        });

        @Deprecated
        public static final Action<String> SHOW_ACHIEVEMENT = new Action<>("show_achievement", String.class, true, new Renderer<String>() { // from class: me.ulrich.clans.library.kyori.adventure.text.event.HoverEvent.Action.4
            @NotNull
            /* JADX INFO: renamed from: render, reason: avoid collision after fix types in other method */
            public <C> String render2(@NotNull ComponentRenderer<C> componentRenderer, @NotNull C c, @NotNull String str) {
                return str;
            }

            @Override // me.ulrich.clans.library.kyori.adventure.text.event.HoverEvent.Action.Renderer
            @NotNull
            public /* bridge */ /* synthetic */ String render(@NotNull ComponentRenderer componentRenderer, @NotNull Object obj, @NotNull String str) {
                return render2((ComponentRenderer<Object>) componentRenderer, obj, str);
            }
        });
        public static final Index<String, Action<?>> NAMES = Index.create(action -> {
            return action.name;
        }, SHOW_TEXT, SHOW_ITEM, SHOW_ENTITY, SHOW_ACHIEVEMENT);
        private final String name;
        private final Class<V> type;
        private final boolean readable;
        private final Renderer<V> renderer;

        /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/event/HoverEvent$Action$Renderer.class */
        @FunctionalInterface
        interface Renderer<V> {
            @NotNull
            <C> V render(@NotNull ComponentRenderer<C> componentRenderer, @NotNull C c, @NotNull V v);
        }

        Action(String str, Class<V> cls, boolean z, Renderer<V> renderer) {
            this.name = str;
            this.type = cls;
            this.readable = z;
            this.renderer = renderer;
        }

        @NotNull
        public Class<V> type() {
            return this.type;
        }

        public boolean readable() {
            return this.readable;
        }

        @NotNull
        public String toString() {
            return this.name;
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/event/HoverEvent$ShowEntity.class */
    public static final class ShowEntity implements Examinable {
        private final Key type;
        private final UUID id;
        private final Component name;

        @NotNull
        public static ShowEntity showEntity(@NotNull Key key, @NotNull UUID uuid) {
            return showEntity(key, uuid, (Component) null);
        }

        @ApiStatus.ScheduledForRemoval(inVersion = "5.0.0")
        @Deprecated
        @NotNull
        public static ShowEntity of(@NotNull Key key, @NotNull UUID uuid) {
            return of(key, uuid, (Component) null);
        }

        @NotNull
        public static ShowEntity showEntity(@NotNull Keyed keyed, @NotNull UUID uuid) {
            return showEntity(keyed, uuid, (Component) null);
        }

        @ApiStatus.ScheduledForRemoval(inVersion = "5.0.0")
        @Deprecated
        @NotNull
        public static ShowEntity of(@NotNull Keyed keyed, @NotNull UUID uuid) {
            return of(keyed, uuid, (Component) null);
        }

        @NotNull
        public static ShowEntity showEntity(@NotNull Key key, @NotNull UUID uuid, @Nullable Component component) {
            return new ShowEntity((Key) Objects.requireNonNull(key, "type"), (UUID) Objects.requireNonNull(uuid, "id"), component);
        }

        @ApiStatus.ScheduledForRemoval(inVersion = "5.0.0")
        @Deprecated
        @NotNull
        public static ShowEntity of(@NotNull Key key, @NotNull UUID uuid, @Nullable Component component) {
            return new ShowEntity((Key) Objects.requireNonNull(key, "type"), (UUID) Objects.requireNonNull(uuid, "id"), component);
        }

        @NotNull
        public static ShowEntity showEntity(@NotNull Keyed keyed, @NotNull UUID uuid, @Nullable Component component) {
            return new ShowEntity(((Keyed) Objects.requireNonNull(keyed, "type")).key(), (UUID) Objects.requireNonNull(uuid, "id"), component);
        }

        @ApiStatus.ScheduledForRemoval(inVersion = "5.0.0")
        @Deprecated
        @NotNull
        public static ShowEntity of(@NotNull Keyed keyed, @NotNull UUID uuid, @Nullable Component component) {
            return new ShowEntity(((Keyed) Objects.requireNonNull(keyed, "type")).key(), (UUID) Objects.requireNonNull(uuid, "id"), component);
        }

        private ShowEntity(@NotNull Key key, @NotNull UUID uuid, @Nullable Component component) {
            this.type = key;
            this.id = uuid;
            this.name = component;
        }

        @NotNull
        public Key type() {
            return this.type;
        }

        @NotNull
        public ShowEntity type(@NotNull Key key) {
            return ((Key) Objects.requireNonNull(key, "type")).equals(this.type) ? this : new ShowEntity(key, this.id, this.name);
        }

        @NotNull
        public ShowEntity type(@NotNull Keyed keyed) {
            return type(((Keyed) Objects.requireNonNull(keyed, "type")).key());
        }

        @NotNull
        public UUID id() {
            return this.id;
        }

        @NotNull
        public ShowEntity id(@NotNull UUID uuid) {
            return ((UUID) Objects.requireNonNull(uuid)).equals(this.id) ? this : new ShowEntity(this.type, uuid, this.name);
        }

        @Nullable
        public Component name() {
            return this.name;
        }

        @NotNull
        public ShowEntity name(@Nullable Component component) {
            return Objects.equals(component, this.name) ? this : new ShowEntity(this.type, this.id, component);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            ShowEntity showEntity = (ShowEntity) obj;
            return this.type.equals(showEntity.type) && this.id.equals(showEntity.id) && Objects.equals(this.name, showEntity.name);
        }

        public int hashCode() {
            return (31 * ((31 * this.type.hashCode()) + this.id.hashCode())) + Objects.hashCode(this.name);
        }

        @Override // me.ulrich.clans.library.kyori.examination.Examinable
        @NotNull
        public Stream<? extends ExaminableProperty> examinableProperties() {
            return Stream.of((Object[]) new ExaminableProperty[]{ExaminableProperty.of("type", this.type), ExaminableProperty.of("id", this.id), ExaminableProperty.of("name", this.name)});
        }

        public String toString() {
            return Internals.toString(this);
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/event/HoverEvent$ShowItem.class */
    public static final class ShowItem implements Examinable {
        private final Key item;
        private final int count;

        @Nullable
        private final BinaryTagHolder nbt;
        private final Map<Key, DataComponentValue> dataComponents;

        @NotNull
        public static ShowItem showItem(@NotNull Key key, int i) {
            return showItem(key, i, (Map<Key, ? extends DataComponentValue>) Collections.emptyMap());
        }

        @ApiStatus.ScheduledForRemoval(inVersion = "5.0.0")
        @Deprecated
        @NotNull
        public static ShowItem of(@NotNull Key key, int i) {
            return showItem(key, i, (Map<Key, ? extends DataComponentValue>) Collections.emptyMap());
        }

        @NotNull
        public static ShowItem showItem(@NotNull Keyed keyed, int i) {
            return showItem(keyed, i, (Map<Key, ? extends DataComponentValue>) Collections.emptyMap());
        }

        @ApiStatus.ScheduledForRemoval(inVersion = "5.0.0")
        @Deprecated
        @NotNull
        public static ShowItem of(@NotNull Keyed keyed, int i) {
            return of(keyed, i, (BinaryTagHolder) null);
        }

        @Deprecated
        @NotNull
        public static ShowItem showItem(@NotNull Key key, int i, @Nullable BinaryTagHolder binaryTagHolder) {
            return new ShowItem((Key) Objects.requireNonNull(key, "item"), i, binaryTagHolder, Collections.emptyMap());
        }

        @ApiStatus.ScheduledForRemoval(inVersion = "5.0.0")
        @Deprecated
        @NotNull
        public static ShowItem of(@NotNull Key key, int i, @Nullable BinaryTagHolder binaryTagHolder) {
            return new ShowItem((Key) Objects.requireNonNull(key, "item"), i, binaryTagHolder, Collections.emptyMap());
        }

        @Deprecated
        @NotNull
        public static ShowItem showItem(@NotNull Keyed keyed, int i, @Nullable BinaryTagHolder binaryTagHolder) {
            return new ShowItem(((Keyed) Objects.requireNonNull(keyed, "item")).key(), i, binaryTagHolder, Collections.emptyMap());
        }

        @ApiStatus.ScheduledForRemoval(inVersion = "5.0.0")
        @Deprecated
        @NotNull
        public static ShowItem of(@NotNull Keyed keyed, int i, @Nullable BinaryTagHolder binaryTagHolder) {
            return new ShowItem(((Keyed) Objects.requireNonNull(keyed, "item")).key(), i, binaryTagHolder, Collections.emptyMap());
        }

        @NotNull
        public static ShowItem showItem(@NotNull Keyed keyed, int i, @NotNull Map<Key, ? extends DataComponentValue> map) {
            return new ShowItem(((Keyed) Objects.requireNonNull(keyed, "item")).key(), i, null, map);
        }

        private ShowItem(@NotNull Key key, int i, @Nullable BinaryTagHolder binaryTagHolder, @NotNull Map<Key, ? extends DataComponentValue> map) {
            this.item = key;
            this.count = i;
            this.nbt = binaryTagHolder;
            this.dataComponents = Collections.unmodifiableMap(new HashMap(map));
        }

        @NotNull
        public Key item() {
            return this.item;
        }

        @NotNull
        public ShowItem item(@NotNull Key key) {
            return ((Key) Objects.requireNonNull(key, "item")).equals(this.item) ? this : new ShowItem(key, this.count, this.nbt, this.dataComponents);
        }

        public int count() {
            return this.count;
        }

        @NotNull
        public ShowItem count(int i) {
            return i == this.count ? this : new ShowItem(this.item, i, this.nbt, this.dataComponents);
        }

        @Deprecated
        @Nullable
        public BinaryTagHolder nbt() {
            return this.nbt;
        }

        @Deprecated
        @NotNull
        public ShowItem nbt(@Nullable BinaryTagHolder binaryTagHolder) {
            return Objects.equals(binaryTagHolder, this.nbt) ? this : new ShowItem(this.item, this.count, binaryTagHolder, Collections.emptyMap());
        }

        @NotNull
        public Map<Key, DataComponentValue> dataComponents() {
            return this.dataComponents;
        }

        @NotNull
        public ShowItem dataComponents(@NotNull Map<Key, DataComponentValue> map) {
            if (Objects.equals(this.dataComponents, map)) {
                return this;
            }
            return new ShowItem(this.item, this.count, null, map.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(new HashMap(map)));
        }

        @NotNull
        public <V extends DataComponentValue> Map<Key, V> dataComponentsAs(@NotNull Class<V> cls) {
            if (this.dataComponents.isEmpty()) {
                return Collections.emptyMap();
            }
            HashMap map = new HashMap(this.dataComponents.size());
            for (Map.Entry<Key, DataComponentValue> entry : this.dataComponents.entrySet()) {
                map.put(entry.getKey(), DataComponentValueConverterRegistry.convert(cls, entry.getKey(), entry.getValue()));
            }
            return Collections.unmodifiableMap(map);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            ShowItem showItem = (ShowItem) obj;
            return this.item.equals(showItem.item) && this.count == showItem.count && Objects.equals(this.nbt, showItem.nbt) && Objects.equals(this.dataComponents, showItem.dataComponents);
        }

        public int hashCode() {
            return (31 * ((31 * ((31 * this.item.hashCode()) + Integer.hashCode(this.count))) + Objects.hashCode(this.nbt))) + Objects.hashCode(this.dataComponents);
        }

        @Override // me.ulrich.clans.library.kyori.examination.Examinable
        @NotNull
        public Stream<? extends ExaminableProperty> examinableProperties() {
            return Stream.of((Object[]) new ExaminableProperty[]{ExaminableProperty.of("item", this.item), ExaminableProperty.of("count", this.count), ExaminableProperty.of("nbt", this.nbt), ExaminableProperty.of("dataComponents", this.dataComponents)});
        }

        public String toString() {
            return Internals.toString(this);
        }
    }

    @NotNull
    public static HoverEvent<Component> showText(@NotNull ComponentLike componentLike) {
        return showText(componentLike.asComponent());
    }

    @NotNull
    public static HoverEvent<Component> showText(@NotNull Component component) {
        return new HoverEvent<>(Action.SHOW_TEXT, component);
    }

    @NotNull
    public static HoverEvent<ShowItem> showItem(@NotNull Key key, int i) {
        return showItem(key, i, (Map<Key, ? extends DataComponentValue>) Collections.emptyMap());
    }

    @NotNull
    public static HoverEvent<ShowItem> showItem(@NotNull Keyed keyed, int i) {
        return showItem(keyed, i, (Map<Key, ? extends DataComponentValue>) Collections.emptyMap());
    }

    @Deprecated
    @NotNull
    public static HoverEvent<ShowItem> showItem(@NotNull Key key, int i, @Nullable BinaryTagHolder binaryTagHolder) {
        return showItem(ShowItem.showItem(key, i, binaryTagHolder));
    }

    @Deprecated
    @NotNull
    public static HoverEvent<ShowItem> showItem(@NotNull Keyed keyed, int i, @Nullable BinaryTagHolder binaryTagHolder) {
        return showItem(ShowItem.showItem(keyed, i, binaryTagHolder));
    }

    @NotNull
    public static HoverEvent<ShowItem> showItem(@NotNull Keyed keyed, int i, @NotNull Map<Key, ? extends DataComponentValue> map) {
        return showItem(ShowItem.showItem(keyed, i, map));
    }

    @NotNull
    public static HoverEvent<ShowItem> showItem(@NotNull ShowItem showItem) {
        return new HoverEvent<>(Action.SHOW_ITEM, showItem);
    }

    @NotNull
    public static HoverEvent<ShowEntity> showEntity(@NotNull Key key, @NotNull UUID uuid) {
        return showEntity(key, uuid, (Component) null);
    }

    @NotNull
    public static HoverEvent<ShowEntity> showEntity(@NotNull Keyed keyed, @NotNull UUID uuid) {
        return showEntity(keyed, uuid, (Component) null);
    }

    @NotNull
    public static HoverEvent<ShowEntity> showEntity(@NotNull Key key, @NotNull UUID uuid, @Nullable Component component) {
        return showEntity(ShowEntity.of(key, uuid, component));
    }

    @NotNull
    public static HoverEvent<ShowEntity> showEntity(@NotNull Keyed keyed, @NotNull UUID uuid, @Nullable Component component) {
        return showEntity(ShowEntity.of(keyed, uuid, component));
    }

    @NotNull
    public static HoverEvent<ShowEntity> showEntity(@NotNull ShowEntity showEntity) {
        return new HoverEvent<>(Action.SHOW_ENTITY, showEntity);
    }

    @Deprecated
    @NotNull
    public static HoverEvent<String> showAchievement(@NotNull String str) {
        return new HoverEvent<>(Action.SHOW_ACHIEVEMENT, str);
    }

    @NotNull
    public static <V> HoverEvent<V> hoverEvent(@NotNull Action<V> action, @NotNull V v) {
        return new HoverEvent<>(action, v);
    }

    private HoverEvent(@NotNull Action<V> action, @NotNull V v) {
        this.action = (Action) Objects.requireNonNull(action, "action");
        this.value = (V) Objects.requireNonNull(v, "value");
    }

    @NotNull
    public Action<V> action() {
        return this.action;
    }

    @NotNull
    public V value() {
        return this.value;
    }

    @NotNull
    public HoverEvent<V> value(@NotNull V v) {
        return new HoverEvent<>(this.action, v);
    }

    @NotNull
    public <C> HoverEvent<V> withRenderedValue(@NotNull ComponentRenderer<C> componentRenderer, @NotNull C c) {
        V v = this.value;
        Object objRender = ((Action) this.action).renderer.render(componentRenderer, c, v);
        return objRender != v ? new HoverEvent<>(this.action, objRender) : this;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.event.HoverEventSource
    @NotNull
    public HoverEvent<V> asHoverEvent() {
        return this;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.event.HoverEventSource
    @NotNull
    public HoverEvent<V> asHoverEvent(@NotNull UnaryOperator<V> unaryOperator) {
        return unaryOperator == UnaryOperator.identity() ? this : new HoverEvent<>(this.action, unaryOperator.apply(this.value));
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.format.StyleBuilderApplicable
    public void styleApply(Style.Builder builder) {
        builder.hoverEvent((HoverEventSource<?>) this);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        HoverEvent hoverEvent = (HoverEvent) obj;
        return this.action == hoverEvent.action && this.value.equals(hoverEvent.value);
    }

    public int hashCode() {
        return (31 * this.action.hashCode()) + this.value.hashCode();
    }

    @Override // me.ulrich.clans.library.kyori.examination.Examinable
    @NotNull
    public Stream<? extends ExaminableProperty> examinableProperties() {
        return Stream.of((Object[]) new ExaminableProperty[]{ExaminableProperty.of("action", this.action), ExaminableProperty.of("value", this.value)});
    }

    public String toString() {
        return Internals.toString(this);
    }
}
