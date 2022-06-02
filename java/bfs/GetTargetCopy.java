package bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 1379. Find a Corresponding Node of a Binary Tree in a Clone of That Tree
 *
 * Given two binary trees original and cloned and given a reference to a node target in the original tree.
 *
 * The cloned tree is a copy of the original tree.
 *
 * Return a reference to the same node in the cloned tree.
 *
 * Note that you are not allowed to change any of the two trees or the target node and the answer must be a reference to a node in the cloned tree.
 */

public class GetTargetCopy {

    static TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        Queue<TreeNode[]> queue = new LinkedList<>();
        queue.add(new TreeNode[] {original, cloned});

        while (!queue.isEmpty()) {
            TreeNode[] treeNodes = queue.poll();

            if (treeNodes[0] == target)
                return treeNodes[1];

            if (treeNodes[0].left != null)
                queue.add(new TreeNode[]{treeNodes[0].left, treeNodes[1].left});

            if (treeNodes[0].right != null)
                queue.add(new TreeNode[]{treeNodes[0].right, treeNodes[1].right});
        }
        return null;
    }

    /**
     * def getTargetCopy(self, original, cloned, target):
     *  queue = []
     *  queue.append([original, cloned])
     *
     *  while queue:
     *      treeNodes = queue.pop(0)
     *
     *      if treeNodes[0] == target:
     *          return treeNodes[1]
     *
     *      if treeNodes[0].left is not None:
     *          queue.append([treeNodes[0].left, treeNodes[1].left])
     *
     *      if treeNodes[0].right is not None:
     *          queue.append([treeNodes[0].right, treeNodes[1].right])
     *
     *  return None
     */

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {this.val = val;}
    }
}
