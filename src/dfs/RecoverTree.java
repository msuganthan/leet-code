package dfs;

public class RecoverTree {

    TreeNode firstElement = null;
    TreeNode secondElement = null;

    TreeNode prevElement = new TreeNode(Integer.MIN_VALUE);
    public static void main(String[] args) {

    }

    void recoverTree(TreeNode root) {
        traverse(root);
        int temp = firstElement.val;
        firstElement.val = secondElement.val;
        secondElement.val = temp;
    }

    void traverse(TreeNode root) {
        if (root == null)
            return;

        traverse(root.left);

        if (firstElement == null && prevElement.val >= root.val)
            firstElement = prevElement;

        if (firstElement != null && prevElement.val >= root.val)
            secondElement = root;

        prevElement = root;

        traverse(root.right);
    }


    private class TreeNode {
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
