package xyz.basalto.arrays;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MergeSortedArraysTest {

    @Test
    public void testMergeDifferentLengths() {
        int[] nums1 = {1, 2, 3, 4, 8, 9, 0, 0, 0};
        int m = 6;
        int[] nums2 = {2, 5, 6};
        int n = 3;
        MergeSortedArrays.merge(nums1, m, nums2, n);
        assertArrayEquals(new int[] {1, 2, 2, 3, 4, 5, 6, 8, 9}, nums1);
    }

    @Test
    public void testMergeDifferentLength2s() {
        int[] nums1 = {2, 5, 6, 0, 0, 0};
        int m = 3;
        int[] nums2 = {1, 2, 3};
        int n = 3;
        MergeSortedArrays.merge(nums1, m, nums2, n);
        assertArrayEquals(new int[] {1, 2, 2, 3, 5, 6}, nums1);
    }

    @Test
    public void testMergeSameLengths() {
        int[] nums1 = {1, 3, 5, 0, 0, 0};
        int[] nums2 = {2, 4, 6};
        MergeSortedArrays.merge(nums1, 3, nums2, 3);
        assertArrayEquals(new int[] {1, 2, 3, 4, 5, 6}, nums1);
    }

    @Test
    public void testMergeEmptyArray() {
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {};
        MergeSortedArrays.merge(nums1, 3, nums2, 0);
        assertArrayEquals(new int[] {1, 2, 3}, nums1);
    }

    @Test
    public void testMergeDuplicateElements() {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 3, 3};
        int n = 3;
        MergeSortedArrays.merge(nums1, m, nums2, n);
        assertArrayEquals(new int[] {1, 2, 2, 2, 3, 3}, nums1);
    }

    @Test
    public void testMergeNegativeNumbers() {
        int[] nums1 = {-3, -2, -1, 0, 0, 0};
        int m = 3;
        int[] nums2 = {-2, 0, 1};
        int n = 3;
        MergeSortedArrays.merge(nums1, m, nums2, n);
        assertArrayEquals(new int[] {-3, -2, -2, -1, 0, 1}, nums1);
    }
}