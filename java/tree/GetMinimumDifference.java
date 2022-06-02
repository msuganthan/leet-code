package tree;

/**
 * 530. Minimum Absolute Difference in BST.
 * https://leetcode.com/problems/minimum-absolute-difference-in-bst/
 *
 * Given the root of a Binary Search Tree (BST), return the minimum absolute difference between the
 * values of any two different nodes in the tree.
 */
public class GetMinimumDifference {

    TreeNode prev;
    int minDiff = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        inOrder(root);
        return minDiff;
    }

    void inOrder(TreeNode root) {
        if (root == null)
            return;
        inOrder(root.left);
        if (prev != null)
            minDiff = Math.min(minDiff, root.val - prev.val);
        prev = root;
        inOrder(root.right);
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}
