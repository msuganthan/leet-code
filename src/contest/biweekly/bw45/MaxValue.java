package contest.biweekly.bw45;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MaxValue {
    public static void main(String[] args) {

    }

    static int maxValue(int[][] events, int K) {
        Arrays.sort(events, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        Map<String, Integer> cache = new HashMap<>();

        return dfs(events, 0, 0, K, 0, cache);
    }

    static int dfs(int[][] events, int current, int count, int K, int end, Map<String, Integer> cache) {
        //ToDo: Suganthan complete this
        return 0;
    }
}
