package recursion;

import java.util.HashMap;

/**
 * 865. Smallest Subtree with all the Deepest Nodes
 *
 * Given the root of a binary tree, the depth of each node is the shortest distance to the root.
 *
 * Return the smallest subtree such that it contains all the deepest nodes in the original tree.
 *
 * A node is called the deepest if it has the largest depth possible among any node in the entire tree.
 *
 * The subtree of a node is tree consisting of that node, plus the set of all descendants of that node.
 */
public class SubtreeWithAllDeepest {
    public static void main(String[] args) {

    }

    HashMap<TreeNode, Integer> depth = new HashMap<>();
    int max_depth = Integer.MIN_VALUE;
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        depth.put(null, -1);
        dfs(root, null);
        for (Integer d: depth.values())
            max_depth = Math.max(max_depth, d);

        return answer(root);
    }

    void dfs(TreeNode node, TreeNode parent) {
        if (node != null) {
            depth.put(node, depth.get(parent) + 1);
            dfs(node.left, node);
            dfs(node.right, node);
        }
    }

    public TreeNode answer(TreeNode node) {
        if (node == null || depth.get(node) == max_depth)
            return node;

        TreeNode L = answer(node.left), R = answer(node.right);
        if (L != null && R != null) return node;
        if (L != null) return L;
        if (R != null) return R;
        return null;
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
