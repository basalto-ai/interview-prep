package xyz.basalto.arrays;

import java.util.*;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();

        if (nums == null || nums.length < 3) return List.of();

        Arrays.sort(nums);

        for(int i = 0; i < nums.length - 2; i++){
            int firstNum = nums[i];
            int left = i + 1;
            int right = nums.length - 1;

            while(left < right) {
                int sum = firstNum + nums[left] + nums[right];

                if (sum == 0){
                    result.add(Arrays.asList(firstNum, nums[left], nums[right]));
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }

        }

        return new ArrayList<>(result);
    }

}
