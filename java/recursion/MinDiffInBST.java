package recursion;

public class MinDiffInBST {
    public static void main(String[] args) {

    }


    public int minDiffInBST(TreeNode root) {
        return 0;
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
