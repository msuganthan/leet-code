package tree;

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
        searchBT(root, "", answer);
        return answer;
    }

    void searchBT(TreeNode root, String path, List<String> answers) {
        if(root.left == null && root.right == null) answers.add(path + root.val);
        if (root.left != null) searchBT(root.left, path + root.val + "->", answers);
        if (root.right != null) searchBT(root.right, path + root.val + "->", answers);
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}
