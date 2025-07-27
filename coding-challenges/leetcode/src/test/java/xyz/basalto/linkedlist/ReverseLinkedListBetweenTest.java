package xyz.basalto.linkedlist;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static xyz.basalto.linkedlist.ListNodeTestUtils.*;

class ReverseLinkedListBetweenTest {


    private final ReverseLinkedListBetween solver = new ReverseLinkedListBetween();

    @Test
    void givenValidSublist_whenReverseBetween_thenSublistIsReversed() {
        ListNode head = fromValues(1, 2, 3, 4, 5, 6, 7);
        ListNode result = solver.reverseBetween(head, 3, 5);
        assertEquals(List.of(1, 2, 5, 4, 3, 6, 7), toList(result));
    }

    @Test
    void givenEntireList_whenReverseBetween_thenWholeListIsReversed() {
        ListNode head = fromValues(1, 2, 3, 4);
        ListNode result = solver.reverseBetween(head, 1, 4);
        assertEquals(List.of(4, 3, 2, 1), toList(result));
    }

    @Test
    void givenLeftEqualsRight_whenReverseBetween_thenListUnchanged() {
        ListNode head = fromValues(1, 2, 3);
        ListNode result = solver.reverseBetween(head, 2, 2);
        assertEquals(List.of(1, 2, 3), toList(result));
    }

    @Test
    void givenReversalAtHead_whenReverseBetween_thenStartSegmentReversed() {
        ListNode head = fromValues(1, 2, 3, 4, 5);
        ListNode result = solver.reverseBetween(head, 1, 2);
        assertEquals(List.of(2, 1, 3, 4, 5), toList(result));
    }

    @Test
    void givenReversalAtTail_whenReverseBetween_thenEndSegmentReversed() {
        ListNode head = fromValues(1, 2, 3, 4, 5);
        ListNode result = solver.reverseBetween(head, 4, 5);
        assertEquals(List.of(1, 2, 3, 5, 4), toList(result));
    }

    @Test
    void givenSingleNode_whenReverseBetween_thenReturnSameNode() {
        ListNode head = fromValues(42);
        ListNode result = solver.reverseBetween(head, 1, 1);
        assertEquals(List.of(42), toList(result));
    }

    @Test
    void givenInvalidLeft_whenReverseBetween_thenThrowException() {
        ListNode head = fromValues(1, 2, 3);
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () ->
                solver.reverseBetween(head, 0, 2)
        );
        assertEquals("left and right must be positive integers", ex.getMessage());
    }


    @Test
    void givenLeftGreaterThanRight_whenReverseBetween_thenThrowException() {
        ListNode head = fromValues(1, 2, 3);
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () ->
                solver.reverseBetween(head, 3, 2)
        );
        assertEquals("left must be less than or equal to right", ex.getMessage());
    }

}