package recursion;

public class GetTargetCopy {
    TreeNode answer, target;
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        this.target = target;
        inOrder(original, cloned);
        return answer;
    }

    void inOrder(TreeNode o, TreeNode c) {
        if(o == null)
            return;

        inOrder(o.left, c.left);
        if(o == target)
            answer = c;
        inOrder(o.right, c.right);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
