package bfs;

import java.util.LinkedList;
import java.util.Queue;

public class GetTargetCopy {

    static final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
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

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {this.val = val;}
    }
}
