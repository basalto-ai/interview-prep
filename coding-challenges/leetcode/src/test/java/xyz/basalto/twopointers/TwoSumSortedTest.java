package xyz.basalto.twopointers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TwoSumSortedTest {

    private final TwoSumSorted solver = new TwoSumSorted();

    @Test
    void givenSimpleSortedArray_whenTargetExists_thenReturnsCorrectIndices() {
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        int[] result = solver.twoSum(numbers, target);
        assertArrayEquals(new int[]{1, 2}, result);
    }

    @Test
    void givenLargeArray_whenTargetExists_thenReturnsCorrectIndices() {
        int[] numbers = new int[1000];
        for (int i = 0; i < 1000; i++) {
            numbers[i] = i + 1; // 1 to 1000
        }
        int target = 1000;
        int[] result = solver.twoSum(numbers, target);
        assertArrayEquals(new int[]{1, 999}, result); // 1 + 999 = 1000
    }

    @Test
    void givenArrayWithTwoElements_whenTargetExists_thenReturnsCorrectIndices() {
        int[] numbers = {1, 3};
        int target = 4;
        int[] result = solver.twoSum(numbers, target);
        assertArrayEquals(new int[]{1, 2}, result);
    }

    @Test
    void givenArrayWithMinimumLength_whenTargetDoesNotExist_thenReturnsInvalidIndices() {
        int[] numbers = {1, 2};
        int target = 5;
        int[] result = solver.twoSum(numbers, target);
        assertArrayEquals(new int[]{-1, -1}, result);
    }

    @Test
    void givenEmptyArray_whenCallingMethod_thenThrowsIllegalArgumentException() {
        int[] numbers = {};
        int target = 0;
        assertThrows(IllegalArgumentException.class, () -> solver.twoSum(numbers, target));
    }

    @Test
    void givenSingleElementArray_whenCallingMethod_thenThrowsIllegalArgumentException() {
        int[] numbers = {5};
        int target = 5;
        assertThrows(IllegalArgumentException.class, () -> solver.twoSum(numbers, target));
    }

    @Test
    void givenTargetWithOverflowRisk_whenValidPairExists_thenReturnsCorrectIndices() {
        int[] numbers = {Integer.MIN_VALUE, 0, Integer.MAX_VALUE};
        int target = -1;
        int[] result = solver.twoSum(numbers, target);
        assertArrayEquals(new int[]{1, 3}, result);
    }

}