package contest.biweekly.bw45;

public class SumOfUnique {
    public static void main(String[] args) {
        System.out.println(sumOfUnique(new int[] {1,2,3,2}));
    }

    static int sumOfUnique(int[] nums) {
        int sum = 0;
        int subtract = 0;
        int[] countMap = new int[100];

        for (int i = 0; i < nums.length; i++) {
            countMap[nums[i] - 1]++;
            if (countMap[nums[i] - 1] > 1) {
                if (countMap[nums[i] - 1] == 2)
                    sum -= nums[i] + nums[i];
                else
                    sum -= nums[i];
            }
            sum += nums[i];
        }

        return sum - subtract;
    }
}
