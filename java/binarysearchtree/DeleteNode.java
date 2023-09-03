package binarysearchtree;

/**
 * 450. Delete Node in a BST
 *
 * Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.
 *
 * Basically, the deletion can be divided into two stages:
 *
 * Search for a node to remove.
 * If the node is found, delete the node.
 */
public class DeleteNode {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return root;
        }

        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                TreeNode current = root.right;
                while (current.left != null) {
                    current = current.left;
                }
                root.val = current.val;
                root.right = deleteNode(root.right, current.val);
            }
        }
        return root;
    }

    /**
     *     def deleteNode(self, root: Optional[TreeNode], key: int) -> Optional[TreeNode]:
     *         if not root:
     *             return root
     *
     *         if key < root.val:
     *             root.left = self.deleteNode(root.left, key)
     *         elif key > root.val:
     *             root.right = self.deleteNode(root.right, key)
     *         else:
     *             if not root.left:
     *                 return root.right
     *             elif not root.right:
     *                 return root.left
     *             else:
     *                 current = root.right
     *                 while current.left:
     *                     current = current.left
     *
     *                 root.val = current.val
     *                 root.right = self.deleteNode(root.right, current.val)
     *         return root
     */

    /**
     * func deleteNode(root *TreeNode, key int) *TreeNode {
     *     if root == nil {
     *         return root
     *     }
     *
     *     if key < root.Val {
     *         root.Left = deleteNode(root.Left, key)
     *     } else if key > root.Val {
     *         root.Right = deleteNode(root.Right, key)
     *     } else {
     *         if root.Left == nil {
     *             return root.Right
     *         } else if root.Right == nil {
     *             return root.Left
     *         } else {
     *             current := root.Right
     *             for current.Left != nil {
     *                 current = current.Left
     *             }
     *             root.Val = current.Val
     *             root.Right = deleteNode(root.Right, current.Val)
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
