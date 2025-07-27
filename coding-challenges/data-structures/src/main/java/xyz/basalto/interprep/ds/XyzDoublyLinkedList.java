package xyz.basalto.interprep.ds;

import java.util.*;

public class XyzDoublyLinkedList<T> implements List<T> {

    private XyzDoublyLinkedNode<T> head;
    private XyzDoublyLinkedNode<T> tail;
    private int size;

    public XyzDoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * Returns the head node of the linked list.
     *
     * <p><b>Warning:</b> This method is exposed for testing and development purposes only.
     * Exposing internal structure is generally not recommended as it may lead to unintended side effects.</p>
     *
     * @return The head node of the linked list, or {@code null} if the list is empty.
     */
    public XyzDoublyLinkedNode<T> getHead() {
        return head;
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
    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private XyzDoublyLinkedNode<T> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T data = current.data;
                current = current.next;
                return data;
            }
        };
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        XyzDoublyLinkedNode<T> current = head;
        int index = 0;
        while (current != null) {
            array[index++] = current.data;
            current = current.next;
        }
        return array;
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        if (a.length < size) {
            a = (T1[]) java.lang.reflect.Array.newInstance(a.getClass().getComponentType(), size);
        }
        XyzDoublyLinkedNode<T> current = head;
        int index = 0;
        Object[] result = a;
        while (current != null) {
            result[index++] = current.data;
            current = current.next;
        }
        if (a.length > size) {
            a[size] = null;
        }
        return a;
    }

    @Override
    public boolean add(T t) {
        XyzDoublyLinkedNode<T> newNode = new XyzDoublyLinkedNode<>(t);
        if (head == null) {
            head = newNode;
            tail = head;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        XyzDoublyLinkedNode<T> start = head;
        XyzDoublyLinkedNode<T> end = tail;
        while (start != null && end != null && start != end && start.prev != end) {
            if (Objects.equals(start.data, o)) {
                removeNode(start);
                return true;
            }
            if (Objects.equals(end.data, o)) {
                removeNode(end);
                return true;
            }
            start = start.next;
            end = end.prev;
        }
        // Handle the case where start == end (middle element)
        if (start == end && Objects.equals(start.data, o)) {
            removeNode(start);
            return true;
        }
        return false;
    }

    private void removeNode(XyzDoublyLinkedNode<T> node) {
        if (node == head) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            } else {
                tail = null; // List becomes empty
            }
        } else if (node == tail) {
            tail = tail.prev;
            tail.next = null;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        size--;
    }


    @Override
    public T get(int index) {
        checkIndex(index);
        return getNode(index).data;
    }

    @Override
    public T set(int index, T element) {
        checkIndex(index);
        XyzDoublyLinkedNode<T> node = getNode(index);
        T oldValue = node.data;
        node.data = element;
        return oldValue;
    }

    @Override
    public void add(int index, T element) {
        if (index == size) {
            add(element);
            return;
        }
        checkIndexForAdd(index);

        XyzDoublyLinkedNode<T> newNode = new XyzDoublyLinkedNode<>(element);

        if (index == 0) {
            newNode.next = head;
            if (head != null) {
                head.prev = newNode;
            }
            head = newNode;
            if (tail == null) {
                tail = head;
            }
        } else {
            XyzDoublyLinkedNode<T> nextNode = getNode(index);
            XyzDoublyLinkedNode<T> prevNode = nextNode.prev;

            newNode.next = nextNode;
            newNode.prev = prevNode;

            if (prevNode != null) {
                prevNode.next = newNode;
            }
            nextNode.prev = newNode;
        }
        size++;
    }

    @Override
    public T remove(int index) {
        checkIndex(index);

        XyzDoublyLinkedNode<T> nodeToRemove = getNode(index);
        T data = nodeToRemove.data;
        removeNode(nodeToRemove);
        return data;
    }

    @Override
    public int indexOf(Object o) {
        XyzDoublyLinkedNode<T> current = head;
        int index = 0;
        while (current != null) {
            if (Objects.equals(current.data, o)) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        XyzDoublyLinkedNode<T> current = tail;
        int index = size - 1;
        while (current != null) {
            if (Objects.equals(current.data, o)) {
                return index;
            }
            current = current.prev;
            index--;
        }
        return -1;
    }

    @Override
    public ListIterator<T> listIterator() {
        throw new UnsupportedOperationException("listIterator() is not supported.");
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        throw new UnsupportedOperationException("listIterator(int index) is not supported.");
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException("subList() is not supported.");
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object o : c) {
            if (!contains(o)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        for (T t : c) {
            add(t);
        }
        return !c.isEmpty();
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        checkIndexForAdd(index);
        int currentIndex = index;
        for (T t : c) {
            add(currentIndex++, t);
        }
        return !c.isEmpty();
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean modified = false;
        for (Object o : c) {
            while (remove(o)) {
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean modified = false;
        XyzDoublyLinkedNode<T> current = head;
        while (current != null) {
            if (!c.contains(current.data)) {
                XyzDoublyLinkedNode<T> toRemove = current;
                current = current.next;
                remove(toRemove.data);
                modified = true;
            } else {
                current = current.next;
            }
        }
        return modified;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    private XyzDoublyLinkedNode<T> getNode(int index) {
        checkIndex(index);
        XyzDoublyLinkedNode<T> current;
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.prev;
            }
        }
        return current;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    private void checkIndexForAdd(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

}
