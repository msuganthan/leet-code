package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GetAllElements {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        Queue<Integer> q1 = new LinkedList<>(), q2 = new LinkedList<>();
        inorder(root1, q1);
        inorder(root2, q2);
        List<Integer> ans = new ArrayList<>();

        while(!q1.isEmpty() || !q2.isEmpty()) {
            if(q2.isEmpty()) {
                ans.add(q1.poll());
            } else if(q1.isEmpty()) {
                ans.add(q2.poll());
            } else {
                ans.add(q1.peek() < q2.peek() ? q1.poll() : q2.poll());
            }
        }

        return ans;
    }

    void inorder(TreeNode node, Queue<Integer> queue) {
        if(node == null) {
            return;
        }
        inorder(node.left, queue);
        queue.offer(node.val);
        inorder(node.right, queue);
    }
}
