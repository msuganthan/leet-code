package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ZigzagLevelOrder {

    public static void main(String[] args) {

    }

    List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null)
            return result;
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        List<Integer> currentLevel = new ArrayList<>();
        stack1.add(root);
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                TreeNode pop = stack1.pop();
                currentLevel.add(pop.val);
                if (pop.left != null)
                    stack2.add(pop.left);
                if (pop.right != null)
                    stack2.add(pop.right);
            }
            if (!currentLevel.isEmpty())
                result.add(new ArrayList<>(currentLevel));
            currentLevel.clear();

            while (!stack2.isEmpty()) {
                TreeNode pop = stack2.pop();
                currentLevel.add(pop.val);
                if (pop.right != null)
                    stack1.add(pop.right);
                if (pop.left != null)
                    stack1.add(pop.left);
            }
            if (!currentLevel.isEmpty())
                result.add(new ArrayList<>(currentLevel));
            currentLevel.clear();
        }
        return result;
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
