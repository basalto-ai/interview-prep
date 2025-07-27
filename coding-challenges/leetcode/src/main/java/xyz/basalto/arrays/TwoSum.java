package xyz.basalto.arrays;

import java.util.HashMap;

/**
 * <a href="https://leetcode.com/problems/two-sum/description/">Two Sum Problem</a>
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> targetMap = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int complement = target - nums[i];
            if (targetMap.containsKey(nums[i])){
                return new int[]{targetMap.get(complement), i};
            }
            targetMap.put(nums[i], i);
        }
        return null;
    }

}
