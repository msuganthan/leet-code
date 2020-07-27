package dynamicProgramming;

public class JumpGame {

    public static void main(String[] args) {
        System.out.println(jump(new int[]{2,3,1,1,4}));
    }

    static int jump(int[] nums) {
        int jumps = 0;
        int maxReach = nums[0];
        int steps    = nums[0];

        for (int i = 1; i < nums.length - 1; i++) {
            maxReach = Math.max(maxReach, i + nums[i]);
            steps--;
            if (steps == 0) {
                jumps++;
                steps = maxReach - i;
            }
        }
        return jumps +1;
    }
}
