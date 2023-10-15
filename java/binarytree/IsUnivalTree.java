package binarytree;

public class IsUnivalTree {
    public boolean isUnivalTree(TreeNode root) {
        return helper(root, null);
    }

    boolean helper(TreeNode node, TreeNode prev) {
        if(node == null) {
            return true;
        }

        if(prev != null && prev.val != node.val) {
            return false;
        }
        return helper(node.left, node) && helper(node.right, node);
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
