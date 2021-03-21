package queue;

import java.util.ArrayList;
import java.util.List;

/**
 * Binary Tree Right Side View
 *
 * Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes
 * you can see ordered from top to bottom.
 */
public class RightSideView {
    public static void main(String[] args) {

    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        rightView(root, result, 0);
        return result;
    }

    void rightView(TreeNode current, List<Integer> result, int depth) {
        if (current == null)
            return;

        if (depth == result.size())
            result.add(current.val);

        rightView(current.right, result, depth + 1);
        rightView(current.left, result, depth + 1);
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
