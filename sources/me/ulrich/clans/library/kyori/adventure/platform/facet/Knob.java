package me.ulrich.clans.library.kyori.adventure.platform.facet;

import java.io.PrintStream;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/platform/facet/Knob.class */
public final class Knob {
    private static final String NAMESPACE = "net.kyo".concat("ri.adventure");
    public static final boolean DEBUG = isEnabled("debug", false);
    private static final Set<Object> UNSUPPORTED = new CopyOnWriteArraySet();
    public static volatile Consumer<String> OUT;
    public static volatile BiConsumer<String, Throwable> ERR;

    private Knob() {
    }

    public static boolean isEnabled(@NotNull String str, boolean z) {
        return System.getProperty(NAMESPACE + "." + str, Boolean.toString(z)).equalsIgnoreCase("true");
    }

    public static void logError(@Nullable Throwable th, @NotNull String str, @NotNull Object... objArr) {
        if (DEBUG) {
            ERR.accept(String.format(str, objArr), th);
        }
    }

    public static void logMessage(@NotNull String str, @NotNull Object... objArr) {
        if (DEBUG) {
            OUT.accept(String.format(str, objArr));
        }
    }

    public static void logUnsupported(@NotNull Object obj, @NotNull Object obj2) {
        if (DEBUG && UNSUPPORTED.add(obj2)) {
            OUT.accept(String.format("Unsupported value '%s' for facet: %s", obj2, obj));
        }
    }

    static {
        PrintStream printStream = System.out;
        Objects.requireNonNull(printStream);
        OUT = printStream::println;
        ERR = (str, th) -> {
            System.err.println(str);
            if (th != null) {
                th.printStackTrace(System.err);
            }
        };
    }
}
