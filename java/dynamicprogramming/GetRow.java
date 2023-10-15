package dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

public class GetRow {
    public static void main(String[] args) {
        new GetRow().getRow(3);
    }
    public List<Integer> getRow(int rowIndex) {
        if(rowIndex == 0) {
            return List.of(1);
        }
        List<List<Integer>> answer = new ArrayList<>();
        for(int i = 0; i <= rowIndex; i++) {
            answer.add(i, new ArrayList<>());
        }

        for (int i = 0; i <= rowIndex; i++) {
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
        return answer.get(rowIndex);
    }
}
