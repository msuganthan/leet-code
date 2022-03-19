package dfs;


/**
 * 98. Validate Binary Search Tree
 *
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 *
 * A valid BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 */
public class IsValidBST {
    boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    boolean isValidBST(TreeNode root, Integer lowerBound, Integer upperBound) {
        if (root == null) {
            return true;
        }

        int val = root.val;
        if (upperBound != null && val >= upperBound) {
            return false;
        }

        if (lowerBound != null && val <= lowerBound) {
            return false;
        }

        if (!isValidBST(root.left, lowerBound, root.val)) {
            return false;
        }

        if (!isValidBST(root.right, root.val, upperBound)) {
            return false;
        }
        return true;
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
