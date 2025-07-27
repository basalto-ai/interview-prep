package xyz.basalto.linkedlist;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static xyz.basalto.linkedlist.ListNodeTestUtils.fromValues;
import static xyz.basalto.linkedlist.ListNodeTestUtils.toList;

class RemoveDuplicatesFromSortedListIITest {

    private final RemoveDuplicatesFromSortedListII remover = new RemoveDuplicatesFromSortedListII();

    @Test
    void givenNoDuplicates_whenDeleteDuplicates_thenReturnsSameList() {
        ListNode input = fromValues(1, 2, 3, 4, 5);
        ListNode result = remover.deleteDuplicates(input);
        assertEquals(List.of(1, 2, 3, 4, 5), toList(result));
    }

    @Test
    void givenAllDuplicates_whenDeleteDuplicates_thenReturnsEmptyList() {
        ListNode input = fromValues(1, 1, 1, 1);
        ListNode result = remover.deleteDuplicates(input);
        assertNull(result);
    }

    @Test
    void givenSomeDuplicates_whenDeleteDuplicates_thenReturnsOnlyUniqueValues() {
        ListNode input = fromValues(1, 2, 3, 3, 4, 4, 5);
        ListNode result = remover.deleteDuplicates(input);
        assertEquals(List.of(1, 2, 5), toList(result));
    }

    @Test
    void givenDuplicatesAtStart_whenDeleteDuplicates_thenSkipsStartDuplicates() {
        ListNode input = fromValues(1, 1, 2, 3);
        ListNode result = remover.deleteDuplicates(input);
        assertEquals(List.of(2, 3), toList(result));
    }

    @Test
    void givenDuplicatesAtEnd_whenDeleteDuplicates_thenSkipsEndDuplicates() {
        ListNode input = fromValues(1, 2, 3, 3);
        ListNode result = remover.deleteDuplicates(input);
        assertEquals(List.of(1, 2), toList(result));
    }

    @Test
    void givenAlternatingDuplicates_whenDeleteDuplicates_thenSkipsCorrectly() {
        ListNode input = fromValues(1, 1, 2, 3, 3, 4, 5, 5, 6);
        ListNode result = remover.deleteDuplicates(input);
        assertEquals(List.of(2, 4, 6), toList(result));
    }

    @Test
    void givenSingleElement_whenDeleteDuplicates_thenReturnsSameElement() {
        ListNode input = fromValues(7);
        ListNode result = remover.deleteDuplicates(input);
        assertEquals(List.of(7), toList(result));
    }

    @Test
    void givenEmptyList_whenDeleteDuplicates_thenReturnsNull() {
        ListNode result = remover.deleteDuplicates(null);
        assertNull(result);
    }

    @Test
    void givenLongListWithClustersOfDuplicates_whenDeleteDuplicates_thenOnlyUniquesRemain() {
        ListNode input = fromValues(1, 1, 2, 3, 3, 4, 5, 5, 6, 7, 8, 8, 9);
        ListNode result = remover.deleteDuplicates(input);
        assertEquals(List.of(2, 4, 6, 7, 9), toList(result));
    }

    @Test
    void givenAllUniqueExceptOneGroup_whenDeleteDuplicates_thenThatGroupIsRemoved() {
        ListNode input = fromValues(1, 2, 2, 3, 4, 5);
        ListNode result = remover.deleteDuplicates(input);
        assertEquals(List.of(1, 3, 4, 5), toList(result));
    }
}