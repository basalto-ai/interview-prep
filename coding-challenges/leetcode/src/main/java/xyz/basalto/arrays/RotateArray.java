package xyz.basalto.arrays;

public class RotateArray {

    public static void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0) return;
        
        int n = nums.length;
        k = k % n;

        if (k == 0) return;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }

}
