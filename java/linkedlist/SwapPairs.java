package linkedlist;

public class SwapPairs {
    public static void main(String[] args) {

    }

    public ListNode swapPairs(ListNode head) {
        ListNode temp = head;

        while (head != null) {
            int headValue = head.val;
            int nextValue = head.next.val;
            head.val = nextValue;
            head.next.val = headValue;

            head = head.next.next;
        }
        return temp;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
