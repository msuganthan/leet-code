package array;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate11 {

    public static void main(String[] args) {
        containsDuplicate(new int[]{1, 2, 3, 1, 2, 3}, 2);
    }

    static boolean containsDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > k)
                set.remove(nums[i - k - 1]);
            if (!set.add(nums[i]))
                return true;
        }
        return false;
    }
}
