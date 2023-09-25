package recursion;

public class MinDiffInBST {

    Integer result = Integer.MAX_VALUE, pre = null;
    public int minDiffInBST(TreeNode root) {
        if(root.left != null) {
            minDiffInBST(root.left);
        }
        if(pre != null) {
            result = Math.min(result, root.val - pre);
        }
        pre = root.val;
        if(root.right != null) {
            minDiffInBST(root.right);
        }
        return result;
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
