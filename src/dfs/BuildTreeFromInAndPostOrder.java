package dfs;

public class BuildTreeFromInAndPostOrder {
    public static void main(String[] args) {

    }

    TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, inorder.length - 1, 0, postorder, postorder.length - 1);
    }

    TreeNode buildTree(int[] iOrder, int iStart, int iEnd, int[] postOrder, int pStart) {
        if (pStart < 0 || iStart < iEnd)
            return null;

        TreeNode root = new TreeNode(postOrder[pStart]);
        int index = 0;
        for (int i = iStart; i >= iEnd; i--) {
            if (iOrder[i] == postOrder[pStart]) {
                index = i;
                break;
            }
        }

        root.left = buildTree(iOrder, index - 1, iEnd, postOrder, pStart - (iStart - index) - 1);
        root.right = buildTree(iOrder, iStart, index + 1, postOrder, pStart - 1);

        return root;
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
