package xyz.basalto.arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

public class RotateArrayTest {
    
    @Test
    public void testRotateBy1Position() {
        int[] nums = {1, 2, 3, 4, 5};
        int k = 1;
        int[] expected = {5, 1, 2, 3, 4};
        RotateArray.rotate(nums, k);
        assertArrayEquals(expected, nums);
    }
    @Test
    public void testRotateByMoreThanLength() {
        int[] nums = {1, 2, 3, 4, 5};
        int k = 7;
        int[] expected = {4, 5, 1, 2, 3};
        RotateArray.rotate(nums, k);
        assertArrayEquals(expected, nums);
    }
    @Test
    public void testRotateByLength() {
        int[] nums = {1, 2, 3, 4, 5};
        int k = 5;
        int[] expected = {1, 2, 3, 4, 5};
        RotateArray.rotate(nums, k);
        assertArrayEquals(expected, nums);
    }
    @Test
    public void testRotateEmptyArray() {
        int[] nums = {};
        int k = 1;
        int[] expected = {};
        RotateArray.rotate(nums, k);
        assertArrayEquals(expected, nums);
    }
    @Test
    public void testRotateSingleElementArray() {
        int[] nums = {1};
        int k = 1;
        int[] expected = {1};
        RotateArray.rotate(nums, k);
        assertArrayEquals(expected, nums);
    }
    @Test
    public void testRotateMultipleElements() {
        int[] nums = {1, 2, 3, 4, 5, 6};
        int k = 3;
        int[] expected = {4, 5, 6, 1, 2, 3};
        RotateArray.rotate(nums, k);
        assertArrayEquals(expected, nums);
    }
}
