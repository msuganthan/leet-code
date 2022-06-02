package contest.weekly.w227;

public class Check {
    public static void main(String[] args) {
        System.out.println(check(new int[] {3,4,5,1,2}));
    }

    static boolean check(int[] nums) {
        int k = 0;
        int N = nums.length;

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > nums[(i + 1) % N])
                k++;

            if(k > 1)
                return false;
        }
        return true;
    }
}
