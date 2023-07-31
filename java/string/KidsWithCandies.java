package string;

import java.util.ArrayList;
import java.util.List;

public class KidsWithCandies {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxCandies = 0;
        for(int candy: candies) {
            maxCandies = Math.max(maxCandies, candy);
        }

        List<Boolean> result = new ArrayList<>();
        for(int candy: candies) {
            result.add(candy + extraCandies >= maxCandies);
        }
        return result;
    }

    /**
     *     def kidsWithCandies(self, candies: List[int], extraCandies: int) -> List[bool]:
     *         maxCandies = max(candies)
     *         result = []
     *         for i in range(len(candies)):
     *             result.append(candies[i] + extraCandies >= maxCandies)
     *         return result
     */

    /**
     * func kidsWithCandies(candies []int, extraCandies int) []bool {
     *     maxCandy := candies[0]
     *     for _, candy := range candies {
     *         if candy > maxCandy {
     *             maxCandy = candy
     *         }
     *     }
     *
     *     result := make([]bool, len(candies))
     *     for i, candy := range candies {
     *         result[i] = candy + extraCandies >= maxCandy
     *     }
     *     return result
     * }
     */
}
