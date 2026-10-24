package me.ulrich.clans.library.hikari.util;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;
import java.util.stream.Collectors;
import me.ulrich.clans.library.hikari.util.ConcurrentBag.IConcurrentBagEntry;
import org.apache.commons.pool2.impl.BaseObjectPoolConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/hikari/util/ConcurrentBag.class */
public class ConcurrentBag<T extends IConcurrentBagEntry> implements AutoCloseable {
    private static final Logger LOGGER = LoggerFactory.getLogger((Class<?>) ConcurrentBag.class);
    private final IBagStateListener listener;
    private volatile boolean closed;
    private final boolean useWeakThreadLocals = useWeakThreadLocals();
    private final SynchronousQueue<T> handoffQueue = new SynchronousQueue<>(true);
    private final AtomicInteger waiters = new AtomicInteger();
    private final CopyOnWriteArrayList<T> sharedList = new CopyOnWriteArrayList<>();
    private final ThreadLocal<List<Object>> threadLocalList = ThreadLocal.withInitial(() -> {
        return this.useWeakThreadLocals ? new ArrayList(16) : new FastList(IConcurrentBagEntry.class, 16);
    });

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/hikari/util/ConcurrentBag$IBagStateListener.class */
    public interface IBagStateListener {
        void addBagItem(int i);
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/hikari/util/ConcurrentBag$IConcurrentBagEntry.class */
    public interface IConcurrentBagEntry {
        public static final int STATE_NOT_IN_USE = 0;
        public static final int STATE_IN_USE = 1;
        public static final int STATE_REMOVED = -1;
        public static final int STATE_RESERVED = -2;

        boolean compareAndSet(int i, int i2);

        void setState(int i);

        int getState();
    }

    public ConcurrentBag(IBagStateListener iBagStateListener) {
        this.listener = iBagStateListener;
    }

    public T borrow(long j, TimeUnit timeUnit) {
        List<Object> list = this.threadLocalList.get();
        for (int size = list.size() - 1; size >= 0; size--) {
            Object objRemove = list.remove(size);
            T t = (T) (this.useWeakThreadLocals ? (IConcurrentBagEntry) ((WeakReference) objRemove).get() : (IConcurrentBagEntry) objRemove);
            if (t != null && t.compareAndSet(0, 1)) {
                return t;
            }
        }
        int iIncrementAndGet = this.waiters.incrementAndGet();
        try {
            for (T t2 : this.sharedList) {
                if (t2.compareAndSet(0, 1)) {
                    if (iIncrementAndGet > 1) {
                        this.listener.addBagItem(iIncrementAndGet - 1);
                    }
                    this.waiters.decrementAndGet();
                    return t2;
                }
            }
            this.listener.addBagItem(iIncrementAndGet);
            long nanos = timeUnit.toNanos(j);
            do {
                long jCurrentTime = ClockSource.currentTime();
                T tPoll = this.handoffQueue.poll(nanos, TimeUnit.NANOSECONDS);
                if (tPoll == null || tPoll.compareAndSet(0, 1)) {
                    this.waiters.decrementAndGet();
                    return tPoll;
                }
                nanos -= ClockSource.elapsedNanos(jCurrentTime);
            } while (nanos > BaseObjectPoolConfig.DEFAULT_EVICTOR_SHUTDOWN_TIMEOUT_MILLIS);
            this.waiters.decrementAndGet();
            return null;
        } catch (Throwable th) {
            this.waiters.decrementAndGet();
            throw th;
        }
    }

    public void requite(T t) {
        t.setState(0);
        int i = 1;
        int i2 = this.waiters.get();
        while (true) {
            int i3 = i2;
            if (i3 <= 0) {
                List<Object> list = this.threadLocalList.get();
                if (list.size() < 16) {
                    list.add(this.useWeakThreadLocals ? new WeakReference(t) : t);
                    return;
                }
                return;
            }
            if (t.getState() != 0 || this.handoffQueue.offer(t)) {
                return;
            }
            if ((i & 255) == 255 || (i3 > 1 && i % i3 == 0)) {
                LockSupport.parkNanos(TimeUnit.MICROSECONDS.toNanos(10L));
            } else {
                Thread.yield();
            }
            i++;
            i2 = this.waiters.get();
        }
    }

    public void add(T t) {
        if (this.closed) {
            LOGGER.info("ConcurrentBag has been closed, ignoring add()");
            throw new IllegalStateException("ConcurrentBag has been closed, ignoring add()");
        }
        this.sharedList.add(t);
        while (this.waiters.get() > 0 && t.getState() == 0 && !this.handoffQueue.offer(t)) {
            Thread.yield();
        }
    }

    public boolean remove(T t) {
        if (!t.compareAndSet(1, -1) && !t.compareAndSet(-2, -1) && !this.closed) {
            LOGGER.warn("Attempt to remove an object from the bag that was not borrowed or reserved: {}", t);
            return false;
        }
        boolean zRemove = this.sharedList.remove(t);
        if (!zRemove && !this.closed) {
            LOGGER.warn("Attempt to remove an object from the bag that does not exist: {}", t);
        }
        this.threadLocalList.get().remove(t);
        return zRemove;
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        this.closed = true;
    }

    public List<T> values(int i) {
        List<T> list = (List) this.sharedList.stream().filter(iConcurrentBagEntry -> {
            return iConcurrentBagEntry.getState() == i;
        }).collect(Collectors.toList());
        Collections.reverse(list);
        return list;
    }

    public List<T> values() {
        return (List) this.sharedList.clone();
    }

    public boolean reserve(T t) {
        return t.compareAndSet(0, -2);
    }

    public void unreserve(T t) {
        if (!t.compareAndSet(-2, 0)) {
            LOGGER.warn("Attempt to relinquish an object to the bag that was not reserved: {}", t);
            return;
        }
        int i = 1;
        int i2 = this.waiters.get();
        while (true) {
            int i3 = i2;
            if (i3 <= 0 || t.getState() != 0 || this.handoffQueue.offer(t)) {
                return;
            }
            if ((i & 255) == 255 || (i3 > 1 && i % i3 == 0)) {
                LockSupport.parkNanos(TimeUnit.MICROSECONDS.toNanos(10L));
            } else {
                Thread.yield();
            }
            i++;
            i2 = this.waiters.get();
        }
    }

    public int getWaitingThreadCount() {
        return this.waiters.get();
    }

    public int getCount(int i) {
        int i2 = 0;
        Iterator<T> it = this.sharedList.iterator();
        while (it.hasNext()) {
            if (it.next().getState() == i) {
                i2++;
            }
        }
        return i2;
    }

    public int[] getStateCounts() {
        int[] iArr = new int[6];
        Iterator<T> it = this.sharedList.iterator();
        while (it.hasNext()) {
            int state = it.next().getState();
            iArr[state] = iArr[state] + 1;
        }
        iArr[4] = this.sharedList.size();
        iArr[5] = this.waiters.get();
        return iArr;
    }

    public int size() {
        return this.sharedList.size();
    }

    public void dumpState() {
        this.sharedList.forEach(iConcurrentBagEntry -> {
            LOGGER.info(iConcurrentBagEntry.toString());
        });
    }

    private boolean useWeakThreadLocals() {
        try {
            if (System.getProperty("me.ulrich.clans.library.hikari.useWeakReferences") != null) {
                return Boolean.getBoolean("me.ulrich.clans.library.hikari.useWeakReferences");
            }
            return getClass().getClassLoader() != ClassLoader.getSystemClassLoader();
        } catch (SecurityException e) {
            return true;
        }
    }
}
