package xyz.basalto.arrays;

import java.util.ArrayList;
import java.util.List;

public class SingleRowPascalTriangle {

    public static List<Integer> generate(int rowIndex) {
        List<Integer> row = new ArrayList<>();

        if (rowIndex < 0) return row;

        row.add(1);

        for (int i = 1; i <= rowIndex; i++) {
            for (int j = row.size() - 1; j > 0; j--) {
                int leftIndex = j - 1;
                int rightIndex = j;
                Integer left = row.get(leftIndex);
                Integer right = row.get(rightIndex);
                row.set(j, left + right);
            }
            row.add(1);
        }

        return row;
    }

}
