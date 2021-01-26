package bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class FindLexSmallestString {
    public static void main(String[] args) {
        System.out.println(findLexSmallestString("5525", 9, 2));
    }

    /**
     * @param s initial state
     * @param a Add a to all the odd indices
     * @param b Rotate S to right positions.
     * @return
     */
    static String findLexSmallestString(String s, int a, int b) {
        int N = s.length();
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        String smallest = s;
        visited.add(s);
        queue.add(s);

        while (!queue.isEmpty()) {
            String current = queue.poll();
            if (smallest.compareTo(current) > 0)
                smallest = current;

            char[] chars = current.toCharArray();
            for (int i = 1; i < N; i += 2)
                chars[i] = (char)((chars[i] - '0' + a) % 10 + '0');

            String s1 = String.valueOf(chars);
            if (visited.add(s1))
                queue.offer(s1);

            String rotate = current.substring(N - b) + current.substring(0, N - b);
            if (visited.add(rotate))
                queue.offer(rotate);
        }
        return smallest;
    }
}
