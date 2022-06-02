package contest.weekly.w277;

/**
 * 5991. Rearrange Array Elements by Sign
 *
 * You are given a 0-indexed integer array nums of even length consisting of an equal number of positive and
 * negative integers.
 *
 * You should rearrange the elements of nums such that the modified array follows the given conditions:
 *
 * Every consecutive pair of integers have opposite signs.
 * For all integers with the same sign, the order in which they were present in nums is preserved.
 * The rearranged array begins with a positive integer.
 * Return the modified array after rearranging the elements to satisfy the aforementioned conditions.
 */
public class RearrangeArray {

    public static void main(String[] args) {
        rearrangeArray(new int[] {3,1,-2,-5,2,-4});
    }
    static int[] rearrangeArray(int[] nums) {
        int[] positive = new int[nums.length / 2];
        int[] negative = new int[nums.length / 2];
        int[] answer = new int[nums.length];
        int j = 0;
        int k = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                negative[j++] = nums[i];
            } else {
                positive[k++] = nums[i];
            }
        }

        j = 0;
        for (int i = 0; i < answer.length; i+=2) {
            answer[i] = positive[j];
            answer[i + 1] = negative[j];
            j++;
        }
        return answer;
    }
}
