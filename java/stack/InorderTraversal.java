package stack;

/**
 * 94. Binary Tree Inorder Traversal
 */

import java.util.ArrayList;
import java.util.List;

public class InorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderTraversal(root, result);
        return result;
    }

    void inorderTraversal(TreeNode root, List<Integer> result) {
        if(root != null) {
            inorderTraversal(root.left, result);
            result.add(root.val);
            inorderTraversal(root.right, result);
        }
    }

    /**
     *     public List<Integer> inorderTraversal(TreeNode root) {
     *         List<Integer> answer = new ArrayList<>();
     *         Stack<TreeNode> stack = new Stack<>();
     *         TreeNode curr = root;
     *         while(curr != null || !stack.empty()) {
     *             while(curr != null) {
     *                 stack.push(curr);
     *                 curr = curr.left;
     *             }
     *             curr = stack.pop();
     *             answer.add(curr.val);
     *             curr = curr.right;
     *         }
     *         return answer;
     *     }
     */

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
