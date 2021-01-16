package twoPointers;

public class WaysToSplit {
    public static void main(String[] args){
        System.out.println(waysToSplit(new int[] {1, 2, 2, 2, 5, 0}));
    }

    static int waysToSplit(int[] nums) {
        int MOD = (int) (1e9 + 7);
        int[] prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];
        for(int i = 1; i < nums.length; i++)
          prefixSum[i] = prefixSum[i - 1] + nums[i];

        int answer = 0;
        for(int i = 1; i < nums.length - 1; i++) {
            int left = helper(prefixSum, prefixSum[i -1], i, true);
            int right = helper(prefixSum, prefixSum[i - 1], i, false);

            if (left == -1 || right == -1) continue;
            answer = (answer + (right - left + 1) % MOD) % MOD;
        }
        return answer;
    }

    static int helper(int[] prefixSum, int leftSum, int index, boolean searchLeft) {
        int N = prefixSum.length;
        int left = index;
        int right = N - 2;

        int answer = -1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            int midSum = prefixSum[mid] - prefixSum[index - 1];
            int rightSum = prefixSum[N - 1] - prefixSum[mid];

            if (leftSum <= midSum && midSum <= rightSum) {
                answer = mid;
                if (searchLeft) right = mid - 1;
                else left = mid + 1;
            } else if (leftSum > midSum) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return answer;
    }
}
