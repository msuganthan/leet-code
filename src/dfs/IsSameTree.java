package dfs;

import java.util.Stack;

public class IsSameTree {
    public static void main(String[] args) {

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
