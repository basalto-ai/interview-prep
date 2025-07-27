package xyz.basalto.twopointers;

public class TwoSumSorted {

    public int[] twoSum(int[] numbers, int target){
        if (numbers == null || numbers.length < 2) {
            throw new IllegalArgumentException("Input array must contain at least 2 elements.");
        }

        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target){
                return new int[]{left + 1, right + 1};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return new int[]{-1, -1};
    }

}
