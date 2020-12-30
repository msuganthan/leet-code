package divideAndConquer;

public class MaxSubArray {
    public static void main(String[] args) {
        maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
    }

    static int maxSubArray(int[] nums) {
        int N = nums.length;
        int max = nums[0];
        for (int i = 1; i < N; i++) {
            nums[i] = Math.max(nums[i], nums[i - 1] + nums[i]);
            max = Math.max(max, nums[i]);
        }
        return max;
    }
}
