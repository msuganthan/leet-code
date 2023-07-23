package binarysearchtree;

import java.util.LinkedList;
import java.util.Queue;

public class RangeSumBST {
    Integer sum = 0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        helper(root, low, high);
        return sum;
    }

    void helper(TreeNode current, int low, int high) {
        if(current == null)
            return;
        if(current.val >= low && current.val <= high)
            sum += current.val;

        helper(current.left, low, high);
        helper(current.right, low, high);
    }

    public int rangeSumBST1(TreeNode root, int low, int high) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int sum = 0;
        while(!queue.isEmpty()) {
            TreeNode element = queue.remove();
            if(element.val >= low && element.val <= high) {
                sum += element.val;
            }

            if(element.left != null) {
                queue.add(element.left);
            }
            if(element.right != null) {
                queue.add(element.right);
            }
        }
        return sum;
    }

    /**
     * class Solution:
     *     sum = 0
     *     def rangeSumBST(self, root: Optional[TreeNode], low: int, high: int) -> int:
     *         self.helper(root, low, high)
     *         return self.sum
     *
     *     def helper(self, root: TreeNode, low: int, high: int):
     *         if root is None:
     *             return
     *
     *         if root.val >= low and root.val <= high:
     *             self.sum += root.val
     *
     *         self.helper(root.left, low, high)
     *         self.helper(root.right, low, high)
     *
     */

    /**
     * type RangeSumBST struct {
     *     sum int
     * }
     *
     *
     * func rangeSumBST(root *TreeNode, low int, high int) int {
     *     rsbst := RangeSumBST{}
     *     rsbst.helper(root, low, high)
     *     return rsbst.sum
     * }
     *
     * func (rsbst *RangeSumBST) helper(current * TreeNode, low, high int) {
     *     if current == nil {
     *         return
     *     }
     *
     *     if current.Val >= low && current.Val <= high {
     *         rsbst.sum += current.Val
     *     }
     *
     *     rsbst.helper(current.Left, low, high);
     *     rsbst.helper(current.Right, low, high);
     * }
     */

    /**
     * func sortedArrayToBST(nums []int) *TreeNode {
     *     return createNodes(nums, 0, len(nums) - 1)
     * }
     *
     * func createNodes(nums []int, start, end int) *TreeNode {
     *     if start > end {
     *         return nil
     *     }
     *
     *     mid := start + (end - start) / 2
     *     node := &TreeNode{Val: nums[mid]}
     *     node.Left = createNodes(nums, start, mid - 1)
     *     node.Right = createNodes(nums, mid + 1, end)
     *     return node
     * }
     */

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
     }
}
