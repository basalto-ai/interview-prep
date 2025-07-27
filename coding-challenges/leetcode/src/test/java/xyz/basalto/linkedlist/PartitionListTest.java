package xyz.basalto.linkedlist;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static xyz.basalto.linkedlist.ListNodeTestUtils.fromValues;
import static xyz.basalto.linkedlist.ListNodeTestUtils.toList;

class PartitionListTest {

    private final PartitionList solution = new PartitionList();

    @Test
    void givenEmptyList_whenPartition_thenReturnsNull() {
        ListNode result = solution.partition(null, 3);
        assertEquals(null, result);
    }

    @Test
    void givenAllLessThanX_whenPartition_thenListRemainsUnchanged() {
        ListNode input = fromValues(1, 1, 2);
        ListNode expected = fromValues(1, 1, 2);
        ListNode result = solution.partition(input, 3);

        assertEquals(expected, result);
    }

    @Test
    void givenAllGreaterThanOrEqualToX_whenPartition_thenListRemainsUnchanged() {
        ListNode input = fromValues(5, 6, 7);
        ListNode expected = fromValues(5, 6, 7);
        ListNode result = solution.partition(input, 5);

        assertEquals(expected, result);
    }

    @Test
    void givenMixedValues_whenPartition_thenPartitionsCorrectly() {
        ListNode input = fromValues(1, 4, 3, 2, 5, 2);
        ListNode expected = fromValues(1, 2, 2, 4, 3, 5);
        ListNode result = solution.partition(input, 3);

        assertEquals(expected, result);
    }

    @Test
    void givenDuplicatesAroundPartition_whenPartition_thenCorrectPartition() {
        ListNode input = fromValues(3, 1, 2, 3, 4, 3);
        ListNode expected = fromValues(1, 2, 3, 3, 4, 3);
        ListNode result = solution.partition(input, 3);

        assertEquals(expected, result);
    }

    @Test
    void givenAllEqualToX_whenPartition_thenListRemainsUnchanged() {
        ListNode input = fromValues(2, 2, 2);
        ListNode expected = fromValues(2, 2, 2);
        ListNode result = solution.partition(input, 2);

        assertEquals(expected, result);
    }

    @Test
    void givenNegativeValues_whenPartition_thenCorrectlyPartitions() {
        ListNode input = fromValues(-3, -2, -1, 0, 1, 2);
        ListNode expected = fromValues(-3, -2, -1, 0, 1, 2);
        ListNode result = solution.partition(input, 3);

        assertEquals(expected, result);
    }

    @Test
    void givenSingleNodeLessThanX_whenPartition_thenSameNodeReturned() {
        ListNode input = fromValues(1);
        ListNode expected = fromValues(1);
        ListNode result = solution.partition(input, 3);

        assertEquals(toList(expected), toList(result));
    }

    @Test
    void givenSingleNodeEqualToX_whenPartition_thenSameNodeReturned() {
        ListNode input = fromValues(3);
        ListNode expected = fromValues(3);
        ListNode result = solution.partition(input, 3);

        assertEquals(toList(expected), toList(result));
    }

    @Test
    void givenLargeList_whenPartition_thenCorrectlyPartitions() {
        int size = 10_000;
        int[] values = new int[size];
        for (int i = 0; i < size; i++) {
            values[i] = i % 100;
        }

        ListNode input = fromValues(values);
        ListNode result = solution.partition(input, 50);

        List<Integer> resultList = toList(result);
        boolean crossed = false;
        for (int val : resultList) {
            if (val >= 50) crossed = true;
            if (crossed && val < 50) {
                throw new AssertionError("Partition order violated with value: " + val);
            }
        }
    }
}