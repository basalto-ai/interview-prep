package xyz.basalto.arrays;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class JumpGameTest {

    private final JumpGame jumpGame = new JumpGame();

    @Test
    void givenEmptyArray_whenCanJump_thenReturnTrue() {
        // Given
        int[] nums = {};

        // When
        boolean result = jumpGame.canJump(nums);

        // Then
        assertTrue(result, "Empty array should return true (trivially reachable)");
    }

    @Test
    void givenSingleElement_whenCanJump_thenReturnTrue() {
        int[] nums = {0};
        assertTrue(jumpGame.canJump(nums));
    }

    @Test
    void givenReachableJumps_whenCanJump_thenReturnTrue() {
        int[] nums = {2, 3, 1, 1, 4};
        assertTrue(jumpGame.canJump(nums));
    }

    @Test
    void givenUnreachableJumpInMiddle_whenCanJump_thenReturnFalse() {
        int[] nums = {3, 2, 1, 0, 4};
        assertFalse(jumpGame.canJump(nums));
    }

    @Test
    void givenAllZeroExceptStart_whenCanJump_thenReturnTrue() {
        int[] nums = {5, 0, 0, 0, 0, 0};
        assertTrue(jumpGame.canJump(nums));
    }

    @Test
    void givenZeroAtStart_whenCanJump_thenReturnFalse() {
        int[] nums = {0, 2, 3};
        assertFalse(jumpGame.canJump(nums));
    }

    @Test
    void givenLargeNumbers_whenCanJump_thenReturnTrue() {
        int[] nums = {10, 9, 8, 1, 0, 0, 1, 0, 1, 0};
        assertTrue(jumpGame.canJump(nums));
    }

    @Test
    void givenOnlyZeroes_whenCanJump_thenReturnFalseIfLengthGreaterThan1() {
        int[] nums = {0, 0, 0};
        assertFalse(jumpGame.canJump(nums));
    }

    @Test
    void givenMaxReachAtStart_whenCanJump_thenReturnTrue() {
        int[] nums = {100, 0, 0, 0, 0, 0, 0, 0, 1};
        assertTrue(jumpGame.canJump(nums));
    }

    @Test
    void givenUnreachableEndDueToZeroChain_whenCanJump_thenReturnFalse() {
        int[] nums = {5, 4, 0, 0, 0, 0, 0};
        assertFalse(jumpGame.canJump(nums));
    }

    @Test
    void givenLargeArray_whenCanJump_thenPerformanceIsAcceptable() {
        int[] nums = new int[10000];
        for (int i = 0; i < nums.length - 1; i++) {
            nums[i] = 1;
        }
        nums[nums.length - 1] = 0;

        assertTrue(jumpGame.canJump(nums));
    }
}
