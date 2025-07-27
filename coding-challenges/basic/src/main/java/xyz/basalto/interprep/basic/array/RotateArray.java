package xyz.basalto.interprep.basic.array;

public class RotateArray {

    public void leftRotateWithExtraSpace(int arr[], int d, int n) {
        d = d % n;
        if (d == 0) return;

        // Creating temp array of size d
        int temp[] = new int[d];

        // Copying first d element in array temp
        for (int i = 0; i < d; i++)
            temp[i] = arr[i];

        // Moving the rest element to index
        // zero to N-d
        for (int i = d; i < n; i++) {
            arr[i - d] = arr[i];
        }

        // Copying the temp array element
        // in original array
        for (int i = 0; i < d; i++) {
            arr[i + n - d] = temp[i];
        }
    }

    public void rightRotateWithExtraSpace(int arr[], int d, int n) {
        d = d % n;
        if (d == 0) return;

        int[] temp = new int[n];

        // Copy the last d elements to the beginning of the temp array
        for (int i = 0; i < d; i++) {
            temp[i] = arr[n - d + i];
        }

        // Copy the first n-d elements to the remaining positions in the temp array
        for (int i = d; i < n; i++) {
            temp[i] = arr[i - d];
        }

        // Copy the temp array back to the original array
        for (int i = 0; i < n; i++) {
            arr[i] = temp[i];
        }
    }

}
