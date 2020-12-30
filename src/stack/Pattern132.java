package stack;

import java.util.Stack;

public class Pattern132 {

    public static void main(String[] args) {
        System.out.println(find132Pattern(new int[]{1, 2, 3, 4}));
    }

    static boolean find132Pattern(int[] nums) {

        Stack<Integer> stack = new Stack<>();
        int s3 = Integer.MAX_VALUE;

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < s3) return true;
            else while (!stack.empty() && stack.peek() < nums[i]) s3 = stack.pop();
            stack.push(nums[i]);
        }
        return false;
    }
}
