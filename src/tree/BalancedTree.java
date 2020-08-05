package tree;

public class BalancedTree {

    public static void main(String[] args) {
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode9 = new TreeNode(9);
        TreeNode treeNode20 = new TreeNode(20);
        TreeNode treeNode15 = new TreeNode(15);
        TreeNode treeNode7 = new TreeNode(7);


        treeNode20.left  = treeNode15;
        treeNode20.right = treeNode7;

        treeNode3.left   = treeNode9;
        treeNode3.right  = treeNode20;

        BalancedTree balancedTree = new BalancedTree();
        balancedTree.isBalanced(treeNode3);
    }

    boolean isBalanced = true;
    public boolean isBalanced(TreeNode root) {
        if(root == null) return isBalanced;

        backTrack(root);
        return isBalanced;
    }

    private int backTrack(TreeNode root) {
        if( root == null)
            return 0;

        int left = backTrack(root.left);
        int right = backTrack(root.right);

        if(Math.abs(left - right) > 1)
            isBalanced = false;

        return Math.max(left, right) + 1;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
        }
    }

}
