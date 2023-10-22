package array.jump;

/**
 * 45. Jump Game II
 *
 * Given an array of non-negative integers nums, you are initially positioned at the first index of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Your goal is to reach the last index in the minimum number of jumps.
 *
 * You can assume that you can always reach the last index.
 *
 * Tag: dynamicProgramming.
 */
public class Jump {
    static int jump(int[] nums) {
        int jump = 0, currEnd = 0, currFarthest = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            currFarthest = Math.max(currFarthest, i + nums[i]);
            if (i == currEnd) {
                jump++;
                currEnd = currFarthest;
            }
        }
        return jump;
    }
}
