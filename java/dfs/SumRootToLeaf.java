package dfs;

public class SumRootToLeaf {
    public int sumRootToLeaf(TreeNode root) {
        return inorder(root, 0);
    }

    int inorder(TreeNode root, int prevSum) {
        if(root == null) {
            return 0;
        }
        prevSum = 2 * prevSum + root.val;
        if(root.left == null && root.right == null) {
            return prevSum;
        }
        return inorder(root.left, prevSum) + inorder(root.right, prevSum);
    }

    
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
