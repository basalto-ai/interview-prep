package xyz.basalto.interprep.ds;

public class XyzDoublyLinkedNode<T> {

    public T data;
    public XyzDoublyLinkedNode<T> next;
    public XyzDoublyLinkedNode<T> prev;

    public XyzDoublyLinkedNode(T data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
