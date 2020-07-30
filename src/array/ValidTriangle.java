package array;

public class ValidTriangle {
    public static void main(String[] args) {
        System.out.println(validTriangle(new int[]{2,2,3,4}));
    }
    static int validTriangle(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            int actualNumber = nums[i];
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int leftNumber = nums[left];
                int rightNumber = nums[right];
                if (actualNumber  <= leftNumber && leftNumber <= rightNumber) {
                    count++;
                    right--;
                } else
                    left++;
            }
        }
        return count;
    }
}
