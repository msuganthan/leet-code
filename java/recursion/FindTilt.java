package recursion;

public class FindTilt {
    public static void main(String[] args) {

    }

    int totalTilt = 0;
    public int findTilt(TreeNode root) {
        this.valueSum(root);
        return this.totalTilt;
    }

    int valueSum(TreeNode node) {
        if (node == null)
            return 0;

        int left = valueSum(node.left);
        int right = valueSum(node.right);
        int tilt = Math.abs(left - right);
        this.totalTilt += tilt;
        return node.val + left + right;
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
