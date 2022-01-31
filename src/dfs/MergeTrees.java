package dfs;

import java.util.Stack;

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

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}
