package xyz.basalto.interprep.basic.array;

public class FindSecondLargest {

    /**
    * Finds the second largest element in the given array.
    */
    public static int secondLargestTwoIterations(int[] arr){
        if (arr == null || arr.length < 2){
            throw new IllegalArgumentException("Invalid input");
        }

        int largest = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;

        // Find the largest element
        for (int i = 0; i < arr.length; i++) {
            largest = Math.max(largest, arr[i]);
        }

        // Find the second-largest element
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != largest)
                second = Math.max(second, arr[i]);
        }

        if(second == Integer.MIN_VALUE){
            throw new IllegalArgumentException("No second largest found");
        }
        
        return second;
    }

    /**
    * Finds the second largest element in the given array.
    */
    public static int secondLargestSingleIterations(int[] arr){
        if (arr == null || arr.length < 2){
            throw new IllegalArgumentException("Invalid input");
        }

        int largest = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;

        // Find the largest element
        for (int num : arr) {
            if (num > largest) {
                second = largest;
                largest = num;
            } else if (num > second && num != largest) {
                second = num;
            }
        }

        if(second == Integer.MIN_VALUE){
            throw new IllegalArgumentException("No second largest found");
        }
        
        return second;
    }

}
