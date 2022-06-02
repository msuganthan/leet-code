class ListNode:
    def __init__(self, val = 0, next = None):
        self.val = val
        self.next = next

class Solution:
    def removeNthFromEnd(self, head, n):
        reference = head
        nodes = []

        while reference is not None:
            nodes.append(reference)
            reference = reference.next

        if n == len(nodes):
            return head.next

        index_to_remove = len(nodes) - n

        prev = nodes[index_to_remove - 1]
        prev.next = prev.next.next

        return head