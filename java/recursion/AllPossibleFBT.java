package recursion;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * All Possible Full Binary Trees
 *
 * Given an integer n, return a list of all possible full binary trees with n nodes.
 * Each node of each tree in the answer must have Node.val == 0.
 *
 * Each element of the answer is the root node of one possible tree. You may return the
 * final list of trees in any order.
 *
 * A full binary tree is a binary tree where each node has exactly 0 or 2 children.
 *
 * Input: n = 7
 * Output: [[0,0,0,null,null,0,0,null,null,0,0],
 *          [0,0,0,null,null,0,0,0,0],
 *          [0,0,0,0,0,0,0],
 *          [0,0,0,0,0,null,null,null,null,0,0],
 *          [0,0,0,0,0,null,null,0,0]]
 */
public class AllPossibleFBT {

    Map<Integer, List<TreeNode>> memo = new HashMap<>();
    public List<TreeNode> allPossibleFBT(int n) {
        if (!memo.containsKey(n)) {
            List<TreeNode> ans = new LinkedList<>();
            if (n == 1) {
                ans.add(new TreeNode(0));
            } else if (n % 2 == 1) {
                for (int l = 0; l < n; ++l) {
                    int r = n - 1 - l;
                    for (TreeNode left: allPossibleFBT(l))
                        for (TreeNode right: allPossibleFBT(r)) {
                            ans.add(new TreeNode(0, left, right));
                        }
                }
            }
            memo.put(n, ans);
        }
        return memo.get(n);
    }

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
