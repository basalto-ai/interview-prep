package xyz.basalto.arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class RemoveDuplicatedSortedTest {

  @Test
    void givenEmptyArray_whenRemoveDuplicates_thenReturnZero() {
        int[] nums = {};
        int result = new RemoveDuplicatedSorted().removeDuplicates(nums);
        assertEquals(0, result);
    }

    @Test
    void givenSingleElement_whenRemoveDuplicates_thenReturnOne() {
        int[] nums = {5};
        int result = new RemoveDuplicatedSorted().removeDuplicates(nums);
        assertEquals(1, result);
    }

    @Test
    void givenTwoSameElements_whenRemoveDuplicates_thenReturnOne() {
        int[] nums = {5, 5};
        int result = new RemoveDuplicatedSorted().removeDuplicates(nums);
        assertEquals(1, result);
    }

    @Test
    void givenTwoDifferentElements_whenRemoveDuplicates_thenReturnTwo() {
        int[] nums = {5, 8};
        int result = new RemoveDuplicatedSorted().removeDuplicates(nums);
        assertEquals(2, result);
    }

    @Test
    void givenThreeSameElements_whenRemoveDuplicates_thenReturnOne() {
        int[] nums = {5, 5, 5};
        int result = new RemoveDuplicatedSorted().removeDuplicates(nums);
        assertEquals(1, result);
    }

    @Test
    void givenThreeElementsWithDuplicates_whenRemoveDuplicates_thenReturnTwo() {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int result = new RemoveDuplicatedSorted().removeDuplicates(nums);
        assertEquals(2, result);
    }

}
