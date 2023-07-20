package divideandconquer;

public class CountRangeSum {
  public static void main(String[] args) {
    System.out.println(countRangeSum(new int[] {-2, 5, -1}, -2, 2));
  }

  static int countRangeSum(int[] nums, int lower, int upper) {
      int N = nums.length;
      long[] rangeSums = new long[N + 1];
      for (int i = 0; i < N; i++)
          rangeSums[i + 1] = rangeSums[i] + nums[i];

      int answer = 0;
      for(int i = 0; i < N; i++) {
          for (int j = i + 1; j <= N; j++) {
              if (rangeSums[j] - rangeSums[i] >= lower && rangeSums[j] - rangeSums[i] <= upper)
                  answer++;
          }
      }
      return answer;
  }
}
