package xyz.basalto.arrays;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RemoveDuplicatedSortedIITest {

    @Test
    void givenEmptyArray_whenRemoveDuplicates_thenReturnZero() {
        int[] nums = {};
        int length = RemoveDuplicatedSortedII.removeDuplicates(nums);
        assertEquals(0, length);
    }


    @Test
    void givenSingleElement_whenRemoveDuplicates_thenReturnOne() {
        int[] nums = {5};
        int length = RemoveDuplicatedSortedII.removeDuplicates(nums);
        assertEquals(1, length);
        assertArrayEquals(new int[]{5}, copyOf(nums, length));
    }

    @Test
    void givenTwoDifferentElements_whenRemoveDuplicates_thenKeepBoth() {
        int[] nums = {1, 2};
        int length = RemoveDuplicatedSortedII.removeDuplicates(nums);
        assertEquals(2, length);
        assertArrayEquals(new int[]{1, 2}, copyOf(nums, length));
    }

    @Test
    void givenTwoSameElements_whenRemoveDuplicates_thenKeepBoth() {
        int[] nums = {2, 2};
        int length = RemoveDuplicatedSortedII.removeDuplicates(nums);
        assertEquals(2, length);
        assertArrayEquals(new int[]{2, 2}, copyOf(nums, length));
    }

    @Test
    void givenThreeSameElements_whenRemoveDuplicates_thenKeepTwo() {
        int[] nums = {7, 7, 7};
        int length = RemoveDuplicatedSortedII.removeDuplicates(nums);
        assertEquals(2, length);
        assertArrayEquals(new int[]{7, 7}, copyOf(nums, length));
    }

    @Test
    void givenArrayWithDuplicates_whenRemoveDuplicates_thenKeepAtMostTwoEach() {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int length = RemoveDuplicatedSortedII.removeDuplicates(nums);
        assertEquals(5, length);
        assertArrayEquals(new int[]{1, 1, 2, 2, 3}, copyOf(nums, length));
    }

    @Test
    void givenArrayWithLongDuplicateSequence_whenRemoveDuplicates_thenTruncateToTwo() {
        int[] nums = {1, 1, 1, 1, 1, 2, 3, 3, 3, 3};
        int length = RemoveDuplicatedSortedII.removeDuplicates(nums);
        assertEquals(5, length);
        assertArrayEquals(new int[]{1, 1, 2, 3, 3}, copyOf(nums, length));
    }

    @Test
    void givenArrayWithNoDuplicates_whenRemoveDuplicates_thenPreserveOriginal() {
        int[] nums = {1, 2, 3, 4, 5};
        int length = RemoveDuplicatedSortedII.removeDuplicates(nums);
        assertEquals(5, length);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, copyOf(nums, length));
    }

    @Test
    void givenAllSameElements_whenRemoveDuplicates_thenKeepOnlyTwo() {
        int[] nums = {9, 9, 9, 9, 9, 9, 9};
        int length = RemoveDuplicatedSortedII.removeDuplicates(nums);
        assertEquals(2, length);
        assertArrayEquals(new int[]{9, 9}, copyOf(nums, length));
    }

    @Test
    void givenInterleavedDuplicates_whenRemoveDuplicates_thenRemoveExtras() {
        int[] nums = {1, 1, 1, 1, 2, 2, 3, 4, 4, 4};
        int length = RemoveDuplicatedSortedII.removeDuplicates(nums);
        assertEquals(7, length);
        assertArrayEquals(new int[]{1, 1, 2, 2, 3, 4, 4}, copyOf(nums, length));
    }

    private int[] copyOf(int[] original, int length) {
        int[] result = new int[length];
        System.arraycopy(original, 0, result, 0, length);
        return result;
    }
}
