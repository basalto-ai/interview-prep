package xyz.basalto.linkedlist;

public class PartitionList {

    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head;

        ListNode lessDummy = new ListNode(0);
        ListNode greaterDummy = new ListNode(0);

        ListNode less = lessDummy;
        ListNode greater = greaterDummy;
        ListNode current = head;

        while (current != null) {
            if (current.val < x) {
                less.next = current;
                less = less.next;
            } else {
                greater.next = current;
                greater = greater.next;
            }
            current = current.next;
        }

        greater.next = null;

        // Connect the two partitions
        less.next = greaterDummy.next;
        return lessDummy.next;
    }

}
