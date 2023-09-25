package array;

import java.util.ArrayList;
import java.util.List;

public class Generate {

    public static void main(String[] args) {
        new Generate().generate(5);
    }
    public List<List<Integer>> generate(int numRows) {
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

    /**
     *     def generate(self, numRows: int) -> List[List[int]]:
     *         answer = []
     *
     *         for i in range(numRows):
     *             answer.append([])
     *
     *         for i in range(numRows):
     *             for j in range(i + 1):
     *                 if i > 1 and j > 0 and j < len(answer[i - 1]):
     *                     l = answer[i - 1][j - 1]
     *                     m = answer[i - 1][j]
     *                     answer[i].append(l + m)
     *                 else:
     *                     answer[i].append(1)
     *         return answer
     */

    /**
     * func generate(numRows int) [][]int {
     *     answer := make([][]int, numRows)
     *
     *     for i := 0; i < numRows; i++ {
     *         answer[i] = make([]int, i + 1)
     *     }
     *
     *     for i := 0; i < numRows; i++ {
     *         for j := 0; j < i + 1; j++ {
     *             if i > 1 && j > 0 && j < len(answer[i - 1]) {
     *                 l := answer[i - 1][j - 1]
     *                 m := answer[i - 1][j];
     *                 answer[i][j] = l + m;
     *             } else {
     *                 answer[i][j] = 1
     *             }
     *         }
     *     }
     *     return answer
     * }
     */
}
