package array;

public class SmallerNumbersThanCurrent {

  public static void main(String[] args) {
      smallerNumbersThanCurrent(new int[] {8, 1, 2, 2, 3});
  }

  static int[] smallerNumbersThanCurrent(int[] nums) {
      int[] count = new int[101];
      int[] answers = new int[nums.length];

      for (int i = 0; i < nums.length; i++)
          count[nums[i]]++;

      for (int i = 1; i < nums.length; i++)
          count[i] += count[i - 1];

      for (int i = 0; i < nums.length; i++) {
          answers[i] = (nums[i] == 0) ? 0 : count[nums[i] - 1];
      }
      return answers;
  }
}
