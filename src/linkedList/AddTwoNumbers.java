package linkedList;

public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode listNode2 = new ListNode(2);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode3 = new ListNode(3);
        listNode4.next = listNode3;
        listNode2.next = listNode4;

        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(6);
        ListNode listNode44 = new ListNode(4);

        listNode6.next = listNode44;
        listNode5.next = listNode6;

        addTwoNumbers(listNode2, listNode5);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode result = new ListNode(0);
        ListNode head = result;
        while (l1 != null || l2 != null || carry != 0) {
            int sum = 0;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            sum = sum + carry;
            head.next = new ListNode(sum % 10);
            head = head.next;

            carry = sum / 10;
        }
        return result.next;

    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
