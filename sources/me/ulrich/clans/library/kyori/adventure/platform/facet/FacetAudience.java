package me.ulrich.clans.library.kyori.adventure.platform.facet;

import java.io.Closeable;
import java.util.Collection;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import me.ulrich.clans.library.kyori.adventure.audience.Audience;
import me.ulrich.clans.library.kyori.adventure.audience.MessageType;
import me.ulrich.clans.library.kyori.adventure.bossbar.BossBar;
import me.ulrich.clans.library.kyori.adventure.chat.ChatType;
import me.ulrich.clans.library.kyori.adventure.chat.SignedMessage;
import me.ulrich.clans.library.kyori.adventure.identity.Identity;
import me.ulrich.clans.library.kyori.adventure.inventory.Book;
import me.ulrich.clans.library.kyori.adventure.pointer.Pointers;
import me.ulrich.clans.library.kyori.adventure.sound.Sound;
import me.ulrich.clans.library.kyori.adventure.sound.SoundStop;
import me.ulrich.clans.library.kyori.adventure.text.Component;
import me.ulrich.clans.library.kyori.adventure.text.flattener.ComponentFlattener;
import me.ulrich.clans.library.kyori.adventure.title.Title;
import me.ulrich.clans.library.kyori.adventure.title.TitlePart;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/platform/facet/FacetAudience.class */
@ApiStatus.Internal
public class FacetAudience<V> implements Closeable, Audience {

    @NotNull
    protected final FacetAudienceProvider<V, FacetAudience<V>> provider;

    @NotNull
    private final Set<V> viewers = new CopyOnWriteArraySet();

    @Nullable
    private V viewer;
    private volatile Pointers pointers;
    private final Facet.Chat<V, Object> chat;
    private final Facet.ActionBar<V, Object> actionBar;
    private final Facet.Title<V, Object, Object, Object> title;
    private final Facet.Sound<V, Object> sound;
    private final Facet.EntitySound<V, Object> entitySound;
    private final Facet.Book<V, Object, Object> book;
    private final Facet.BossBar.Builder<V, Facet.BossBar<V>> bossBar;

    @Nullable
    private final Map<BossBar, Facet.BossBar<V>> bossBars;
    private final Facet.TabList<V, Object> tabList;

    @NotNull
    private final Collection<? extends Facet.Pointers<V>> pointerProviders;

    /* JADX WARN: Multi-variable type inference failed */
    public FacetAudience(@NotNull FacetAudienceProvider facetAudienceProvider, @NotNull Collection<? extends V> collection, @Nullable Collection<? extends Facet.Chat> collection2, @Nullable Collection<? extends Facet.ActionBar> collection3, @Nullable Collection<? extends Facet.Title> collection4, @Nullable Collection<? extends Facet.Sound> collection5, @Nullable Collection<? extends Facet.EntitySound> collection6, @Nullable Collection<? extends Facet.Book> collection7, @Nullable Collection<? extends Facet.BossBar.Builder> collection8, @Nullable Collection<? extends Facet.TabList> collection9, @Nullable Collection<? extends Facet.Pointers> collection10) {
        this.provider = (FacetAudienceProvider) Objects.requireNonNull(facetAudienceProvider, "audience provider");
        Iterator it = ((Collection) Objects.requireNonNull(collection, "viewers")).iterator();
        while (it.hasNext()) {
            addViewer(it.next());
        }
        refresh();
        this.chat = (Facet.Chat) Facet.of(collection2, this.viewer);
        this.actionBar = (Facet.ActionBar) Facet.of(collection3, this.viewer);
        this.title = (Facet.Title) Facet.of(collection4, this.viewer);
        this.sound = (Facet.Sound) Facet.of(collection5, this.viewer);
        this.entitySound = (Facet.EntitySound) Facet.of(collection6, this.viewer);
        this.book = (Facet.Book) Facet.of(collection7, this.viewer);
        this.bossBar = (Facet.BossBar.Builder) Facet.of(collection8, this.viewer);
        this.bossBars = this.bossBar == null ? null : Collections.synchronizedMap(new IdentityHashMap(4));
        this.tabList = (Facet.TabList) Facet.of(collection9, this.viewer);
        this.pointerProviders = collection10 == null ? Collections.emptyList() : collection10;
    }

    public void addViewer(@NotNull V v) {
        if (this.viewers.add(v) && this.viewer == null) {
            this.viewer = v;
            refresh();
        }
    }

    public void removeViewer(@NotNull V v) {
        if (this.viewers.remove(v) && this.viewer == v) {
            this.viewer = this.viewers.isEmpty() ? null : this.viewers.iterator().next();
            refresh();
        }
        if (this.bossBars == null) {
            return;
        }
        Iterator<Facet.BossBar<V>> it = this.bossBars.values().iterator();
        while (it.hasNext()) {
            it.next().removeViewer(v);
        }
    }

    public void refresh() {
        synchronized (this) {
            this.pointers = null;
        }
        if (this.bossBars == null) {
            return;
        }
        for (Map.Entry<BossBar, Facet.BossBar<V>> entry : this.bossBars.entrySet()) {
            BossBar key = entry.getKey();
            entry.getValue().bossBarNameChanged(key, key.name(), key.name());
        }
    }

    @Override // me.ulrich.clans.library.kyori.adventure.audience.Audience
    public void sendMessage(@NotNull Identity identity, @NotNull Component component, @NotNull MessageType messageType) {
        Object objCreateMessage;
        if (this.chat == null || (objCreateMessage = createMessage(component, this.chat)) == null) {
            return;
        }
        Iterator<V> it = this.viewers.iterator();
        while (it.hasNext()) {
            this.chat.sendMessage(it.next(), identity, objCreateMessage, messageType);
        }
    }

    @Override // me.ulrich.clans.library.kyori.adventure.audience.Audience
    public void sendMessage(@NotNull Component component, ChatType.Bound bound) {
        Object objCreateMessage;
        if (this.chat == null || (objCreateMessage = createMessage(component, this.chat)) == null) {
            return;
        }
        Component componentRender = this.provider.componentRenderer.render(bound.name(), this);
        Component componentRender2 = null;
        if (bound.target() != null) {
            componentRender2 = this.provider.componentRenderer.render(bound.target(), this);
        }
        ChatType.Bound boundBind = bound.type().bind(componentRender, componentRender2);
        Iterator<V> it = this.viewers.iterator();
        while (it.hasNext()) {
            this.chat.sendMessage(it.next(), Identity.nil(), objCreateMessage, boundBind);
        }
    }

    @Override // me.ulrich.clans.library.kyori.adventure.audience.Audience
    public void sendMessage(@NotNull SignedMessage signedMessage, ChatType.Bound bound) {
        if (signedMessage.isSystem()) {
            sendMessage(signedMessage.unsignedContent() != null ? signedMessage.unsignedContent() : Component.text(signedMessage.message()), bound);
        } else {
            super.sendMessage(signedMessage, bound);
        }
    }

    @Override // me.ulrich.clans.library.kyori.adventure.audience.Audience
    public void sendActionBar(@NotNull Component component) {
        Object objCreateMessage;
        if (this.actionBar == null || (objCreateMessage = createMessage(component, this.actionBar)) == null) {
            return;
        }
        Iterator<V> it = this.viewers.iterator();
        while (it.hasNext()) {
            this.actionBar.sendMessage(it.next(), objCreateMessage);
        }
    }

    @Override // me.ulrich.clans.library.kyori.adventure.audience.Audience
    public void playSound(Sound sound) {
        if (this.sound == null) {
            return;
        }
        for (V v : this.viewers) {
            Object objCreatePosition = this.sound.createPosition(v);
            if (objCreatePosition != null) {
                this.sound.playSound(v, sound, objCreatePosition);
            }
        }
    }

    @Override // me.ulrich.clans.library.kyori.adventure.audience.Audience
    public void playSound(@NotNull Sound sound, Sound.Emitter emitter) {
        if (this.entitySound == null) {
            return;
        }
        if (emitter == Sound.Emitter.self()) {
            for (V v : this.viewers) {
                Object objCreateForSelf = this.entitySound.createForSelf(v, sound);
                if (objCreateForSelf != null) {
                    this.entitySound.playSound(v, objCreateForSelf);
                }
            }
            return;
        }
        Object objCreateForEmitter = this.entitySound.createForEmitter(sound, emitter);
        if (objCreateForEmitter == null) {
            return;
        }
        Iterator<V> it = this.viewers.iterator();
        while (it.hasNext()) {
            this.entitySound.playSound(it.next(), objCreateForEmitter);
        }
    }

    @Override // me.ulrich.clans.library.kyori.adventure.audience.Audience
    public void playSound(Sound sound, double d, double d2, double d3) {
        if (this.sound == null) {
            return;
        }
        Object objCreatePosition = this.sound.createPosition(d, d2, d3);
        Iterator<V> it = this.viewers.iterator();
        while (it.hasNext()) {
            this.sound.playSound(it.next(), sound, objCreatePosition);
        }
    }

    @Override // me.ulrich.clans.library.kyori.adventure.audience.Audience
    public void stopSound(@NotNull SoundStop soundStop) {
        if (this.sound == null) {
            return;
        }
        Iterator<V> it = this.viewers.iterator();
        while (it.hasNext()) {
            this.sound.stopSound(it.next(), soundStop);
        }
    }

    @Override // me.ulrich.clans.library.kyori.adventure.audience.Audience
    public void openBook(Book book) {
        Object objCreateBook;
        if (this.book == null) {
            return;
        }
        String plain = toPlain(book.title());
        String plain2 = toPlain(book.author());
        LinkedList linkedList = new LinkedList();
        Iterator<Component> it = book.pages().iterator();
        while (it.hasNext()) {
            Object objCreateMessage = createMessage(it.next(), this.book);
            if (objCreateMessage != null) {
                linkedList.add(objCreateMessage);
            }
        }
        if (plain == null || plain2 == null || linkedList.isEmpty() || (objCreateBook = this.book.createBook(plain, plain2, linkedList)) == null) {
            return;
        }
        Iterator<V> it2 = this.viewers.iterator();
        while (it2.hasNext()) {
            this.book.openBook(it2.next(), objCreateBook);
        }
    }

    private String toPlain(Component component) {
        if (component == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        ComponentFlattener componentFlattenerBasic = ComponentFlattener.basic();
        Component componentRender = this.provider.componentRenderer.render(component, this);
        Objects.requireNonNull(sb);
        componentFlattenerBasic.flatten(componentRender, sb::append);
        return sb.toString();
    }

    @Override // me.ulrich.clans.library.kyori.adventure.audience.Audience
    public void showTitle(Title title) {
        if (this.title == null) {
            return;
        }
        Object objCreateMessage = createMessage(title.title(), this.title);
        Object objCreateMessage2 = createMessage(title.subtitle(), this.title);
        Title.Times times = title.times();
        int ticks = times == null ? -1 : this.title.toTicks(times.fadeIn());
        int ticks2 = times == null ? -1 : this.title.toTicks(times.stay());
        int ticks3 = times == null ? -1 : this.title.toTicks(times.fadeOut());
        Object objCreateTitleCollection = this.title.createTitleCollection();
        if (ticks != -1 || ticks2 != -1 || ticks3 != -1) {
            this.title.contributeTimes(objCreateTitleCollection, ticks, ticks2, ticks3);
        }
        this.title.contributeSubtitle(objCreateTitleCollection, objCreateMessage2);
        this.title.contributeTitle(objCreateTitleCollection, objCreateMessage);
        Object objCompleteTitle = this.title.completeTitle(objCreateTitleCollection);
        if (objCompleteTitle == null) {
            return;
        }
        Iterator<V> it = this.viewers.iterator();
        while (it.hasNext()) {
            this.title.showTitle(it.next(), objCompleteTitle);
        }
    }

    @Override // me.ulrich.clans.library.kyori.adventure.audience.Audience
    public <T> void sendTitlePart(@NotNull TitlePart<T> titlePart, @NotNull T t) {
        if (this.title == null) {
            return;
        }
        Objects.requireNonNull(t, "value");
        Object objCreateTitleCollection = this.title.createTitleCollection();
        if (titlePart == TitlePart.TITLE) {
            Object objCreateMessage = createMessage((Component) t, this.title);
            if (objCreateMessage != null) {
                this.title.contributeTitle(objCreateTitleCollection, objCreateMessage);
            }
        } else if (titlePart == TitlePart.SUBTITLE) {
            Object objCreateMessage2 = createMessage((Component) t, this.title);
            if (objCreateMessage2 != null) {
                this.title.contributeSubtitle(objCreateTitleCollection, objCreateMessage2);
            }
        } else {
            if (titlePart != TitlePart.TIMES) {
                throw new IllegalArgumentException("Unknown TitlePart '" + titlePart + "'");
            }
            Title.Times times = (Title.Times) t;
            int ticks = this.title.toTicks(times.fadeIn());
            int ticks2 = this.title.toTicks(times.stay());
            int ticks3 = this.title.toTicks(times.fadeOut());
            if (ticks != -1 || ticks2 != -1 || ticks3 != -1) {
                this.title.contributeTimes(objCreateTitleCollection, ticks, ticks2, ticks3);
            }
        }
        Object objCompleteTitle = this.title.completeTitle(objCreateTitleCollection);
        if (objCompleteTitle == null) {
            return;
        }
        Iterator<V> it = this.viewers.iterator();
        while (it.hasNext()) {
            this.title.showTitle(it.next(), objCompleteTitle);
        }
    }

    @Override // me.ulrich.clans.library.kyori.adventure.audience.Audience
    public void clearTitle() {
        if (this.title == null) {
            return;
        }
        Iterator<V> it = this.viewers.iterator();
        while (it.hasNext()) {
            this.title.clearTitle(it.next());
        }
    }

    @Override // me.ulrich.clans.library.kyori.adventure.audience.Audience
    public void resetTitle() {
        if (this.title == null) {
            return;
        }
        Iterator<V> it = this.viewers.iterator();
        while (it.hasNext()) {
            this.title.resetTitle(it.next());
        }
    }

    public void showBossBar(@NotNull BossBar bossBar) {
        Facet.BossBar<V> facetBossBarListener;
        if (this.bossBar == null || this.bossBars == null) {
            return;
        }
        synchronized (this.bossBars) {
            facetBossBarListener = this.bossBars.get(bossBar);
            if (facetBossBarListener == null) {
                facetBossBarListener = new FacetBossBarListener(this.bossBar.createBossBar(this.viewers), component -> {
                    return this.provider.componentRenderer.render(component, this);
                });
                this.bossBars.put(bossBar, facetBossBarListener);
            }
        }
        if (facetBossBarListener.isEmpty()) {
            facetBossBarListener.bossBarInitialized(bossBar);
            bossBar.addListener(facetBossBarListener);
        }
        Iterator<V> it = this.viewers.iterator();
        while (it.hasNext()) {
            facetBossBarListener.addViewer(it.next());
        }
    }

    @Override // me.ulrich.clans.library.kyori.adventure.audience.Audience
    public void hideBossBar(@NotNull BossBar bossBar) {
        Facet.BossBar<V> bossBar2;
        if (this.bossBars == null || (bossBar2 = this.bossBars.get(bossBar)) == null) {
            return;
        }
        Iterator<V> it = this.viewers.iterator();
        while (it.hasNext()) {
            bossBar2.removeViewer(it.next());
        }
        if (!bossBar2.isEmpty() || this.bossBars.remove(bossBar) == null) {
            return;
        }
        bossBar.removeListener(bossBar2);
        bossBar2.close();
    }

    @Override // me.ulrich.clans.library.kyori.adventure.audience.Audience
    public void sendPlayerListHeader(@NotNull Component component) {
        Object objCreateMessage;
        if (this.tabList == null || (objCreateMessage = createMessage(component, this.tabList)) == null) {
            return;
        }
        Iterator<V> it = this.viewers.iterator();
        while (it.hasNext()) {
            this.tabList.send(it.next(), objCreateMessage, null);
        }
    }

    @Override // me.ulrich.clans.library.kyori.adventure.audience.Audience
    public void sendPlayerListFooter(@NotNull Component component) {
        Object objCreateMessage;
        if (this.tabList == null || (objCreateMessage = createMessage(component, this.tabList)) == null) {
            return;
        }
        Iterator<V> it = this.viewers.iterator();
        while (it.hasNext()) {
            this.tabList.send(it.next(), null, objCreateMessage);
        }
    }

    @Override // me.ulrich.clans.library.kyori.adventure.audience.Audience
    public void sendPlayerListHeaderAndFooter(@NotNull Component component, @NotNull Component component2) {
        if (this.tabList != null) {
            Object objCreateMessage = createMessage(component, this.tabList);
            Object objCreateMessage2 = createMessage(component2, this.tabList);
            if (objCreateMessage == null || objCreateMessage2 == null) {
                return;
            }
            Iterator<V> it = this.viewers.iterator();
            while (it.hasNext()) {
                this.tabList.send(it.next(), objCreateMessage, objCreateMessage2);
            }
        }
    }

    @Override // me.ulrich.clans.library.kyori.adventure.pointer.Pointered
    @NotNull
    public Pointers pointers() {
        if (this.pointers == null) {
            synchronized (this) {
                if (this.pointers == null) {
                    V v = this.viewer;
                    if (v == null) {
                        return Pointers.empty();
                    }
                    Pointers.Builder builder = Pointers.builder();
                    contributePointers(builder);
                    for (Facet.Pointers<V> pointers : this.pointerProviders) {
                        if (pointers.isApplicable(v)) {
                            pointers.contributePointers(v, builder);
                        }
                    }
                    Pointers pointersBuild = builder.build2();
                    this.pointers = pointersBuild;
                    return pointersBuild;
                }
            }
        }
        return this.pointers;
    }

    @ApiStatus.OverrideOnly
    protected void contributePointers(Pointers.Builder builder) {
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.bossBars != null) {
            Iterator it = new LinkedList(this.bossBars.keySet()).iterator();
            while (it.hasNext()) {
                hideBossBar((BossBar) it.next());
            }
            this.bossBars.clear();
        }
        Iterator<V> it2 = this.viewers.iterator();
        while (it2.hasNext()) {
            removeViewer(it2.next());
        }
        this.viewers.clear();
    }

    @Nullable
    private Object createMessage(@NotNull Component component, Facet.Message<V, Object> message) {
        Component componentRender = this.provider.componentRenderer.render(component, this);
        V v = this.viewer;
        if (v == null) {
            return null;
        }
        return message.createMessage(v, componentRender);
    }
}
