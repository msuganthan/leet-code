package bfs;

import java.util.LinkedList;
import java.util.Queue;

public class MaxLevelSum {

    public int maxLevelSum(TreeNode root) {
        int maxSum = Integer.MIN_VALUE;
        int depth = 0, answer = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            depth++;
            int runningSum = 0;

            int size = queue.size();
            for(int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                runningSum += current.val;

                if(current.left != null) {
                    queue.add(current.left);
                }

                if(current.right != null) {
                    queue.add(current.right);
                }
            }
            if(maxSum < runningSum) {
                maxSum = runningSum;
                answer = depth;
            }
        }
        return answer;
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
