package dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

/**
 * 77. Combinations
 *
 * Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].
 *
 * You may return the answer in any order.
 */
public class Combine {

    public static void main(String[] args) {
        new Combine().combine(4, 2);
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> answerList = new ArrayList<>();
        backTrack(1, n, k, answerList, new ArrayList<>());
        return answerList;
    }

    void backTrack(int start, int n, int k, List<List<Integer>> answerList, List<Integer> runningList) {
        if (runningList.size() == k) {
            answerList.add(new ArrayList<>(runningList));
            return;
        }
        for (int i = start; i <= n; i++) {
            runningList.add(i);
            backTrack(i + 1, n, k, answerList, runningList);
            runningList.remove(runningList.size() - 1);
        }
    }

    /**
     *     def combine(self, n: int, k: int) -> List[List[int]]:
     *         res = []
     *
     *         def backTrack(start, comb):
     *             if len(comb) == k:
     *                 res.append(comb.copy())
     *                 return
     *             for i in range(start, n + 1):
     *                 comb.append(i)
     *                 backTrack(i + 1, comb)
     *                 comb.pop()
     *         backTrack(1, [])
     *         return res
     */

    /**
     * func combine(n int, k int) [][]int {
     *     res := [][]int{}
     *
     *     var backTrack func(int, []int)
     *     backTrack = func(start int, comb[] int) {
     *         if len(comb) == k {
     *             temp := make([]int, len(comb))
     *             copy(temp, comb)
     *             res = append(res, temp)
     *             return
     *         }
     *         for i := start; i <= n; i++ {
     *             comb = append(comb, i)
     *             backTrack(i + 1, comb)
     *             comb = comb[:len(comb) - 1]
     *         }
     *     }
     *     backTrack(1, []int{})
     *     return res
     * }
     */
}
