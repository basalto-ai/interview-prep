
package xyz.basalto.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class CopyRandomPointerListWithMap {

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
        if (head == null) return null;
        Map<Node, Node> map = new HashMap<>();

        Node current = head;
        while(current != null){
            map.put(current, new Node(current.val));
            current = current.next;
        }

        current = head;
        while (current != null){
            Node copy = map.get(current);
            copy.next = map.get(current.next);
            copy.random = map.get(current.random);
            current = current.next;
        }

        return map.get(head);
    }
}
