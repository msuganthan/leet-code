package array;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * 1488. Avoid Flood in The City.
 * <p>
 * Your country has an infinite number of lakes. Initially, all the lakes are empty, but when it rains over
 * the nth lake, the nth lake becomes full of water. If it rains over a lake which is full of water,
 * there will be a flood. Your goal is to avoid the flood in any lake.
 * <p>
 * Given an integer array rains where:
 * <p>
 * rains[i] > 0 means there will be rains over the rains[i] lake.
 * rains[i] == 0 means there are no rains this day and you can choose one lake this day and dry it.
 * Return an array ans where:
 * <p>
 * ans.length == rains.length
 * ans[i] == -1 if rains[i] > 0.
 * ans[i] is the lake you choose to dry in the ith day if rains[i] == 0.
 * If there are multiple valid answers return any of them. If it is impossible to avoid flood return an
 * empty array.
 * <p>
 * Notice that if you chose to dry a full lake, it becomes empty, but if you chose to dry an empty lake,
 * nothing changes.
 */
public class AvoidFlood {

    static int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] answer = new int[n];
        TreeSet<Integer> dryDays = new TreeSet<>();
        Map<Integer, Integer> lakeToFill = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (rains[i] == 0) {
                dryDays.add(i);
                answer[i] = 1;
            } else {
                int lake = rains[i];
                // if it's already full, find the earliest possible time to empty it
                if (lakeToFill.containsKey(lake)) {
                    Integer dryDay = dryDays.higher(lakeToFill.get(lake));
                    if (dryDay == null)
                        return new int[]{};
                    answer[dryDay] = lake;
                    dryDays.remove(dryDay);
                }
                lakeToFill.put(lake, i);
                answer[i] = -1;
            }
        }
        return answer;
    }
}
