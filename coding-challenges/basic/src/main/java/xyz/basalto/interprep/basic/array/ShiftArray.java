package xyz.basalto.interprep.basic.array;

import java.util.Objects;

/**
 * The ShiftArray class provides static methods to shift the elements of an integer array
 * either to the right or to the left by one position.
 */
public final class ShiftArray {

    /**
     * Shifts the elements of the given array to the right by one position.
     * <p>
     * The last element of the array is moved to the front, and all other elements are shifted
     * one position to the right.
     * </p>
     *
     * @param arr the array to be shifted to the right
     * @throws NullPointerException if the input array is null
     */
    public static void rightShift(int[] arr) {
        Objects.requireNonNull(arr, "Input array cannot be null.");

        int n = arr.length;
        if (n <= 1) return;

        int last = arr[n - 1];
        for (int i = n - 1; i > 0; i--) {
            arr[i] = arr[i - 1];
        }
        arr[0] = last;
    }

    /**
     * Shifts the elements of the given array to the left by one position.
     * <p>
     * The first element of the array is moved to the end, and all other elements are shifted
     * one position to the left.
     * </p>
     *
     * @param arr the array to be shifted to the left
     * @throws NullPointerException if the input array is null
     */
    public static void leftShift(int[] arr) {
        Objects.requireNonNull(arr, "Input array cannot be null.");

        int n = arr.length;
        if (n <= 1) return;

        int first = arr[0];
        for (int i = 0; i < n - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[n - 1] = first;
    }
}
