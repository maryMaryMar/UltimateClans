package org.apache.commons.pool2.impl;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.time.Duration;
import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:org/apache/commons/pool2/impl/LinkedBlockingDeque.class */
class LinkedBlockingDeque<E> extends AbstractQueue<E> implements Serializable, Deque<E> {
    private static final long serialVersionUID = -387911632671998426L;
    private transient Node<E> first;
    private transient Node<E> last;
    private transient int count;
    private final int capacity;
    private final InterruptibleReentrantLock lock;
    private final Condition notEmpty;
    private final Condition notFull;

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:org/apache/commons/pool2/impl/LinkedBlockingDeque$AbstractItr.class */
    private abstract class AbstractItr implements Iterator<E> {
        Node<E> next;
        E nextItem;
        private Node<E> lastRet;

        AbstractItr() {
            LinkedBlockingDeque.this.lock.lock();
            try {
                this.next = firstNode();
                this.nextItem = this.next == null ? null : this.next.item;
            } finally {
                LinkedBlockingDeque.this.lock.unlock();
            }
        }

        void advance() {
            LinkedBlockingDeque.this.lock.lock();
            try {
                this.next = succ(this.next);
                this.nextItem = this.next == null ? null : this.next.item;
            } finally {
                LinkedBlockingDeque.this.lock.unlock();
            }
        }

        abstract Node<E> firstNode();

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.next != null;
        }

        @Override // java.util.Iterator
        public E next() {
            if (this.next == null) {
                throw new NoSuchElementException();
            }
            this.lastRet = this.next;
            E e = this.nextItem;
            advance();
            return e;
        }

        abstract Node<E> nextNode(Node<E> node);

        @Override // java.util.Iterator
        public void remove() {
            Node<E> node = this.lastRet;
            if (node == null) {
                throw new IllegalStateException();
            }
            this.lastRet = null;
            LinkedBlockingDeque.this.lock.lock();
            try {
                if (node.item != null) {
                    LinkedBlockingDeque.this.unlink(node);
                }
            } finally {
                LinkedBlockingDeque.this.lock.unlock();
            }
        }

        private Node<E> succ(Node<E> node) {
            while (true) {
                Node<E> nodeNextNode = nextNode(node);
                if (nodeNextNode == null) {
                    return null;
                }
                if (nodeNextNode.item != null) {
                    return nodeNextNode;
                }
                if (nodeNextNode == node) {
                    return firstNode();
                }
                node = nodeNextNode;
            }
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:org/apache/commons/pool2/impl/LinkedBlockingDeque$DescendingItr.class */
    private class DescendingItr extends AbstractItr {
        private DescendingItr() {
            super();
        }

        @Override // org.apache.commons.pool2.impl.LinkedBlockingDeque.AbstractItr
        Node<E> firstNode() {
            return LinkedBlockingDeque.this.last;
        }

        @Override // org.apache.commons.pool2.impl.LinkedBlockingDeque.AbstractItr
        Node<E> nextNode(Node<E> node) {
            return node.prev;
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:org/apache/commons/pool2/impl/LinkedBlockingDeque$Itr.class */
    private class Itr extends AbstractItr {
        private Itr() {
            super();
        }

        @Override // org.apache.commons.pool2.impl.LinkedBlockingDeque.AbstractItr
        Node<E> firstNode() {
            return LinkedBlockingDeque.this.first;
        }

        @Override // org.apache.commons.pool2.impl.LinkedBlockingDeque.AbstractItr
        Node<E> nextNode(Node<E> node) {
            return node.next;
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:org/apache/commons/pool2/impl/LinkedBlockingDeque$Node.class */
    private static final class Node<E> {
        E item;
        Node<E> prev;
        Node<E> next;

        Node(E e, Node<E> node, Node<E> node2) {
            this.item = e;
            this.prev = node;
            this.next = node2;
        }
    }

    public LinkedBlockingDeque() {
        this(Integer.MAX_VALUE);
    }

    public LinkedBlockingDeque(boolean z) {
        this(Integer.MAX_VALUE, z);
    }

    public LinkedBlockingDeque(Collection<? extends E> collection) {
        this(Integer.MAX_VALUE);
        this.lock.lock();
        try {
            for (E e : collection) {
                Objects.requireNonNull(e);
                if (!linkLast(e)) {
                    throw new IllegalStateException("Deque full");
                }
            }
            this.lock.unlock();
        } catch (Throwable th) {
            this.lock.unlock();
            throw th;
        }
    }

    public LinkedBlockingDeque(int i) {
        this(i, false);
    }

    public LinkedBlockingDeque(int i, boolean z) {
        if (i <= 0) {
            throw new IllegalArgumentException();
        }
        this.capacity = i;
        this.lock = new InterruptibleReentrantLock(z);
        this.notEmpty = this.lock.newCondition();
        this.notFull = this.lock.newCondition();
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection, java.util.Queue, java.util.Deque
    public boolean add(E e) {
        addLast(e);
        return true;
    }

    @Override // java.util.Deque
    public void addFirst(E e) {
        if (!offerFirst(e)) {
            throw new IllegalStateException("Deque full");
        }
    }

    @Override // java.util.Deque
    public void addLast(E e) {
        if (!offerLast(e)) {
            throw new IllegalStateException("Deque full");
        }
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        this.lock.lock();
        try {
            Node<E> node = this.first;
            while (node != null) {
                node.item = null;
                Node<E> node2 = node.next;
                node.prev = null;
                node.next = null;
                node = node2;
            }
            this.last = null;
            this.first = null;
            this.count = 0;
            this.notFull.signalAll();
        } finally {
            this.lock.unlock();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Deque
    public boolean contains(Object obj) {
        if (obj == null) {
            return false;
        }
        this.lock.lock();
        try {
            for (Node<E> node = this.first; node != null; node = node.next) {
                if (obj.equals(node.item)) {
                    this.lock.unlock();
                    return true;
                }
            }
            this.lock.unlock();
            return false;
        } catch (Throwable th) {
            this.lock.unlock();
            throw th;
        }
    }

    @Override // java.util.Deque
    public Iterator<E> descendingIterator() {
        return new DescendingItr();
    }

    public int drainTo(Collection<? super E> collection) {
        return drainTo(collection, Integer.MAX_VALUE);
    }

    public int drainTo(Collection<? super E> collection, int i) {
        Objects.requireNonNull(collection, "c");
        if (collection == this) {
            throw new IllegalArgumentException();
        }
        this.lock.lock();
        try {
            int iMin = Math.min(i, this.count);
            for (int i2 = 0; i2 < iMin; i2++) {
                collection.add(this.first.item);
                unlinkFirst();
            }
            this.lock.unlock();
            return iMin;
        } catch (Throwable th) {
            this.lock.unlock();
            throw th;
        }
    }

    @Override // java.util.AbstractQueue, java.util.Queue, java.util.Deque
    public E element() {
        return getFirst();
    }

    @Override // java.util.Deque
    public E getFirst() {
        E ePeekFirst = peekFirst();
        if (ePeekFirst == null) {
            throw new NoSuchElementException();
        }
        return ePeekFirst;
    }

    @Override // java.util.Deque
    public E getLast() {
        E ePeekLast = peekLast();
        if (ePeekLast == null) {
            throw new NoSuchElementException();
        }
        return ePeekLast;
    }

    public int getTakeQueueLength() {
        this.lock.lock();
        try {
            return this.lock.getWaitQueueLength(this.notEmpty);
        } finally {
            this.lock.unlock();
        }
    }

    public boolean hasTakeWaiters() {
        this.lock.lock();
        try {
            return this.lock.hasWaiters(this.notEmpty);
        } finally {
            this.lock.unlock();
        }
    }

    public void interuptTakeWaiters() {
        this.lock.lock();
        try {
            this.lock.interruptWaiters(this.notEmpty);
        } finally {
            this.lock.unlock();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Deque
    public Iterator<E> iterator() {
        return new Itr();
    }

    private boolean linkFirst(E e) {
        if (this.count >= this.capacity) {
            return false;
        }
        Node<E> node = this.first;
        Node<E> node2 = new Node<>(e, null, node);
        this.first = node2;
        if (this.last == null) {
            this.last = node2;
        } else {
            node.prev = node2;
        }
        this.count++;
        this.notEmpty.signal();
        return true;
    }

    private boolean linkLast(E e) {
        if (this.count >= this.capacity) {
            return false;
        }
        Node<E> node = this.last;
        Node<E> node2 = new Node<>(e, node, null);
        this.last = node2;
        if (this.first == null) {
            this.first = node2;
        } else {
            node.next = node2;
        }
        this.count++;
        this.notEmpty.signal();
        return true;
    }

    @Override // java.util.Queue, java.util.Deque
    public boolean offer(E e) {
        return offerLast(e);
    }

    boolean offer(E e, Duration duration) {
        return offerLast(e, duration);
    }

    public boolean offer(E e, long j, TimeUnit timeUnit) {
        return offerLast(e, j, timeUnit);
    }

    @Override // java.util.Deque
    public boolean offerFirst(E e) {
        Objects.requireNonNull(e, "e");
        this.lock.lock();
        try {
            return linkFirst(e);
        } finally {
            this.lock.unlock();
        }
    }

    public boolean offerFirst(E e, Duration duration) {
        Objects.requireNonNull(e, "e");
        long nanos = duration.toNanos();
        this.lock.lockInterruptibly();
        while (!linkFirst(e)) {
            try {
                if (nanos <= 0) {
                    this.lock.unlock();
                    return false;
                }
                nanos = this.notFull.awaitNanos(nanos);
            } catch (Throwable th) {
                this.lock.unlock();
                throw th;
            }
        }
        this.lock.unlock();
        return true;
    }

    public boolean offerFirst(E e, long j, TimeUnit timeUnit) {
        return offerFirst(e, PoolImplUtils.toDuration(j, timeUnit));
    }

    @Override // java.util.Deque
    public boolean offerLast(E e) {
        Objects.requireNonNull(e, "e");
        this.lock.lock();
        try {
            return linkLast(e);
        } finally {
            this.lock.unlock();
        }
    }

    boolean offerLast(E e, Duration duration) {
        Objects.requireNonNull(e, "e");
        long nanos = duration.toNanos();
        this.lock.lockInterruptibly();
        while (!linkLast(e)) {
            try {
                if (nanos <= 0) {
                    this.lock.unlock();
                    return false;
                }
                nanos = this.notFull.awaitNanos(nanos);
            } catch (Throwable th) {
                this.lock.unlock();
                throw th;
            }
        }
        this.lock.unlock();
        return true;
    }

    public boolean offerLast(E e, long j, TimeUnit timeUnit) {
        return offerLast(e, PoolImplUtils.toDuration(j, timeUnit));
    }

    @Override // java.util.Queue, java.util.Deque
    public E peek() {
        return peekFirst();
    }

    @Override // java.util.Deque
    public E peekFirst() {
        this.lock.lock();
        try {
            return this.first == null ? null : this.first.item;
        } finally {
            this.lock.unlock();
        }
    }

    @Override // java.util.Deque
    public E peekLast() {
        this.lock.lock();
        try {
            return this.last == null ? null : this.last.item;
        } finally {
            this.lock.unlock();
        }
    }

    @Override // java.util.Queue, java.util.Deque
    public E poll() {
        return pollFirst();
    }

    E poll(Duration duration) {
        return pollFirst(duration);
    }

    public E poll(long j, TimeUnit timeUnit) {
        return pollFirst(j, timeUnit);
    }

    @Override // java.util.Deque
    public E pollFirst() {
        this.lock.lock();
        try {
            return unlinkFirst();
        } finally {
            this.lock.unlock();
        }
    }

    E pollFirst(Duration duration) {
        long nanos = duration.toNanos();
        this.lock.lockInterruptibly();
        while (true) {
            try {
                E eUnlinkFirst = unlinkFirst();
                if (eUnlinkFirst != null) {
                    this.lock.unlock();
                    return eUnlinkFirst;
                }
                if (nanos <= 0) {
                    this.lock.unlock();
                    return null;
                }
                nanos = this.notEmpty.awaitNanos(nanos);
            } catch (Throwable th) {
                this.lock.unlock();
                throw th;
            }
        }
    }

    public E pollFirst(long j, TimeUnit timeUnit) {
        return pollFirst(PoolImplUtils.toDuration(j, timeUnit));
    }

    @Override // java.util.Deque
    public E pollLast() {
        this.lock.lock();
        try {
            return unlinkLast();
        } finally {
            this.lock.unlock();
        }
    }

    public E pollLast(Duration duration) {
        long nanos = duration.toNanos();
        this.lock.lockInterruptibly();
        while (true) {
            try {
                E eUnlinkLast = unlinkLast();
                if (eUnlinkLast != null) {
                    this.lock.unlock();
                    return eUnlinkLast;
                }
                if (nanos <= 0) {
                    this.lock.unlock();
                    return null;
                }
                nanos = this.notEmpty.awaitNanos(nanos);
            } catch (Throwable th) {
                this.lock.unlock();
                throw th;
            }
        }
    }

    public E pollLast(long j, TimeUnit timeUnit) {
        return pollLast(PoolImplUtils.toDuration(j, timeUnit));
    }

    @Override // java.util.Deque
    public E pop() {
        return removeFirst();
    }

    @Override // java.util.Deque
    public void push(E e) {
        addFirst(e);
    }

    public void put(E e) {
        putLast(e);
    }

    public void putFirst(E e) {
        Objects.requireNonNull(e, "e");
        this.lock.lock();
        while (!linkFirst(e)) {
            try {
                this.notFull.await();
            } catch (Throwable th) {
                this.lock.unlock();
                throw th;
            }
        }
        this.lock.unlock();
    }

    public void putLast(E e) {
        Objects.requireNonNull(e, "e");
        this.lock.lock();
        while (!linkLast(e)) {
            try {
                this.notFull.await();
            } catch (Throwable th) {
                this.lock.unlock();
                throw th;
            }
        }
        this.lock.unlock();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.count = 0;
        this.first = null;
        this.last = null;
        while (true) {
            Object object = objectInputStream.readObject();
            if (object == null) {
                return;
            } else {
                add(object);
            }
        }
    }

    public int remainingCapacity() {
        this.lock.lock();
        try {
            return this.capacity - this.count;
        } finally {
            this.lock.unlock();
        }
    }

    @Override // java.util.AbstractQueue, java.util.Queue, java.util.Deque
    public E remove() {
        return removeFirst();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Deque
    public boolean remove(Object obj) {
        return removeFirstOccurrence(obj);
    }

    @Override // java.util.Deque
    public E removeFirst() {
        E ePollFirst = pollFirst();
        if (ePollFirst == null) {
            throw new NoSuchElementException();
        }
        return ePollFirst;
    }

    @Override // java.util.Deque
    public boolean removeFirstOccurrence(Object obj) {
        if (obj == null) {
            return false;
        }
        this.lock.lock();
        try {
            for (Node<E> node = this.first; node != null; node = node.next) {
                if (obj.equals(node.item)) {
                    unlink(node);
                    return true;
                }
            }
            return false;
        } finally {
            this.lock.unlock();
        }
    }

    @Override // java.util.Deque
    public E removeLast() {
        E ePollLast = pollLast();
        if (ePollLast == null) {
            throw new NoSuchElementException();
        }
        return ePollLast;
    }

    @Override // java.util.Deque
    public boolean removeLastOccurrence(Object obj) {
        if (obj == null) {
            return false;
        }
        this.lock.lock();
        try {
            for (Node<E> node = this.last; node != null; node = node.prev) {
                if (obj.equals(node.item)) {
                    unlink(node);
                    return true;
                }
            }
            return false;
        } finally {
            this.lock.unlock();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Deque
    public int size() {
        this.lock.lock();
        try {
            return this.count;
        } finally {
            this.lock.unlock();
        }
    }

    public E take() {
        return takeFirst();
    }

    public E takeFirst() {
        this.lock.lock();
        while (true) {
            try {
                E eUnlinkFirst = unlinkFirst();
                if (eUnlinkFirst != null) {
                    this.lock.unlock();
                    return eUnlinkFirst;
                }
                this.notEmpty.await();
            } catch (Throwable th) {
                this.lock.unlock();
                throw th;
            }
        }
    }

    public E takeLast() {
        this.lock.lock();
        while (true) {
            try {
                E eUnlinkLast = unlinkLast();
                if (eUnlinkLast != null) {
                    this.lock.unlock();
                    return eUnlinkLast;
                }
                this.notEmpty.await();
            } catch (Throwable th) {
                this.lock.unlock();
                throw th;
            }
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public Object[] toArray() {
        this.lock.lock();
        try {
            Object[] objArr = new Object[this.count];
            int i = 0;
            for (Node<E> node = this.first; node != null; node = node.next) {
                int i2 = i;
                i++;
                objArr[i2] = node.item;
            }
            this.lock.unlock();
            return objArr;
        } catch (Throwable th) {
            this.lock.unlock();
            throw th;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        this.lock.lock();
        try {
            if (tArr.length < this.count) {
                tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.count));
            }
            int i = 0;
            for (Node<E> node = this.first; node != null; node = node.next) {
                int i2 = i;
                i++;
                tArr[i2] = node.item;
            }
            if (tArr.length > i) {
                tArr[i] = null;
            }
            return tArr;
        } finally {
            this.lock.unlock();
        }
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        this.lock.lock();
        try {
            return super.toString();
        } finally {
            this.lock.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void unlink(Node<E> node) {
        Node<E> node2 = node.prev;
        Node<E> node3 = node.next;
        if (node2 == null) {
            unlinkFirst();
            return;
        }
        if (node3 == null) {
            unlinkLast();
            return;
        }
        node2.next = node3;
        node3.prev = node2;
        node.item = null;
        this.count--;
        this.notFull.signal();
    }

    private E unlinkFirst() {
        Node<E> node = this.first;
        if (node == null) {
            return null;
        }
        Node<E> node2 = node.next;
        E e = node.item;
        node.item = null;
        node.next = node;
        this.first = node2;
        if (node2 == null) {
            this.last = null;
        } else {
            node2.prev = null;
        }
        this.count--;
        this.notFull.signal();
        return e;
    }

    private E unlinkLast() {
        Node<E> node = this.last;
        if (node == null) {
            return null;
        }
        Node<E> node2 = node.prev;
        E e = node.item;
        node.item = null;
        node.prev = node;
        this.last = node2;
        if (node2 == null) {
            this.first = null;
        } else {
            node2.next = null;
        }
        this.count--;
        this.notFull.signal();
        return e;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        this.lock.lock();
        try {
            objectOutputStream.defaultWriteObject();
            for (Node<E> node = this.first; node != null; node = node.next) {
                objectOutputStream.writeObject(node.item);
            }
            objectOutputStream.writeObject(null);
        } finally {
            this.lock.unlock();
        }
    }
}
