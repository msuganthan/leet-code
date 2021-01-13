package array;

public class MaxProduct {
    public static void main(String[] args) {

    }

    static int maxProduct(int[] nums) {
        int maxProduct = 0;
        int left = 0;
        int right = 0;
        int N = nums.length;

        for (int i = 0; i < N; i++) {
            left = nums[i] * (left == 0 ? 1 : left);
            right = nums[N - 1 - i] * (right == 0 ? 1 : right);
            maxProduct = Math.max(maxProduct, Math.max(left, right));
        }
        return maxProduct;
    }
}
