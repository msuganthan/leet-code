package binarysearchtree;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class FindTarget {
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> container = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            TreeNode element = queue.remove();

            if(container.contains(k - element.val)) {
                return true;
            }
            container.add(element.val);

            if(element.left != null) {
                queue.add(element.left);
            }

            if(element.right != null) {
                queue.add(element.right);
            }
        }
        return false;
    }

    Set<Integer> container = new HashSet<>();
    public boolean findTarget1(TreeNode root, int k) {
        return inorder(root, k);
    }

    boolean inorder(TreeNode current, int k) {
        if(current == null) {
            return false;
        }
        if(container.contains(k - current.val)) {
            return true;
        }
        container.add(current.val);
        return inorder(current.left, k) || inorder(current.right, k);
    }

    /**
     * class Solution:
     *     def __init__(self):
     *         self.container = set()
     *
     *     def inorder(self, current, k):
     *         if current is None:
     *             return False
     *
     *         if k - current.val in self.container:
     *             return True
     *
     *         self.container.add(current.val)
     *         return self.inorder(current.left, k) or self.inorder(current.right, k)
     *
     *     def findTarget(self, root: Optional[TreeNode], k: int) -> bool:
     *         return self.inorder(root, k)
     */

    /**
     * var container map[int]struct{}
     * func findTarget(root *TreeNode, k int) bool {
     *     container = make(map[int]struct{})
     *     return inorder(root, k)
     * }
     *
     * func inorder(current *TreeNode, k int) bool {
     *     if current == nil {
     *         return false
     *     }
     *
     *     if _, ok := container[k - current.Val]; ok {
     *         return true
     *     }
     *
     *     container[current.Val] = struct{}{}
     *
     *     return inorder(current.Left, k) || inorder(current.Right, k)
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
