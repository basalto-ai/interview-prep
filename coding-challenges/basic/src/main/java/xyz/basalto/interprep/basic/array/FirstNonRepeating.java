package xyz.basalto.interprep.basic.array;


public class FirstNonRepeating {

    /**
     * Finds the first non-repeating element in an array using a nested loop.
     *
     * @param arr The input array of integers.
     * @return The first non-repeating element, or -1 if no such element is found.
     */
    public static int findFirstUniqueUsingLoops(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            boolean isUnique = true;
            for (int j = 0; j < n; j++) {
                if (i != j && arr[i] == arr[j]) {
                    isUnique = false;
                    break; // If a duplicate is found, no need to check further
                }
            }
            if (isUnique) {
                return arr[i]; // Return the first element that has no duplicates
            }
        }

        return -1; // If no unique element is found, return -1
    }

}
