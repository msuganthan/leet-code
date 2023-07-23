package linkedlist;

public class IsPalindrome {

    public static void main(String[] args) {
        ListNode listNode1_1 = new ListNode(1);
        ListNode listNode2_2 = new ListNode(2, listNode1_1);
        ListNode listNode2 = new ListNode(2, listNode2_2);
        ListNode listNode1 = new ListNode(1, listNode2);
        System.out.println(isPalindrome(listNode1));
    }

    static boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode prev = null;
        while (slow != null) {
            ListNode temp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = temp;
        }

        while (prev != null) {
            if (head.val != prev.val) {
                return false;
            }
            head = head.next;
            prev = prev.next;
        }
        return true;
    }

    /**
     *     def isPalindrome(self, head: Optional[ListNode]) -> bool:
     *         slow = head
     *         fast = head
     *
     *         while fast and fast.next:
     *             fast = fast.next.next
     *             slow = slow.next
     *
     *         prev = None
     *         while slow:
     *             temp = slow.next
     *             slow.next = prev
     *             prev = slow
     *             slow = temp
     *
     *         while prev:
     *             if head.val != prev.val:
     *                 return False
     *             head = head.next
     *             prev = prev.next
     *
     *         return True
     */


    static class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }
}
