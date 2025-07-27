package xyz.basalto.linkedlist;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }


    @Override
    public String toString() {
        return "[" + this.val + ", " + (this.next != null ? this.next.val : "null") + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ListNode currentB)) return false;

        ListNode currentA = this;

        while (currentA != null && currentB != null) {
            if (currentA.val != currentB.val) {
                return false;
            }
            currentA = currentA.next;
            currentB = currentB.next;
        }

        return currentA == null && currentB == null;
    }

    @Override
    public int hashCode() {
        int hash = 1;
        ListNode current = this;
        while (current != null) {
            hash = 31 * hash + current.val;
            current = current.next;
        }
        return hash;
    }

}



