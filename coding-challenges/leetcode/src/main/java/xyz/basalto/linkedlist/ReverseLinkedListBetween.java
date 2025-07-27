package xyz.basalto.linkedlist;

public class ReverseLinkedListBetween {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Step 1: Move prev to the node just before reversal starts
        ListNode prevLeft = dummy;
        for (int i = 1; i < left; i++) {
            prevLeft = prevLeft.next;
        }

        // Step 2: Reverse the sublist from left to right
        ListNode current = prevLeft.next;
        ListNode prevNode = null;

        for (int i = 0; i <= right - left; i++) {
            ListNode nextTemp = current.next;
            current.next = prevNode;
            prevNode = current;
            current = nextTemp;
        }

        // Step 3: Connect reversed part with the rest
        ListNode leftNode = prevLeft.next;
        leftNode.next = current;
        prevLeft.next = prevNode;

        return dummy.next;
    }

}
