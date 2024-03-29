package bfs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MaxDepth {
    public int maxDepth(Node root) {
        if(root == null) return 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            depth++;
            for(int i = 0; i < size; i++) {
                Node node = queue.remove();
                queue.addAll(node.children);
            }
        }
        return depth;
    }

    static class Node {
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
