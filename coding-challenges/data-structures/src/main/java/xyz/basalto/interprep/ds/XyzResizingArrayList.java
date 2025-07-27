package xyz.basalto.interprep.ds;

import java.util.*;

public class XyzResizingArrayList<T> implements List<T> {

    private static final int INITIAL_CAPACITY = 10;

    private T[] data;
    private int size;

    public XyzResizingArrayList(){
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
        return indexOf(o) >= 0;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(data, size);
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean add(T element) {
        ensureCapacity(size + 1);
        data[size++] = element;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        int index = indexOf(o);
        if (index >= 0) {
            remove(index);
            return true;
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
        checkIndexForAdd(size + c.size());
        for (T element : c) {
            add(element);
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        checkIndexForAdd(index);
        ensureCapacity(size + c.size());
        // Shift elements to make room for new elements
        System.arraycopy(data, index, data, index + c.size(), size - index);
        for (T element : c) {
            data[index++] = element;
        }
        size += c.size();
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
        return modified;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean modified = false;
        for(int i = 0; i < size; i++){
            if(!c.contains(data[i])){
                remove(i);
                i--;
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            data[i] = null;
        }
        size = 0;
    }

    @Override
    public T get(int index) {
        checkIndex(index);
        return data[index];
    }

    @Override
    public T set(int index, T element) {
        checkIndex(index);
        T oldElement = data[index];
        data[index] = element;
        return oldElement;
    }

    @Override
    public void add(int index, T element) {
        checkIndex(index);
        ensureCapacity(size + 1);

        // Shift elements to the right to make room for the new element
        System.arraycopy(data, index, data, index + 1, size - index);
        data[index] = element;
        size++;
    }

    @Override
    public T remove(int index) {
        checkIndex(index);
        T removedElement = data[index];

        // Shift elements to the left to fill the gap
        System.arraycopy(data, index + 1, data, index, size - index - 1);
        size--;
        data[size] = null; // Clear the last element
        return removedElement;
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(data[i], o)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        for (int i = size - 1; i >= 0; i--) {
            if (Objects.equals(data[i], o)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public ListIterator<T> listIterator() {
        throw new UnsupportedOperationException("listIterator not supported");
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        throw new UnsupportedOperationException("listIterator not supported");
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        checkIndexForAdd(fromIndex);
        checkIndexForAdd(toIndex);
        if (fromIndex > toIndex) {
            throw new IllegalArgumentException("fromIndex cannot be greater than toIndex");
        }

        XyzResizingArrayList<T> subList = new XyzResizingArrayList<>();
        for (int i = fromIndex; i < toIndex; i++) {
            subList.add(data[i]);
        }
        return subList;
    }

    @Override
    public Iterator<T> iterator() {
        return new XYZIterator();
    }

    // Helper method to ensure capacity is enough
    public void ensureCapacity(int minCapacity) {
        if (minCapacity > data.length) {
            int newCapacity = Math.max(data.length + (data.length / 2), minCapacity);
            resize(newCapacity);
        }
    }

    // Check if the index is valid for getting or setting an element
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
    }

    // Check if the index is valid for adding an element
    private void checkIndexForAdd(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds for add: " + index);
        }
    }

    // Resize the internal array to a new capacity
    private void resize(int newCapacity) {
        T[] newData = (T[]) new Object[newCapacity];
        System.arraycopy(data, 0, newData, 0, size);
        data = newData;
    }

    private class XYZIterator implements Iterator<T> {

        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < size;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return data[currentIndex++];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Remove operation is not supported.");
        }
    }

}
