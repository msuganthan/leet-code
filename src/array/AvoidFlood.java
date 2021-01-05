package array;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class AvoidFlood {

    public static void main(String[] args) {
        System.out.println(avoidFlood(new int[]{1, 2, 0, 0, 2, 1}));
    }

    static int[] avoidFlood(int[] rains) {
        int N = rains.length;
        int[] answer = new int[N];
        TreeSet<Integer> dryDays = new TreeSet<>();
        Map<Integer, Integer> lakeToFill = new HashMap<>();
        for (int i = 0; i < N; i++) {
            if (rains[i] == 0) {
                dryDays.add(i);
                answer[i] = 1;
            } else {
                int lake = rains[i];
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
