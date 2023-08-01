package dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 872. Leaf-Similar Trees
 * Consider all the leaves of a binary tree, from left to right order, the values of those leaves form a leaf value sequence.
 *
 * For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).
 *
 * Two binary trees are considered leaf-similar if their leaf value sequence is the same.
 *
 * Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.
 */
public class LeafSimilar {

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        Stack<TreeNode> firstStack = new Stack<>();
        List<Integer> firstList = new ArrayList<>();
        firstStack.add(root1);
        while(!firstStack.isEmpty()) {
            TreeNode element = firstStack.pop();

            if(element.left != null) {
                firstStack.add(element.left);
            }

            if(element.right != null) {
                firstStack.add(element.right);
            }

            if(element.left == null && element.right == null) {
                firstList.add(element.val);
            }
        }

        Stack<TreeNode> secondStack = new Stack<>();
        List<Integer> secondList = new ArrayList<>();
        secondStack.add(root2);
        while(!secondStack.isEmpty()) {
            TreeNode element = secondStack.pop();

            if(element.left != null) {
                secondStack.add(element.left);
            }

            if(element.right != null) {
                secondStack.add(element.right);
            }

            if(element.left == null && element.right == null) {
                secondList.add(element.val);
            }

        }
        return firstList.equals(secondList);
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
