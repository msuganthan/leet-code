package array;

public class SmallerNumbersThanCurrent {

  public static void main(String[] args) {
      smallerNumbersThanCurrent(new int[] {8, 1, 2, 2, 3});
  }

  static int[] smallerNumbersThanCurrent(int[] nums) {
      int[] answer = new int[nums.length];
      int[] count = new int[101];

      for(int n: nums) {
          count[n]++;
      }

      for(int i = 1; i < 101; i++) {
          count[i] += count[i - 1];
      }

      for(int i = 0; i < nums.length; i++) {
          answer[i] = nums[i] == 0 ? 0 : count[nums[i] - 1];
      }
      return answer;
  }

    /**
     * answer = [0] * len(nums)
     * count = [0] * 101
     *
     * for n in nums:
     *  count[n] += 1
     *
     * for i in range(1, 101):
     *  count[i] += count[i - 1]
     *
     * for i in range(len(nums)):
     *  answer[i] = 0 if nums[i] == 0 else count[nums[i] - 1]
     *
     * return answer
     */
}
