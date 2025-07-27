package xyz.basalto.interprep.basic.array;

import java.util.stream.IntStream;

/**
 * The CheckArrayIsSorted class provides static methods to check whether an integer array
 * is sorted in non-decreasing order.
 */
public class CheckArrayIsSorted {

    public static boolean isSortedWithStream(int[] arr) {
        if (arr == null || arr.length < 2) {
            return true;
        }
        return IntStream.range(0, arr.length - 1)
                .allMatch(i -> arr[i] <= arr[i + 1]);
    }

    public static boolean isSorted(int[] arr) {
        if (arr == null || arr.length < 2) {
            return true;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

}
