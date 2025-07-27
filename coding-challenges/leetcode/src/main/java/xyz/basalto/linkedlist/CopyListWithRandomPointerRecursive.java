package xyz.basalto.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointerRecursive {

    static class Node {
        int val;
        Node next;
        Node random;

        Node(int val) {
            this.val = val;
        }
    }

    /**
     * Creates a deep copy of a linked list with random pointers.
     *
     * @param head the head of the original list
     * @return the head of the deep-copied list
     */
    public Node copyRandomList(Node head) {
        return copyRandomList(head, new HashMap<>());
    }

    private Node copyRandomList(Node node, Map<Node, Node> map){
        if (node == null) return null;
        if (map.containsKey(node)) return map.get(node);

        Node clone = new Node(node.val);
        map.put(node, clone);

        clone.next = copyRandomList(node.next, map);
        clone.random = copyRandomList(node.random, map);

        return clone;
    }
}
