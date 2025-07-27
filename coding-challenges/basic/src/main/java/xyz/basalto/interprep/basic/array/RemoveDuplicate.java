package xyz.basalto.interprep.basic.array;

import java.util.Arrays;
import java.util.Objects;

public class RemoveDuplicate {

    /**
     * Removes duplicates from a sorted integer array.
     *
     * @param nums The input sorted array.
     * @return A new array with duplicates removed.
     * @throws IllegalArgumentException if the input array is null.
     */
    public static int[] removeDuplicatesSorted(int[] nums) {
        Objects.requireNonNull(nums, "Input array cannot be null.");
        if (nums.length <= 1) return nums;

        int uniqueIndex = 0; // index of unique elements
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[uniqueIndex]) {
                uniqueIndex++;
                nums[uniqueIndex] = nums[i];
            }
        }

        // Create a new array of the correct size to hold the unique elements
        return Arrays.copyOf(nums, uniqueIndex + 1);
    }

    /**
     * Removes duplicates from a sorted array of comparable elements.
     *
     * @param arr The input sorted array.
     * @return A new array with duplicates removed.
     * @throws IllegalArgumentException if the input array is null.
     */
    public static <T extends Comparable<T>> T[] removeDuplicatesSorted(T[] arr) {
        Objects.requireNonNull(arr, "Input array cannot be null.");
        if (arr.length <= 1) return arr;

        int uniqueIndex = 0; // index of unique elements
        for (int i = 1; i < arr.length; i++) {
            if (!Objects.equals(arr[i], arr[uniqueIndex])) {
                uniqueIndex++;
                arr[uniqueIndex] = arr[i];
            }
        }

        // Create a new array of the correct size to hold the unique elements
        return Arrays.copyOf(arr, uniqueIndex + 1);
    }

    /**
     * Removes duplicates from an unsorted integer array.
     *
     * @param nums The input unsorted array.
     * @return A new array with duplicates removed.
     * @throws IllegalArgumentException if the input array is null.
     */
    public static int[] removeDuplicates(int[] nums) {
        Objects.requireNonNull(nums, "Input array cannot be null.");
        if (nums.length <= 1) return nums;

        int uniqueIndex = 0; // Index of the last unique element found
        for (int i = 1; i < nums.length; i++) {
            boolean isDuplicate = false;
            for (int j = 0; j <= uniqueIndex; j++) {
                if (nums[i] == nums[j]) {
                    isDuplicate = true;
                    break;
                }
            }

            if (!isDuplicate) {
                uniqueIndex++;
                nums[uniqueIndex] = nums[i];
            }
        }

        // Create a new array of the correct size to hold the unique elements
        return Arrays.copyOf(nums, uniqueIndex + 1);
    }

    /**
     * Removes duplicates from an unsorted array of comparable elements.
     *
     * @param arr The input unsorted array.
     * @return A new array with duplicates removed.
     * @throws IllegalArgumentException if the input array is null.
     */
    public static <T extends Comparable<T>> T[] removeDuplicates(T[] arr) {
        Objects.requireNonNull(arr, "Input array cannot be null.");
        if (arr.length <= 1) return arr;
        int uniqueIndex = 0; // Index of the last unique element found

        for (int i = 1; i < arr.length; i++) {
            boolean isDuplicate = false;
            for (int k = 0; k <= uniqueIndex; k++) {
                if (Objects.equals(arr[i], arr[k])) {
                    isDuplicate = true;
                    break;
                }
            }

            if (!isDuplicate) {
                uniqueIndex++;
                arr[uniqueIndex] = arr[i];
            }
        }

        // Create a new array of the correct size to hold the unique elements
        return java.util.Arrays.copyOf(arr, uniqueIndex + 1);
    }

}
