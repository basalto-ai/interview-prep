package xyz.basalto.arrays;

/**
 * https://leetcode.com/problems/jump-game/
 * 
 * You are given an integer array nums. You are initially positioned at the array's first index, and each element in 
 * the array represents your maximum jump length at that position.
 * 
 * Return true if you can reach the last index, or false otherwise.
 */
public class JumpGame {

    public boolean canJump(int[] nums) {
        int maxReach = 0; // Tracks the furthest index we can reach

        for (int i = 0; i < nums.length; i++) {
            if (i > maxReach) {
                // If we can't reach this position, return false
                return false;
            }
            maxReach = Math.max(maxReach, i + nums[i]);
        }

        return true;
    }

     public boolean canJumpFromEnd(int[] nums) {
        int goal = nums.length - 1; // Start with the last index

        for (int i = nums.length - 2; i >= 0; i--) {
            if (i + nums[i] >= goal) {
                goal = i; // You can reach or go beyond the current goal
            }
        }

        return goal == 0; // Can we reach the start?
    }

}
