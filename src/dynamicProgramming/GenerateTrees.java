package dynamicProgramming;

import java.util.ArrayList;
import java.util.List;

/**
 * ToDo: Come back to this question
 * 95. Unique Binary Search Trees II
 *
 * Given an integer n, return all the structurally unique BST's (binary search trees), which has exactly n nodes of
 * unique values from 1 to n. Return the answer in any order.
 *
 * Input: n = 3
 * Output: [[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]
 */

public class GenerateTrees {
    public static void main(String[] args) {

    }

    public List<TreeNode> generateTrees(int n) {
        if(n == 0)
            return new ArrayList<>();
        return helper(1, n);
    }

    List<TreeNode> helper(int start, int end) {
        List<TreeNode> result = new ArrayList<>();
        
        if (start > end)
            result.add(null);

        for (int index = start; index <= end; index++) {
            List<TreeNode> leftTree = helper(start, index - 1);
            List<TreeNode> rightTree = helper(index + 1, end);

            for (TreeNode left: leftTree) {
                for (TreeNode right: rightTree) {
                    TreeNode root = new TreeNode(index);
                    root.left = left;
                    root.right = right;
                    result.add(root);
                }
            }
        }
        return result;
    }
}

class TreeNode {
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

