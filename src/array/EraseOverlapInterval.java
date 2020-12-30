package array;

import java.util.Arrays;

public class EraseOverlapInterval {
    public static void main(String[] args) {
        eraseOverlapIntervals(new int[][]{{1, 2}});
    }

    public static int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

        int end = intervals[0][1];
        int count = 1;
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] >= end) {
                end = intervals[i][1];
                count++;
            }
        }
        return intervals.length - count;
    }
}
