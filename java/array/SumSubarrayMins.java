package array;

import java.util.Stack;

public class SumSubarrayMins {
    public static void main(String[] args) {

    }

    static int sumSubArrayMins(int[] arr) {
        int MOD = 1_000_000_007;

        Stack<RepInteger> stack = new Stack<>();
        int answer = 0, dot = 0;
        for (int i = 0; i < arr.length; i++) {
            int count = 1;

            while (!stack.isEmpty() && stack.peek().val >= arr[i]) {
                RepInteger node = stack.pop();
                count += node.count;
                dot -= node.val * node.count;
            }

            stack.push(new RepInteger(arr[i], count));
            dot += arr[i] * count;
            answer += dot;
            answer %= MOD;
        }
        return answer;
    }
}

class RepInteger {
    int val, count;
    RepInteger(int val, int count) {
        this.val = val;
        this.count = count;
    }
}