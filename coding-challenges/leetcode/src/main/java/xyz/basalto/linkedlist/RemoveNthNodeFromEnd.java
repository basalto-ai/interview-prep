package xyz.basalto.linkedlist;

public class RemoveNthNodeFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n <= 0) {
            throw new IllegalArgumentException("Invalid input: head must not be null and n must be positive");
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode fast = dummy;
        ListNode slow = dummy;

        for(int i = 0; i <= n; i++){
            if(fast == null) throw new IllegalArgumentException("n is larger than the length of the list");
            fast = fast.next;
        }

        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return dummy.next;
    }
}
