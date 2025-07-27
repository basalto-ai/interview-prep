package xyz.basalto.arrays;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MajorityElementTest {

    @Test
    public void testEmptyArray() {
        int[] nums = {};
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> MajorityElement.majorityElement(nums));
    }

    @Test
    public void testSingleElementArray() {
        int[] nums = {1};
        assertEquals(1, MajorityElement.majorityElement(nums));
    }

    @Test
    public void testArrayWithMajorityElement() {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        assertEquals(2, MajorityElement.majorityElement(nums));
    }

    @Test
    public void testLargeArrayWithMajorityElement() {
        int[] nums = new int[10000];
        for (int i = 0; i < 10000; i++) {
            nums[i] = i % 2 == 0 ? 1 : 2;
        }
        assertEquals(1, MajorityElement.majorityElement(nums));
    }

}
