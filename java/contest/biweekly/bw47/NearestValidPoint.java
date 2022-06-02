package contest.biweekly.bw47;

/**
 * Find Nearest Point That Has the Same X or Y Coordinate
 * <p>
 * You are given two integers, x and y, which represent your current location on a Cartesian grid: (x, y).
 * You are also given an array points where each points[i] = [ai, bi] represents that a point exists at (ai, bi).
 * A point is valid if it shares the same x-coordinate or the same y-coordinate as your location.
 * <p>
 * Return the index (0-indexed) of the valid point with the smallest Manhattan distance from your current location.
 * If there are multiple, return the valid point with the smallest index. If there are no valid points, return -1.
 * <p>
 * The Manhattan distance between two points (x1, y1) and (x2, y2) is abs(x1 - x2) + abs(y1 - y2).
 * <p>
 * Input: x = 3, y = 4, points = [[1,2],[3,1],[2,4],[2,3],[4,4]]
 * Output: 2
 */
public class NearestValidPoint {
    public static void main(String[] args) {
        System.out.println(new NearestValidPoint().nearestValidPoint(3, 4, new int[][]{{3, 4}}));
    }

    public int nearestValidPoint(int x, int y, int[][] points) {
        int minManhattanDistance = Integer.MAX_VALUE;
        int ans = -1;
        for (int i = 0; i < points.length; i++) {
            //validPoints
            if (points[i][0] == x || points[i][1] == y) {
                int calculateManhattanDistance = calculateManhattanDistance(x, y, points[i]);
                if (calculateManhattanDistance < minManhattanDistance) {
                    minManhattanDistance = calculateManhattanDistance;
                    ans = i;
                }
            }
        }
        return ans;
    }


    int calculateManhattanDistance(int x, int y, int[] points) {
        return Math.abs(x - points[0]) + Math.abs(y - points[1]);
    }
}
