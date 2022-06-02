# 2. Add Two Numbers
#
# You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
#
# You may assume the two numbers do not contain any leading zero, except the number 0 itself.

class Solution:
    def add_twoNumbers(self, l1, l2):
        dummy_head = ListNode(0)
        result = dummy_head
        carry = 0

        while l1 is not None or l2 is not None or carry != 0:
            digit1 = l1.val if l1 is not None else 0
            digit2 = l2.val if l2 is not None else 0

            _sum = digit1 + digit2 + carry
            carry = _sum // 10

            result.next = ListNode(_sum % 10)
            result = result.next

            l1 = l1.next if l1 is not None else None
            l2 = l2.next if l2 is not None else None

        return dummy_head.next
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next