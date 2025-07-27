package xyz.basalto.interprep.basic.array;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CheckArrayIsSortedTest {

    // Given a null array when checking then should return true.
    @Test
    public void givenNullArray_whenUsingIsSorted_thenReturnTrue() {
        int[] arr = null;
        boolean result1 = CheckArrayIsSorted.isSorted(arr);
        boolean result2 = CheckArrayIsSorted.isSortedWithStream(arr);
        assertTrue(result1, "Null array should be considered sorted.");
        assertTrue(result2, "Null array should be considered sorted.");
    }
    
    // Given an empty array when checking then should return true.
    @Test
    public void givenEmptyArray_whenUsingIsSorted_thenReturnTrue() {
        int[] arr = new int[0];
        boolean result1 = CheckArrayIsSorted.isSorted(arr);
        boolean result2 = CheckArrayIsSorted.isSortedWithStream(arr);
        assertTrue(result1, "Empty array should be considered sorted.");
        assertTrue(result2, "Empty array should be considered sorted.");
    }
    
    // Given a single element array when checking then should return true.
    @Test
    public void givenSingleElementArray_whenUsingIsSorted_thenReturnTrue() {
        int[] arr = {5};
        boolean result1 = CheckArrayIsSorted.isSorted(arr);
        boolean result2 = CheckArrayIsSorted.isSortedWithStream(arr);
        assertTrue(result1, "Single element array should be considered sorted.");
        assertTrue(result2, "Single element array should be considered sorted.");
    }
    
    // Given a sorted array when checking then should return true.
    @Test
    public void givenSortedArray_whenUsingIsSorted_thenReturnTrue() {
        int[] arr = {1, 2, 3, 4, 5};
        boolean result1 = CheckArrayIsSorted.isSorted(arr);
        boolean result2 = CheckArrayIsSorted.isSortedWithStream(arr);
        assertTrue(result1, "Sorted array should return true.");
        assertTrue(result2, "Sorted array should return true.");
    }
    
    // Given a sorted array with duplicates when checking then should return true.
    @Test
    public void givenSortedArrayWithDuplicates_whenUsingIsSorted_thenReturnTrue() {
        int[] arr = {1, 2, 2, 3, 4, 4, 5};
        boolean result1 = CheckArrayIsSorted.isSorted(arr);
        boolean result2 = CheckArrayIsSorted.isSortedWithStream(arr);
        assertTrue(result1, "Sorted array with duplicates should return true.");
        assertTrue(result2, "Sorted array with duplicates should return true.");
    }
    
    // Given an unsorted array when checking then should return false.
    @Test
    public void givenUnsortedArray_whenUsingIsSorted_thenReturnFalse() {
        int[] arr = {5, 3, 4, 1, 2};
        boolean result1 = CheckArrayIsSorted.isSorted(arr);
        boolean result2 = CheckArrayIsSorted.isSortedWithStream(arr);
        assertFalse(result1, "Unsorted array should return false.");
        assertFalse(result2, "Unsorted array should return false.");
    }
    
    // Given a complex array with negatives and zeros when checking then should return correct results.
    @Test
    public void givenArrayWithNegativesAndZeros_whenUsingIsSorted_thenReturnCorrectResult() {
        int[] sortedArr = {-10, -5, 0, 0, 2, 3, 3, 7};
        int[] unsortedArr = {-10, -5, 0, 3, 0, 2, 3, 7};
        
        boolean result1 = CheckArrayIsSorted.isSorted(sortedArr);
        boolean result2 = CheckArrayIsSorted.isSortedWithStream(sortedArr);
        assertTrue(result1, "Sorted array with negatives and zeros should return true.");
        assertTrue(result2, "Sorted array with negatives and zeros should return true.");
        
        boolean result3 = CheckArrayIsSorted.isSorted(unsortedArr);
        boolean result4 = CheckArrayIsSorted.isSortedWithStream(unsortedArr);
        assertFalse(result3, "Unsorted array with negatives and zeros should return false.");
        assertFalse(result4, "Unsorted array with negatives and zeros should return false.");
    }
    
    // Given a large sorted array when checking then should return true.
    @Test
    public void givenLargeSortedArray_whenUsingIsSorted_thenReturnTrue() {
        int n = 10000;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        boolean result1 = CheckArrayIsSorted.isSorted(arr);
        boolean result2 = CheckArrayIsSorted.isSortedWithStream(arr);
        assertTrue(result1, "Large sorted array should return true.");
        assertTrue(result2, "Large sorted array should return true.");
    }
    
    // Given a large unsorted array when checking then should return false.
    @Test
    public void givenLargeUnsortedArray_whenUsingIsSorted_thenReturnFalse() {
        int n = 10000;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        // Introduce disorder in the middle
        arr[n/2] = arr[n/2] + 1;
        arr[n/2 + 1] = arr[n/2 + 1] - 1;
        
        boolean result1 = CheckArrayIsSorted.isSorted(arr);
        boolean result2 = CheckArrayIsSorted.isSortedWithStream(arr);
        assertFalse(result1, "Large unsorted array should return false.");
        assertFalse(result2, "Large unsorted array should return false.");
    }
}
