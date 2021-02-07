package contest.weekly.w224;

import java.util.HashMap;
import java.util.Map;

public class CountGoodRectangles {
    public static void main(String[] args) {
        System.out.println(countGoodRectangles(new int[][]{{3, 12}, {3, 9}, {8, 5}}));
    }
    static int countGoodRectangles(int[][] rectangles) {
        Map<Integer, Integer> map = new HashMap<>();
        int currentMax = 0;
        for (int i = 0; i < rectangles.length; i++) {
            int num = rectangles[i][0] <rectangles[i][1] ? rectangles[i][0] : rectangles[i][1];
            map.put(num, map.getOrDefault(num, 0) + 1);
            currentMax = Math.max(currentMax, num);
        }
        return map.get(currentMax);
    }
}
