package tree;

/**
 * 814. Binary Tree Pruning
 *
 * https://leetcode.com/problems/binary-tree-pruning/
 *
 * Given the root of a binary tree, return the same tree where every subtree (of the given tree)
 * not containing a 1 has been removed.
 *
 * A subtree of a node `node` is node plus every node that is a descendant of `node`.
 */
public class PruneTree {

    public TreeNode pruneTree(TreeNode root) {
        return containsOne(root) ? root : null;
    }

    boolean containsOne(TreeNode node) {
        if (node == null) return false;

        boolean leftContainsOne = containsOne(node.left);
        boolean rightContainsOne = containsOne(node.right);

        if (!leftContainsOne) node.left = null;

        if (!rightContainsOne) node.right = null;

        return node.val == 1 || leftContainsOne || rightContainsOne;
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}
