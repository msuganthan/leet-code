package array;

import java.util.HashMap;
import java.util.Map;

//ToDo: I don't understand this.
public class ContainsDuplicate111 {

    public static void main(String[] args) {
        containsDuplicate(new int[]{-1, -1}, 1, -1);
    }

    static boolean containsDuplicate(int[] nums, int k, int t) {
        if (t < 0)
            return false;
        Map<Long, Long> dict = new HashMap<>();
        long tModified = (long) t + 1;
        for (int i = 0; i < nums.length; i++) {

        }
        return false;
    }
}
