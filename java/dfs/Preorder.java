package dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Preorder {
    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if(root == null)
            return result;
        Stack<Node> stack    = new Stack();
        stack.add(root);

        while(!stack.isEmpty()) {
            Node current = stack.pop();
            result.add(current.val);
            for(int i = current.children.size() - 1; i >= 0; i--)
                stack.add(current.children.get(i));
        }
        return result;
    }

    List<Integer> answer = new ArrayList<>();
    public List<Integer> preorder1(Node root) {
        if(root == null) {
            return answer;
        }
        answer.add(root.val);
        for(Node node: root.children) {
            preorder1(node);
        }
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
