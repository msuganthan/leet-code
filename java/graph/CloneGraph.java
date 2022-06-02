package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class CloneGraph {

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Map<Node, Node> visited = new HashMap<>();
        Node newNode = new Node(node.val);
        visited.put(node, newNode);

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            List<Node> newNeighbors = visited.get(current).neighbors;
            for (Node neighbor : current.neighbors) {
                if (!visited.containsKey(neighbor)) {
                    queue.add(neighbor);
                    visited.put(neighbor, new Node(neighbor.val));
                }
                newNeighbors.add(visited.get(neighbor));
            }
        }
        return newNode;
    }

    public Node cloneGraph1(Node node) {
        if (node == null) {
            return null;
        }
        Map<Node, Node> visited = new HashMap<>();
        Node newNode = new Node(node.val);
        visited.put(node, newNode);

        Stack<Node> stack = new Stack<>();
        stack.add(node);

        while (!stack.isEmpty()) {
            Node current = stack.pop();

            List<Node> newNeighbors = visited.get(current).neighbors;
            for (Node neighbor : current.neighbors) {
                if (!visited.containsKey(neighbor)) {
                    stack.add(neighbor);
                    visited.put(neighbor, new Node(neighbor.val));
                }
                newNeighbors.add(visited.get(neighbor));
            }
        }
        return newNode;
    }

    /**
     * def cloneGraph(self, node: 'Node') -> 'Node':
     *         if node is None:
     *             return None
     *
     *         visited = {}
     *         new_node = Node(node.val)
     *         visited[node] = new_node
     *
     *         queue = deque()
     *         queue.append(node)
     *
     *         while queue:
     *             current = queue.popleft()
     *
     *             new_neighbors = visited[current].neighbors
     *             for neighbor in current.neighbors:
     *                 if neighbor not in visited:
     *                     queue.append(neighbor)
     *                     visited[neighbor] = Node(neighbor.val)
     *
     *                 new_neighbors.append(visited[neighbor])
     *
     *         return new_node
     */

    /**
     * func cloneGraph(node *Node) *Node {
     * 	if node == nil {
     * 		return nil
     *        }
     *
     * 	visited := make(map[*Node]*Node)
     * 	newNode := &Node{val: node.val}
     * 	visited[node] = newNode
     *
     * 	queue := []*Node{node}
     *
     * 	for len(queue) > 0 {
     * 		current := queue[0]
     * 		queue = queue[1:]
     *
     * 		newNeighbors := visited[current].neighbors
     * 		for _, neighbor := range current.neighbors {
     * 			if _, ok := visited[neighbor]; !ok {
     * 				queue = append(queue, neighbor)
     * 				visited[neighbor] = &Node{val: neighbor.val}
     *            }
     * 			newNeighbors = append(newNeighbors, visited[neighbor])
     *        }
     *    }
     *
     * 	return newNode
     * }
     */


}

class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
