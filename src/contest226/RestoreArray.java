package contest226;

import java.util.*;

public class RestoreArray {
    //ToDo: Sugan, Comeback to this later
    public static void main(String[] args) {
//        System.out.println(restoreArray(new int[][]{
//                {2, 1},
//                {3, 4},
//                {3, 2}
//        }));
        System.out.println(restoreArray(new int[][]{
                {4,-2},
                {1,4},
                {-3,1}
        }));
    }

    static int[] restoreArray(int[][] adjacentPairs) {
        int N = adjacentPairs.length + 1;
        int curr = 0;
        int next = 0;
        int[] answer = new int[N];
        Map<Integer, ArrayList<Integer>> pairMap = new HashMap<>();
        for (int[] pairs : adjacentPairs) {
            pairMap.computeIfAbsent(pairs[0], k -> new ArrayList<>()).add(pairs[1]);
            pairMap.computeIfAbsent(pairs[1], k -> new ArrayList<>()).add(pairs[0]);
        }
        for (int key : pairMap.keySet()) {
            if (pairMap.get(key).size() == 1) {
                curr = key;
                next = pairMap.get(key).get(0);
                break;
            }
        }
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < N; i++) {
            answer[i] = curr;
            visited.add(curr);
            curr = next;
            for (int neigh : pairMap.get(next)) {
                if (!visited.contains(neigh)) {
                    next = neigh;
                    break;
                }
            }
        }
        return answer;
    }
}
