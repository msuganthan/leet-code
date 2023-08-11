package dfs;

import java.util.LinkedList;
import java.util.Queue;

public class InvertTree {
    public TreeNode invertTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if(root != null){
            queue.offer(root);
        }
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                TreeNode current = queue.remove();

                TreeNode temp = current.left;
                current.left = current.right;
                current.right = temp;

                if(current.left != null) {
                    queue.add(current.left);
                }

                if(current.right != null) {
                    queue.add(current.right);
                }
            }
        }
        return root;
    }

    void swap(TreeNode node) {
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}
