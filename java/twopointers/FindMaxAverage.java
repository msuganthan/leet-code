package twopointers;

public class FindMaxAverage {
    public double findMaxAverage(int[] nums, int k) {
        int initialSum = 0;
        for(int i = 0; i < k; i++) {
            initialSum += nums[i];
        }
        double res = initialSum;
        for(int i = k; i < nums.length;i++) {
            initialSum += nums[i] - nums[i - k];
            res = Math.max(res, initialSum);
        }
        return res / k;
    }

    /**
     *     def findMaxAverage(self, nums: List[int], k: int) -> float:
     *         initialSum = sum(nums[:k])
     *         res = initialSum
     *         for i in range(k , len(nums)):
     *             initialSum += nums[i] - nums[i - k]
     *             res = max(res, initialSum)
     *
     *         return res / k
     */

    /**
     * func findMaxAverage(nums []int, k int) float64 {
     *     initialSum := 0
     *     for i := 0; i < k; i++ {
     *         initialSum += nums[i]
     *     }
     *
     *     res := float64(initialSum)
     *     for i := k; i < len(nums); i++ {
     *         initialSum += nums[i] - nums[i - k]
     *         if float64(initialSum) > res {
     *             res = float64(initialSum)
     *         }
     *     }
     *     return res / float64(k)
     * }
     */
}
