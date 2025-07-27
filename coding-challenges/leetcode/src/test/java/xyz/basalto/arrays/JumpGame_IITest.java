package xyz.basalto.arrays;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class JumpGame_IITest {

    @Test
    void givenNoExtraJumpNeeded_whenJump_thenReturnZero() {
        int[] nums = {1};
        int result = JumpGame_II.jump(nums);
        assertEquals(0, result);
    }

    @Test
    void givenMinimumTwoJumpsRequired_whenJump_thenReturnTwo() {
        int[] nums = {2, 3, 1, 1, 4};
        int result = JumpGame_II.jump(nums);
        assertEquals(2, result); // 0 → 1 → 4
    }

    @Test
    void givenUniformJumpLengths_whenJump_thenReturnExpectedJumps() {
        int[] nums = {2, 2, 2, 2, 2};
        int result = JumpGame_II.jump(nums);
        assertEquals(2, result);
    }

    @Test
    void givenLongListWithAlternatingZeroes_whenJump_thenHandleComplexity() {
        int[] nums = {5, 0, 0, 0, 1, 1, 1, 1, 6, 0, 0, 0, 1};
        int result = JumpGame_II.jump(nums);
        assertEquals(5, result);
    }

    @Test
    void givenLargeInput_whenJump_thenReturnCorrectMinimumJumps() {
        int[] nums = new int[10000];
        // Large jump length
        Arrays.fill(nums, 1000);
        int result = JumpGame_II.jump(nums);
        assertTrue(result < 20); // Should be very small relative to size
    }

    @Test
    void givenDecreasingJumpLengths_whenJump_thenHandleEfficiently() {
        int[] nums = {10, 9, 8, 7, 6, 1, 0, 0, 0, 0, 1};
        int result = JumpGame_II.jump(nums);
        assertEquals(1, result); // One jump covers entire array
    }

    @Test
    void givenZerosAfterReachablePath_whenJump_thenReturnValidJumps() {
        int[] nums = {4, 2, 0, 0, 2, 0};
        int result = JumpGame_II.jump(nums);
        assertEquals(2, result); // 0→4→5
    }

    @Test
    void givenCustom10ElementArray_whenJump_thenReturnMinimumJumps() {
        int[] nums = {3, 4, 1, 1, 0, 2, 0, 1, 4, 2};
        int result = JumpGame_II.jump(nums);
        assertEquals(3, result);
    }

}