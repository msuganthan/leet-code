package stack;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElements {
    public int[] nextGreaterElements(int[] nums) {
        int[] answer = new int[nums.length];
        Arrays.fill(answer, -1);
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < nums.length * 2; i++) {
            while(!stack.isEmpty() && nums[i % nums.length] > nums[stack.peek()]) {
                answer[stack.pop()] = nums[i % nums.length];
            }
            stack.push(i % nums.length);
        }
        return answer;
    }
}
