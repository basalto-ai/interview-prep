package xyz.basalto.interprep.ds;

import java.util.*;

/**
 * A singly linked list implementation.
 * Explicitly set the public access modifier to the class for the sake of the test.
 * @param <T>
 */
public class XyzSinglyLinkedList<T> implements List<T> {

    public XyzSingleLinkedNode<T> head;
    public XyzSingleLinkedNode<T> tail;
    public int size;

    public XyzSinglyLinkedList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
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
        return indexOf(o) >= 0;
    }

    @Override
    public boolean add(T t) {
        XyzSingleLinkedNode<T> newNode = new XyzSingleLinkedNode<>(t);
        if (tail == null) {
            head = newNode;
            tail = head;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (head == null) return false;

        // If the head node needs to be removed.
        if (Objects.equals(head.data, o)) {
            head = head.next;
            if (head == null) {
                tail = null;
            }
            size--;
            return true;
        }

        // Traverse the list to find the node to remove.
        XyzSingleLinkedNode<T> current = head;
        while (current.next != null) {
            if (Objects.equals(current.next.data, o)) {
                current.next = current.next.next;
                if (current.next == null) {
                    tail = current;
                }
                size--;
                return true;
            }
            current = current.next;
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
        if (c.isEmpty()) return false;

        // Create nodes for new elements
        XyzSingleLinkedNode<T> firstNewNode = new XyzSingleLinkedNode<>(null);
        XyzSingleLinkedNode<T> lastNewNode = firstNewNode;

        for (T element : c) {
            lastNewNode.next = new XyzSingleLinkedNode<>(element);
            lastNewNode = lastNewNode.next;
        }

        firstNewNode = firstNewNode.next;

        if (head == null) {
            head = firstNewNode;
            tail = lastNewNode;
        } else {
            tail.next = firstNewNode;
            tail = lastNewNode;
        }

        // Update the size
        size += c.size();
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        // Validate index and handle empty collection
        checkIndexForAdd(index);
        if (c.isEmpty()) {
            return false;
        }

        XyzSingleLinkedNode<T> firstNewNode = new XyzSingleLinkedNode<>(null);
        XyzSingleLinkedNode<T> lastNewNode = firstNewNode;

        for (T element : c) {
            lastNewNode.next = new XyzSingleLinkedNode<>(element);
            lastNewNode = lastNewNode.next;
        }

        // Skip the dummy node to get the actual first new node
        firstNewNode = firstNewNode.next;

        // Insert the new nodes into the existing list
        if (index == 0) {
            lastNewNode.next = head;
            head = firstNewNode;
            if (tail == null) {
                tail = lastNewNode;
            }
        } else {
            XyzSingleLinkedNode<T> prevNode = getNode(index - 1);
            lastNewNode.next = prevNode.next;
            prevNode.next = firstNewNode;

            if (lastNewNode.next == null) {
                tail = lastNewNode;
            }
        }

        // Update size
        size += c.size();
        return true;
    }


    @Override
    public boolean removeAll(Collection<?> c) {
        boolean modified = false;
        for (Object e : c) {
            while (remove(e)) {
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean modified = false;
        XyzSingleLinkedNode<T> current = head;
        XyzSingleLinkedNode<T> previous = null;

        while(current != null){
            if (!c.contains(current.data)){
                if (current == head){
                    head = current.next;
                } else {
                    // remove current
                    previous.next = current.next;
                }
                if (current == tail){
                    tail = previous;
                }
                size--;
                modified = true;
            } else {
                previous = current;
            }
            current = current.next;
        }
        return modified;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public T get(int index) {
        // Validate that the index is within bounds.
        checkIndex(index);

        // Traverse the list
        XyzSingleLinkedNode<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        // Return the data at the specified index.
        return current.data;
    }

    @Override
    public T set(int index, T element) {
        checkIndex(index);
        XyzSingleLinkedNode<T> node = getNode(index);
        T oldValue = node.data;
        node.data = element;
        return oldValue;
    }

    @Override
    public void add(int index, T element) {
        // Check if the index is valid for adding a new element.
        checkIndexForAdd(index);

        // Create a new node for the element.
        XyzSingleLinkedNode<T> newNode = new XyzSingleLinkedNode<>(element);

        // If adding at the head (index 0).
        if (index == 0) {
            newNode.next = head;
            head = newNode;
            if (tail == null) {
                tail = newNode;
            }
        } else {
            XyzSingleLinkedNode<T> previous = getNode(index - 1);
            newNode.next = previous.next;
            previous.next = newNode;
            if (newNode.next == null) {
                tail = newNode;
            }
        }

        // Increment the size
        size++;
    }

    @Override
    public T remove(int index) {
        checkIndex(index);

        XyzSingleLinkedNode<T> removedNode;
        if (index == 0) {
            removedNode = head;
            head = head.next;
            if (head == null) {
                tail = null;
            }
        } else {
            XyzSingleLinkedNode<T> previous = getNode(index - 1);
            removedNode = previous.next;
            previous.next = removedNode.next;
            if (removedNode.next == null) {
                tail = previous;
            }
        }
        size--;
        return removedNode.data;
    }

    @Override
    public int indexOf(Object o) {
        int index = 0;
        for (XyzSingleLinkedNode<T> current = head; current != null; current = current.next) {
            if (Objects.equals(current.data, o)) {
                return index;
            }
            index++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        int lastIndex = -1;
        int index = 0;
        for (XyzSingleLinkedNode<T> current = head; current != null; current = current.next) {
            if (Objects.equals(current.data, o)) {
                lastIndex = index;
            }
            index++;
        }
        return lastIndex;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        if (fromIndex < 0 || toIndex > size || fromIndex > toIndex) {
            throw new IndexOutOfBoundsException("Index out of bounds for subList operation.");
        }

        XyzSinglyLinkedList<T> subList = new XyzSinglyLinkedList<>();

        if (fromIndex == toIndex) {
            return subList;
        }

        XyzSingleLinkedNode<T> current = head;
        for (int i = 0; i < fromIndex; i++) {
            current = current.next;
        }

        // Add elements from fromIndex to toIndex to the subList
        for (int i = fromIndex; i < toIndex; i++) {
            subList.add(current.data);
            current = current.next;
        }

        return subList;
    }


    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
    }

    private void checkIndexForAdd(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds for add: " + index);
        }
    }

    private XyzSingleLinkedNode<T> getNode(int index) {
        checkIndex(index);
        XyzSingleLinkedNode<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];
        int index = 0;
        for (XyzSingleLinkedNode<T> current = head; current != null; current = current.next) {
            result[index] = current.data;
            index++;
        }

        return result;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        if (a.length < size) {
            return (T[]) Arrays.copyOf(toArray(), size, a.getClass());
        }
        System.arraycopy(toArray(), 0, a, 0, size);
        if (a.length > size) {
            a[size] = null;
        }
        return a;
    }

    @Override
    public ListIterator<T> listIterator() {
        throw new UnsupportedOperationException("Operation not supported");
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        throw new UnsupportedOperationException("Operation not supported");
    }

}
