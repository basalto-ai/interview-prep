package xyz.basalto.interprep.ds;

import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class XyzSinglyLinkedStack<T> implements Deque<T> {

    private XyzSingleLinkedNode<T> head;
    private int size;

    public XyzSinglyLinkedStack() {
        head = null;
        size = 0;
    }

    @Override
    public void push(T t) {
        XyzSingleLinkedNode<T> oldHead = head;
        head = new XyzSingleLinkedNode<>(t);
        head.next = oldHead;
        size++;
    }

    @Override
    public T pop() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        T item = head.data;
        head = head.next;
        size--;
        return item;
    }

    @Override
    public T peek() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        return head.data;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for(Object o : c) {
            if (!contains(o)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean contains(Object o) {
        XyzSingleLinkedNode<T> current = head;
        while (current != null) {
            if (Objects.equals(current.data, o)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new XyzSingleLinkedListIterator<>(head);
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        int i = 0;
        for (T item : this) {
            array[i++] = item;
        }
        return array;
    }

    /**
     * Iterator implementation for singly linked list
     */
    private static class XyzSingleLinkedListIterator<T> implements Iterator<T> {
        private XyzSingleLinkedNode<T> current;

        public XyzSingleLinkedListIterator(XyzSingleLinkedNode<T> head) {
            current = head;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if (!hasNext()) throw new NoSuchElementException();
            T item = current.data;
            current = current.next;
            return item;
        }
    }

    /**
     * Unsupported operations
     */

    @Override
    public void addFirst(T t) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void addLast(T t) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean offerFirst(T t) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean offerLast(T t) {
        throw new UnsupportedOperationException();
    }

    @Override
    public T removeFirst() {
        throw new UnsupportedOperationException();
    }

    @Override
    public T removeLast() {
        throw new UnsupportedOperationException();
    }

    @Override
    public T pollFirst() {
        throw new UnsupportedOperationException();
    }

    @Override
    public T pollLast() {
        throw new UnsupportedOperationException();
    }

    @Override
    public T getFirst() {
        throw new UnsupportedOperationException();
    }

    @Override
    public T getLast() {
        throw new UnsupportedOperationException();
    }

    @Override
    public T peekFirst() {
        throw new UnsupportedOperationException();
    }

    @Override
    public T peekLast() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeFirstOccurrence(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeLastOccurrence(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean add(T t) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean offer(T t) {
        throw new UnsupportedOperationException();
    }

    @Override
    public T remove() {
        throw new UnsupportedOperationException();
    }

    @Override
    public T poll() {
        throw new UnsupportedOperationException();
    }

    @Override
    public T element() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<T> descendingIterator() {
        throw new UnsupportedOperationException();
    }

}
