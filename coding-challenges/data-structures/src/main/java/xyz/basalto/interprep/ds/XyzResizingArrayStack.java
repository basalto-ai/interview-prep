package xyz.basalto.interprep.ds;

import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class XyzResizingArrayStack<T> implements Deque<T> {

    private static final int INITIAL_CAPACITY = 10;
    private static final int RESIZE_FACTOR = 2;
    private static final int SHRINK_THRESHOLD = 4;

    private T[] stack;
    private int size;

    public XyzResizingArrayStack() {
        stack = (T[]) new Object[INITIAL_CAPACITY];
        size = 0;
    }

   
    @Override
    public void push(T t) {
        resizeIfNeeded();
        stack[size++] = t;
    }

    @Override
    public T pop() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        T item = stack[--size];
        stack[size] = null;
        resizeIfNeeded();
        return item;
    }

    @Override
    public T peek() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        return stack[size - 1];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

     private void resizeIfNeeded() {
        if (size == stack.length) {
            resize(stack.length * RESIZE_FACTOR);
        } else if (size > 0 && size == stack.length / SHRINK_THRESHOLD) {
            resize(stack.length / RESIZE_FACTOR);
        }
    }

    private void resize(int capacity) {
        T[] copy = (T[]) new Object[capacity];
        System.arraycopy(stack, 0, copy, 0, size);
        stack = copy;
    }

    // Unsupported operations
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
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean contains(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object[] toArray() {
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
