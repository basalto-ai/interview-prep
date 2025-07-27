package xyz.basalto.interprep.basic.array;

/**
 * The ReverseArray class provides a static method to reverse an integer array in place.
 */
public class ReverseArray {

    public static void reverse(int[] arr) {
        if (arr == null) {
            throw new IllegalArgumentException("Array cannot be null.");
        }

        int low = 0;
        int high = arr.length - 1;

        // Swap elements from the beginning and end until the middle is reached
        while (low < high) {
            int tmp = arr[low];
            arr[low] = arr[high];
            arr[high] = tmp;
            low++;
            high--;
        }
    }
}
