package datastructures;

import java.util.ArrayList;
import java.util.List;

public class LinkedListInBinaryTree {

    public static void main(String[] args) {

    }

    public boolean isSubPath(ListNode head, TreeNode root) {
        List<Integer> A = new ArrayList<>();
        List<Integer> dp = new ArrayList<>();
        A.add(head.val);
        dp.add(0);

        int i = 0;
        head = head.next;
        while (head != null) {
            while (i > 0 && head.val != A.get(i))
                i = dp.get(i - 1);
            if (head.val == A.get(i))
                ++i;
            A.add(head.val);
            dp.add(i);
            head = head.next;
        }
        return depthFirstSearch(root, 0, A, dp);
    }

    private boolean depthFirstSearch(TreeNode root, int i, List<Integer> A, List<Integer> dp) {
        if (root == null)
            return false;
        while (i > 0 && root.val != A.get(i))
            i = dp.get(i - 1);
        if (root.val == A.get(i))
            i++;
        return i == dp.size() || depthFirstSearch(root.left, i, A, dp) || depthFirstSearch(root.right, i, A, dp);
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
