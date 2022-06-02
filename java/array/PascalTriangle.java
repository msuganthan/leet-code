package array;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

    public static void main(String[] args) {
        pascalTriangle(5);
    }

    static List<List<Integer>> pascalTriangle(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        if (numRows == 0) return triangle;


        List<Integer> first_row = new ArrayList<>();
        first_row.add(1);
        triangle.add(first_row);

        for (int i = 0; i < numRows; i++) {
            List<Integer> prev_row = new ArrayList<>();
            List<Integer> curr_row = new ArrayList<>();

            curr_row.add(1);


            for (int j = 1; j < i; j++)
                curr_row.add(prev_row.get(j - 1) + prev_row.get(j));


            curr_row.add(1);

            triangle.add(curr_row);
        }

        return triangle;


    }
}
