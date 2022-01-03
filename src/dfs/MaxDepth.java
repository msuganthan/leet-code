package dfs;

import java.util.LinkedList;
import java.util.Queue;

public class MaxDepth {
    public static void main(String[] args) {

    }

    int maxDepthRecur(TreeNode root) {
        if (root == null)
            return 0;

        return 1 + Math.max(maxDepthRecur(root.left), maxDepthRecur(root.right));
    }

    int maxDepth(TreeNode root) {
        int depth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();

                if (current.left != null)
                    queue.add(current.left);

                if (current.right != null)
                    queue.add(current.right);
            }
            depth++;
        }
        return depth;
    }


    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
