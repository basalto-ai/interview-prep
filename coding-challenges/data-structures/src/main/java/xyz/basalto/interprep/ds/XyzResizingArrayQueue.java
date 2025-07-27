package xyz.basalto.interprep.ds;

import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import java.util.Queue;
import java.util.stream.Stream;

public class XyzResizingArrayQueue<T> implements Queue<T> {

    private static final int INITIAL_CAPACITY = 10;
    private static final int RESIZE_FACTOR = 2;
    private static final int SHRINK_THRESHOLD = 4;
    
    private T[] data;
    private int size;

    public XyzResizingArrayQueue(){
        data = (T[]) new Object[INITIAL_CAPACITY];
        size = 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public boolean contains(Object o) {
        for (T t : data) {
            if(Objects.equals(t, o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(data[i], o)) {
                // left shift elements to fill the gap
                for (int j = i; j < size - 1; j++) {
                    data[j] = data[j + 1];
                }
                size--;
                data[size] = null;
                shrink(); 
                return true;
            }
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
        for(Object e: c){
            while(contains(e)){
                remove(e);
                modified = true;
            }
        }
        shrink(); 
        return modified;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean modified = false;
        for (int i = 0; i < size; ) {
            if (!c.contains(data[i])) {
                remove(data[i]);
                modified = true;
            } else {
                i++;
            }
        }
        return modified;
    }

    @Override
    public void clear() {
        this.data = (T[]) new Object[INITIAL_CAPACITY];
        this.size = 0;
    }

    @Override
    public boolean add(T e) {
        if(!offer(e)) {
            throw new IllegalStateException("Queue full");
        }
        return true;
    }

    @Override
    public boolean offer(T e) {
        ensureCapacity(size + 1);
        data[size++] = e;
        return true;
    }

    @Override
    public T remove() {
        if(isEmpty()) {
            throw new IllegalStateException("Queue empty");
        }
        T element = data[0];
        return element;
    }

    @Override
    public T poll() {
        if(isEmpty()) return null;
        T element = data[0];
        // left shift elements to fill the gap
        for (int i = 0; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
        data[size] = null;
        return element;
    }

    @Override
    public T element() {
        if(isEmpty()) throw new IllegalStateException("Queue empty");
        return data[0];
    }

    @Override
    public T peek() {
        if(isEmpty()) return null;
        return data[0];
    }

    @Override
    public Iterator<T> iterator() {
        return new XyzResizingArrayQueueIterator();
    }

    @Override
    public Object[] toArray() {
        return Stream.of(data).limit(size).toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toArray'");
    }

    // Ensure capacity of the array
    private void ensureCapacity(int capacity) {
        if (capacity > data.length) {
            int newCapacity = data.length * RESIZE_FACTOR;
            if (newCapacity < capacity) {
                newCapacity = capacity;
            }
            T[] newData = (T[]) new Object[newCapacity];
            System.arraycopy(data, 0, newData, 0, size);
            data = newData;
        }
    }

    // Shrink the array if necessary
    private void shrink() {
        if (size < data.length / SHRINK_THRESHOLD && data.length > INITIAL_CAPACITY) {
            int newCapacity = data.length / RESIZE_FACTOR;
            T[] newData = (T[]) new Object[newCapacity];
            System.arraycopy(data, 0, newData, 0, size);
            data = newData;
        }
    }


    // Default iterator or Queue
    private class XyzResizingArrayQueueIterator implements Iterator<T> {
        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public T next() {
            T element = data[index];
            index++;
            return element;
        }
    }

}
