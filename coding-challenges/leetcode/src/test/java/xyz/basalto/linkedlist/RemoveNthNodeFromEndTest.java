package xyz.basalto.linkedlist;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static xyz.basalto.linkedlist.ListNodeTestUtils.fromValues;
import static xyz.basalto.linkedlist.ListNodeTestUtils.toList;

class RemoveNthNodeFromEndTest {

    private final RemoveNthNodeFromEnd remover = new RemoveNthNodeFromEnd();

    @Test
    void givenMiddleNodeToRemove_whenRemoveNthFromEnd_thenCorrectListReturned() {
        ListNode head = fromValues(1, 2, 3, 4, 5);
        ListNode result = remover.removeNthFromEnd(head, 2);
        assertEquals(toList(result), List.of(1, 2, 3, 5));
    }

    @Test
    void givenHeadNodeToRemove_whenRemoveNthFromEnd_thenNewHeadIsCorrect() {
        ListNode head = fromValues(1, 2, 3, 4, 5);
        ListNode result = remover.removeNthFromEnd(head, 5);
        assertEquals(fromValues(2, 3, 4, 5), result);
    }

    @Test
    void givenLastNodeToRemove_whenRemoveNthFromEnd_thenTailRemoved() {
        ListNode head = fromValues(1, 2, 3);
        ListNode result = remover.removeNthFromEnd(head, 1);
        assertEquals(fromValues(1, 2), result);
    }

    @Test
    void givenSingleNodeList_whenRemoveNthFromEnd_thenEmptyListReturned() {
        ListNode head = fromValues(10);
        ListNode result = remover.removeNthFromEnd(head, 1);
        assertNull(result);
    }

    @Test
    void givenTwoNodeList_whenRemoveFirstNode_thenOnlySecondRemains() {
        ListNode head = fromValues(8, 9);
        ListNode result = remover.removeNthFromEnd(head, 2);
        assertEquals(fromValues(9), result);
    }

    @Test
    void givenInvalidNTooLarge_whenRemoveNthFromEnd_thenThrowsException() {
        ListNode head = fromValues(1, 2, 3);
        assertThrows(IllegalArgumentException.class, () -> remover.removeNthFromEnd(head, 4));
    }

    @Test
    void givenZeroN_whenRemoveNthFromEnd_thenThrowsException() {
        ListNode head = fromValues(1, 2);
        assertThrows(IllegalArgumentException.class, () -> remover.removeNthFromEnd(head, 0));
    }

    @Test
    void givenNullHead_whenRemoveNthFromEnd_thenThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> remover.removeNthFromEnd(null, 1));
    }

    @Test
    void givenLargeList_whenRemoveNthFromEnd_thenCorrectListReturned() {
        ListNode head = fromValues(10, 20, 30, 40, 50, 60, 70, 80, 90, 100);
        ListNode result = remover.removeNthFromEnd(head, 4); // removes 70
        assertEquals(fromValues(10, 20, 30, 40, 50, 60, 80, 90, 100), result);
    }

    @Test
    void givenAllSameValues_whenRemoveMiddleNthFromEnd_thenCorrectListReturned() {
        ListNode head = fromValues(1, 1, 1, 1, 1);
        ListNode result = remover.removeNthFromEnd(head, 3);
        assertEquals(fromValues(1, 1, 1, 1), result);
    }

}