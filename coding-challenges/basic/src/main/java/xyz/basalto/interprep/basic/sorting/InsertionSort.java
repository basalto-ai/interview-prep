package xyz.basalto.interprep.basic.sorting;

public class InsertionSort {

    /**
     * Sorts an array using the insertion sort algorithm.
     *
     * @param arr The input array of integers to be sorted.
     */
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int currentValue = arr[i];
            int j = i - 1;

            // Find the correct position for currentValue in the sorted portion of the array
            while (j >= 0 && arr[j] > currentValue) {
                arr[j + 1] = arr[j]; // Shift elements to the right to create a space
                j--;
            }

            // Insert currentValue into its correct position
            arr[j + 1] = currentValue;
        }
    }

}
