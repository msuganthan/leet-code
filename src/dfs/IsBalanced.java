package dfs;

public class IsBalanced {

    boolean isBalanced = true;
    public static void main(String[] args) {

    }

    boolean isBalanced(TreeNode root) {
        backTrack(root);
        return isBalanced;
    }

    int backTrack(TreeNode root) {
        if (root == null)
            return 0;

        int left = backTrack(root.left);
        int rigt = backTrack(root.right);

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
