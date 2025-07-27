package xyz.basalto.arrays;

public class H_Index {
    public static int hIndex(int[] citations) {
        int n = citations.length;
        int[] count = new int[n + 1];

        // Count how many papers have i citations
        for (int c : citations) {
            if (c >= n) {
                count[n]++;
            } else {
                count[c]++;
            }
        }

        // Go from high to low to find the max h
        int total = 0;
        for (int i = n; i >= 0; i--) {
            total += count[i];
            if (total >= i) {
                return i;
            }
        }

        return 0;
    }
}
