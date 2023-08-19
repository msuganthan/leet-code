package prefixsum;

/**
 * 1732. Find the Highest Altitude
 *
 * There is a biker going on a road trip. The road trip consists of n + 1 points at different altitudes. The biker starts his trip on point 0 with altitude equal 0.
 *
 * You are given an integer array gain of length n where gain[i] is the net gain in altitude between points i​​​​​​ and i + 1 for all (0 <= i < n). Return the highest altitude of a point.
 */
public class LargestAltitude {

    static int largestAltitude(int[] gain) {
        int startingPoint = 0;
        int result = 0;
        for(int n: gain) {
            int runningSum = startingPoint + n;
            result = Math.max(result, runningSum);
            startingPoint = runningSum;
        }
        return result;
    }

    /**
     *     def largestAltitude(self, gain: List[int]) -> int:
     *         startingPoint = 0
     *         result = 0
     *         for n in gain:
     *             runningSum = startingPoint + n
     *             result = max(result, runningSum)
     *             startingPoint = runningSum
     *         return result
     */

    /**
     * func largestAltitude(gain []int) int {
     *     startingPoint := 0
     *     result := 0
     *     for _,n := range gain{
     *         runningSum := startingPoint + n
     *         if(runningSum > result) {
     *             result = runningSum
     *         }
     *         startingPoint = runningSum
     *     }
     *     return result;
     *
     * }
     */
}
