package dfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 104. Maximum Depth of Binary Tree
 * Given the root of a binary tree, return its maximum depth.
 *
 * A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 */
public class MaxDepth {

    int maxDepthRecur(TreeNode root) {
        if (root == null)
            return 0;

        return 1 + Math.max(maxDepthRecur(root.left), maxDepthRecur(root.right));
    }

    int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                if(current.left != null) {
                    queue.add(current.left);
                }

                if(current.right != null) {
                    queue.add(current.right);
                }
            }
            depth++;
        }
        return depth;
    }

    /**
     *     def maxDepth(self, root: Optional[TreeNode]) -> int:
     *         if root is None:
     *             return 0
     *
     *         queue = deque()
     *         queue.append(root)
     *         depth = 0
     *
     *         while queue:
     *             size = len(queue)
     *             for i in range(size):
     *                 current = queue.popleft()
     *
     *                 if current.left:
     *                     queue.append(current.left)
     *
     *                 if current.right:
     *                     queue.append(current.right)
     *
     *             depth += 1
     *
     *         return depth
     */
    /**
     * func maxDepth(root *TreeNode) int {
     *     if root == nil {
     *         return 0
     *     }
     *
     *     queue := list.New()
     *     queue.PushBack(root)
     *     depth := 0
     *
     *     for queue.Len() > 0 {
     *         size := queue.Len()
     *         for i := 0; i < size; i++ {
     *             current := queue.Remove(queue.Front()).(*TreeNode)
     *
     *             if current.Left != nil {
     *                 queue.PushBack(current.Left)
     *             }
     *
     *             if current.Right != nil {
     *                 queue.PushBack(current.Right)
     *             }
     *         }
     *         depth++
     *     }
     *     return depth
     * }
     */


    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
