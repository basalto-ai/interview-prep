package xyz.basalto.linkedlist;

public class RemoveDuplicatesFromSortedListII {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        while (head != null) {
            boolean isDuplicate = false;
            while (head.next != null && head.val == head.next.val) {
                head = head.next;
                isDuplicate = true;
            }

            if (isDuplicate) {
                // Skip all duplicates
                prev.next = head.next;
            } else {
                prev = prev.next;
            }

            head = head.next;
        }

        return dummy.next;
    }

}
