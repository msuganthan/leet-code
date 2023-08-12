package tree;

import java.util.Stack;

/**
 * 617. Merge Two Binary Trees
 *
 * You are given two binary trees root1 and root2.
 *
 * Imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not. You need to merge the two trees into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of the new tree.
 *
 * Return the merged tree.
 *
 * Note: The merging process must start from the root nodes of both trees.
 */
public class MergeTrees {

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null)
            return t2;

        Stack<TreeNode[]> stack = new Stack();
        stack.push(new TreeNode[] {t1, t2});

        while(!stack.isEmpty()) {
            TreeNode[] curr = stack.pop();

            if(curr[1] == null)
                continue;

            curr[0].val += curr[1].val;

            if(curr[0].left == null && curr[1].left != null)
                curr[0].left = curr[1].left;
            else
                stack.push(new TreeNode[] {curr[0].left, curr[1].left});

            if(curr[0].right == null && curr[1].right != null)
                curr[0].right = curr[1].right;
            else
                stack.push(new TreeNode[] {curr[0].right, curr[1].right});
        }
        return t1;
    }

    public TreeNode mergeTrees1(TreeNode root1, TreeNode root2) {
        if(root1 == null) {
            return root2;
        }

        if(root2 == null) {
            return root1;
        }

        root1.val = root1.val + root2.val;

        root1.left = mergeTrees1(root1.left, root2.left);
        root1.right = mergeTrees1(root1.right, root2.right);
        return root1;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}
