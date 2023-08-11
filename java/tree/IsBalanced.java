package tree;

/**
 * 110. Balanced Binary Tree
 *
 * Given a binary tree, determine if it is
 * height-balanced
 * .
 */
public class IsBalanced {

    boolean isBalanced = true;
    boolean isBalanced(TreeNode root) {
        dfs(root);
        return isBalanced;
    }

    int dfs(TreeNode root) {
        if (root == null)
            return 0;

        int left = dfs(root.left);
        int rigt = dfs(root.right);

        if (Math.abs(left - rigt) > 1)
            isBalanced = false;

        return Math.max(left, rigt) + 1;
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
