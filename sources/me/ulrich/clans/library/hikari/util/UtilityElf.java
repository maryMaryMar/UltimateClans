package me.ulrich.clans.library.hikari.util;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.Locale;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/hikari/util/UtilityElf.class */
public final class UtilityElf {
    private static final Logger LOGGER = LoggerFactory.getLogger((Class<?>) UtilityElf.class);
    private static final Pattern PASSWORD_MASKING_PATTERN = Pattern.compile("([?&;][^&#;=]*[pP]assword=)[^&#;]*");

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/hikari/util/UtilityElf$CustomDiscardPolicy.class */
    public static class CustomDiscardPolicy implements RejectedExecutionHandler {
        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/hikari/util/UtilityElf$DefaultThreadFactory.class */
    public static final class DefaultThreadFactory implements ThreadFactory {
        private final String threadName;
        private final boolean daemon = true;

        public DefaultThreadFactory(String str) {
            this.threadName = str;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, this.threadName);
            thread.setDaemon(this.daemon);
            return thread;
        }
    }

    private UtilityElf() {
    }

    public static String maskPasswordInJdbcUrl(String str) {
        return PASSWORD_MASKING_PATTERN.matcher(str).replaceAll("$1<masked>");
    }

    public static String getNullIfEmpty(String str) {
        if (str == null || str.trim().isEmpty()) {
            return null;
        }
        return str.trim();
    }

    public static void quietlySleep(long j) {
        try {
            Thread.sleep(j);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static boolean safeIsAssignableFrom(Object obj, String str) {
        try {
            return Class.forName(str).isAssignableFrom(obj.getClass());
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    public static <T> T createInstance(String str, Class<T> cls) {
        return (T) createInstance(str, cls, new Object[0]);
    }

    public static <T> T createInstance(String str, Class<T> cls, Object... objArr) {
        if (str == null) {
            return null;
        }
        try {
            Class<?> clsAttemptFromContextLoader = attemptFromContextLoader(str);
            if (clsAttemptFromContextLoader == null) {
                clsAttemptFromContextLoader = UtilityElf.class.getClassLoader().loadClass(str);
                LOGGER.debug("Class {} loaded from classloader {}", str, UtilityElf.class.getClassLoader());
            }
            int length = objArr.length;
            if (length == 0) {
                return cls.cast(clsAttemptFromContextLoader.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
            }
            Class[] clsArr = new Class[length];
            for (int i = 0; i < length; i++) {
                clsArr[i] = objArr[i].getClass();
            }
            return cls.cast(((Constructor) Arrays.stream(clsAttemptFromContextLoader.getConstructors()).filter(constructor -> {
                if (constructor.getParameterCount() != length) {
                    return false;
                }
                Class<?>[] parameterTypes = constructor.getParameterTypes();
                return IntStream.range(0, length).allMatch(i2 -> {
                    return parameterTypes[i2].isAssignableFrom(clsArr[i2]);
                });
            }).findFirst().orElseThrow(() -> {
                return new RuntimeException("No suitable constructor found for class " + str + " with arguments " + Arrays.toString(objArr));
            })).newInstance(objArr));
        } catch (Exception e) {
            throw new RuntimeException("Failed to load class " + str, e);
        }
    }

    public static ThreadPoolExecutor createThreadPoolExecutor(int i, String str, ThreadFactory threadFactory, RejectedExecutionHandler rejectedExecutionHandler) {
        return createThreadPoolExecutor(new LinkedBlockingQueue(i), str, threadFactory, rejectedExecutionHandler);
    }

    public static ThreadPoolExecutor createThreadPoolExecutor(BlockingQueue<Runnable> blockingQueue, String str, ThreadFactory threadFactory, RejectedExecutionHandler rejectedExecutionHandler) {
        if (threadFactory == null) {
            threadFactory = new DefaultThreadFactory(str);
        }
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 5L, TimeUnit.SECONDS, blockingQueue, threadFactory, rejectedExecutionHandler);
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }

    public static int getTransactionIsolation(String str) {
        if (str == null) {
            return -1;
        }
        try {
            return IsolationLevel.valueOf(str.toUpperCase(Locale.ENGLISH)).getLevelId();
        } catch (IllegalArgumentException e) {
            try {
                int i = Integer.parseInt(str);
                for (IsolationLevel isolationLevel : IsolationLevel.values()) {
                    if (isolationLevel.getLevelId() == i) {
                        return isolationLevel.getLevelId();
                    }
                }
                throw new IllegalArgumentException("Invalid transaction isolation value: " + str);
            } catch (NumberFormatException e2) {
                throw new IllegalArgumentException("Invalid transaction isolation value: " + str, e2);
            }
        }
    }

    private static Class<?> attemptFromContextLoader(String str) {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        if (contextClassLoader == null) {
            return null;
        }
        try {
            Class<?> clsLoadClass = contextClassLoader.loadClass(str);
            LOGGER.debug("Class {} found in Thread context class loader {}", str, contextClassLoader);
            return clsLoadClass;
        } catch (ClassNotFoundException e) {
            LOGGER.debug("Class {} not found in Thread context class loader {}, trying classloader {}", str, contextClassLoader, UtilityElf.class.getClassLoader());
            return null;
        }
    }
}
