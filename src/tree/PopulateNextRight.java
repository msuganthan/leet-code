package tree;

public class PopulateNextRight {
    public Node connect(Node root) {
        Node temp = root;
        while(root != null && root.left != null) {
            Node curr = root;
            while(curr != null) {
                curr.left.next = curr.right;
                curr.right.next = curr.next == null ? null : curr.next.left;
                curr = curr.next;
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
