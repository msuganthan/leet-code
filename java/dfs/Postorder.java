package dfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Postorder {
    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null)
            return result;
        Stack<Node> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            final Node current = stack.pop();
            result.add(current.val);
            for (Node child: current.children)
                stack.add(child);
        }
        Collections.reverse(result);
        return result;
    }

    List<Integer> answer = new ArrayList<>();
    public List<Integer> postorder1(Node root) {
        if(root == null) {
            return answer;
        }

        for(Node node: root.children) {
            postorder1(node);
        }
        answer.add(root.val);
        return answer;
    }

    static class Node {
        public final int val;
        public final List<Node> children;

        public Node(int val) {
            this.val = val;
            this.children = new ArrayList<>();
        }

        public Node(int val, List<Node> children) {
            this.val = val;
            this.children = children;
        }
    }
}
