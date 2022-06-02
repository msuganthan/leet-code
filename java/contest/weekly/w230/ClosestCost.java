package contest.weekly.w230;

/**
 * Closest Dessert Cost
 * You would like to make dessert and are preparing to buy the ingredients. You have n ice cream base flavors and m types of toppings to choose from. You must follow these rules when making your dessert:
 *
 * There must be exactly one ice cream base.
 * You can add one or more types of topping or have no toppings at all.
 * There are at most two of each type of topping.
 * You are given three inputs:
 *
 * baseCosts, an integer array of length n, where each baseCosts[i] represents the price of the ith ice cream base flavor.
 * toppingCosts, an integer array of length m, where each toppingCosts[i] is the price of one of the ith topping.
 * target, an integer representing your target price for dessert.
 * You want to make a dessert with a total cost as close to target as possible.
 *
 * Return the closest possible cost of the dessert to target. If there are multiple, return the lower one.
 *
 *
 *
 */
public class ClosestCost {
    public static void main(String[] args) {

    }

    int result = 0;
    int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        result = baseCosts[0];
        for (int base: baseCosts)
            closestCost(base, toppingCosts, 0, target);
        return result;
    }

    void closestCost(int current, int[] toppingCosts, int index, int target) {
        if (Math.abs(target - current) < Math.abs(target - result))
            result = current;
        if (index == toppingCosts.length) return;

        closestCost(current, toppingCosts, index + 1, target);
        closestCost(current + toppingCosts[index], toppingCosts, index + 1, target);
        closestCost(current + toppingCosts[index] * 2, toppingCosts, index + 1, target );
    }
}
