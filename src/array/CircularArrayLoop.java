package array;

public class CircularArrayLoop {
    public static void main(String[] args) {
        System.out.println(circularArrayLoop(new int[]{2, -1, 1, 2, 2}));
    }

    static boolean circularArrayLoop(int[] nums) {
        int N = nums.length;

        if (nums.length == 1)
            return false;

        for (int i = 0; i < N; i++) {
            if (nums[i] == 0)
                continue;

            int slowIndex = i;
            int fastIndex = getIndex(i, nums);

            while (nums[fastIndex] * nums[i] > 0
                    && nums[getIndex(fastIndex, nums)] * nums[i] > 0) {
                if (slowIndex == fastIndex) {
                    if (slowIndex == getIndex(slowIndex, nums))
                        break;
                    return true;
                }
                slowIndex = getIndex(slowIndex, nums);
                fastIndex = getIndex(getIndex(fastIndex, nums), nums);
            }

            //No loop detected, set all element along the way to 0
            slowIndex = i;
            int value = nums[i];
            while (nums[slowIndex] * value > 0) {
                int next = getIndex(slowIndex, nums);
                nums[slowIndex] = 0;
                slowIndex = next;
            }
        }
        return false;
    }

    static int getIndex(int i, int[] nums) {
        int N = nums.length;
        return i + nums[i] >= 0 ? (i + nums[i]) % N : N + ((i + nums[i]) % N);
    }
}
