package queue;

import java.util.TreeSet;

/**
 * Max Sum of Rectangle No Larger Than K
 *
 * Given a non-empty 2D matrix matrix and an integer k, find the max sum of a rectangle in the matrix such that
 * its sum is no larger than k.
 *
 * Input: matrix = [[1,0,1],[0,-2,3]], k = 2
 * Output: 2
 * Explanation: Because the sum of rectangle [[0, 1], [-2, 3]] is 2,
 *              and 2 is the max number no larger than k (k = 2).
 */
//ToDo: Have to come back
public class MaxSumSubmatrix {
    public static void main(String[] args) {

    }

    public int maxSumSubmatrix(int[][] matrix, int k) {
        int row = matrix.length, col = matrix[0].length;
        int result = Integer.MIN_VALUE;

        for (int i = 0; i < col; i++) {
            int[] sums = new int[row];
            for (int j = i; j < col; j++) {
                for (int l = 0; l < row; l++) {
                    sums[l] += matrix[l][j];
                }

                TreeSet<Integer> set = new TreeSet<>();
                set.add(0);
                int currSum = 0;
                for(int sum : sums) {
                    currSum += sum;
                    //we use sum subtraction (curSum - sum) to get the subarray with sum <= k
                    //therefore we need to look for the smallest sum >= currSum - k
                    Integer num = set.ceiling(currSum - k);
                    if (num != null)
                        result = Math.max(result, currSum - num);
                    set.add(currSum);
                }
            }
        }
        return result;
    }
}
