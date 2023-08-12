package tree;

/**
 *
 * 572. Subtree of Another Tree
 *
 * Given the roots of two binary trees root and subRoot, return true if there is a subtree of root with the same structure and node values of subRoot and false otherwise.
 *
 * A subtree of a binary tree tree is a tree that consists of a node in tree and all of this node's descendants. The tree tree could also be considered as a subtree of itself.
 */
public class IsSubTree {

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }

        if (isIdentical(root, subRoot)) {
            return true;
        }

        return isSubtree(root.left, subRoot)
                || isSubtree(root.right, subRoot);
    }

    boolean isIdentical(TreeNode node1, TreeNode node2) {
        if (node1 == null || node2 == null) {
            return node1 == null && node2 == null;
        }

        return node1.val == node2.val &&
                isIdentical(node1.left, node2.left) &&
                isIdentical(node1.right, node2.right);
    }
    
    public static class TreeNode {
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
