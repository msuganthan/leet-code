package contest.weekly.w232;

/**
 * Maximum Score of a Good Subarray
 *
 * You are given an array of integers nums (0-indexed) and an integer k.
 *
 * The score of a subarray (i, j) is defined as min(nums[i], nums[i+1], ..., nums[j]) * (j - i + 1).
 * A good subarray is a subarray where i <= k <= j.
 */
public class MaximumScore {
    public static void main(String[] args) {

    }

    public int maximumScore(int[] nums, int k) {
        int result = nums[k], minimum = nums[k], i = k, j = k, N = nums.length;
        while (i > 0 || j < N - 1) {
            if (i == 0)
                ++j;
            else if (j == N - 1)
                --i;
            else if (nums[i - 1] < nums[j + 1])
                ++j;
            else
                --i;
            minimum = Math.min(minimum, Math.min(nums[i], nums[j]));
            result = Math.max(result, minimum * j - i + 1);
        }
        return result;
    }
}
