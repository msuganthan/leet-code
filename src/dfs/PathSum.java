package dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * 113. Path Sum II
 * https://leetcode.com/problems/path-sum-ii/
 *
 * Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where the sum of the
 * node values in the path equals targetSum. Each path should be returned as a list of the node values, not node
 * references.
 *
 * A root-to-leaf path is a path starting from the root and ending at any leaf node. A leaf is a node with no children.
 */
public class PathSum {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        pathSum(root, targetSum, new ArrayList(), result);
        return result;
    }

    void pathSum(TreeNode root, int target, ArrayList<Integer> currentList, List<List<Integer>> result) {
        if(root == null)
            return;

        currentList.add(root.val);
        if(root.left == null && root.right == null && target - root.val == 0) {
            result.add(new ArrayList(currentList));
        } else {
            pathSum(root.left, target - root.val, currentList, result);
            pathSum(root.right, target - root.val, currentList, result);
        }
        currentList.remove(currentList.size() - 1);
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
