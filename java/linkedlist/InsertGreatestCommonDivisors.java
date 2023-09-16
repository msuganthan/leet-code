package linkedlist;

public class InsertGreatestCommonDivisors {

    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode dummy = head;
        while(head != null && head.next != null) {
            int a = head.val;
            int b = head.next.val;
            int gcd = findGCD(a, b);
            ListNode temp = head.next;
            head.next = new ListNode(gcd, temp);
            head = temp;
        }
        return dummy;
    }

    int findGCD(int a, int b) {
        if(b == 0) {
            return a;
        }
        return findGCD(b, a % b);
    }

    /**
     *     def insertGreatestCommonDivisors(self, head: Optional[ListNode]) -> Optional[ListNode]:
     *         dummy = head;
     *         while head and head.next:
     *             gcd = self.findGCD(head.val, head.next.val)
     *             temp = head.next
     *             head.next = ListNode(gcd, temp)
     *             head = temp
     *         return dummy
     *
     *     def findGCD(self, a, b):
     *         if b == 0:
     *             return a
     *         return self.findGCD(b, a % b)
     */

    /**
     * func insertGreatestCommonDivisors(head *ListNode) *ListNode {
     *     dummy := head
     *     for head != nil && head.Next != nil {
     *         gcd := findGCD(head.Val, head.Next.Val)
     *         temp := head.Next
     *         head.Next = &ListNode{Val: gcd, Next: temp}
     *         head = temp
     *     }
     *     return dummy;
     * }
     *
     * func findGCD(a, b int) int {
     *     if b == 0 {
     *         return a
     *     }
     *     return findGCD(b, a % b)
     * }
     */

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
