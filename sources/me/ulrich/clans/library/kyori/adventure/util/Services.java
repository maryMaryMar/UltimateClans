package me.ulrich.clans.library.kyori.adventure.util;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Optional;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;
import java.util.Set;
import me.ulrich.clans.library.kyori.adventure.internal.properties.AdventureProperties;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/util/Services.class */
public final class Services {
    private static final boolean SERVICE_LOAD_FAILURES_ARE_FATAL = Boolean.TRUE.equals(AdventureProperties.SERVICE_LOAD_FAILURES_ARE_FATAL.value());

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/util/Services$Fallback.class */
    public interface Fallback {
    }

    private Services() {
    }

    @NotNull
    public static <P> Optional<P> service(@NotNull Class<P> cls) {
        Iterator it = Services0.loader(cls).iterator();
        while (it.hasNext()) {
            try {
                Object next = it.next();
                if (it.hasNext()) {
                    throw new IllegalStateException("Expected to find one service " + cls + ", found multiple");
                }
                return Optional.of(next);
            } catch (Throwable th) {
                if (SERVICE_LOAD_FAILURES_ARE_FATAL) {
                    throw new IllegalStateException("Encountered an exception loading service " + cls, th);
                }
            }
        }
        return Optional.empty();
    }

    @NotNull
    public static <P> Optional<P> serviceWithFallback(@NotNull Class<P> cls) {
        Object obj = null;
        for (Object obj2 : Services0.loader(cls)) {
            try {
                if (!(obj2 instanceof Fallback)) {
                    return Optional.of(obj2);
                }
                if (obj == null) {
                    obj = obj2;
                }
            } catch (Throwable th) {
                if (SERVICE_LOAD_FAILURES_ARE_FATAL) {
                    throw new IllegalStateException("Encountered an exception loading service " + cls, th);
                }
            }
        }
        return Optional.ofNullable(obj);
    }

    public static <P> Set<P> services(Class<? extends P> cls) {
        ServiceLoader serviceLoaderLoader = Services0.loader(cls);
        HashSet hashSet = new HashSet();
        Iterator it = serviceLoaderLoader.iterator();
        while (it.hasNext()) {
            try {
                hashSet.add(it.next());
            } catch (ServiceConfigurationError e) {
                if (SERVICE_LOAD_FAILURES_ARE_FATAL) {
                    throw new IllegalStateException("Encountered an exception loading a provider for " + cls + ": ", e);
                }
            }
        }
        return Collections.unmodifiableSet(hashSet);
    }
}
