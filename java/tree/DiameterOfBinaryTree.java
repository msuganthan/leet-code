package tree;

/**
 * 543. Diameter of Binary Tree
 *
 * Given the root of a binary tree, return the length of the diameter of the tree.
 *
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
 *
 * The length of a path between two nodes is represented by the number of edges between them.
 */
public class DiameterOfBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        DiameterOfBinaryTree diameterOfBinaryTree = new DiameterOfBinaryTree();
        diameterOfBinaryTree.diameterOfBinaryTree(root);
    }

    private int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return diameter;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftDepth = dfs(node.left);
        int rightDepth = dfs(node.right);
        diameter = Math.max(diameter, leftDepth + rightDepth);

        return Math.max(leftDepth, rightDepth) + 1;
    }

    /**
     * class Solution:
     *     def __init__(self):
     *         self.diameter = 0
     *
     *     def depth(self, node: Optional[TreeNode]) -> int:
     *         left = self.depth(node.left) if node.left else 0
     *         right = self.depth(node.right) if node.right else 0
     *
     *         if left + right > self.diameter:
     *             self.diameter = left + right
     *
     *         return 1 + (left if left > right else right)
     *
     *     def diameterOfBinaryTree(self, root: Optional[TreeNode]) -> int:
     *         self.depth(root)
     *         return self.diameter
     */

    /**
     * func diameterOfBinaryTree(root *TreeNode) int {
     *    max := 0
     *    var dfs func(node *TreeNode) int
     *     dfs = func(node *TreeNode) int {
     *         if node == nil { return 0 }
     *         left, right := dfs(node.Left), dfs(node.Right)
     *         max = Max(max, left+right)
     *         return 1+Max(left, right)
     *     }
     *     dfs(root)
     *     return max
     * }
     *
     * func Max(a, b int) int { if a > b { return a }; return b }
     */
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}
