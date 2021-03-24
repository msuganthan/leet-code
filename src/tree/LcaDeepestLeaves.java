package tree;

import java.util.HashMap;

public class LcaDeepestLeaves {

    public static void main(String[] args) {

    }

    HashMap<TreeNode, Integer> depth = new HashMap<>();
    int max_depth = Integer.MIN_VALUE;
    public TreeNode lcaDeepestLeaves(TreeNode root) {
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
