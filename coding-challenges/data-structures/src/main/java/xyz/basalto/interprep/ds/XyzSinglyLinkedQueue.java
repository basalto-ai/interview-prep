package xyz.basalto.interprep.ds;

import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import java.util.Queue;

/**
 * A singly linked queue implementation.
 *
 * <p><b>Warning:</b> Public fields are for development and testing only. Avoid using them in production.</p>
 *
 * @param <T> The type of elements held by this queue.
 */
public class XyzSinglyLinkedQueue<T> implements Queue<T> {

    public int size;
    public XyzSingleLinkedNode<T> head;
    public XyzSingleLinkedNode<T> tail;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        XyzSingleLinkedNode<T> node = head;
        while (node != null) {
            if (Objects.equals(node.data, o)) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    @Override
    public boolean remove(Object o) {
        XyzSingleLinkedNode<T> prev = null;
        XyzSingleLinkedNode<T> curr = head;
        
        while (curr != null) {
            if (Objects.equals(curr.data, o)) {
                if (prev == null) {
                    // remove the head element
                    head = curr.next;
                } else {
                    prev.next = curr.next;
                }
                size--;
                return true;
            }
            prev = curr;
            curr = curr.next;
        }

        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object e : c) {
            if (!contains(e)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        for (T e : c) {
            add(e);
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean modified = false;
        for (Object e : c) {
            modified |= remove(e);
        }
        return modified;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean modified = false;
        XyzSingleLinkedNode<T> prev = null;
        XyzSingleLinkedNode<T> curr = head;

        while (curr != null) {
            if (!c.contains(curr.data)) {
                if (prev == null) {
                    head = curr.next;
                } else {
                    prev.next = curr.next;
                }
                size--;
                modified = true;
            } else {
                prev = curr;
            }
            curr = curr.next;
        }
        
        return modified;
    }

    @Override
    public void clear() {
        this.size = 0;
        this.head = null;
        this.tail = null;
    }

    @Override
    public boolean add(T e) {
        if (!offer(e)) {
            throw new IllegalStateException("Queue full");
        }
        return true;
    }

    @Override
    public boolean offer(T e) {
        XyzSingleLinkedNode<T> newNode = new XyzSingleLinkedNode<>(e);
        if (head == null) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
        size++;
        return true;
    }

    @Override
    public T remove() {
        if (head == null) {
            throw new IllegalStateException("Queue is empty");
        }

        T data = head.data;
        head = head.next;
        size--;

        if (size == 0) {
            tail = null;
        }

        return data;
    }

    @Override
    public T poll() {
        if(head == null) {
            return null;
        }
        T data = head.data;
        head = head.next;
        size--;

        if(size == 0) {
            tail = null;
        }

        return data;
    }

    @Override
    public T element() {
        if (head == null) {
            throw new IllegalStateException("Queue is empty");
        }
        return head.data;
    }

    @Override
    public T peek() {
        if (head == null) {
            return null; 
        }
        return head.data;
    }

    
    @Override
    public Iterator<T> iterator() {
        return new XyzSingleLinkedQueueIterator();
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        XyzSingleLinkedNode<T> node = head;
        for (int i = 0; i < size; i++) {
            array[i] = node.data;
            node = node.next;
        }
        return array;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException("toArray(T[] a) not supported");
    }        

    // iterator
    private class XyzSingleLinkedQueueIterator implements Iterator<T> {

        private XyzSingleLinkedNode<T> current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            T data = current.data;
            current = current.next;
            return data;
        }
    }

}
