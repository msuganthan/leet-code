package tree;

public class EvenGrandParentSum {

    public int sumEvenGrandparent(TreeNode root) {
        return helper(root, null, null);
    }

    int helper(TreeNode current, TreeNode parent, TreeNode grandParent) {
        int sum = 0;
        if (current == null)
            return 0;

        if (grandParent != null && grandParent.val % 2 == 0)
            sum += current.val;

        sum += helper(current.left, current, parent);
        sum += helper(current.right, current, parent);
        return sum;

    }


    static class TreeNode {
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
