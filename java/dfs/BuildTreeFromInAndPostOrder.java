package dfs;

public class BuildTreeFromInAndPostOrder {
    TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, inorder.length - 1, 0, postorder, postorder.length - 1);
    }

    TreeNode buildTree(int[] inOrder, int inStart, int inEnd, int[] postOrder, int postStart) {
        if (postStart < 0 || inStart < inEnd)
            return null;

        TreeNode root = new TreeNode(postOrder[postStart]);
        int index = 0;
        for (int i = inStart; i >= inEnd; i--) {
            if (inOrder[i] == postOrder[postStart]) {
                index = i;
                break;
            }
        }

        root.left = buildTree(inOrder, index - 1, inEnd, postOrder, postStart - (inStart - index) - 1);
        root.right = buildTree(inOrder, inStart, index + 1, postOrder, postStart - 1);

        return root;
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
