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

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
