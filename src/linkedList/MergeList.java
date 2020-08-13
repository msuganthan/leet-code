package linkedList;

public class MergeList {

    public static void main(String[] args) {
        //ListNode listNode3 = new ListNode(3);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode1 = new ListNode(-9, listNode2);

        //ListNode listNode14 = new ListNode(4);
        ListNode listNode13 = new ListNode(7);
        ListNode listNode11 = new ListNode(5, listNode13);

        mergeTwoLists(listNode1, listNode11);
    }

    static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode dummyhead = res;
        while(l1 != null || l2 != null) {

            if(l1 != null && l2 != null) {
                if(l1.val < l2.val) {
                    res.next = new ListNode(l1.val);
                    l1 = l1.next;
                } else {
                    res.next = new ListNode(l2.val);
                    l2 = l2.next;
                }
                res = res.next;
            } else {
                while (l1 != null) {
                    res.next = new ListNode(l1.val);
                    l1 = l1.next;
                    res = res.next;
                }

                while (l2 != null) {
                    res.next = new ListNode(l2.val);
                    l2 = l2.next;
                    res = res.next;
                }
            }

        }

        return dummyhead.next;
    }

    static public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
