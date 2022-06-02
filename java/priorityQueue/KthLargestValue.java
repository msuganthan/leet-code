package priorityQueue;

import java.util.PriorityQueue;

/**
 * 1738. Find Kth Largest XOR Coordinate Value.
 *
 * You are given a 2D matrix of size m x n, consisting of non-negative integers.
 * You are also given an integer k.
 *
 * The value of coordinate (a, b) of the matrix is the XOR of all matrix[i][j] where 0 <= i <= a < m and 0 <= j <= b < n (0-indexed).
 *
 * Find the kth largest value (1-indexed) of all the coordinates of matrix.
 */
public class KthLargestValue {
    public int kthLargestValue(int[][] matrix, int k) {
        int N = matrix.length;
        int M = matrix[0].length;
        int[][] dp = new int[N][M];

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int x = i - 1 < 0 ? 0 : dp[i - 1][j];
                int y = j - 1 < 0 ? 0 : dp[i][j - 1];
                int z = i - 1 < 0 || j - 1 < 0 ? 0 : dp[i - 1][j - 1];

                dp[i][j] = x ^ y ^ z ^ matrix[i][j];
                priorityQueue.add(dp[i][j]);
                if (priorityQueue.size() > k)
                    priorityQueue.poll();
            }
        }
        return priorityQueue.poll();
    }
}
