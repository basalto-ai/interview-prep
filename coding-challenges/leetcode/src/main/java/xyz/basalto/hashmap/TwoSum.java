package xyz.basalto.hashmap;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> valueToIndex = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int complement = target - nums[i];
            if(valueToIndex.containsKey(complement)){
                return new int[]{valueToIndex.get(complement), i};
            }
            valueToIndex.put(nums[i], i); // complement, index
        }
        throw new IllegalArgumentException("No two sum solution");
    }

}
