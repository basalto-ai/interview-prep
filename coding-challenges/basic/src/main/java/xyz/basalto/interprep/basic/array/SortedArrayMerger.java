package xyz.basalto.interprep.basic.array;

public class SortedArrayMerger {

    public static int[] mergeSortedArrays(int[] arr1, int[] arr2) {
        
        int i = 0;
        int j = 0;
        int k = 0;
        int n1 = arr1.length;
        int n2 = arr2.length;
        int[] result = new int[n1 + n2];
    
        // Traverse both arrays
        while (i < n1 && j < n2) {
            // Compare elements from both arrays and add the smaller one to the result array
            if (arr1[i] < arr2[j]) {
                result[k++] = arr1[i++];
            } else {
                result[k++] = arr2[j++];
            }
        }
    
        // Store remaining elements of the first array
        while (i < n1) {
            result[k++] = arr1[i++];
        }
    
        // Store remaining elements of the second array
        while (j < n2) {
            result[k++] = arr2[j++];
        }
        return result;
    }
    
}
