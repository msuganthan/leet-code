package tree;

/**
 * 1325. Delete Leaves With a Given Value
 *
 * https://leetcode.com/problems/delete-leaves-with-a-given-value/
 *
 * Given a binary tree root and an integer target, delete all the leaf nodes with value target.
 *
 * Note that once you delete a leaf node with value target, if its parent node becomes a leaf node and has
 * the value target, it should also be deleted (you need to continue doing that until you cannot).
 */
public class RemoveLeafNodes {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root.left != null) root.left = removeLeafNodes(root.left, target);
        if (root.right != null) root.right = removeLeafNodes(root.right, target);
        return root.left == root.right && root.val == target ? null : root;
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}
