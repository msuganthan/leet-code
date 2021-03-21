package contest.weekly.w233;


import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Number of Orders in the Backlog
 *
 * You are given a 2D integer array orders, where each orders[i] = [pricei, amounti, orderTypei] denotes that amounti
 * orders have been placed of type orderTypei at the price pricei. The orderTypei is:
 *
 * 0 if it is a batch of buy orders, or
 * 1 if it is a batch of sell orders.
 *
 * Note that orders[i] represents a batch of amounti independent orders with the same price and order type. All orders
 * represented by orders[i] will be placed before all orders represented by orders[i+1] for all valid i.
 *
 * There is a backlog that consists of orders that have not been executed. The backlog is initially empty. When an order
 * is placed, the following happens:
 *
 * If the order is a buy order, you look at the sell order with the smallest price in the backlog. If that sell order's
 * price is smaller than or equal to the current buy order's price, they will match and be executed, and that sell order
 * will be removed from the backlog. Else, the buy order is added to the backlog.
 *
 * Vice versa, if the order is a sell order, you look at the buy order with the largest price in the backlog.
 * If that buy order's price is larger than or equal to the current sell order's price, they will match and be executed,
 * and that buy order will be removed from the backlog. Else, the sell order is added to the backlog.
 *
 * Return the total amount of orders in the backlog after placing all the orders from the input. Since this number can be
 * large, return it modulo 109 + 7.
 */
public class GetNumberOfBacklogOrders {
    public static void main(String[] args) {
        System.out.println(new GetNumberOfBacklogOrders().getNumberOfBacklogOrders(new int[][]{
                {7,1000000000,1},
                {15,3,0},
                {5,999999995,0},
                {5,1,1},
        }));
    }

    public int getNumberOfBacklogOrders(int[][] orders) {
        //Sell for higher price
        PriorityQueue<int[]> sell = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        //Buy for lower price
        PriorityQueue<int[]> buy = new PriorityQueue<>((o1, o2) -> o2[0] - o1[0]);

        for (int[] o: orders) {
            if (o[2] == 0) {
                while (!sell.isEmpty() && o[0] >= sell.peek()[0] && o[1] >= sell.peek()[1]) {
                    o[1] -= sell.peek()[1];
                    sell.poll();
                }
                if (!sell.isEmpty() && o[0] >= sell.peek()[0] && o[1] > 0) {
                    sell.peek()[1] -= o[1];
                    o[1] = 0;
                }
                if (o[1] > 0) {
                    buy.offer(o);
                }
            } else {
                while (!buy.isEmpty() && o[0] <= buy.peek()[0] && o[1] >= buy.peek()[1]) {
                    o[1] -= buy.peek()[1];
                    buy.poll();
                }
                if (!buy.isEmpty() && o[0] <= buy.peek()[0] && o[1] > 0) {
                    buy.peek()[1] -= o[1];
                    o[1] = 0;
                }
                if (o[1] > 0) {
                    sell.offer(o);
                }
            }
        }

        long res = 0;
        for (int[] o : sell) {
            res += o[1];
            res %= 1000000007;
        }
        for (int[] o : buy) {
            res += o[1];
            res %= 1000000007;
        }
        return (int)(res % 1000000007);
    }
}
