package stack;

/**
 * 94. Binary Tree Inorder Traversal
 */

import java.util.ArrayList;
import java.util.List;

public class PreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorderTraversal(root, result);
        return result;
    }

    void preorderTraversal(TreeNode root, List<Integer> result) {
        result.add(root.val);
        if (root.left != null) {
            preorderTraversal(root.left, result);
        }
        if (root.right != null)
            preorderTraversal(root.right, result);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}
