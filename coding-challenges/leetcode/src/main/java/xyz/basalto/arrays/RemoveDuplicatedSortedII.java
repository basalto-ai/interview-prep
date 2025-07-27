package xyz.basalto.arrays;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/description/
 */
public class RemoveDuplicatedSortedII {

    public static int removeDuplicates(int[] nums) {
        if (nums.length <= 2) return nums.length;

        int insertPos = 2;
        for (int i = 2; i < nums.length; i++) {
            // Compare with the element two positions before
            if (nums[i] != nums[insertPos - 2]) {
                nums[insertPos] = nums[i];
                insertPos++;
            }
        }

        return insertPos;
    }
}
