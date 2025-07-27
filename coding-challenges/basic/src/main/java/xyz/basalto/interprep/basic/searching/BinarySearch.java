package xyz.basalto.interprep.basic.searching;

public class BinarySearch {

    public static <T extends Comparable<T>> int search(T[] elements, T target){
        int left = 0;
        int right = elements.length - 1;

        while(left <= right){
            int mid = left + (right - left) / 2;
            if(elements[mid].compareTo(target) == 0){
                return mid;
            } else if(elements[mid].compareTo(target) < 0){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

}
