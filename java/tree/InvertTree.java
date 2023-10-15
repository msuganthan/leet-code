package tree;

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

    public TreeNode invertTree1(TreeNode root) {
        if(root == null) {
            return null;
        }
        invertTree1(root.left);
        invertTree1(root.right);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}
