package binarysearchtree;

public class SearchBST {

    static TreeNode searchBST(TreeNode root, int val) {
        while(root != null && root.val != val) {
            root = val < root.val ? root.left : root.right;
        }
        return root;
    }


    /**
     *     def searchBST(self, root: Optional[TreeNode], val: int) -> Optional[TreeNode]:
     *         while root and root.val != val:
     *             root = root.left if val < root.val else root.right
     *
     *         return root
     */

    /**
     * func searchBST(root *TreeNode, val int) *TreeNode {
     *     for root != nil && root.Val != val {
     *         if val < root.Val {
     *             root = root.Left
     *         } else {
     *             root = root.Right
     *         }
     *     }
     *     return root
     * }
     */

    static class TreeNode {
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
