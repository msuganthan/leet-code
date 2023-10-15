package bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevels {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> answer = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            double sum = 0.0;
            for(int i = 0; i < size; i++) {
                TreeNode element = queue.remove();
                sum += element.val;

                if(element.left != null) {
                    queue.add(element.left);
                }

                if(element.right != null) {
                    queue.add(element.right);
                }
            }
            answer.add(sum / size);
        }
        return answer;
    }

     static class TreeNode {
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
