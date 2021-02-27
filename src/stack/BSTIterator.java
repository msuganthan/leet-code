package stack;

import java.util.ArrayList;
import java.util.List;

public class BSTIterator {
    List<Integer> sorted;
    int index;
    public BSTIterator(TreeNode root) {
        this.sorted = new ArrayList<>();
        this.index = -1;
        this.inOrder(root);
    }

    public int next() {
        return this.sorted.get(++this.index);
    }

    public boolean hasNext() {
        return this.index + 1 < this.sorted.size();
    }

    private void inOrder(TreeNode root) {
        if(root == null)
            return;

        inOrder(root.left);
        sorted.add(root.val);
        inOrder(root.right);
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
