package backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 257. Binary Tree Paths.
 * https://leetcode.com/problems/binary-tree-paths/
 *
 * Given the root of a binary tree, return all root-to-leaf paths in any order.
 *
 * A leaf is a node with no children.
 */
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> answer = new ArrayList<>();
        dfs(root, answer, new ArrayList<>());
        return answer;
    }

    void dfs(TreeNode node, List<String> answer, List<String> runningList) {
        if(node == null) {
            return;
        }
        runningList.add(String.valueOf(node.val));
        if(node.left == null && node.right == null) {
            answer.add(String.join("->", runningList));
        }

        dfs(node.left, answer, runningList);
        dfs(node.right, answer, runningList);
        runningList.remove(runningList.size() - 1);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}
