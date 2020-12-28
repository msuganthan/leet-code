package array;

/**
 * Created by msuganthan on 5/9/20.
 */
public class NumberOfGoodPairs {

    public static void main(String[] args) {
        numIdenticalPairs(new int[]{1, 2, 3, 1, 1, 3});
    }

    public static int numIdenticalPairs(int[] nums) {
        int res = 0;
        int[] count = new int[101];
        for (int n: nums)
            res += count[n]++;
        return res;
    }
}
