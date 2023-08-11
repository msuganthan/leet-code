package dfs;

import java.util.Stack;

/**
 *
 * 100. Same Tree
 *
 * Given the roots of two binary trees p and q, write a function to check if they are the same or not.
 *
 * Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
 */
public class IsSameTree {

    boolean isSameTree1(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;

        if (p.val == q.val) {
            return isSameTree1(p.left, q.left) && isSameTree1(p.right, q.right);
        }
        return false;
    }
    boolean isSameTree(TreeNode p, TreeNode q) {
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.add(p);
        s2.add(q);

        while (!s1.isEmpty() && !s2.isEmpty()) {
            TreeNode first = s1.pop();
            TreeNode second = s2.pop();

            if (first == null && second == null)
                continue;

            if ((first == null && second != null)
                || (first != null && second == null)
                || (first.val != second.val))
                return false;

            s1.add(first.left);
            s1.add(first.right);

            s2.add(second.left);
            s2.add(second.right);
        }
        return true;
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
