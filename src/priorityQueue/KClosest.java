package priorityQueue;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 973. K Closest Points to Origin.
 *
 * Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k,
 * return the k closest points to the origin (0, 0).
 *
 * The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).
 *
 * You may return the answer in any order. The answer is guaranteed to be unique (except for the order that
 * it is in).
 */
public class KClosest {
    public int[][] kClosest(int[][] points, int k) {
        Queue<int[]> queue = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (int i = 0; i < points.length; i++) {
            int[] entry = { distance(points[i]), i };
            if (queue.size() < k) {
                queue.add(entry);
            } else if (entry[0] < queue.peek()[0]) {
                queue.poll();
                queue.add(entry);
            }
        }
        int[][] ans = new int[k][2];
        for (int i = 0; i < k; i++) {
            ans[i] = points[queue.poll()[1]];
        }
        return ans;
    }

    int distance(int[] points) {
        return points[0] * points[0] + points[1] * points[1];
    }
}
