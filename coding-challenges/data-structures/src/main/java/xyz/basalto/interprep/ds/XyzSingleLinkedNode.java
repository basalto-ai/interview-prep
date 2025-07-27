package xyz.basalto.interprep.ds;

/**
 * Represents a node in a singly linked list.
 *
 * <p><b>Warning:</b> Public fields are for development and testing only. Avoid using them in production.</p>
 *
 * @param <T> The type of value held by this node.
 */
public class XyzSingleLinkedNode<T> {

    /** The value stored in this node. */
    public T data;

    /** Reference to the next node in the linked list. */
    public XyzSingleLinkedNode<T> next;

    /**
     * Constructs a new node with the given data.
     *
     * @param data The value to store in the node.
     */
    public XyzSingleLinkedNode(T data) {
        this.data = data;
        this.next = null;
    }

}
