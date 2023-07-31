package string;

/**
 * 605. Can Place Flowers
 *
 * You have a long flowerbed in which some of the plots are planted, and some are not. However, flowers cannot be planted in adjacent plots.
 *
 * Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer n, return true if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule and false otherwise.
 */
public class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        for(int i = 0; i < flowerbed.length && count < n; i++) {
            if(flowerbed[i] == 0) {

                boolean emptyLeft = i == 0 || flowerbed[i - 1] == 0;
                boolean emptyRight = i == flowerbed.length - 1 || flowerbed[i + 1] == 0;
                if(emptyLeft && emptyRight) {
                    flowerbed[i] = 1;
                    count++;
                }
            }
        }
        return count == n;
    }

    /**
     *     def canPlaceFlowers(self, flowerbed: List[int], n: int) -> bool:
     *         count = 0
     *         for i in range(len(flowerbed)):
     *             if count >= n:
     *                 break
     *
     *             if flowerbed[i] == 0:
     *                 emptyLeft = i == 0 or flowerbed[i - 1] == 0
     *                 emptyRight = i == len(flowerbed) - 1 or flowerbed[i + 1] == 0
     *
     *                 if emptyLeft and emptyRight:
     *                     flowerbed[i] = 1
     *                     count += 1
     *
     *         return count == n
     */

    /**
     * func canPlaceFlowers(flowerbed []int, n int) bool {
     *     count := 0
     *     for i := 0; i < len(flowerbed) && count < n; i++ {
     *         if flowerbed[i] == 0 {
     *             emptyLeft := i == 0 || flowerbed[i - 1] == 0
     *             emptyRight := i == len(flowerbed) - 1 || flowerbed[i + 1] == 0
     *
     *             if emptyLeft && emptyRight {
     *                 flowerbed[i] = 1
     *                 count++
     *             }
     *         }
     *     }
     *     return count == n
     * }
     */
}
