package divideAndConquer;

import java.util.Arrays;

public class KClosest {
    public static void main(String[] args) {

    }

    public int[][] kClosest(int[][] points, int K) {
        int N = points.length;
        int[] distance = new int[N];
        for (int i = 0; i < N; i++)
            distance[i] = calculateDistance(points[i]);
        Arrays.sort(distance);
        int kThDistance = distance[K - 1];

        int[][] answer = new int[K][2];
        int t = 0;
        for (int i = 0; i < N; i++)
            if (calculateDistance(points[i]) <= kThDistance)
                answer[t++] = points[i];

        return answer;
    }

    public int calculateDistance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}
