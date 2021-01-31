package array;

import java.util.PriorityQueue;

public class KthLargestValue {
    public static void main(String[] args) {

    }

    static int kthLargestValue(int[][] matrix, int K) {
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
                if (priorityQueue.size() > K)
                    priorityQueue.poll();
            }
        }
        return priorityQueue.poll();
    }
}
