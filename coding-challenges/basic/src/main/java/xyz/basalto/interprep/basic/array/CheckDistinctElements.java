package xyz.basalto.interprep.basic.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CheckDistinctElements {

    /**
     * Checks if all elements in the array are distinct using nested loops.
     * 
     * @param arr The input array to check.
     * @return true if all elements are distinct, false otherwise.
     * @throws IllegalArgumentException if the input array is null.
     */
    public static boolean areDistinctWithLoops(int[] arr) {
        if (arr == null) {
            throw new IllegalArgumentException("Input array cannot be null.");
        }
        int length = arr.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                if (arr[i] == arr[j]) {
                    // duplicate found
                    return false; 
                }
            }
        }
        return true;
    }

    /**
     * Checks if all elements in the array are distinct using a Set.
     * 
     * @param arr The input array to check.
     * @return true if all elements are distinct, false otherwise.
     * @throws IllegalArgumentException if the input array is null.
     */
    public static boolean areDistinctWithSet(int[] arr) {
        if (arr == null) {
            throw new IllegalArgumentException("Input array cannot be null.");
        }
        Set<Integer> seen = new HashSet<>();
        for (int num : arr) {
            if (!seen.add(num)) {
                // Duplicate found
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if all elements in the array are distinct using Java Streams
     * with early exit upon finding a duplicate.
     */
    public static boolean areDistinctWithStream(int[] arr){
        if (arr == null) {
            throw new IllegalArgumentException("Input array cannot be null.");
        }
        Set<Integer> seen = new HashSet<>();
        return Arrays.stream(arr)
                     .allMatch(seen::add);  
    }

  
}
