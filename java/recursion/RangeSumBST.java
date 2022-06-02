package recursion;

public class RangeSumBST {
    Integer sum = 0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        helper(root, low, high);
        return sum;
    }

    void helper(TreeNode current, int low, int high) {
        if(current == null)
            return;
        if(current.val >= low && current.val <= high)
            sum += current.val;

        helper(current.left, low, high);
        helper(current.right, low, high);
    }


     private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
     }
}
