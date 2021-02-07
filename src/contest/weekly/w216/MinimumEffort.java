package contest.weekly.w216;

import java.util.Arrays;
import java.util.Comparator;

public class MinimumEffort {
    public static void main(String[] args) {
        System.out.println(minimumEffort(new int[][]{
                {1, 3}, {2, 4}, {10, 11}, {10, 12}, {8, 9}
        }));
    }

    public static int minimumEffort(int[][] tasks) {
        int res = 0;
        Arrays.sort(tasks, Comparator.comparingInt(a -> (a[1] - a[0])));
        for (int[] task : tasks)
            res += Math.max(res + task[0], task[1]);
        return res;
    }
}
