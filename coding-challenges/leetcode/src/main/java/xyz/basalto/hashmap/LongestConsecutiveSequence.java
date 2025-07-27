package xyz.basalto.hashmap;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int n: nums) numSet.add(n);

        int longest = 0;
        for (int num: numSet){
            if (!numSet.contains(num - 1)){
                int current = num;
                int streak = 1;

                while (numSet.contains(current + 1)) {
                    current++;
                    streak++;
                }

                longest = Math.max(longest, streak);
            }

        }

        return longest;
    }

}
