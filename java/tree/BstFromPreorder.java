package tree;

public class BstFromPreorder {
    int index = 0;
    public TreeNode bstFromPreorder(int[] preorder) {
        return helper(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    TreeNode helper(int[] preorder, int start, int end) {
        if(index == preorder.length
                || preorder[index] < start || preorder[index] > end) {
            return null;
        }

        int val = preorder[index++];
        TreeNode root = new TreeNode(val);
        root.left = helper(preorder, start, val);
        root.right = helper(preorder, val, end);
        return root;
    }
}
