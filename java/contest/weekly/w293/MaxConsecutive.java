package contest.weekly.w293;

import java.util.Arrays;

/**
 * Maximum Consecutive Floors Without Special Floors
 * Alice manages a company and has rented some floors of a building as office space. Alice has decided some of these floors should be special floors, used for relaxation only.
 *
 * You are given two integers bottom and top, which denote that Alice has rented all the floors from bottom to top (inclusive). You are also given the integer array special, where special[i] denotes a special floor that Alice has designated for relaxation.
 *
 * Return the maximum number of consecutive floors without a special floor.
 */
public class MaxConsecutive {
    public static void main(String[] args) {
        maxConsecutive(2, 9, new int[] {4, 6});
    }

    static public int maxConsecutive(int bottom, int top, int[] special) {
        Arrays.sort(special);
        int max = special[0] - bottom;
        int n = special.length;
        for(int i = 1; i < n; i++){
            max = Math.max(special[i] - special[i - 1] - 1, max);
        }
        max = Math.max(max, top - special[n -1]);
        return max;
    }
}
