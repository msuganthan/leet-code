package dfs;

public class InvertTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;

        swap(root);
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    void swap(TreeNode node) {
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}
