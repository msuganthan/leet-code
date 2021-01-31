package bfs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class SnakesAndLadders {
    public static void main(String[] args) {
        System.out.println(snakesAndLadders(new int[][]{
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 35, -1, -1, 13, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 15, -1, -1, -1, -1}
        }));
    }

    static int snakesAndLadders(int[][] board) {
        int N = board.length;

        Map<Integer, Integer> distance = new HashMap();
        distance.put(1, 0);

        Queue<Integer> queue = new LinkedList();
        queue.add(1);

        while(!queue.isEmpty()) {
            int startingPoint = queue.poll();
            if(startingPoint == N * N) return distance.get(startingPoint);

            for(int runningPoint = startingPoint + 1; runningPoint <= Math.min(startingPoint + 6, N * N); runningPoint++) {
                int[] nextXY = findXY(runningPoint, N);
                int row = nextXY[0];
                int col = nextXY[1];
                int runningOriginal = board[row][col] == -1 ? runningPoint : board[row][col];
                if(!distance.containsKey(runningOriginal)) {
                    distance.put(runningOriginal, distance.get(startingPoint) +  1);
                    queue.add(runningOriginal);
                }
            }
        }

        return -1;
    }

    static int[] findXY(int s, int N) {
        int quot = (s - 1) / N;
        int rem  = (s - 1) % N;
        int row = N - 1 - quot;
        int col = quot % 2 == 0 ? rem : N - 1 - rem;
        return new int[] {row, col};
    }
}
