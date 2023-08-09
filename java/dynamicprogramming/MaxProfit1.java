package dynamicprogramming;

/**
 * 123. Best Time to Buy and Sell Stock III
 *
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
 *
 * Note: You may not engage in multiple transactions at the same time
 * (i.e., you must sell the stock before you buy again).
 */
public class MaxProfit1 {
    public int maxProfit(int[] prices) {
        int result = 0;
        int lowest = prices[0];
        for (int price : prices) {
            if (price < lowest) {
                lowest = price;
            }
            result = Math.max(result, price - lowest);
        }
        return result;
    }

    /**
     *     def maxProfit(self, prices: List[int]) -> int:
     *         res = 0
     *
     *         lowest = prices[0]
     *         for price in prices:
     *             if price < lowest:
     *                 lowest = price
     *             res = max(res, price - lowest)
     *         return res
     */

    /**
     * func maxProfit(prices []int) int {
     *     result := 0
     *     lowest := prices[0]
     *
     *     for _, price := range prices {
     *         if price < lowest {
     *             lowest = price
     *         }
     *         if price - lowest > result {
     *             result = price - lowest
     *         }
     *     }
     *     return result
     * }
     */
}
