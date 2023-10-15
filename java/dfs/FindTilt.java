package dfs;

public class FindTilt {
    int totalTilt = 0;
    public int findTilt(TreeNode root) {
        dfs(root);
        return totalTilt;
    }

    int dfs(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        totalTilt += Math.abs(left - right);
        return root.val + left + right;
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
