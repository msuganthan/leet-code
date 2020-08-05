package miscellaneous.graph;

import java.util.*;

public class TopologicalSort {

    public static void main(String[] args) {
        ArrayList<Character> list = new ArrayList(Arrays.asList('A','B','C','D','E'));
        Graph charGraph = new Graph(list);
        charGraph.addEdge('A','B');
        charGraph.addEdge('A','C');
        charGraph.addEdge('A','D');
        charGraph.addEdge('B','D');
        charGraph.addEdge('C','E');
        charGraph.addEdge('D','E');
        charGraph.topologicalSort();
    }

    static class Graph {

        //Holds all nodes
        private List<Character> nodes;
        //Holds all the edges
        private ArrayList<Character> edgeList;
        //Holds the edges for each node.
        private HashMap<Character, ArrayList<Character>> edges;
        //Indicate the visited nodes.
        private List<Character> visitedNodes;

        Graph(List<Character> nodes) {
            this.nodes   = nodes;
            edges        = new HashMap<>();
            visitedNodes = new ArrayList<>();
        }

        /**
         * Method to add edge to a node.
         * @param node
         * @param child
         */
        public void addEdge(Character node, Character child) {
            if(!edges.containsKey(node))
                edgeList = new ArrayList<>();
            else
                edgeList = edges.get(node);

            edgeList.add(child);
            edges.put(node, edgeList);
        }

        public void topologicalSort() {
            Stack stack = new Stack();
            for (Character c: nodes)
                if (!visitedNodes.contains(c))
                    sort(c, stack);

                while (!stack.isEmpty())
                    System.out.print(stack.pop() + " ");
        }

        public void sort(Character ch, Stack stack) {
            visitedNodes.add(ch);

            if (edges.get(ch) != null) {
                Iterator iterator = edges.get(ch).iterator();
                Character neighborNode;

                while (iterator.hasNext()) {
                    neighborNode = (Character) iterator.next();
                    if (!visitedNodes.contains(neighborNode))
                        sort(neighborNode, stack);
                }
            }
            stack.push(new Character(ch));
        }
    }
}
