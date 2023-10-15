package array.maxprofit;

public class MaxProfit1 {

    public int maxProfit(int[] prices) {
        int profit = 0;
        int buy = Integer.MAX_VALUE;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < buy)
                buy = prices[i];
            else if (profit < prices[i] - buy)
                profit = prices[i] - buy;
        }
        return profit;
    }
}
