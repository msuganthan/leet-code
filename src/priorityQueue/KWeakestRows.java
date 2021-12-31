package priorityQueue;

import java.util.PriorityQueue;

/**
 * 1337. The K Weakest Rows in a Matrix
 * You are given an m x n binary matrix mat of 1's (representing soldiers) and 0's (representing civilians).
 * The soldiers are positioned in front of the civilians. That is, all the 1's will appear to the left of all
 * the 0's in each row.
 *
 * A row i is weaker than a row j if one of the following is true:
 *
 * The number of soldiers in row i is less than the number of soldiers in row j.
 * Both rows have the same number of soldiers and i < j.
 * Return the indices of the k weakest rows in the matrix ordered from weakest to strongest.
 *
 *
 */
public class KWeakestRows {

    public int[] kWeakestRows(int[][] mat, int k) {
        int[] ans = new int[k];
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> a[0] != b[0] ? b[0] - a[0] : b[1] - a[1]);
        for (int i = 0; i < mat.length; i++) {
            priorityQueue.offer(new int[]{ones(mat[i]), i});
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }
        while (k > 0) {
            ans[--k] = priorityQueue.poll()[1];
        }
        return ans;
    }

    int ones(int[] row) {
        int lo = 0;
        int high = row.length;

        while(lo < high) {
            int mid = lo + (high - lo) / 2;

            if (row[mid] == 1)
                lo = mid + 1;
            else
                high = mid;
        }

        return lo;
    }
}
