package slidingwindow;

/**
 * 1004. Max Consecutive Ones III
 *
 * Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.
 *
 * Todo: Zero understanding
 */
public class MaxConsective111s {

    public static void main(String[] args) {
        System.out.println(longestOnes(new int[]{0, 0, 0, 0, 0}, 3));
    }

    static int longestOnes(int[] nums, int k) {
        int i = 0;
        int j = 0;
        while (i < nums.length) {
            if (nums[i++] == 0)
                k--;
            if (k < 0) {
                if (nums[j] == 0)
                    k++;
                j++;
            }
        }
        return i - j;
    }
}
