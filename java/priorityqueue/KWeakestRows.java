package priorityqueue;

import java.util.PriorityQueue;

/**
 * 1337. The K Weakest Rows in a Matrix
 * https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/
 *
 * You are given an m x n binary matrix mat of 1's (representing soldiers) and 0's (representing civilians).
 * The soldiers are positioned in front of the civilians. That is, all the 1's will appear to the left of all
 * the 0's in each row.
 *
 * A row i is weaker than a row j if one of the following is true:
 *
 * The number of soldiers in row i is less than the number of soldiers in row j.
 * Both rows have the same number of soldiers and i < j.
 * Return the indices of the k weakest rows in the matrix ordered from weakest to strongest.
 */
public class KWeakestRows {

    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] != b[0] ? b[0] - a[0] : b[1] - a[1]);
        for(int i = 0; i < mat.length; i++) {
            int ones = binarysearch(mat[i]);
            queue.offer(new int[] {ones, i});
            if (queue.size() > k) {
                queue.poll();
            }
        }
        int[] ans = new int[k];
        while (k > 0) {
            ans[--k] = queue.poll()[1];
        }
        return ans;
    }

    int binarysearch(int[] row) {
        int left = 0, right = row.length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;

            if(row[mid] == 1) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }


    /**
     * class Solution:
     *     def kWeakestRows(self, mat: List[List[int]], k: int) -> List[int]:
     *         queue = []
     *         for i in range(len(mat)):
     *             ones = self.binarysearch(mat[i])
     *             heapq.heappush(queue, (-ones, -i))
     *             if len(queue) > k:
     *                 heapq.heappop(queue)
     *
     *         ans = []
     *         while k > 0:
     *             ans.append(-heapq.heappop(queue)[1])
     *             k -= 1
     *         return ans[::-1]
     *
     *     def binarysearch(self, row):
     *         left, right = 0, len(row) - 1
     *         while left <= right:
     *             mid = left + (right - left) // 2
     *
     *             if row[mid] == 1:
     *                 left = mid + 1
     *             else:
     *                 right = mid - 1
     *         return left
     */
}
