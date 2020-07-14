package stack;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement_2 {

    public static void main(String[] args) {
        nextGreaterElements(new int[] {1, 2, 1});
    }

    public static int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n * 2; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % n])
                result[stack.pop()] = nums[i % n];
            if (i < n) stack.push(i);
        }

        return result;
    }
}
