package priorityQueue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        for (ListNode listNode: lists) {
            if(listNode != null)
                priorityQueue.add(listNode);
        }

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (!priorityQueue.isEmpty()){
            tail.next = priorityQueue.poll();
            tail = tail.next;

            if (tail.next!=null)
                priorityQueue.add(tail.next);
        }
        return dummy.next;
    }

    static public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
