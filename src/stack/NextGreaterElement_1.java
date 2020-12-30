package stack;

import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElement_1 {

    public static void main(String[] args) {
        int[] ints = nextGreatestElements(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2});
        for (int i : ints)
            System.out.print(i + " ");
    }

    public static int[] nextGreatestElements(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> next_greatest = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int num : nums2) {
            while (!stack.isEmpty() && stack.peek() < num) {
                next_greatest.put(stack.pop(), num);
            }
            stack.push(num);
        }

        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = next_greatest.getOrDefault(nums1[i], -1);
        }
        return nums1;
    }

}
