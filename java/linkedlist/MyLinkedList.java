package linkedlist;

/**
 * 707. Design Linked List
 *
 * Design your implementation of the linked list. You can choose to use a singly or doubly linked list.
 * A node in a singly linked list should have two attributes: val and next. val is the value of the current node, and next is a pointer/reference to the next node.
 * If you want to use the doubly linked list, you will need one more attribute prev to indicate the previous node in the linked list. Assume all nodes in the linked list are 0-indexed.
 *
 * Implement the MyLinkedList class:
 *
 * MyLinkedList() Initializes the MyLinkedList object.
 * int get(int index) Get the value of the indexth node in the linked list. If the index is invalid, return -1.
 * void addAtHead(int val) Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
 * void addAtTail(int val) Append a node of value val as the last element of the linked list.
 * void addAtIndex(int index, int val) Add a node of value val before the indexth node in the linked list. If index equals the length of the linked list, the node will be appended to the end of the linked list. If index is greater than the length, the node will not be inserted.
 * void deleteAtIndex(int index) Delete the indexth node in the linked list, if the index is valid.
 */
public class MyLinkedList {
    ListNode left;
    ListNode right;

    public MyLinkedList() {
        this.left = new ListNode(0);
        this.right = new ListNode(0);
        left.next = right;
        right.prev = left;
    }

    public int get(int index) {
        ListNode cur = left.next;
        while(cur != null && index > 0) {
            cur = cur.next;
            index -= 1;
        }
        if(cur != null && cur != right && index == 0) {
            return cur.val;
        }
        return -1;
    }

    public void addAtHead(int val) {
        ListNode next = this.left.next;
        ListNode prev = left;

        ListNode node = new ListNode(val);
        prev.next = node;
        next.prev = node;

        node.next = next;
        node.prev = prev;
    }

    public void addAtTail(int val) {
        ListNode prev = this.right.prev;
        ListNode next = this.right;

        ListNode node = new ListNode(val);
        prev.next = node;
        next.prev = node;
        node.next = next;
        node.prev = prev;
    }

    public void addAtIndex(int index, int val) {
        ListNode curr = left.next;
        while (curr != null && index > 0) {
            curr = curr.next;
            index--;
        }
        if (curr != null && index == 0) {
            ListNode node = new ListNode(val);

            ListNode prev = curr.prev;
            ListNode next = curr;

            prev.next = node;
            next.prev = node;

            node.next = next;
            node.prev = prev;
        }
    }

    public void deleteAtIndex(int index) {
        ListNode cur = left.next;
        while(cur != null && index > 0) {
            cur = cur.next;
            index -= 1;
        }
        if(cur != null && cur != right && index == 0) {
            ListNode next = cur.next;
            ListNode prev = cur.prev;
            next.prev = prev;
            prev.next = next;
        }
    }
}

class ListNode {
    int val;
    ListNode prev;
    ListNode next;
    public ListNode(int val) {
        this.val = val;
    }
}