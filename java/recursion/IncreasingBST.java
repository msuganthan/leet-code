package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * 897. Increasing Order Search Tree
 *
 * Given the root of a binary search tree, rearrange the tree in in-order so that the leftmost node in the tree is now
 * the root of the tree, and every node has no left child and only one right child.
 *
 */
public class IncreasingBST {

    public TreeNode increasingBST1(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        inOrder(root, values);
        TreeNode treeNode = new TreeNode(0);
        TreeNode temp = treeNode;
        for(int val: values) {
            treeNode.right = new TreeNode(val);
            treeNode = treeNode.right;
        }
        return temp.right;
    }

    void inOrder(TreeNode treeNode, List<Integer> values) {
        inOrder(treeNode.left, values);
        values.add(treeNode.val);
        inOrder(treeNode.right, values);
    }

    TreeNode current;
    public TreeNode increasingBST(TreeNode root) {
        TreeNode ans = new TreeNode(0);
        current = ans;
        iterateRecursively(root);
        return ans.right;
    }

    void iterateRecursively(TreeNode node) {
        if (node == null)
            return;

        iterateRecursively(node.left);
        node.left = null;
        current.right = node;
        current = node;
        iterateRecursively(node.right);
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
    }
}
