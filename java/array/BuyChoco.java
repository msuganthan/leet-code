package array;

import java.util.Arrays;

public class BuyChoco {
    public int buyChoco(int[] prices, int money) {
        Arrays.sort(prices);
        return prices[0] + prices[1] > money ? money : money - (prices[0] + prices[1]);
    }
}
