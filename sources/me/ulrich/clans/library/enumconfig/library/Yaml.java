package me.ulrich.clans.library.enumconfig.library;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.regex.Pattern;
import me.ulrich.clans.library.enumconfig.library.composer.Composer;
import me.ulrich.clans.library.enumconfig.library.constructor.BaseConstructor;
import me.ulrich.clans.library.enumconfig.library.constructor.Constructor;
import me.ulrich.clans.library.enumconfig.library.emitter.Emitable;
import me.ulrich.clans.library.enumconfig.library.emitter.Emitter;
import me.ulrich.clans.library.enumconfig.library.error.YAMLException;
import me.ulrich.clans.library.enumconfig.library.events.Event;
import me.ulrich.clans.library.enumconfig.library.introspector.BeanAccess;
import me.ulrich.clans.library.enumconfig.library.nodes.Node;
import me.ulrich.clans.library.enumconfig.library.nodes.Tag;
import me.ulrich.clans.library.enumconfig.library.parser.ParserImpl;
import me.ulrich.clans.library.enumconfig.library.reader.StreamReader;
import me.ulrich.clans.library.enumconfig.library.reader.UnicodeReader;
import me.ulrich.clans.library.enumconfig.library.representer.Representer;
import me.ulrich.clans.library.enumconfig.library.resolver.Resolver;
import me.ulrich.clans.library.enumconfig.library.serializer.Serializer;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/Yaml.class */
public class Yaml {
    protected final Resolver resolver;
    private String name;
    protected BaseConstructor constructor;
    protected Representer representer;
    protected DumperOptions dumperOptions;
    protected LoaderOptions loadingConfig;

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/Yaml$EventIterable.class */
    private static class EventIterable implements Iterable<Event> {
        private final Iterator<Event> iterator;

        public EventIterable(Iterator<Event> it) {
            this.iterator = it;
        }

        @Override // java.lang.Iterable
        public Iterator<Event> iterator() {
            return this.iterator;
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/Yaml$NodeIterable.class */
    private static class NodeIterable implements Iterable<Node> {
        private final Iterator<Node> iterator;

        public NodeIterable(Iterator<Node> it) {
            this.iterator = it;
        }

        @Override // java.lang.Iterable
        public Iterator<Node> iterator() {
            return this.iterator;
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/Yaml$SilentEmitter.class */
    private static class SilentEmitter implements Emitable {
        private final List<Event> events;

        private SilentEmitter() {
            this.events = new ArrayList(100);
        }

        public List<Event> getEvents() {
            return this.events;
        }

        @Override // me.ulrich.clans.library.enumconfig.library.emitter.Emitable
        public void emit(Event event) {
            this.events.add(event);
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/Yaml$YamlIterable.class */
    private static class YamlIterable implements Iterable<Object> {
        private final Iterator<Object> iterator;

        public YamlIterable(Iterator<Object> it) {
            this.iterator = it;
        }

        @Override // java.lang.Iterable
        public Iterator<Object> iterator() {
            return this.iterator;
        }
    }

    public Yaml() {
        this(new Constructor(new LoaderOptions()), new Representer(new DumperOptions()));
    }

    public Yaml(DumperOptions dumperOptions) {
        this(new Constructor(new LoaderOptions()), new Representer(dumperOptions), dumperOptions);
    }

    public Yaml(LoaderOptions loaderOptions) {
        this(new Constructor(loaderOptions), new Representer(new DumperOptions()), new DumperOptions(), loaderOptions);
    }

    public Yaml(LoaderOptions loaderOptions, DumperOptions dumperOptions) {
        this(new Constructor(loaderOptions), new Representer(dumperOptions), dumperOptions);
    }

    public Yaml(Representer representer) {
        this(new Constructor(new LoaderOptions()), representer);
    }

    public Yaml(BaseConstructor baseConstructor) {
        this(baseConstructor, new Representer(new DumperOptions()));
    }

    public Yaml(BaseConstructor baseConstructor, Representer representer) {
        this(baseConstructor, representer, initDumperOptions(representer));
    }

    private static DumperOptions initDumperOptions(Representer representer) {
        DumperOptions dumperOptions = new DumperOptions();
        dumperOptions.setDefaultFlowStyle(representer.getDefaultFlowStyle());
        dumperOptions.setDefaultScalarStyle(representer.getDefaultScalarStyle());
        dumperOptions.setAllowReadOnlyProperties(representer.getPropertyUtils().isAllowReadOnlyProperties());
        dumperOptions.setTimeZone(representer.getTimeZone());
        return dumperOptions;
    }

    public Yaml(Representer representer, DumperOptions dumperOptions) {
        this(new Constructor(new LoaderOptions()), representer, dumperOptions);
    }

    public Yaml(BaseConstructor baseConstructor, Representer representer, DumperOptions dumperOptions) {
        this(baseConstructor, representer, dumperOptions, baseConstructor.getLoadingConfig(), new Resolver());
    }

    public Yaml(BaseConstructor baseConstructor, Representer representer, DumperOptions dumperOptions, LoaderOptions loaderOptions) {
        this(baseConstructor, representer, dumperOptions, loaderOptions, new Resolver());
    }

    public Yaml(BaseConstructor baseConstructor, Representer representer, DumperOptions dumperOptions, Resolver resolver) {
        this(baseConstructor, representer, dumperOptions, new LoaderOptions(), resolver);
    }

    public Yaml(BaseConstructor baseConstructor, Representer representer, DumperOptions dumperOptions, LoaderOptions loaderOptions, Resolver resolver) {
        if (baseConstructor == null) {
            throw new NullPointerException("Constructor must be provided");
        }
        if (representer == null) {
            throw new NullPointerException("Representer must be provided");
        }
        if (dumperOptions == null) {
            throw new NullPointerException("DumperOptions must be provided");
        }
        if (loaderOptions == null) {
            throw new NullPointerException("LoaderOptions must be provided");
        }
        if (resolver == null) {
            throw new NullPointerException("Resolver must be provided");
        }
        if (!baseConstructor.isExplicitPropertyUtils()) {
            baseConstructor.setPropertyUtils(representer.getPropertyUtils());
        } else if (!representer.isExplicitPropertyUtils()) {
            representer.setPropertyUtils(baseConstructor.getPropertyUtils());
        }
        this.constructor = baseConstructor;
        this.constructor.setAllowDuplicateKeys(loaderOptions.isAllowDuplicateKeys());
        this.constructor.setWarnOnDuplicateKeys(loaderOptions.isWarnOnDuplicateKeys());
        this.constructor.setWrappedToRootException(loaderOptions.isWrappedToRootException());
        if (!dumperOptions.getIndentWithIndicator() && dumperOptions.getIndent() <= dumperOptions.getIndicatorIndent()) {
            throw new YAMLException("Indicator indent must be smaller then indent.");
        }
        representer.setDefaultFlowStyle(dumperOptions.getDefaultFlowStyle());
        representer.setDefaultScalarStyle(dumperOptions.getDefaultScalarStyle());
        representer.getPropertyUtils().setAllowReadOnlyProperties(dumperOptions.isAllowReadOnlyProperties());
        representer.setTimeZone(dumperOptions.getTimeZone());
        this.representer = representer;
        this.dumperOptions = dumperOptions;
        this.loadingConfig = loaderOptions;
        this.resolver = resolver;
        this.name = "Yaml:" + System.identityHashCode(this);
    }

    public String dump(Object obj) {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(obj);
        return dumpAll(arrayList.iterator());
    }

    public Node represent(Object obj) {
        return this.representer.represent(obj);
    }

    public String dumpAll(Iterator<? extends Object> it) {
        StringWriter stringWriter = new StringWriter();
        dumpAll(it, stringWriter, null);
        return stringWriter.toString();
    }

    public void dump(Object obj, Writer writer) {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(obj);
        dumpAll(arrayList.iterator(), writer, null);
    }

    public void dumpAll(Iterator<? extends Object> it, Writer writer) {
        dumpAll(it, writer, null);
    }

    private void dumpAll(Iterator<? extends Object> it, Writer writer, Tag tag) {
        Serializer serializer = new Serializer(new Emitter(writer, this.dumperOptions), this.resolver, this.dumperOptions, tag);
        try {
            serializer.open();
            while (it.hasNext()) {
                serializer.serialize(this.representer.represent(it.next()));
            }
            serializer.close();
        } catch (IOException e) {
            throw new YAMLException(e);
        }
    }

    public String dumpAs(Object obj, Tag tag, DumperOptions.FlowStyle flowStyle) {
        DumperOptions.FlowStyle defaultFlowStyle = this.representer.getDefaultFlowStyle();
        if (flowStyle != null) {
            this.representer.setDefaultFlowStyle(flowStyle);
        }
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(obj);
        StringWriter stringWriter = new StringWriter();
        dumpAll(arrayList.iterator(), stringWriter, tag);
        this.representer.setDefaultFlowStyle(defaultFlowStyle);
        return stringWriter.toString();
    }

    public String dumpAsMap(Object obj) {
        return dumpAs(obj, Tag.MAP, DumperOptions.FlowStyle.BLOCK);
    }

    public void serialize(Node node, Writer writer) {
        Serializer serializer = new Serializer(new Emitter(writer, this.dumperOptions), this.resolver, this.dumperOptions, null);
        try {
            serializer.open();
            serializer.serialize(node);
            serializer.close();
        } catch (IOException e) {
            throw new YAMLException(e);
        }
    }

    public List<Event> serialize(Node node) {
        SilentEmitter silentEmitter = new SilentEmitter();
        Serializer serializer = new Serializer(silentEmitter, this.resolver, this.dumperOptions, null);
        try {
            serializer.open();
            serializer.serialize(node);
            serializer.close();
            return silentEmitter.getEvents();
        } catch (IOException e) {
            throw new YAMLException(e);
        }
    }

    public <T> T load(String str) {
        return (T) loadFromReader(new StreamReader(str), Object.class);
    }

    public <T> T load(InputStream inputStream) {
        return (T) loadFromReader(new StreamReader(new UnicodeReader(inputStream)), Object.class);
    }

    public <T> T load(Reader reader) {
        return (T) loadFromReader(new StreamReader(reader), Object.class);
    }

    public <T> T loadAs(Reader reader, Class<? super T> cls) {
        return (T) loadFromReader(new StreamReader(reader), cls);
    }

    public <T> T loadAs(String str, Class<? super T> cls) {
        return (T) loadFromReader(new StreamReader(str), cls);
    }

    public <T> T loadAs(InputStream inputStream, Class<? super T> cls) {
        return (T) loadFromReader(new StreamReader(new UnicodeReader(inputStream)), cls);
    }

    private Object loadFromReader(StreamReader streamReader, Class<?> cls) {
        this.constructor.setComposer(new Composer(new ParserImpl(streamReader, this.loadingConfig), this.resolver, this.loadingConfig));
        return this.constructor.getSingleData(cls);
    }

    public Iterable<Object> loadAll(Reader reader) {
        this.constructor.setComposer(new Composer(new ParserImpl(new StreamReader(reader), this.loadingConfig), this.resolver, this.loadingConfig));
        return new YamlIterable(new Iterator<Object>() { // from class: me.ulrich.clans.library.enumconfig.library.Yaml.1
            @Override // java.util.Iterator
            public boolean hasNext() {
                return Yaml.this.constructor.checkData();
            }

            @Override // java.util.Iterator
            public Object next() {
                return Yaml.this.constructor.getData();
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }
        });
    }

    public Iterable<Object> loadAll(String str) {
        return loadAll(new StringReader(str));
    }

    public Iterable<Object> loadAll(InputStream inputStream) {
        return loadAll(new UnicodeReader(inputStream));
    }

    public Node compose(Reader reader) {
        return new Composer(new ParserImpl(new StreamReader(reader), this.loadingConfig), this.resolver, this.loadingConfig).getSingleNode();
    }

    public Iterable<Node> composeAll(Reader reader) {
        final Composer composer = new Composer(new ParserImpl(new StreamReader(reader), this.loadingConfig), this.resolver, this.loadingConfig);
        return new NodeIterable(new Iterator<Node>() { // from class: me.ulrich.clans.library.enumconfig.library.Yaml.2
            @Override // java.util.Iterator
            public boolean hasNext() {
                return composer.checkNode();
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.Iterator
            public Node next() {
                Node node = composer.getNode();
                if (node != null) {
                    return node;
                }
                throw new NoSuchElementException("No Node is available.");
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }
        });
    }

    public void addImplicitResolver(Tag tag, Pattern pattern, String str) {
        this.resolver.addImplicitResolver(tag, pattern, str);
    }

    public void addImplicitResolver(Tag tag, Pattern pattern, String str, int i) {
        this.resolver.addImplicitResolver(tag, pattern, str, i);
    }

    public String toString() {
        return this.name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public Iterable<Event> parse(Reader reader) {
        final ParserImpl parserImpl = new ParserImpl(new StreamReader(reader), this.loadingConfig);
        return new EventIterable(new Iterator<Event>() { // from class: me.ulrich.clans.library.enumconfig.library.Yaml.3
            @Override // java.util.Iterator
            public boolean hasNext() {
                return parserImpl.peekEvent() != null;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.Iterator
            public Event next() {
                Event event = parserImpl.getEvent();
                if (event != null) {
                    return event;
                }
                throw new NoSuchElementException("No Event is available.");
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }
        });
    }

    public void setBeanAccess(BeanAccess beanAccess) {
        this.constructor.getPropertyUtils().setBeanAccess(beanAccess);
        this.representer.getPropertyUtils().setBeanAccess(beanAccess);
    }

    public void addTypeDescription(TypeDescription typeDescription) {
        this.constructor.addTypeDescription(typeDescription);
        this.representer.addTypeDescription(typeDescription);
    }
}
