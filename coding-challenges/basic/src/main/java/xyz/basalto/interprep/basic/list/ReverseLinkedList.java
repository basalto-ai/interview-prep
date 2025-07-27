package xyz.basalto.interprep.basic.list;

import xyz.basalto.interprep.ds.XyzSingleLinkedNode;

public class ReverseLinkedList {

    public static  XyzSingleLinkedNode reverseList(XyzSingleLinkedNode head){

        XyzSingleLinkedNode current = head;
        XyzSingleLinkedNode prev = null;

        while(current != null){
            XyzSingleLinkedNode nextTmp = current.next;
            current.next = prev;
            prev = current;
            current = nextTmp;
        }

        return prev;
    }

}
