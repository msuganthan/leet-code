package dfs;

public class IsValidBST {
    public static void main(String[] args) {

    }

    boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    boolean isValidBST(TreeNode root, Integer lowerBound, Integer upperBound) {
        if (root == null)
            return true;
        int val = root.val;
        //right value is lesser than lowerBound
        if (lowerBound != null && val <= lowerBound)
            return false;

        //left value is greater than upper bound
        if (upperBound != null && val > upperBound)
            return false;

        if (!isValidBST(root.left, lowerBound, root.val))
            return false;

        if (!isValidBST(root.right, root.val, upperBound))
            return false;

        return true;
    }


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
