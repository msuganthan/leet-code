package bfs;

import java.util.*;

public class DistanceK {

    static Map<TreeNode, TreeNode> parentMap;
    static List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        parentMap = new HashMap<>();
        dfs(root, null);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(target);

        Set<TreeNode> seen = new HashSet<>();
        seen.add(target);

        int distance = 0;
        while (!queue.isEmpty()) {
            if (distance == K) {
                List<Integer> answer = new ArrayList<>();
                for (TreeNode node : queue)
                    answer.add(node.val);
                return answer;
            }
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.poll();
                seen.add(treeNode);
                if (treeNode.left != null && !seen.contains(treeNode.left)) {
                    seen.add(treeNode.left);
                    queue.offer(treeNode.left);
                }
                if (treeNode.right != null && !seen.contains(treeNode.right)) {
                    seen.add(treeNode.right);
                    queue.offer(treeNode.right);
                }
                TreeNode parentNode = parentMap.get(treeNode);
                if (parentNode != null && !seen.contains(parentNode)) {
                    seen.add(parentNode);
                    queue.offer(parentNode);
                }
            }
            distance++;
        }
        return new ArrayList<>();
    }

    static void dfs(TreeNode node, TreeNode parent) {
        if (node != null) {
            parentMap.put(node, parent);
            dfs(node.left, node);
            dfs(node.right, node);
        }
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) {this.val = val;}
    }
}
