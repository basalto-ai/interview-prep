package xyz.basalto.linkedlist;

public class RotateList {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        ListNode tail = head;
        int length = 1;

        while(tail.next != null){
            tail = tail.next;
            length++;
        }

        k = k % length;
        if (k == 0) return head;

        // make the list circular
        tail.next = head;

        // find the new tail
        int stepsToNewTail = length - k;
        ListNode newTail = head;
        for (int i = 1; i < stepsToNewTail; i++) {
            newTail = newTail.next;
        }

        // break the circle and return new head
        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;

    }

}
