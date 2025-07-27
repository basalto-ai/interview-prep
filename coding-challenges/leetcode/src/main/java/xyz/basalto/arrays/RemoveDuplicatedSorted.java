package xyz.basalto.arrays;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii
 */
/*************  ✨ Windsurf Command 🌟  *************/
public class RemoveDuplicatedSorted {

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int insertPos = 1; // Index to insert the next unique element

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[insertPos - 1]) {
                nums[insertPos] = nums[i];
                insertPos++;
            }
        }

        return insertPos;
    }

}
