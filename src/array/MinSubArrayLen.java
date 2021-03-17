package array;

public class MinSubArrayLen {
    public static void main(String[] args) {

    }

    public int minSubArrayLen(int target, int[] nums) {
        int answer = Integer.MAX_VALUE;
        int sum = 0;
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= target) {
                answer = Math.min(answer, i - left + 1);
                sum -= nums[left++];
            }
        }
        return answer;
    }
}
