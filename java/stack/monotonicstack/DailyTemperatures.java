package stack.monotonicstack;

import java.util.Stack;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] answer = new int[temperatures.length];
        for (int i = 0; i < temperatures.length - 1; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()])  {
                int idx = stack.pop();
                answer[idx] = i - idx;
            }
            stack.push(i);
        }
        return answer;
    }

    /**
     *     def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
     *         stack = []
     *         answer = [0] * len(temperatures)
     *
     *         for i in range(len(temperatures)):
     *             while stack and temperatures[i] > temperatures[stack[-1]]:
     *                 idx = stack.pop()
     *                 answer[idx] = i - idx
     *             stack.append(i)
     *
     *         return answer
     */
}
