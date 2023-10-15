package array.jump;

/**
 * 55. Jump Game
 *
 * You are given an integer array nums. You are initially positioned at the array's first index,
 * and each element in the array represents your maximum jump length at that position.
 *
 * Return true if you can reach the last index, or false otherwise.
 */
public class CanJump {
    public boolean canJump(int[] nums) {
        int max = 0;
        for (int i = 0; i <= max; i++) {
            max = Math.max(max, i + nums[i]);

            if (max >= nums.length - 1) return true;
        }
        return false;
    }
}
