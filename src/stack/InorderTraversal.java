package stack;

/**
 * 94. Binary Tree Inorder Traversal
 */

import java.util.ArrayList;
import java.util.List;

public class InorderTraversal {
    public static void main(String[] args) {

    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderTraversal(root, result);
        return result;
    }

    void inorderTraversal(TreeNode root, List<Integer> result) {
        if (root.left != null)
            inorderTraversal(root.left, result);
        result.add(root.val);
        if (root.right != null)
            inorderTraversal(root.right, result);
    }



    public class TreeNode {
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
