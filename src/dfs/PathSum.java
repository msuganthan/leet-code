package dfs;

import java.util.ArrayList;
import java.util.List;

public class PathSum {
    public static void main(String[] args) {

    }

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
