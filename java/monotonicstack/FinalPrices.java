package monotonicstack;

import java.util.Stack;

public class FinalPrices {
    public int[] finalPrices(int[] prices) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < prices.length; i++) {
            while(!stack.isEmpty() && prices[i] <= prices[stack.peek()]) {
                int index = stack.pop();
                prices[index] -= prices[i];
            }
            stack.push(i);
        }
        return prices;
    }

    /**
     *     def finalPrices(self, prices: List[int]) -> List[int]:
     *         stack = []
     *         for i in range(len(prices)):
     *             while stack and prices[i] <= prices[stack[-1]]:
     *                 index = stack.pop()
     *                 prices[index] = prices[index] - prices[i]
     *             stack.append(i)
     *
     *         return prices
     */

    /**
     * func finalPrices(prices []int) []int {
     *     stack := []int{}
     *     for i := 0; i < len(prices); i++ {
     *         for len(stack) > 0 && prices[i] <= prices[stack[len(stack) - 1]] {
     *             index := stack[len(stack) - 1]
     *             stack = stack[:len(stack) - 1]
     *             prices[index] -= prices[i]
     *         }
     *         stack = append(stack, i)
     *     }
     *     return prices
     * }
     */
}
