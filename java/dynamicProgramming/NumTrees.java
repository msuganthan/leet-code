package dynamicProgramming;

/**
 * Unique Binary Search Trees
 *
 * Given an integer n, return the number of structurally unique BST's (binary search trees) which has exactly n nodes
 * of unique values from 1 to n.
 */
public class NumTrees {
    public static void main(String[] args) {

    }

    public int numTrees(int n) {
        int result = 0;

        if (n == 0 || n == 1)
            return 1;

        for (int i = 0; i < n; i++) {
            result += numTrees(i) * numTrees(n - i - 1);
        }
        return result;
    }
}
