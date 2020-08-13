package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrderTraversal {

    static List<Integer> inOrderElements = new ArrayList<>();

    public static void main(String[] args) {
        /**
         *      3
         *    /   \
         *   9    20
         *  / \  /  \
         * 5  1 15   7
         */
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode9 = new TreeNode(9);
        treeNode9.left     = treeNode5;
        treeNode9.right    = treeNode1;

        TreeNode treeNode20 = new TreeNode(20);
        TreeNode treeNode15 = new TreeNode(15);
        TreeNode treeNode7 = new TreeNode(7);


        treeNode20.left  = treeNode15;
        treeNode20.right = treeNode7;

        treeNode3.left   = treeNode9;
        treeNode3.right  = treeNode20;

        System.out.println("*** Recursive ***");
        inOrderTraversal(treeNode3)
                .stream()
                .forEach(ele -> System.out.print(ele + " "));

        inOrderElements.clear();
        System.out.println("\n\n\n*** Iterative ***");
        inOrderTraversalItr(treeNode3)
                .stream()
                .forEach(ele -> System.out.print(ele + " "));
    }

    public static List<Integer> inOrderTraversal(TreeNode tree) {
        if (tree == null)
            return inOrderElements;

        if (tree.left != null)
            inOrderTraversal(tree.left);

            inOrderElements.add(tree.val);

        if (tree.right != null)
            inOrderTraversal(tree.right);

        return inOrderElements;
    }


    public static List<Integer> inOrderTraversalItr(TreeNode node) {
        //Traverse to the left most as possible.
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur          = node;
        while(cur != null || !stack.empty()) {
            while(cur != null) {
                stack.add(cur);
                cur = cur.left;
            }

            cur = stack.pop();
            inOrderElements.add(cur.val);
            cur = cur.right;
        }
        return inOrderElements;

    }


    static public class TreeNode {
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
