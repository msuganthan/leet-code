package tree;

public class PopulateNextRight {

    public static void main(String[] args) {

        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);

        Node node2 = new Node(2);
        node2.left = node4;
        node2.right = node5;

        Node node3 = new Node(3);
        node3.left = node6;
        node3.right = node7;

        Node node1 = new Node(1);
        node1.left = node2;
        node1.right = node3;

        connect(node1);
    }

    public static Node connect(Node root) {

        Node temp = root;
        while (root != null) {

            if (root.right != null) {
                root.left.next = root.right;
                if (root.next != null && root.next.left != null)
                    root.right.next = root.next.left;
                else
                    root.right.next = null;

            }

            root = root.left;
        }
        return temp;
    }


    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }
    }
}
