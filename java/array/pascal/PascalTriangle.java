package array.pascal;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

    public static void main(String[] args) {
        pascalTriangle(5);
    }

    static List<List<Integer>> pascalTriangle(int numRows) {
        List<List<Integer>> answer = new ArrayList<>();
        for(int i = 0; i < numRows; i++) {
            answer.add(i, new ArrayList<>());
        }
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < i + 1; j++) {
                if (i > 1 && j > 0 && j < answer.get(i - 1).size()) {
                    Integer l = answer.get(i - 1).get(j - 1);
                    Integer m = answer.get(i - 1).get(j);
                    answer.get(i).add(l + m);
                } else {
                    answer.get(i).add(1);
                }
            }
        }
        return answer;
    }
}
