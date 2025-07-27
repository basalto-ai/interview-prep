package xyz.basalto.linkedlist;

import java.util.ArrayList;
import java.util.List;

public class ListNodeTestUtils {

    /**
     * Converts a varargs sequence of integers to a singly linked list.
     *
     * @param values integer values
     * @return head of the corresponding linked list
     */
    public static ListNode fromValues(int... values) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int val : values) {
            current.next = new ListNode(val);
            current = current.next;
        }
        return dummy.next;
    }

    /**
     * Converts a linked list into a list of integers.
     *
     * @param head head of the linked list
     * @return list of integer values
     */
    public static List<Integer> toList(ListNode head) {
        List<Integer> result = new ArrayList<>();

        while (head != null) {
            result.add(head.val);
            head = head.next;
        }

        return result;
    }
}
