package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ReconstructQueue {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        List<int[]> answer = new LinkedList<>();
        for(int[] p: people) {
            answer.add(p[1], p);
        }
        return answer.toArray(new int[answer.size()][]);
    }

    /**
     *     def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
     *         people.sort(key=lambda p: (-p[0], p[1]))
     *         res = []
     *         for p in people:
     *             res.insert(p[1], p)
     *         return res
     */
}
