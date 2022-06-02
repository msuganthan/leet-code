package bfs;

import java.util.LinkedList;
import java.util.Queue;

public class MaxLevelSum {
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode0 = new TreeNode(0);
        TreeNode treeNode77 = new TreeNode(7);
        TreeNode treeNode_8 = new TreeNode(8);

        treeNode7.left = treeNode77;
        treeNode7.right = treeNode_8;

        treeNode1.left = treeNode7;
        treeNode1.right = treeNode0;

        System.out.println(maxLevelSum(treeNode1));
    }

    static int maxLevelSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int maxSum = root.val;
        int level = 0;
        int maxLevel = level;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int levelSum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();

                levelSum += current.val;

                if (current.left != null)
                    queue.add(current.left);

                if (current.right != null)
                    queue.add(current.right);
            }
            level++;
            if (maxSum < levelSum) {
                maxSum = levelSum;
                maxLevel = level;
            }
        }
        return maxLevel;
    }


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) {this.val = val;}
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
