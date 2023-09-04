package priorityqueue;

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
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) ->
            Integer.compare(
                    (b[0] * b[0] + b[1] * b[1]),
                    (a[0] * a[0] + a[1] * a[1])
            ));
        for (int[] point : points) {
            queue.add(point);
            //remove when size increase k
            if (queue.size() > k) {
                queue.remove();
            }
        }
        int[][] ans = new int[k][2];
        for (int i = 0; i < k; i++) {
            int[] cur = queue.poll();
            ans[i][0] = cur[0];
            ans[i][1] = cur[1];
        }
        return ans;
    }

    int distance(int[] points) {
        return points[0] * points[0] + points[1] * points[1];
    }
}
