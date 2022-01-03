package dfs;

public class MinDepth {
    public static void main(String[] args) {

    }

    int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null) return minDepth(root.left) + 1;
        if (root.right == null) return minDepth(root.right) + 1;
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
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
