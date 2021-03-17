package recursion;

import java.util.ArrayList;
import java.util.List;

public class IncreasingBST {

    public static void main(String[] args) {
    }

    public TreeNode increasingBST(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        inOrder(root, values);
        TreeNode treeNode = new TreeNode(0);
        TreeNode temp = treeNode;
        for(int val: values) {
            treeNode.right = new TreeNode(val);
            treeNode = treeNode.right;
        }
        return temp.right;
    }

    void inOrder(TreeNode treeNode, List<Integer> values) {
        inOrder(treeNode.left, values);
        values.add(treeNode.val);
        inOrder(treeNode.right, values);
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
