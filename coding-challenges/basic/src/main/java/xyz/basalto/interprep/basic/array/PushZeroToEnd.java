package xyz.basalto.interprep.basic.array;

public class PushZeroToEnd {

    public static void push(int[] arr){
        if(null == arr){
            throw new IllegalArgumentException("arr cannot be null");
        }

        int nonZeroIndex  = 0;

        for (int i = 0; i < arr.length; i++){
            if (arr[i] != 0){
                arr[nonZeroIndex ] = arr[i];
                nonZeroIndex ++;
            }
        }

        while(nonZeroIndex  < arr.length){
            arr[nonZeroIndex ] = 0;
            nonZeroIndex ++;
        }
    }

}
