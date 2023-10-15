package sort;

import java.util.Arrays;

public class SortTheStudents {
    public int[][] sortTheStudents(int[][] score, int k) {
        Arrays.sort(score, (a, b) -> Integer.compare(b[k], a[k]));
        return score;
    }

    /**
     * func sortTheStudents(score [][]int, k int) [][]int {
     *     sort.Slice(score, func(i, j int) bool {
     *         return score[i][k] > score[j][k]
     *     })
     *     return score
     * }
     */

    /**
     *     def sortTheStudents(self, score: List[List[int]], k: int) -> List[List[int]]:
     *         score.sort(key=lambda x: x[k], reverse=True)
     *         return score
     */
}
