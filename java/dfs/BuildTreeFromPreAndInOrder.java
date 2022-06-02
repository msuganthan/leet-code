package dfs;

public class BuildTreeFromPreAndInOrder {
    /**
     * preorder = [3,9,20,15,7]
     * inorder = [9,3,15,20,7]
     *
     * Pre order is gonna be static
     * In order is gonna be dynamic
     */
    TreeNode buildTree(int[] preOrder, int[] inOrder) {
        return buildTree(preOrder, 0, preOrder.length - 1, inOrder, 0);
    }

    TreeNode buildTree(int[] iOrder, int iStart, int iEnd, int[] pOrder, int pStart) {
        if(pStart > pOrder.length - 1 || iStart > iEnd)
            return null;

        TreeNode root = new TreeNode(pOrder[pStart]);
        int index = 0;
        for(int i = 0; i <= iEnd; i++) {
            if(iOrder[i] == root.val) {
                index = i;
                break;
            }
        }

        root.left = buildTree(iOrder, iStart, index - 1, pOrder, pStart + 1);
        root.right = buildTree(iOrder, index + 1, iEnd, pOrder, pStart + index - iStart + 1);

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
