package contest.weekly.w358;

import java.util.List;
import java.util.TreeSet;

public class MinAbsoluteDifference {
    public static void main(String[] args) {
        new MinAbsoluteDifference().minAbsoluteDifference(List.of(4,3,2,4), 2);
    }
    public int minAbsoluteDifference(List<Integer> nums, int x) {
        int ans = Integer.MAX_VALUE;
        TreeSet<Integer> s = new TreeSet<>();
        for(int i = x; i < nums.size(); i++) {
            s.add(nums.get(i - x));
            Integer high = s.ceiling(nums.get(i)), low = s.floor(nums.get(i));
            if(high != null) {
                ans = Math.min(ans, Math.abs(nums.get(i) - high));
            }
            if(low != null) {
                ans = Math.min(ans, Math.abs(nums.get(i) - low));
            }
        }
        return ans;
    }
}
