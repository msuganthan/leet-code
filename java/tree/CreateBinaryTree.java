package tree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 2196. Create Binary Tree From Descriptions
 * https://leetcode.com/problems/create-binary-tree-from-descriptions/
 *
 * You are given a 2D integer array descriptions where descriptions[i] = [parenti, childi, isLefti] indicates that parenti is the parent of childi in a binary tree of unique values. Furthermore,
 *
 * If isLefti == 1, then childi is the left child of parenti.
 * If isLefti == 0, then childi is the right child of parenti.
 * Construct the binary tree described by descriptions and return its root.
 *
 * The test cases will be generated such that the binary tree is valid.
 */
public class CreateBinaryTree {
 public TreeNode createBinaryTree(int[][] descriptions) {
  Map<Integer, TreeNode> map = new HashMap<>();// save the reference of Nodes
  Set<Integer> children= new HashSet<>();// add all the child nodes

  for(int d[] : descriptions) {
   children.add(d[1]);// add the child node
   if(!map.containsKey(d[0]))// not a node make one and put it
    map.put(d[0], new TreeNode(d[0]));

   if(!map.containsKey(d[1]))// not a node make one and put it
    map.put(d[1], new TreeNode(d[1]));

   if(d[2] == 1)
    map.get(d[0]).left = map.get(d[1]);// join with left
   else
    map.get(d[0]).right = map.get(d[1]);// join with right
  }

  for(int e : map.keySet())
   if(!children.contains(e))//set contains all the child, if a node isn't in set it's root
    return map.get(e);

  return null;
 }

 public class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int val) { this.val = val; }
 }
}
