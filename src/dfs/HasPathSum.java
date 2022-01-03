package dfs;

public class HasPathSum {
    public static void main(String[] args) {

    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null)
            return false;

        if (root.left == null && root.right == null && targetSum - root.val == 0)
            return true;

        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
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
