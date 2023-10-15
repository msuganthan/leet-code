package dynamicprogramming.maxprofit;

import java.util.HashMap;
import java.util.Map;

public class MaxProfit111 {
    public int maxProfit(int[] prices) {
        Map<String, Integer> cache = new HashMap<>();
        return dfs(prices, cache, 0, true);
    }

    int dfs(int[] prices,
            Map<String, Integer> cache,
            int index,
            boolean buying) {
        if(index >= prices.length) {
            return 0;
        }
        String key = index + "-" + buying;
        if(cache.containsKey(key)) {
            return cache.get(key);
        }
        int cooldown = dfs(prices, cache, index + 1, buying);
        int buyOSell;
        if(buying) {
            buyOSell = dfs(prices, cache, index + 1, !buying) - prices[index];
        } else {
            buyOSell = dfs(prices, cache, index + 2, !buying) + prices[index];
        }
        cache.put(key, Math.max(buyOSell, cooldown));
        return cache.get(key);
    }
}
