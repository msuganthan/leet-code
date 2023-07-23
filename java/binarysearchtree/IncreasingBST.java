package binarysearchtree;

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
        TreeNode answer = new TreeNode(0);
        current = answer;
        inOrder(root);
        return answer.right;
    }

    void inOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        inOrder(root.left);
        root.left = null;
        current.right = root;
        current = root;
        inOrder(root.right);
    }

    /**
     *     def increasingBST(self, root: TreeNode) -> TreeNode:
     *         def in_order(node):
     *             nonlocal current
     *             if not node:
     *                 return
     *             in_order(node.left)
     *             node.left = None
     *             current.right = node
     *             current = node
     *             in_order(node.right)
     *
     *         answer = TreeNode(0)
     *         current = answer
     *         in_order(root)
     *         return answer.right
     */

    /**
     * var prev *TreeNode
     * func increasingBST(root *TreeNode) *TreeNode {
     *     answer := &TreeNode{}
     *     prev = answer
     *     inOrder(root)
     *     return answer.Right
     * }
     *
     * func inOrder(root *TreeNode) {
     *     if root == nil {
     *         return
     *     }
     *
     *     inOrder(root.Left)
     *     prev.Right = root
     *     prev = root
     *     prev.Left = nil
     *
     *     inOrder(root.Right)
     * }
     */

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
    }
}
