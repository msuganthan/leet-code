package binarysearchtree;

/**
 *
 * 701. Insert into a Binary Search Tree
 *
 *
 * You are given the root node of a binary search tree (BST) and a value to insert into the tree. Return the root node of the BST after the insertion. It is guaranteed that the new value does not exist in the original BST.
 *
 * Notice that there may exist multiple valid ways for the insertion, as long as the tree remains a BST after insertion. You can return any of them.
 */
public class InsertIntoBST {

    /**
     *
     * public TreeNode insertIntoBST(TreeNode root, int val) {
     *         if (root == null) return new TreeNode(val);
     *         TreeNode curr = root;
     *         TreeNode prev = null;
     *         while(curr != null) {
     *             prev = curr;
     *             if(val < curr.val) curr = curr.left;
     *             else curr = curr.right;
     *         }
     *         if(val < prev.val) {
     *             prev.left = new TreeNode(val);
     *         } else {
     *             prev.right = new TreeNode(val);
     *         }
     *         return root;
     *     }
     */

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) {
            return new TreeNode(val);
        }
        if(val < root.val)
            root.left = insertIntoBST(root.left, val);
        else
            root.right = insertIntoBST(root.right, val);
        return root;
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
