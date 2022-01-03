package stack;

/**
 * 94. Binary Tree Inorder Traversal
 */

import java.util.ArrayList;
import java.util.List;

public class PostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorderTraversal(root, result);
        return result;
    }

    void postorderTraversal(TreeNode root, List<Integer> result) {
        if (root.left != null) {
            postorderTraversal(root.left, result);
        }
        if (root.right != null)
            postorderTraversal(root.right, result);
        result.add(root.val);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}
