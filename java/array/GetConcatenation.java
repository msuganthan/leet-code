package array;

/**
 * 1929. Concatenation of Array
 * Given an integer array nums of length n, you want to create an array ans of length 2n where ans[i] == nums[i] and ans[i + n] == nums[i] for 0 <= i < n (0-indexed).
 *
 * Specifically, ans is the concatenation of two nums arrays.
 *
 * Return the array ans.
 */
public class GetConcatenation {
    public int[] getConcatenation(int[] nums) {
        int[] ans = new int[nums.length * 2];
        for(int i = 0; i < nums.length; i++) {
            ans[i] = nums[i];
            ans[i + nums.length] = nums[i];
        }
        return ans;
    }

    /**
     *     def getConcatenation(self, nums: List[int]) -> List[int]:
     *         answer = [0] * (len(nums) * 2)
     *         for i in range(len(nums)):
     *             answer[i] = nums[i]
     *             answer[i + len(nums)] = nums[i]
     *
     *         return answer
     */

    /**
     * func getConcatenation(nums []int) []int {
     *     n := len(nums)
     *     ans := make([]int, n * 2)
     *
     *     for i:= 0; i < n; i++ {
     *         ans[i] = nums[i]
     *         ans[i + n] = nums[i]
     *     }
     *     return ans
     * }
     */
}
