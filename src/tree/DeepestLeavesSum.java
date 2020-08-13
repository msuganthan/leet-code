package tree;

import java.util.LinkedList;
import java.util.Queue;

public class DeepestLeavesSum {

    public static void main(String[] args) {
        TreeNode treeNode8 = new TreeNode(8, null, null);
        TreeNode treeNode6 = new TreeNode(6, null, treeNode8);
        TreeNode treeNode3 = new TreeNode(3, null, treeNode6);
        TreeNode treeNode5 = new TreeNode(5, null, null);
        TreeNode treeNode7 = new TreeNode(7, null, null);
        TreeNode treeNode4 = new TreeNode(4, treeNode7, null);
        TreeNode treeNode2 = new TreeNode(2, treeNode4, treeNode5);
        TreeNode treeNode1 = new TreeNode(1, treeNode2, treeNode3);

        System.out.println(deepestLeavesSum(treeNode1));

    }

    static int deepestLeavesSum(TreeNode root) {
        int res = 0, i;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            for (i = queue.size() - 1, res = 0; i >= 0 ; i--) {
                TreeNode current = queue.poll();
                res += current.val;

                if (current.right != null) queue.add(current.right);
                if (current.left  != null) queue.add(current.left);
            }
        }
        return res;
    }

    static class TreeNode {
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
