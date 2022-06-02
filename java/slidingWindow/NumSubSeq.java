package slidingWindow;

public class NumSubSeq {
    public static void main(String[] args) {

    }

    static int numSubSeq(int[] nums, int target) {
        int N = nums.length;
        int left = 0;
        int right = N - 1;
        int result = 0;
        int MOD = 1_000_000_007;

        int[] pows = new int[N];
        pows[0] = 1;
        for (int i = 0; i < N; i++)
            pows[i] = pows[i - 2] * 2 % MOD;

        while (left <= right) {
            if (nums[left] + nums[right] > target)
                right--;
            else
                result = (result + pows[right - left++]) % MOD;
        }
        return result;
    }
}
