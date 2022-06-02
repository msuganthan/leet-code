package dfs;

public class RecoverTree {

    TreeNode firstElement = null;
    TreeNode secondElement = null;
    TreeNode prevElement = null;
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

        if (firstElement == null && (prevElement == null || prevElement.val >= root.val))
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
    }

}
