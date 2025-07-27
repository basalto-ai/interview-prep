package xyz.basalto.arrays;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

    /**
     * Given an integer numRows, return the first numRows of Pascal's triangle.
     *
     * @param numRows
     * @return
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        if (numRows <= 0) return triangle;

        // add top
        triangle.add(List.of(1));

        for (int i = 1; i < numRows; i++) {
            List<Integer> level = new ArrayList<>();
            List<Integer> prevRow = triangle.get(i - 1);

            // Each row starts with 1
            level.add(1);

            // Calculate the values in between the first and last element
            for (int j = 1; j < i; j++) {
                level.add(prevRow.get(j - 1) + prevRow.get(j));
            }

            // Each row ends with 1
            level.add(1);

            // Add the row to the triangle
            triangle.add(level);
        }


        return triangle;
    }
}
