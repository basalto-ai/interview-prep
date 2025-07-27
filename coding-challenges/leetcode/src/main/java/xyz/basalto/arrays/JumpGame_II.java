package xyz.basalto.arrays;

public class JumpGame_II {

    public static int jump(int[] nums) {
        int jumps = 0;
        int farthest = 0;
        int currentEnd = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            int possibleJum = i + nums[i];
            farthest = Math.max(farthest, possibleJum);

            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest;
            }
        }

        return jumps;
    }

}
