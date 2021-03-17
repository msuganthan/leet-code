package recursion;

public class RangeSumBST {
    public static void main(String[] args) {

    }

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
