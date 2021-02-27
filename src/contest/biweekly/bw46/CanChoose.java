package contest.biweekly.bw46;

/**
 * Form Array by Concatenating Subarrays of Another Array
 *
 * You are given a 2D integer array groups of length n. You are also given an integer array nums.
 *
 * You are asked if you can choose n disjoint subarrays from the array nums such that the ith subarray is equal to groups[i]
 * (0-indexed), and if i > 0, the (i-1)th subarray appears before the ith subarray in nums
 * (i.e. the subarrays must be in the same order as groups).
 *
 * Return true if you can do this task, and false otherwise.
 *
 * Note that the subarrays are disjoint if and only if there is no index k such that nums[k] belongs to more than one subarray.
 * A subarray is a contiguous sequence of elements within an array.
 *
 */
public class CanChoose {
    public static void main(String[] args) {
        System.out.println(canChoose(new int[][]{{1,-1,-1}, {3,-2,0}}, new int[] {1,-1,0,1,-1,-1,3,-2,0}));
    }

    static boolean canChoose(int[][] groups, int[] nums) {
        int i = 0;
        for (int start = 0; i < groups.length && groups[i].length + start < nums.length; start++) {
            if (search(groups[i], nums, start))
                start += groups[i++].length - 1;
        }
        return i == groups.length;
    }

    static boolean search(int[] group, int[] nums, int start) {
        for (int i = 0; i < group.length; i++) {
            if (group[i] != nums[i + start])
                return false;
        }
        return true;
    }
}
